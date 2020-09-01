import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.devices.WorkersPage;
import guardhat_ui.gallery.GalleryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GalleryPageTest extends BaseTest {



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
        WorkersPage workersPage = new WorkersPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.getMediaFileNumberTextBefore();
        galleryPage.selectMediaDropDown();
        galleryPage.selectMediaOption("image");
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.getMediaFileNumberTextAfter();
        Assert.assertNotEquals(galleryPage.mediaFileNumberTextBefore, galleryPage.mediaFileNumberTextAfter, "The number are equal");
    }

    @Test
    public void verifyGalleryAudioOption() {
        GalleryPage galleryPage = new GalleryPage();
        WorkersPage workersPage = new WorkersPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.getMediaFileNumberTextBefore();
        galleryPage.selectMediaDropDown();
        galleryPage.selectMediaOption("audio");
        galleryPage.getMediaFileNumberTextAfter();
        Assert.assertNotEquals(galleryPage.mediaFileNumberTextBefore, galleryPage.mediaFileNumberTextAfter, "The number are equal");
    }

    @Test
    public void verifyGalleryVideoOption() {
        GalleryPage galleryPage = new GalleryPage();
        WorkersPage workersPage = new WorkersPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.getMediaFileNumberTextBefore();
        galleryPage.selectMediaDropDown();
        galleryPage.selectMediaOption("video");
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.getMediaFileNumberTextAfter();
        Assert.assertNotEquals(galleryPage.mediaFileNumberTextBefore, galleryPage.mediaFileNumberTextAfter, "The number are equal");
    }

    @Test
    public void verifyGalleryCloseBtn() {
        GalleryPage galleryPage = new GalleryPage();
        WorkersPage workersPage = new WorkersPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.selectFirstFile();
        galleryPage.selectCloseBtn();
        Assert.assertTrue(galleryPage.isNotDisplayedSelectedMediaSection(), "Section is displayed");
    }

    // SCC-1151
    @Test
    public void verifyGalleryDeleteBtn() {
        GalleryPage galleryPage = new GalleryPage();
        WorkersPage workersPage = new WorkersPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.getMediaFileNumberTextBefore();
        galleryPage.selectFirstFile();
        galleryPage.selectDeleteBtn();
        galleryPage.selectConfirmBtn();
        Assert.assertTrue(galleryPage.isDisplayedSuccessMessage(), "The message is not displayed");
        Assert.assertTrue(galleryPage.isNotDisplayedSuccessMessage(), "The message is displayed");
        galleryPage.getMediaFileNumberTextAfter();
        Assert.assertNotEquals(galleryPage.mediaFileNumberTextBefore, galleryPage.mediaFileNumberTextAfter, "The number is equal");
    }


    // SCC-382
    @Test
    public void verifyGalleryDetailWindow() {
        GalleryPage galleryPage = new GalleryPage();
        WorkersPage workersPage = new WorkersPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        galleryPage.selectMediaDropDown();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.selectMediaOption("image");
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.selectFirstFile();
        Assert.assertTrue(galleryPage.isDisplayedUserProfileImage(), "User image is not displayed");
        Assert.assertTrue(galleryPage.isDisplayedDeviceBatteryElement(), "Device battery element is not displayed");
        Assert.assertTrue(galleryPage.isDisplayedDevicePercentage(), "Device Percentage element is not displayed");
        Assert.assertTrue(galleryPage.isDisplayedPanelTitle(),"Panel title is not displayed");
        Assert.assertTrue(galleryPage.isDisplayedMiniMap(),"Mini map is not displayed");
    }

    // SCC-386
    @Test
    public void verifyGalleryRelatedFile() {
        GalleryPage galleryPage = new GalleryPage();
        WorkersPage workersPage = new WorkersPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        galleryPage.selectGalleryBtn();
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.selectMediaDropDown();
        galleryPage.selectMediaOption("image");
        Assert.assertTrue(workersPage.isNotDisplayedProgressBar(),"Progress bar is displayed");
        galleryPage.selectFirstFile();
        Assert.assertTrue(galleryPage.isDisplayedRelatedFile(), "Related file is not displayed");
    }
}
