import general_setup.BasePage;
import guardhat_ui.HomePage;
import guardhat_ui.LoginPage;
import guardhat_ui.devices.WorkersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    //SCC-442  SCC-261
    @Test
    public void verifyHomeActiveMiaCount() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        homePage.getActDevCountNavBarNumber();
        homePage.getActDevSummaryNumber();
        Assert.assertEquals(homePage.actDevCountNavBarNumber,homePage.actDevSummaryNumber,"Active device count is not equal");
        homePage.getMiaDevCountNavBarNumber();
        homePage.getMiaDevSummaryNumber();
        Assert.assertEquals(homePage.miaDevCountNavBarNumber,homePage.miaDevSummaryNumber,"MIA device count is not equal");

    }

    //SCC-499
    @Test
    public void verifyHomeActiveBtn() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        homePage.selectActiveBtn();
        workersPage.getStatusArray("Active");
        Assert.assertEquals(workersPage.workerStatusText, "Active");
    }

    //SCC-499
    @Test
    public void verifyHomeMiaBtn() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        homePage.selectMiaBtn();
        workersPage.getStatusArray("MIA");
        Assert.assertEquals(workersPage.workerStatusText, "MIA");
    }

    @Test
    public void verifyHomeCriticalBtn() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        homePage.selectCriticalBtn();
        Assert.assertTrue(homePage.isDisplayedTotalEventsText(),"Total events text is not displayed");
    }

    @Test
    public void verifyHomeNonCriticalBtn() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        homePage.selectNonCriticalBtnBtn();
        Assert.assertTrue(homePage.isDisplayedTotalEventsText(),"Total events text is not displayed");
    }

    @Test
    public void verifyHomeGeofenceBtn() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        homePage.selectGeofenceBtn();
        Assert.assertTrue(homePage.isDisplayedNewZoneBtn(),"New Zone btn is not displayed");
    }

    // SCC-439
    @Test
    public void verifyHomeEvacuationBtn() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        homePage.selectEvacuationBtn();
        Assert.assertTrue(homePage.isDisplayedNewZoneBtn(),"New Zone btn is not displayed");
    }
}
