package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import useractivities.CommonActions;
import Logger.LogSetting;

public class LoginPage {

    private WebDriver driver = null;
    private Logger log = LogSetting.getLogger(CommonActions.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Find the element locator.
     */

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement usernameTextBox;

    /**
     * Login functions.
     */

    private void enterUsername(String username) {
        new CommonActions(driver).enterString(usernameTextBox, username);
        log.info("Username Entered");
    }
}
