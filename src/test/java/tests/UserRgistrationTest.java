package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRgistrationTest extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	@Test
	public void UserCanRegisterSuccessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.UserRegistration("Marwan", "Hallek", "hallek.mm@gmail.com", "2020@2020");
	}   
}
