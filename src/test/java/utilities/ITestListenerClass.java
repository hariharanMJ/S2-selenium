package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass  implements ITestListener{



	@Override
	public void onTestFailure(ITestResult result) {
		String Listenermethod = result.getTestName();
		
		System.out.println("Test has been failed");	
		

		WebDriver driver = new ChromeDriver();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+Listenermethod+".png";
		
		try {
			FileUtils.copyFile(srcFile, new File(destFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
