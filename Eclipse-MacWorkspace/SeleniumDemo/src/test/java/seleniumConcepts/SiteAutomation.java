package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class SiteAutomation extends PageObjects{

	public static void main(String[] args) {
		
		rediffsiteMpage();
		findelement();
		
	}
	
	public static void oHRMSiteLogin()
	{
		Launch_App("chrome","https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		PageObjectsDeclaration("oHRM_Login");
		oHRMuserName.sendKeys("Admin");
		oHRMpassWord.sendKeys("admin123");
		oHRMlogin.click();

	}
	
	public static void CCSiteLaunch()
	{
		Launch_App("chrome","https://chandanachaitanya.github.io/selenium-practice-site/");
		
	}
	
	public static void HotSiteLaunch()
	{
		Launch_App("chrome","https://adactinhotelapp.com/");
		PageObjectsDeclaration("HotFPage");
		HotNuserLink.click();
		PageObjectsDeclaration("HotGobackPage");
		HotgoBack.click();
	}
	
	public static void rediffsiteMpage()
	{
		Launch_App("chrome","https://www.rediff.com");
		PageObjectsDeclaration("RedFPage");
		redCrAcc.click();

	}
	
	public static void rediffCrateAcc()
	{
		
	}
	
	public static void findelement()
	{	
		//for list
		//List<WebElement> objList = driver.findElements(By.tagName("a"));
		
		//for text box
		List<WebElement> objList = driver.findElements(By.tagName("input"));
		
		for (WebElement l:objList)
		{
			//for links we use .getText / .getAttribute with name "href"
			//System.out.println(l.getText());
			//System.out.println(l.getAttribute("href"));
			
			//for text box "input" tab, we use .getAttribute with name "type"
			//System.out.println(l.getAttribute("name"));

		}
		
	}

}
