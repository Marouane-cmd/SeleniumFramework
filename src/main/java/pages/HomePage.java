package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse =(JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	
	@FindBy(id="customerCurrency")
	WebElement currencyDrDwList;
	
	@FindBy(linkText ="Computers")
	public WebElement computerMenu;
	
	@FindBy(xpath ="/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	public WebElement noteBooksMenu;
	
	public void openRegistrationPage()
	{
		clickButton(registerLink);
	}
	public void openLoginPage()
	{
		clickButton(LoginLink);

	}
	public void openContactUsPage() 
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}
	public void CurrencyChange() 
	{
		select= new Select(currencyDrDwList);
		select.selectByVisibleText("US Dollar");
	}
	public void SelectNoteBooksMenu() 
	{
		action.moveToElement(computerMenu).moveToElement(noteBooksMenu).click().build().perform();
	}
}
