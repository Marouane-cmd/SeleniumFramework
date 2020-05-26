package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	
	HomePage home;
	ContactUsPage contactPage;
	
	String email = "home@test.com";
	String fullname ="Test User";
	String enquiry="hallo";
	@Test
	public void UserCanUseContactUs() 
	{
		home = new HomePage(driver);
		home.openContactUsPage();
		contactPage= new ContactUsPage(driver);
		contactPage.contactUs(fullname, email, enquiry);
		Assert.assertTrue(contactPage.successMsg.getText().contains("Your enquiry"));
	}

}
