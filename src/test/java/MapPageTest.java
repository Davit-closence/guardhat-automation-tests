import general_setup.BasePage;
import guardhat_ui.LoginPage;
import guardhat_ui.zones.MapPage;
import org.testng.annotations.Test;

public class MapPageTest extends BaseTest {

    @Test
    public void tst() {
        LoginPage loginPage = new LoginPage();
        MapPage mapPage = new MapPage();
        loginPage.loginGuard(BasePage.USERNAME, BasePage.PASSWORD);
        System.out.println(mapPage.getZonesButtonX() + " " + mapPage.getZonesButtonY());
        mapPage.selectZonesBtn();
        mapPage.selectNewZoneBtn();
        System.out.println(mapPage.getMapElementX() + " " + mapPage.getMapElementY());
        mapPage.move(1200,200);
        mapPage.move(1210,210);
        mapPage.move(1215,215);
        mapPage.move(1220,220);
    }
}
