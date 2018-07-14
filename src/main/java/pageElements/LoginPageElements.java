package pageElements;

import org.openqa.selenium.By;

public interface LoginPageElements {
	By userNameField = By.xpath("//input[@id='username_login']");
	By passwordField = By.id("password_login");
	By loginButton = By.id("loginBtn_1");
}
