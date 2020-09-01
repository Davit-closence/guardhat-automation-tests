import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.administration.UserManagerPage;
import guardhat_ui.devices.WorkersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManagerTest extends BaseTest {

    @Test
    public void verifyAddUserFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        managerPage.selectUserManagerOption();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(), "Progress bar is displayed");
        managerPage.selectAddUserBtn();
        managerPage.fillFirstNameField();
        managerPage.fillLastNameField();
        managerPage.fillEmployeeIdField();
        managerPage.fillJobTitleField();
        managerPage.fillPhoneField();
        managerPage.fillEmailField();
        managerPage.selectCompanyGeOption();
        managerPage.selectDepartmentItOption();
        managerPage.selectSiteArmOption();
//        managerPage.selectBuildingBuildOption();
        managerPage.selectNextBtn();
        managerPage.selectHatUserBtn();
        managerPage.fillSipUsernameField();
        managerPage.fillSipPasswordField("sqa12345");
        managerPage.fillConfirmSipPasswordField("sqa12345");
        managerPage.selectSecondNextBtn();
        managerPage.selectAddUserFinishBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(managerPage.isDisplayedUserAddMessage(), "User add message does not display");
    }

    // SCC-1613
    @Test
    public void verifyUserLanguageFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectLanguageDropDown();
        managerPage.selectLanguageOption("Pусский");
        Assert.assertTrue(managerPage.isDisplayedRusChangePassBtn(), "Rus change button is not displayed");
        managerPage.selectRusLanguageDrDw();
        managerPage.selectEnglishOption();
        Assert.assertTrue(managerPage.isDisplayedEnChangePassBtn(), "Change pass btn is not english language");
    }

    // SCC-398
    @Test
    public void verifyMyProfileText() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        Assert.assertTrue(managerPage.isDisplayedUpdateSystemText(), "Update System text is not displayed");
        Assert.assertTrue(managerPage.isDisplayedUserCredentialText(), "User credential text is not displayed");
    }


    // SCC-403
    @Test
    public void verifyUserEnableDisableFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        managerPage.selectUserManagerOption();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(), "Progress bar is displayed");
        managerPage.createHatUser("sqa12345", "sqa12345");
        managerPage.selectCloseBtn();
        managerPage.fillUserSearchField(managerPage.firstNameText + " " + managerPage.lastNameText);
        managerPage.selectFirstIcon();
        managerPage.selectEditBtn();
        managerPage.selectEnableBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(managerPage.isDisplayedUserEnableMessage(), "Enable Message is not displayed");
        managerPage.selectDisableBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(managerPage.isDisplayedUserDisableMessage(), "Disable Message is not displayed");
    }

    // SCC-1612   fix
    @Test
    public void verifyUserSystemUserConfigurationFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        managerPage.selectUserManagerOption();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(), "Progress bar is displayed");
        managerPage.createHatUser("sqa12345", "sqa12345");
        managerPage.selectCloseBtn();
        managerPage.fillUserSearchField(managerPage.firstNameText + " " + managerPage.lastNameText);
        managerPage.selectFirstIcon();
        managerPage.selectEditBtn();
        managerPage.selectDeviceUserCheckbox();
        Assert.assertTrue(managerPage.isDisplayedHatUserCheckbox(), "Hay User checkbox is not displayed");
        managerPage.selectHatUserCheckbox();
        Assert.assertTrue(managerPage.isDisplayedDeviceUserCheckbox(), "Device checkbox is not displayed");
        managerPage.selectSaveBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(managerPage.isDisplayedUpdateMessage(), "Update message is not displayed");
    }

    @Test
    public void verifyUserEditNameCredentialFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        managerPage.selectUserManagerOption();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(), "Progress bar is displayed");
        managerPage.createHatUser("sqa12345", "sqa12345");
        managerPage.selectCloseBtn();
        managerPage.fillUserSearchField(managerPage.firstNameText + " " + managerPage.lastNameText);
        managerPage.selectFirstIcon();
        managerPage.selectEditBtn();
        managerPage.fillFirstNameField();
        managerPage.getBeforeFirstNameText();
        managerPage.fillLastNameField();
        managerPage.getBeforeLastNameText();
        managerPage.selectSaveBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(managerPage.isDisplayedUpdateMessage(), "Update message is not displayed");
        managerPage.reloadPage();
        managerPage.fillUserSearchField(managerPage.beforeFirstNameText + " " + managerPage.beforeLastNameText);
        managerPage.selectFirstIcon();
        Assert.assertTrue(managerPage.isDisplayedPanelPrimary(), "Panel primary class is not displayed");
        managerPage.getAfterFirstNameText();
        managerPage.getAfterLastNameText();
        Assert.assertNotEquals(managerPage.firstNameText, managerPage.afterFirstNameText, "First Name is equal");
        Assert.assertNotEquals(managerPage.lastNameText, managerPage.beforeLastNameText, "Last name text is equal");
    }
}
