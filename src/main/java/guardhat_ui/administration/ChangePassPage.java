package guardhat_ui.administration;

import general_setup.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassPage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public ChangePassPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//a[@title='Administration']")
    private WebElement administrationBtn;

    public void selectAdministrationBtn() {
        click(administrationBtn);
    }

    @FindBy(xpath = "//a[text()=' Change Password ']")
    private WebElement changePasswordBtn;

    public void selectChangePasswordBtn(){
        click(changePasswordBtn);
    }

    @FindBy(xpath = "//a[text()=' Close ']")
    private WebElement closeBtn;

    public void selectCloseBtn(){
        click(closeBtn);
    }

    @FindBy(xpath = "//div[@class='panel__detail']")
    private WebElement panelDetailElement;

    public boolean isDisplayedPanelDetailElement(){
        return isDisplayed(panelDetailElement);
    }

    public boolean isNotDisplayedPanelDetailElement(){
        return isNotDisplayed(panelDetailElement);
    }

    @FindBy(xpath = "//button[@class='o-btn c-btn--large c-btn--utility enable']")
    private WebElement saveBtn;

    public void selectSaveBtn(){
        click(saveBtn);
    }

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement currentPassField;

    public void fillCurrentPassField(String currentPass){
        type(currentPassField,currentPass);
    }

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement newPassField;

    public void fillNewPassField(String newPass){
        type(newPassField,newPass);
    }

    @FindBy(xpath = "(//input[@type='password'])[3]")
    private WebElement confirmPassField;

    public void fillConfirmPassField(String confirmPass){
        type(confirmPassField,confirmPass);
    }

    @FindBy(xpath = "//p[text()=' Password not changed! ']")
    private WebElement passNotChangeMessage;

    public boolean isDisplayedPassNotChangeMessage(){
        return isDisplayed(passNotChangeMessage);
    }
}
