package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ConfigReader;

import java.util.concurrent.TimeUnit;

public class DriverInstance {

    public DriverInstance() {
    }

    private static WebDriver driverInstance = null;

    public static WebDriver getMyDriver() {
        startDriver();
        return driverInstance;
    }

    private static void startDriver() {
        if (driverInstance == null) {
            if (ConfigReader.readProjectConfig("BrowserName").equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
                driverInstance = new ChromeDriver();
                driverInstance.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
                driverInstance.manage().window().maximize();
//                return driverInstance;
            } else if
            (ConfigReader.readProjectConfig("BrowserName").equalsIgnoreCase("Chrome") && ConfigReader.readProjectConfig("Hidden").equalsIgnoreCase("true")) {
                System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
                driverInstance = new ChromeDriver(options);
//                return driverInstance;
            }
        }
//        return driverInstance;
    }
}


