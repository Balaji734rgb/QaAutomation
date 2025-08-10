package prexo_Software.QA_Automation;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.girish.dealsdray.genericutility.BaseClass;
import com.girish.dealsdray.pomrepository.LoginPage;

import ExtentReports.ExtentReport;

public class HRM extends BaseClass {
	@Test
	public void giri() throws IOException, InterruptedException {
		
		//ExtentReport.createTest(null, null, null, null, null);
		LoginPage log=new LoginPage(driver);
		WebDriverWait wait = webUtility.explicitWait(driver);
	    log.getRegisterLink().click();
	    int K=1;
	    log.getFristNameTF().sendKeys(excelData.readStringExcelvalue(driver, "Register", K, 1));
	    log.getLastNameTF().sendKeys(excelData.readStringExcelvalue(driver, "Register", K, 2));
	
	
	
	
	}

}
