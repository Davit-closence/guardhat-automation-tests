import guardhat_ui.HomePage;
import guardhat_ui.LoginPage;
import guardhat_ui.devices.WorkersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    //SCC-499
    @Test
    public void verifyHomeActiveBtn() {
        LoginPage loginPage = new LoginPage();
        WorkersPage workersPage = new WorkersPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard("davit", "guardhat2020");
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
        loginPage.loginGuard("davit", "guardhat2020");
        homePage.selectMiaBtn();
        workersPage.getStatusArray("MIA");
        Assert.assertEquals(workersPage.workerStatusText, "MIA");
    }

    @Test
    public void verifyHomeCriticalBtn() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard("davit", "guardhat2020");
        homePage.selectCriticalBtn();
        Assert.assertTrue(homePage.isDisplayedTotalEventsText(),"Total events text is not displayed");
    }

    @Test
    public void verifyHomeNonCriticalBtn() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard("davit", "guardhat2020");
        homePage.selectNonCriticalBtnBtn();
        Assert.assertTrue(homePage.isDisplayedTotalEventsText(),"Total events text is not displayed");
    }

    @Test
    public void verifyHomeGeofenceBtn() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard("davit", "guardhat2020");
        homePage.selectGeofenceBtn();
        Assert.assertTrue(homePage.isDisplayedNewZoneBtn(),"New Zone btn is not displayed");
    }

    @Test
    public void verifyHomeEvacuationBtn() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginGuard("davit", "guardhat2020");
        homePage.selectEvacuationBtn();
        Assert.assertTrue(homePage.isDisplayedNewZoneBtn(),"New Zone btn is not displayed");
    }
}