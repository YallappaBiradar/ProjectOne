package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashBordRahul;
import pageObjects.LoginPageR;
import testBase.BaseClass;

public class TC02_RahulLoginPage extends BaseClass{

	@Test
	public void login() throws InterruptedException {
		
		
		LoginPageR lpage = new LoginPageR(driver);
		
		lpage.loginToApplication(p.getProperty("uName"), p.getProperty("uPass"));
		
		
		
		String sysTitle = lpage.titleVerification();
		Thread.sleep(3000);
		BaseClass b = new BaseClass();
		b.captureScreen("DashBord");
		
		DashBordRahul dpage = new DashBordRahul(driver);
		dpage.logout();
		
		Thread.sleep(3000);
		
		Assert.assertEquals(sysTitle, "Let's Shop");
		
		
	}
	
	
}
