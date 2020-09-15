package sfdc.reusable_code;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import sfdc.testcases.SFDC_Test_Base;

public class Select_Browser extends SFDC_Test_Base {

	@Test
	@Parameters("browserName")
	public void BrowserName(String browserName) throws Exception {

		if (browserName.equalsIgnoreCase("chrome")) {
			logger = report.startTest("Chrome Browser");
			logger.log(LogStatus.INFO, "Chrome browser is selected for testing");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			logger = report.startTest("Firefox Browser");
			logger.log(LogStatus.INFO, "Firefox browser is selected for testing");
		} else if (browserName.equalsIgnoreCase("opera")) {
			logger = report.startTest("Opera Browser");
			logger.log(LogStatus.INFO, "Opera browser is selected for testing");
		} else if (browserName.equalsIgnoreCase("edge")) {
			logger = report.startTest("Edge Browser");
			logger.log(LogStatus.INFO, "Microsoft Edge browser is selected for testing");
		} else if (browserName.equalsIgnoreCase("ie")) {
			logger = report.startTest("Internet Explorer Browser");
			logger.log(LogStatus.INFO, "Internet Explorer is selected for testing");
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

	}

}
