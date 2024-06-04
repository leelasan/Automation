package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{
	
	public AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	public void LongClickAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), "duration", 2000));
		
	}

	public void AscrollUntillEnd()
	{
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 1.0
				));
		}while(canScrollMore);
	}
	
	public void Ascrolltillfindobj()
	{
		
		
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 1.0
				));
			//boolean avail = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"WebView\"]")).getAttribute("text").isEmpty();
			//System.out.println(avail);
			
		/*	if((driver.findElement(AppiumBy.accessibilityId("WebView")).isDisplayed())){
				
			}
			System.out.println("Object not displayed");
		*/
		 
		}while(canScrollMore);
		
	}
	
	public void GscrollUntilText(String inputtext)
	{
		//when you exactly know where to scroll up front use below google engines method.
		//this is googles UiAutomator functionality of scrolling not from Appium's UiAutomator2
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+inputtext+"\"))"));	
		
		//androidUIAutomator(pass the script for scrolling - which use UiScrollable class with scrollIntoView Method)
		
		//Google's UiScrollable class directly don't understand the selector like driver.findElement
		//so we need to tell that we are sending a selector "UiSelector()" class as an argument to the UiScrollable class
		
		//and then call the method scrollIntoView of that UiScrollable class with the required input text
	}
	
	public void SwipeAction(WebElement ele, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId() ,
			    "direction", direction,
			    "percent", 0.75
			));
		
	}
}
