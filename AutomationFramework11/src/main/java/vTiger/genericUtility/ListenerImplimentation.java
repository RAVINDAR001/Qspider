package vTiger.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplimentation implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"...passed..");
		
		
	}

	
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"...secsess..");
	
		
	}

	
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"..failed..");
		WebDriverUtility wutil=new WebDriverUtility();
		JavaFileUtility jutil=new JavaFileUtility();
		String screenshotname = methodname+"-"+jutil.togetSystemDateandTime();
		try {
			wutil.ToTakeScreenShot(BaseClass.sdDriver, screenshotname);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	
		
	}

	
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"..skipped..");
		
	}

	public void onStart(ITestContext context) {
		System.out.println(context+"..start..");
		
	}

	
	public void onFinish(ITestContext context) {
		System.out.println(context+"..finshed..");
		
		
	}
	

}
