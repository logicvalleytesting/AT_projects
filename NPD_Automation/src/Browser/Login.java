package Browser;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import RepositoryParser.Opt_Respository_parser;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import RepositoryParser.Opt_Respository_parser;

public class Login extends Browser_open {
	public static int password;
	@Test
	public static void NPD_Login() throws Exception{
		 try { 
			 
			 logger.info("Browser Test1213");
			  
			 //Numeric password change code======================================================
			 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
			 Cell cell = sheet1.getRow(1).getCell(1);
			 String Password = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type
			 //===================================================================
			 
	    	 //parser = new Opt_Respository_parser("E:/Eclipse projects/NPD_Automation/Locater.properties");
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("txtLoginUserName"))).sendKeys(sheet1.getRow(1).getCell(0).getStringCellValue());
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("txtLoginPassword"))).sendKeys(Password);
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("txtLoginAccountNo"))).sendKeys(sheet1.getRow(1).getCell(2).getStringCellValue());
	wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("btnSave"))).click();
	
	Thread.sleep(5000);
	                String url = driver.getCurrentUrl();
	                String gettitle=driver.getTitle();
	                //System.out.println(gettitle);
	                       //     http://geo4s.logicvalley.co.uk:83/Dashboard/Dashboard
	                if (!(url.equals("http://geo4s.logicvalley.co.uk:83/Dashboard/Dashboard"))){
	                	  driver.quit();
	                	
	                	  // Assert.assertNotEquals("Dashboard", gettitle);
	                	 logger.info("Login Details: User name: "+ (sheet1.getRow(1).getCell(0).getStringCellValue()) +" ,Account No: "+ (sheet1.getRow(1).getCell(2).getStringCellValue()));
	                	logger.error("Invalid Login credentials or User name has locked"); 
	     			   result = TestLinkAPIResults.TEST_FAILED;
	     			   updateTestLinkResult("NPD-1","Invalid Login credentials or User name has locked", result);
	     			  capture(driver,"SS_01");
	                }else {
	                 logger.info("Login Details: User name: "+ (sheet1.getRow(1).getCell(0).getStringCellValue()) +" ,Account No: "+ (sheet1.getRow(1).getCell(2).getStringCellValue()));
	                  logger.info("Login Sucessful");  
	                  result = TestLinkAPIResults.TEST_PASSED;
	       	       updateTestLinkResult("NPD-1", null, result);
	       	       
	       	    Test =extent.createTest("TC-2:Login");
  		       Test.log(Status.PASS,"Login with valid credentials");
  		     Test.log(Status.PASS,"TC-2=Login Sucessful,"+"Login credentials: User name:"+ (sheet1.getRow(1).getCell(0).getStringCellValue()) +" ,Account No: "+ (sheet1.getRow(1).getCell(2).getStringCellValue()));
  
	                }

		 } catch(Exception  e) {
		    	logger.error("Error occurred Browser open");
			 logger.error("Error occurred login");
			   logger.error("Exceptions happen in login!", e); 
			   result = TestLinkAPIResults.TEST_FAILED;
			   exception = e.getMessage();
			   updateTestLinkResult("NPD-1",exception, result);
			   
			   Test.log(Status.FAIL, "Invalid Login credentials or User name has locked -"+exception);
			   throw(e);
			  
	        }
		
	}  
	
	/* @AfterTest
	    public static void endTest()
	    {
	   extent.flush();
	    }*/
	
	
}
