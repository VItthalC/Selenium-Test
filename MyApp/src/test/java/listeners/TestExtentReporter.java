package listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.BaseClass;


public class TestExtentReporter implements ITestListener{

	private static ExtentReports extent;
	private static ExtentTest test;
	String path = System.getProperty("user.dir");
	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter = new ExtentSparkReporter(path+"/reports/extent.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("Test suite execution started: "+ context.getName());
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		System.out.println("Test Started: "+ result.getName());
		//System.out.println("Test attributes from ITestResult: "+ result.getAttributeNames());
		
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: "+result.getName());
		test.fail(result.getName());
		
		TakesScreenshot ts =(TakesScreenshot) BaseClass.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path+"\\Screenshots\\"+result.getName()+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".png");
		srcFile.renameTo(des);
		test.fail("Screenshot : "+test.addScreenCaptureFromPath(des.getAbsolutePath()));
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: "+result.getName());
		test.pass("Test passed");
		 //ts =(TakesScreenshot) BaseClass.getDriver();
			//srcFile = ts.getScreenshotAs(OutputType.FILE);
			//srcFile.renameTo(new File(path+"\\Screenshots\\"+result.getName()+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".png"));
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
		System.out.println("Test suite execution finished: "+ context.getName());
	}
}
