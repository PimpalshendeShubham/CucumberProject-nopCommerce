package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	WebElement emailTextBox;

	@FindBy(id = "Password")
	WebElement passwordTextBox;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;

	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox;

	public void enterEmail(String emailAdd) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// checkBox.click();

		emailTextBox.clear();
		emailTextBox.sendKeys(emailAdd);
	}

	public void enterPassword(String pwd) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public void clickOnLogOutButton() {
		logoutLink.click();
	}
}
