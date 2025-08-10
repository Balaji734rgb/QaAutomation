package com.girish.dealsdray.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class JavaUtility {
	public String timeStamp(WebDriver driver)
	{
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		return timeStamp;
	}
	
	
	public void fileCopy(WebDriver driver) throws IOException
	{
		PropertDataUtility fileUtils = new PropertDataUtility();
		String filename=fileUtils.readPropertyData(driver, "filename");
		StringSelection content = new StringSelection(filename);
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Clipboard clipBoard = toolKit.getSystemClipboard();
		clipBoard.setContents(content,null);
	}
	
	public void webPageScreenShot(WebDriver driver, String name) throws IOException
	{ 
	TakesScreenshot tks = (TakesScreenshot)driver;
	File tempFile = tks.getScreenshotAs(OutputType.FILE);
	 File destFile = new File("../erroShots/prexo/screenshot"+name+timeStamp(driver)+".png");
     FileUtils.copyFile(tempFile, destFile);
	}
	
	
	
	public void webElementScreenShot(WebDriver driver,String name,WebElement ele) throws IOException
	{
		File tempFile = ele.getScreenshotAs(OutputType.FILE);
		 File destFile = new File("../erroShots/prexo/screenshot/"+name+timeStamp(driver)+".png");
	     FileUtils.copyFile(tempFile, destFile);
		
	}
	
	public void screenSize(WebDriver driver) throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
	}
	public void screenSize4(WebDriver driver) throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
	}
	
	public void screenSize2(WebDriver driver) throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
	}
	
	public void screenSize3(WebDriver driver) throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
	}
	public String todayDate(WebDriver driver)
	{
		  String date = LocalDateTime.now().toString();
		return date;
	}
	
	public String getScreenShotAsBase64(WebDriver driver,String name) throws IOException
	{
		TakesScreenshot tks = (TakesScreenshot)driver;
		File tempFile = tks.getScreenshotAs(OutputType.FILE);
		 String destFile = "./erroShots/prexo/screenshot"+name+timeStamp(driver)+".png";
	     FileUtils.copyFile(tempFile, new File(destFile));
	     byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(destFile));
	     return Base64.getEncoder().encodeToString(imageBytes);
	}
	
	 
	
	
}
