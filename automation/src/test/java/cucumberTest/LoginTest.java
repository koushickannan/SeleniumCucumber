package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.*;

public class LoginTest {
	WebDriver driver;
	final static Logger logger = Logger.getLogger(LoginTest.class);

	private StringBuffer verificationErrors = new StringBuffer();
	Config co = new Config();
	Platform po = new Platform();

	String expectedTitle = "UIoT | Universal Internet Of Things";

	@Before
	public void setUp() throws Exception {

		PropertyConfigurator.configure("log4j.properties");
		driver = po.readBrowserName();
		driver.manage().window().maximize();
		driver.get(co.getBaseUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void loginForm() throws Exception {
		try {

			String actualTitle = driver.getTitle();

			System.out.println("Page title:" + actualTitle);

			Assert.assertEquals("Log in to saml-demo", actualTitle);

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

	}

	@After
	public void tearDown() throws Exception {

		po.tearDown("Login");

	}

}