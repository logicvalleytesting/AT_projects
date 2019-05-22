package NPD_Master_Menus;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Browser.Browser_open;
import RepositoryParser.Opt_Respository_parser;

public class Master_Asset_Type extends Browser_open {
	public static DateFormat AYdateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");  // Create object of SimpleDateFormat class and decide the format
	public  static Date dateAY = new Date(); //get current date time with Date()
	 public static String Assetypedate= AYdateFormat.format(dateAY); // Now format the date
	 
	 
public static String Assettype;
	@Test(description="Select Asset type menu",priority=1)
	public void selectAssettypemenu() throws Exception {
		try {
			//System.out.println("Asset type menu dec");
		//parser = new Opt_Respository_parser("E:/Eclipse projects/NPD_Automation/Locater.properties");
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Dashoard_Items_AssetTyp"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Asset_type_menu"))).click();
		logger.info("Selected Asset type menu"); 
		 Test =extent.createTest("TC-3:Master-Assetype menu");
		 Test.log(Status.PASS,"Selected Asset type");
		} catch
		(Exception  e) {
			logger.error("Error occurred Select asset type menu");
			logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is Select asset type menu-"+exception);
			 throw(e);
		}
	}
	
	@Test(description="Add new asset type",priority=2)
	public void Addnewassettype() throws Exception {
		try {
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Create1"))).click();
		 Assettype= sheet2.getRow(11).getCell(1).getStringCellValue()+Assetypedate;
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Asset_type"))).sendKeys(Assettype);
		
		String org= wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("DD_organization"))).getText();
          //System.out.println(sheet2.getRow(12).getCell(1).getStringCellValue());
          
          Select select = new Select(driver.findElement(parser.getbjectLocator("DD_organization")));
          WebElement option = select.getFirstSelectedOption();
          String defaultItem = option.getText();
         // System.out.println(defaultItem);
        //  timeout();
          if(defaultItem =="Select") {
        	  System.out.println(defaultItem);
          }else {
        	  System.out.println(defaultItem);
        	  Select DDorg = new Select(driver.findElement(parser.getbjectLocator("DD_organization")));
        	  DDorg.selectByVisibleText(sheet2.getRow(12).getCell(1).getStringCellValue());
        	  DDorg.selectByIndex(1);
          }
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_save"))).click();
		logger.info("Created new assetype:"+Assettype+"Org:"+sheet2.getRow(12).getCell(1).getStringCellValue()); 
		
		Test.log(Status.PASS,"Create new assetype");
		} catch
		(Exception  e) {
			logger.error("Error occurred add new asset type");
			logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is add new asset type-"+exception);
			 throw(e);
		}	
	}
	
	@Test(description="Edit the new asset",priority=3)
	public void Editassettype() throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_CReturn"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Ass_typ_search"))).sendKeys(Assettype);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Csearch"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Gird_Edit"))).click();
			String Edit_Assettype= wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Asset_type"))).getAttribute("value");
			String Edit_Assetvalue= Edit_Assettype + 1;
			driver.findElement(parser.getbjectLocator("Txt_Asset_type")).clear();
			driver.findElement(parser.getbjectLocator("Txt_Asset_type")).sendKeys(Edit_Assetvalue);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_save"))).click();
			logger.info("Updated assetype:"+Assettype+" Org:"+sheet2.getRow(12).getCell(1).getStringCellValue());
			
			Test.log(Status.PASS,"Edit new Asset type");
		}catch
		(Exception  e) {
			logger.error("Error occurred Edit new asset type");
			logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is add Edit new asset type"+exception);
			 throw(e);
		}	
	}
	
	@Test(description="Delete Asset",priority=4)
	public void DeleteAssettype() throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_CReturn"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Ass_typ_search"))).sendKeys(Assettype);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Csearch"))).click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Gird_Delete"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("AlertDeleteConfirm"))).click();
			//timeout();
			logger.info("Delete assetype:"+Assettype+" Org:"+sheet2.getRow(12).getCell(1).getStringCellValue()); 
			//Click dash board
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Dashboard_Btn"))).click();
			Test.log(Status.PASS,"Delete new Asset type");
		}catch
		(Exception  e) {
			logger.error("Error occurred Delete new asset type");
			logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is Delete new asset type menu-"+exception);
			 throw(e); 
		}	
	}

	public void timeout() throws InterruptedException {
		Thread.sleep(3000);
	}
}
