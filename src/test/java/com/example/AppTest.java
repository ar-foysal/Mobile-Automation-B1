package com.example;

// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;
import org.openqa.selenium.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Test class for automating interactions with the General Store sample Android application.
 * It demonstrates basic Appium setup, UI Automator capabilities configuration, and simple UI element interactions.
 */
public class AppTest {

    private AndroidDriver driver;

    /**
     * Initializes the Appium AndroidDriver with required test capabilities
     * before the test suite execution begins.
     */
    @BeforeSuite
    public void setUp() {
        Capabilities options = new BaseOptions()
                .amend("platformName", "android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:deviceName", "Pixel_10")
                .amend("appium:appPackage", "com.androidsample.generalstore")
                .amend("appium:appActivity", "com.androidsample.generalstore.SplashActivity")
                .amend("appium:udid", "emulator-5554")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Executes the primary shopping test flow:
     * - Selects country and fills in user details.
     * - Clicks "Let's Shop" to navigate to the product page.
     * - Adds the first product to the cart.
     * - Navigates to the shopping cart and selects the checkbox.
     */
    @Test
    public void sampleTest() {
        WebElement el1 = driver.findElement(AppiumBy.id("android:id/text1"));
        el1.click();
        WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Albania\")"));
        el2.click();
        WebElement el3 = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        el3.sendKeys("Test User");
        WebElement el4 = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        el4.click();
        WebElement el5 = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        el5.click();
        WebElement el6 = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(0)"));
        el6.click();
        WebElement el7 = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        el7.click();
        WebElement el8 = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        el8.click();

    }

    /**
     * Tears down the environment by quitting the WebDriver session safely
     * after all tests in the suite have executed.
     */
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    /**
     * Helper method to construct and provide the remote Appium server URL.
     * 
     * @return URL object pinpointing the Appium server running locally
     */
    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
