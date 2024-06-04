package appiumWithiOS.appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest{

	@Test
	public void IOSBasicsTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name='Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Leela");
		Thread.sleep(2000);
		driver.findElement(By.id("OK")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm / Cancel'")).click();
		System.out.println(driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText());
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Confirm']")).click();
	}
}
