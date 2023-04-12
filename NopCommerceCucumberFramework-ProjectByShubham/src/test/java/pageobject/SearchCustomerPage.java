package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCustomerPage {

	WebDriver driver;
	WebDriverWait wait;

	public SearchCustomerPage(WebDriver Driver) {
		this.driver = Driver;

		PageFactory.initElements(Driver, this);
	}

	@FindBy(id = "SearchEmail")
	WebElement emailAdd;

	@FindBy(id = "search-customers")
	WebElement searchBtn;

	@FindBy(xpath = "//table[@role='grid']")
	WebElement searchResult;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(id = "SearchFirstName")
	WebElement firstName;

	@FindBy(id = "SearchLastName")
	WebElement lastName;

	public void enterEmailAdd(String email) {
		emailAdd.sendKeys(email);
	}

	public void clickOnSearchButton() {
		searchBtn.click();

	}

	public boolean searchCustomerByEmail(String expectedEmail) {
		boolean found = false;

		int ttlRows = tableRows.size();

		for (int i = 1; i <= ttlRows; i++) {
			System.out.println("Searching row:" + i);

			WebElement webElementEmail = driver.findElement(By.xpath("//table//tbody/tr[" + i + "]/td[2]"));
			String actualEmailAdd = webElementEmail.getText();
			System.out.println(actualEmailAdd);

			if (actualEmailAdd.equals(expectedEmail)) {
				found = true;
				break;
			}

		}

		return found;

	}

	public void enterFirstName(String firstNameText) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(firstNameText);

	}

	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}

	public boolean searchCustomerByName(String name) {
		boolean found = false;

		int ttlRows = tableRows.size();

		for (int i = 1; i <= ttlRows; i++) {
			WebElement webElementName = driver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"));
			String actualName = webElementName.getText();

			if (actualName.equals(name)) {
				found = true;
				break;
			}

		}

		return found;

	}
}
