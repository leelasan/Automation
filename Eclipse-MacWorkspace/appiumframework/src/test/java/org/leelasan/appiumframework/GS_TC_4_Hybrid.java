package org.leelasan.appiumframework;

import java.time.Duration;
import java.util.Set;

import org.leelasan.pageobjects.android.CartPage;
import org.leelasan.pageobjects.android.FormPage;
import org.leelasan.pageobjects.android.ProductsCatalog;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GS_TC_4_Hybrid extends AndroidBaseTest{

	@Test
	public void SearchProductandAddtoCartandValidate() throws InterruptedException
	{
		formpage.setNameField("Leela");
		formpage.setGender("female");
		formpage.setCountrySelection("Aruba");
		ProductsCatalog prodcat = formpage.submitForm();
		
		prodcat.addItemToCartByIndex(0);
		prodcat.addItemToCartByIndex(0);
		CartPage cartPage = prodcat.gotoCartPage();
		
		//Thread.sleep(2000);
		//WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" , "Cart"));
		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();				
	}
		
}
