package home.assignment.testcases;

import org.testng.annotations.Test;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.support.PageFactory;
import home.assignment.pages.BaseClass;
import home.assignment.pages.AutomationPage;
import home.assignment.utility.Helper;
import home.assignment.utility.Emails;

public class SendEmailTest extends BaseClass
{
	@Test
	public void SendEmailpApp() throws InterruptedException, EmailException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		AutomationPage automationPage = PageFactory.initElements(driver, AutomationPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		Helper.scrollDown(driver);
		
		Emails.sendEmail(excel.getStringData("Credentials", 0, 0), excel.getStringData("Credentials", 0, 1), automationPage.getAddress());
		
		Helper.captureScreenshot(driver,testName,"02_Complete");
	}

}
