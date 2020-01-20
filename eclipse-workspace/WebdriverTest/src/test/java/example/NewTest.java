package example;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;

import Utils.ExcelUtils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private WebDriver driver;
	    ExcelUtils eu=new ExcelUtils();
	    static String TestDataExcel="C:\\Users\\pc\\eclipse-workspace\\WebdriverTest\\src\\main\\resources\\testData\\DataTest.xlsx";
		@Test(enabled = true)
		@Parameters("Check")
		public void testEasy(String value) {
			System.out.println("value:"+value);
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
		@Test(enabled = false)
		@Parameters("Check")
		public void ParamterTest(String value) {
			System.out.println("Check:"+value);
			 		
		}	
		@Test(enabled = false)
		@Parameters({"Suitecheck","Check"})
		public void SuiteTest(String value,String Value2) {
			System.out.println("Suitecheck:"+value);
			System.out.println("Testcheck:"+Value2);
			 		
		}

	
	  @Test(enabled = true,dataProvider="TestData") 
	  public void Excelread(String name,String DOB) {
		/*
		 * System.out.println("Suitecheck:"+value);
		 * System.out.println("Testcheck:"+Value2);
		 */
		  System.out.println("Name::"+name);
		  System.out.println("DOB:"+DOB);
	  
	  }
	 
		@Test(dataProvider="Datacheck")
		public void DataCheck(int number,boolean flag)
		{
			System.out.println("number:"+number);
			System.out.println("flag:"+flag);
			Assert.assertEquals(flag, true);
		}
		@Test(dependsOnMethods= {"DataCheck"},dataProvider="Datacheck",enabled = false)
		public void Dependencytest(int number,boolean flag) {
			System.out.println("numberDependsuccess:"+number);
		}
		@DataProvider(name="Datacheck")
		public static Object[][] primeNumbers(){
			 //return new Object[][] {{2, true}, {6, false}, {19, true}, {22, false}, {23, true}};
			return new Object[][] {{2, true}, {6, true}, {19, true}, {22, true}, {23, true}};
		}
		@DataProvider(name="TestData")
		public static Object[][] TestData() throws Exception{
			 //return new Object[][] {{2, true}, {6, false}, {19, true}, {22, false}, {23, true}};
			 Object[][] testData=ExcelUtils.getTableArray(TestDataExcel,"DataSheet");
			 return testData;
		}
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	