package sfdc.page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.reusable_code.SFDC_Reusable_Methods;

public class SFDC_Developer_Console_Page extends SFDC_Reusable_Methods {
	
	WebDriver driver;

	public SFDC_Developer_Console_Page(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Defining all the user actions (Methods) that can be performed in the SFDC Developer Console page

		// This method is to get current url
	
	public String getCurrentUrl() {

		return driver.getCurrentUrl();

	}
	
	// This method is to get current url
	
	public void closeWindow() {

		 driver.close();

	}
	

}
