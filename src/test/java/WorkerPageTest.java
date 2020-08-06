import guardhat_ui.LoginPage;
import guardhat_ui.devices.WorkersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkerPageTest extends BaseTest {


    // SCC-304
    @Test
    public void verifyWorkersStatusOffline() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectDeviceStatusOption("Offline");
        workersPage.getDeviceStatusText();
        Assert.assertEquals(workersPage.statusText, "Offline");
    }

    @Test
    public void verifyWorkersStatusOnline() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectDeviceStatusOption("Offline");
        workersPage.selectDeviceStatusOption("Online");
        workersPage.getDeviceStatusText();
        Assert.assertEquals(workersPage.statusText, "Online");
    }

    // under SCC-304
    @Test
    public void verifyWorkersRefreshFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectReloadBtn();
        Assert.assertTrue(workersPage.isNotDisplayedFirstDeviceIcon(), "Device icon is displayed");
    }


    // SCC-318
    @Test
    public void verifyWorkersTrackFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        workersPage.selectTrackBtn();
        Assert.assertTrue(workersPage.isDisplayedNowFollowingText(), "The following text is not displayed");
    }

    // SCC-318
    @Test
    public void verifyWorkersStopTrackFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
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
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectDeviceStatusOption("No device");
        Assert.assertTrue(workersPage.isNotDisplayedFirstDeviceIcon(), "Device icon is displayed");
    }

    // SCC-1023
    @Test
    public void verifyWorkersSensorTextFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        Assert.assertTrue(workersPage.isDisplayedSensorReadingsText(), "Sensor readings text is not display");
    }

    // SCC-1689
    @Test
    public void verifyWorkersCloseFunctionality() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
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
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        Assert.assertTrue(workersPage.isDisplayedSensorReadingsText(), "Sensor readings text is not display");
        workersPage.selectFirstDeviceIcon();
        Assert.assertTrue(workersPage.isNotDisplayedSensorReadingsText(), "Sensor reading text is displayed");
    }

    // SCC-301
    @Test
    public void verifyWorkersStatusAll() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectDeviceStatusOption("All");
        workersPage.getStatusArray("Offline");
        Assert.assertEquals(workersPage.workerStatusText, "Offline");
//        workersPage.getStatusArray("Online");
//        Assert.assertEquals(workersPage.workerStatusText, "Online");
        // in progress
    }

    // SCC-307
    @Test
    public void verifyWorkersGeneralWebElement() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectFirstDeviceIcon();
        Assert.assertTrue(workersPage.isDisplayedSensorReadingsText(),"Sensor text does not display");
        Assert.assertTrue(workersPage.isDisplayedTrackBtn(),"Tracker btn is not displayed");
        Assert.assertTrue(workersPage.isDisplayedVideoCallBtn(),"Video call btn is not displayed");
        Assert.assertTrue(workersPage.isDisplayedCallAudioBtn(),"Audio call btn is not displayed");
        Assert.assertTrue(workersPage.isDisplayedTextBtn(),"Send message btn is not displayed");
        // in progress
    }

    // SCC-305
    @Test
    public void verifyWorkersStatusMia() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectDeviceStatusOption("MIA");
        workersPage.getStatusArray("MIA");
        Assert.assertEquals(workersPage.workerStatusText, "MIA");
    }

    @Test
    public void verifyWorkersActiveDeviceCount() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.getDeviceCountAfterRefresh();
        workersPage.selectReloadBtn();
        workersPage.getDeviceCountBeforeRefresh();
        Assert.assertEquals(workersPage.deviceCountAfterRefresh,workersPage.deviceCountBeforeRefresh,"Device count is not equal");
    }

    @Test
    public void verifyWorkersMiaDeviceCount() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard("davit", "guardhat2020");
        workersPage.selectDevicesBtn();
        workersPage.selectDeviceStatusOption("MIA");
        workersPage.getDeviceCountAfterRefresh();
        workersPage.selectReloadBtn();
        workersPage.getDeviceCountBeforeRefresh();
        Assert.assertEquals(workersPage.deviceCountAfterRefresh,workersPage.deviceCountBeforeRefresh,"Device count is not equal");
    }



}
