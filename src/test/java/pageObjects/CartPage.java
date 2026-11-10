package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	
	public CartPage(WebDriver driver) {
		
		super(driver);
	}
	@FindBy(xpath="//*[contains(text(),' Sign Out ')]")
	WebElement btnSignout;
	
	@FindBy(xpath="//p[@class='itemNumber']")
	WebElement orderId;
	
	@FindBy(xpath="//*[contains(text(),'Checkout')]")
	WebElement btnCheckout;
	
	@FindBy(css="div[class='cartSection'] h3")
	WebElement productNameInCartPage;
	
	
	public String getOrderId() {
		
		String id = orderId.getText();
		
//		String orderId = id.substring(1, id.length());
		return id.substring(1, id.length());
	}
	
	public void clickCheckoutBtn() throws InterruptedException {
		
		btnCheckout.click();
		Thread.sleep(3000);
	}
	
	public void logout() {
		
		btnSignout.click();
		
	}
	
	public String pName() {
		
		return productNameInCartPage.getText();
	}
	
	
}
