package pages;

import org.openqa.selenium.WebDriver;

import core.ActionDriver;
import pageElements.LoginPageElements;

public class LoginPage extends ActionDriver{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage typeUserName(String user) {
		type(LoginPageElements.userNameField, user);
		return this;
	}
	
	public LoginPage typePassword(String password) {
		type(LoginPageElements.passwordField, password);
		return this;
	}
	
	public UserPage clickLoginButton() {
		click(LoginPageElements.loginButton);
		return new UserPage(driver);
	}

}
