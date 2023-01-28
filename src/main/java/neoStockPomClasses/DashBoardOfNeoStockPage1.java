package neoStockPomClasses;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DashBoardOfNeoStockPage1 {

	@FindBy(xpath=("(//a[text()='OK'])[2]")) private WebElement OkClick ;
	@FindBy(xpath=("(//a[text()='Close'])[5]")) private WebElement CloseClick ;
	@FindBy(id="lbl_username") private WebElement UserNameValue ;
	@FindBy(id="lnk_logout") private WebElement logOutbtn ;
	@FindBy(id="lbl_curbalancetop") private WebElement AccountBalance;
	@FindBy(xpath = "//div[@id='sortable']") private List<WebElement>  watchlist;
	
	
	public DashBoardOfNeoStockPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void HandlePopUps() throws InterruptedException {
		Thread.sleep(1000);
		if(OkClick.isDisplayed()==true) {
			Thread.sleep(1000);
			OkClick.click();
			Reporter.log("Ok Popup handle",true);
			Thread.sleep(1000);
			//CloseClick.click();
			Reporter.log("Close Popup handle",true);
			Thread.sleep(1000);
		}else {
			Reporter.log("There is no Popup",true);
		}
		
	}
	
	public String actualUserNameValue() throws InterruptedException {
		Thread.sleep(1000);
		String UserName = UserNameValue.getText();
		Reporter.log("Getting Actual Username",true);
		Reporter.log("actualUserName is :"+UserName,true);
		return UserName;
	}
	
	
	public String accountbalanceCheck() {
		String myBalance = AccountBalance.getText();
		Reporter.log("Getting account balance",true);
		Reporter.log("Account balance is :"+myBalance,true);
		return myBalance;
	}
	
	public void logOutclick() throws InterruptedException {
		Thread.sleep(500);
		UserNameValue.click();
		Thread.sleep(500);
		logOutbtn.click();
		Reporter.log("LogOut From NeoStock Accout",true);
}
	public void watchList() {
      Iterator<WebElement> it = watchlist.iterator();
      while(it.hasNext()) {
    	  System.out.print(it.next().getText()+" ");
      }
      System.out.println();
		}
		
	}
	
	

