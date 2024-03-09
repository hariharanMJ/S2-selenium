package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class LoginPage extends BaseTest{
	
	@FindBy(xpath="//div[@class='vector-menu mw-portlet']/descendant::span[2]")
	WebElement loginPage;
	
	@FindBy(id="wpName1")
	WebElement Username;
	
	@FindBy(id="wpPassword1")
	WebElement Password;
	
	@FindBy(id="wpLoginAttempt")
	WebElement LoginBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void user_login() {
		loginPage.click();
		Username.sendKeys("admin");
		Password.sendKeys("admin123");
		LoginBtn.click();
	}

}
