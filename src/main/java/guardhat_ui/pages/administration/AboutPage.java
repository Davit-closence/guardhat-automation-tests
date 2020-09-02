package guardhat_ui.pages.administration;

import guardhat_ui.general_setup.ui_helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public AboutPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//*[text()='About']")
    private WebElement aboutOption;

    public void selectAboutOption() {
        click(aboutOption);
    }


    @FindBy(xpath = "//div[@class='panel__section']")
    private WebElement aboutTextVersion;

    public boolean isDisplayedAboutTextVersion(){
        return isDisplayed(aboutTextVersion);
    }

}
