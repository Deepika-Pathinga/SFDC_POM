package sfdc.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import sfdc.page_factory.SFDC_Developer_Console_Page;
import sfdc.page_factory.SFDC_Home_Page;
import sfdc.page_factory.SFDC_Login_Page;

public class SFDC_TC_07 extends SFDC_Test_Base {

	@Test(dataProvider = "data-provider-url,username,password")
	public static void TC_08_UserMenu(String url, String username, String password)
			throws InterruptedException, AWTException {

		logger = report.startTest("TC_08_UserMenu");
		logger.log(LogStatus.INFO, "Starting SFDC TC_08_UserMenu...");

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

		// Enter username, password and click on login
		LP.loginToSFDC(username, password);
//		LP.setUserName(username);
//
//		// Enter valid password
//		LP.setPassword(password);
//
//		// Click Login Button
//		LP.clickOnLoginButton();

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

		// Step 1B: click on the user menu
		HP.clickOnUserMenu();

		// Step 1C: Drop down with "My profile", "My Settings", "Developer
		// Console","Logout" , "Switching to lightning Experience" is displayed
		boolean check_myprofile = HP.checkMyProfile();
		boolean check_mysettings = HP.checkMySettings();
		boolean check_developerconsole = HP.checkDeveloperConsole();
		boolean check_switchtolighting = HP.checkSwitchToLighting();
		boolean check_logout = HP.checkLogout();

		if (check_myprofile && check_mysettings && check_developerconsole && check_switchtolighting
				&& check_logout == true)
			logger.log(LogStatus.PASS,
					"User menu Drop down with \"My profile\", \"My Settings\", \"Developer Console\", \"Switching to lightning Experience\", \"Logout\" is displayed");
		else
			logger.log(LogStatus.FAIL, "User menu Drop down is not displayed");

		// Step 2: Click Developer Console option from user menu
		HP.clickOnDeveloperConsole();

		// Step 3: closing the dev window
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		// System.out.println(getAllWindows.size());
		driver.switchTo().window(getWindow[1]);
		// System.out.println(driver.getCurrentUrl());
		SFDC_Developer_Console_Page DCP = new SFDC_Developer_Console_Page(driver);
//		String Actual = DCP.getCurrentUrl();
//		String Expected = "https://na174.salesforce.com/_ui/common/apex/debug/ApexCSIPage";
//		if (Actual == Expected)
//			logger.log(LogStatus.PASS, "In Developer Console page");
//		else
//			logger.log(LogStatus.FAIL, "Not In Developer Console page");
		Thread.sleep(3000);
		DCP.closeWindow();
		logger.log(LogStatus.INFO, "Developer Console page is closed");
		Thread.sleep(5000);
		logger.log(LogStatus.INFO, "TC_08_UserMenu completed successfully");

	}

}
