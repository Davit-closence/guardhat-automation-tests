package ui;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.pages.devices.WorkersPage;
import guardhat_ui.pages.home_login.LoginPage;

import guardhat_ui.pages.analytics.AnalyticPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnalyticPageTest extends BaseTest{

//SCC-1542
    @Test
    public void verifyOverViewSectionAppear() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        Assert.assertTrue(analyticPage.isDisplayedAnalyticsBarChart(),"Chart is not displayed");
    }

    @Test
    public void verifyKpiReportAppear() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        analyticPage.selectKpiReport();
        Assert.assertTrue(analyticPage.isDisplayedFormGroupElement(),"Form group is not displayed");
        Assert.assertTrue(analyticPage.isDisplayedReportGraph(),"Graph is not displayed");
    }

    @Test
    public void verifyZoneReportAppear() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        analyticPage.selectZoneReportBtn();
        Assert.assertTrue(analyticPage.isDisplayedSelectZoneText(),"Zone text is not displayed");
    }

    @Test
    public void verifyLocationAuditTrailAppear() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        analyticPage.selectAuditTrailReportBtn();
        Assert.assertTrue(analyticPage.isDisplayedAuditTrailText(),"Audit trail label is not displayed");
    }

    @Test
    public void verifyLocationReportAppear() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        analyticPage.selectLocationReportBtn();
        Assert.assertTrue(analyticPage.isDisplayedLocationForText(),"Location for label is not displayed");
    }

    @Test
    public void verifySensorReadingsAppear() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        analyticPage.selectSensorReadingsBtn();
        Assert.assertTrue(analyticPage.isDisplayedSensorSelectedEl(),"Sensor element is not displayed");
    }

    @Test
    public void verifyProximityReportAppear() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        analyticPage.selectProximityReportBtn();
        Assert.assertTrue(analyticPage.isDisplayedProximityForText(),"Proximity text label is not displayed");
    }
    //SCC-1542 $$END$$

    @Test
    public void verifyOverViewChartSection() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        Assert.assertTrue(analyticPage.isDisplayedFirstChart(),"First Chart is not displayed");
        Assert.assertTrue(analyticPage.isDisplayedSecondChart(),"Second Chart is not displayed");
    }

    @Test
    public void verifyOverViewDevicePowerOnOption() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        workersPage.isNotDisplayedProgressBar();
        analyticPage.selectSiteDropDown();
        analyticPage.selectSiteOption("All");
        analyticPage.selectEventTypeDropDown();
        analyticPage.selectEventTypeOption("Device powered on");
        analyticPage.selectSubmitBtn();
        workersPage.isNotDisplayedProgressBar();
        analyticPage.getAnalyticText(" Device powered on ");
        Assert.assertEquals(analyticPage.analyticText," Device powered on "," Device powered on is not equal");
    }

    // SCC-??
    @Test
    public void verifyKpiReportCriticalNumbers() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        analyticPage.selectKpiReport();
        Assert.assertTrue(analyticPage.isDisplayedCriticalEventsNumber(),"Critical Numbers is not displayed");
    }

    @Test
    public void verifyKpiReportNonCriticalNumbers() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        analyticPage.selectKpiReport();
        Assert.assertTrue(analyticPage.isDisplayedNonCriticalEventsNumber(),"Non Critical Numbers is not displayed");
    }

    // SCC-614
    @Test
    public void verifyKpiReportChangeSiteFunctionality() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        workersPage.isNotDisplayedProgressBar();
        analyticPage.selectKpiReport();
        analyticPage.getCriticalNumberTextBefore();
        analyticPage.selectSiteDropDown();
        analyticPage.selectSiteOption("CAT_Ranch_2");
        analyticPage.selectSubmitBtn();
        analyticPage.getCriticalNumberTextAfter();
        Assert.assertNotEquals(analyticPage.criticalNumberTextBefore,analyticPage.criticalNumberTextAfter,"The critical number is equal");
    }

    @Test
    public void verifyKpiReportAverageResolutionNumbers() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        analyticPage.selectKpiReport();
        Assert.assertTrue(analyticPage.isDisplayedAverageResolutionTimeNumber(),"Average resolution Numbers is not displayed");
    }

    // SCC-356
    @Test
    public void verifyOverViewSectionResolveEvent() {
        LoginPage loginPage = new LoginPage();
        AnalyticPage analyticPage = new AnalyticPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        analyticPage.selectAnalyticBtn();
        Assert.assertTrue(analyticPage.isDisplayedAnalyticsBarChart(),"Chart is not displayed");
        analyticPage.selectFirstEvent();
        Assert.assertTrue(analyticPage.isDisplayedResolvedText(),"Resolved test is not displayed");
    }


    // two section in progress
}
