package ui;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.pages.home_login.LoginPage;
import guardhat_ui.pages.administration.DeviceManagerPage;
import guardhat_ui.pages.administration.UserManagerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeviceManagerTest extends BaseTest {

    @Test
    public void verifyAddDeviceFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        DeviceManagerPage deviceManagerPage = new DeviceManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        deviceManagerPage.selectDeviceManagerOption();
        deviceManagerPage.selectAddDeviceBtn();
        deviceManagerPage.selectTypeDropdown();
        deviceManagerPage.selectTypeOption("Mobile Phone");
        deviceManagerPage.fillNameField();
        deviceManagerPage.fillGuidField();
        deviceManagerPage.fillTagAddressField();
        deviceManagerPage.fillSerialNumberField();
        managerPage.selectSaveBtn();
        Assert.assertTrue(deviceManagerPage.isDisplayedDeviceAddMessage(), "Device add message is not displayed");
    }

    @Test
    public void verifyEditDeviceFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        DeviceManagerPage deviceManagerPage = new DeviceManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        deviceManagerPage.selectDeviceManagerOption();
        deviceManagerPage.createDevice("Mobile Phone");
        managerPage.selectSaveBtn();
        Assert.assertTrue(deviceManagerPage.isDisplayedDeviceAddMessage(), "Device add message is not displayed");
        deviceManagerPage.reloadBrowser();
        deviceManagerPage.fillDeviceSearchField(deviceManagerPage.guidText);
        deviceManagerPage.selectSearchedDevice();
        deviceManagerPage.stopDriver(1000);
        managerPage.selectEditBtn();
        deviceManagerPage.getAfterTagText();
        deviceManagerPage.fillTagAddressField();
        managerPage.selectSaveBtn();
        Assert.assertTrue(deviceManagerPage.isDisplayedDeviceUpdateMessage(), "Device update message is not displayed");
        deviceManagerPage.fillDeviceSearchField(deviceManagerPage.guidText);
        deviceManagerPage.selectFirstDevice();
        deviceManagerPage.getBeforeTagText();
        Assert.assertNotEquals(deviceManagerPage.afterTagText, deviceManagerPage.beforeTagText, "Tag address text equal");
    }

    @Test
    public void verifyDeviceEnableDisableFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        DeviceManagerPage deviceManagerPage = new DeviceManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        deviceManagerPage.selectDeviceManagerOption();
        deviceManagerPage.createDevice("Mobile Phone");
        managerPage.selectSaveBtn();
        Assert.assertTrue(deviceManagerPage.isDisplayedDeviceAddMessage(), "Device add message is not displayed");
        deviceManagerPage.reloadBrowser();
        deviceManagerPage.fillDeviceSearchField(deviceManagerPage.guidText);
        deviceManagerPage.selectSearchedDevice();
        deviceManagerPage.stopDriver(1000);
        managerPage.selectEditBtn();
        deviceManagerPage.selectDisableBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(deviceManagerPage.isDisplayedDeviceDisableMessage(),"The device disable message is not displayed");
        Assert.assertTrue(deviceManagerPage.isDisplayedEnableBtn(),"Enable btn is not displayed");
        deviceManagerPage.selectEnableBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(deviceManagerPage.isDisplayedDeviceEnableMessage(),"Device enable message is not displayed");
        Assert.assertTrue(deviceManagerPage.isDisplayedDisableBtn(),"Device disable btn is not displayed");
    }
}
