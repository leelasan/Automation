package appiumWithiOS.appium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class IOSSwipeTest extends IOSBaseTest{

	@Test
	public void IOSSwipeTestMethod() throws InterruptedException
	{
		//for bundle id's we can simply google
		Map<String,String> params = new HashMap<>();
		params.put("bundleId","com.apple.mobileslideshow");
		driver.executeScript("mobile:launchApp", params);
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
		
		List<WebElement> photos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		System.out.println(photos.size());
		
		driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
		
		for (WebElement s:photos)
		{
			Map<String, Object> params1 = new HashMap<String, Object>();
			params1.put("direction", "left");
			Thread.sleep(2000);
			driver.executeScript("mobile:swipe", params1);
		}
		driver.navigate().back();
	}
}