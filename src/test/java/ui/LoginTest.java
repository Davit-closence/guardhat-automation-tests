package ui;

import guardhat_ui.general_setup.ui_helper.GoogleSheetData;
import guardhat_ui.pages.home_login.LoginPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //SCC-494  SCC-980
    @Test
    public void verifyLoginFunctionality() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField(GoogleSheetData.setGoogleSheetData(0));
        loginPage.fillPasswordField(GoogleSheetData.setGoogleSheetData(1));
        loginPage.selectLoginBtn();
        loginPage.selectOverrideBtn();
        Assert.assertTrue(loginPage.isDisplayedLogoutBtn(), "Logout btn is not displayed");
    }

    //SCC-260
    @Description("This test check error message when filling invalid Username") // for allure report description
    @Test
    public void verifyLoginWithInvalidUserName() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField(GoogleSheetData.setGoogleSheetData(4));
        loginPage.fillPasswordField(GoogleSheetData.setGoogleSheetData(5));
        loginPage.selectLoginBtn();
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(), "Error message is not displayed");
    }

    //SCC-259
    @Test
    public void verifyLoginWithInvalidPass() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField(GoogleSheetData.setGoogleSheetData(2));
        loginPage.fillPasswordField(GoogleSheetData.setGoogleSheetData(3));
        loginPage.selectLoginBtn();
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(), "Error message is not displayed");
    }

    @Test
    public void verifyLoginWithInvalidAllData() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField(GoogleSheetData.setGoogleSheetData(6));
        loginPage.fillPasswordField(GoogleSheetData.setGoogleSheetData(7));
        loginPage.selectLoginBtn();
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(), "Error message is not displayed");
    }

    @Test
    public void verifyLogoutFunctionality() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField(GoogleSheetData.setGoogleSheetData(0));
        loginPage.fillPasswordField(GoogleSheetData.setGoogleSheetData(1));
        loginPage.selectLoginBtn();
        loginPage.selectOverrideBtn();
        Assert.assertTrue(loginPage.isDisplayedLogoutBtn(), "Logout btn is not displayed");
        loginPage.selectLogoutBtn();
        Assert.assertTrue(loginPage.isDisplayedLoginBtn(), "Login btn is not displayed");
    }
}
