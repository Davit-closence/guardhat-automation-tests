package guardhat_ui.administration;

import com.sun.tools.example.debug.expr.ExpressionParser;
import general_setup.BasePage;
import general_setup.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.Test;

import java.util.List;

public class UserManagerPage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public UserManagerPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//a[@title='Administration']")
    private WebElement administrationBtn;

    public void selectAdministrationBtn() {
        click(administrationBtn);
    }

    @FindBy(xpath = "//*[text()='User Manager']")
    private WebElement userManagerOption;

    public void selectUserManagerOption() {
        click(userManagerOption);
    }

    @FindBy(xpath = "//div[@class='c-dropdown']")
    private WebElement myProfileDropDown;

    public void selectMyProfileDropDown() {
        click(myProfileDropDown);
    }

    @FindBy(xpath = "//a[text()=' Add User']")
    private WebElement addUserBtn;

    public void selectAddUserBtn() {
        click(addUserBtn);
    }

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    private WebElement firstNameField;

    public void fillFirstNameField() {
        type(firstNameField, "SQA_FirstName " + currentData());
    }

    public String firstNameText;
    public String lastNameText;

    public String getFirstNameText() {
        return this.firstNameText = getElementValue(firstNameField);
    }

    public String getLastNameText() {
        return this.lastNameText = getElementValue(lastNameField);
    }

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    private WebElement lastNameField;

    public void fillLastNameField() {
        type(lastNameField, "SQA_LastName " + currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='employeeId']")
    private WebElement employeeIdField;

    public void fillEmployeeIdField() {
        type(employeeIdField, currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='jobTitle']")
    private WebElement jobTitleField;

    public void fillJobTitleField() {
        type(jobTitleField, "JobTitle " + currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='phone']")
    private WebElement phoneField;

    public void fillPhoneField() {
        type(phoneField, "+" + currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement emailField;

    public void fillEmailField() {
        type(emailField, "sqa" + currentData() + "@mailinator.com");
    }

    @FindBy(xpath = "//mat-select[@formcontrolname='organizationalRoles']")
    private WebElement organizationalRolesDropDown;

    @FindBys({
            @FindBy(xpath = "//span[@class='mat-option-text']//span")
    })
    private List<WebElement> organizeOptions;

    public void selectOrganizeOption(String optionText) {
        click(organizationalRolesDropDown);
        for (WebElement organizeOption : organizeOptions) {
            if (getElementText(organizeOption).equals(optionText)) {
                clickJS(organizeOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//mat-select[@formcontrolname='company']")
    private WebElement companyDropDown;

    @FindBys({
            @FindBy(xpath = "//span[@class='mat-option-text']")
    })
    private List<WebElement> companyOptions;

    public void selectCompanyOption(String optionText) {
        click(companyDropDown);
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("(//mat-option[@role='option'])[1]"));
        for (WebElement companyOption : companyOptions) {
            if (getElementText(companyOption).equals(optionText)) {
                click(companyOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//span[text()=' GE ']")
    private WebElement companyGeOption;

    public void selectCompanyGeOption() {
        click(companyDropDown);
        click(companyGeOption);
    }

    @FindBy(xpath = "//mat-select[@formcontrolname='department']")
    private WebElement departmentDropDown;

    @FindBys({
            @FindBy(xpath = "//span[@class='mat-option-text']")
    })
    private List<WebElement> departmentOptions;

    public void selectDepartmentOption(String optionText) {
        click(departmentDropDown);
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("(//mat-option[@role='option'])[1]"));
        for (WebElement departmentOption : departmentOptions) {
            if (getElementText(departmentOption).equals(optionText)) {
                click(departmentOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//span[text()=' IT ']")
    private WebElement departmentItOption;

    public void selectDepartmentItOption() {
        click(departmentDropDown);
        click(departmentItOption);
    }

    @FindBy(xpath = "//mat-select[@formcontrolname='site']")
    private WebElement siteDropDown;

    @FindBys({
            @FindBy(xpath = "//span[@class='mat-option-text']")
    })
    private List<WebElement> siteOptions;

    public void selectSiteOption(String optionText) {
        click(siteDropDown);
        for (WebElement siteOption : siteOptions) {
            if (getElementText(siteOption).equals(optionText)) {
                click(siteOption);
                break;
            }
        }
    }

    @FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
    private WebElement siteArmOption;

    public void selectSiteArmOption() {
        click(siteDropDown);
        driverSleep(800);
        click(siteArmOption);
    }

    @FindBy(xpath = "//mat-select[@formcontrolname='building']")
    private WebElement buildingDropDown;

    @FindBys({
            @FindBy(xpath = "//span[@class='mat-option-text']")
    })
    private List<WebElement> buildingOptions;

    public void selectBuildingOption(String optionText) {
        click(buildingDropDown);
        for (WebElement buildingOption : buildingOptions) {
            if (getElementText(buildingOption).equals(optionText)) {
                click(buildingOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//span[text()=' Building 03 ']")
    private WebElement buildingBuildOption;

    public void selectBuildingBuildOption() {
        click(buildingDropDown);
        click(buildingBuildOption);
    }

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement nextBtn;

    public void selectNextBtn() {
        click(nextBtn);
    }

    @FindBy(xpath = "//label[text()='Hat User']")
    private WebElement hatUserBtn;

    public void selectHatUserBtn() {
        click(hatUserBtn);
    }


    @FindBy(xpath = "//input[@formcontrolname='sipUsername']")
    private WebElement sipUsernameField;

    public void fillSipUsernameField() {
        type(sipUsernameField, currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='sipPassword']")
    private WebElement sipPasswordField;

    public void fillSipPasswordField() {
        type(sipPasswordField, "sqa12345");
    }

    @FindBy(xpath = "//input[@formcontrolname='confirmSipPassword']")
    private WebElement confirmSipPasswordField;

    public void selectConfirmSipPasswordField() {
        type(confirmSipPasswordField, "sqa12345");
    }

    @FindBy(xpath = "(//span[text()='Next'])[2]")
    private WebElement secondNextBtn;

    public void selectSecondNextBtn() {
        click(secondNextBtn);
    }

    @FindBy(xpath = "//span[text()='Add User']")
    private WebElement addUserFinishBtn;

    public void selectAddUserFinishBtn() {
        click(addUserFinishBtn);
    }

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement confirmBtn;

    public void selectConfirmBtn() {
        click(confirmBtn);
    }

    @FindBy(xpath = "//*[text()=' New User has been added! ']")
    private WebElement userAddMessage;

    public boolean isDisplayedUserAddMessage() {
        return isDisplayed(userAddMessage);
    }

    @FindBy(xpath = "//div[@class='mat-select-value']")
    private WebElement languageDropDown;

    public void selectLanguageDropDown() {
        click(languageDropDown);
    }

    @FindBys({
            @FindBy(xpath = "//span[@class='mat-option-text']")
    })
    private List<WebElement> languageOptions;

    public void selectLanguageOption(String option) {
        WaitHelper.getWait().waitForElementToBeVisible
                (By.xpath("//div[@dir='ltr']"));
        for (WebElement languageOption : languageOptions) {
            if (getElementText(languageOption).equals(option)) {
                click(languageOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//a[text()=' Изменить пароль ']")
    private WebElement rusChangePassBtn;


    public boolean isDisplayedRusChangePassBtn() {
        return isDisplayed(rusChangePassBtn);
    }

    @FindBy(xpath = "//span[text()='Pусский']")
    private WebElement rusLanguageDrDw;

    public void selectRusLanguageDrDw() {
        click(rusLanguageDrDw);
    }

    @FindBy(xpath = "//span[text()='English']")
    private WebElement englishOption;

    public void selectEnglishOption() {
        click(englishOption);
    }

    @FindBy(xpath = "//a[text()=' Change Password ']")
    private WebElement enChangePassBtn;

    public boolean isDisplayedEnChangePassBtn() {
        return isDisplayed(enChangePassBtn);
    }

    @FindBy(xpath = "//span[contains(text(),'Last updated by System Administrator on')]")
    private WebElement updateSystemText;

    public boolean isDisplayedUpdateSystemText() {
        return isDisplayed(updateSystemText);
    }

    @FindBy(xpath = "(//div[@class='o-media__body'])[2]")
    private WebElement userCredentialText;

    public boolean isDisplayedUserCredentialText() {
        return isDisplayed(userCredentialText);
    }


    public void createUser() {
        selectAddUserBtn();
        fillFirstNameField();
        getFirstNameText();
        fillLastNameField();
        getLastNameText();
        fillEmployeeIdField();
        fillJobTitleField();
        fillPhoneField();
        fillEmailField();
        selectCompanyGeOption();
        selectDepartmentItOption();
        selectSiteArmOption();
//        managerPage.selectBuildingBuildOption();
        selectNextBtn();
        selectHatUserBtn();
        fillSipUsernameField();
        fillSipPasswordField();
        selectConfirmSipPasswordField();
        selectSecondNextBtn();
        selectAddUserFinishBtn();
        selectConfirmBtn();
        isDisplayedUserAddMessage();
    }

    @FindBy(xpath = "//input")
    private WebElement userSearchField;

    public void fillUserSearchField(String text) {
        type(userSearchField, text);
    }

    @FindBy(xpath = "(//div[@class='c-listview__icon'])[1]")
    private WebElement firstIcon;

    public void selectFirstIcon() {
        click(firstIcon);
    }

    @FindBy(xpath = "//*[text()=' Edit  ']")
    private WebElement editBtn;

    public void selectEditBtn() {
        click(editBtn);
    }

    @FindBy(xpath = "//*[text()=' Disable ']")
    private WebElement disableBtn;

    public void selectDisableBtn() {
        click(disableBtn);
    }

    @FindBy(xpath = "//p[contains(text(),'User has been disabled')]")
    private WebElement userDisableMessage;

    public boolean isDisplayedUserDisableMessage() {
        return isDisplayed(userDisableMessage);
    }

    @FindBy(xpath = "//*[text()=' Enable ']")
    private WebElement enableBtn;

    public void selectEnableBtn() {
        click(enableBtn);
    }

    @FindBy(xpath = "//p[contains(text(),'User has been enabled')]")
    private WebElement userEnableMessage;

    public boolean isDisplayedUserEnableMessage() {
        return isDisplayed(userEnableMessage);
    }

    @FindBy(xpath = "//a[text()=' Close ']")
    private WebElement closeBtn;

    public void selectCloseBtn(){
        click(closeBtn);
    }

}
