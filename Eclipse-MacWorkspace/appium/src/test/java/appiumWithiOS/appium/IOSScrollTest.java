package appiumWithiOS.appium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class IOSScrollTest extends IOSBaseTest{

	@Test
	public void IOSScrollTestDemo() throws InterruptedException
	{
		//just scrolling down
		WebElement ele = driver.findElement(By.id("Web View"));
		
		Map<String,Object> params = new HashMap<>();
		params.put("element",((RemoteWebElement)ele).getId());
		params.put("direction", "down");
		
		driver.executeScript("mobile: scroll", params);	
		Thread.sleep(2000);
		
		driver.findElement(By.id("Web View")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();
		Thread.sleep(2000);
		
		//picker view automation which takes scrolling manually
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

		System.out.println(driver.findElement(AppiumBy.accessibilityId("Red color component value")).getText());
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
		System.out.println(driver.findElement(AppiumBy.accessibilityId("Red color component value")).getText());
		
		System.out.println(driver.findElement(AppiumBy.accessibilityId("Green color component value")).getText());
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
		System.out.println(driver.findElement(AppiumBy.accessibilityId("Green color component value")).getText());

		System.out.println(driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText());
		driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("105");
		System.out.println(driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText());

		
	}
}