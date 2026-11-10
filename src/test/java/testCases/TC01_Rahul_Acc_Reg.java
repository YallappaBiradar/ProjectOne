package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage_Rahul;
import pageObjects.RegestrationPageRahul;
import testBase.BaseClass;

public class TC01_Rahul_Acc_Reg extends BaseClass {

//	public WebDriver driver;

	@Test
	public void regPage() throws InterruptedException {

		Homepage_Rahul hPage = new Homepage_Rahul(driver);

		hPage.regesterPageLink();

		RegestrationPageRahul rPage = new RegestrationPageRahul(driver);

		rPage.setUsername(randomAlpabhet());
		rPage.setLastname(randomAlpabhet());
		rPage.setEmail(randomAlpabhet() + "@gmail.com");

		rPage.setMobNo(randomNumber());

		rPage.selectOccupancy("Student");

		rPage.selectGender();

		String pass = randomAlphaNumeric();
		System.out.println("Password is :" + pass);
		rPage.setPassword(pass);
		rPage.setConfPassword(pass);
		rPage.clickCheckBox();
		Thread.sleep(3000);
		rPage.clickRegBtn();

		String msg = rPage.confMessage();

		if (msg.equals("Account Created Successfully")) {

			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);
		}

	}

}
