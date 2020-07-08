package home.assignment.pages;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import home.assignment.utility.Helper;

public class AutomationPage {
	
	WebDriver driver;
	
	public AutomationPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(css="input[placeholder='שם...']") WebElement userName;
	
	@FindBy(css="input[placeholder='דואר אלקטרוני...']") WebElement userEmail;
	
	@FindBy(css="input[placeholder='טלפון...']") WebElement userPhone;
	
	@FindBy(xpath="//span[.='שליחה']") WebElement submitButton;
	
	@FindBy(id="name") WebElement moreName;
	
	@FindBy(id="company") WebElement moreCompany;
	
	@FindBy(id="email") WebElement moreEmail;
	
	@FindBy(id="telephone") WebElement morePhone;
	
	@FindBy(xpath="//span[.='דברו איתנו']") WebElement talkToUs;
	
	@FindBy(css="h1[class='thankYou__title-bl9e43-5 fSmmAW']") WebElement thankYou;
	
	@FindBy(linkText="mati@herolo.co.il") WebElement mailTo;
	
	@FindBy(css="a[class='socialMediaBar__ImgSocial-sc-1f95hbj-2 jCiLrI']") WebElement linkedin;
	
	@FindBy(css="a[class='socialMediaBar__ImgSocial-sc-1f95hbj-2 iZfnyd']") WebElement whatsapp;
	
	@FindBy(css="a[class='socialMediaBar__ImgSocial-sc-1f95hbj-2 gdrWsw']") WebElement facebook;
	
	@FindBy(css="a[class='socialMediaBar__ImgSocial-sc-1f95hbj-2 gAmXai']") WebElement homepage;
	
	public void userDetails (String nameApp, String emailApp, String phoneApp)
	{
		userName.sendKeys(nameApp);
		userEmail.sendKeys(emailApp);
		userPhone.sendKeys(phoneApp);
	}
	
	public void submitDetails()
	{
		submitButton.click();
	}
	
	public void moreUserDetails (String nameApp, String compApp, String emailApp, String phoneApp)
	{
		moreName.sendKeys(nameApp);
		moreCompany.sendKeys(compApp);
		moreEmail.sendKeys(emailApp);
		morePhone.sendKeys(phoneApp);
	}
	
	public void submitMoreDetails()
	{
		talkToUs.click();
	}
	
	public void assertThankYou()
	{
		Assert.assertEquals(thankYou.getText(),"תודה!","The test did not proceed to the next page");
	}
	
	public String getAddress()
	{
		return mailTo.getText();
	}
	
	public void socialMediaBarClick(String testName) throws InterruptedException
	{
		ArrayList<WebElement> socialMedias = new ArrayList<WebElement>();
		socialMedias.add(linkedin);
		socialMedias.add(whatsapp);
		socialMedias.add(facebook);
		socialMedias.add(homepage);
				
		for (int i=0 ; i<socialMedias.size() ; i++)
		{
			socialMedias.get(i).click();
			String number = String.valueOf(i+1);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
		    
		    Helper.captureScreenshot(driver,testName+"_"+number+"_","02_SocialMedias");
		    
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}
	}
}
