package Job_Menus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Browser.Browser_open;

public class Job_list_Edit extends Browser_open{
	
	@Test(description="Select job list menu",priority=19)
	public void Edit_job_list() throws Exception {
		try {
			//Pass the job code value in another class
			job_list_Add listadd= new job_list_Add();
			String  Returnjobcode= listadd.Addnew_job();
			System.out.println(Returnjobcode);
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Btn_Return"))).click();
			timeout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_srch_code"))).sendKeys(Returnjobcode);
			timeout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_srch_code"))).sendKeys(Keys.ARROW_DOWN);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Txt_srch_code"))).sendKeys(Keys.ENTER);
			timeout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Btn_Search"))).click();
			timeout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_joblist_edit"))).click();
			Thread.sleep(5000);
			//Additional user add
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_additional_user_chkbox"))).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Add_user"))).sendKeys(sheet3.getRow(15).getCell(1).getStringCellValue());
			 timeout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Add_user"))).sendKeys(Keys.ARROW_DOWN);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Add_user"))).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Add_user_Btn"))).click();
			timeout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Add_user"))).sendKeys(sheet3.getRow(16).getCell(1).getStringCellValue());
			timeout();
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Add_user"))).sendKeys(Keys.ARROW_DOWN);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Add_user"))).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Add_user_Btn"))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_document_tab"))).click();
			
			//////////////////////////////////////////////////////////////////////////////////////////////////
//			 wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Doc_Add_Btn"))).click();
//			
//	         WebElement uploadElement = driver.findElement(parser.getbjectLocator("Job_doc_browse_Btn"));
//	         // enter the file path onto the file-selection input field
//	         uploadElement.sendKeys("E:/Ashok/selenium Notes/Ashok/Form_CCF_nonaadhar.pdf");
//	         // check the "I accept the terms of service" check box
//	         driver.findElement(By.id("terms")).click();
//
//	           // click the "UploadFile" button
//	           driver.findElement(By.name("send")).click();
            //////////////////////////////////////////////////////////////////////////////////////////////////
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Job_Btn_Save_new"))).click();
			logger.info("Job updated sucessfully,Job code:"+ Returnjobcode);  
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Dashboard_Btn"))).click();
			
			Test.log(Status.PASS,"Edit new job");
	} catch(Exception  e) {
		logger.error("Error occurred in edit job");
		logger.error("Exceptions happen!", e); 
		 exception = e.getMessage();
		 Test.log(Status.FAIL, "Edit new job-"+exception);
		 throw(e);
	}
   }
	public void timeout() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	
}
