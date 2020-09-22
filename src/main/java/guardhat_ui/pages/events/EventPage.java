package guardhat_ui.pages.events;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.general_setup.ui_helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class EventPage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public EventPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//a[@title='Events']")
    private WebElement eventBtn;

    public void selectEventBtn() {
        click(eventBtn);
    }

    @FindBy(xpath = "//select[@type='select']")
    private WebElement eventStatusDropDown;

    public void selectEventStatusDropDown() {
        driverSleep(3000);
        click(eventStatusDropDown);
    }

    @FindBys({
            @FindBy(xpath = "//select[@type='select']//option")
    })
    private List<WebElement> eventStatusOptions;

    public void selectEventStatusOption(String text) {
        for (WebElement eventStatusOption : eventStatusOptions) {
            if (getElementAtt(eventStatusOption, "value").equals(text)) {
                click(eventStatusOption);
                break;
            }
        }
    }

    @FindBy(xpath = "(//div[@class='eventlist__icon'])[1]")
    private WebElement eventIcon;

    public void selectEventIcon() {
        click(eventIcon);
    }

    @FindBy(xpath = "(//*[text()=' SOS alarm '])[1]")
    private WebElement sosAlarmEvent;

    public void selectSosAlarmEvent(){
        click(sosAlarmEvent);
    }

    @FindBy(xpath = "//a[text()=' Close ']")
    private WebElement closeBtn;

    public void selectCloseBtn() {
        click(closeBtn);
    }

    public boolean isNotDisplayedCloseBtn() {
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.xpath("//div[@type='close']"));
        return isNotDisplayed(closeBtn);
    }

    public boolean isDisplayedCloseBtn(){
        return isDisplayed(closeBtn);
    }

    @FindBy(xpath = "//a[text()=' Resolve ']")
    private WebElement resolveBtn;

    public void selectResolveBtn() {
        click(resolveBtn);
    }

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement confirmPopupBtn;

    public void selectConfirmPopupBtn() {
        click(confirmPopupBtn);
    }

    @FindBy(css = ".eventlist__event--resolved")
    private WebElement resolvedElement;

    public boolean isDisplayedResolvedElement() {
        return isDisplayed(resolvedElement);
    }

    public boolean isNotDisplayedResolvedElement() {
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.cssSelector(".eventlist__event--resolved"));
        return isNotDisplayed(resolvedElement);
    }

    @FindBy(xpath = "//button[text()=' Post comment ']")
    private WebElement postCommentBtn;

    public void selectPostCommentBtn() {
        click(postCommentBtn);
    }

    @FindBy(xpath = "//textarea[@class='ng-untouched ng-pristine ng-valid']")
    private WebElement commentsField;

    @FindBy(xpath = "//textarea[contains(@placeholder, 'Type')]")
    private WebElement textFilledField;

    public void fillCommentsField() {
        type(commentsField, "sqa " + currentData());
    }

    public String commentsValueAfter;

    public String getCommentsValue() {
        return this.commentsValueAfter = getElementValue(textFilledField);
    }

    @FindBy(xpath = "//button[text()=' Save comment ']")
    private WebElement saveCommentsBtn;

    public void selectSaveCommentsBtn() {
        click(saveCommentsBtn);
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("//button[text()=' Post comment ']"));
    }

    @FindBy(xpath = "(//div[@class='c-media__meta text--small text--meta']//span)[1]")
    private WebElement beforeCommentsText;

    public String commentsValueBefore;

    public String getCommentsValueBefore() {
        driverSleep(2000);
        return this.commentsValueBefore = getElementText(beforeCommentsText);
    }

    @FindBy(css = ".panel__header-left")
    private WebElement leftPanel;

    public boolean isDisplayedLeftPanel() {
        return isDisplayed(leftPanel);
    }

    public boolean isNotDisplayedLeftPanel() {
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.cssSelector(".panel__header-left"));
        return isNotDisplayed(leftPanel);
    }

    public void refreshBrowser() {
        driver.navigate().refresh();
        driverSleep(300);
    }

    @FindBy(xpath = "(//div[contains(@class, 'eventlist__column c-listview__column')])[4]//text()")
    private WebElement eventTextElement;

    public String eventText;

    public String getEventText() {
        return this.eventText = getElementText(eventTextElement);
    }

    public boolean isEventTextEqual(String text) {
        return this.eventText.contains(text);
    }

    @FindBy(xpath = "(//*[@class='gh-icon icon-EC602'])[1]")
    private WebElement socialDistanceIcon;

    public boolean isDisplayedSocialDistanceIcon() {
        return isDisplayed(socialDistanceIcon);
    }

    @FindBy(xpath = "(//*[@class='gh-icon icon-EG015'])[1]")
    private WebElement deviceInformationIcon;

    public boolean isDisplayedDeviceInformationIcon() {
        return isDisplayed(deviceInformationIcon);
    }

    @FindBy(xpath = "//textarea")
    private WebElement commentsFieldPopup;

    public void fillCommentsFieldPopup() {
        type(commentsFieldPopup, currentData());
    }

    @FindBy(xpath = "//h2[text()='Last five events']")
    private WebElement lastFiveText;

    public boolean isDisplayedLastFiveText() {
        return isDisplayed(lastFiveText);
    }

    @FindBy(xpath = "(//a[@class='eventlist__event event--warning ng-star-inserted'])[1]")
    private WebElement firstEventNonCritical;

    public String firstEventNonCriticalColor;

    public String getFirstEventNonCriticalColor() {
        return this.firstEventNonCriticalColor = getElementCssValue(firstEventNonCritical, "background-color");
    }

    @FindBy(xpath = "(//a[@class='eventlist__event eventlist__event--critical ng-star-inserted'])[1]")
    private WebElement firstCriticalEvent;

    public String firstEventCriticalColor;

    public String getFirstEventCriticalColor() {
        return this.firstEventCriticalColor = getElementCssValue(firstCriticalEvent, "background-color");
    }

    public void driverStop(int time) {
        driverSleep(time);
    }

    @FindBys({
            @FindBy(xpath = "//div[contains(@class, 'eventlist__column c-listview__column')]")
    })
    private List<WebElement> eventElements;

    public void selectEventElement(String text) {
        for (WebElement eventElement : eventElements) {
            if (getElementText(eventElement).equals(text)) {
                click(eventElement);
                break;
            }
        }
    }

    @FindBy(xpath = "//h1[@class='header__title']")
    private WebElement headerTitle;

    public String headerTitleText;

    public String getHeaderTitleText(){
        return this.headerTitleText = getElementText(headerTitle);
    }

    @FindBy(xpath = "//div[@type='call-video']")
    private WebElement videoBtn;

    public boolean isDisplayedVideoBtn(){
        return isNotDisplayed(videoBtn);
    }

    @FindBy(xpath = "//div[@type='callStart']")
    private WebElement audioBtn;

    public boolean isDisplayedAudioBtn(){
        return isNotDisplayed(audioBtn);
    }


}
