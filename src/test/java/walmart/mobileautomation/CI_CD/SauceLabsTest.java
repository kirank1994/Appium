package walmart.mobileautomation.CI_CD;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SauceLabsTest {
    public static void main(String[] args) throws Exception {
        // Sauce Labs credentials
        String sauceUserName = "oauth-kirankonduri073-615fb";
        String sauceAccessKey = "2979a315-575a-4b1d-bc44-2ecfd041f129";

        // Sauce Labs URL
        String sauceURL = "https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

        // Appium Options
        MutableCapabilities appiumOptions = new MutableCapabilities();
        appiumOptions.setCapability("platformName", "Android");
        appiumOptions.setCapability("appium:deviceName", "Google Pixel 4a GoogleAPI Emulator");
        appiumOptions.setCapability("appium:platformVersion", "11.0");
        appiumOptions.setCapability("appium:automationName", "UiAutomator2");
        appiumOptions.setCapability("appium:app", "storage:filename=ApiDemos-debug.apk"); // Your uploaded app name
        appiumOptions.setCapability("appium:tunnelIdentifier", "oauth-kirankonduri073-615fb_tunnel_name");

        // Sauce options (metadata)
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("name", "Sample SauceLabs Appium Test");
        sauceOptions.setCapability("build", "Build_001");
        sauceOptions.setCapability("username", sauceUserName);
        sauceOptions.setCapability("accessKey", sauceAccessKey);

        // Merge Sauce options
        appiumOptions.setCapability("sauce:options", sauceOptions);

        // Start the driver
        AndroidDriver driver = new AndroidDriver(new URL(sauceURL), appiumOptions);

        // Simple action (optional)
        System.out.println("Session started: " + driver.getSessionId());

        // Always quit
        driver.quit();
    }
}