package NPD_Master_Menus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Browser.Browser_open;
import RepositoryParser.Opt_Respository_parser;

public class Master_Service_Item extends Browser_open {
	public static DateFormat AssetdateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");  // Create object of SimpleDateFormat class and decide the format
	public  static Date date1 = new Date(); //get current date time with Date()
	 public static String ser_item_date= AssetdateFormat.format(date1); // Now format the date
	 public static String SerDefvalue;
	 public static String Ser_item_name;
	 @Test(description="Select service item menu",priority=13)
	 public void Open_ser_item_menu() throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Seritem_Dashboard_Btn"))).click();
			 
			 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Dashboard_Items"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Service_item_menu"))).click();
				logger.info("Selected Service Item menu");    // log file created
				Test =extent.createTest("TC-6:Master-Service item");
				 Test.log(Status.PASS,"Selected Service item menu");
		}catch(Exception  e) {
			logger.error("Error occurred in select service item menu");
			 logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is Select service item menu-"+exception);
			 throw(e);
	    }
	 }	
	 
	 @Test(description="Add service item menu",priority=14)
	 public void Add_new_ser_item() throws Exception {
			try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_ser_item_create"))).click();
		
		 Ser_item_name= sheet2.getRow(25).getCell(1).getStringCellValue()+ser_item_date;
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Ser_itm_Name"))).sendKeys(Ser_item_name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Display_name"))).sendKeys(sheet2.getRow(26).getCell(1).getStringCellValue());
		
		DataFormatter Ser_formatter = new DataFormatter(); //creating formatter using the default locale
		 Cell cell = sheet2.getRow(27).getCell(1);
		  SerDefvalue = Ser_formatter.formatCellValue(cell); 

		 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Def_price"))).sendKeys(SerDefvalue);
		
		    driver.findElement(parser.getbjectLocator("Txt_category_name")).sendKeys(sheet2.getRow(28).getCell(1).getStringCellValue());
			timeout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_category_name"))).sendKeys(Keys.ARROW_DOWN);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_category_name"))).sendKeys(Keys.ENTER);
			
			
			Select sel_cat = new Select(driver.findElement(parser.getbjectLocator("DD_Ser_item_org")));
		    WebElement option = sel_cat.getFirstSelectedOption();
		    String defaultItem = option.getText();
		   // System.out.println(defaultItem);
		  //  timeout();
		    if(defaultItem =="Select") {
		  	//  System.out.println(defaultItem);
		    }else {
		  	 // System.out.println(defaultItem);
		  	  Select DDorg = new Select(driver.findElement(parser.getbjectLocator("DD_Ser_item_org")));
		  	  DDorg.selectByVisibleText(sheet2.getRow(29).getCell(1).getStringCellValue());
		  	  DDorg.selectByIndex(1);
		    }
		    wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_ser_item_save"))).click();
		    logger.info("Added new Service item");   
		    Test.log(Status.PASS,"Add new Service item");
			}catch(Exception  e) {
				logger.error("Error occurred in add new service item");
				 logger.error("Exceptions happen!", e); 
				 exception = e.getMessage();
				 Test.log(Status.FAIL, "Test Case Failed is add new service item menu-"+exception);
				 throw(e);
		    }
			}
	 
	 
	 @Test(description="Edit service item menu",priority=15)
	 public void Edit_new_ser_item() throws Exception {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Ser_Rtn"))).click();
				
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_ser_name"))).sendKeys(Ser_item_name);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_search"))).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Gird_Edit"))).click();
				 
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Chklist"))).sendKeys(sheet2.getRow(30).getCell(1).getStringCellValue());
				timeout();
				wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Chklist"))).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(parser.getbjectLocator("Txt_Chklist")).sendKeys(Keys.ENTER);

				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Chklist_add"))).click();
				 
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_ser_item_save"))).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Ser_Rtn"))).click();
				 logger.info("Edit new Service item");   
				 Test.log(Status.PASS,"Edit new Service item");
			}catch(Exception  e) {
				logger.error("Error occurred in edit service item");
				 logger.error("Exceptions happen!", e); 
				 exception = e.getMessage();
				 Test.log(Status.FAIL, "Test Case Failed is edit new service item menu-"+exception);
				 throw(e);
		    }
	 }
	 
	 
	 @Test(description="Delete service item menu",priority=16)
	 public void Delete_new_ser_item() throws Exception {
			try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_ser_name"))).sendKeys(Ser_item_name);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_search"))).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Gird_Del"))).click();
				 
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("AlertDeleteConfirm"))).click();
				 
				 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Dashboard_Btn"))).click();
				 Test.log(Status.PASS,"Delete new Service item");
				 logger.info("Delete new Service item");   
			}catch(Exception  e) {
				logger.error("Error occurred in delete service item");
				 logger.error("Exceptions happen!", e); 
				 exception = e.getMessage();
				 Test.log(Status.FAIL, "Test Case Failed is delete new service item menu-"+exception);
				 throw(e);
		    }
	 }
	 
	 
	 public void timeout() throws InterruptedException {
			Thread.sleep(3000);
		}
	 
	 @AfterTest
	    public static void endTest()
	    {
	   extent.flush();
	    }
	 
	 
}
