package guardhat_ui.pages.administration;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.general_setup.ui_helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeaconManagerPage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public BeaconManagerPage() {
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

    @FindBy(xpath = "//*[text()='Beacon Manager']")
    private WebElement beaconManagerOption;

    public void selectBeaconManagerOption() {
        click(beaconManagerOption);
    }

    @FindBy(xpath = "//a[text()=' Add Beacon ']")
    private WebElement addBeaconBtn;

    public void selectAddBeaconBtn() {
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("(//img[@alt='enabled'])[1]"));
        click(addBeaconBtn);
    }

    @FindBy(xpath = "//div[@class='mat-form-field-wrapper']")
    private WebElement typeDropDown;

    @FindBy(xpath = "//mat-select[@role='listbox']")
    private WebElement typeDropDownArrow;

    public void selectTypeDropDown() {
        driverSleep(4500);
//        WaitHelper.getWait().waitForElementToBeClickable
//                (By.cssSelector(".mat-select-trigger .mat-select-arrow-wrapper"));
        click(typeDropDown);
    }

    @FindBy(xpath = "//span[text()=' Fixed Beacon ']")
    private WebElement fixedBeaconOption;

    public void selectFixedBeaconOption() {
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("(//span[@class='mat-option-text'])[3]"));
        click(fixedBeaconOption);
    }

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement nameField;

    public void fillNameField() {
        type(nameField, "SQA_" + currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='uuid']")
    private WebElement uuidField;

    public void fillUuidField() {
        type(uuidField, "e2c56db5-dffb-48d2-b060-d0f5a71096e3");
    }

    @FindBy(xpath = "//input[@formcontrolname='major']")
    private WebElement majorField;

    public void fillMajorField() {
        type(majorField, currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='minor']")
    private WebElement minorField;

    public void fillMinorField() {
        type(minorField, currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='innerProximityThreshold']")
    private WebElement innerProximityThresholdField;

    public void fillInnerProximityThresholdField() {
        type(innerProximityThresholdField, currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='latitude']")
    private WebElement latitudeField;

    public void fillLatitudeField() {
        type(latitudeField, currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='longitude']")
    private WebElement longitudeField;

    public void fillLongitudeField() {
        type(longitudeField, currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='altitude']")
    private WebElement altitudeField;

    public void fillAltitudeField() {
        type(altitudeField, currentData());
    }

    @FindBy(xpath = "//*[text()=' Save ']")
    private WebElement saveBtn;

    public void selectSaveBtn() {
        click(saveBtn);
    }

    @FindBy(xpath = "//p[contains(text(),' New Beacon has been added! ')]")
    private WebElement beaconAddMessage;

    public boolean isDisplayedBeaconAddMessage() {
        return isDisplayed(beaconAddMessage);
    }

    @FindBy(xpath = "//input")
    private WebElement searchField;

    public void fillSearchField(String name) {
        type(searchField, name);
    }

    public String beaconName;

    public String getBeaconName() {
        return this.beaconName = getElementValue(nameField);
    }

    public void createNewBeacon() {
        selectAddBeaconBtn();
        selectTypeDropDown();
        selectFixedBeaconOption();
        fillNameField();
        getBeaconName();
        fillUuidField();
        fillMajorField();
        fillMinorField();
        fillInnerProximityThresholdField();
        fillLatitudeField();
        fillLongitudeField();
        fillAltitudeField();
        selectSaveBtn();
        isDisplayedBeaconAddMessage();
    }

    @FindBy(xpath = "//a[@class='c-listview__result']")
    private WebElement firstBeacon;

    public void selectFirstBeacon() {
        click(firstBeacon);
    }

    @FindBy(xpath = "//*[text()=' Edit  ']")
    private WebElement editBtn;

    public void selectEditBtn() {
        click(editBtn);
    }


    @FindBy(xpath = "//p[contains(text(),' Beacon has been modified! ')]")
    private WebElement beaconUpdateMessage;

    public boolean isDisplayedBeaconUpdateMessage() {
        return isDisplayed(beaconUpdateMessage);
    }

}
