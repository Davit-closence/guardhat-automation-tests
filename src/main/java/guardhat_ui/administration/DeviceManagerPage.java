package guardhat_ui.administration;

import general_setup.BasePage;
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


}
