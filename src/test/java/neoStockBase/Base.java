package neoStockBase;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStockUtility.Utility;

public class Base {
	protected WebDriver driver;
	public void LaunchUrl() throws IOException  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Automation_Velocity\\Selenium\\chromedriver.exe");
		   driver = new ChromeDriver();
		   
	       driver.get(Utility.readPropertyFile("url"));
	       
			driver.manage().window().maximize();
			
			Reporter.log("Launch Url",true);
}
}

//comment1
