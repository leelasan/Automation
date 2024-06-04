package appiumWithiOS.appium;

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
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class IOSBaseTest {
	
	public IOSDriver driver;
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
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 13 Pro");
		options.setApp("/Users/leelasan/git/Automation/Eclipse-MacWorkspace/appium/src/test/java/resources/UIKitCatalog.app");
		//options.setApp("/Users/leelasan/git/Automation/Eclipse-MacWorkspace/appium/src/test/java/resources/TestApp 3.app");
		options.setPlatformVersion("15.2");
		//Appium take help of WebDriverAgent to talk with XCUITest. To install webdriveragent in runtime we will give a little time as below
		options.setWdaLaunchTimeout(Duration.ofSeconds(40));
		
		driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
}
