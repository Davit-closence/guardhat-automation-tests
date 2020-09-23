package guardhat_ui.pages.home_login;

import guardhat_ui.general_setup.ui_helper.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger("guardhat_ui.pages.home_login.LoginPage");

    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public LoginPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "submit")
    private WebElement loginBtn;

    @FindBy(xpath = "//button[@class='o-btn c-btn--subdued logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//button[text()='Override ']")
    private WebElement overrideBtn;

    @FindBy(xpath = "//div[@class='login__error__message']")
    private WebElement errorMessage;

    public void fillUserNameField(String user) {
        type(userNameField, user);
    }

    public void fillPasswordField(String pass) {
        type(passwordField, pass);
    }

    public void selectLoginBtn() {
        click(loginBtn);
    }

    public void selectOverrideBtn() {
        clickJS(overrideBtn);
    }

    public boolean isDisplayedLogoutBtn() {
        return isDisplayed(logoutBtn);
    }

    public boolean isDisplayedErrorMessage() {
        return isDisplayed(errorMessage);
    }

    public void selectLogoutBtn() {
        driverSleep(1500);
        click(logoutBtn);
    }

    public boolean isDisplayedLoginBtn() {
        return isDisplayed(loginBtn);
    }

    public void checkOverrideBtn() {
        driverSleep(800);
        try {
            overrideBtn.isDisplayed();
            click(overrideBtn);
        } catch (NoSuchElementException e) {
            isDisplayedLogoutBtn();
        }
    }

    public void loginGuard(String username, String password) {
        fillUserNameField(username);
        fillPasswordField(password);
        selectLoginBtn();
        checkOverrideBtn();
    }
}
