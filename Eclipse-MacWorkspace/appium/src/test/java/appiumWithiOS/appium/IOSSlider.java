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

public class IOSSlider extends IOSBaseTest{

	@Test
	public void IOSSliderTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"AppElem\"`]")).sendKeys("0.1%");
		Thread.sleep(3000);
		System.out.println(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"AppElem\"`]")).getAttribute("value"));
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"AppElem\"`]")).sendKeys("0.5%");
		Thread.sleep(3000);
		System.out.println(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"AppElem\"`]")).getAttribute("value"));
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"AppElem\"`]")).sendKeys("1%");
		Thread.sleep(3000);
		System.out.println(driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"AppElem\"`]")).getAttribute("value"));
		
	}
}