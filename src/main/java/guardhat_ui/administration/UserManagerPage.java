package guardhat_ui.administration;

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
        type(firstNameField, "FirstName " + currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    private WebElement lastNameField;

    public void fillLastNameField() {
        type(lastNameField, "LastName " + currentData());
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

    @FindBy(xpath = "//span[text()=' Arm1 ']")
    private WebElement siteArmOption;

    public void selectSiteArmOption() {
        click(siteDropDown);
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

    public void selectHatUserBtn(){
        click(hatUserBtn);
    }


    @FindBy(xpath = "//input[@formcontrolname='sipUsername']")
    private WebElement sipUsernameField;

    public void fillSipUsernameField(){
        type(sipUsernameField,currentData());
    }

    @FindBy(xpath = "//input[@formcontrolname='sipPassword']")
    private WebElement sipPasswordField;

    public void fillSipPasswordField(){
        type(sipPasswordField,"sqa12345");
    }

    @FindBy(xpath = "//input[@formcontrolname='confirmSipPassword']")
    private WebElement confirmSipPasswordField;

    public void selectConfirmSipPasswordField(){
        type(confirmSipPasswordField,"sqa12345");
    }

    @FindBy(xpath = "(//span[text()='Next'])[2]")
    private WebElement secondNextBtn;

    public void selectSecondNextBtn(){
        click(secondNextBtn);
    }

    @FindBy(xpath = "//span[text()='Add User']")
    private WebElement addUserFinishBtn;

    public void selectAddUserFinishBtn(){
        click(addUserFinishBtn);
    }

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement confirmBtn;

    public void selectConfirmBtn(){
        click(confirmBtn);
    }

    @FindBy(xpath = "//*[text()=' New User has been added! ']")
    private WebElement userAddMessage;

    public boolean isDisplayedUserAddMessage(){
        return isDisplayed(userAddMessage);
    }
}
