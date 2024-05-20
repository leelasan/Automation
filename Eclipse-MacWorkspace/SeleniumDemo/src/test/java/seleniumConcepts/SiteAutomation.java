package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class SiteAutomation extends PageObjects{

	public static void main(String[] args) {
		
		rediffsiteMpage();
		//findelement();
		//findelementwithjustfor();
		
		//CCSiteLaunch();
		//getCCdropdownlistnames();
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
		PageObjectsDeclaration("CCPage");

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
		PageObjectsDeclaration("RedCrAccPage");
		RedFullName.sendKeys("Leela Prasad");
		
		

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
		//int i = 0;
		for (WebElement l:objList)
		{
			//for links we use .getText / .getAttribute with name "href"
			
			//System.out.println(l.getText());
			//System.out.println(l.getAttribute("href"));
			
			//for text box "input" tab, we use .getAttribute with name "type"
			System.out.println(l.getAttribute("name"));
		}
		
	}
	
	public static void findelementwithjustfor()
	{	
				
		//for text box
		List<WebElement> objList = driver.findElements(By.tagName("input"));
		
		for (int i=0; i<objList.size(); i++)
		{
			//for text box "input" tab, we use .getAttribute with name "type"
			System.out.println(objList.get(i).getAttribute("name"));
			
			if (i==0)
			{
				objList.get(0).sendKeys("Leela Prasad");
			}
			
		}
	}
	
	public static void getCCdropdownlistnames()
	{
		
		//Select select_CClanlist = new Select(CCListBox);
		//select_CClanlist.selectByIndex(1)
		//select_CClanlist.selectByValue("C#");
		
		
		List<WebElement> CCListBoxOptions = CCListBox.findElements(By.tagName("option"));
		
		//for (WebElement l:CCListBoxOptions)
		//System.out.println(l.getText());
		
		for (int i=0; i<CCListBoxOptions.size(); i++)
		{
			//for text box "input" tab, we use .getAttribute with name "type"
			System.out.println(CCListBoxOptions.get(i).getText());
			
			if (i==1)
			{
				CCListBoxOptions.get(i).click();
			}else
				System.out.println("printing all list values...");
			
		}
		
	}

}
