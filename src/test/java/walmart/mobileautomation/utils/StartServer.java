package walmart.mobileautomation.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Test
public class StartServer {
	public static AndroidDriver driver;

	public static void StartMyAppiumServer() throws MalformedURLException, InterruptedException {

		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("/opt/homebrew/bin/appium")) // ✅
																															// Point
																															// to
																															// CLI,
																															// not
																															// main.js
				.usingDriverExecutable(new File("/opt/homebrew/bin/node")).withIPAddress("127.0.0.1").usingPort(4723)
				.build();

		service.start();
		System.out.println("Appium Server Started");
		// 3. Initialize driver
		UiAutomator2Options options = new UiAutomator2Options();
		// options.setDeviceName("RahulPhone"); //emulator
		options.setDeviceName("Android Device");// real device

		options.setChromedriverExecutable("//Users//rahulshetty//documents//chromedriver 11");
		options.setApp(ConfigReader.getProperty("appPath"));
		// options.setApp("//Users//kondurikiran//Documents//C//AutomationTesting//10_appium//Udemy_Cource//Appium//src//test//resources//resources//ApiDemos-debug.apk");
		// options.setApp("//Users//rahulshetty//workingcode//Appium//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Add your test logic here
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		service.stop();
		System.out.println("Appium Server Stopped");
	}
}