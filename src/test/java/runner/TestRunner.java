package runner;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        monochrome = true, dryRun = false, glue = "stepdefinition", plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"})

public class TestRunner {
    @BeforeClass
    public static void setReportConfiguration() {
        ExtentProperties property = ExtentProperties.INSTANCE;
        property.setReportPath("Reports/Report.html");
    }

    @AfterClass
    public static void setConfiguration() {
        Reporter.loadXMLConfig("ConfigFiles/extent-config.xml");
    }

}
