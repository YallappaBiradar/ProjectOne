package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashBordRahul;
import pageObjects.LoginPageR;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_DDT_Rahul extends BaseClass {

	@Test(dataProvider = "logindata", dataProviderClass = DataProviders.class) // getting data from different class and
																				// package
	public void dataDrivenLogin(String email, String pwd, String exp) {

		try {
			LoginPageR lpage = new LoginPageR(driver);

			lpage.setUsername(email);

			lpage.setPassword(pwd);
			lpage.clickLoginBtn();

			String sysTitle = lpage.titleVerification();

			DashBordRahul dpage = new DashBordRahul(driver);

//	(1)	 Data is valid -> Login success - test pass - logout
//						login failed - test fail

//		 (2) Data is invalid - > Login success - test fail
//								login failed - test pass

			if (exp.equalsIgnoreCase("valid")) {

				if (sysTitle.equals("Let's Shop")) {

					dpage.logout();
					Assert.assertEquals(sysTitle, "Let's Shop");
				} else {

//				Assert.assertTrue(false);
					Assert.fail();
				}
			}

			if (exp.equalsIgnoreCase("invalid")) {

				if (sysTitle.equals("Let's Shop")) {

					dpage.logout();
//				Assert.fail();
					Assert.assertTrue(false);
				} else {

					Assert.assertTrue(true);
				}

			}

		} catch (Exception e) {
			Assert.fail();
		}
	}

}
