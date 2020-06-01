package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase
{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "removefromcart")
	WebElement removeCheck;
	
	@FindBy(name = "updatecart")
	WebElement updateCartBtn;
	
	@FindBy(id = "itemquantity11215")
	public WebElement quantityText;
	
	@FindBy(css = "td.subtotal")
	public WebElement totaLbl;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy (id="termsofservice")
	WebElement agreeCheckBox;
	
	public void RemoveProductFromCart() 
	{
		clickButton(removeCheck);
		clickButton(updateCartBtn);
	}
    
	public void UpdateProductQuantityInCart(String quantity)
	{   // clear quantity textbox
		clearText(quantityText);
		setTextElementText(quantityText, quantity);
		clickButton(updateCartBtn);
	}
	
    public void OpenCheckoutPage() 
    {
    	clickButton(agreeCheckBox);
    	clickButton(checkoutBtn);
    }


}
