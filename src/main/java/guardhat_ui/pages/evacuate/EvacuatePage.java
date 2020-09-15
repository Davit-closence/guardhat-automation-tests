package guardhat_ui.pages.evacuate;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.general_setup.ui_helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class EvacuatePage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public EvacuatePage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//a[@title='Evacuate']")
    private WebElement evacuateBtn;

    public void selectEvacuateBtn() {
        click(evacuateBtn);
    }

    @FindBy(xpath = "//div[@class='cdk-overlay-pane']")
    private WebElement evacuationPopup;

    public boolean isDisplayedEvacuationPopup() {
        return isDisplayed(evacuationPopup);
    }

    public boolean isNotDisplayedEvacuationPopup() {
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.xpath("//div[@class='cdk-overlay-pane']"));
        return isNotDisplayed(evacuationPopup);
    }

    @FindBy(xpath = "//a[@class='c-actions__navlink']")
    private WebElement closePopupBtn;

    public void selectClosePopupBtn() {
        click(closePopupBtn);
    }

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement cancelBtn;

    public void selectCancelBtn() {
        click(cancelBtn);
    }

    @FindBy(xpath = "//div[@class='dismiss_container']")
    private WebElement dismissBtn;

    public boolean isDisplayedDismissBtn() {
        return isDisplayed(dismissBtn);
    }

    @FindBy(xpath = "//button[text()='Evacuate']")
    private WebElement evacuatePopupBtn;

    public void selectEvacuatePopupBtn() {
        click(evacuatePopupBtn);
    }

    @FindBy(xpath = "(//div[@class='mat-select-arrow-wrapper'])[1]")
    private WebElement siteDropDown;

    public void selectSiteDropDown(){
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("//div[@class='cdk-overlay-pane']"));
        driverSleep(5000);
        click(siteDropDown);
    }

    @FindBys({
            @FindBy(xpath = "//mat-option[@role='option']")
    })
    private List<WebElement> evacuationOptions;

    public void selectEvacuationOption(String text) {
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("(//div[@class='cdk-overlay-pane'])[2]"));
        driverSleep(100);
        for (WebElement evacuationOption : evacuationOptions) {
            if (getElementText(evacuationOption).equals(text)) {
                click(evacuationOption);
                break;
            }
        }
    }


    @FindBy(xpath = "(//div[@class='mat-select-arrow-wrapper'])[2]")
    private WebElement buildingDropDown;

    public void selectBuildingDropDown(){
        driverSleep(3000);
        click(buildingDropDown);
    }

    @FindBy(xpath = "(//div[@class='mat-select-arrow-wrapper'])[3]")
    private WebElement floorsDropDown;

    public void selectFloorsDropDown(){
        driverSleep(3000);
        click(floorsDropDown);
    }

}
