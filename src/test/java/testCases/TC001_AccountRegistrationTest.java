package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegestrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	public WebDriver driver;
	
	@Test
	public void verify_Account_Registration() {
		
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyaccount();
		hp.clickRegister();
		
		AccountRegestrationPage regpage = new AccountRegestrationPage(driver);
		
		regpage.setFirstName("FirstName");
		regpage.setLastName("LastName");
		regpage.setEmail("toxic@gmail.com");
		
		regpage.setPassword("pass&097");
		
		regpage.clickAgreebtn();
		regpage.clickContinuebtn();
		
		String msg = regpage.getConfirmationMsg();
		
		Assert.assertEquals(msg, "Your Account Has Been Created");
		
	}

}
