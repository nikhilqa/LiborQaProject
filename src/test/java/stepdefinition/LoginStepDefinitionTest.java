package stepdefinition;

import base.DriverInstance;

import cucumber.api.java.en.Given;
import utilities.ConfigReader;

import static junit.framework.TestCase.assertEquals;

public class LoginStepDefinitionTest extends DriverInstance {

    @Given("^user is on flowable login page$")
    public void user_is_on_flowable_login_page() {
        assertEquals(ConfigReader.readProjectConfig("TestHomePageTitle"), getMyDriver().getTitle(), "User is not on login page");
    }

}
