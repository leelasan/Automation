package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class IEDriver {

	public static void main(String[] args) {

		WebDriver driver = new InternetExplorerDriver();
		System.setProperty("webdriver.ie.driver","Z:\\Eclipse-MacWorkspace\\Libs\\Drivers\\IEDriverServer.exe");
		String baseURL = "http://anasuyas.com";
		driver.get(baseURL);
		
	}

}
