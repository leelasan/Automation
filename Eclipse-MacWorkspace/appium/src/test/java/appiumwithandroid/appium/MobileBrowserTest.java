package appiumwithandroid.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{
	
	@Test
	public void BrowserTest() throws InterruptedException
	{
		driver.get("https://www.udemy.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//*[name()='svg'][@aria-label='Open side drawer'])[1]")).click();
		driver.findElement(By.xpath("//div[normalize-space()='Plans & Pricing']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)","");
	}

}
