package sfdc.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import sfdc.page_factory.SFDC_Home_Page;
import sfdc.page_factory.SFDC_Login_Page;

public class SFDC_TC_10 extends SFDC_Test_Base {

	@Test(dataProvider = "data-provider-url,username,password")
	public static void TC_18_Stuck(String url, String username, String password) throws InterruptedException {
		logger = report.startTest("TC_18_Stuck");
		logger.log(LogStatus.INFO, "Starting SFDC TC_18_Stuck...");

		// Step 1A: Open SFDC URL
		openUrl(url);

		// Create an object for login page
		SFDC_Login_Page LP = new SFDC_Login_Page(driver);

		// Explicit wait to load SFDC Login page
		WebDriverWait login_wait = new WebDriverWait(driver, 10);
		login_wait.until(ExpectedConditions.titleIs("Login | Salesforce"));

		// SFDC application page should be displayed
		String expected = "Login | Salesforce";
		String actual = LP.titleOfLoginPage();

		Assert.assertEquals(actual, expected);
		logger.log(LogStatus.INFO, "SFDC Login page is displayed");

		// Enter username
		LP.setUserName(username);

		// Enter valid password
		LP.setPassword(password);

		// Click Login Button
		LP.clickOnLoginButton();

		// Create an object for home page
		SFDC_Home_Page HP = new SFDC_Home_Page(driver);

		// Home page should be displayed
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = HP.titleOfHomePage();

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			logger.log(LogStatus.PASS, "Home page is displayed");
			// logger.log(LogStatus.INFO, logger.addScreenCapture(takeScreenShot()));
		} else
			logger.log(LogStatus.FAIL, "Home page is not displayed");

		// Step 2: click Opportunities
		Thread.sleep(5000);
		HP.clickOnOpportunities();
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "Entered Opportunities page");

		// Opportunities page should be displayed
		String expectedpage = "Opportunities: Home ~ Salesforce - Developer Edition";
		String actualpage = driver.getTitle();

		if (actualpage.equalsIgnoreCase(expectedpage)) {
			logger.log(LogStatus.PASS, "Opportunities page is displayed");
			// logger.log(LogStatus.INFO, logger.addScreenCapture(takeScreenShot()));
		} else
			logger.log(LogStatus.FAIL, "Opportunities page is not displayed");

		// Step 3: Click opportunity Stuck link
		Thread.sleep(5000);
		HP.clickOnStuck();

		Thread.sleep(5000);
		// Opportunities page should be displayed
		String expectedstuck = "Stuck Opportunities ~ Salesforce - Developer Edition";
		String actualstuck = driver.getTitle();

		if (actualstuck.equalsIgnoreCase(expectedstuck)) {
			logger.log(LogStatus.PASS, "Opportunities Pipeline page is displayed");
			// logger.log(LogStatus.INFO, logger.addScreenCapture(takeScreenShot()));
		} else
			logger.log(LogStatus.FAIL, "Opportunities pipeline page is not displayed");

		logger.log(LogStatus.INFO, "TC_18_Stuck completed successfully");

	}

}
