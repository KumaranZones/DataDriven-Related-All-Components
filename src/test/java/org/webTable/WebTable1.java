package org.webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args) {
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
			for(int j=1; j<=tableHeaderColumnSize; j++) {
				String value = driver.findElement(By.xpath("/html/body/div/div[3]/div/div[2]/main/div/div/div/article/div/div/div[3]/div/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(value+"|");
			}
			System.out.println();

		}
		
	}
	
}
