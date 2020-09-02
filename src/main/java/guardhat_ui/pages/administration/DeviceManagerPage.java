package guardhat_ui.pages.administration;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.general_setup.ui_helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Random;

public class DeviceManagerPage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public DeviceManagerPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//*[text()='Device Manager']")
    private WebElement deviceManagerOption;

    public void selectDeviceManagerOption() {
        click(deviceManagerOption);
    }

    @FindBy(xpath = "//a[text()='Add Device']")
    private WebElement addDeviceBtn;

    public void selectAddDeviceBtn() {
        click(addDeviceBtn);
    }

    @FindBy(xpath = "//mat-select[@formcontrolname='deviceTypeControl']")
    private WebElement typeDropdown;

    public void selectTypeDropdown() {
        driverSleep(3000);
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("(//a[@class='c-listview__result ng-star-inserted'])[1]"));
        click(typeDropdown);
    }

    @FindBys({
            @FindBy(xpath = "//mat-option/span")
    })
    private List<WebElement> typeOptions;

    public void selectTypeOption(String option) {
        for (WebElement typeOption : typeOptions) {
            if (getElementText(typeOption).equals(option)) {
                click(typeOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//input[@formcontrolname='deviceNameControl']")
    private WebElement nameField;

    public void fillNameField() {
        type(nameField, "SQA-" + currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='guidControl']")
    private WebElement guidField;

    public void fillGuidField() {
        type(guidField, genNumber(8000, 1000) + "b" + genNumber(89, 10) + "d-"
                + genNumber(899, 100) + "e-" + genNumber(8000, 1000) + "-a"
                + genNumber(9, 0) + "cb-" + genNumber(9, 0) + "c00e"
                + genNumber(8000, 1000) + "e" + genNumber(89, 10));
    }

    public String guidText;

    public String getGuidText() {
        return this.guidText = getElementValue(guidField);
    }

    @FindBy(xpath = "//input[@formcontrolname='tagAddressControl']")
    private WebElement tagAddressField;

    public void fillTagAddressField() {
        type(tagAddressField, genNumber(89, 10) + ":b" + genNumber(9, 0) + ":" + genNumber(89, 10)
                + ":" + genNumber(89, 10) + ":" + genNumber(89, 10) + ":" + genNumber(89, 10));
    }

    @FindBy(xpath = "//input[@formcontrolname='serialNoControl']")
    private WebElement serialNumberField;

    public void fillSerialNumberField() {
        type(serialNumberField, "ATOMHZ00000" + genNumber(89999, 10000));
    }

    public String genNumber(int bound, int count) {
        Random random = new Random();
        int number = random.nextInt(bound) + count;
        return String.valueOf(number);
    }

    @FindBy(xpath = "//p[contains(text(),'New Device has been added')]")
    private WebElement deviceAddMessage;

    public boolean isDisplayedDeviceAddMessage() {
        return isDisplayed(deviceAddMessage);
    }

    public void createDevice(String typeOption) {
        selectAddDeviceBtn();
        selectTypeDropdown();
        selectTypeOption(typeOption);
        fillNameField();
        fillGuidField();
        getGuidText();
        fillTagAddressField();
        fillSerialNumberField();
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement deviceSearchField;

    public void fillDeviceSearchField(String deviceText) {
        driverSleep(1000);
        type(deviceSearchField, deviceText);
    }

    public void reloadBrowser() {
        driver.navigate().refresh();
        driverSleep(1000);
    }

    @FindBy(xpath = "(//a[@class='c-listview__result ng-star-inserted'])[1]")
    private WebElement firstDevice;

    public void selectFirstDevice() {
        click(firstDevice);
    }

    public String afterTagText;
    public String beforeTagText;

    public String getAfterTagText() {
        driverSleep(1000);
        return this.afterTagText = getElementValue(tagAddressField);
    }

    public String getBeforeTagText() {
        return this.beforeTagText = getElementText(tagAddressField);
    }

    @FindBy(xpath = "//p[contains(text(),'Device has been modified')]")
    private WebElement deviceUpdateMessage;

    public boolean isDisplayedDeviceUpdateMessage() {
        return isDisplayed(deviceUpdateMessage);
    }

    public void stopDriver(int number) {
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("//input[@formcontrolname='tagAddressControl']"));
        driverSleep(number);
    }

    @FindBy(xpath = "(//a[@class='c-listview__result'])[1]")
    private WebElement searchedDevice;

    public void selectSearchedDevice() {
        driverSleep(1000);
        click(searchedDevice);
    }

    @FindBy(xpath = "//a[text()=' Disable ']")
    private WebElement disableBtn;

    public void selectDisableBtn() {
        click(disableBtn);
    }

    public boolean isDisplayedDisableBtn() {
        return isDisplayed(disableBtn);
    }

    @FindBy(xpath = "//a[text()=' Enable ']")
    private WebElement enableBtn;

    public void selectEnableBtn() {
        click(enableBtn);
    }

    public boolean isDisplayedEnableBtn() {
        return isDisplayed(enableBtn);
    }


    @FindBy(xpath = "//p[contains(text(),'Device has been enabled')]")
    private WebElement deviceEnableMessage;

    public boolean isDisplayedDeviceEnableMessage() {
        return isDisplayed(deviceEnableMessage);
    }


    @FindBy(xpath = "//p[contains(text(),'Device has been disabled')]")
    private WebElement deviceDisableMessage;

    public boolean isDisplayedDeviceDisableMessage() {
        return isDisplayed(deviceDisableMessage);
    }

}
