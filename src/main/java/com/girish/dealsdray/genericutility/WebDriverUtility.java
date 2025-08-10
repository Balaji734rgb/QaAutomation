package com.girish.dealsdray.genericutility;



import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public  WebDriverWait explicitWait(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait;
	}
	
	public Alert alertOption(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	public void scroll(WebDriver driver,int i,int j)
	{
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript ("window.scrollBy(i,j)");
	}

}
