import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.administration.SystemConfPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SystemConfPageTest extends BaseTest {

    @Test
    public void verifyWorkerDistanceUWBandGPS() {
        LoginPage loginPage = new LoginPage();
        SystemConfPage systemConfPage = new SystemConfPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        systemConfPage.selectAdministrationBtn();
        systemConfPage.selectMyProfileDropDown();
        systemConfPage.selectUserManagerOption();
        systemConfPage.fillUsingUWBField("40");
        systemConfPage.getUWBNumber();
        Assert.assertEquals(systemConfPage.UWBNumber,"40","UWB is not equal");
        systemConfPage.fillUsingGPSField("190");
        systemConfPage.getGPSNumber();
        Assert.assertEquals(systemConfPage.GPSNumber,"190","GPS is not equal");
        systemConfPage.selectSaveBtn();
        Assert.assertTrue(systemConfPage.isDisplayedSavedReportMessage(),"Message is not displayed");
        systemConfPage.reloadPage();
        systemConfPage.getUWBNumber();
        systemConfPage.getGPSNumber();
        Assert.assertEquals(systemConfPage.UWBNumber,"40","UWB is not equal");
        Assert.assertEquals(systemConfPage.GPSNumber,"190","GPS is not equal");
        systemConfPage.fillUsingUWBField("50");
        systemConfPage.fillUsingGPSField("200");
        systemConfPage.getUWBNumber();
        systemConfPage.getGPSNumber();
        systemConfPage.selectSaveBtn();
        systemConfPage.reloadPage();
        Assert.assertEquals(systemConfPage.UWBNumber,"50","UWB is not equal");
        Assert.assertEquals(systemConfPage.GPSNumber,"200","GPS is not equal");
    }
}
