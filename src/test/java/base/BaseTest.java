package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
public static WebDriver driver;
	
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harih\\Downloads\\chromedriver-win64.zip\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
	}
	
	public void closebrowser()
	{
		driver.close();
	}	

}
