package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUser {

	WebDriver driver;

	Config co = new Config();
	Prep prep = new Prep();
	Select s;
	Platform po = new Platform();

	private StringBuffer verificationErrors = new StringBuffer();
	final static Logger logger = Logger.getLogger(AddUser.class);

	@Before
	public void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		driver = po.readBrowserName();
		driver.manage().window().maximize();
		driver.get(co.getBaseUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.debug("Got the URL");
	}

	@Test
	public void loginForm() throws Exception {
		try {

			driver.findElement(By.id("username")).sendKeys(co.getUserName());
			driver.findElement(By.id("password")).sendKeys(co.getPassword());
			driver.findElement(By.xpath("//input[@value='Log in']")).click();

		} catch (Exception e) {
			verificationErrors.append(e.getMessage());
			throw e;
		}

	}

	@Test
	public void addUser() throws Exception {
		driver.findElement(By.xpath("//*[contains(@class,'nav-label') and text()='Users']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a/li[contains(text(),'Create User') and @id='users_3']")).click();
		driver.findElement(By.xpath("//input[@id='fName']")).sendKeys(co.getFirstName());
		driver.findElement(By.xpath("//input[@id='lName']")).sendKeys(co.getLastName());
		driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys(prep.readEmailId());
		driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys(co.getPhoneNumber());
		s = new Select(driver.findElement(By.id("groupName")));
		s.selectByVisibleText(co.getTenant());

		s = new Select(driver.findElement(By.id("roleId")));
		s.selectByVisibleText(co.getRoles());
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(prep.readUserName());
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(co.getNewPassword());
		driver.findElement(By.xpath("//input[@id='cPassword']")).sendKeys(co.getNewConfirmPassword());
		s = new Select(driver.findElement(By.id("iotSubSystem_3_combobox")));
		s.selectByVisibleText(co.getPartnerManagement());

		driver.findElement(By.xpath("//input[@value='Create']")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String successText = driver.findElement(By.xpath("//tr/td[2]/div[2]/div[3]/div[2]")).getText();

		System.out.println(successText);

	}

	@After
	public void tearDown() throws Exception {
		po.tearDown("AddUser");

	}

}
