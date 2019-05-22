package Job_Menus;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Browser.Browser_open;
import RepositoryParser.Opt_Respository_parser;

public class job_list_Add extends Browser_open{
	@Test(description="Select job list menu",priority=17)
	public void selectJoblist_menu() throws Exception {
		try {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Joblist_Dashboard_Btn"))).click();
	   timeout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Dashboard_Job_Joblist"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_list_select"))).click();
		logger.info("Job list menu selected");
		Test =extent.createTest("TC-7:Job list");
		 Test.log(Status.PASS,"Selected job list menu");
		} catch(Exception  e) {
			logger.error("Error occurred in select job list menu");
			logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Test Case Failed is Select job list menu-"+exception);
			 throw(e);
		}
	}
	@Test(description="Add new job",priority=18)
	public String Addnew_job() throws Exception {
		try {
			
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Joblist_Btn_Create"))).click();
	//Customer name select		
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_customername"))).sendKeys(sheet3.getRow(2).getCell(1).getStringCellValue());
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_customername"))).sendKeys(Keys.ARROW_DOWN);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_customername"))).sendKeys(Keys.ENTER);
	
	//Client name select		
	driver.findElement(parser.getbjectLocator("Job_Txt_client_name")).sendKeys(sheet3.getRow(3).getCell(1).getStringCellValue());
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_client_name"))).sendKeys(Keys.ARROW_DOWN);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_client_name"))).sendKeys(Keys.ENTER);
	
	//Priority drop down select 
	 Select Selpriority = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_DD_Priority"))));
	 Selpriority.selectByVisibleText(sheet3.getRow(4).getCell(1).getStringCellValue());
	 Selpriority.selectByIndex(1);
	 
	//Category selection
	driver.findElement(parser.getbjectLocator("Job_Txt_Category_name")).sendKeys(sheet3.getRow(5).getCell(1).getStringCellValue());
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_Category_name"))).sendKeys(Keys.ARROW_DOWN);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_Category_name"))).sendKeys(Keys.ENTER);
	
	//User selection
	driver.findElement(parser.getbjectLocator("Job_Txt_Username")).sendKeys(sheet3.getRow(6).getCell(1).getStringCellValue());
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_Username"))).sendKeys(Keys.ARROW_DOWN);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_Username"))).sendKeys(Keys.ENTER);

	//Select service address
	Select Selserviceadd = new Select(driver.findElement(parser.getbjectLocator("Job_DD_Serviceaddress")));
	Selserviceadd.selectByIndex(1);
	 
	//Select billing address
	Select Selbillingadd = new Select(driver.findElement(parser.getbjectLocator("Job_DD_Billingaddress")));
	Selbillingadd.selectByIndex(1);
	
	//Template selection
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Template_DD"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Tem_sel_service"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Job_header_click"))).click();
	
	
	//Start and due date select
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Startdate"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Select_Today"))).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_DueDT"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Sel_Next_month"))).click();
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Fin_dueDT"))).click();
	
	
	//Service item 1 add
	driver.findElement(parser.getbjectLocator("Job_Serviceitem_TXT")).sendKeys(sheet3.getRow(11).getCell(1).getStringCellValue());
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Serviceitem_TXT"))).sendKeys(Keys.ARROW_DOWN);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Serviceitem_TXT"))).sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Serviceitem_TXT"))).sendKeys(Keys.TAB);
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Serviceadd_btn"))).click();
	
	//Service item 2 add
	driver.findElement(parser.getbjectLocator("Job_Serviceitem_TXT")).sendKeys(sheet3.getRow(12).getCell(1).getStringCellValue());
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Serviceitem_TXT"))).sendKeys(Keys.ARROW_DOWN);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Serviceitem_TXT"))).sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Serviceitem_TXT"))).sendKeys(Keys.TAB);
	timeout();
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Serviceadd_btn"))).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Note_tab"))).click();
	 jobcode=wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_txtcode"))).getAttribute("value");
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txtjobnots"))).sendKeys(sheet3.getRow(14).getCell(1).getStringCellValue()+"-"+jobcode);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Btn_save"))).click();
	
	logger.info("Job saved sucessfully,Job code:"+ jobcode);  
	 Test.log(Status.PASS,"Add new job");
	 timeout();
      return jobcode;
		} catch(Exception  e) {
			logger.error("Error occurred in add new job");
			logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 Test.log(Status.FAIL, "Add new job-"+exception);
			 throw(e);
		}
	}
		
	public void timeout() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	
}
