package neoStockTestClasses;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStockBase.Base;
import neoStockUtility.Utility;

public class Listeners extends Base implements ITestListener {
	
	public void onTestSuccess(ITestResult result) {
		Reporter.log("TC"+result.getName()+" pass",true);
	}
	
	public void onTestSkipped(ITestResult result) {
		Reporter.log("TC"+result.getName()+" Skip",true);
		
	}
	
	public void onTestFailure(ITestResult result) {
		Reporter.log("TC"+result.getName()+" Fail",true);
		try {
			Utility.TakeScreenShot(result.getName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
