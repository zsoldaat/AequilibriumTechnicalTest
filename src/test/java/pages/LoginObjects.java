package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginObjects {
	
	WebDriver driver = null;

	By usernameField = By.id("user-name");
	By passwordField = By.id("password");
	By loginButton = By.id("login-button");
	By errorButton = By.className("error-button");
	
	public LoginObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUsernameFieldText(String text) {
		driver.findElement(usernameField).sendKeys(text);
	}
	
	public void setPasswordFieldText(String text) {
		driver.findElement(passwordField).sendKeys(text);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

}
