package ExtentReports;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	private ExtentReport() {}	
	private static ExtentReports extent ;
	public static ExtentTest test;
	
	
	public static void initReports() throws IOException
	{
		
		if(java.util.Objects.isNull(extent))
		{
			extent=new ExtentReports();
			ExtentSparkReporter spark= new ExtentSparkReporter("index.html");
			File conf = new File("extent-config.xml");
			spark.loadXMLConfig(conf);
			extent.attachReporter(spark);
		}
	}
	
	public static void flushReports() throws IOException
	{
		if(java.util.Objects.nonNull(extent))
		{
		extent.flush();
		// unless you call this method you test logs will not be appear
		//Desktop.getDesktop().browse(new File("index.html").toURI());
		}
	}
	
	public static void createTest(String testname, String author,String category1, String category2, String deviceName)
	{
			test=extent.createTest(testname).assignAuthor(author).assignCategory(category1).assignCategory(category2).assignDevice(deviceName);

			
	}
}
