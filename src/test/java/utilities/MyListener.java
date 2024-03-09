package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



@Listeners(ITestListenerClass.class)

public class MyListener implements ITestListener{
	
	public static WebDriver driver;
	public static ExtentReports ex;
	public static ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test has started");
		
	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test has Finished");
	}

	
	@BeforeTest
	public void OpenBrowser()
	{
		driver = new ChromeDriver();
	}

	
	@Test(priority='1',testName="Wiki")
	public void ListenersMethod()
	{
	
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		System.out.println(driver.getTitle());
		Assert.assertTrue(false);
	}
	
	
	@Test
	public void extentReportDemo() {
		
		// Initialize the extent report
		ExtentReports ex = new ExtentReports();
		
		//ExtentSparkReporter is a open source reporter which creates the report
		
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("C:\\Users\\harih\\eclipse-workspace\\SeleniumS2\\extentreports\\report.html");
		
		ex.attachReporter(sparkreporter); // report gets created
		ex.setSystemInfo("OS", System.getProperty("os.name"));
		ex.setSystemInfo("JAVA", System.getProperty("java.version"));
		ex.setSystemInfo("Host Name", System.getProperty("HostName.name"));
		ex.setSystemInfo("Browser", "Chrome");
		ExtentTest test1 = ex.createTest("onStart");
	    test1.pass("Test has started");
	   
	    ExtentTest test2 = ex.createTest("Test2");
	   test2.log(Status.FAIL, "This test has failed");
		
		
		ex.flush(); // generates the report
		
		
	}
	
	@AfterTest
	public void Closebrowser()
	{
		driver.close();
	}

}
