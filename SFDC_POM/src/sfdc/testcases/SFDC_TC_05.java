package sfdc.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import sfdc.page_factory.SFDC_Login_Page;

public class SFDC_TC_05 extends SFDC_Test_Base {
	
	@Test(dataProvider = "data-provider-url,username,password")
	public static void TC_04_B_ForgotPassword(String url, String username, String password) throws InterruptedException {

		logger = report.startTest("TC_04_B_ForgotPassword");
		logger.log(LogStatus.INFO, "Starting SFDC TC_04_B_ForgotPassword...");

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

		// Step 2: Enter wrong username 123
		//Step 2: Enter username
		LP.setUserName("123");		
		logger.log(LogStatus.PASS, "Wrong Username is entered");

		// Step 3: Enter wrong password 22131
		LP.setPassword("22131");
		logger.log(LogStatus.PASS, "Wrong Password is entered");

		// Step 4A: Click login
		LP.clickOnLoginButton();

		// Step 4B: Error message is displayed
		String errormessage = LP.errorMessage();

		if (errormessage.equals(
				"Please check your username and password. If you still can't log in, contact your Salesforce administrator."))
			logger.log(LogStatus.PASS,
					"Error message \'Please check your username and password. If you still can't log in, contact your Salesforce administrator.\' is displayed.");
		else
			logger.log(LogStatus.FAIL, "Error message is not displayed.");
		
		logger.log(LogStatus.INFO, "TC_04_B_ForgotPassword completed successfully");

	}

}
