package neoStockTestClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStockBase.Base;
import neoStockPomClasses.DashBoardOfNeoStockPage1;
import neoStockPomClasses.NeoStaockHomePage1;
import neoStockPomClasses.NeoStockPasswordPage1;
import neoStockPomClasses.NeoStockSignInPage1;
import neoStockUtility.Utility;

@Listeners(neoStockTestClasses.Listeners.class)
public class ValidateNeoStockUserName extends Base{
	NeoStaockHomePage1 home;
	NeoStockSignInPage1 sign;
	NeoStockPasswordPage1 pass;
	DashBoardOfNeoStockPage1 dash;
	 String s = "TCID453";
 
	 @BeforeClass
   public void LaunchApplication() throws IOException {
		 LaunchUrl();
		Utility.wait(1000, driver);
		 home = new NeoStaockHomePage1(driver);
		 sign = new NeoStockSignInPage1(driver);
		 pass = new NeoStockPasswordPage1(driver);
		 dash = new DashBoardOfNeoStockPage1(driver);
	     
  }

 
  @BeforeMethod
  public void loginToNeoStock() throws InterruptedException, EncryptedDocumentException, IOException {
	  home.ClickOnSignInButton();
	 Thread.sleep(1000);
	 Utility.wait(1000, driver);
	  
	  sign.EnterMobileNo(Utility.readExcelSheet(0, 0));
	  sign.SignInClick();
	  
	 Utility.wait(1000, driver);
	 
	  pass.EnterPass(Utility.readExcelSheet(0, 1));
      Thread.sleep(1000);
	  pass.ClickSubmitButton();
	 
	  Utility.wait(5000, driver);
	  
	 

	  dash.HandlePopUps();
	  Utility.wait(0, driver);
	 
	  
  }
  
  
  @Test
  public void ValidateUserName() throws InterruptedException, EncryptedDocumentException, IOException {
	  //Assert.fail();
     AssertJUnit.assertEquals(dash.actualUserNameValue(), Utility.readExcelSheet(0, 2),"actual & expected userName not match, TC fail");
	Utility.TakeScreenShot(s, driver);
  }
  @Test
  public void ValidateAccountBalance() {
	  AssertJUnit.assertNotNull(dash.accountbalanceCheck(),"Balance Null");
  }

  
  @AfterMethod
  public void logOutNeoStockAccount() throws InterruptedException {
	  Utility.wait(1000, driver);
	  
	
	  dash.logOutclick();
	  Thread.sleep(5000);
	 
	 
  }
 
@AfterClass
public void CloseTheBBrowser() {
	driver.close();
}

}
