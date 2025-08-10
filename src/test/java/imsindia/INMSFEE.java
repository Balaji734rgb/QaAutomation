package imsindia;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver ;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.girish.dealsdray.genericutility.BaseClass;
import com.girish.dealsdray.genericutility.ExcelUtility;
import com.girish.dealsdray.pomrepository.ImsIndia;
public class INMSFEE extends BaseClass{
	
	public static void main(String[] args) throws Throwable, IOException {
	
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ExcelUtility excelData = new ExcelUtility();
        driver.get("https://techassignments.imsindia.com/ipm-indore-classroom-2026/");
        ImsIndia imsPom = new ImsIndia(driver);
    // Loop through Excel rows (starting from row 1)
        for (int row = 1; row <= 7; row++) {
            String expectedCity = excelData.readStringExcelvalue(driver, "Data", row, 0);
            String expectedCentre = excelData.readStringExcelvalue(driver, "Data", row, 1);
     // Click City dropdown and select matching city
            imsPom.getCityName().click();
            Thread.sleep(1000);
            List<WebElement> listOfCities = imsPom.getListofcities();
            for (WebElement cityElement : listOfCities) {
                if (cityElement.getText().equals(expectedCity)) {
                    cityElement.click();
                    System.out.println("Selected City: " + expectedCity);
                    break;
                }
            }
      // Click Centre dropdown and select matching centre
            imsPom.getSelectCentre().click();
            Thread.sleep(1000);
            List<WebElement> listOfCentres = imsPom.getListOfCenter();
            for (WebElement centreElement : listOfCentres) {
                if (centreElement.getText().equals(expectedCentre)) {
                    centreElement.click();
                    Thread.sleep(1000);
                    System.out.println("Selected Centre: " + expectedCentre);
                    break;
                }
            }
            // Verify Base Fee
            String expectedBaseFee = excelData.readStringExcelvalue(driver, "Data", row, 2);
            String baseFeeFromUI = imsPom.getBaseFee().getText();
            Thread.sleep(2000);
            WebElement fee = driver.findElement(By.xpath("//h3[@class='course-cost__amt mt-3']"));
            String fees = fee.getText();
            Thread.sleep(2000);
            System.out.println();
            if (fees.equals(expectedBaseFee)) {
                System.out.println("✅ Base fee matches for " + expectedCentre  +   expectedBaseFee + ": " +  fees);
            } else {
                System.out.println("❌ Base fee mismatch for " + expectedCentre +" | Expected: " + expectedBaseFee + " | Found: " + fees);
            }
        }
        driver.quit();
    }
}
	


