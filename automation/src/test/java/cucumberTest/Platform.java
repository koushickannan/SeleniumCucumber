package cucumberTest;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;

//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Platform extends Config{

	WebDriver driver;

	public WebDriver readBrowserName() throws IOException{
		
		String browser = getBrowserName();

		if (browser.equalsIgnoreCase("CH")) {

			System.setProperty("webdriver.chrome.driver", "./CHDriver/chromedriver.exe");
			driver = new ChromeDriver();	
			

		}
		return driver;
		
	}

}
