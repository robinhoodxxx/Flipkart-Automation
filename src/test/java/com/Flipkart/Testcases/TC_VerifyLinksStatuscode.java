package com.Flipkart.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import java.net.HttpURLConnection;
import java.net.URL;



import com.BaseClass.Baseclass;

public class TC_VerifyLinksStatuscode extends Baseclass{
	
	
	@Test
	public void VerifyLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
       List<WebElement> links = driver.findElements(By.xpath("//a[@class='HlWMPX']"));
        
        // Create HttpClient instance
        //HttpClient client = HttpClients.createDefault();

        // Loop through each link and check its status
        for (WebElement link : links) {
            String linkurl = link.getAttribute("href");
            if (linkurl != null && !linkurl.isEmpty()) {
            	try
                {
                    URL url = new URL(linkurl);

                    //Now we will be creating url connection and getting the response code
                    HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
                    httpURLConnect.setConnectTimeout(2000);
                    httpURLConnect.connect();
                    int status=httpURLConnect.getResponseCode();
                    if(status>=400)
                    {
                    	System.out.println(link.getText()+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
                    }    
               
                    //Fetching and Printing the response code obtained
                    else{
                        System.out.println(link.getText()+" - "+httpURLConnect.getResponseMessage());
                    }
                }catch (Exception e) {
                	System.out.println(link.getText()+" - is broken");

              }

            }

        }
	}

}
