package loginUser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Main;
import common.Platform;
import common.PropertyHelper;

//import common.AlreadyRunException;

public class IoTLogin{
	WebDriver driver;
	String baseUrl = "http://15.213.51.128:8080/dsm/";
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		
		Main m = new Main();
		driver.manage().window().maximize();

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajuk\\git\\IoTProject\\CHDriver\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void loginForm() throws Exception {
		try {

            String actualTitle = "";
			String actualTitle1 = "";
			String expectedTitle = "UIoT | Universal Internet Of Things";
			driver.get(baseUrl);

			actualTitle = driver.getTitle();

			System.out.println("Page title:" + actualTitle);

			Assert.assertEquals("Log in to saml-demo", actualTitle);

			driver.findElement(By.id("username")).sendKeys("IoTAdmin");
			driver.findElement(By.id("password")).sendKeys("Demo!123");
			driver.findElement(By.xpath("//input[@value='Log in']")).click();

			actualTitle1 = driver.getTitle();
//			Assert.assertEquals("UIoT | Universal Internet Of Things", actualTitle1);
			
			if(!expectedTitle.equals(actualTitle1)){
				System.out.println("Test Result: Fail");
			} else{
				System.out.println("Test Result: Pass");
			}
			
			System.out.println("Thank you!!");
				
		


        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();

	}

}
