package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
   @FindBy(linkText = "Change password")
   WebElement changPasswordLink;
   
   @FindBy(id="OldPassword")
   WebElement oldPassword;
   
   @FindBy(id ="NewPassword")
   WebElement newPassword;
   
   @FindBy(id="ConfirmNewPassword")
   WebElement confirmNwPsw;
   
   @FindBy(css="div.result")
   public WebElement pswIsChanged;
   
   @FindBy(css="input.button-1.change-password-button")
   WebElement chanPswBtn;
   
   public void openChangePasswordPage() 
   {
	   clickButton(changPasswordLink);
   }
   public void changePassword(String oldPsw, String newPsw ) 
   {
	   setTextElementText(oldPassword, oldPsw);
	   setTextElementText(newPassword, newPsw);
	   setTextElementText(confirmNwPsw, newPsw);
	   clickButton(chanPswBtn);
   }
   
}
