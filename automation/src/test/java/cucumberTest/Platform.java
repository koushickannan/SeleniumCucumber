package cucumberTest;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Platform extends Config {

	public String browser;
	WebDriver driver;

	final static Logger logger = Logger.getLogger(Platform.class);

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public WebDriver readBrowserName() throws IOException {

		String browser = getBrowserName();

		if (browser.equalsIgnoreCase("CH")) {
			
			DesiredCapabilities capabilities = new DesiredCapabilities() ;
			capabilities.setBrowserName("chrome");
			capabilities.getVersion();
			System.setProperty("webdriver.chrome.driver", "./CHDriver/chromedriver.exe");
			driver = new ChromeDriver(capabilities);

		}

		else if (browser.equalsIgnoreCase("FF")) {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "localhost");
			profile.setPreference("network.proxy.socks_port", 9150);
			driver = new FirefoxDriver(profile);
			// driver=new FirefoxDriver();
		}
		return driver;

	}

	public void tearDown(String imageName) throws Exception {

		Selenium sel = new Selenium();
		sel.takeScreenShot(driver, imageName);

		driver.quit();
	}

}
