package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase
{
	/*
	 * 1- User Registration
	 * 2- Search for a product
	 * 3- Add product review
	 * 4- LogOut
	 */

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;

	// 1-User registration

	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.UserRegistration("Marwann", "Hallek", "hallek.mm0656@g222.com", "2020@2020");
		Thread.sleep(3000);
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		System.out.println(registerObject.successMessage.getText());
	} 
	//2- Search for a product
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

	// 3- Add product review
	@Test(priority = 3)
	public void RegistredUserCanAddReview() 
	{
		detailsObject.openAddReviewPage();
		reviewObject= new ProductReviewPage(driver);
		reviewObject.AddProductReview("new review", "The product is very good");
		Assert.assertTrue(reviewObject.reiewNotification.getText().contains("Product review is successfully added"));
	}

	//4- UserlogOut
	@Test(priority = 4)
	public void UserCanLogOut() 
	{
		registerObject.LogOut();
	}
}
