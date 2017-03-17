package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddAsset {

	WebDriver driver;

	Config co = new Config();
	Prep prep = new Prep();
	Select s;
	Platform po = new Platform();

	private StringBuffer verificationErrors = new StringBuffer();

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

			// String baseUrl = "http://15.213.51.128:8080/dsm/";

			driver.get(co.getBaseUrl());
			driver.findElement(By.id("username")).sendKeys(co.getUserName());
			driver.findElement(By.id("password")).sendKeys(co.getPassword());
			driver.findElement(By.xpath("//input[@value='Log in']")).click();

		} catch (Exception e) {
			verificationErrors.append(e.getMessage());
			throw e;
		}

	}

	@Test
	public void addAsset() throws Exception {
		try {
			driver.findElement(By.xpath("//*[contains(@class,'nav-label') and text()='Asset Mgmt.']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a/li[contains(text(),'Add Asset') and @id='asset_2']")).click();
			driver.findElement(By.xpath("//input[@name='resourceName']")).sendKeys(prep.readDeviceName());

			s = new Select(driver.findElement(By.id("resourceType")));
			s.selectByVisibleText(co.getResourceType());

			driver.findElement(By.xpath("(.//*[@class='dropdown-toggle ng-scope'])[1]")).click();

			Thread.sleep(5000);

			driver.findElement(By.xpath("(.//ul[@role='menu'])[2]//li[1]")).click();

			driver.findElement(By.xpath("(.//*[@class='dropdown-toggle ng-scope'])[2]")).click();

			Thread.sleep(5000);
			driver.findElement(By.xpath("(.//ul[@role='menu'])[3]//li[2]")).click();

//			driver.findElement(By.xpath("//input[@class='undefined ng-pristine ng-valid ng-empty ng-touched']"))
//					.sendKeys(co.getDeviceProfile());

			WebElement ldcpe = driver
					.findElement(By.xpath("//input[@class='ng-pristine ng-valid ng-not-empty ng-touched']"));
			if (ldcpe.isSelected()) {
				ldcpe.click();
			}
			WebElement lpe = driver
					.findElement(By.xpath("//input[@class='ng-pristine ng-untouched ng-valid ng-not-empty']"));
			if (lpe.isSelected()) {
				lpe.click();
			}
			
			driver.findElement(By.xpath("//input[@id='iotParamsAppEUI']")).sendKeys(prep.readAppEUI());
			driver.findElement(By.xpath("//input[@id='iotParamsDevEUI']")).sendKeys(prep.readAppEUI());
			driver.findElement(By.xpath("//input[@id='iotParamsmchineId']")).sendKeys(prep.readMachineId());
			
			driver.findElement(By.xpath("//button[1][contains(text(),'Create')]")).click();
			Thread.sleep(3000);
			
			String successText = driver.findElement(By.xpath("//tr/td[2]/div[2]/div[3]")).getText();
			
			System.out.println(successText);
			

		} catch (Exception e) {
			verificationErrors.append(e.getMessage());
			throw e;
		}

	}

	@After
	public void tearDown() throws Exception {
		po.tearDown("AddAsset");

	}

}
