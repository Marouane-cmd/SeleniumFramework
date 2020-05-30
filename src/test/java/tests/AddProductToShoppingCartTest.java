package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase
{
	SearchPage searchPage;
	ProductDetailsPage 	productDetails;
	ShoppingCartPage cartPage;
	String productName ="Apple MacBook Pro 13-inch";
	
	
	@Test(priority = 1)
	public void UserCanSearchForProductUsingAutoSuggest() 
	{
		searchPage= new SearchPage(driver);
		searchPage.ProductSearchUsingAutoSuggest(productName);
		productDetails= new ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}
	
	@Test(priority = 2)
	public void UserCanAddProductToShoppingCart() 
	{
		productDetails= new ProductDetailsPage(driver);
		productDetails.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		cartPage= new ShoppingCartPage(driver);

		Assert.assertTrue(cartPage.totaLbl.getText().equals("$3,600.00"));

	}
	/*@Test(priority = 3)
	public void UserCanUpdateProductQuantityInCart() throws InterruptedException
	{   		
		
		cartPage= new ShoppingCartPage(driver);
		cartPage.UpdateProductQuantityInCart("4");
		Thread.sleep(3000);
		Assert.assertTrue(cartPage.totaLbl.getText().contains("7,2"));

	}*/
	@Test(priority = 3)
	public void UserCanRemoveProductFromShoppingCart() 
	{
		cartPage= new ShoppingCartPage(driver);
		cartPage.RemoveProductFromCart();
	}
	

}
