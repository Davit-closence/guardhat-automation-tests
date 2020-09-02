package ui;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.pages.home_login.LoginPage;
import guardhat_ui.pages.devices.WorkersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkerPageTest extends BaseTest {


    // SCC-304
    @Test
    public void verifyWorkersStatusOffline() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.selectDeviceStatusDropDown();
        workersPage.selectDeviceStatusOption("Offline");
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.getDeviceStatusText();
        Assert.assertEquals(workersPage.statusText, "Offline","Status is not equal");
    }

    // SCC-304
    @Test
    public void verifyWorkersStatusOnline() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.selectDeviceStatusDropDown();
        workersPage.selectDeviceStatusOption("Offline");
        workersPage.selectDeviceStatusDropDown();
        workersPage.selectDeviceStatusOption("Online");
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.getDeviceStatusText();
        Assert.assertEquals(workersPage.statusText, "Online");
    }

    // SCC-305
    @Test
    public void verifyWorkersStatusMia() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.selectDeviceStatusDropDown();
        workersPage.selectDeviceStatusOption("MIA");
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.getStatusArray("MIA");
        Assert.assertEquals(workersPage.workerStatusText, "MIA");
    }

    @Test
    public void verifyWorkersRefreshFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.selectReloadBtn();
        Assert.assertTrue(workersPage.isNotDisplayedFirstDeviceIcon(), "Device icon is displayed");
    }


    // SCC-318
    @Test
    public void verifyWorkersTrackFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        workersPage.selectTrackBtn();
        Assert.assertTrue(workersPage.isDisplayedNowFollowingText(), "The following text is not displayed");
    }

    // SCC-456
    @Test
    public void verifyWorkersTrackTBtnFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        workersPage.selectTrackBtn();
        Assert.assertTrue(workersPage.isDisplayedNowFollowingText(), "The following text is not displayed");
        workersPage.selectTBtn();
        workersPage.selectFirstDeviceIcon();
        Assert.assertTrue(workersPage.isDisplayedTrackBtn(), "Trace btn does not display");
    }

    // SCC-318
    @Test
    public void verifyWorkersStopTrackFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        workersPage.selectTrackBtn();
        Assert.assertTrue(workersPage.isDisplayedNowFollowingText(), "The following text is not displayed");
        workersPage.selectFirstDeviceIcon();
        workersPage.selectStopTrackerBtn();
        Assert.assertTrue(workersPage.isDisplayedTrackBtn(), "Trace btn does not display");
    }

    // SCC-621
    @Test
    public void verifyWorkersStatusNoDevice() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.selectDeviceStatusDropDown();
        workersPage.selectDeviceStatusOption("No device");
        Assert.assertTrue(workersPage.isNotDisplayedFirstDeviceIcon(), "Device icon is displayed");
    }

    // SCC-1023
    @Test
    public void verifyWorkersSensorTextFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        Assert.assertTrue(workersPage.isDisplayedSensorReadingsText(), "Sensor readings text is not display");
        Assert.assertTrue(workersPage.isDisplayedLocationDetails(),"Location details is not displayed");
    }

    // SCC-1689
    @Test
    public void verifyWorkersCloseFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        workersPage.selectCloseBtn();
        Assert.assertTrue(workersPage.isNotDisplayedSensorReadingsText(), "Sensor reading text is displayed");
    }

    // SCC-477
    @Test
    public void verifyWorkersDeviceUnselectFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        Assert.assertTrue(workersPage.isDisplayedSensorReadingsText(), "Sensor readings text is not display");
        workersPage.selectFirstDeviceIcon();
        Assert.assertTrue(workersPage.isNotDisplayedSensorReadingsText(), "Sensor reading text is displayed");
    }

    // SCC-307
    @Test
    public void verifyWorkersGeneralWebElement() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        Assert.assertTrue(workersPage.isDisplayedSensorReadingsText(),"Sensor text does not display");
        Assert.assertTrue(workersPage.isDisplayedTrackBtn(),"Tracker btn is not displayed");
        Assert.assertTrue(workersPage.isDisplayedVideoCallBtn(),"Video call btn is not displayed");
        Assert.assertTrue(workersPage.isDisplayedCallAudioBtn(),"Audio call btn is not displayed");
        Assert.assertTrue(workersPage.isDisplayedTextBtn(),"Send message btn is not displayed");
    }


    @Test
    public void verifyWorkersActiveDeviceCount() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.getActiveDeviceCountAfterRefresh();
        workersPage.selectReloadBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.getActiveDeviceCountBeforeRefresh();
        Assert.assertEquals(workersPage.activeDeviceCountAfterRefresh,workersPage.activeDeviceCountBeforeRefresh,"Device count is not equal");
    }

    @Test
    public void verifyWorkersMiaDeviceCount() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        workersPage.selectDevicesBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.selectDeviceStatusDropDown();
        workersPage.selectDeviceStatusOption("MIA");
        workersPage.getDeviceCountAfterRefresh();
        System.out.println(workersPage.deviceCountAfterRefresh);
        workersPage.selectReloadBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        workersPage.getDeviceCountBeforeRefresh();
        System.out.println(workersPage.deviceCountBeforeRefresh);
        Assert.assertEquals(workersPage.deviceCountAfterRefresh,workersPage.deviceCountBeforeRefresh,"Device count is not equal");
    }



}
