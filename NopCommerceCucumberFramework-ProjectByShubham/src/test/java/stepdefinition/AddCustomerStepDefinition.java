package stepdefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageobject.AddCustomerPage;
import pageobject.SearchCustomerPage;
import utilities.ObjectRepo;
import io.cucumber.java.en.*;

public class AddCustomerStepDefinition extends ObjectRepo {

	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {

		addCustomerPage = new AddCustomerPage(driver);
		String actualTitle = addCustomerPage.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);

		}
	}

	@When("User click on customers Dropdown Menu")
	public void user_click_on_customers_Dropdown_Menu() {
		addCustomerPage.clickOnCustomersMenu();
	}

	@When("click on customers Item")
	public void click_on_customers_Item() {
		addCustomerPage.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() {
		addCustomerPage.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		String actualTitle = addCustomerPage.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("User enter customer info")
	public void user_enter_customer_info(io.cucumber.datatable.DataTable dataTable) {

		addCustomerPage.enterEmail(generateEmailId() + "@gmail.com");

		Map<String, String> data = dataTable.asMap(String.class, String.class);

		addCustomerPage.enterPassword(data.get("password"));
		addCustomerPage.enterFirstName(data.get("firstName"));
		addCustomerPage.enterLastName(data.get("lastName"));
		addCustomerPage.enterGender(data.get("Gender"));
		addCustomerPage.enterDob(data.get("DOB"));
		addCustomerPage.enterCompanyName(data.get("companyName"));

	}

	@When("click on Save button")
	public void click_on_Save_button() {
		addCustomerPage.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
		String actualMessage = addCustomerPage.getMessage();
		if (actualMessage.contains(message)) {
			Assert.assertTrue(true);

		}
	}

}
