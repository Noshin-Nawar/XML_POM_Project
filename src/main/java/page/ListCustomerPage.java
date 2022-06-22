package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListCustomerPage extends BasePage{

	
	WebDriver driver;
	
	public void listCustomerPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_BAR_ON_LIST_CUSTOMER_ELEMENT;
	
	public void clickAddCustomerOnListCustomer() {
		
		ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT.click();
	}
	
	
	String insertedName;
	public void insertSearchBarOnListCustomer() {
		
		 insertedName = AddContactPage.enteredName;
		
		SEARCH_BAR_ON_LIST_CUSTOMER_ELEMENT.sendKeys(insertedName);
		
	}
/*// tbody/tr[1]/td[3]/following-sibling::td[4]/a[1]
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_xpath_profile = "]/td[3]/following-sibling::td[4]/a[1]";
	
	
	public void verifyEnteredNameOnSearchBar() {
		
	for (int i=1; i<=5; i++) {
		
		String enteredName= driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
		
		if(enteredName.contains(insertedName)) {
			
			System.out.println("Entered name exist!!");
			
			driver.findElement(By.xpath(before_xpath+ i + after_xpath_profile)).click();
			
		}
		
		
		
		
	}	
	} 
	*/
	}
