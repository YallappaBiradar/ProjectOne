package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegestrationPageRahul extends BasePage {

//	public  WebDriver driver;
	
	public RegestrationPageRahul(WebDriver driver){
		
		super(driver);
	}
	
	@FindBy(id="firstName") 
	WebElement txtFirstName;
	
	@FindBy(id="lastName")
	WebElement txtLastName;
	
	@FindBy(id="userEmail")
	WebElement txtEmail;
	
	
	@FindBy(id="userMobile")
	WebElement txtMobNo;
	
	@FindBy(xpath="//select[@formcontrolname='occupation']")
	WebElement dropdownOcc;
	
	@FindBy(xpath="//input[@value='Male']")
	WebElement radioBtnGender;
	
	@FindBy(id="userPassword")
	WebElement txtPassword;
	
	@FindBy(id="confirmPassword")
	WebElement txtConfpassword;
	
	@FindBy(xpath="//input[@formcontrolname='required']")
	WebElement checkBox;
	
	@FindBy(xpath="//input[@value='Register']")
	WebElement btnRegester;
	
	@FindBy(xpath="//h1[contains(text(),'Account Created Successfully')]")
	WebElement accRegMessage;
	
	
	
	public void setUsername(String username) {
		
		txtFirstName.sendKeys(username);
	}
	
	public void setLastname(String lastname) {
		
		txtLastName.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
	
	public void setMobNo(String mobNo) {
		
		txtMobNo.sendKeys(mobNo);
	}
	
	public void selectOccupancy(String option) {
		
		Select select = new Select(dropdownOcc);
		select.selectByVisibleText(option);
//		select.selectByValue(option); 
		
	}
	
	public void selectGender() {
		
		radioBtnGender.click();
	}
	
	public void setPassword(String password) {
		
		txtPassword.sendKeys(password);
		
	}
	
	public void setConfPassword(String password) {
		
		txtConfpassword.sendKeys(password);
	}
	
	public void clickCheckBox() {
		
		checkBox.click();
	}
	
	public void clickRegBtn() {
		
		btnRegester.click();
	}
	
	public String confMessage() {
		
		String msg = accRegMessage.getText();
		return msg;
	} 
	
	
	
}
