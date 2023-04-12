package stepdefinition;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import io.cucumber.java.en.*;

import pageobject.LoginPage;
import utilities.ObjectRepo;

public class LoginStepDefinition extends ObjectRepo {

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {

		loginPage = new LoginPage(driver);
		System.out.println("Launch browser");
		
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
	}

	@When("User enters Email as test@{int}.com and Password as test{int}")
	public void user_enters_Email_as_test_com_and_Password_as_test(String email, String password) {
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
	}

	@When("User enters Email as email and Password as password")
	public void user_enters_Email_as_email_and_Password_as_password(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String email = row.get("email");
			String password = row.get("password");

			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
		}
	}

	@When("Click on Login")
	public void click_on_Login() {

		loginPage.clickOnLoginButton();
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String string) {

		String actualTitle = driver.getTitle();
		if (actualTitle.equals(string)) {

			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue("title is not matched", false);
		}

	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() {
		loginPage.clickOnLogOutButton();
	}

	@Then("close browser")
	public void close_browser() {

		driver.close();
	}
}
