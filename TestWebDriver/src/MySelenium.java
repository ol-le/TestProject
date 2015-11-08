import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//wrapper for selenium to make usage more comfortable
//all tests should derive from this class
public class MySelenium {

	public static WebDriver driver;
	
	//selenium configuration on setup
	@BeforeTest
	public void setUp(){
		FirefoxProfile ffProfile = new FirefoxProfile();
		File binfile = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(binfile);
		driver = new FirefoxDriver(ffBinary, ffProfile); //configuring profile and binary to initialize FirefoxDriver
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//initialization of timeouts
		driver.get("https://www.concur.com/");//initialize default page
	}
	
	//closing browser and disposing web driver instance
	@AfterTest
	public void tearDown(){
		driver.close(); 
		driver.quit(); 
	}
	
	//wrappers for getElement functions
	public WebElement getElementByXpath(String xpath){
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement getElementById(String id){
		return driver.findElement(By.id(id));
	}
	
	public WebElement getElementByCss(String css){
		return driver.findElement(By.cssSelector(css));
	}
	
	public WebElement getElementByName(String name){
		return driver.findElement(By.name(name));
	}
	
	public void switchToFrameByXpath(String xpath){
		driver.switchTo().frame(getElementByXpath(xpath));
	}

	//waiter
	public WebElement waitForElement(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;	
	}
	
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public WebElement getElementByLinkText(String linkText){
		return driver.findElement(By.linkText(linkText));

	}
	
	public WebElement getElementByClassName(String className){
		return driver.findElement(By.className(className));
	}
		
}
