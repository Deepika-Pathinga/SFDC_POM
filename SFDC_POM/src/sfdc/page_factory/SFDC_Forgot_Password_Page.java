package sfdc.page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.reusable_code.SFDC_Reusable_Methods;

public class SFDC_Forgot_Password_Page extends SFDC_Reusable_Methods {
	
	WebDriver driver;

	public SFDC_Forgot_Password_Page(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// All WebElements are identified by @FindBy annotation
	@FindBy(xpath = "//*[@id=\"un\"]")
	WebElement Uname;
	
	@FindBy(xpath = "//*[@id=\"continue\"]")
	WebElement continueButton;
	
	// Defining all the user actions (Methods) that can be performed in the SFDC Forgot password page

		// This method is to enter username in the email text box
		public void setUserName(String strUserName) {

			// Uname.sendKeys(strUserName);
			enterText(Uname, strUserName, "Username");
		}
		
		// This method is to click on continue button
		public void clickOnContinueButton() throws InterruptedException {

			click(continueButton, "Continue Button");

		}
	

}
