package guardhat_ui.administration;

import general_setup.BasePage;
import general_setup.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SystemConfPage extends BasePage {

    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public SystemConfPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//a[@title='Administration']")
    private WebElement administrationBtn;

    public void selectAdministrationBtn() {
        click(administrationBtn);
    }

    @FindBy(xpath = "//div[@class='c-dropdown']")
    private WebElement myProfileDropDown;

    public void selectMyProfileDropDown() {
        click(myProfileDropDown);
    }

    @FindBy(xpath = "//*[text()='System Configuration']")
    private WebElement userManagerOption;

    public void selectUserManagerOption() {
        click(userManagerOption);
    }

    @FindBy(xpath = "//input[@formcontrolname='nearbyWorkerDistanceThresholdUWB']")
    private WebElement usingUWBField;

    public void fillUsingUWBField(String number) {
        type(usingUWBField, number);
    }

    @FindBy(xpath = "//input[@formcontrolname='nearbyWorkerDistanceThresholdGPS']")
    private WebElement usingGPSField;

    public void fillUsingGPSField(String number) {
        type(usingGPSField, number);
    }

    public String UWBNumber;

    public String getUWBNumber() {
        return this.UWBNumber = getElementValue(usingUWBField);
    }

    public String GPSNumber;

    public String getGPSNumber() {
        return this.GPSNumber = getElementValue(usingGPSField);
    }

    @FindBy(xpath = "//*[text()=' Save ']")
    private WebElement saveBtn;

    public void selectSaveBtn() {
        driverSleep(900);
        click(saveBtn);
    }

    @FindBy(xpath = "//p[contains(text(),' System Configuration has been modified! ')]")
    private WebElement savedReportMessage;

    public boolean isDisplayedSavedReportMessage() {
        return isDisplayed(savedReportMessage);
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }


    @FindBy(xpath = "//input[@formcontrolname='enableUserTracker']")
    private WebElement userTrackerCheckbox;

    public String userTrackerCheckboxAttribute;

    public String getUserTrackerCheckboxAttribute() {
        return this.userTrackerCheckboxAttribute = getElementAtt(userTrackerCheckbox, "class");
    }

    public void selectUserTrackerCheckbox() {
        click(userTrackerCheckbox);
    }

    @FindBy(xpath = "//input[@formcontrolname='enableRoleBasedStyle']")
    private WebElement deviceStyleCheckbox;

    public String deviceStyleCheckboxAttribute;

    public String getDeviceStyleCheckboxAttribute() {
        return this.deviceStyleCheckboxAttribute = getElementAtt(deviceStyleCheckbox, "class");
    }

    public void selectDeviceStyleCheckbox() {
        click(deviceStyleCheckbox);
    }

    @FindBy(xpath = "//input[@formcontrolname='showInfoMessages']")
    private WebElement showInfoMessagesCheckbox;

    public String showInfoMessagesCheckboxAttribute;

    public String getShowInfoMessagesCheckboxAttribute() {
        return this.showInfoMessagesCheckboxAttribute = getElementAtt(showInfoMessagesCheckbox, "class");
    }

    public void selectShowInfoMessagesCheckbox() {
        click(showInfoMessagesCheckbox);
    }

    public String ngDirty = "checkbox-hidden ng-valid ng-dirty ng-touched";
}
