package sfdc.page_factory;

import sfdc.reusable_code.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SFDC_Login_Page extends SFDC_Reusable_Methods {

	WebDriver driver;

	public SFDC_Login_Page(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// All WebElements are identified by @FindBy annotation

	@FindBy(xpath = "//input[@id='username']")
	WebElement Uname;

	@FindBy(xpath = "//input[@id='password']")
	WebElement pwd;

	@FindBy(xpath = "//*[@id=\"login_form\"]/div[3]/label")
	WebElement checkbox;

	@FindBy(xpath = "//*[@id='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"error\"]")
	WebElement error;

	@FindBy(xpath = "//*[@id=\"idcard-identity\"]")
	WebElement Usernamepopulated;

	@FindBy(xpath = "//input[@id='rememberUn']")
	WebElement Checkboxchecked;

	@FindBy(xpath = "//a[@id='forgot_password_link']") // *[@id=\\\"forgot_password_link\\\"]
	WebElement forgotPasswordBtn;

	// Defining all the user actions (Methods) that can be performed in the SFDC
	// Login page

	// This method is to set Email in the email text box (Username)
	public void setUserName(String strUserName) {

		// Uname.sendKeys(strUserName);
		enterText(Uname, strUserName, "Username");
	}

	// This method is to set Password in the password text box
	public void setPassword(String strPassword) {

		// pwd.sendKeys(strPassword);
		enterText(pwd, strPassword, "Password");

	}

	// This method is to clear Password in the password text box
	public void clearPassword() {

		clear(pwd, "Password");

	}

	// This method is to click on checkbox
	public void clickOnCheckBox() throws InterruptedException {

		click(checkbox, "Check box");

	}

	// This method is to click on login button
	public void clickOnLoginButton() throws InterruptedException {

		// loginBtn.click();
		click(loginBtn, "Login Button");

	}
	
	// This method is to login to the SFDC application and go to homepage
	
	/**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return
	 * @throws InterruptedException 

     */

    public void loginToSFDC(String strUserName,String strPasword) throws InterruptedException{

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickOnLoginButton();           

    }

	// This method is to click on Forgot Password Link
	public void clickOnForgotPasswordLink() throws InterruptedException {

		click(forgotPasswordBtn, "Forgot Password Button");

	}

	// This method is to get error message for invalid username or password
	public String errorMessage() {

		return error.getText();

	}

	// This method is to get username populated
	public String userNamePopulated() {

		return Usernamepopulated.getText();

	}

	// This method is to get title of login page
	public String titleOfLoginPage() {

		return driver.getTitle();

	}

	// This method is to get boolean value of Checkboxchecked webelement
	public boolean getCheckboxchecked() {

		return Checkboxchecked.isSelected();

	}

}
