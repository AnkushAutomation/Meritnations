package pages;

import org.openqa.selenium.WebDriver;

import core.ActionDriver;
import pageElements.HomePageElements;

public class HomePage extends ActionDriver {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage clickLoginLink() {
		click(HomePageElements.loginLink);
		return new LoginPage(driver);
	}

}
