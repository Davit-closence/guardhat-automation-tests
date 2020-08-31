package guardhat_ui;

import general_setup.BasePage;
import guardhat_ui.administration.AboutPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public HomePage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//div[text()='Active']")
    private WebElement activeBtn;

    public void selectActiveBtn() {
        click(activeBtn);
    }

    @FindBy(xpath = "//div[text()='MIA']")
    private WebElement miaBtn;

    public void selectMiaBtn() {
        click(miaBtn);
    }

    @FindBy(xpath = "//div[text()='Critical']")
    private WebElement criticalBtn;

    public void selectCriticalBtn() {
        click(criticalBtn);
    }

    @FindBy(xpath = "//span[text()=' Total events ']")
    private WebElement totalEventsText;

    public boolean isDisplayedTotalEventsText() {
        return isDisplayed(totalEventsText);
    }

    @FindBy(xpath = "//div[text()='Non-critical']")
    private WebElement nonCriticalBtn;

    public void selectNonCriticalBtnBtn() {
        click(criticalBtn);
    }


    @FindBy(xpath = "//div[text()='Geofence']")
    private WebElement geofenceBtn;

    public void selectGeofenceBtn() {
        click(geofenceBtn);
    }

    @FindBy(xpath = "//a[text()='New Zone']")
    private WebElement newZoneBtn;

    public boolean isDisplayedNewZoneBtn() {
        return isDisplayed(newZoneBtn);
    }


    @FindBy(xpath = "//div[text()='Evacuation']")
    private WebElement evacuationBtn;

    public void selectEvacuationBtn() {
        click(evacuationBtn);
    }

    @FindBy(xpath = "(//div[@class='c-global__stats']//div)[1]")
    private WebElement actDevCountNavBar;

    public String actDevCountNavBarNumber;

    public String getActDevCountNavBarNumber() {
        driverSleep(1000);
        this.actDevCountNavBarNumber = getElementText(actDevCountNavBar);
        return this.actDevCountNavBarNumber.trim();
    }

    @FindBy(xpath = "(//div[@class='c-global__stats']//div)[2]")
    private WebElement miaDevCountNavBar;

    public String miaDevCountNavBarNumber;

    public String getMiaDevCountNavBarNumber() {
        this.miaDevCountNavBarNumber = getElementText(miaDevCountNavBar);
        return this.miaDevCountNavBarNumber.trim();
    }

    @FindBy(xpath = "//div[@class='o-media__figure summary__count']")
    private WebElement actDevSummary;

    public String actDevSummaryNumber;

    public String getActDevSummaryNumber() {
        this.actDevSummaryNumber = getElementText(actDevSummary);
        return this.actDevSummaryNumber.trim();
    }

    @FindBy(xpath = "(//div[@class='media-left summary__count'])[1]")
    private WebElement miaDevSummary;

    public String miaDevSummaryNumber;

    public String getMiaDevSummaryNumber() {
        this.miaDevSummaryNumber = getElementText(miaDevSummary);
        return this.miaDevSummaryNumber.trim();
    }



}
