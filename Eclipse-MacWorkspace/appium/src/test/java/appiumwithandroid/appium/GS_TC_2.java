package appiumwithandroid.appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class GS_TC_2 extends BaseTest{

	@Test
	public void SearchProductandAddtoCartandValidate() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Leela");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		GscrollUntilText("India");
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Try if we can go to the activity page without providing the above details. or if required, how to pass?
		
		GscrollUntilText("Jordan 6 Rings");
		
		int prodCnt = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0; i<prodCnt; i++)
		{
			String prodName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if (prodName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		Thread.sleep(3000);
		Assert.assertEquals((driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText()),"Jordan 6 Rings");
		Thread.sleep(3000);
	}
		
}
