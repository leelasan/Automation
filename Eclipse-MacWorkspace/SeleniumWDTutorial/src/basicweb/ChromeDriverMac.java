package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverMac {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.ChromeDriver","/Users/leelasan/Eclipse-MacWorkspace/Libs/Drivers/chromedriver");
		
		WebDriver driver;
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("user-data-dir=/Users/leelasan/Library/Application Support/Google/Chrome");
		driver = new ChromeDriver(Options);
		
		String baseURL = "http://www.anasuyas.com";
		driver.get(baseURL);
	}
}