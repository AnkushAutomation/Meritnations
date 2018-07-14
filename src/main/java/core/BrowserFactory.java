package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BrowserFactory {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String baseURL = "https://www.meritnation.com/";
	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver.set(new InternetExplorerDriver());
		}
		else{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver.set(new ChromeDriver());
		}
		getInstance().manage().window().maximize();
		getInstance().get(baseURL);
	}
	
	public static WebDriver getInstance() {
		return driver.get();
	}
	
	@AfterClass
	public void closeBrowser() {
		getInstance().close();
	}

}
