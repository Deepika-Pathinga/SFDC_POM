package sfdc.testcases;

import java.io.IOException;

import sfdc.page_factory.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class SFDC_TC_01 extends SFDC_Test_Base {
	
	@Test(dataProvider = "data-provider-url,username,password")
	public static void TC_01_LoginErrorMessage(String url, String username, String password) throws InterruptedException, IOException {

		logger = report.startTest("TC_01_LoginErrorMessage");
		logger.log(LogStatus.INFO, "Starting SFDC TC_01_LoginErrorMessage...");
		
		//Step 1A: Open SFDC URL
		openUrl(url);
		
		//Step 1B: Explicit wait to load SFDC Login page
		WebDriverWait login_wait = new WebDriverWait(driver, 10);
		login_wait.until(ExpectedConditions.titleIs("Login | Salesforce"));
		
		//Step 1C: Create an object for login page
		SFDC_Login_Page LP = new SFDC_Login_Page(driver);
		
		// Step 1D: SFDC application page should be displayed
		String expected = "Login | Salesforce";
		String actual = LP.titleOfLoginPage();

		Assert.assertEquals(actual, expected);
		logger.log(LogStatus.INFO, "SFDC Login page is displayed");
				
		//Step 2: Enter username
		LP.setUserName(username);
		
		//Step 3: Clear Password field
		LP.clearPassword();
		
		//Step 4A: Click Login Button
		LP.clickOnLoginButton();
		
		//Step 4B: Error message should be displayed
		String error_message = LP.errorMessage();
		
		if (error_message.equals("Please enter your password.")) {
			logger.log(LogStatus.PASS, "Error message \'Please enter your password.\' is displayed.");
			//logger.log(LogStatus.INFO, logger.addScreenCapture(takeScreenShot()));
		}
			
		else
			logger.log(LogStatus.FAIL, "Error message is not displayed.");
		
		logger.log(LogStatus.INFO, "TC_01_LoginErrorMessage completed successfully");
	}

}
