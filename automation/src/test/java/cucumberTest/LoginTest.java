package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.junit.*;

//import common.AlreadyRunException;

public class LoginTest {
	WebDriver driver;

	private StringBuffer verificationErrors = new StringBuffer();
	Config co = new Config();

	String expectedTitle = "UIoT | Universal Internet Of Things";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/automation/CHDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void loginForm() throws Exception {
		try {
			String actualTitle = "";

			driver.get(co.getBaseUrl());

			actualTitle = driver.getTitle();

			System.out.println("Page title:" + actualTitle);

			// Assert.assertEquals("Log in to saml-demo", actualTitle);

			driver.findElement(By.id("username")).sendKeys(co.getUserName());
			driver.findElement(By.id("password")).sendKeys(co.getPassword());
			driver.findElement(By.xpath("//input[@value='Log in']")).click();

		} catch (Exception e) {
			verificationErrors.append(e.getMessage());
			throw e;
		}

	}

	@Test
	public void dashboard() throws Exception {

		String actualTitle1 = "";
		actualTitle1 = driver.getTitle();

		Assert.assertEquals("UIoT | Universal Internet Of Things", actualTitle1);

		if (!expectedTitle.equals(actualTitle1)) {
			System.out.println("Test Result: Fail");
		} else {
			System.out.println("Test Result: Pass");
		}

		System.out.println("Success");

	}

	@After
	public void tearDown() throws Exception {
		driver.close();

	}

}