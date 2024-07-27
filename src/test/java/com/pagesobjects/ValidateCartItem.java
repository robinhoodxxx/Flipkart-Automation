package com.pagesobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Actionclass;


public class ValidateCartItem extends Actionclass{
	
	 WebDriver driver;
		
		public ValidateCartItem (WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[@class='_3SkBxJ']")
	private WebElement CartIcon;
	
	
	//a[@class='_2Kn22P gBNbID']
	
	@FindBy(xpath="//a[@class='_2Kn22P gBNbID']")
	private WebElement itemName;
	
	
	@FindBy(xpath="//span[@class='_2-ut7f _1WpvJ7']")
	private WebElement itemPrice;
	
	public void GoToCart(){
		CartIcon.click();
		
	}
	
	public WebElement CartItems(){
		return itemName;
		
	}
	
	public WebElement CartItemPrice(){
		return itemPrice;
		
	}
	
	
	
	
	
	
	
	

		
		
	}


