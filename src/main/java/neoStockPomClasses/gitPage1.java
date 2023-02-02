package neoStockPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class gitPage1 {
	
	@FindBy(id="lnk_signup1") private WebElement ClickOnSignIn;
	
	public gitPage1(WebDriver driver ) {
		PageFactory.initElements(driver, this);
}
	public void ClickOnSignInButton() {
	ClickOnSignIn.click();
	Reporter.log("Clicking on SignIn Button",true);
	}

}
