package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase 
{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage  wishlistObject;
	
	@Test (priority = 1,alwaysRun = true)
	public void UserCanSearchForProduct() 
	{
		searchObject= new SearchPage(driver);
		detailsObject= new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	@Test(priority = 2)
	public void UserCanAddProductToWishlist() 
	{
     detailsObject= new ProductDetailsPage(driver)	;
     detailsObject.addProductToWishlist();
     driver.navigate().to("https://demo.nopcommerce.com" + "/wishlist");
     wishlistObject= new WishlistPage(driver);
     Assert.assertTrue(wishlistObject.wishListHeader.isDisplayed());
     Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() 
	{
	     wishlistObject= new WishlistPage(driver);
         wishlistObject.RemoveProductFromWishList();
         Assert.assertTrue(wishlistObject.emptyCartLbl.getText().contains("The wishlist is empty!"));
	}

}
