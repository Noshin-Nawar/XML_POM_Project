package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;

import util.BrowserFactory;



public class AddContactTest {

	WebDriver driver;

	// saving the values of the required cells in separate string variables, to call
	// them later on
	String USERNAME;
	String PASSWORD;
	String FULLNAME;
	String COMPANYNAME;
	String EMAIL;
	String PHONE;
	String ADDRESS;
	String CITY;
	String COUNTRY;
	String STATE;
	String ZIP;
    
	@Test 
	@Parameters({"userName","password","FullName","CompanyName","Email","Phone","Address","City","Country","State","Zip"})
	public void userShouldBeAbleToAddCustomer(String USERNAME,String PASSWORD,String FULLNAME,String COMPANYNAME,String EMAIL,String PHONE,	String ADDRESS,String CITY,String COUNTRY,String STATE,String ZIP) throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.insertUserName( USERNAME);
		loginPage.insertPassword(PASSWORD);
		loginPage.clickSignin();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardHeader("Dashboard");
		dashboardPage.clickOnCustomer();
		dashboardPage.clickOnAddCustomer();
		
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
	    addContactPage.validateAddContactPage("Add Contact");
		addContactPage.insertFullName(FULLNAME);
		addContactPage.selectCompany(COMPANYNAME);
		addContactPage.insertEmail( EMAIL);
        addContactPage.insertPhone(PHONE);
        addContactPage.insertAddress(ADDRESS);
        addContactPage.insertCity(CITY);
        addContactPage.insertCity(STATE);
        addContactPage.insertZip(ZIP);
        
        addContactPage.selectCountry(COUNTRY);
        addContactPage.clickSaveButton();
        
        
        dashboardPage.clickListCustomer();
     // addContactPage.varifyInsertedNameandDelete();
        //addContactPage.insertSearchBarOnListCustomer();
        
        
	}

	
	

}
