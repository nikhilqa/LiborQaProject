package base;

import Logger.LogSetting;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import useractivities.CommonActions;
import utilities.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class BaseCall {//} extends DriverInstance {

    private Logger log = LogSetting.getLogger(BaseCall.class);
    public WebDriver driver = DriverInstance.getMyDriver();

    @Before
    public void alwaysRun() {
        new CommonActions(driver).get(ConfigReader.readProjectConfig("FlowableQaURL"));
        log.info("Browser started");
    }

    @After()
    public void closeDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = "screenshot" + new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss")
                    .format(new GregorianCalendar().getTime())
                    + ".png";
            log.info(screenshotPath);
            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("Screenshots" + screenshotPath));
                log.info("Screenshot taken before case failure");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.close();
        log.info("Browser closed");
    }
}
