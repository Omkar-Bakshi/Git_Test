package TestNGmodule.TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNGtestcases {
	WebDriver driver;
	
	@BeforeMethod

	public void setUp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

	}
	
	@Test(priority = 1)
	
	
	public void validatepagetitle() {
		boolean titleName=driver.getTitle().equals("OrangeHRM");
		
		Assert.assertTrue(titleName);
		
			
		
	}
	 

	/*@Test(priority = 2)

	public void validateUserName() {

	boolean userName = driver.findElement(By.id("txtUsername")).isDisplayed();

	Assert.assertTrue(userName);

	}
	
	@Test(priority = 3)
	public void validateLogin() {
		boolean loginTitle = driver.findElement(By.id("logInPanelHeading")).isDisplayed();
		Assert.assertTrue(loginTitle);
	}
	*/

	 

	@AfterMethod

	public void tearDown() {

	driver.quit();

	}


}