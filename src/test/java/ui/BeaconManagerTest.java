package ui;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.pages.home_login.LoginPage;
import guardhat_ui.pages.administration.BeaconManagerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BeaconManagerTest extends BaseTest {

    @Test
    public void verifyNewBeaconFunctionality() {
        LoginPage loginPage = new LoginPage();
        BeaconManagerPage beaconManagerPage = new BeaconManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        beaconManagerPage.selectAdministrationBtn();
        beaconManagerPage.selectMyProfileDropDown();
        beaconManagerPage.selectBeaconManagerOption();
        beaconManagerPage.selectAddBeaconBtn();
        beaconManagerPage.selectTypeDropDown();
        beaconManagerPage.selectFixedBeaconOption();
        beaconManagerPage.fillNameField();
        beaconManagerPage.fillUuidField();
        beaconManagerPage.fillMajorField();
        beaconManagerPage.fillMinorField();
        beaconManagerPage.fillInnerProximityThresholdField();
        beaconManagerPage.fillLatitudeField();
        beaconManagerPage.fillLongitudeField();
        beaconManagerPage.fillAltitudeField();
        beaconManagerPage.selectSaveBtn();
        Assert.assertTrue(beaconManagerPage.isDisplayedBeaconAddMessage(),"Add message for beacon is not displayed");
    }

    @Test
    public void verifyEditBeaconFunctionality() {
        LoginPage loginPage = new LoginPage();
        BeaconManagerPage beaconManagerPage = new BeaconManagerPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        beaconManagerPage.selectAdministrationBtn();
        beaconManagerPage.selectMyProfileDropDown();
        beaconManagerPage.selectBeaconManagerOption();
        beaconManagerPage.createNewBeacon();
        beaconManagerPage.fillSearchField(beaconManagerPage.beaconName);
        beaconManagerPage.selectFirstBeacon();
        beaconManagerPage.selectEditBtn();
        beaconManagerPage.fillNameField();
        beaconManagerPage.selectSaveBtn();
        Assert.assertTrue(beaconManagerPage.isDisplayedBeaconUpdateMessage(),"Beacon update message is not displayed");
    }

}
