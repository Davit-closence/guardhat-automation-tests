import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.gallery.GalleryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GalleryPageTest extends BaseTest {

// SCC-1151

    @Test
    public void verifyGalleryReloadBtn() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        galleryPage.selectReloadBtn();
        Assert.assertTrue(galleryPage.isDisplayedProgressBarElement(), "Progress bar is nor displayed");
    }

    @Test
    public void verifyGalleryImageOption() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        galleryPage.getMediaFileNumberTextBefore();
        galleryPage.selectMediaDropDown();
        galleryPage.selectMediaOption("Image");
        galleryPage.getMediaFileNumberTextAfter();
        Assert.assertNotEquals(galleryPage.mediaFileNumberTextBefore, galleryPage.mediaFileNumberTextAfter, "The number are equal");
    }

    @Test
    public void verifyGalleryAudioOption() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        galleryPage.getMediaFileNumberTextBefore();
        galleryPage.selectMediaDropDown();
        galleryPage.selectMediaOption("Audio");
        galleryPage.getMediaFileNumberTextAfter();
        Assert.assertNotEquals(galleryPage.mediaFileNumberTextBefore, galleryPage.mediaFileNumberTextAfter, "The number are equal");
    }

    @Test
    public void verifyGalleryVideoOption() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        galleryPage.getMediaFileNumberTextBefore();
        galleryPage.selectMediaDropDown();
        galleryPage.selectMediaOption("Video");
        galleryPage.getMediaFileNumberTextAfter();
        Assert.assertNotEquals(galleryPage.mediaFileNumberTextBefore, galleryPage.mediaFileNumberTextAfter, "The number are equal");
    }

    @Test
    public void verifyGalleryCloseBtn() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        galleryPage.selectFirstFile();
        galleryPage.selectCloseBtn();
        Assert.assertTrue(galleryPage.isNotDisplayedSelectedMediaSection(), "Section is displayed");
    }

    @Test
    public void verifyGalleryDeleteBtn() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        galleryPage.getMediaFileNumberTextBefore();
        galleryPage.selectFirstFile();
        galleryPage.selectDeleteBtn();
        galleryPage.selectConfirmBtn();
        Assert.assertTrue(galleryPage.isDisplayedSuccessMessage(), "The message is not displayed");
        Assert.assertTrue(galleryPage.isNotDisplayedSuccessMessage(), "The message is displayed");
        galleryPage.getMediaFileNumberTextAfter();
        Assert.assertNotEquals(galleryPage.mediaFileNumberTextBefore, galleryPage.mediaFileNumberTextAfter, "The number is equal");
    }

    @Test
    public void verifyGalleryDetailWindow() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        galleryPage.selectMediaDropDown();
        galleryPage.selectMediaOption("Image");
        galleryPage.selectFirstFile();
        Assert.assertTrue(galleryPage.isDisplayedUserProfileImage(), "User image is not displayed");
        Assert.assertTrue(galleryPage.isDisplayedDeviceBatteryElement(), "Device battery element is not displayed");
        Assert.assertTrue(galleryPage.isDisplayedDevicePercentage(), "Device Percentage element is not displayed");
        Assert.assertTrue(galleryPage.isDisplayedPanelTitle(),"Panel title is not displayed");
        Assert.assertTrue(galleryPage.isDisplayedMiniMap(),"Mini map is not displayed");
    }

    @Test
    public void verifyGalleryRelatedFile() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        galleryPage.selectMediaDropDown();
        galleryPage.selectMediaOption("Image");
        galleryPage.selectFirstFile();
        Assert.assertTrue(galleryPage.isDisplayedRelatedFile(), "Related file is not displayed");
    }
}
