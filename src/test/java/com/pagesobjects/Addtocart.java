package com.pagesobjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Addtocart {
	
   WebDriver driver;
	
	public Addtocart (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	





	@FindBy(xpath="//input[@name='q']")
	private WebElement search;
	
	@FindBy(xpath="//div[@class='_2kHMtA']")
	private WebElement product;
	
	@FindBy(xpath="//div[@class='_3qX0zy']")
	private WebElement Home;
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	private WebElement AddtoCart;
	
	@FindBy(xpath="//button[normalize-space()='NOTIFY ME']")
	private WebElement NotAvailable;
	
	@FindBy(xpath="//span[@class='B_NuCI']")
	private WebElement ProductName;
	
	@FindBy(xpath="//div[@class='_30jeq3 _16Jk6d']")
	private WebElement ProductPrice;


	
	
	@FindBy(xpath="//div[@class='_30jeq3 _16Jk6d']")
	private WebElement Carticon;
	
	
	@FindBy(xpath="//span[@class='_2U7eDE']")
	private WebElement CartTotalNo;
	
	

	

	public void EnterSearchText(String text) {
		search.sendKeys(text);	}
	
	public void Submit() {
		search.submit();
	}
	
	public List<WebElement> getProducts() {
		
		 return driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	}
	
	public List<WebElement> getCartProducts() {
		
		 return driver.findElements(By.xpath("//a[@class='_2Kn22P gBNbID']"));
	}
	
	public void ClickAddToCartBtn() {
		AddtoCart.click();
	}
	
	public Boolean ProductAvailable() {
		try {
			
			return AddtoCart.isDisplayed() && AddtoCart.getAttribute("disabled") == null;
		}
		catch(Exception e) {
			
			return false;
		}
		
	}
	

	
	public void getHome() {
		 Home.click();
	}

	
	public String getProductName() {
		return ProductName.getText();
	}
	
	public String getProductprice() {
		return ProductPrice.getText();
	}

	
	public int TotalItemsIncart() {
		return Integer.parseInt(CartTotalNo.getText());
	}

	
	
	
	

}
