package guardhat_ui.administration;

import general_setup.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

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
