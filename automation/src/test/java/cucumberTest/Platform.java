package cucumberTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Platform {

	WebDriver driver;

	public void getBrowser(String browser) {

		if (browser.equalsIgnoreCase("CH")) {

			System.setProperty("webdriver.ie.driver", "./CHDriver/chromedriver.exe");

			driver = new ChromeDriver();

		}
	}

}
