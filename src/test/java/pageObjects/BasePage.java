package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	
	WebDriver driver;
	WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	
}
