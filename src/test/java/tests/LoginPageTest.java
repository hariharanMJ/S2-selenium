package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pages.LoginPage;

import base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	LoginPage lp;
	
	@Test(priority='1')
	public void start_browser()
	{
		openBrowser();
		lp = new LoginPage(driver);
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
