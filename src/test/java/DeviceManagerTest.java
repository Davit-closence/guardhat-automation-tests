import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.administration.DeviceManagerPage;
import guardhat_ui.administration.UserManagerPage;
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
    }
}
