package appiumwithandroid.appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.AppiumBy;

public class GS_TC_3 extends BaseTest{

	@Test
	public void SearchProductandAddtoCartandValidate() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Leela");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		GscrollUntilText("Aruba");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Aruba']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//once you click on ADD TO CART the text will turn to ADDED TO CART
		//then the visible count of WebElements with the ADD TO CART is only one
		//So if you use the index of 1 it will fail with out of bounds exception. So, given 0 again
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		int AmtCnt = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double total=0.00;
		
		for (int i=0;i<AmtCnt;i++)
		{
			double price = Double.parseDouble((driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText()).substring(1));
			total = total + price;
		}
		System.out.println(total);
		Assert.assertEquals(total, Double.parseDouble((driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getAttribute("text")).substring(1)));
		Thread.sleep(3000);
		LongClickAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
		Thread.sleep(3000);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
	}
		
}
