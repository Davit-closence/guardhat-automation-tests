package ui;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.pages.home_login.LoginPage;
import guardhat_ui.pages.administration.SystemConfPage;
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
        Assert.assertTrue(systemConfPage.isDisplayedSavedReportMessage_1(),"Message is not displayed");
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

    @Test
    public void verifySystemConfUserTrackerCheckboxFunctionality() {
        LoginPage loginPage = new LoginPage();
        SystemConfPage systemConfPage = new SystemConfPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        systemConfPage.selectAdministrationBtn();
        systemConfPage.selectMyProfileDropDown();
        systemConfPage.selectUserManagerOption();
        systemConfPage.selectUserTrackerCheckbox();
        systemConfPage.selectSaveBtn();
        Assert.assertTrue(systemConfPage.isDisplayedSavedReportMessage_1(),"Message is not displayed");
        systemConfPage.getUserTrackerCheckboxAttribute();
        Assert.assertEquals(systemConfPage.userTrackerCheckboxAttribute,systemConfPage.ngDirty,"Check uncheck attribute is not equal");
        systemConfPage.selectUserTrackerCheckbox();
        systemConfPage.selectSaveBtn();
        Assert.assertTrue(systemConfPage.isDisplayedSavedReportMessage_1(),"Message is not displayed");
    }

    @Test
    public void verifySystemConfDeviceStyleCheckboxFunctionality() {
        LoginPage loginPage = new LoginPage();
        SystemConfPage systemConfPage = new SystemConfPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        systemConfPage.selectAdministrationBtn();
        systemConfPage.selectMyProfileDropDown();
        systemConfPage.selectUserManagerOption();
        systemConfPage.selectDeviceStyleCheckbox();
        systemConfPage.selectSaveBtn();
        Assert.assertTrue(systemConfPage.isDisplayedSavedReportMessage_1(),"Message is not displayed");
        systemConfPage.getDeviceStyleCheckboxAttribute();
        Assert.assertEquals(systemConfPage.deviceStyleCheckboxAttribute,systemConfPage.ngDirty,"Check uncheck attribute is not equal");
        systemConfPage.selectDeviceStyleCheckbox();
        systemConfPage.selectSaveBtn();
        Assert.assertTrue(systemConfPage.isDisplayedSavedReportMessage_1(),"Message is not displayed");
    }

    @Test
    public void verifySystemConfInfoMessageCheckboxFunctionality() {
        LoginPage loginPage = new LoginPage();
        SystemConfPage systemConfPage = new SystemConfPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        systemConfPage.selectAdministrationBtn();
        systemConfPage.selectMyProfileDropDown();
        systemConfPage.selectUserManagerOption();
        systemConfPage.selectShowInfoMessagesCheckbox();
        systemConfPage.selectSaveBtn();
        Assert.assertTrue(systemConfPage.isDisplayedSavedReportMessage_1(),"Message is not displayed");
        systemConfPage.getShowInfoMessagesCheckboxAttribute();
        Assert.assertEquals(systemConfPage.showInfoMessagesCheckboxAttribute,systemConfPage.ngDirty,"Check uncheck attribute is not equal");
        systemConfPage.selectShowInfoMessagesCheckbox();
        systemConfPage.selectSaveBtn();
        Assert.assertTrue(systemConfPage.isDisplayedSavedReportMessage_1(),"Message is not displayed");
    }
}
