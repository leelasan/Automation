package org.leelasan.pageobjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	public void setNameField(String name){
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	public void setGender(String gender) {
		
		if (gender.contains("female")){
			femaleOption.click();
		}else{
			maleOption.click();
		}
	}
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	public void setCountrySelection(String country)
	{
		countrySelection.click();
		GscrollUntilText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	public ProductsCatalog submitForm() {
		shopButton.click();
		return new ProductsCatalog(driver);
	}
}
