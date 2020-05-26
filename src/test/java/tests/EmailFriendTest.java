package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {


	// 1-User registration
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.UserRegistration("Marwann", "Hallek", "hallek.mm0666@g222.com", "2020@2020");
		Thread.sleep(3000);
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		System.out.println(registerObject.successMessage.getText());
	} 
	//2- Search for product
	@Test(priority = 2)
	public void UserCanSearchUsingAutoSugggest() 
	{
		try {
			searchObject= new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject= new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		} catch (Exception e)
		{
			System.out.println("Error occured  "+ e.getMessage());
		}
	}
	
	//3- Send email to a friend
	@Test(priority = 3)
	public void RegistredUserCanSendProductToFriend() 
	{
		detailsObject.openSendEmail();
		emailObject= new EmailPage(driver);
		emailObject.SendEmailToFriend("aaa@test.com", "Hello Friend");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent"));
	} 
	
	//4- UserlogOut
	@Test(priority = 4)
	public void UserCanLogOut() 
	{
		registerObject.LogOut();
	}
}
