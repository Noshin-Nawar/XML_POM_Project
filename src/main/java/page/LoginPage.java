package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

WebDriver driver;
	
	//creating a constructor to connect two drives (driver of LoginTest with driver of LoginPage)
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	//Element list
	@FindBy(how= How.XPATH,using="//input[@id='username']") WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@name='login']") WebElement LOGIN_ELEMENT;

	//Interact-able methods
	public void insertUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickSignin() {
		LOGIN_ELEMENT.click();
	}
}
