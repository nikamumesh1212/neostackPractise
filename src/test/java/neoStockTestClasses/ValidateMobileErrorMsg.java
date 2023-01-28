package neoStockTestClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStockBase.Base;
import neoStockPomClasses.NeoStaockHomePage1;
import neoStockPomClasses.NeoStockSignInPage1;
import neoStockUtility.Utility;
@Listeners(neoStockTestClasses.Listeners.class)
public class ValidateMobileErrorMsg extends Base{
	NeoStaockHomePage1 home;
	NeoStockSignInPage1 sign;
 
	@BeforeMethod
	public void launchApp() throws IOException, InterruptedException {
		LaunchUrl();
		Utility.wait(1000, driver);
		 home = new NeoStaockHomePage1(driver);
		 sign = new NeoStockSignInPage1(driver);
		 home.ClickOnSignInButton();
		 Thread.sleep(1000);
		 Utility.wait(1000, driver);
	}
	@Test
	  public void validateMobileError1()  {
			  sign.SignInClick();
			String expectedmsg = "Required";
			AssertJUnit.assertEquals(expectedmsg,sign.mobilesuggestMsg1(),"ExpectedMsg & ActualMsg not Match,TC Fail");
	}
	
	@Test
  public void validateMobileError2()  {
		sign.EnterMobileNo("888888888");
		  sign.SignInClick();
		String expectedmsg = "Invalid Mobile Number";
		AssertJUnit.assertEquals(expectedmsg,sign.mobilesuggestMsg2(),"ExpectedMsg & ActualMsg not Match,TC Fail");
}
	
	@AfterMethod
	public void CloseTheBBrowser() {
		driver.close();
	}
}
