package Browser;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Logout extends Browser_open {
	
	@Test(description="Select logout",priority=24)
	public static void logout() {
		try {
			logger.info("Logout");
			wait.until(ExpectedConditions.visibilityOfElementLocated(parser.getbjectLocator("Btn_logout"))).click();
			driver.quit();
			
		} catch(Exception  e) {
			logger.error("Error occurred in logout");
			logger.error("Exceptions happen!", e); 
			 exception = e.getMessage();
			 throw(e);
		}
	}
	
	  @AfterTest
	    public static void endTest()
	    {
	   extent.flush();
	    }
}
