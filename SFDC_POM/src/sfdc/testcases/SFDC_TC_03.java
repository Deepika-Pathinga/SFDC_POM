package sfdc.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import sfdc.page_factory.SFDC_Home_Page;
import sfdc.page_factory.SFDC_Login_Page;

public class SFDC_TC_03 extends SFDC_Test_Base {
	
	@Test(dataProvider = "data-provider-url,username,password")
	public static void TC_03_CheckRememberMe(String url, String username, String password) throws InterruptedException {

		logger = report.startTest("TC_03_CheckRememberMe");
		logger.log(LogStatus.INFO, "Starting SFDC TC_03_CheckRememberMe...");
		
		//Step 1A: Open SFDC URL
		openUrl(url);
		
		//Step 1B: Create an object for login page
		SFDC_Login_Page LP = new SFDC_Login_Page(driver);
				
		//Step 1C: Explicit wait to load SFDC Login page
		WebDriverWait login_wait = new WebDriverWait(driver, 10);
		login_wait.until(ExpectedConditions.titleIs("Login | Salesforce"));
				
		// Step 1D: SFDC application page should be displayed
		String expected = "Login | Salesforce";
		String actual = LP.titleOfLoginPage();

		Assert.assertEquals(actual, expected);
		logger.log(LogStatus.INFO, "SFDC Login page is displayed");
						
		//Step 2: Enter username
		LP.setUserName(username);
		
		// Step 2B: Enter Valid password
		LP.setPassword(password);

		// Step 2C: check remember me
		LP.clickOnCheckBox();

		// Step 2D: click login
		LP.clickOnLoginButton();

		// Step 2E: Create an object for home page
		SFDC_Home_Page HP = new SFDC_Home_Page(driver);

		// Home page should be displayed
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = HP.titleOfHomePage();

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			logger.log(LogStatus.PASS, "Home page is displayed");
			// logger.log(LogStatus.INFO, logger.addScreenCapture(takeScreenShot()));
		} else
			logger.log(LogStatus.FAIL, "Home page is not displayed");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	

		// Step 3A: In home page, click on usermenu for username
		HP.clickOnUserMenu();

		// Step 3B: Select logout from the option
		HP.clickOnLogout();

		// Step 3C: Login page with username populated and checkbox with check is displayed
		String expectedTitleLogout = "Login | Salesforce";
		String actualTitleLogout = LP.titleOfLoginPage();

		if (actualTitleLogout.equalsIgnoreCase(expectedTitleLogout)) {

			String Usernamepopulated = LP.userNamePopulated();			
						
			boolean checked = LP.getCheckboxchecked();

					if (Usernamepopulated.equalsIgnoreCase("deepika@tekarch.com") && (checked == true))
						logger.log(LogStatus.PASS,
								"After Logout, Login sales force page is displayed with Username populated and remember me checked");
					else
						logger.log(LogStatus.FAIL, "After LogOut, Username is not populated and/or remember me is not checked");
		}		
		else
			logger.log(LogStatus.FAIL, "Logout is not successfull and Login page is not displayed");

		// Step 4A: validate the username in username field
		String validUsername = LP.userNamePopulated();

		if (validUsername.equals("deepika@tekarch.com"))
			logger.log(LogStatus.PASS, "Username displayed in Username field is successfully validated");
		else
			logger.log(LogStatus.FAIL, "Username validation = fail");		
				
		logger.log(LogStatus.INFO, "TC_03_CheckRememberMe completed successfully");
	}

}
