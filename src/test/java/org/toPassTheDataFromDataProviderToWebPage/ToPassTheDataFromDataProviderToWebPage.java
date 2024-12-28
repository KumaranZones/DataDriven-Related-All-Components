package org.toPassTheDataFromDataProviderToWebPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToPassTheDataFromDataProviderToWebPage {

	@Test(dataProvider = "QAData")
	public void DataProviderTest(String name1,String eMail1,String phoneNumber1,String address1) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement name = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
		name.sendKeys(name1);
		WebElement eMail = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		eMail.sendKeys(eMail1);
		WebElement phoneNumber = driver.findElement(By.xpath("//input[starts-with(@id,'phone')]"));
		phoneNumber.sendKeys(phoneNumber1);
		WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'textarea')]"));
		address.sendKeys(address1);
	}
	@DataProvider(name="QAData")
	public Object[][] datas() {
		Object[][] data = {{"Kumaran","kumar@gmail.com","9876543212","Chennai"},
				{"Aaaaaa","aaaa@gmail.com","9864536453","Salem"},
				{"Bbbbbb","bbbb@gmail.com","8765453627","Madurai"},
				{"Ccccc","ccccc@gmail.com","6574637485","Chennai"},
				{"Kumaran","kumar@gmail.com","9876543212","Chennai"},
				{"Dddddd","ddddd@gmail.com","9876564764","Salem"}};
		return data;
	}

}
