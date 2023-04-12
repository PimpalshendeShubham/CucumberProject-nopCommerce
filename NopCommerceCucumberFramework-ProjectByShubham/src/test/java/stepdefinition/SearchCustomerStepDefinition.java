package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import pageobject.SearchCustomerPage;
import utilities.ObjectRepo;
import io.cucumber.java.en.*;

public class SearchCustomerStepDefinition extends ObjectRepo {

	@When("Enter customer Email")
	public void enter_customer_Email() {
		searchCustomerPage = new SearchCustomerPage(driver);
		searchCustomerPage.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCustomerPage.clickOnSearchButton();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() {
		boolean searchResult = searchCustomerPage.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		if (searchResult) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue("no customer found with this email", false);
	}

	@When("Enter customer Name")
	public void enter_customer_Name() {
		if (searchCustomerPage == null) {
			searchCustomerPage = new SearchCustomerPage(driver);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchCustomerPage.enterFirstName("John");
		searchCustomerPage.enterLastName("Smith");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_Search_table() {
		boolean searchResult = searchCustomerPage.searchCustomerByName("John Smith");
		if (searchResult) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue("no customer found with this name", false);
	}
}
