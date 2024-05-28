package appiumwithandroid.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class ScrollDemo extends BaseTest{
	
	@Test
	public void ScrollGesture() throws MalformedURLException, URISyntaxException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//GscrollUntilText("WebView");
		
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.findElement(AppiumBy.accessibilityId("Views")).click();

		//driver.navigate().back();
		//driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		Ascrolltillfindobj();
		//when you don't know where the object while scrolling use below user defined method to scroll until the end
		//AscrollUntillEnd();
	}
	

}


