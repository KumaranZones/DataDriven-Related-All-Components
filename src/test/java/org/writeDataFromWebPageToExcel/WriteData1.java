package org.writeDataFromWebPageToExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteData1 {

	@Test
	public void main() throws IOException {
		
		Workbook wb = new XSSFWorkbook();
		Sheet createSheet = wb.createSheet("WebTableDatas");
		File file = new File("C:\\Users\\kumar\\eclipse-workspaces4\\DataDrivenRelatedAllComponents\\Excel\\WebTableData.xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		
		List<WebElement> tableHeaderRow = driver.findElements(By.xpath("/html/body/div/div[3]/div/div[2]/main/div/div/div/article/div/div/div[3]/div/div/div[2]/table/tbody/tr"));
		int tableHeaderRowSize = tableHeaderRow.size();
		for(int i=1; i<=tableHeaderRowSize; i++) {
			List<WebElement> tableHeaderColumn = driver.findElements(By.xpath("/html/body/div/div[3]/div/div[2]/main/div/div/div/article/div/div/div[3]/div/div/div[2]/table/tbody/tr["+i+"]/td"));
			int tableHeaderColumnSize = tableHeaderColumn.size();
			Row row = createSheet.createRow(i-1);
			for(int j=1; j<=tableHeaderColumnSize; j++) {
				WebElement value = driver.findElement(By.xpath("/html/body/div/div[3]/div/div[2]/main/div/div/div/article/div/div/div[3]/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]"));
				Cell cell = row.createCell(j-1);
				cell.setCellValue(value.getText());
			}
		}
		wb.write(fos);
		wb.close();
		
	}
	
}
