package appiumwithandroid.appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class AppiumBasics extends BaseTest{
	
	@Test
	public void WiFiSettingsName() throws MalformedURLException, URISyntaxException
	{
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(),"WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Leela");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		//it is recommended to use AppiumBy.className instead of just By.className
		
		
	}

}


