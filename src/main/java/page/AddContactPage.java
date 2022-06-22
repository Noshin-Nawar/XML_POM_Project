package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddContactPage extends BasePage {
	WebDriver driver;

	// constructor creation & passing the driver in this page
	public AddContactPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Add Contact')]")
	WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ELEMENT;


	

	
	// for assert of this page
	public void validateAddContactPage(String addContact) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), addContact, "Wrong Page!");
	}

	static String enteredName;

	public static String getEnteredName() {
		return enteredName;
	}

	public void insertFullName(String fullName) {

		String enteredName = fullName + generateRandomNo(999);

		FULL_NAME_ELEMENT.sendKeys(enteredName);
	}

	public void selectCompany(String company) {

		selectFromDropdown(COMPANY_ELEMENT, company);
	}

	public void insertEmail(String email) {

		EMAIL_ELEMENT.sendKeys(email + generateRandomNo(999));

	}

	public void insertPhone(String phone) {

		PHONE_ELEMENT.sendKeys(phone + generateRandomNo(999));

	}

	public void insertAddress(String address) {

		ADDRESS_ELEMENT.sendKeys(address + generateRandomNo(999));

	}

	public void insertCity(String city) {

		CITY_ELEMENT.sendKeys(city);

	}

	public void insertState(String state) {

		STATE_ELEMENT.sendKeys(state);

	}

	public void insertZip(String zip) {

		ZIP_ELEMENT.sendKeys(zip + generateRandomNo(999));

	}

	public void selectCountry(String country) {

		selectFromDropdown(COUNTRY_ELEMENT, country);

	}

	public void clickSaveButton() {

		SAVE_BUTTON_ELEMENT.click();

	}

	// forListCustomerPage

	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[3]/td[3]
	// tbody/tr[i]/td[3]
	// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]

/*	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_delete_xpath = "]/td[3]/following-sibling::td[4]/a[2]";

	// for List Customerpage
	public void varifyInsertedNameandDelete() {

		for (int i= 1; i <= 5; i++) {

			String nameList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			
				//System.out.println(nameList);
		 
		 if(nameList.contains(enteredName)) 
		 {
			 
				System.out.println("Entered Name Exist.");
				
				driver.findElement(By.xpath(before_xpath + i + after_delete_xpath)).click();
			
		 }
          break; 
		} 
	} 
	
	*/

	
	
	
}
