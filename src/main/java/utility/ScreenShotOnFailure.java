package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import core.BrowserFactory;

public class ScreenShotOnFailure extends TestListenerAdapter {
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	@Override
	public void onTestFailure(ITestResult tr) {
	try {
		captureScreenShot(tr);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	 
	@Override
	public void onTestSkipped(ITestResult tr) {
	    
	}
	 
	@Override
	public void onTestSuccess(ITestResult tr) {
	    
	}
	
	public void captureScreenShot(ITestResult tr) throws Exception {
		System.setProperty(ESCAPE_PROPERTY, "false");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");
		String strDate = formatter.format(date);
		File location = new File("./test-output/screenshots/"+tr.getName()+strDate+".png");
		File screenshot = ((TakesScreenshot)BrowserFactory.getInstance()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, location);
		Reporter.log("<h3>Repro Steps:</h3><br>");
		Reporter.log(tr.getMethod().getDescription() + "<br>");
		Reporter.log("<img src = "+location.getCanonicalPath()+" height = '100' width = '100'/><br>");
		Reporter.log("<a href = "+location.getCanonicalPath()+">ScreenShot</a><br>");
	}
}
