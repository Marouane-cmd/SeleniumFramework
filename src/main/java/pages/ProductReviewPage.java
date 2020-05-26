package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement reiewTitleText;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reiewText;

	@FindBy(id="addproductrating_4")
	WebElement rating4RdoBtn;
	
	@FindBy(name="add-review")
	WebElement submitReviewBtn;
	
	@FindBy(css="div.result")
	public WebElement reiewNotification;
	
	public void AddProductReview(String reviewTitleTxt, String reviewTxt) 
	{
		setTextElementText(reiewTitleText, reviewTitleTxt);
		setTextElementText(reiewText, reviewTxt);
		clickButton(rating4RdoBtn);
		clickButton(submitReviewBtn);
	}


	


}
