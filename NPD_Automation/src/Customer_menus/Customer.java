package Customer_menus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.Status;
import Browser.Browser_open;
import org.testng.annotations.Test;

public class Customer extends Browser_open {
	 public static DateFormat Cusnamefor = new SimpleDateFormat("ddMMyyyyHHmmss");  // Create object of SimpleDateFormat class and decide the format
		public  static Date Cus_dt_val = new Date(); //get current date time with Date()
		 public static String Cus_dt= Cusnamefor.format(Cus_dt_val); // Now format the date
		 
		 public static String CusnameDT;
		 
		
	 
	@Test(priority=20)
	public void customer_menu() throws Exception {
		try {
	     Test =extent.createTest("TC-8:Customer");
          timeout();
       wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_dashboard"))).click();
	   timeout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_Customer_header"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Customer_menu"))).click();
		logger.info("Customer menu selected");
		 Test.log(Status.PASS,"Customer menu selected");
		}catch(Exception  e) {
			logger.error("Error occurred in select customer menu",e);
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is Select customer menu-"+exception);
			 throw(e);
		}
	}
	@Test(priority=21)
	public void addnewcustomer() throws Exception {
		try {
			 timeout();
			 CusnameDT=sheet4.getRow(2).getCell(1).getStringCellValue()+Cus_dt;

		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_btn_create"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_Txt_cus_name"))).sendKeys(CusnameDT);
		
		//Customer type select		
		driver.findElement(parser.getbjectLocator("Cus_Txt_cus_type")).sendKeys(sheet4.getRow(3).getCell(1).getStringCellValue());
		timeout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_Txt_cus_type"))).sendKeys(Keys.ARROW_DOWN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_Txt_cus_type"))).sendKeys(Keys.ENTER);
		
		//Organization drop down select 
		 Select Selorg = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_DD_cus_org"))));
		 Selorg.selectByVisibleText(sheet4.getRow(4).getCell(1).getStringCellValue());
		 Selorg.selectByIndex(1);
		 
		 driver.findElement(parser.getbjectLocator("Cus_Txt_cus_desc")).sendKeys(sheet4.getRow(14).getCell(1).getStringCellValue());
		 
		 driver.findElement(parser.getbjectLocator("Cus_Txt_cus_Phone")).sendKeys(sheet4.getRow(5).getCell(1).getStringCellValue());
		 driver.findElement(parser.getbjectLocator("Cus_Txt_cus_Email")).sendKeys(sheet4.getRow(6).getCell(1).getStringCellValue());
		 
		 driver.findElement(parser.getbjectLocator("Cus_Btn_Add")).click();

		//Address type select
		 Select Selpriority = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_Mod_dd_Addr_typ"))));
		 Selpriority.selectByVisibleText(sheet4.getRow(7).getCell(1).getStringCellValue());
		 Selpriority.selectByIndex(1);
		 
		 driver.findElement(parser.getbjectLocator("Cus_Mod_txt_Addr1")).sendKeys(sheet4.getRow(8).getCell(1).getStringCellValue());
		 driver.findElement(parser.getbjectLocator("Cus_Mod_txt_Addr2")).sendKeys(sheet4.getRow(9).getCell(1).getStringCellValue());
		 
		 
		 driver.findElement(parser.getbjectLocator("Cus_Mod_Chkbox_primary")).click();

		 driver.findElement(parser.getbjectLocator("Cus_mod_txt_City")).sendKeys(sheet4.getRow(10).getCell(1).getStringCellValue());
		 driver.findElement(parser.getbjectLocator("Cus_Mod_txt_State")).sendKeys(sheet4.getRow(11).getCell(1).getStringCellValue());
		 
		 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
		 Cell cell = sheet4.getRow(12).getCell(1);
		 String zip = formatter.formatCellValue(cell);
		 
		 driver.findElement(parser.getbjectLocator("Cus_Mod_txt_zip")).sendKeys(zip);
		 driver.findElement(parser.getbjectLocator("Cus_Mod_txt_Country")).sendKeys(sheet4.getRow(13).getCell(1).getStringCellValue());
		 
		 driver.findElement(parser.getbjectLocator("Cus_Mod_Chkbox_Billaddr")).click();
		 driver.findElement(parser.getbjectLocator("Cus_Mod_Chkbox_Commaddr")).click();
	
		 driver.findElement(parser.getbjectLocator("Cus_Mod_btn_add")).click();
		 
		 timeout();
		 js.executeScript("window.scrollBy(0,250)", "");
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_btn_Saveclose"))).click();
			
			logger.info("Added new customer:"+CusnameDT);
		Test.log(Status.PASS,"Addred new customer, Name:"+ CusnameDT);
		}catch(Exception  e) {
			logger.error("Error occurred in add new customer",e);
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is Select customer menu-"+exception);
			 throw(e);
		}
	}
	
	@Test(priority=22)
	public void Editnewcustomer() {
		try {
			
		//	CusnameDT=sheet4.getRow(2).getCell(1).getStringCellValue()+Cus_dt;
			System.out.println(CusnameDT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_txt_Src_Name"))).sendKeys(CusnameDT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_btn_Search"))).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_Btn_Edit_gird"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_Txt_cus_contact_per"))).sendKeys(sheet4.getRow(15).getCell(1).getStringCellValue());
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_Txt_cus_contact_phone"))).sendKeys(sheet4.getRow(16).getCell(1).getStringCellValue());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_btn_save"))).click();
		
		logger.info("Edited new customer:"+CusnameDT);
		Test.log(Status.PASS,"Edit new customer, Name:"+ CusnameDT);
		Test.log(Status.PASS,"Customer search option working");
		
	}catch(Exception  e) {
		logger.error("Error occurred in Edit new customer",e);
		 exception = e.getMessage();
		 Test.log(Status.FAIL, "Test Case Failed is Edit new customer-"+exception);
		 throw(e);
	}
	}
	
	
	@Test(priority=23)
	public void Deletenewcustomer() {
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_btn_return"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_txt_Src_Name"))).sendKeys(CusnameDT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_btn_Search"))).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Cus_Btn_Del_gird"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("AlertDeleteConfirm"))).click();
			
			logger.info("Deleted new customer:"+CusnameDT);
			Test.log(Status.PASS,"Delete new customer,Name:"+ CusnameDT);
		}catch(Exception  e) {
			logger.error("Error occurred in delete new customer",e);
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is delete new customer-"+exception);
			 throw(e);
		}
	}
	
	
	
	
	public void timeout() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	  @AfterTest
	    public static void endTest()
	    {
	   extent.flush();
	    }

}
