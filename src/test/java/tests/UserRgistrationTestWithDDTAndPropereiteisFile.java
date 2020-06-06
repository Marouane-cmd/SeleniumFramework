package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRgistrationTestWithDDTAndPropereiteisFile extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String firstName= LoadProperties.userdata.getProperty("firstname");
	String lastName= LoadProperties.userdata.getProperty("lastname");
	String email= LoadProperties.userdata.getProperty("email");
	String password= LoadProperties.userdata.getProperty("password");

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.UserRegistration(firstName,lastName,email,password);
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
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.logOutLink.getText().equals("Log out"));
	}
}
