package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.DashBordRahul;
import pageObjects.LoginPageR;
import testBase.BaseClass;

public class TC_04_AddingProductToCart extends BaseClass {

	String id;
	String prodName = "ZARA COAT 3";

	@Test
	public void appLogin() {

		LoginPageR lpage = new LoginPageR(driver);

		lpage.loginToApplication(p.getProperty("uName"), p.getProperty("uPass"));

		String sysTitle = lpage.titleVerification();

		Assert.assertEquals(sysTitle, "Let's Shop");
	}

	@Test(dependsOnMethods = "appLogin")
	public void selectProductFromHomepage() throws InterruptedException {

		DashBordRahul dpage = new DashBordRahul(driver);

		dpage.selectingProduct(prodName);

		String num = dpage.prodNumInCart();

//		Thread.sleep(3000);

//		dpage.logout();

		dpage.clickCartbtn();
		Assert.assertEquals(num, "1");

	}

	@Test(dependsOnMethods = { "appLogin", "selectProductFromHomepage" })
	public void cartPage() throws InterruptedException {

		CartPage cpage = new CartPage(driver);

		this.id = cpage.getOrderId();
		System.out.println("order id is :" + this.id);

//		cpage.clickCheckoutBtn();
		Thread.sleep(3000);
		String productName = cpage.pName();
		System.out.println("Product Name  is :"+productName);
		

		if (productName.equalsIgnoreCase(prodName)) {

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}
		
		cpage.clickCheckoutBtn();
//		cpage.clickCheckoutBtn();
		cpage.logout();
	}

}
