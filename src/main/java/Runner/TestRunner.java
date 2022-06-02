package Runner;

import org.apache.poi.hssf.record.formula.functions.True;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Selenium_Workspace\\AmazonCucumberPOM\\src\\main\\java\\features\\amazonSelectIteam.feature", //the path of the feature files
		glue={"StepDefinations"}, //the path of the step definition files
		format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = true//to check the mapping is proper between feature file and step def file
		//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}			
		)

public class TestRunner {
}
