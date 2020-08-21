import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.administration.UserManagerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManagerTest extends BaseTest {

    @Test
    public void verifyAddUserFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        managerPage.selectUserManagerOption();
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
        managerPage.fillSipPasswordField();
        managerPage.selectConfirmSipPasswordField();
        managerPage.selectSecondNextBtn();
        managerPage.selectAddUserFinishBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(managerPage.isDisplayedUserAddMessage(), "User add message does not display");
    }

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

    @Test
    public void verifyMyProfileText() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        Assert.assertTrue(managerPage.isDisplayedUpdateSystemText(), "Update System text is not displayed");
        Assert.assertTrue(managerPage.isDisplayedUserCredentialText(), "User credential text is not displayed");
    }

    @Test
    public void verifyUserEnableDisableFunctionality() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        managerPage.selectUserManagerOption();
        managerPage.createUser();
        managerPage.selectCloseBtn();
        managerPage.fillUserSearchField(managerPage.firstNameText + managerPage.lastNameText);
        managerPage.selectFirstIcon();
        managerPage.selectEditBtn();
        managerPage.selectEnableBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(managerPage.isDisplayedUserEnableMessage(),"Enable Message is not displayed");
        managerPage.selectDisableBtn();
        managerPage.selectConfirmBtn();
        Assert.assertTrue(managerPage.isDisplayedUserDisableMessage(),"Disable Message is not displayed");
    }
}
