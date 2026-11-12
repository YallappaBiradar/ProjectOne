package practice_Automation;

import java.time.Duration;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class Auto_Suggesstion {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		//div[@class='wM6W7d']
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("ti6dpd")).sendKeys("automation");
		
		List<WebElement> choice = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		/*
		for(int i =0; i<=choice.size(); i++) {
			
			System.out.println(choice.get(i).getText());
		} 
		*/
		for(WebElement ele : choice) {
			 Thread.sleep(2000);
			String temp= ele.getText();
			//System.out.println(ele.getText());
			if(temp.equalsIgnoreCase("automation testing")){
			{
				System.out.println(ele.getText());
				ele.click();
			}
	     	}
		}
		Thread.sleep(3000);
		driver.quit();
	
		

	}

}
