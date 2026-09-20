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

public class TC001_AccountRegistrationTest {

	WebDriver driver;
	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
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
