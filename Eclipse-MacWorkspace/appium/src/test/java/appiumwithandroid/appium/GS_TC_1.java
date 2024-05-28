package appiumwithandroid.appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class GS_TC_1 extends BaseTest{

	@Test
	public void fill_form()
	{
		//Firstly filled the form and when required to check the toast message, commented the line which sends name and and got the error 
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Leela");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		GscrollUntilText("India");
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		//System.out.println(toastMessage);
		//Assert.assertEquals(toastMessage, "Please enter your name");
		
	}
		
}
