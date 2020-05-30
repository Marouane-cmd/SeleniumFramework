package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);
	}
  
   @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[5]/a")
   public WebElement productCell;
   
   @FindBy(css="h1")
   public WebElement wishListHeader;
   
   @FindBy(name="updatecart")
   public WebElement updateWishlistBtn;
   
   @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[1]/input")
   public WebElement removeFromCartCheck;
   
   @FindBy(css="div.no-data")
   public WebElement emptyCartLbl;
   
   public void RemoveProductFromWishList() 
   {
	   clickButton(removeFromCartCheck);
	   clickButton(updateWishlistBtn);
   }
}
