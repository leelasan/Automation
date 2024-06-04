package appiumwithandroid.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{
		Map<String, String> env = new HashMap<String, String>(System.getenv());
		env.put("ANDROID_HOME", "/Users/leelasan/Library/Android/sdk");
		env.put("JAVA_HOME","/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home");
		
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withEnvironment(env)
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload")
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();

		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3a API 32"); //emulator
		//options.setDeviceName("Android Device"); //real device

		
		options.setApp("//Users//leelasan//git//Automation//Eclipse-MacWorkspace//appium//src//test//java//resources//ApiDemos-debug.apk");
		//options.setApp("//Users//leelasan//git//Automation//Eclipse-MacWorkspace//appium//src//test//java//resources//General-Store.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
		
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
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
			
		}while(canScrollMore && (driver.findElements(AppiumBy.accessibilityId("WebView")).size())<1);
		
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
