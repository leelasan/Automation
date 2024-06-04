package org.leelasan.pageobjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import io.appium.java_client.android.AndroidDriver;
import utils.AndroidActions;

public class ProductsCatalog extends AndroidActions{

	AndroidDriver driver;

	public ProductsCatalog(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addtocart;
	
	public void addItemToCartByIndex(int index)
	{
		addtocart.get(index).click();;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;
	
	public CartPage gotoCartPage() throws InterruptedException
	{
		cartButton.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
	
	
	

}
