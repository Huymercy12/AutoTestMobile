package core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBase {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid","192.168.0.102:5555");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.banggood.client");
        capabilities.setCapability("appActivity","com.banggood.client.module.home.MainActivity");
        capabilities.setCapability("automationName","UiAutomator2");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        wait = new WebDriverWait(driver,20);
    }
    public void closeApp(){
        driver.closeApp();
    }

}