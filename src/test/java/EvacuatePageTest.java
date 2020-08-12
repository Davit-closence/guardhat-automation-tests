import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.evacuate.EvacuatePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EvacuatePageTest extends BaseTest {

    @Test
    public void verifyEvacuationPopupAppear() {
        LoginPage loginPage = new LoginPage();
        EvacuatePage evacuatePage = new EvacuatePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        evacuatePage.selectEvacuateBtn();
        Assert.assertTrue(evacuatePage.isDisplayedEvacuationPopup(),"Evacuation popup is not displayed");
    }

    @Test
    public void verifyEvacuationCloseBtnFunctionality() {
        LoginPage loginPage = new LoginPage();
        EvacuatePage evacuatePage = new EvacuatePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        evacuatePage.selectEvacuateBtn();
        evacuatePage.selectClosePopupBtn();
        Assert.assertTrue(evacuatePage.isNotDisplayedEvacuationPopup(),"Evacuation popup is displayed");
    }

    @Test
    public void verifyEvacuationCancelBtnFunctionality() {
        LoginPage loginPage = new LoginPage();
        EvacuatePage evacuatePage = new EvacuatePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        evacuatePage.selectEvacuateBtn();
        evacuatePage.selectCancelBtn();
        Assert.assertTrue(evacuatePage.isNotDisplayedEvacuationPopup(),"Evacuation popup is displayed");
    }

    @Test
    public void verifyEvacuationEmptyFunctionality() {
        LoginPage loginPage = new LoginPage();
        EvacuatePage evacuatePage = new EvacuatePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        evacuatePage.selectEvacuateBtn();
        evacuatePage.selectEvacuatePopupBtn();
        Assert.assertTrue(evacuatePage.isDisplayedDismissBtn(),"Dismiss btn is not displayed");
    }

    // SCC-439
    @Test
    public void verifyEvacuationFunctionality() {
        LoginPage loginPage = new LoginPage();
        EvacuatePage evacuatePage = new EvacuatePage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        evacuatePage.selectEvacuateBtn();
        evacuatePage.selectSiteDropDown();
        evacuatePage.selectEvacuationOption("CAT_Ranch_2");
        evacuatePage.selectBuildingDropDown();
        evacuatePage.selectEvacuationOption("MO-AC");
        evacuatePage.selectFloorsDropDown();
        evacuatePage.selectEvacuationOption("Floor 0");
        evacuatePage.selectEvacuatePopupBtn();
        Assert.assertTrue(evacuatePage.isNotDisplayedEvacuationPopup(),"Evacuation popup is displayed");
    }
}
