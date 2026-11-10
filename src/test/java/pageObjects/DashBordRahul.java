package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBordRahul extends BasePage {

	public DashBordRahul(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath="//*[contains(text(),' Sign Out ')]")
	WebElement btnSignout;
	
	@FindBy(xpath="//button[@class='btn w-10 rounded']")
	List<WebElement> btnAddToCart;
	
	@FindBy(xpath="//div[@class='card-body']//b")
	List<WebElement> productName;
	
	@FindBy(xpath="//label[contains(text(),'1')]")
	WebElement cartNum;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement btncart;
	
	
	public void selectingProduct(String name) throws InterruptedException {
		
		
		for(int i = 1; i<=productName.size(); i++) {
			
		if(productName.get(i).getText().equals(name)) {
			
			btnAddToCart.get(i).click();
			Thread.sleep(3000);
			break;
		}
		}
		
	
		
	}
	
	public String prodNumInCart() {
		
		return	cartNum.getText();
	}
	
	public void clickCartbtn() {
		
		btncart.click();
	}
	
	public void logout() {
		
		btnSignout.click();
	}

}
