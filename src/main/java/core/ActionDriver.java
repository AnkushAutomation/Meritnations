package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDriver {
	protected WebDriver driver;
	protected WebDriverWait wait;
	private long shortTime = 30;
	public ActionDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	protected void waitForElement(By locator) {
		wait = new WebDriverWait(driver, shortTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected void type(By locator, String text) {
		waitForElement(locator);
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}
	
	protected void click(By locator) {
		waitForElement(locator);
		WebElement element = driver.findElement(locator);
		element.click();
	}
	

	protected void selectDropDownValue(By dd, String text) {
		waitForElement(dd);
		WebElement dropDown = driver.findElement(dd);
		Select drop = new Select(dropDown);
		drop.selectByVisibleText(text);
	}
		
	protected boolean textIsEqualTo(By locator, String text) {
		waitForElement(locator);
		WebElement element = driver.findElement(locator);
		return element.getText().equals(text);

	}

}
