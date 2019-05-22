package NPD_Master_Menus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Browser.Browser_open;
import RepositoryParser.Opt_Respository_parser;


public class Master_Ser_item_category extends Browser_open {
	
	public static DateFormat AssetdateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");  // Create object of SimpleDateFormat class and decide the format
	public  static Date date1 = new Date(); //get current date time with Date()
	 public static String ser_cat_date= AssetdateFormat.format(date1); // Now format the date
	 public static String Ser_date;
	 
	@Test(description="Select service item category menu",priority=9)
	 public void Open_ser_item_menu() throws Exception {
		try {
			
			System.out.println("Test service item category");
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Ser_item_Btn_Dashboard"))).click();
	       //============>>>>Select Service Item Category menu<<<<=============================	
			timeout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Ser_item_Btn_items"))).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Ser_item_category"))).click();
		logger.info("Selected Service Item Category menu");    // log file created
		
		Test =extent.createTest("TC-5:Master-Service item category");
		 Test.log(Status.PASS,"Selected Service item category menu");
		}catch(Exception  e) {
			logger.error("Error occurred in select service item category menu");
			 logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			  Test.log(Status.FAIL, "Test Case Failed is Select service item category menu "+exception);
			 throw(e);
	    }
	 }
	
	@Test(description="Add new service item category",priority=10)
	 public void Add_new_ser_item_category() throws Exception {
		try {
			
	 Ser_date= sheet2.getRow(18).getCell(1).getStringCellValue()+ser_cat_date; 
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Ser_item_Cat"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Ser_item_cat_name"))).sendKeys(Ser_date);
	
	Select sel_cat = new Select(driver.findElement(parser.getbjectLocator("DD_Ser_item_cat_org")));
    WebElement option = sel_cat.getFirstSelectedOption();
    String defaultItem = option.getText();
   // System.out.println(defaultItem);
  //  timeout();
    if(defaultItem =="Select") {
  	//  System.out.println(defaultItem);
    }else {
  	  System.out.println(defaultItem);
  	  Select DDorg = new Select(driver.findElement(parser.getbjectLocator("DD_Ser_item_cat_org")));
  	  DDorg.selectByVisibleText(sheet2.getRow(19).getCell(1).getStringCellValue());
  	  DDorg.selectByIndex(1);
  	  
    }
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_ser_item_save"))).click();
	logger.info("Saved sucessfully new Service Item Category :"+Ser_date);   
	 Test.log(Status.PASS,"Add Service item category");
		}catch(Exception  e) {
			logger.error("Error occurred in new service item category");
			 logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is Add Service item category "+exception);
			 throw(e);
	    }
	}
	
	@Test(description="Edit new service item category menu",priority=11)
	 public void Edit_new_ser_item_category() throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_ser_item_rtn"))).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_search_item_cat"))).sendKeys(Ser_date);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_search_ser_cat"))).click();	
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Gird_Btn_edit_ser_cat"))).click();	
			String Edit_Service_item_cat= wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_Ser_item_cat_name"))).getAttribute("value");
			String Edit_value= Edit_Service_item_cat + 1;    // Add value for updater
			driver.findElement(parser.getbjectLocator("Txt_Ser_item_cat_name")).clear();
			driver.findElement(parser.getbjectLocator("Txt_Ser_item_cat_name")).sendKeys(Edit_value);
			driver.findElement(parser.getbjectLocator("Btn_ser_item_save")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_ser_item_rtn"))).click();	
			
			logger.info("Edited sucessfully new Service Item Category :"+Ser_date);   
			Test.log(Status.PASS,"Edit Service item category");
			
		}catch(Exception  e) {
			logger.error("Error occurred in edit service item category");
			 logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is Edit Service item category "+exception);
			 throw(e);
	    }
		}
	
	
	@Test(description="Delete new service item category menu",priority=12)
	 public void Delete_new_ser_item_category() throws Exception {
		try {
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Txt_search_item_cat"))).sendKeys(Ser_date);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_search_ser_cat"))).click();	
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Gird_Btn_Delete_ser_cat"))).click();	
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_Confirm"))).click();
	 //Click dash board
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Dashboard_Btn"))).click();
	
	logger.info("Deleted sucessfully new Service Item Category :"+Ser_date);   
	Test.log(Status.PASS,"Delete Service item category");
		}catch(Exception  e) {
			logger.error("Error occurred in delete service item category");
			 logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is delete Service item category "+exception);
			 throw(e);
	    }
	
	}
	public void timeout() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	

}
