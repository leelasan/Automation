package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PageObjects extends LaunchBrowser{
	public static WebElement oHRMuserName;
	public static WebElement oHRMpassWord;
	public static WebElement oHRMlogin;
	public static WebElement oHRMuserDdown;
	public static WebElement oHRMlogOut;
	
	public static WebElement HotNuserLink;
	public static WebElement HotgoBack;
	
	public static WebElement redCrAcc;

	

	public static void main(String[] args) {

	}

	public static void PageObjectsDeclaration(String sitePage)
	{
		switch (sitePage){		
		
			case "oHRM_Login":
			
				oHRMuserName = driver.findElement(By.name("username"));
				oHRMpassWord = driver.findElement(By.name("password"));
				oHRMlogin = driver.findElement(By.tagName("button"));
				break;
			
			case "oHRM_Logout":
				
				oHRMuserDdown = driver.findElement(By.tagName("span"));
				oHRMlogOut = driver.findElement(By.tagName("a"));
				break;
				
			case "RedFPage":
				redCrAcc = driver.findElement(By.linkText("Create Account"));
				break;
			
			case "HotFPage":
				
				HotNuserLink = driver.findElement(By.linkText("New User Register Here"));
				break;
				
			case "HotGobackPage":
				HotgoBack = driver.findElement(By.partialLinkText("Go back"));
				break;
				
		}
	}
}
