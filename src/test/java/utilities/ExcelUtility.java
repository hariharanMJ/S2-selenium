package utilities;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelUtility {
public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harih\\Downloads\\chromedriver-win64.zip\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
	}
	
	@Test(dataProvider = "TestData")
	public void Inputdata(String Username, String Password) throws InterruptedException {
		driver.findElement(By.id("wpName1")).clear();
		driver.findElement(By.id("wpName1")).sendKeys(Username);
		
		driver.findElement(By.id("wpPassword1")).clear();
		driver.findElement(By.id("wpPassword1")).sendKeys(Password);
		
		driver.findElement(By.id("wpLoginAttempt")).click();
		
		Thread.sleep(1500);
	}
		
		@DataProvider(name="TestData")
		public  Object[][] datasupply()throws FileNotFoundException
		{
			// get the data from excel sheet
			
			Object[][] inputdata = Xls_DataProvider.getTestData("TestData");
			
			return inputdata;
			
		}
		
		@AfterClass
		public void CloseBrowser()
		{
			driver.close();
		}

		


}
