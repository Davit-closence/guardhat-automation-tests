package guardhat_ui.analytics;

import general_setup.BasePage;
import general_setup.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AnalyticPage extends BasePage {
    @Override
    public String getUrl() {
        return "https://ddd2.guardhat.io";
    }

    public AnalyticPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//a[@title='Analytics']")
    private WebElement analyticBtn;

    public void selectAnalyticBtn() {
        click(analyticBtn);
    }

    @FindBy(xpath = "//div[@type='analytics']")
    private WebElement analyticsBarChart;

    public boolean isDisplayedAnalyticsBarChart() {
        return isDisplayed(analyticsBarChart);
    }

    @FindBy(xpath = "//a[text()='KPI Report']")
    private WebElement kpiReportBtn;

    public void selectKpiReport() {
        click(kpiReportBtn);
    }

    @FindBy(xpath = "(//div[@class='row form-group'])[1]")
    private WebElement formGroupElement;

    public boolean isDisplayedFormGroupElement() {
        return isDisplayed(formGroupElement);
    }

    @FindBy(xpath = "//a[text()='Zone Report']")
    private WebElement zoneReportBtn;

    @FindBy(xpath = "//h4[text()='Select Zone']")
    private WebElement selectZoneText;

    public void selectZoneReportBtn() {
        click(zoneReportBtn);
    }

    public boolean isDisplayedSelectZoneText() {
        return isDisplayed(selectZoneText);
    }

    @FindBy(xpath = "//a[text()='Location Report']")
    private WebElement locationReportBtn;

    @FindBy(xpath = "//label[text()='Location For']")
    private WebElement locationForText;

    public void selectLocationReportBtn() {
        click(locationReportBtn);
    }

    public boolean isDisplayedLocationForText() {
        return isDisplayed(locationForText);
    }

    @FindBy(xpath = "//a[text()='Audit Trail Report']")
    private WebElement auditTrailReportBtn;

    @FindBy(xpath = "//label[text()='Audit Trail']")
    private WebElement auditTrailText;

    public void selectAuditTrailReportBtn() {
        click(auditTrailReportBtn);
    }

    public boolean isDisplayedAuditTrailText() {
        return isDisplayed(auditTrailText);
    }


    @FindBy(xpath = "//a[text()='Sensor readings']")
    private WebElement sensorReadingsBtn;

    public void selectSensorReadingsBtn() {
        click(sensorReadingsBtn);
    }


    @FindBy(xpath = "//a[text()='Proximity Report']")
    private WebElement proximityReportBtn;

    @FindBy(xpath = "//label[text()='Proximity For']")
    private WebElement proximityForText;

    public void selectProximityReportBtn() {
        click(proximityReportBtn);
    }

    public boolean isDisplayedProximityForText() {
        return isDisplayed(proximityForText);
    }

    @FindBy(xpath = "(//h1[@class=' text-center text-nowrap'])[1]")
    private WebElement criticalEventsNumber;

    public boolean isDisplayedCriticalEventsNumber() {
        return isDisplayed(criticalEventsNumber);
    }

    @FindBy(xpath = "(//h1[@class=' text-center text-nowrap'])[2]")
    private WebElement nonCriticalEventsNumber;

    public boolean isDisplayedNonCriticalEventsNumber() {
        return isDisplayed(nonCriticalEventsNumber);
    }

    @FindBy(xpath = "(//h1[@class=' text-center text-nowrap'])[3]")
    private WebElement averageResolutionTimeNumber;

    public boolean isDisplayedAverageResolutionTimeNumber() {
        return isDisplayed(averageResolutionTimeNumber);
    }

    @FindBy(xpath = "//select[@id='location']")
    private WebElement siteDropDown;

    public void selectSiteDropDown() {
        click(siteDropDown);
    }

    @FindBys({
            @FindBy(xpath = "//select[@id='location']/option")
    })
    private List<WebElement> siteOptions;

    public void selectSiteOption(String text) {
        for (WebElement siteOption : siteOptions) {
            if (getElementText(siteOption).equals(text)) {
                click(siteOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//select[@id='worker']")
    private WebElement workerDropDown;

    public void selectWorkerDropDown() {
        click(workerDropDown);
    }

    @FindBys({
            @FindBy(xpath = "//select[@id='worker']/option")
    })
    private List<WebElement> workerOptions;

    public void selectWorkerOption(String text) {
        for (WebElement workerOption : workerOptions) {
            if (getElementText(workerOption).equals(text)) {
                click(workerOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//select[@id='eventType']")
    private WebElement eventTypeDropDown;

    public void selectEventTypeDropDown() {
        click(eventTypeDropDown);
    }

    @FindBys({
            @FindBy(xpath = "//select[@id='eventType']/option")
    })
    private List<WebElement> eventTypeOptions;

    public void selectEventTypeOption(String text) {
        for (WebElement eventTypeOption : eventTypeOptions) {
            if (getElementText(eventTypeOption).equals(text)) {
                click(eventTypeOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    public void selectSubmitBtn() {
        click(submitBtn);
    }

    @FindBys({
            @FindBy(xpath = "//div[contains(@class, 'eventlist__column c-listview__column')]//text()")
    })
    private List<WebElement> analyticElementTexts;

    public String analyticText;

    public String getAnalyticText(String text){
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("//div[@class='uploader-status ng-star-inserted']"));
        WaitHelper.getWait().waitForElementToBeInVisible
                (By.xpath("//div[@class='uploader-status ng-star-inserted']"));
        driverSleep(300);
        for (WebElement analyticElementText: analyticElementTexts){
            if (getElementText(analyticElementText).equals(text)){
                break;
            }
        }
        return this.analyticText = text;
    }

    @FindBy(xpath = "//div[@class='uploader-status ng-star-inserted']")
    private WebElement loadingElement;
}