package tests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword="2020@2020";
	String newPassword="123456";
	String firstName="Marwan";
	String lastName="Hallek";
	String email="hallek.mm064444@g222.com";
	@Test(priority=1)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.UserRegistration(firstName, lastName, email, oldPassword);
		Thread.sleep(3000);
		AssertJUnit.assertTrue(registerObject.successMessage.getText().contains("completed"));
		System.out.println(registerObject.successMessage.getText());
	}  
	@Test(priority = 2)
	public void RegisteredUserCanCchangPassord() 
	{
	  
	   myAccountObject= new MyAccountPage(driver);
	   registerObject.OpenMyAccountPage();
	   myAccountObject.openChangePasswordPage();
	   myAccountObject.changePassword(oldPassword, newPassword);
	   AssertJUnit.assertTrue(myAccountObject.pswIsChanged.getText().contains("Password was changed"));
	}
	@Test(priority = 3)
	public void UserCanLogOut() 
	{
		registerObject.LogOut();
	}
	@Test(priority = 4)
	public void UserLogIn()
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
		AssertJUnit.assertTrue(registerObject.logOutLink.getText().equals("Log out"));
	}
}
