package Listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ExtentReports.ExtentReport;

public class ListenersClass implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/*
	@Override
public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	}
*/
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReport.test.pass(result.getMethod().getMethodName()+" is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReport.test.fail(result.getMethod().getMethodName()+" is failed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReport.test.skip(result.getMethod().getMethodName()+" is skipped");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		 try {
			ExtentReport.flushReports();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//	}
}
