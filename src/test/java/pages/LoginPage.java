package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private static WebElement usernameField = null;
	private static WebElement passwordField = null;
	private static WebElement loginButton = null;
	private static List<WebElement> errorButtons = null;
	private static List<WebElement> h3headers = null;
	private static String h3HeaderText = null;
	
	public static WebElement usernameField(WebDriver driver) {
		usernameField = driver.findElement(By.id("user-name"));
		return usernameField;
	}
	
	public static WebElement passwordField(WebDriver driver) {
		passwordField = driver.findElement(By.id("user-name"));
		return passwordField;
	}
	
	public static WebElement loginButton(WebDriver driver) {
		loginButton = driver.findElement(By.id("login-button"));
		return loginButton;
	}
	
	public static List<WebElement> errorButtons(WebDriver driver) {
		errorButtons = driver.findElements(By.className("error-button"));
		return errorButtons;
	}
	
	public static List<WebElement> h3headers (WebDriver driver) {
		h3headers = driver.findElements(By.tagName("h3"));
		return h3headers;
	}
	
	public static String h3HeaderText (WebDriver driver) {
		h3HeaderText = driver.findElement(By.tagName("h3")).getText();
		return h3HeaderText;
		
	}

}
