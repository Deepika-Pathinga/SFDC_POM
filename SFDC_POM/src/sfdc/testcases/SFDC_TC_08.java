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

public class SFDC_TC_08 extends SFDC_Test_Base {
	
	@Test(dataProvider = "data-provider-url,username,password")
	public static void TC_09_UserMenu(String url, String username, String password) throws InterruptedException {
		logger = report.startTest("TC_09_UserMenu");
		logger.log(LogStatus.INFO, "Starting SFDC TC_09_UserMenu...");
		
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

		// Step 2A: Select logout from the option
		HP.clickOnLogout();

		// Step 2B: Login page is displayed
		String expectedTitleLogout = "Login | Salesforce";
		String actualTitleLogout = LP.titleOfLoginPage();

		if (actualTitleLogout.equalsIgnoreCase(expectedTitleLogout))
			logger.log(LogStatus.PASS, "After Logout, Login sales force page is displayed");
		else
			logger.log(LogStatus.FAIL, "Logout is not successfull and Login page is not displayed");
		
		logger.log(LogStatus.INFO, "TC_09_UserMenu completed successfully");

	}

}
