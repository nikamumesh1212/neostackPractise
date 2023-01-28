package neoStockUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	public static String readExcelSheet(int row,int cell) throws EncryptedDocumentException, IOException {
	 File myFile = new File("C:\\Automation_Velocity\\Selenium\\mock14.xlsx");
	 
	 Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet4");
	 String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
	 Reporter.log("Reading from ExcelSheet Row is:"+row+"Reading from ExcelSheet Cell is:"+cell,true);
	 Reporter.log("Data is:"+value,true);
	 return value;
 }
	public static String readPropertyFile(String key) throws IOException  {
		Properties property = new Properties();
		FileInputStream myFile = new FileInputStream("C:\\Users\\umesh\\eclipse-workspace\\NeoStock_MVN\\myProperty.properties");
		property.load(myFile);
		String value1 = property.getProperty(key);
		Reporter.log("Reading from Property File",true);
		 Reporter.log("Data is:"+value1,true);
		 return value1;
	 }
		
	
	
 
 public static void wait(int time,WebDriver driver) {
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	 Reporter.log("Wait for time is:"+time+"ms",true);
 }
 

 public static void TakeScreenShot(String fileName,WebDriver driver) throws IOException {
	 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Automation_Velocity\\Selenium\\screenshot\\"+fileName+".png");
	Reporter.log("Taking ScreenShots",true);
	FileHandler.copy(src, dest);
	Reporter.log("ScreenShot Taken & save it as :"+dest,true);
	 
 }
 public static void ScrollIntoView(WebElement element,WebDriver driver) {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0],ScrollIntoView(true)",element);
	 Reporter.log("Scrolling Into View is :"+element.getText(),true);
 }
 
}

