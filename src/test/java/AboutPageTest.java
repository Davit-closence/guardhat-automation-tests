import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.administration.AboutPage;
import guardhat_ui.administration.UserManagerPage;
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
