package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase 
{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstNameTxt;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastNameTxt;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement adressTxt;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postCodeTxt;
	
	@FindBy(xpath ="//*[@id=\"billing-buttons-container\"]/input")
	WebElement continueBtn;
	
	@FindBy(id="shippingoption_1")
	WebElement shippingMethodRdo;
	
	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement continueShippingBtn;
	
	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement continuePaymentBtn;
	
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement continueInfoBtn;
	
	@FindBy(linkText ="Apple MacBook Pro 13-inch")
	public WebElement productName;
	
	@FindBy(xpath="//*[@id=\"confirm-order-buttons-container\"]/input")
	public WebElement confirmBtn;
	
	@FindBy(css="h1")
	public WebElement ThankyLbl;
	
	@FindBy(css="div.title")
	public WebElement successMsg;
	
	@FindBy(linkText = "Click here for order details.")
	public WebElement orderDetailsLink;
	

    public void RegesitredUserCheckoutProduct(String countryName, String adress, String postCode,
    		                                  String phone, String city, String productName) throws InterruptedException 
    {
    	select = new Select(countryList);
    	select.selectByVisibleText(countryName);
    	setTextElementText(cityTxt, city);
    	setTextElementText(adressTxt, adress);
    	setTextElementText(postCodeTxt, postCode);
    	setTextElementText(phoneTxt, phone);
    	clickButton(continueBtn);
    	Thread.sleep(3000);
    	clickButton(shippingMethodRdo);
		Thread.sleep(3000);
    	clickButton(continueShippingBtn);
    	Thread.sleep(4000);
    	clickButton(continuePaymentBtn);
    	Thread.sleep(4000);
    	clickButton(continueInfoBtn);
    	Thread.sleep(3000);
    	
    }
    public void confirmOrder() throws InterruptedException 
    {    Thread.sleep(4000);
    	 clickButton(confirmBtn);
    	 Thread.sleep(4000);
    }
    public void printOrder() 
    {
    	clickButton(orderDetailsLink);
    }

}
