package pageObjects;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

	
	public CartPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//*[contains(text(),' Sign Out ')]")
	WebElement btnSignout;

	@FindBy(xpath = "//p[@class='itemNumber']")
	WebElement orderId;

	@FindBy(xpath = "//*[contains(text(),'Checkout')]")
	WebElement btnCheckout;

	@FindBy(css = "div[class='cartSection'] h3")
	WebElement productNameInCartPage;

	@FindBy(xpath = "//div[@class='user__name mt-5']//input[@type='text']")
	WebElement txtEmailId;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement txtcountry;

	@FindBy(css = ".ta-results button")
	List<WebElement> countryOption;

	@FindBy(xpath = "//*[contains(text(),'Place Order ')]")
	WebElement btnPlaceOrder;

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement btnOrders;
	
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement txtThankYou;

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
		;
		return productNameInCartPage.getText();
	}

	public String placeingSelectedOrder(String countryName, String country) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		
		String cartPageEmail = txtEmailId.getText();

		txtcountry.sendKeys(countryName);
		wait.until(ExpectedConditions.visibilityOfAllElements(countryOption));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	/*	for (WebElement opt : countryOption) {

			if (opt.getText().equalsIgnoreCase(country)) {

//				opt.click();
				js.executeScript("arguments[0].click()", opt); 
				break;
			}

		}
	*/
		
		for(int i = 0 ; i<countryOption.size(); i++) {
			
		String	countryText = countryOption.get(i).getText();
		System.out.println("Countries are :"+countryText);
		if(countryText.equalsIgnoreCase(country)) {
			
			countryOption.get(i).click();
			break;
		}
			
		}
//		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(btnPlaceOrder));
		btnPlaceOrder.click();
		
		String thankyouText = txtThankYou.getText();
		
		@NonNull
		WebElement orderbtn = wait.until(ExpectedConditions.elementToBeClickable(btnOrders));
//		btnOrders.click();
		
		orderbtn.click();
		
		Thread.sleep(3000);
		
		return thankyouText;

	}

}
