package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { ".//Feature" }, // it will run LoginPage.feature
		glue = { "stepdefinition","hooks" }, 
		dryRun = false, 
		monochrome = true,
		tags="@Regression",
				
		plugin = {"pretty", "html:target/CucumberReports/Reports_html.html","json:target/CucumberReports/Reports_json.json","junit:target/CucumberReports/Reports_xml.xml"}
		//plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	
		)
		
public class TestRunner {

}
