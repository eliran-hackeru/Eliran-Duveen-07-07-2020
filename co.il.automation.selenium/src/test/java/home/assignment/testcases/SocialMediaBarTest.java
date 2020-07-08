package home.assignment.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import home.assignment.pages.BaseClass;
import home.assignment.pages.AutomationPage;
import home.assignment.utility.Helper;

public class SocialMediaBarTest extends BaseClass
{
	@Test
	public void SocialMediaBarApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		AutomationPage automationPage = PageFactory.initElements(driver, AutomationPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		Helper.scrollDown(driver);
		
		automationPage.socialMediaBarClick(testName);
		
		Helper.captureScreenshot(driver,testName,"03_Complete");
		
	}
}
