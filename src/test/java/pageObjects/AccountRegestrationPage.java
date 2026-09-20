package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegestrationPage extends BasePage {

	public AccountRegestrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement btnAgreeopt;
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confMessage;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);

	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {

		txtPassword.sendKeys(password);
	}

	public void clickAgreebtn() {

		btnAgreeopt.click();
	}

	public void clickContinuebtn() {
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
		String msg = confMessage.getText();
		return msg;
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
}
