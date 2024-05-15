package seleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
public class LaunchBrowser {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
	}
	
	public static void Launch_App(String BrowserName, String baseURL)
	{
		switch (BrowserName) {
		
		case "chromefortest":		
			System.setProperty("webdriver.chrome.ChromeDriver","/Users/leelasan/git/Automation/Eclipse-MacWorkspace/Libs/Drivers/chromedriver-mac-x64");
			ChromeOptions CO = new ChromeOptions();
			CO.setBinary("/Users/leelasan/git/Browsers/chrome-mac-x64/Google Chrome for Testing.app");
			driver = new ChromeDriver(CO);
			driver.get(baseURL);
			driver.manage().window().maximize();

			
		case "safari":
			driver = new SafariDriver();
			driver.get(baseURL);
			driver.manage().window().maximize();

			
		case "chrome":
			driver = new ChromeDriver();
			driver.get(baseURL);
			driver.manage().window().maximize();
			
		}
		
	}
}
