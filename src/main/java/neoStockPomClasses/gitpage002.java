package neoStockPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class gitpage002 {

	@FindBy(xpath = "(//input[@class='form-control'])[1]") private WebElement mobileField;
	@FindBy(id="lnk_signup1") private WebElement signInClick ;
	@FindBy(xpath = "//span[text()='Invalid Mobile Number']") private WebElement MobileInvalidMsg2;
	@FindBy(id="MainContent_signinsignup_reqfld1") private WebElement MobileInvalidMsg1;
	
	public gitpage002(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void EnterMobileNo(String mobno) {
		mobileField.sendKeys(mobno);
		Reporter.log("Entering Mobile No.",true);
		
	}
	public void SignInClick() {
		signInClick.click();
		Reporter.log("Clicking on signIn Button",true);
	}
	
	public String mobilesuggestMsg1() {
		String msg = MobileInvalidMsg1.getText();
		return msg;
	}
	public String mobilesuggestMsg2() {
		String msg = MobileInvalidMsg2.getText();
		return msg;
	}
}
