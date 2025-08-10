package com.girish.dealsdray.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import ExtentReports.ExtentReport;


public class BaseClass {
	   public WebDriver driver;
	   public ExcelUtility excelData=new ExcelUtility();
	   public PropertDataUtility fileutils=new PropertDataUtility();
	   public JavaUtility javaUtils= new JavaUtility();
	   public WebDriverUtility webUtility=new WebDriverUtility();
	   
	 
	  
	   
	   @BeforeSuite
	   public void beforeSuite() throws IOException
	   {
		  ExtentReport.initReports();
	   }
	   @AfterSuite
	   public void aftrerSuite() throws IOException
	   {
		   ExtentReport.flushReports();
	   }
		@BeforeMethod
		public void configureBeforeMethod() throws IOException
		{
			String browserName = fileutils.readPropertyData(driver, "browsername");
			if(browserName.equals("chrome"))
			{
			    ChromeOptions options = new ChromeOptions();
			    options.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(options);
			}
			else if(browserName.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.get(fileutils.readPropertyData(driver, "url"));
		
		}
		@AfterMethod
		public void configureAfterMethod(ITestResult res) throws IOException
		{
			
				int status = res.getStatus();
				System.out.println(status);
				String name = res.getName();
				if(status==2)
				{
					ExtentReport.test.fail(MarkupHelper.createLabel("<b><h4> "+name+" Test is failed with some exception look into test ng report for the descption :</h4></b>", ExtentColor.RED));
					ExtentReport.test.info(MediaEntityBuilder.createScreenCaptureFromBase64String(javaUtils.getScreenShotAsBase64(driver, name)).build());
					javaUtils.webPageScreenShot(driver,name);
				}
				driver.manage().window().minimize();
				driver.quit();
			}
}
