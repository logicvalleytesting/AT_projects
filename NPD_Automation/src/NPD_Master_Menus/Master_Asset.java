package NPD_Master_Menus;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sun.media.jfxmedia.logging.Logger;
import Browser.Browser_open;
import RepositoryParser.Opt_Respository_parser;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class Master_Asset extends Browser_open{
	public static DateFormat AssetdateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");  // Create object of SimpleDateFormat class and decide the format
	public  static Date date1 = new Date(); //get current date time with Date()
	 public static String Assetdate= AssetdateFormat.format(date1); // Now format the date
	public String AssetName;
	@Test(description="Select Asset menu",priority=5)
	public void OpenAssetmenu() throws Exception {
		try {
			timeout();
			//parser = new Opt_Respository_parser("E:/Eclipse projects/NPD_Automation/Locater.properties");
       //============>>>>Select Asset menu<<<<=============================	
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Dashoard_Items_Asset"))).click();
	System.out.println(parser.getbjectLocator("Asset_Menu_Sel"));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Asset_Menu_Sel"))).click();
	logger.info("Selected asset menu");    // log file created
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Create_Asset"))).click();
		//==============================================================================
		   result = TestLinkAPIResults.TEST_PASSED;
	       updateTestLinkResult("NPD-2", null, result);
	       String url1 =  driver.getCurrentUrl();
        	   result = TestLinkAPIResults.TEST_PASSED;
    	       updateTestLinkResult("NPD-3", null, result);
    	       
    	       Test =extent.createTest("TC-4:Master-Asset menu");
    			 Test.log(Status.PASS,"Selected Asset menu");
		}catch(Exception  e) {
			logger.error("Error occurred Select asset menu");
			 logger.error("Exceptions happen!", e); 
			   result = TestLinkAPIResults.TEST_FAILED;
			   exception = e.getMessage();
			   updateTestLinkResult("NPD-2",exception, result);
			   Test.log(Status.FAIL, "Test Case Failed is Select asset menu "+exception);
			   throw(e);
	    }
	}
	@Test(description="Adding the new asset",priority=6)
	public void Asset_Insert() throws Exception {
			try {
				//System.out.println(Assetdate);
		 AssetName= sheet2.getRow(2).getCell(1).getStringCellValue()+Assetdate;  //Asset name created by using date format
		  System.out.print(AssetName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Asset_Name"))).sendKeys(AssetName);
		driver.findElement(parser.getbjectLocator("Txt_Identification_No")).sendKeys(sheet2.getRow(3).getCell(1).getStringCellValue());
		//==========>>>>Auto complete box selection<<<<<<========================
		driver.findElement(parser.getbjectLocator("Txt_Assettype_Name")).sendKeys(sheet2.getRow(4).getCell(1).getStringCellValue());
		timeout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Assettype_Name"))).sendKeys(Keys.ARROW_DOWN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Assettype_Name"))).sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_UOM_Name"))).sendKeys(sheet2.getRow(5).getCell(1).getStringCellValue());
		timeout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_UOM_Name"))).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(parser.getbjectLocator("Txt_UOM_Name")).sendKeys(Keys.ENTER);
		//==========>>>>Auto complete box selection<<<<<<========================
		driver.findElement(parser.getbjectLocator("Btn_Save")).click();
		
		logger.info("Inserted sucessfully");
		logger.info("Asset Saved details:Asset name:"+ AssetName +", Asset type name:"+ sheet2.getRow(4).getCell(1).getStringCellValue()); //Log info 
		   result = TestLinkAPIResults.TEST_PASSED;
	       updateTestLinkResult("NPD-9", null, result);
	       Test.log(Status.PASS,"Add new Asset");
		} catch(Exception  e) {
			logger.error("Error occurred in add asset");
			 logger.error("Exceptions happen!", e); 
			   result = TestLinkAPIResults.TEST_FAILED;
			   exception = e.getMessage();
			   updateTestLinkResult("NPD-9",exception, result);
			   Test.log(Status.FAIL, "Test Case Failed is add new asset "+exception);
			   throw(e);
	    }
	}
	@Test(description="Edit the new asset",priority=7)
	public void Asset_Edit() throws Exception {
		try {
			timeout();
		driver.findElement(parser.getbjectLocator("Btn_Return")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Name"))).sendKeys(AssetName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Sarch"))).click();
		timeout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Asset_Gird_Edit"))).click();
		
		String Edit_identification_No= wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Identification_No"))).getAttribute("value");
		String Edit_value= Edit_identification_No + 1;    // Add value for updater
		driver.findElement(parser.getbjectLocator("Txt_Identification_No")).clear();
		driver.findElement(parser.getbjectLocator("Txt_Identification_No")).sendKeys(Edit_value);
		driver.findElement(parser.getbjectLocator("Btn_Save")).click();

		logger.info("Updated sucessful "+ " Changed Identification No to "+ Edit_value);
		 result = TestLinkAPIResults.TEST_PASSED;
	       updateTestLinkResult("NPD-16", null, result);
	      // Asset_delete();
	       Test.log(Status.PASS,"Edit new Asset");
		}catch(Exception e) {
			logger.error("Error occurred in edit asset");
			logger.error("Exceptions happen!", e); 
			result = TestLinkAPIResults.TEST_FAILED;
			
			   exception = e.getMessage();
			   updateTestLinkResult("NPD-16",exception, result);
			   Test.log(Status.FAIL, "Test Case Failed is Edit new asset "+exception);
			   throw(e);
		}
	}
	@Test(description="Delete the new asset",priority=8)
	public void Asset_delete() throws Exception {
		try {
			driver.findElement(parser.getbjectLocator("Btn_Return")).click();
			timeout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Name"))).sendKeys(AssetName);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Sarch"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Asset_Gird_Delete"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Confirm"))).click();
		//	timeout();
			logger.info("Deleted sucessful "+ "Asset name "+ AssetName);
			 result = TestLinkAPIResults.TEST_PASSED;
		       updateTestLinkResult("NPD-18", null, result);
		       updateTestLinkResult("NPD-19", null, result);

		     //Click dash board
				wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Dashboard_Btn"))).click();
				  Test.log(Status.PASS,"Delete new Asset");
		}catch(Exception e) {
			logger.error("Error occurred in delete asset");
			logger.error("Exceptions happen!", e); 
			result = TestLinkAPIResults.TEST_FAILED;
			 exception = e.getMessage();
			 updateTestLinkResult("NPD-18",exception, result);
			 updateTestLinkResult("NPD-19",exception, result);
			 Test.log(Status.FAIL, "Test Case Failed is delete new asset "+exception);
			throw(e);  
		}
	}
	public void timeout() throws InterruptedException {
		Thread.sleep(3000);
	}
}
