package sfdc.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import sfdc.page_factory.SFDC_Check_Your_Email_Page;
import sfdc.page_factory.SFDC_Forgot_Password_Page;
import sfdc.page_factory.SFDC_Login_Page;

public class SFDC_TC_04 extends SFDC_Test_Base {
	
	@Test(dataProvider = "data-provider-url,username,password")
	public static void TC_04_A_ForgotPassword(String url, String username, String password) throws InterruptedException {
		
		logger = report.startTest("TC_04_A_ForgotPassword");
		logger.log(LogStatus.INFO, "Starting SFDC TC_04_A_ForgotPassword...");

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

		// Step 2A: click forgot password button
		LP.clickOnForgotPasswordLink();

		// Step 2B: Forgot Password page is displayed
		String expectedTitleForgotPassword = "Forgot Your Password | Salesforce";
		String actualTitleForgotPassword = driver.getTitle();

		if (actualTitleForgotPassword.equalsIgnoreCase(expectedTitleForgotPassword))
			logger.log(LogStatus.PASS, "Salesforce forgot password page is displayed");
		else
			logger.log(LogStatus.FAIL, "Salesforce forgot password page is not displayed");

		// Step 3A: Create an object for forgot password page
		SFDC_Forgot_Password_Page FPP = new SFDC_Forgot_Password_Page(driver);

		// Step 3B: Provide username in forgot password page
		FPP.setUserName(username);
		
		// Step 3C: click continue button
		FPP.clickOnContinueButton();

		// Step 3D: Create an object for check your email page
		SFDC_Check_Your_Email_Page CYEP = new SFDC_Check_Your_Email_Page(driver);
		
		//Password reset message page is displayed
		String expectedTitleCheckEmail = "Check Your Email | Salesforce";
		String actualTitleCheckEmail = CYEP.titleOfCheckYourEmailPage();

		if (actualTitleCheckEmail.equalsIgnoreCase(expectedTitleCheckEmail))
			logger.log(LogStatus.PASS, "Password reset message page is displayed and an Email is sent");
		else
			logger.log(LogStatus.FAIL, "Password reset message page is not displayed");
		
		logger.log(LogStatus.INFO, "TC_04_A_ForgotPassword completed successfully");

	}

}
