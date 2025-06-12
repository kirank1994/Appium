package walmart.mobileautomation.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

import org.testng.annotations.Test;
@Test
public class StartServer {
    public static void StartMyAppiumServer() {
   
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/opt/homebrew/bin/appium")) // ✅ Point to CLI, not main.js
                .usingDriverExecutable(new File("/opt/homebrew/bin/node")) 
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();
             System.out.println("Appium Server Started");
        // Add your test logic here

        service.stop();
        System.out.println("Appium Server Stopped");
    }
}