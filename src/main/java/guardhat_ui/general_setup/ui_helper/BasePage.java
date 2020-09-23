package guardhat_ui.general_setup.ui_helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    private static final Logger LOGGER = Logger.getLogger("base.BasePage");
    protected WebDriver driver;

    public abstract String getUrl();

    public static final String IMAGE_PATH = "";
    public static final String VIDEO_PATH = "";
    public static final String BASE_UI_URL = "https://test2.ghclosence.com/login";   // https://ddd2.guardhat.io  https://closence-1.guardhat.net/login
    public static final String USERNAME = "sccadmin";                         // davit                     sccadmin
    public static final String PASSWORD = "KyraSccAdminPassword";                 //  guardhat2020              KyraSccAdminPassword

    public BasePage() {
        this.driver = DriverHelper.get().getDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        if (!driver.getCurrentUrl().equals(getUrl())) {
            throw new Error(getUrl() + " is not loaded web page!");
        }
    }

    public void type(WebElement element, String text) {
        LOGGER.info("-*- Driver is filling " + text + " in " + element.toString());
        WaitHelper.getWait().waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        LOGGER.info("-*- Driver is clicking on " + element.toString());
        WaitHelper.getWait().waitForElementToBeVisible(element);
        element.click();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            WaitHelper.getWait().waitForElementToBeVisible(element);
            element.isDisplayed();
            LOGGER.info("-*- Element is displayed: " + element.toString());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement find(By location) {
        return driver.findElement(location);
    }

    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            LOGGER.info("-*- Element $$$disappears$$$ ");
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void scrollDown(int vertical) {
        LOGGER.info("-*- Driver is scrolling down with: " + vertical);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + vertical + ")");
    }

    public void scrollUp(int vertical) {
        LOGGER.info("-*- Driver is scrolling up with: " + vertical);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + vertical + ")");
    }

    public void driverSleep(int time) {
        LOGGER.info("-*- Driver is sleeping with: " + time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementText(WebElement element) {
        WaitHelper.getWait().waitForElementToBeVisible(element);
        LOGGER.info("-*- Driver is getting Texts: " + element.getText());
        return element.getText();
    }

    public String getElementValue(WebElement element) {
        WaitHelper.getWait().waitForElementToBeVisible(element);
        LOGGER.info("-*- Driver is getting Value: " + element.getAttribute("value"));
        return element.getAttribute("value");
    }

    public void scrollUntilElement(WebElement element) {
        LOGGER.info("-*- Driver is scrolling until: " + element.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void openNewTab(String url) {
        LOGGER.info("-*- Driver is opening new tab with: " + url + " URL");
        ((JavascriptExecutor) driver).executeScript("window.open('" + url + "'," + "'_blank')");
    }

    public void changeTab(int index) {
        LOGGER.info("-*- Driver is changing tab with: " + index);
        Object[] windows = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windows[index]).toString();
    }

    public String currentData() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddHHmmss");
        Date date = new Date();
        return formatter.format(date);
    }

    public String getElementAtt(WebElement element, String attribute) {
        WaitHelper.getWait().waitForElementToBeVisible(element);
        return element.getAttribute(attribute);
    }

    public Actions getActions() {
        return new Actions(driver);
    }

    public void clickJS(WebElement element) {
        WaitHelper.getWait().waitForElementToBeVisible(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void selectDropDownItemByName(WebElement element, String name) {
        new Select(element).selectByVisibleText(name);
    }

    public String getElementCssValue(WebElement element,String value){
        WaitHelper.getWait().waitForElementToBeVisible(element);
        return element.getCssValue(value);
    }
}
