package guardhat_ui.administration;

import general_setup.BasePage;
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

    @FindBy(xpath = "//*[@class='gh-icon icon-Plus']")
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

    public void reloadPage(){
        driver.navigate().refresh();
    }

}
