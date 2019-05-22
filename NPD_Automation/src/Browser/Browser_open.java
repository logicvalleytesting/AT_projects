package Browser;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import RepositoryParser.Opt_Respository_parser;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class Browser_open {
	public static WebDriver driver;
	public static Properties prop;
	public static Properties path;
	public static Opt_Respository_parser parser;
	public static Logger logger;
	public static String DEV_KEY = "15c3f985aeeb03e65d4fcd404077aea5"; //API key
	public static String SERVER_URL="http://192.168.130.204:82/testlink/lib/api/xmlrpc/v1/xmlrpc.php"; //your testlink server url
	public static String PROJECT_NAME = "GEO4S";    //Testlink project name
	public static String PLAN_NAME = "NPD_TP"; //Testlink plan name
	public static String BUILD_NAME = "Geo4s New build";   //Testlink release name
	public static String result = "";
	public static String exception = null;
	public static WebDriverWait wait;
	public static XSSFSheet sheet1;
	public static XSSFSheet sheet2;
	public static XSSFSheet sheet3;
	public static XSSFSheet sheet4;
	
	public static JavascriptExecutor js;
	//date format declared global.........
	public String jobcode;
	public static   ExtentHtmlReporter htmlReports;
    public static   ExtentReports extent;
    public static ExtentTest Test;
    public static   String filename= "./Report/ExtentReportResults.html";
	
	 @BeforeSuite 
	public void check_browser() throws InterruptedException, Exception{
		try {
			
		  logger=Logger.getLogger(Browser_open.class);
	       // configure log4j properties file
	       PropertyConfigurator.configure("log4j.properties");
	     
	       htmlReports = new ExtentHtmlReporter(filename);
	    	extent =new ExtentReports();
	    	extent.attachReporter(htmlReports);
	    	htmlReports.config().setReportName("Automation Testing");
	    	htmlReports.config().setTheme(Theme.STANDARD);
	    	htmlReports.config().setTestViewChartLocation(ChartLocation.TOP);
	    	extent.setSystemInfo("Project Name", "GEO4S");
	    	extent.setSystemInfo("User Name", "Ashok.A");
	    	extent.setSystemInfo("Environment", "Automation Testing");
	    
	    	
	    //	extent.config().setCSS("css-string");
	    

		File file = new File("./Datafile.properties");   
		File file1 = new File("./Locater.properties");
		File Excelsrc= new File("./TestData.xlsx");

	       //Live URLs 
		/*File file = new File("E:/Testing Team/Automation_Projects/NPD_Automation/Datafile.properties");
		File file1 = new File("E:/Testing Team/Automation_Projects/NPD_Automation/Locater.properties");
		File Excelsrc= new File("E:/Testing Team/Automation_Projects/NPD_Automation/TestData.xlsx");*/
		
		FileInputStream fileInput = null;
		FileInputStream fileInput1 = null;
		FileInputStream fis=new FileInputStream(Excelsrc);
		// FileInputStream fileInput2 = null; //Parser

		fileInput = new FileInputStream(file);
		fileInput1 = new FileInputStream(file1);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
			
	      // load properties file
		 prop = new Properties();
		 path = new Properties();

			prop.load(fileInput);
			path.load(fileInput1);
			
           sheet1= wb.getSheetAt(0);   ///Xlsx file calling.....
           sheet2= wb.getSheetAt(1);
           sheet3= wb.getSheetAt(2);
           sheet4= wb.getSheetAt(3);

           parser = new Opt_Respository_parser("./Locater.properties");
           
           //Live URLs 
          //parser = new Opt_Respository_parser("E:/Testing Team/Automation_Projects/NPD_Automation/Locater.properties");

           logger.info(".........Execution started.....");
  //===========================================================================================
           String Sel_driver= prop.getProperty("Driver");
            if (Sel_driver.equals("Chrome")){    //Chrome driver configuration
        	   System.setProperty("webdriver.chrome.driver",prop.getProperty("Chrome_Dri_Path"));
        	     driver = new ChromeDriver();
        		driver.get(prop.getProperty("URL"));
        		
           }else if(Sel_driver.equals("Firefox")) {    //Fire fox configuration 
        	   System.setProperty("webdriver.gecko.driver",prop.getProperty("Drivr_path_URL"));
      	     driver = new FirefoxDriver();   
      		driver.get(prop.getProperty("URL"));
      		
           }else {                  // If any thing else then default select chrome
        	   System.setProperty("webdriver.gecko.driver",prop.getProperty("Drivr_path_URL"));
        	     driver = new FirefoxDriver();   
        		driver.get(prop.getProperty("URL"));    	   
           }
           
	     driver.manage().window().maximize();
	     
	  // Wait statement using with default seconds (100 Seconds)
		 wait = new WebDriverWait(driver,20);
		 
	       logger.info("Browser opened");
	       
	       Test =extent.createTest("TC-1:Application open");
	       Test.log(Status.PASS,"Geo4s application launched using firefox browser...");
	       
	       logger.info("Browser Testtttttttttttttttttt");
	       
	       //Scroll down or up using this code
	    js = ((JavascriptExecutor) driver);
	    
	    } catch(Exception  e) {
	    	
	    	logger.error("Error occurred Browser open");
		   logger.error("Exceptions happen!", e); 
		   exception = e.getMessage();
		   Test.log(Status.FAIL, "Test Case Failed is "+exception);
		   throw(e);
        }
	}
	
	public static void updateTestLinkResult(String testCase, String exception, String result) throws TestLinkAPIException{
		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY, SERVER_URL);
		testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase, BUILD_NAME, exception, result);
		}
	
	public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("./Report/"+screenShotName+".png");
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
	
	
	
	
	
	
}
