package sfdc.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import sfdc.reusable_code.*;

public class SFDC_Test_Base extends SFDC_Reusable_Methods {

	/*
	 * Author: Deepika Pathinga 
	 * Project: SFDC Application Testing 
	 * Date Created: Apr 14, 2020
	 */

	@BeforeTest
	public void callCreateReport() {
		createReport();
	}

	@AfterTest
	public void callCloseReport() {
		closeReport();
	}

	@BeforeMethod
	@Parameters("browserName")
	public void callInitialzeDriver(String browserName) throws Exception {
		initializeDriver(browserName);
	}

	@AfterMethod
	public void callCloseBrowser() {
		closeBrowser();
	}

	@DataProvider(name = "data-provider-url,username,password")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "https://login.salesforce.com", "deepika@tekarch.com", "tekarch2020" } };
	}

}
