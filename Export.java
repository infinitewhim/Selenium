package com.hn;



import java.util.regex.Pattern;
import java.io.File;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class Export {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.marionette", "D:\\geckodriver.exe");
		
		File pathToBinary = new File("D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		driver = new FirefoxDriver(ffBinary,firefoxProfile);
		
		
	}

	@Test
	public void testExport() throws Exception {
		
        
		baseUrl = "http://www.1point3acres.com/bbs/";
	   
	    driver.get(baseUrl );
	    Thread.sleep(500);
	    
	    driver.manage().window().maximize();
	    Thread.sleep(500);
	    driver.findElement(By.id("ls_username")).clear();
	    driver.findElement(By.id("ls_username")).sendKeys("infinitewhim");
	    Thread.sleep(1000);
	    driver.findElement(By.id("ls_password")).clear();
	    
	    //input pwd here first
	    driver.findElement(By.id("ls_password")).sendKeys("");
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("button.pn.vm")).click();
	    Thread.sleep(2000);
	    
	    
	    driver.findElement(By.cssSelector("tr.fl_row > td.fl_g > dl > dt > a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("C++刷题，坐标加州irvine")).click();
	    Thread.sleep(5000);
	    
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700)"); 
	    Thread.sleep(10000);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
