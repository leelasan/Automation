package appiumwithandroid.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class NavigatetoActivityPage extends BaseTest{
	
	@Test
	public void WiFiSettingsName() throws MalformedURLException, URISyntaxException
	{
		
		
		//Once you have the package name and activity name, you can skip the page traversals
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		//below method is deprecated in Appium2 and we don't need to import io.appium.java_client.android.Activity package as well
		//Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity(activity);
		
		// to land to the required page directly - from appium2
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//Screen rotation to landscape
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(),"WiFi settings");
		
		//copy to clip board - paste from clip board
		driver.setClipboardText("Leela Prasad");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		
	}

}


