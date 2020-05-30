package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css="span.price-value-4")
	public WebElement productPriceLbl;
	
	@FindBy(linkText = "Add your review")
	public WebElement reviewLink;
	
	@FindBy(css="input.button-2.email-a-friend-button")
	public WebElement friendEmailBtn;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlistBtn;
	
	@FindBy(css ="input.button-2.add-to-compare-list-button")
	public WebElement addToCompareBtn;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn;
	
	public void openSendEmail() 
	{
		clickButton(friendEmailBtn);
	}
	public void openAddReviewPage() 
	{
		clickButton(reviewLink);
	}
	public void addProductToWishlist() 
	{
		clickButton(addToWishlistBtn);
	}
	public void AddProductToCompare()
	{
		clickButton(addToCompareBtn);
	}
	public void AddToCart()
	{
		clickButton(addToCartBtn);
	}
	
}
