package home.assignment.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import home.assignment.pages.BaseClass;
import home.assignment.pages.AutomationPage;
import home.assignment.utility.Helper;

public class ContactUsFooterTest extends BaseClass
{
	@Test
	public void hearMoreApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		AutomationPage automationPage = PageFactory.initElements(driver, AutomationPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		Helper.scrollDown(driver);
		
		automationPage.moreUserDetails(excel.getStringData("Details", 0, 0), excel.getStringData("Details", 0, 3),excel.getStringData("Details", 0, 1),excel.getStringData("Details", 0, 2));
		
		Helper.captureScreenshot(driver,testName,"02_InsertUserDetails");
		
		automationPage.submitMoreDetails();
		
		Helper.waitForElementByID(driver, "juggling");
		
		automationPage.assertThankYou();
		
		Helper.captureScreenshot(driver,testName,"03_Complete");
		
		
	}

}
