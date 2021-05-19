package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.LoginObjects;
import pages.LoginPage;
import utility.Utility;


public class LoginChrome {
	
	private static String[] users = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"};
	private static String password = "secret_sauce";
	
	private ExtentSparkReporter htmlReporter;
	private ExtentReports extent;
	private ExtentTest test;
	
	WebDriver driver;
	
	private LoginObjects loginObjects;
	
	private String testURL = "https://www.saucedemo.com/";
	private String successfulLoginURL = "https://www.saucedemo.com/inventory.html";
	
	@BeforeSuite
	public void setup() {

		htmlReporter = new ExtentSparkReporter("extentReports-Chrome.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}

	@BeforeTest
	public void setupTest() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers/chromedriver");
		driver = new ChromeDriver();
		
		loginObjects = new LoginObjects(driver);

	}
	
	
	@Test
	public void loginSuccess() {
		
		test = extent.createTest("Login success", "Testing the successful login path");
		
		test.log(Status.INFO, "Starting Test");
		
		driver.get(testURL);
		test.log(Status.PASS, "Page Opened Successfully");
		
		loginObjects.setUsernameFieldText(users[0]);
		test.log(Status.PASS, "Entered username");
		
		loginObjects.setPasswordFieldText(password);
		test.log(Status.PASS, "Entered password");
		
		loginObjects.clickLoginButton();
		test.log(Status.PASS, "Clicked Login");
		
		if (successfulLoginURL.equals(driver.getCurrentUrl())) {
			test.log(Status.PASS, "Access successfully granted");
		} else {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
		}
		
	}
	
	@Test
	public void noCredentials() {
		
		test = extent.createTest("Login denied - no credentials", "Testing the login with no credentials");
		
		test.log(Status.INFO, "Starting Test");
		
		driver.get(testURL);
		test.log(Status.PASS, "Page Opened Successfully");
		
		loginObjects.clickLoginButton();
		test.log(Status.PASS, "Login Button Clicked");
		
		if (testURL.equals(driver.getCurrentUrl())) {
			test.log(Status.PASS, "Login denied - User stays on login page");
		} else {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
		}
		
		if (LoginPage.h3HeaderText(driver).equals("Epic sadface: Username is required")) {
			test.log(Status.PASS, "Login denied - Error message is present");
		} else {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
		}
		
	}
	
	@Test
	public void wrongCredentials() {
		test = extent.createTest("Login denied - wrong credentials", "Testing login with wrong username, wrong password");
		
		test.log(Status.INFO, "Starting Test");
		
		driver.get(testURL);
		test.log(Status.PASS, "Page Opened Successfully");
		
		loginObjects.setUsernameFieldText("Wrong user");
		test.log(Status.PASS, "Entered username");
		
		loginObjects.setPasswordFieldText("wrong password");
		test.log(Status.PASS, "Entered password");
		
		loginObjects.clickLoginButton();
		test.log(Status.PASS, "Clicked Login");
		
		if (testURL.equals(driver.getCurrentUrl())) {
			test.log(Status.PASS, "Login denied - User stays on login page");
		} else {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
		}
		
		if (LoginPage.h3HeaderText(driver).equals("Epic sadface: Username and password do not match any user in this service")) {
			test.log(Status.PASS, "Login denied - Error message is present");
		} else {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
		}
	}
	
	@Test
	public void lockedOutUser() {
		test = extent.createTest("Login denied - Locked out", "Attempting to login as a locked out users");
		
		test.log(Status.INFO, "Starting Test");
		
		driver.get(testURL);
		test.log(Status.PASS, "Page Opened Successfully");
		
		loginObjects.setUsernameFieldText(users[1]);
		test.log(Status.PASS, "Entered username");
		
		loginObjects.setPasswordFieldText(password);
		test.log(Status.PASS, "Entered password");
		
		loginObjects.clickLoginButton();
		test.log(Status.PASS, "Clicked Login");
		
		if (testURL.equals(driver.getCurrentUrl())) {
			test.log(Status.PASS, "Login denied - User stays on login page");
		} else {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
		}
		
		if (LoginPage.h3HeaderText(driver).equals("Epic sadface: Sorry, this user has been locked out.")) {
			test.log(Status.PASS, "Login denied - Error message is present");
		} else {
			System.out.println(LoginPage.h3HeaderText(driver));
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
		}
	}
	
	@Test
	public void tabbedNavigation() {
		test = extent.createTest("Login success - Tabbed Navigation", "Tests the successful login path using the keyboard");
		
		test.log(Status.INFO, "Starting Test");
		
		driver.get(testURL);
		test.log(Status.PASS, "Page Opened Successfully");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(users[0]).build().perform();
		
		test.log(Status.PASS, "Username entered");
		
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(password).build().perform();
		
		test.log(Status.PASS, "Password entered");
		
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		
		test.log(Status.PASS, "Login Clicked");
		
		if (successfulLoginURL.equals(driver.getCurrentUrl())) {
			test.log(Status.PASS, "Access successfully granted");
		} else {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
		}
		
	}
	
	@Test
	public void loadTimeTest() {
		
		test = extent.createTest("Load time test", "Testing login times for all users");
		
		test.log(Status.INFO, "Starting Test");
		
		for (String user: users) {
			
			driver.get(testURL);
			
			loginObjects.setUsernameFieldText(user);
			loginObjects.setPasswordFieldText(password);
			
			long start = System.currentTimeMillis();
			
			loginObjects.clickLoginButton();
			
			long finish = System.currentTimeMillis();
			
			long time = finish-start;
			
			if (time > 2000) {
				test.fail("Time for "+user+" (miliseconds): "+time, MediaEntityBuilder.createScreenCaptureFromPath(Utility.addScreenshot(driver)).build());
			} else {
				test.pass("Time for "+user+" (miliseconds): "+time);
			}
		}
	}
	
	@AfterTest
	public void testTearDown() {
//		driver.close();
		driver.quit();
		
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	

	

}
