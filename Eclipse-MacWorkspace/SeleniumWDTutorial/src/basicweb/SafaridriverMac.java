package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafaridriverMac {

	public static void main(String[] args) {
		WebDriver driver = new SafariDriver();
		String baseURL = "http://www.anasuyas.com";
		driver.get(baseURL);
	
	}

}
