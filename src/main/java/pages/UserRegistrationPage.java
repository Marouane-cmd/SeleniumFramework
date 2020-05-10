package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase
{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "gender-male")
	WebElement genderRadioBtn;

	@FindBy(id = "FirstName")
	WebElement firstNameBx;

	@FindBy(id = "LastName")
	WebElement lastNameBx;

	@FindBy(id = "Email")
	WebElement EmailBx;

	@FindBy(id = "Password")
	WebElement PasswordBx;

	@FindBy(id = "ConfirmPassword")
	WebElement confPasswordBx;

	@FindBy(id = "register-button")
	WebElement registerBtn;
	public void UserRegistration(String FirstName, String LastName, String Email, String Password)
	{
     genderRadioBtn.click();
     firstNameBx.sendKeys(FirstName);
     lastNameBx.sendKeys(LastName);
     EmailBx.sendKeys(Email);
     PasswordBx.sendKeys(Password);
     confPasswordBx.sendKeys(Password);
     registerBtn.click();
	}

}
