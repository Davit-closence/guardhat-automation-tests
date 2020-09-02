package guardhat_ui.pages.administration;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.general_setup.ui_helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

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
    public String afterFirstNameText;
    public String afterLastNameText;
    public String beforeFirstNameText;
    public String beforeLastNameText;

    public String getBeforeFirstNameText() {
        return this.beforeFirstNameText = getElementValue(firstNameField);
    }

    public String getBeforeLastNameText() {
        return this.beforeLastNameText = getElementValue(lastNameField);
    }

    public String getAfterFirstNameText() {
        return this.afterFirstNameText = getElementText(firstNameField);
    }

    public String getAfterLastNameText() {
        return this.afterLastNameText = getElementText(lastNameField);
    }


    public String getFirstNameText() {
        return this.firstNameText = getElementValue(firstNameField);
    }

    public String getLastNameText() {
        return this.lastNameText = getElementValue(lastNameField);
    }

    public void reloadPage(){
        driver.navigate().refresh();
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

    @FindBy(xpath = "//label[text()='System User']")
    private WebElement systemUserBtn;

    public void selectSystemUserBtn() {
        click(systemUserBtn);
    }

    @FindBy(xpath = "//input[@formcontrolname='sipUsername']")
    private WebElement sipUsernameField;

    public void fillSipUsernameField() {
        type(sipUsernameField, currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='sipPassword']")
    private WebElement sipPasswordField;

    public void fillSipPasswordField(String sipPass) {
        type(sipPasswordField, sipPass);
    }

    @FindBy(xpath = "//input[@formcontrolname='confirmSipPassword']")
    private WebElement confirmSipPasswordField;

    public void fillConfirmSipPasswordField(String confirmSipPass) {
        type(confirmSipPasswordField, confirmSipPass);
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


    public void createHatUser(String sipPass, String confirmSipPass) {
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
        fillSipPasswordField(sipPass);
        fillConfirmSipPasswordField(confirmSipPass);
        selectSecondNextBtn();
        selectAddUserFinishBtn();
        selectConfirmBtn();
        isDisplayedUserAddMessage();
    }

    public void createSystemUser(String permission) {
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
        selectNextBtn();
        selectSystemUserBtn();
        fillUserNameField();
        getUserName();
        selectPermissionDropDown();
        selectPermissionOption(permission);
        fillEnterPassField(userName);
        fillConfirmPassField(userName);
        fillSipUsernameField();
        fillSipPasswordField(userName);
        fillConfirmSipPasswordField(userName);
        selectSecondNextBtn();
        selectAddUserFinishBtn();
        selectConfirmBtn();
        isDisplayedUserAddMessage();
    }

    @FindBy(xpath = "//input[@formcontrolname='userName']")
    private WebElement userNameField;

    public void fillUserNameField() {
        type(userNameField, "sqa" + currentData());
    }

    public String userName;

    public String getUserName() {
        return this.userName = getElementValue(userNameField);
    }

    @FindBy(xpath = "//mat-select[@formcontrolname='clientRole']")
    private WebElement permissionDropDown;

    public void selectPermissionDropDown() {
        click(permissionDropDown);
    }

    @FindBys({
            @FindBy(xpath = "//mat-option/span")
    })
    private List<WebElement> permissionOptions;

    public void selectPermissionOption(String option) {
        for (WebElement permissionOption : permissionOptions) {
            if (getElementText(permissionOption).equals(option)) {
                click(permissionOption);
                break;
            }
        }
    }

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement enterPassField;

    public void fillEnterPassField(String enterPass) {
        type(enterPassField, enterPass);
    }

    @FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
    private WebElement confirmPassField;

    public void fillConfirmPassField(String confirmPass) {
        type(confirmPassField, confirmPass);
    }

    @FindBy(xpath = "//span[text()='Set user as a hat user']")
    private WebElement hatUserCheckbox;

    public void selectHatUserCheckbox() {
        click(hatUserCheckbox);
    }

    @FindBy(xpath = "//span[text()='Device User']")
    private WebElement deviceUserCheckbox;

    public boolean isDisplayedDeviceUserCheckbox() {
        return isDisplayed(deviceUserCheckbox);
    }

    public void selectDeviceUserCheckbox() {
        click(deviceUserCheckbox);
    }

    public boolean isDisplayedHatUserCheckbox() {
        return isDisplayed(hatUserCheckbox);
    }

    @FindBy(xpath = "//*[contains(text(),' Save ')]")
    private WebElement saveBtn;

    public void selectSaveBtn() {
        click(saveBtn);
    }

    @FindBy(xpath = "//input")
    private WebElement userSearchField;

    public void fillUserSearchField(String text) {
        type(userSearchField, text);
        driverSleep(1000);
    }

    @FindBy(xpath = "(//div[@class='c-listview__icon'])[1]")
    private WebElement firstIcon;

    public void selectFirstIcon() {
        driverSleep(1000);
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

    @FindBy(xpath = "//p[contains(text(),'has been updated')]")
    private WebElement updateMessage;

    public boolean isDisplayedUpdateMessage() {
        return isDisplayed(updateMessage);
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

    public void selectCloseBtn() {
        click(closeBtn);
    }

    @FindBy(xpath = "//div[@class='panel__primary']")
    private WebElement panelPrimary;

    public boolean isDisplayedPanelPrimary(){
        driverSleep(1000);
        return isDisplayed(panelPrimary);
    }

}
