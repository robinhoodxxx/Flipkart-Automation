package com.BaseClass;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actionclass  {
	
	public static WebDriver driver;
	

    public void EnterText(WebElement el, String txt){
        try {

            WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(el));
            el.sendKeys(txt);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
    public void ClickElement(WebElement el){
        try {

            WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(el));
            el.click();

        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("failed to click");
        }


    }
    
    public void ClickAnyElement(WebElement el){
        try {

            WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal\"]/div/div")));
            JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("arguments[0].click();",el);

            // Update with the actual ID or other locator of your custom modal

//            Actions actions = new Actions(driver);
//            actions.moveByOffset(0, 0).click().build().perform();

        }
        catch(Exception e)
        {
        	System.out.println("failed");
            e.printStackTrace();
        }


    }
    
    public void implictwait(long seconds) {
    	try {
    		
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    	}
    	catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void SwitchToCurrentWindow(String Window){
        try {
            Thread.sleep(2000);
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle).getTitle().equals(Window);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    public void WaitTillElementisVisible(WebElement el){
        try {
            WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(el));


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
    
    public void Wait() {
    	try
    	{
    		
         Thread.sleep(5000);    
}
    	catch(Exception e)
        {
            e.printStackTrace();
        }
      

    }
    
    public void Wait(int millisecs) {
    	try
    	{
    		
         Thread.sleep(millisecs);    
}
    	catch(Exception e)
        {
            e.printStackTrace();
        }
      

    }



}
