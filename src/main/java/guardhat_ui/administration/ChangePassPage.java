package guardhat_ui.administration;

import general_setup.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

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

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn;

    public void selectSaveBtn(){
        click(saveBtn);
    }
}
