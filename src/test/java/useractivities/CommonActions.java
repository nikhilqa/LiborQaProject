package useractivities;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Logger.LogSetting;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonActions {

    private WebDriver driver;
    public final int timeOut = 45;
    private static final String char_list = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,w,x,w,z";
    private static final int char_length = 10;
    private Logger log = LogSetting.getLogger(CommonActions.class);

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * method to open specified url
     *
     * @param url to open
     */
    //Step to navigate to specified URL
    public void get(String url) {
        driver.get(url);
    }

    /**
     * method to navigate to specified page
     *
     * @param url navigation url
     */
    public void navigate(String url) {
        driver.navigate().to(url);
    }

    /**
     * method to enter text
     *
     * @param text to enter text
     */
    //Step to navigate to specified URL
    public void enterString(WebElement element, String text) {
        element.isEnabled();
        element.sendKeys(text);
    }

    /**
     * method to click
     */
    //Step to navigate to specified URL
    public void clickElement(WebElement element) {
        element.isEnabled();
        element.click();
    }

    /**
     * method to click on an element with action class
     *
     * @param element to be clicked
     */
    public void clickOnElementUsingActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement((By) element));
        actions.click().perform();
    }

    /**
     * method to click on an element using javascript
     *
     * @param element to be clicked
     */
    public void clickOnElementUsingJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement((By) element);
        js.executeScript("arguments[0].click();", webElement);
    }

    /**
     * method to get int part from a string
     *
     * @param getInt string passed
     * @return
     */
    public int getIntValue(String getInt) {
        Pattern intsOnly = Pattern.compile("\\d+");
        Matcher makeMatch = intsOnly.matcher(getInt);
        makeMatch.find();
        String inputInt = makeMatch.group();
        return Integer.parseInt(inputInt);
    }

    /**
     * method to get title of current webpage
     *
     * @return String name of a webpage
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * method to wait until page is loaded completely
     *
     * @param PageName String name of current webpage
     */
    public void waitForPageToLoad(String PageName) {
        String pageLoadStatus;
        JavascriptExecutor js;

        do {
            js = (JavascriptExecutor) driver;
            pageLoadStatus = (String) js.executeScript("return document.readyState");
            log.info(".");
        } while (!pageLoadStatus.equals("complete"));
        log.info(PageName + " page loaded successfully");
    }


    /**
     * method verify whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     */
    public Boolean isElementPresent(By targetElement) {
        return driver.findElements(targetElement).size() > 0;
    }

    /**
     * method verify whether element is not present on screen
     *
     * @param targetElement element not to be present
     * @return true if element is not present else throws exception
     */
    public Boolean isElementNotPresent(By targetElement) {
        return driver.findElements(targetElement).size() == 0;
    }

    /**
     * method to wait for an element to be visible
     *
     * @param targetElement element to be visible
     * @return true if element is visible else throws TimeoutException
     */
    public boolean waitForVisibility(By targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is not visible: " + targetElement);
            System.out.println();
            System.out.println(e.getMessage());
            throw new TimeoutException();
        }
    }

    /**
     * method to wait for an element to be clickable
     *
     * @param targetElement element to be clickable
     * @return true if element is clickable else throws TimeoutException
     */
    public boolean waitForElementToBeClickable(By targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is not clickable: " + targetElement);
            System.out.println();
            System.out.println(e.getMessage());
            throw new TimeoutException();
        }
    }

    /**
     * method to wait for an element until it is invisible
     *
     * @param targetElement element to be invisible
     * @return true if element gets invisible else throws TimeoutException
     */
    public boolean waitForInvisibility(By targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is still visible: " + targetElement);
            System.out.println();
            System.out.println(e.getMessage());
            throw new TimeoutException();
        }
    }

    /**
     * method to find an element
     *
     * @param locator element to be found
     * @return WebElement if found else throws NoSuchElementException
     */
    public WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /**
     * method to find all the elements of specific locator
     *
     * @param locator element to be found
     * @return return the list of elements if found else throws NoSuchElementException
     */
    public List<WebElement> findElements(WebElement locator) {
        try {
            return driver.findElements((By) locator);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /**
     * method to match value with list elements and click on it
     *
     * @param fetchedListElements List of fetched value
     * @param valueToBeMatched    value to be matched with list elements
     */
    public void clickOnMatchingValue(List<WebElement> fetchedListElements, String valueToBeMatched) {

        for (WebElement element : fetchedListElements) {
            if (element.getText().equalsIgnoreCase(valueToBeMatched)) {
                element.click();
                return;
            }
        }
    }

    /**
     * method to check value contained in list elements and click on it
     *
     * @param fetchedListElements List of fetched value
     * @param valueToBeContained  value to be contained in list elements
     */
    public void clickOnContainingValue(List<WebElement> fetchedListElements, String valueToBeContained) {

        for (WebElement element : fetchedListElements) {
            if (element.getText().toLowerCase().contains(valueToBeContained.toLowerCase())) {
                element.click();
                //System.out.println("Trying to select: "+valueToBeContained );
                return;
            }
        }
    }

    /**
     * method to accept alert,
     * exception is thrown if no alert is present
     */
    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            throw new NoAlertPresentException();
        }
    }

    /**
     * method to get message test of alert
     *
     * @return message text which is displayed
     */
    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (NoAlertPresentException e) {
            throw new NoAlertPresentException();
        }
    }

    /**
     * method to verify if alert is present
     *
     * @return returns true if alert is present else false
     */
    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            throw new NoAlertPresentException();
        }
    }

    /**
     * method to select a value from dropdown with index
     *
     * @param selectLocator          element with select tag
     * @param valueToBeSelectedindex index to be selected
     */
    public void selectValuefromDropDownByIndex(By selectLocator, int valueToBeSelectedindex) {
        Select selectFromDropdown = new Select(findElement(selectLocator));
        selectFromDropdown.selectByIndex(valueToBeSelectedindex);

    }

    //generic helper methods start
    protected void clearInput(WebElement selector) {
        driver.findElement((By) selector).clear();
    }

    protected void setValue(WebElement selector, String value) {
        // does work of driver.findElement(By.id("ainput")).sendKeys("10");
        driver.findElement((By) selector).sendKeys(value);
    }

    protected String getInputFieldValue(WebElement selector) {
        String inputFieldValue = driver.findElement((By) selector).getAttribute("value");
        return inputFieldValue;
    }

    public void SelectByVisibleText(WebElement element, String visibleValue) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleValue);
        log.info("WebElement " + element + "Visible value" + visibleValue);
    }

    // Select first option
    public String getFirstSelectedOption(WebElement element) {
        String value = new Select(element).getFirstSelectedOption().getText();
        log.info("WebElement " + element + "value" + value);
        return value;
    }

    // Select using index
    public void SelectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
        log.info("WebElement " + element + "index" + index);
    }

    // Select by value
    public void SelectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
        log.info("WebElement " + element + "value" + value);
    }


    public void DeSelectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByValue(value);
        log.info("WebElement " + element + "value" + value);
    }

    public List<String> getAllDropDownValue(WebElement locator) {
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement element : elementList) {
            log.info("Element" + element.getText());
            valueList.add(element.getText());
        }
        return valueList;
    }

    public boolean verifyElementPresent(WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
            log.info(element.getText() + " isDisplayed");
        } catch (Exception e) {
            log.error(e);
        }
        return isDisplayed;
    }

    public boolean verifyElementNotPresent(
            WebElement element) {
        boolean isDisplayed = false;
        try {
            element.isDisplayed();
            log.info(element.getText() + " is Displayed");
        } catch (Exception e) {
            log.error("Element Not Found" + e);
            isDisplayed = true;
        }
        return isDisplayed;
    }

    public boolean verifyTextEquals(WebElement element,
                                    String expectedText) {
        boolean flag = false;
        try {
            String actualText = element.getText();
            if (actualText.equals(expectedText)) {
                log.info("actualText is :" + actualText + " expected text is: "
                        + expectedText);
                return flag = true;
            } else {
                log.error("actualText is :" + actualText
                        + " expected text is: " + expectedText);
                return flag;
            }

        } catch (Exception e) {
            log.error("actualText is :" + element.getText()
                    + " expected text is: " + expectedText);
            log.info("text not matching" + e);
            return flag;
        }

    }

    public Object executeScript(String script) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        log.info(script);
        return exe.executeScript(script);
    }

    public Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        log.info(script);
        return exe.executeScript(script, args);
    }

    public void scrollToElemet(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
        log.info(element);
    }

    public void scrollToElemetAndClick(WebElement element) {
        scrollToElemet(element);
        element.click();
        log.info(element);
    }

    public void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView()", element);
        log.info(element);
    }

    public void scrollIntoViewAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
        log.info(element);
    }

    public void scrollDownVertically() {
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollUpVertically() {
        executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public static String GenerateRandomString() {
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < char_length; i++) {
            int number = getRandomNumber();
            char ch = char_list.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    public static int getRandomNumber() {
        int randomInt = 0;
        Random randGen = new Random();
        randomInt = randGen.nextInt(char_list.length());
        if (randomInt - 1 == -1) {
            return randomInt - 1;

        } else {
            return randomInt;
        }

    }

    public void setImplicitWait(long timeout, TimeUnit unit) {
        driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
    }

    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMilSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(pollingEveryInMilSec, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    public void waitForElementVisible(WebElement locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitForElement(WebDriver driver, WebElement element, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element is " + element.getText());
    }

    public WebElement waitForElement(WebDriver driver, long time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPageToLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
