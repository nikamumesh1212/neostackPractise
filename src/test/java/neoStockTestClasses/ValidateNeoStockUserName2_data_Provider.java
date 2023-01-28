package neoStockTestClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStockBase.Base;
import neoStockPomClasses.DashBoardOfNeoStockPage1;
import neoStockPomClasses.NeoStaockHomePage1;
import neoStockPomClasses.NeoStockPasswordPage1;
import neoStockPomClasses.NeoStockSignInPage1;
import neoStockUtility.Utility;



@Listeners(neoStockTestClasses.Listeners.class)
public class ValidateNeoStockUserName2_data_Provider extends Base{
    NeoStaockHomePage1 home;
	NeoStockSignInPage1 sign;
	NeoStockPasswordPage1 pass;
	DashBoardOfNeoStockPage1 dash;
	
	@BeforeMethod
  public void LaunchApplication() throws IOException {
		 LaunchUrl();
		Utility.wait(1000, driver);
		 home = new NeoStaockHomePage1(driver);
		 sign = new NeoStockSignInPage1(driver);
		 pass = new NeoStockPasswordPage1(driver);
		 dash = new DashBoardOfNeoStockPage1(driver);
		 }
  
 @Test(dataProvider = "logindetail")
  public void ValidateUserName(String mob1,String pwd1,String username) throws InterruptedException, IOException {
	  home.ClickOnSignInButton();
		 Thread.sleep(1000);
		 Utility.wait(1000, driver);
		  
		  sign.EnterMobileNo(mob1);
		  sign.SignInClick();
		  
		 Utility.wait(1000, driver);
		 
		  pass.EnterPass(pwd1);
	      Thread.sleep(1000);
		  pass.ClickSubmitButton();
		 
		  Utility.wait(5000, driver);
		  
		 dash.HandlePopUps();
		  Utility.wait(0, driver);
		  
		  AssertJUnit.assertEquals(dash.actualUserNameValue(), username,"actual & expected userName not match, TC fail");
		  dash.logOutclick();
			
  }
  
 @Test(dataProvider = "account")
  public void ValidateAccountBalance(String mob2,String pwd2) throws InterruptedException {
	  home.ClickOnSignInButton();
		 Thread.sleep(1000);
		 Utility.wait(1000, driver);
		  
		  sign.EnterMobileNo(mob2);
		  sign.SignInClick();
		  
		 Utility.wait(1000, driver);
		 
		  pass.EnterPass(pwd2);
	      Thread.sleep(1000);
		  pass.ClickSubmitButton();
		 
		  Utility.wait(5000, driver);
		  
		 dash.HandlePopUps();
		  Utility.wait(0, driver);
		  
		  AssertJUnit.assertNotNull(dash.accountbalanceCheck(),"Balance Null");
		   
		  dash.logOutclick();
 }

  @AfterMethod
  public void logOutNeoStockAccount() throws InterruptedException {
	  Utility.wait(1000, driver);
	 driver.close();
  }
  @DataProvider(name="logindetail")
  public String[][] getLoginDetails(){
	  String [][]getData= {{"8308379818","9504","Hi Umesh Nikam"},{"8888939328","2276","Hi Rajendra Patil"},{"8087673426","4853","Hi Mangesh Ingale"}};
	return getData;
  }
  
 @DataProvider(name="account")
  public String[][] accountValidation(){
	  String [][]getData= {{"8308379818","9504"},{"8087673426","4853"},{"8888939328","2276"}};
	return getData;
  }

}
