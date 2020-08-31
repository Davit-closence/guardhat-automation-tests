import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.events.EventPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventPageTest extends BaseTest {

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

    // SCC-1022
    @Test
    public void verifyEventsResolveBtnFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        eventPage.selectEventIcon();
        eventPage.selectResolveBtn();
        eventPage.selectConfirmPopupBtn();
        Assert.assertTrue(eventPage.isDisplayedResolvedElement(), "Resolved element is not displayed");
        Assert.assertTrue(eventPage.isNotDisplayedResolvedElement(), "Resolved element is displayed");
    }

    @Test
    public void verifyEventsLastFiveEvents() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        eventPage.selectEventIcon();
        Assert.assertTrue(eventPage.isDisplayedLastFiveText(),"Last five event text is not displayed");
    }

    // SCC-295
    @Test
    public void verifyEventsPostCommentsFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
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
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("noncritical");
        eventPage.getFirstEventNonCriticalColor();
        Assert.assertEquals(eventPage.firstEventNonCriticalColor,"rgba(225, 225, 224, 1)","Non critical color is not equal");
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        eventPage.getFirstEventCriticalColor();
        Assert.assertEquals(eventPage.firstEventCriticalColor,"rgba(255, 0, 0, 1)","Crtical event color is not equal");
    }


    @Test
    public void verifyEventsDeselectFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        eventPage.selectEventIcon();
        Assert.assertTrue(eventPage.isDisplayedLeftPanel(), "Left panel is not displayed");
        eventPage.selectEventIcon();
        Assert.assertTrue(eventPage.isNotDisplayedLeftPanel(), "Left panel is displayed");
    }

    @Test
    public void verifyEventsRefreshBrowserFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        eventPage.selectEventIcon();
        Assert.assertTrue(eventPage.isDisplayedLeftPanel(), "Left panel is not displayed");
        eventPage.refreshBrowser();
        Assert.assertTrue(eventPage.isDisplayedLeftPanel(), "Left panel is not displayed");
    }

    @Test
    public void verifyEventsCriticalOptionFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        Assert.assertTrue(eventPage.isDisplayedSocialDistanceIcon(),"Social distance icon is not displayed");
    }

    @Test
    public void verifyEventsNonCriticalOptionFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("noncritical");
        Assert.assertTrue(eventPage.isDisplayedDeviceInformationIcon(),"Device information icon is not displayed");
    }

    @Test
    public void verifyEventsPostCommentBeforeResolve() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        eventPage.selectEventBtn();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("critical");
        eventPage.selectEventIcon();
        eventPage.selectResolveBtn();
        eventPage.fillCommentsFieldPopup();
        eventPage.selectConfirmPopupBtn();
        Assert.assertTrue(eventPage.isDisplayedResolvedElement(), "Resolved element is not displayed");
        Assert.assertTrue(eventPage.isNotDisplayedResolvedElement(), "Resolved element is displayed");
    }
}
