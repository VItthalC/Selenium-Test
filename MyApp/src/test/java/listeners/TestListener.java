package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.BaseClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class TestListener implements ITestListener{

	//WebDriver driver;
	TakesScreenshot ts;
	File srcFile, desFile;
	String path = System.getProperty("user.dir");
	
	
	
	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Test suite execution started: "+ context.getName());
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: "+ result.getName());
		//System.out.println("Test attributes from ITestResult: "+ result.getAttributeNames());
		
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: "+result.getName());
		 ts =(TakesScreenshot) BaseClass.getDriver();
		srcFile = ts.getScreenshotAs(OutputType.FILE);
		srcFile.renameTo(new File(path+"\\Screenshots\\"+result.getName()+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".png"));
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: "+result.getName());
		 //ts =(TakesScreenshot) BaseClass.getDriver();
			//srcFile = ts.getScreenshotAs(OutputType.FILE);
			//srcFile.renameTo(new File(path+"\\Screenshots\\"+result.getName()+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".png"));
	}
	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Test suite execution finished: "+ context.getName());
	}
	
}
