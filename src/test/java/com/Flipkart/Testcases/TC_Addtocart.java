package com.Flipkart.Testcases;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.Baseclass;
import com.pagesobjects.Addtocart;
import com.utilityfiles.ConfigFileReader;


public class TC_Addtocart extends Baseclass{
	static HashMap<String,String> storeProducts =new HashMap<String, String>();
   CommonClasses common= new CommonClasses();
	  ConfigFileReader file = new ConfigFileReader ();


	@Test(priority=0)
	public void SearchBytext() {
		
		Addtocart ad=new Addtocart(driver);

		ad.EnterSearchText(file.getSearchcategory());
		ad.Submit();

		
	}
	@Test(priority=1)
	public void Addingtocart() {
		
		Addtocart ad=new Addtocart(driver);

				
	    String mainPage = driver.getWindowHandle();
		System.out.println("---Main page="+ mainPage);
		
		List<WebElement> products = ad.getProducts();
		if(products.isEmpty())
		{
			Assert.assertTrue(false);
          return;
		}
		
		for(WebElement pd : products) {
			//System.out.println(pd.getText());
			//System.out.println(products.size()); 
			pd.click();
			
			common.AdditemToCart(storeProducts);
			
			driver.switchTo().window(mainPage);
			
		}
		
		
		
			}
	@Test(priority=2)
	public void AddedCartItemNoValidate() {
		
		Addtocart ad=new Addtocart(driver);
		
		ad.getHome();
		System.out.println(ad.TotalItemsIncart());
		System.out.println(storeProducts.size());
		Assert.assertEquals(ad.TotalItemsIncart(), storeProducts.size());

	}
	
	
	
	


}
