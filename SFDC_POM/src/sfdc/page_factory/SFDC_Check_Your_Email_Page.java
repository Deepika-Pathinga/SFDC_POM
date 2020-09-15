package sfdc.page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import sfdc.reusable_code.SFDC_Reusable_Methods;

public class SFDC_Check_Your_Email_Page extends SFDC_Reusable_Methods {
	
	
	WebDriver driver;

	public SFDC_Check_Your_Email_Page(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	// This method is to get title of check your email page
	public String titleOfCheckYourEmailPage() {

		return driver.getTitle();

	}

}
