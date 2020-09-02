package guardhat_ui.general_setup.ui_helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverHelper {

    public static DriverHelper get() {
        DriverHelper driverHelper = new DriverHelper();
        return driverHelper;
    }

    public WebDriver driver;
    private static final String BROWSER = System.getProperty("selenium.browser", "chrome");
    private static final String REMOTE = System.getProperty("selenium.remote", "false");
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private String OS = System.getProperty("os.name");

    public WebDriver getDriver() {
        if (OS.contains("Mac")) {
            if (driverThread.get() == null) {
                switch (BROWSER) {
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver",
                                "./src/main/resources/drivers/chromedriver-mac-64bit");
                        if (Boolean.valueOf(REMOTE)) {
                            driver = initRemoteDriver(DesiredCapabilities.chrome());
                        } else {
                            driver = new ChromeDriver();
                            driver.manage().deleteAllCookies();
                        }
                        driverThread.set(driver);
                        driver.manage().window().fullscreen();
                        break;

                    case "firefox":
                        System.setProperty("webdriver.gecko.driver",
                                "./src/main/resources/drivers/geckodriver-mac-64bit");
                        if (Boolean.valueOf(REMOTE)) {
                            driver = initRemoteDriver(DesiredCapabilities.firefox());
                        } else {
                            driver = new FirefoxDriver();
                        }
                        driverThread.set(driver);
                        break;
                }
            }
            return driverThread.get();
        } else if (OS.contains("Linux") || OS.contains("Ubuntu")) {
            if (driverThread.get() == null) {
                switch (BROWSER) {
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver",
                                "/opt/chromedriver");
                        if (Boolean.valueOf(REMOTE)) {
                            driver = initRemoteDriver(DesiredCapabilities.chrome());
                        } else {
                            driver = new ChromeDriver();
                            driver.manage().deleteAllCookies();
                        }
                        driverThread.set(driver);
                        driver.manage().window().fullscreen();
                        break;

                    case "firefox":
                        System.setProperty("webdriver.gecko.driver",
                                "./src/main/resources/drivers/geckodriver-linux-64bit");
                        if (Boolean.valueOf(REMOTE)) {
                            driver = initRemoteDriver(DesiredCapabilities.firefox());
                        } else {
                            driver = new FirefoxDriver();
                        }
                        driverThread.set(driver);
                        break;
                }
            }
            return driverThread.get();
        } else {
            if (driverThread.get() == null) {
                switch (BROWSER) {
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver",
                                "./src/main/resources/drivers/chromedriver-windows-32bit.exe");
                        if (Boolean.valueOf(REMOTE)) {
                            driver = initRemoteDriver(DesiredCapabilities.chrome());
                        } else {
                            driver = new ChromeDriver();
                            driver.manage().deleteAllCookies();
                        }
                        driverThread.set(driver);
                        driver.manage().window().fullscreen();
                        break;

                    case "firefox":
                        System.setProperty("webdriver.gecko.driver",
                                "./src/main/resources/drivers/geckodriver-windows-32bit.exe");
                        if (Boolean.valueOf(REMOTE)) {
                            driver = initRemoteDriver(DesiredCapabilities.firefox());
                        } else {
                            driver = new FirefoxDriver();
                        }
                        driverThread.set(driver);
                        break;
                }
            }
            return driverThread.get();
        }
    }

    public RemoteWebDriver initRemoteDriver(DesiredCapabilities capabilities) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", true);
            capabilities.setCapability("screenResolution", "1920x1080x24");
            remoteWebDriver = new RemoteWebDriver(new URL("http://192.168.20.100:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return remoteWebDriver;
    }

    public void quitDriver(WebDriver driver) {
//        driver.close();
        driver.quit();
        driverThread.remove();
    }
}
