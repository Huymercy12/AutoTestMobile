package pages;

import core.AppiumBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstPage extends AppiumBase {
    public FirstPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "com.banggood.client:id/main_tab_category")
    private WebElement category;
    @FindBy(id = "com.banggood.client:id/primary_cate_list")
    private WebElement list;
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[@text='Nhà và vườn']")
    private  WebElement homeandgarden ;
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]")
    private WebElement homdecor ;
    @FindBy(id = "com.banggood.client:id/slide_filter_entry")
    private WebElement filter ;
    @FindBy(id = "com.banggood.client:id/edit_price_min")
    private WebElement min ;
    @FindBy(id = "com.banggood.client:id/edit_price_max")
    private WebElement max ;
    @FindBy(id = "com.banggood.client:id/btn_done")
    private WebElement done ;
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup[1]")
    private WebElement firstproduct ;
    @FindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement namepr ;
    @FindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement price ;
    WebDriverWait wait = new WebDriverWait(driver,20);
    public void category(){
        category.click();
    }
    public void clickHomeandgarden(){
        swipeUpInContainer(By.id("com.banggood.client:id/primary_cate_list"),list,10,driver);
        homeandgarden.click();
    }
    public void clickHomedecor(){
        homdecor.click();
    }
    public void filter(){
        filter.click();
        min.sendKeys("20");
        max.sendKeys("30");
    }
    public void done(){
        done.click();
    }
    public void clickfirstpro(){
        firstproduct.click();
    }
    public boolean verifyProduct(){
        return namepr.isDisplayed() && price.isDisplayed() ;
    }

    public void swipeMobileUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 2;
        swipe(startx, starty, startx, endy, driver);
    }
    public void swipe(int startx, int starty, int endx, int endy , AndroidDriver drive){
        new TouchAction(drive).longPress(PointOption.point(startx,starty)).moveTo(PointOption.point(endx,endy))
                .release().perform();
    }
    public void swipeUpInContainer(By locator, WebElement androidElementContainer, int count, AndroidDriver driver){
        boolean isVisible = checkElementDisplayed(locator,driver);
        if (isVisible){
            return;
        }
        int startx = 0;
        int starty = 0;
        int endx = 0;
        int endy = 0;
        startx = endx = androidElementContainer.getLocation().getX() + Math.round(androidElementContainer.getSize().getWidth() / 2);
        starty = (int) (androidElementContainer.getLocation().getY() + Math.round(0.8 * androidElementContainer.getSize().getHeight()));
        endy = (int) (androidElementContainer.getLocation().getY() + Math.round(0.2 * androidElementContainer.getSize().getHeight()));
        System.out.println(startx+"_"+ starty+"_"+endx+"_"+ endy);
        for (int i = 0; i < count; ++i) {
            swipe(startx, starty, endx, endy,driver);
            isVisible = checkElementDisplayed(locator,driver);
            if (isVisible){
                break;
            }
        }
    }
    public boolean checkElementDisplayed(By locator, AndroidDriver driver) {
        boolean isDisplay = false;
        AndroidElement androidElement = null;
        try {
            androidElement = (AndroidElement) driver.findElement(locator);
        }catch (Exception e){
        }
        if (null != androidElement) {
            try {
                if (null != androidElement.getLocation()) {
                    int x = androidElement.getLocation().getX();
                    int y = androidElement.getLocation().getY();
                    Dimension windowSize = driver.manage().window().getSize();
                    String deviceScreenSize = "";
                    int yMaxScreen = (int) Math.round(windowSize.getHeight());
                    int xMaxScreen = (int) Math.round(windowSize.getWidth());
                    if (driver instanceof AndroidDriver) {
                        deviceScreenSize = StringUtils.substringBetween(driver.toString(), "deviceScreenSize=",
                                ",");
                    }
                    if (null != deviceScreenSize && !deviceScreenSize.equals("")) {
                        yMaxScreen = Integer.parseInt(deviceScreenSize.split("x")[1]);
                        xMaxScreen = Integer.parseInt(deviceScreenSize.split("x")[0]);
                    }
                    if (x >= 0 && x < xMaxScreen && y >= 0 && y < yMaxScreen) {
                        isDisplay = true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return isDisplay;
    }
}
