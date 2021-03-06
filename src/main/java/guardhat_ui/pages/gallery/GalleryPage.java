package guardhat_ui.pages.gallery;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.general_setup.ui_helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class GalleryPage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public GalleryPage() {
        super();
        driver.get(getUrl());
    }


    @FindBy(xpath = "//a[@title='Gallery']")
    private WebElement galleryBtn;

    public void selectGalleryBtn() {
        click(galleryBtn);
    }

    public void driverStop(int time){
        driverSleep(time);
    }

    @FindBy(xpath = "//div[@type='reload']")
    private WebElement reloadBtn;

    public void selectReloadBtn() {
        click(reloadBtn);
    }

    public boolean isDisplayedReloadBtn(){
        return isDisplayed(reloadBtn);
    }

    @FindBy(xpath = "//mat-progress-bar[@role='progressbar']")
    private WebElement progressBarElement;

    public boolean isDisplayedProgressBarElement() {
        return isDisplayed(progressBarElement);
    }

    @FindBy(xpath = "//select[@type='select']")
    private WebElement mediaDropDown;

    public void selectMediaDropDown() {
        click(mediaDropDown);
    }

    @FindBys({
            @FindBy(xpath = "//select[@type='select']/option")
    })
    private List<WebElement> mediaOptions;

    public void selectMediaOption(String option) {
        for (WebElement mediaOption : mediaOptions) {
            if (getElementAtt(mediaOption,"value").equals(option)) {
                click(mediaOption);
                break;
            }
        }
    }

    @FindBy(xpath = "(//div[@class='c-summary']//span)[1]")
    private WebElement mediaFileNumber;

    public String mediaFileNumberTextBefore;

    public String getMediaFileNumberTextBefore() {
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("//mat-progress-bar[@role='progressbar']"));
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.xpath("//mat-progress-bar[@role='progressbar']"));
        driverSleep(500);
        return this.mediaFileNumberTextBefore = getElementText(mediaFileNumber);
    }

    public String mediaFileNumberTextAfter;

    public String getMediaFileNumberTextAfter() {
//        WaitHelper.getWait().waitForElementToBeVisible
//                (By.xpath("//mat-progress-bar[@role='progressbar']"));
//        WaitHelper.getWait().waitForElementToBeInVisible
//                (By.xpath("//mat-progress-bar[@role='progressbar']"));
        driverSleep(1000);
        return this.mediaFileNumberTextAfter = getElementText(mediaFileNumber);
    }

    @FindBy(xpath = "(//a[@class='o-grid__item ng-star-inserted'])[1]")
    private WebElement firstFile;

    public void selectFirstFile() {
        click(firstFile);
    }

    @FindBy(xpath = "//div[@type='close']")
    private WebElement closeBtn;

    public void selectCloseBtn() {
        click(closeBtn);
    }

    @FindBy(xpath = "//a[@class='o-grid__item ng-star-inserted o-grid__item--selected']")
    private WebElement selectedMediaSection;

    public boolean isNotDisplayedSelectedMediaSection() {
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.xpath("//a[@class='o-grid__item ng-star-inserted o-grid__item--selected']"));
        return isNotDisplayed(selectedMediaSection);
    }

    @FindBy(xpath = "//div[@type='geofence-end']")
    private WebElement deleteBtn;

    public void selectDeleteBtn() {
        click(deleteBtn);
    }

    @FindBy(xpath = "//button[@class='o-btn c-btn--success']")
    private WebElement confirmBtn;

    public void selectConfirmBtn() {
        click(confirmBtn);
    }

    @FindBy(xpath = "//*[contains(text(),'Media successfully deleted')]")
    private WebElement successMessage;

    public boolean isNotDisplayedSuccessMessage(){
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.xpath("//*[contains(text(),'Media successfully deleted')]"));
        return isNotDisplayed(successMessage);
    }

    public boolean isDisplayedSuccessMessage(){
        return isDisplayed(successMessage);
    }

    @FindBy(xpath = "//img[@alt='user profile image']")
    private WebElement userProfileImage;

    public boolean isDisplayedUserProfileImage(){
        return isDisplayed(userProfileImage);
    }

    @FindBy(xpath = "//div[@class='c-admin-battery']")
    private WebElement deviceBatteryElement;

    public boolean isDisplayedDeviceBatteryElement(){
        return isDisplayed(deviceBatteryElement);
    }

    @FindBy(xpath = "//span[@class='text-bold']")
    private WebElement devicePercentage;

    public boolean isDisplayedDevicePercentage(){
        return isDisplayed(devicePercentage);
    }

    @FindBy(xpath = "//h2[@class='panel__title']")
    private WebElement panelTitle;

    public boolean isDisplayedPanelTitle(){
        return isDisplayed(panelTitle);
    }

    @FindBy(xpath = "//canvas[@class]")
    private WebElement miniMap;

    public boolean isDisplayedMiniMap(){
        return isDisplayed(miniMap);
    }

    @FindBy(xpath = "(//img[@alt='related Media thumbnail'])[1]")
    private WebElement relatedFile;

    public boolean isDisplayedRelatedFile(){
        return isDisplayed(relatedFile);
    }
}
