package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRgistrationTest extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.UserRegistration("Marwann", "Hallek", "hallek.mm035@g222.com", "2020@2020");
		Thread.sleep(3000);
		Assert.assertTrue(registerObject.successMessage.getText().contains("completed"));
		System.out.println(registerObject.successMessage.getText());
	}  
	@Test(dependsOnMethods = "UserCanRegisterSuccessfully")
	public void UserCanLogOut() 
	{
		registerObject.LogOut();
	}
	@Test(dependsOnMethods = "UserCanLogOut")
	public void UserLogIn()
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.UserLogin("hallek.mm035@g222.com", "2020@2020");
		Assert.assertTrue(registerObject.logOutLink.getText().equals("Log out"));
	}
}
