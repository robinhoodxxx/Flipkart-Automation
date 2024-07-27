package com.BaseClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.utilityfiles.ConfigFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;

	
	  ConfigFileReader file = new ConfigFileReader ();
	    
	    @BeforeTest(alwaysRun=true)
		public void setup(){
	    	
	    	try {
			
			BrowserSetup(file.getBrowser());
			
			
			driver.get(file.getApplicationUrl());
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(file.getImplicitlyWait()));
			
	    	}
	    	catch(Exception e) {
	    		System.out.println("Browser launch failed "+ e);
	    	}
			
			
			//PopupExit();
			
		}
	    
	    @AfterTest(alwaysRun=true)
		public void browserQuit() {
			//driver.close();
			driver.quit();
		}
	    
	    private void BrowserSetup(String browser) {
			
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup(); 
				driver=new ChromeDriver();
			}
			
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup(); 
				driver=new FirefoxDriver();
			}
			
			else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup(); 
				driver=new EdgeDriver();
			}else {
				System.out.println("Browser is not existed");
			}
		}
		
	
	    
	    
	    
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
	        }


	    }
	    
	    public void ClickAnyElement(WebElement el){
	        try {

	            WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal\"]/div/div")));
	            JavascriptExecutor js=(JavascriptExecutor)driver;
	    		js.executeScript("arguments[0].click();",el);

	            // Update with the actual ID or other locator of your custom modal

//	            Actions actions = new Actions(driver);
//	            actions.moveByOffset(0, 0).click().build().perform();

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
	    
	    public  void Screenshot(String img) {
	    	String filelocation = System.getProperty("user.dir")+"//screenshots//";
	    	String imglocation= filelocation+img+".png";
	    	try {
	    		File screenshotfile = new File(filelocation);
	    		File imgfile = new File(imglocation);

	    		if(!screenshotfile.exists()) {
	    			Boolean created=screenshotfile.mkdirs();
	    			
	    				if(created) System.out.println(" file is created ");
	    			
	    		}
	    		if(imgfile.exists()) {
	    			
	    			imgfile.delete();
	    			
	    		}
	    		
	    		TakesScreenshot ts=(TakesScreenshot) driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				
				
				File target=new File(imglocation);
			
				FileUtils.copyFile(src, target);
				
	    	}
	    	catch(FileNotFoundException e) {
			  System.out.println("Screen shot File location is not found");
			}
	    	
	    	catch(Exception e) {
				  System.out.println(e);  

	    	}





}
}
