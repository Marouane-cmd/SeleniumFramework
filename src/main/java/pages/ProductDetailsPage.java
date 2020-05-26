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
	
	public void openSendEmail() 
	{
		clickButton(friendEmailBtn);
	}
	public void openAddReviewPage() 
	{
		clickButton(reviewLink);
	}
	
}
