package guardhat_ui.devices;

import general_setup.BasePage;
import general_setup.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;


public class WorkersPage extends BasePage {
    @Override
    public String getUrl() {
        return "https://ddd2.guardhat.io/";
    }

    public WorkersPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//a[@title='Devices']")
    private WebElement devicesBtn;

    public void selectDevicesBtn() {
        click(devicesBtn);
    }

    @FindBy(xpath = "//select[@type='select']")
    private WebElement deviceStatusDropDown;

    @FindBys({
            @FindBy(xpath = "//select[@type='select']/option")
    })
    private List<WebElement> deviceStatusOptions;

    public void selectDeviceStatusOption(String text) {
        click(deviceStatusDropDown);
        for (WebElement deviceStatusOption : deviceStatusOptions) {
            if (getElementText(deviceStatusOption).equals(text)) {
                click(deviceStatusOption);
                break;
            }
        }
    }

    @FindBy(xpath = "(//div[@class='worker-status--container']//span)[2]")
    private WebElement deviceStatusText;

    public String statusText;

    public String getDeviceStatusText() {
        return this.statusText = getElementText(deviceStatusText);
    }

    @FindBy(xpath = "//div[@class='icon-container']")
    private WebElement reloadBtn;

    public void selectReloadBtn() {
        click(reloadBtn);
    }

    @FindBy(xpath = "(//div[@class='c-listview__icon'])[1]")
    private WebElement firstDeviceIcon;

    public boolean isNotDisplayedFirstDeviceIcon() {
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.xpath("(//div[@class='c-listview__icon'])[1]"));
        return isNotDisplayed(firstDeviceIcon);
    }

    public void selectFirstDeviceIcon() {
        click(firstDeviceIcon);
    }

    @FindBy(xpath = "//div[@type='userTrackerStart']")
    private WebElement trackBtn;

    public void selectTrackBtn() {
        click(trackBtn);
    }

    @FindBy(xpath = "//text[@class='tracker_mode']")
    private WebElement nowFollowingText;

    public boolean isDisplayedNowFollowingText() {
        return isDisplayed(nowFollowingText);
    }

    @FindBy(xpath = "//*[contains(text(),' Stop Tracking ')]")
    private WebElement stopTrackerBtn;

    public void selectStopTrackerBtn() {
        click(stopTrackerBtn);
    }

    public boolean isDisplayedTrackBtn() {
        return isDisplayed(trackBtn);
    }

    @FindBy(xpath = "//h2[text()='Sensor readings']")
    private WebElement sensorReadingsText;

    public boolean isDisplayedSensorReadingsText() {
        return isDisplayed(sensorReadingsText);
    }

    @FindBy(xpath = "//*[contains(text(),' Close ')]")
    private WebElement closeBtn;

    public void selectCloseBtn() {
        click(closeBtn);
    }

    public boolean isNotDisplayedSensorReadingsText() {
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.xpath("//h2[text()='Sensor readings']"));
        return isNotDisplayed(sensorReadingsText);
    }

    @FindBys({
            @FindBy(xpath = "//span[@class='worker-status--text font-grey']")
    })
    private List<WebElement> statusArray;

    public String workerStatusText;

    public String getStatusArray(String text) {
        for (WebElement status : statusArray) {
            if (getElementText(status).equals(text)) {
                break;
            }
        }
        return this.workerStatusText = text;
    }

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
    private WebElement firstDeviceName;

    public String firstDeviceNameText;

    public String getFirstDeviceNameText() {
        return this.firstDeviceNameText = getElementText(firstDeviceName);
    }

    @FindBy(xpath = "(//h1[@class='header__title'])[1]")
    private WebElement headerDeviceName;

    public String headerDeviceNameText;

    public String getHeaderDeviceNameText() {
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("(//h1[@class='header__title'])[1]"));
        return this.headerDeviceNameText = getElementText(headerDeviceName);
    }

    @FindBy(xpath = "//div[@type='call-video']")
    private WebElement videoCallBtn;

    @FindBy(xpath = "//div[@type='callStart']")
    private WebElement callAudioBtn;

    @FindBy(xpath = "//div[@type='teleCommands-tts']")
    private WebElement textBtn;

    public boolean isDisplayedVideoCallBtn() {
        return isDisplayed(videoCallBtn);
    }

    public boolean isDisplayedCallAudioBtn() {
        return isDisplayed(callAudioBtn);
    }

    public boolean isDisplayedTextBtn() {
        return isDisplayed(textBtn);
    }

    @FindBy(xpath = "(//div[@class='c-summary']//span)[1]")
    private WebElement deviceCount;

    public String deviceCountAfterRefresh;
    public String deviceCountBeforeRefresh;

    public String getDeviceCountAfterRefresh() {
        return this.deviceCountAfterRefresh = getElementText(deviceCount);
    }

    public String getDeviceCountBeforeRefresh() {
        return this.deviceCountBeforeRefresh = getElementText(deviceCount);
    }


}
