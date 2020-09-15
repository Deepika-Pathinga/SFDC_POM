package sfdc.page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import sfdc.reusable_code.SFDC_Reusable_Methods;

public class SFDC_Home_Page extends SFDC_Reusable_Methods {

	WebDriver driver;

	public SFDC_Home_Page(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// All WebElements are identified by @FindBy annotation

	@FindBy(xpath = "//span[@id='userNavLabel']") // div[@id='userNavButton'] //div[@id='userNav']
	WebElement userMenu;

	@FindBy(partialLinkText = "Logout")
	WebElement logOut;

	@FindBy(xpath = "//*[@id=\"userNav-arrow\"]")
	WebElement check_usermenu_dropdown;

	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement check_myprofile;

	@FindBy(xpath = "//a[contains(text(),'My Settings')]")
	WebElement check_mysettings;

	@FindBy(xpath = "//a[@class='debugLogLink menuButtonMenuLink']")
	WebElement check_developerconsole;

	@FindBy(xpath = "//a[@class='menuButtonMenuLink'][contains(text(),'Switch to Lightning Experience')]")
	WebElement check_switchtolighting;

	@FindBy(xpath = "//a[contains(text(),'Opportunities')]")
	WebElement opty;

	// These are from Opportunities page
	@FindBy(xpath = "//a[contains(text(),'Opportunity Pipeline')]")
	WebElement pipe;
	@FindBy(xpath = "//a[contains(text(),'Stuck Opportunities')]")
	WebElement stuck;

	// Defining all the user actions (Methods) that can be performed in the SFDC
	// Home page

	// This method is to click on UserMenu
	public void clickOnUserMenu() throws InterruptedException {

		if (userMenu.isDisplayed()) {
			click(userMenu, "User menu");
		}

	}

	// This method is to click on Developer Console
	public void clickOnDeveloperConsole() throws InterruptedException {

		click(check_developerconsole, "My Profile");

	}

	// This method is to click on Logout
	public void clickOnLogout() throws InterruptedException {

		click(logOut, "Logout");

	}

	// This method is to click on Opportunities
	public void clickOnOpportunities() throws InterruptedException {

		click(opty, "Opportunities");

	}

	// This method is to get title of home page
	public String titleOfHomePage() {

		return driver.getTitle();

	}

	// This method is to get boolean value of check_usermenu_dropdown webelement
	public boolean checkUserMenuDropdown() {

		return check_usermenu_dropdown.isDisplayed();

	}

	// This method is to get boolean value of myprofile webelement
	public boolean checkMyProfile() {

		return check_myprofile.isDisplayed();

	}

	// This method is to get boolean value of MySettings webelement
	public boolean checkMySettings() {

		return check_mysettings.isDisplayed();

	}

	// This method is to get boolean value of Developer Console webelement
	public boolean checkDeveloperConsole() {

		return check_developerconsole.isDisplayed();

	}

	// This method is to get boolean value of Switch to Lighting webelement
	public boolean checkSwitchToLighting() {

		return check_switchtolighting.isDisplayed();

	}

	// This method is to get boolean value of Logout webelement
	public boolean checkLogout() {

		return logOut.isDisplayed();

	}

	// This method is to click on Opportunities pipeline link, this is from
	// Opportunities page
	public void clickOnOpportunitiesPipeline() throws InterruptedException {

		click(pipe, "Opportunities Pipeline");

	}

	// This method is to click on stuck pipeline link, this is from Opportunities
	// page
	public void clickOnStuck() throws InterruptedException {

		click(stuck, "Opportunities Stuck");

	}

}
