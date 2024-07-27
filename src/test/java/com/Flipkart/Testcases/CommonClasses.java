package com.Flipkart.Testcases;

import java.util.HashMap;
import java.util.Set;

import com.BaseClass.Baseclass;
import com.pagesobjects.Addtocart;

public class CommonClasses extends Baseclass{
	
	public void AdditemToCart( HashMap<String,String> store) {
		Addtocart add=new Addtocart(driver);

		String mainPage = driver.getWindowHandle();
		//System.out.println("Main page ----="+ mainPage);

		
		Set<String> allPages=driver.getWindowHandles();
		for(String page : allPages) {
			if(!page.equals(mainPage)) {
				driver.switchTo().window(page);
				break;
			}
		}
		System.out.println("----------------------");
		
		
		if(add.ProductAvailable()) {
	           System.out.println(add.ProductAvailable());
			String price= add.getProductprice().replace("₹","");
			System.out.println(add.getProductName()+"--"+price+" is added");
			store.put(add.getProductName(), price);
			add.ClickAddToCartBtn();
            //store.size()
			//System.out.println(store.size());

			Wait(1000);
		}
		
		driver.close();
		
		
		
		
	}	

}
