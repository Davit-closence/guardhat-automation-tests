import guardhat_ui.LoginPage;
import guardhat_ui.events.EventPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EventPageTest extends BaseTest {

    @Test
    public void verifyEventsCloseBtnFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard("davit", "guardhat2020");
        eventPage.selectEventBtn();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("Critical");
        eventPage.selectEventIcon();
        eventPage.selectCloseBtn();
        Assert.assertTrue(eventPage.isNotDisplayedCloseBtn(), "Close btn is Displayed");
    }

// SCC-1022
    @Test
    public void verifyEventsResolveBtnFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard("davit", "guardhat2020");
        eventPage.selectEventBtn();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("Critical");
        eventPage.selectEventIcon();
        eventPage.selectResolveBtn();
        eventPage.selectConfirmPopupBtn();
        Assert.assertTrue(eventPage.isDisplayedResolvedElement(), "Resolved element is not displayed");
        Assert.assertTrue(eventPage.isNotDisplayedResolvedElement(), "Resolved element is displayed");
    }

    // SCC-295
    @Test
    public void verifyEventsPostCommentsFunctionality() {
        LoginPage loginPage = new LoginPage();
        EventPage eventPage = new EventPage();
        loginPage.loginGuard("davit", "guardhat2020");
        eventPage.selectEventBtn();
        eventPage.selectEventStatusDropDown();
        eventPage.selectEventStatusOption("Critical");
        eventPage.selectEventIcon();
        eventPage.selectPostCommentBtn();
        eventPage.fillCommentsField();
        eventPage.getCommentsValue();
        eventPage.selectSaveCommentsBtn();
        eventPage.getCommentsValueBefore();
        Assert.assertEquals(eventPage.commentsValueBefore,"a few seconds ago","Comments text is not equal");
    }
}
