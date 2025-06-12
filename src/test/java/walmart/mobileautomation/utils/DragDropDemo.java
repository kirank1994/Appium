package walmart.mobileautomation.utils;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DragDropDemo extends BaseTest{
//    // Example locators for an Android app
//    @AndroidFindBy(id = "com.example.app:id/username")
//    public WebElement usernameField;
//
//    @AndroidFindBy(id = "com.example.app:id/password")
//    public WebElement passwordField;
//
//    @AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
//    public WebElement loginButton;

    // Actions
	@Test
	public void DragDropTest() throws MalformedURLException, InterruptedException
	{

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 619,
			    "endY", 560
			));
		
		Thread.sleep(3000);
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");

		
		
		
		
		
	
	
		
			
	}
	
	
}
