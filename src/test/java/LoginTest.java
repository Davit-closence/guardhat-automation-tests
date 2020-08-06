import guardhat_ui.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void verifyLoginFunctionality(){
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField("davit");
        loginPage.fillPasswordField("guardhat2020");
        loginPage.selectLoginBtn();
        loginPage.selectOverrideBtn();
        Assert.assertTrue(loginPage.isDisplayedLogoutBtn(),"Logout btn is not displayed");
    }

    @Test
    public void verifyLoginWithInvalidUserName(){
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField("sccuserrr");
        loginPage.fillPasswordField("guardhat2020");
        loginPage.selectLoginBtn();
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(),"Error message is not displayed");
    }

    @Test
    public void verifyLoginWithInvalidPass(){
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField("davit");
        loginPage.fillPasswordField("guardhat2016888");
        loginPage.selectLoginBtn();
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(),"Error message is not displayed");
    }

    @Test
    public void verifyLoginWithInvalidAllData(){
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField("sccuserrrr");
        loginPage.fillPasswordField("guardhat2016888");
        loginPage.selectLoginBtn();
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(),"Error message is not displayed");
    }

    @Test
    public void verifyLogoutFunctionality(){
        LoginPage loginPage = new LoginPage();
        loginPage.getUrl();
        loginPage.fillUserNameField("davit");
        loginPage.fillPasswordField("guardhat2020");
        loginPage.selectLoginBtn();
        loginPage.selectOverrideBtn();
        Assert.assertTrue(loginPage.isDisplayedLogoutBtn(),"Logout btn is not displayed");
        loginPage.selectLogoutBtn();
        Assert.assertTrue(loginPage.isDisplayedLoginBtn(),"Login btn is not displayed");
    }
}
