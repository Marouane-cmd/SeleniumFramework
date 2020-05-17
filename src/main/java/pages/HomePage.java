package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Register")
	WebElement registerLink;
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	public void openRegistrationPage()
	{
		clickButton(registerLink);
	}
	public void openLoginPage()
	{
		clickButton(LoginLink);

	}
}
