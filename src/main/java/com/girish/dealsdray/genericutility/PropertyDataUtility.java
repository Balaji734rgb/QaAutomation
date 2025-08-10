package com.girish.dealsdray.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class PropertyDataUtility {
	public String readPropertyData(WebDriver driver,String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/commondatadeals.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String keyValue = pobj.getProperty(key);
		return keyValue;
	}

}
