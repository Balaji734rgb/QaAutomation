package imsindia;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.girish.dealsdray.genericutility.BaseClass;
import com.girish.dealsdray.genericutility.ExcelUtility;
import com.girish.dealsdray.pomrepository.ImsIndia;

import ExtentReports.ExtentReport;

public class ImsIndiaFee extends BaseClass{
	
	@Test(priority=1)
public void ImsFees() throws IOException, InterruptedException {
	
	/*
	ExtentReport.createTest("Verify filter Icon", "Girish", "Functional Cases", "Regression", fileutils.readPropertyData(driver, "browsername"));		
	ExtentReport.test.info(MarkupHelper.createLabel("<b><h2> Verify Filter Icon in Ready for charge in super admin panel :</h2></b>", ExtentColor.BLUE));
	webUtility.implicitWait(driver);
	ImsIndia imspom=new ImsIndia(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;
  //  js.executeScript("window.scrollBy(0,800)");
    Thread.sleep(3000);
    
    int k=1;
    int j=1;
	imspom.getCityName().click();
	
	List<WebElement> ListOfCities = imspom.getListofcities();
	System.out.println(ListOfCities);
	for(WebElement city:ListOfCities ) {
		
		if(city.equals(excelData.readStringExcelvalue(driver, "Data", k, 1))) {
			city.click();
			System.out.println(excelData.readStringExcelvalue(driver, "Data", k, 1));
			
		}
		
		
	}
	
	WebElement ele = imspom.getCityName();
	System.out.println(ListOfCities);
    Thread.sleep(3000);

	
}
*/


ExtentReport.test.info(
    MarkupHelper.createLabel(
        "<b><h2>Verify Filter Icon in Ready for Charge in Super Admin Panel:</h2></b>",
        ExtentColor.BLUE
    )
);

webUtility.implicitWait(driver);
ImsIndia imsPom = new ImsIndia(driver);
JavascriptExecutor js = (JavascriptExecutor) driver;

Thread.sleep(3000);

// Open City dropdown
imsPom.getCityName().click();

// Fetch lists
List<WebElement> listOfCities = imsPom.getListofcities();
List<WebElement> listOfCentres = imsPom.getListOfCenter();

int k = 0; 
// f
int centreExcelRow = 1; // j

String expectedCityName = excelData.readStringExcelvalue(driver, "Data", k, 1);

// Iterate through cities
for (WebElement cityElement : listOfCities) {
    String cityNameFromUI = cityElement.getText();

    if (cityNameFromUI.equals(expectedCityName)) {
        cityElement.click();
        System.out.println("Selected City: " + cityNameFromUI);

        imsPom.getSelectCentre().click();

        // Iterate through centres
        String expectedCentreName = excelData.readStringExcelvalue(driver, "Data", centreExcelRow, 1);
        for (WebElement centreElement : listOfCentres) {
            String centreNameFromUI = centreElement.getText();
            System.out.println("Centre Found: " + centreNameFromUI);

            if (centreNameFromUI.equals(expectedCentreName)) {
                centreElement.click();
                Thread.sleep(3000);

                // Verify Base Fee
                String baseFeeFromUI = imsPom.getBaseFee().getText();
                String expectedBaseFee = excelData.readStringExcelvalue(driver, "Data", k, 1);

                if (baseFeeFromUI.equals(expectedBaseFee)) {
                    System.out.println("Base Fee Matched: " + baseFeeFromUI);
                } else {
                    System.out.println("Base Fee Mismatch! UI: " + baseFeeFromUI + ", Expected: " + expectedBaseFee);
                }
                break; // Exit centre loop once matched
            }
        }
    }

    // Move to next Excel rows
    k++;
    centreExcelRow++;
}

Thread.sleep(3000);
}}
