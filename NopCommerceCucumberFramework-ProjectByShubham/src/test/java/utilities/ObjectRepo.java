package utilities;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.AddCustomerPage;
import pageobject.LoginPage;
import pageobject.SearchCustomerPage;

public class ObjectRepo{

	
		public  static WebDriver driver;
		public LoginPage loginPage;
		public SearchCustomerPage searchCustomerPage;
		public AddCustomerPage addCustomerPage;
		
		
		
		public String generateEmailId()
		{
			return(RandomStringUtils.randomAlphabetic(5));
		}
		
	}

