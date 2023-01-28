package neoStockPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStockPasswordPage1 {

	@FindBy(id=("txt_accesspin")) private WebElement passwordField;
	@FindBy(id=("lnk_submitaccesspin")) private WebElement submitbtn;
	
	public NeoStockPasswordPage1(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}
	
	public void EnterPass(String password) throws InterruptedException {
		passwordField.sendKeys(password);
		Reporter.log("Entring password",true);
		Thread.sleep(1000);
		
	}
	public void ClickSubmitButton() {
		
	submitbtn.click();
	Reporter.log("Clicking on submit Button",true);
}
}