package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Properties  p;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		//Loading config.propertiesfile 
		
	FileReader file = new FileReader("./src/test/resources/config.properties");
	p = new Properties();
	p.load(file);
		
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Invalid browser name :");
			return;

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomAlpabhet() {

		String randomString = RandomStringUtils.randomAlphabetic(6);
		return randomString;
	}

	public String randomNumber() {

		String randomNumbaer = RandomStringUtils.randomNumeric(10);
		return randomNumbaer;
	}

	public String randomAlphaNumeric() {
		String randomString = RandomStringUtils.randomAlphabetic(6);
		String randomNumbaer = RandomStringUtils.randomNumeric(10);
		return (randomString + "@" + randomNumbaer);
	}
	
	public String captureScreen(String tname) {
		
		String timestamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
	String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"__"+timestamp+".png";
	
	File targetFile = new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
	return targetFilePath;
		
		
	}

}
