package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegesitredUserCheckoutProductTest extends TestBase
{
	/*
	 * 1- Register user
	 * 2- Search for product
	 * 3- Add to cart
	 * 4- Checkout
	 * 5-Logout
	 */
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.UserRegistration("Marwann", "Hallek", "hallek.mm035@gk2442.com", "2020@2020");
		Thread.sleep(3000);
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		System.out.println(registerObject.successMessage.getText());
	}  
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
	@Test(priority = 3)
	public void UserCanAddProductToShoppingCart() 
	{
		detailsObject= new ProductDetailsPage(driver);
		detailsObject.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		cartPage= new ShoppingCartPage(driver);

		//Assert.assertTrue(cartPage.totaLbl.getText().equals("$3,600.00"));

    }
	@Test(priority = 4)
	public void UserCanCheckoutProduct() throws InterruptedException 
	{
		
		checkoutObject= new CheckoutPage(driver);
		cartPage.OpenCheckoutPage();
		checkoutObject.RegesitredUserCheckoutProduct("Germany", "Hannover", "123520", "123564890", "garbsen", productName);
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankyLbl.isDisplayed());
		checkoutObject.printOrder();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject= new OrderDetailsPage(driver);
	//	orderObject.PrintOrderDetails();
		orderObject.DownloadPdfInvoice();
	
	}
	@Test(priority = 5)
	public void RegeistredUserCanLogOut()
	{
		registerObject.LogOut();
}
}
