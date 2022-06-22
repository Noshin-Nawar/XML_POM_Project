package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {

	WebDriver driver;


	// saving the values of the required cells in separate string variables, to call
	// them later on
	
	
	String USERNAME;
	String PASSWORD ;


	@Test
	@Parameters({"userName","password"})
	public void validUserShouldBeAbleToLogin(String USERNAME,String PASSWORD) {

		// connecting two drivers (driver of BrowserFactory and driver of LoginTest) and
		// calling the init() method
		driver = BrowserFactory.init();

		// using Pagefactory method to create object of the LoginPage
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(USERNAME);
		loginPage.insertPassword(PASSWORD);
		loginPage.clickSignin();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardHeader("Dashboard");

		// calling the tearDown() method
		 BrowserFactory.tearDown();

	}

}
