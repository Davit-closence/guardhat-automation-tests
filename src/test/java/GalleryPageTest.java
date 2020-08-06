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
        loginPage.loginGuard("davit", "guardhat2020");
        galleryPage.selectGalleryBtn();
        galleryPage.selectReloadBtn();
        Assert.assertTrue(galleryPage.isDisplayedProgressBarElement(), "Progress bar is nor displayed");
    }

    @Test
    public void verifyGalleryImageOption() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard("davit", "guardhat2020");
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
        loginPage.loginGuard("davit", "guardhat2020");
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
        loginPage.loginGuard("davit", "guardhat2020");
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
        loginPage.loginGuard("davit", "guardhat2020");
        galleryPage.selectGalleryBtn();
        galleryPage.selectFirstFile();
        galleryPage.selectCloseBtn();
        Assert.assertTrue(galleryPage.isNotDisplayedSelectedMediaSection(),"Section is displayed");
    }

    @Test
    public void verifyGalleryDeleteBtn() {
        GalleryPage galleryPage = new GalleryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard("davit", "guardhat2020");
        galleryPage.selectGalleryBtn();
        galleryPage.getMediaFileNumberTextBefore();
        galleryPage.selectFirstFile();
        galleryPage.selectDeleteBtn();
        galleryPage.selectConfirmBtn();
        Assert.assertTrue(galleryPage.isDisplayedSuccessMessage(),"The message is not displayed");
        Assert.assertTrue(galleryPage.isNotDisplayedSuccessMessage(),"The message is displayed");
        galleryPage.getMediaFileNumberTextAfter();
        Assert.assertNotEquals(galleryPage.mediaFileNumberTextBefore,galleryPage.mediaFileNumberTextAfter,"The number is equal");
    }
}
