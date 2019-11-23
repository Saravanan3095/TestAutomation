package example;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("http://demo.guru99.com/test/guru99home/");  
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
		}	
		@BeforeTest
		public void beforeTest() {
			
			 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Webdriver\\78.0.3904.70\\chromedriver.exe");
			driver = new ChromeDriver();  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	