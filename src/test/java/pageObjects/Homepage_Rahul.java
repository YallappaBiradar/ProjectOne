package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage_Rahul extends BasePage{

	WebDriver driver;
	
	public Homepage_Rahul(WebDriver driver){
		
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='text-reset']")  
	WebElement linkRegester ;
	
	
	
	
	
	public void regesterPageLink() {
		
		linkRegester.click();		
	}
}
