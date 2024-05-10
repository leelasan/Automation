package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class FirefoxDriverMac {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/leelasan/Eclipse-MacWorkspace/Libs/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String baseURL = "http://anasuyas.com";
		driver.get(baseURL);
	}

}