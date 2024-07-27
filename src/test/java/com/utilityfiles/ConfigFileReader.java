package com.utilityfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "ConfigFiles//Configuration.properties";


    public ConfigFileReader(){
        FileInputStream reader;
        try {
            reader = new FileInputStream(new File(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
            	reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

   

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait == null) 
         throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
        
        return Long.parseLong(implicitlyWait);
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url == null)   
        	throw new RuntimeException("url not specified in the Configuration.properties file.");
        
        return url.trim();
    }
    
    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser == null)   
        	throw new RuntimeException("url not specified in the Configuration.properties file.");
       // System.out.print(browser);
        
        return browser.trim();
    }
    
    public String getSearchcategory() {
        String item = properties.getProperty("searchcategory");
        if(item == null)   
        	throw new RuntimeException("search category not specified in the Configuration.properties file.");
        //System.out.print(item);
        
        return item.trim();
    }
    
    public String getitem() {
        String item = properties.getProperty("searchitem");
        if(item == null)   
        	throw new RuntimeException("item is not given.");
        //System.out.print(item);
        
        return item.trim();
    }


    

}
