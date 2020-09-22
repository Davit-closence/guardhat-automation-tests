package ui;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.pages.devices.WorkersPage;
import guardhat_ui.pages.home_login.LoginPage;
import guardhat_ui.pages.events.EventPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventPageTest extends BaseTest {

    // SCC-290
    @Test
    public void verifyEventsCloseBtnFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        eventPage.selectEventIcon();
        eventPage.selectCloseBtn();
        Assert.assertTrue(eventPage.isNotDisplayedCloseBtn(), "Close btn is Displayed");
    }

    // SCC-1022  SCC-271
    @Test
    public void verifyEventsResolveBtnFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        eventPage.selectSosAlarmEvent();
        eventPage.selectResolveBtn();
        eventPage.selectConfirmPopupBtn();
        Assert.assertTrue(eventPage.isDisplayedResolvedElement(), "Resolved element is not displayed");
        Assert.assertTrue(eventPage.isNotDisplayedResolvedElement(), "Resolved element is displayed");
    }

    @Test
    public void verifyEventsLastFiveEvents() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventIcon();
        Assert.assertTrue(eventPage.isDisplayedLastFiveText(),"Last five event text is not displayed");
    }

    // SCC-295
    @Test
    public void verifyEventsPostCommentsFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        eventPage.selectEventIcon();
        eventPage.selectPostCommentBtn();
        eventPage.fillCommentsField();
        eventPage.getCommentsValue();
        eventPage.selectSaveCommentsBtn();
        eventPage.getCommentsValueBefore();
        Assert.assertEquals(eventPage.commentsValueBefore, "a few seconds ago", "Comments text is not equal");
    }

    // SCC-1685
    @Test
    public void verifyEventsCriticalNonCriticalColors() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("noncritical");
        eventPage.getFirstEventNonCriticalColor();
        Assert.assertEquals(eventPage.firstEventNonCriticalColor,"rgba(225, 225, 224, 1)","Non critical color is not equal");
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        eventPage.getFirstEventCriticalColor();
        Assert.assertEquals(eventPage.firstEventCriticalColor,"rgba(255, 0, 0, 1)","Crtical event color is not equal");
    }


    // SCC-299
    @Test
    public void verifyEventsDeselectFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventIcon();
        Assert.assertTrue(eventPage.isDisplayedLeftPanel(), "Left panel is not displayed");
        eventPage.selectEventIcon();
        Assert.assertTrue(eventPage.isNotDisplayedLeftPanel(), "Left panel is displayed");
    }

    // SCC-443
    @Test
    public void verifyEventsRefreshBrowserFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventIcon();
        Assert.assertTrue(eventPage.isDisplayedLeftPanel(), "Left panel is not displayed");
        eventPage.refreshBrowser();
        Assert.assertTrue(eventPage.isDisplayedLeftPanel(), "Left panel is not displayed");
    }

    //SCC-265
    @Test
    public void verifyEventsCriticalOptionFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        Assert.assertTrue(eventPage.isDisplayedSocialDistanceIcon(),"Social distance icon is not displayed");
    }

    @Test
    public void verifyEventsNonCriticalOptionFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("noncritical");
        Assert.assertTrue(eventPage.isDisplayedDeviceInformationIcon(),"Device information icon is not displayed");
    }
    // SCC-265 $$END$$$


    // SCC-289
    @Test
    public void verifyEventsPostCommentBeforeResolve() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        eventPage.selectSosAlarmEvent();
        eventPage.selectResolveBtn();
        eventPage.fillCommentsFieldPopup();
        eventPage.selectConfirmPopupBtn();
        Assert.assertTrue(eventPage.isDisplayedResolvedElement(), "Resolved element is not displayed");
        Assert.assertTrue(eventPage.isNotDisplayedResolvedElement(), "Resolved element is displayed");
    }

    // SCC-266
    @Test
    public void verifyEventsNonCriticalGeneralElements() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        WorkersPage workersPage = new WorkersPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        workersPage.isNotDisplayedProgressBar();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("noncritical");
        Assert.assertTrue(eventPage.isDisplayedDeviceInformationIcon(),"Device information icon is not displayed");
        eventPage.selectEventElement("Device powered on");
        eventPage.getHeaderTitleText();
        Assert.assertEquals(eventPage.headerTitleText,"Device powered on","Header text is not equal");
        Assert.assertTrue(eventPage.isDisplayedVideoBtn(),"Video icon is not displayed");
        Assert.assertTrue(eventPage.isDisplayedAudioBtn(),"Audio icon is not displayed");
        Assert.assertTrue(eventPage.isDisplayedCloseBtn(),"Close icon is not displayed");
    }
}
