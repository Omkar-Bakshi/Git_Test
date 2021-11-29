package TestNGmodule.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;



public class CodilityPractice1 {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
				
	}
	
	@Test(priority=1,enabled=false)
	public void validateTitle() {
		boolean titleName= driver.getTitle().contentEquals("OrangeHRM");
		Assert.assertTrue(titleName);
	}
	
	@Test(priority=2,enabled=false)
	public void usernameDisplay() {
		boolean Uname= driver.findElement(By.id("txtUsername")).isDisplayed();
		Assert.assertTrue(Uname);
	}
	
	@Test(priority=3,enabled=false)
	public void vLoginPanel() {
		boolean panel= driver.findElement(By.id("logInPanelHeading")).isDisplayed();
		Assert.assertTrue(panel);
	}
	
	@Test(priority=4,enabled=false)
	public void resultP() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("ajay");
		driver.findElement(By.name("_search")).click();
		boolean noResult= driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).getText().equals("No Records Found");
		Assert.assertTrue(noResult);
		
	}
	
	@Test(priority=5,enabled=false)
	public void result() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Aravind");
		driver.findElement(By.name("_search")).click();
		boolean resultt=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).getText().equals("Aravind");
		Assert.assertTrue(resultt);
	}
	
	@Test(priority=6)
	public void chkBox() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Aravind");
		driver.findElement(By.name("_search")).click();
		driver.findElement(By.id("ohrmList_chkSelectRecord_39")).click();
		boolean CBox1=driver.findElement(By.id("ohrmList_chkSelectRecord_39")).isSelected();
		Assert.assertTrue(CBox1);
		boolean CBox2=driver.findElement(By.id("ohrmList_chkSelectRecord_39")).isEnabled();
		Assert.assertTrue(CBox2);
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
		
	}

}
