package ui;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.pages.home_login.LoginPage;
import guardhat_ui.pages.administration.AboutPage;
import guardhat_ui.pages.administration.UserManagerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutPageTest extends BaseTest {

    // SCC-1185
    @Test
    public void verifyAboutText() {
        LoginPage loginPage = new LoginPage();
        UserManagerPage managerPage = new UserManagerPage();
        AboutPage aboutPage = new AboutPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        managerPage.selectAdministrationBtn();
        managerPage.selectMyProfileDropDown();
        aboutPage.selectAboutOption();
        Assert.assertTrue(aboutPage.isDisplayedAboutTextVersion(),"The text of about is not displayed");
    }
}
