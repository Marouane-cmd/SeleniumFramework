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
	
	@FindBy(xpath ="//div[@class='result']")
	public WebElement successMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement logOutLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;
	
	public void UserRegistration(String FirstName, String LastName, String Email, String Password)
	{
     clickButton(genderRadioBtn);
     setTextElementText(firstNameBx, FirstName);
     setTextElementText(lastNameBx, LastName);
     setTextElementText(EmailBx, Email);
     setTextElementText(PasswordBx, Password);
     setTextElementText(confPasswordBx, Password);
     clickButton(registerBtn);
	}
   public void LogOut() 
   {
	   clickButton(logOutLink);
   }
   public void OpenMyAccountPage()
   {
	   clickButton(myAccountLink);
   }

}
