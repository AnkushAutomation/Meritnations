package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BrowserFactory;
import dataProvider.DataProviderForLogin;
import dataProvider.DataProviderForLogin2;
import pages.HomePage;
import pages.LoginPage;
import pages.UserPage;

public class LoginPageTest extends BrowserFactory{
	private static final String loginRepro = "1. Click on login Link<br>2.Type UserName and Password.<br>3.Click on login button<br>";
	@Test(dataProviderClass = DataProviderForLogin.class, dataProvider = "Credentials", description = loginRepro)
	public void verifyLogin(String displayName, String userName, String pass) {
		HomePage homePage = new HomePage(getInstance());
		LoginPage login = homePage.clickLoginLink();
		UserPage userPage = login.typeUserName(userName).
							typePassword(pass).clickLoginButton();
		Assert.assertTrue(userPage.verifyUser(displayName));
		userPage.logout();
	}

}
