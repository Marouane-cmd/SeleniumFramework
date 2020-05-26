package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangCurrencyTest extends TestBase {
	
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	
	@Test
	public void UserCanChangeCurrency()
	{
		homeObject= new HomePage(driver);
		homeObject.CurrencyChange();
	}
	@Test
	public void UserCanSearchUsingAutoSugggest() 
	{
		try {
			searchObject= new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject= new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
			Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("$"));
			System.out.println(detailsObject.productPriceLbl.getText());
		} catch (Exception e)
		{
			System.out.println("Error occured  "+ e.getMessage());
		}

}
}