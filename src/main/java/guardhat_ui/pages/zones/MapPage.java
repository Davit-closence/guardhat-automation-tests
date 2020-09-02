package guardhat_ui.pages.zones;

import guardhat_ui.general_setup.ui_helper.BasePage;
import guardhat_ui.general_setup.ui_helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MapPage extends BasePage {
    @Override
    public String getUrl() {
        return BasePage.BASE_UI_URL;
    }

    public MapPage() {
        super();
        driver.get(getUrl());
    }

    @FindBy(xpath = "//a[@title='Zones']")
    private WebElement zonesBtn;


    @FindBy(xpath = "//a[@title='Home']")
    private WebElement homeBtn;

    public void selectZonesBtn() {
        click(zonesBtn);
    }

    public int getZonesButtonX() {
        WaitHelper.getWait().waitForElementToBeVisible(By.xpath("//a[@title='Zones']"));
        Point point = zonesBtn.getLocation();
        return point.getX();
    }

    public int getZonesButtonY() {
        WaitHelper.getWait().waitForElementToBeVisible(By.xpath("//a[@title='Zones']"));
        Point point = zonesBtn.getLocation();
        return point.getY();
    }

    @FindBy(xpath = "//a[text()='New Zone']")
    private WebElement newZoneBtn;

    public void selectNewZoneBtn() {
        click(newZoneBtn);
    }

    @FindBy(xpath = "//canvas[@class='ol-unselectable']")
    private WebElement mapElement;

    public int getMapElementX() {
        WaitHelper.getWait().waitForElementToBeVisible(By.xpath("//canvas[@class='ol-unselectable']"));
        Point point = mapElement.getLocation();
        return point.getX();
    }

    public int getMapElementY() {
        WaitHelper.getWait().waitForElementToBeVisible(By.xpath("//canvas[@class='ol-unselectable']"));
        Point point = mapElement.getLocation();
        return point.getY();
    }

    public void move(int x, int y) {
        getActions().moveToElement(mapElement,x, y).click().build().perform();
    }
}
