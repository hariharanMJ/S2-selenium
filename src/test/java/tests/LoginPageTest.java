package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pages.LoginPage;


public class LoginPageTest {
	public  WebDriver driver;	
	LoginPage lp;
	
	@Test(priority='1')
	public void start_browser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harih\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
	}
	@Test(priority='2')
	public void test_user_login() throws InterruptedException
	{
		Thread.sleep(1000);
		lp.user_login();
	}

	@AfterClass
	public void close_browser() throws InterruptedException {
		Thread.sleep(1000);
		
		driver.close();
	}
}
