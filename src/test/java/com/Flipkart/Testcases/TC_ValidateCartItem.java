package com.Flipkart.Testcases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.Baseclass;
import com.pagesobjects.Addtocart;
import com.pagesobjects.ValidateCartItem;
import com.utilityfiles.ConfigFileReader;

public class TC_ValidateCartItem extends Baseclass{
	   CommonClasses common= new CommonClasses();
		static HashMap<String,String> storeProducts =new HashMap<String, String>();
		  ConfigFileReader file = new ConfigFileReader ();




	
	@Test
	public void AdditemToCart() {
		
        Addtocart ad=new Addtocart(driver);
        ValidateCartItem vc= new ValidateCartItem(driver);
        
        String s= file.getitem();

	    String mainPage = driver.getWindowHandle();
		
		List<WebElement> products = ad.getProducts();
		
		
		for(WebElement pd : products) {
			System.out.println(pd.getText());
			if(!pd.getText().contains(s)) continue; 
				
				pd.click();
				//System.out.println("class 2 runned");
			
			common.AdditemToCart(storeProducts);
			
			driver.switchTo().window(mainPage);
			
			break;
		
	}
		if(storeProducts.isEmpty()) {
			System.out.println("No item is found with the text");
			Assert.assertTrue(false);
			return ;
		}
		
		
		vc.GoToCart();
		
		for (Map.Entry<String, String> entry : storeProducts.entrySet()) {
            // entry.getKey() + ", Value: " + entry.getValue());
             Assert.assertEquals(entry.getKey().split("  ")[0],vc.CartItems().getText());
             Assert.assertEquals(entry.getValue(),vc.CartItemPrice().getText().replace("₹",""));

        }

		
		
		//System.out.println(vc.CartItems().getText());
	//	System.out.println(vc.CartItemPrice().getText());
		
		
		
		
		
		
		
		
			

	
	

}
}
