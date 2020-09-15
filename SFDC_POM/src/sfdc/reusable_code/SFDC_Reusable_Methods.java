package sfdc.reusable_code;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDC_Reusable_Methods {
	
	public static ExtentTest logger;
	public static ExtentReports report;
	public static WebDriver driver;
	
	/*
	 * Name of the Method : InitializeDriver 
	 * Brief Description : This will initialize browser (chrome, firefox, edge, opera, ie) 
	 * Arguments : String browserName
	 * Created By : Deepika Pathinga 
	 * Created Date : 04/14/2020 
	 * Last Modified : 04/14/2020
	 */
	public static void initializeDriver(String browserName) throws Exception {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
	}
	
	/*
	 * Name of the Method: createReport 
	 * Brief Description : This will create a empty Extent Report. 
	 * Arguments : No Arguments 
	 * Created By : Deepika Pathinga 
	 * Created Date : 04/14/2020 
	 * Last Modified : 04/14/2020
	 */
	public static void createReport() {
		String fileName = new SimpleDateFormat("'SFDCReport_'YYYYMMddHHmmss'.html'").format(new Date());
		String path = "C:\\Users\\deepi\\Desktop\\SFDC_Report\\" + fileName;
		report = new ExtentReports(path);
	}
	
	/*
	 * name of the Method : OpenUrl
	 * Brief Description  : This will open the url passed and maximizes the window screen
	 * Arguments		  : String -> url
	 * Created By 		  : Deepika Pathinga
	 * created Date		  : 04/14/2020
	 * Last Modified	  : 04/14/2020
	 */
	public static void openUrl(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	/* name of the method:   EnterText
	 * BriefDescription  :   entering text value for textbox
	 * Arguments         :  element --->object
	 *                      text    --->to be entered 
	 *                      objName --->object name
	 *  createdby        :  Automation team 
	 *  created date     :  04/14/20209 
	 *  LastModified Date:  04/14/2020          
	 */
	public static void enterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) 
			logger.log(LogStatus.ERROR, objName + " Textbox is not found or its empty.");
		else 
			element.sendKeys(text);
			logger.log(LogStatus.INFO, text + " is entered in the " + objName + " field");
		}
	
	/* name of the method:   Clear
	 * BriefDescription  :   clearing text value for textbox
	 * Arguments         :  element --->object
	 *                      objName --->object name
	 *  createdby        :  Deepika Pathinga 
	 *  created date     :  04/14/2020
	 *  LastModified Date:  04/14/2020          
	 */
	public static void clear(WebElement element, String objName) {		
		if(!element.isDisplayed())
			logger.log(LogStatus.ERROR, objName + "Textbox is not found");
		else 
			element.clear();
			logger.log(LogStatus.INFO, objName + " is cleared from the field");
	}
	
	/* name of the method:   Click
	 * BriefDescription  :   Clicking the webelement
	 * Arguments         :  element --->object
	 *                      objName --->object name
	 *  createdby        :  Deepika Pathinga
	 *  created date     :  04/14/2020
	 *  LastModified Date:  04/14/2020          
	 */
	public static void click(WebElement element, String objName) throws InterruptedException {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {			
			element.click();
			logger.log(LogStatus.INFO, objName + " Element is found and clicked");
			Thread.sleep(1000);
		}
	}
	

	/*
	 * name of the Method : CloseBrowser
	 * Brief Description  : This will close the browser
	 * Arguments		  : No Arguments
	 * Created By 		  : Deepika Pathinga
	 * created Date		  : 04/14/2020
	 * Last Modified	  : 04/14/2020
	 */
	public static void closeBrowser() {
		driver.quit();
	}

	/*
	 * name of the Method : CloseReport
	 * Brief Description  : This will generate the report
	 * Arguments		  : No Arguments
	 * Created By 		  : Deepika Pathinga
	 * created Date		  : 04/14/2020
	 * Last Modified	  : 04/14/2020
	 */
	public static void closeReport() {
		report.flush();
	}	

}
