package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase
{
     String firstProductName ="Apple MacBook Pro 13-inch";
     String secondProductName ="Asus N551JK-XO076H Laptop" ;
     //1-search for product num 1
     //2-search for product num 2
     //3-add to compare
     //4-clear list
     
     ProductDetailsPage detailsObject;
     HomePage homePge;
     ComparePage compareObject;
     SearchPage searchObject;
     
     @Test(priority = 1)
     public void UserCanCompareProducts()
     {
        searchObject= new SearchPage(driver);
        compareObject= new ComparePage(driver);
        detailsObject= new ProductDetailsPage(driver);
        
        searchObject.ProductSearchUsingAutoSuggest("Mac");
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProductName));
        detailsObject.AddProductToCompare();
        
        searchObject.ProductSearchUsingAutoSuggest("Asus");
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(secondProductName));
        detailsObject.AddProductToCompare();
        
        driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
        Assert.assertTrue(compareObject.firstProductName.isDisplayed());
        Assert.assertTrue(compareObject.secondProductName.isDisplayed());

        compareObject.CompareProducts();
     }
     @Test(priority = 2)
     public void UserClearCompareList()
     {
     	compareObject.ClearCompareList();
     }
}
