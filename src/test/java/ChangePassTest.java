import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.administration.ChangePassPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePassTest extends BaseTest{

    @Test
    public void verifyChangePassCloseBtnFunctionality(){
        ChangePassPage changePassPage = new ChangePassPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        changePassPage.selectAdministrationBtn();
        changePassPage.selectChangePasswordBtn();
        Assert.assertTrue(changePassPage.isDisplayedPanelDetailElement(),"Panel detail element is not displayed");
        changePassPage.selectCloseBtn();
        Assert.assertTrue(changePassPage.isNotDisplayedPanelDetailElement(),"Panel detail element is  displayed");
    }
}
