package guardhat_ui.events;

import general_setup.BasePage;
import general_setup.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class EventPage extends BasePage {
    @Override
    public String getUrl() {
        return "https://ddd2.guardhat.io/";
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
        click(eventStatusDropDown);
    }

    @FindBys({
            @FindBy(xpath = "//select[@type='select']//option")
    })
    private List<WebElement> eventStatusOptions;

    public void selectEventStatusOption(String text) {
        for (WebElement eventStatusOption : eventStatusOptions) {
            if (getElementText(eventStatusOption).equals(text)) {
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

    public String getCommentsValue(){
        return this.commentsValueAfter = getElementValue(textFilledField);
    }

    @FindBy(xpath = "//button[text()=' Save comment ']")
    private WebElement saveCommentsBtn;

    public void selectSaveCommentsBtn(){
        click(saveCommentsBtn);
    }

    @FindBy(xpath = "(//div[@class='c-media__meta text--small text--meta']//span)[1]")
    private WebElement beforeCommentsText;

    public String commentsValueBefore;

    public String getCommentsValueBefore(){
        driverSleep(500);
        return this.commentsValueBefore = getElementText(beforeCommentsText);
    }
}