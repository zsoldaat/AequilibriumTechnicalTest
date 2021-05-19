package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utility.BrowsersAndUsers;


public class BaseTestClass {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public static BrowsersAndUsers browsersAndUsers;
	
	@BeforeSuite
	public void setup() {
		
		browsersAndUsers = new BrowsersAndUsers();

		htmlReporter = new ExtentSparkReporter("extentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
//	@AfterMethod
//	public void getResult(ITestResult result) {
//		if (result.getStatus()==ITestResult.FAILURE) {
//			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
//			test.fail(result.getThrowable());
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			test.pass(MarkupHelper.createLabel("Pass", ExtentColor.GREEN));
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			test.skip(MarkupHelper.createLabel("Skipped", ExtentColor.YELLOW));
//			test.skip(result.getThrowable());
//		}
//	}
	

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	

}
