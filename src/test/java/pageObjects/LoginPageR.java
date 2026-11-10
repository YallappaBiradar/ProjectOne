package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageR extends BasePage {

//	public WebDriver driver;
	public LoginPageR(WebDriver driver) {

		super(driver);
	}

	@FindBy(id = "userEmail")
	WebElement txtUsername;

	@FindBy(id = "userPassword")
	WebElement txtPassword;

	@FindBy(id = "login")
	WebElement btnlogin;

	public void loginToApplication(String username, String password) {

		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnlogin.click();

	}

	public void setUsername(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		
		btnlogin.click();
	}

	public String titleVerification() {
		// String title = driver.getTitle();
		return driver.getTitle();
	}

}
