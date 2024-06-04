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

public class IOStouchAndHold extends IOSBaseTest{

	@Test
	public void IOStouchAndHoldTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
		WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
		
		/*
		 ((JavascriptExecutor)driver).executeScript("mobile: touchAndHold", 
				ImmutableMap.of("element",((RemoteWebElement)ele).getId(), "duration", 5));
		*/
		
		//The above statement can be divided in multiple steps like below with the usage of Map
		
		Map<String,Object> params = new HashMap<>();
		params.put("element",((RemoteWebElement)ele).getId());
		params.put("duration", 5);
		
		driver.executeScript("mobile: touchAndHold", params);	
		
		//here instead of elementId we use just element
		//and duration is in seconds instead of milliseconds
		//also casting for driver is not required
	}
}