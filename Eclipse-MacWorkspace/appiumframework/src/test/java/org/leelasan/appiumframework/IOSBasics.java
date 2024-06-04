package org.leelasan.appiumframework;

import org.leelasan.pageobjects.ios.AlertViews;
import org.leelasan.pageobjects.ios.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest{

	@Test
	public void IOSBasicsTest() throws InterruptedException
	{
		AlertViews alertViews = homepage.selectAlertViews();
		alertViews.fillTextLabel("hello");
		String actualMessage = alertViews.getConfirmMessage();
		Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");
	}
}
