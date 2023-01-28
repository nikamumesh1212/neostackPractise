package neoStockTestClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.sql.Driver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStockBase.Base;
import neoStockPomClasses.DashBoardOfNeoStockPage1;
import neoStockPomClasses.NeoStaockHomePage1;
import neoStockPomClasses.NeoStockPasswordPage1;
import neoStockPomClasses.NeoStockSignInPage1;
import neoStockUtility.Utility;

public class ValidateWatchList extends Base{
	
	  NeoStaockHomePage1 home;
		NeoStockSignInPage1 sign;
		NeoStockPasswordPage1 pass;
		DashBoardOfNeoStockPage1 dash;
		
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
	  public void ValidateUserName() throws InterruptedException, IOException {
		  home.ClickOnSignInButton();
			 Thread.sleep(1000);
			 Utility.wait(1000, driver);
			  
			  sign.EnterMobileNo("8308379818");
			  sign.SignInClick();
			  
			 Utility.wait(1000, driver);
			 
			  pass.EnterPass("9504");
		      Thread.sleep(1000);
			  pass.ClickSubmitButton();
			 
			  Utility.wait(5000, driver);
			  
			 dash.HandlePopUps();
			  Utility.wait(0, driver);
			  
			  Utility.wait(5000, driver);
			  }
	
  @Test
  public void watchListOfNeostaock() {
  dash.watchList();
  
  
  
  }
  
  @AfterMethod
  public void logoutneoStock() throws InterruptedException {
	  dash.logOutclick();
	  }
  
  @AfterClass
  public void closeBrowser() {
	  driver.close();
  }
}
