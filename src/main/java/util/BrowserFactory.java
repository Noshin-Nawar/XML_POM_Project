package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	static String browser;
	static String url;
	
	
	public static void readConfig() {
		
		try {
		//need to establish the file path along with InputStream
		InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
		Properties prop = new Properties();
		prop.load(input);
		browser = prop.getProperty("browser"); //output = firefox
		url = prop.getProperty("url"); //output =http://techfios.com/billing/?ng=admin/
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver init() {
		readConfig();
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
