package cucumberTest;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Platform extends Config {

	WebDriver driver;

	public void readBrowserName() throws IOException {

		String browser = getBrowserName();

		if (browser.equalsIgnoreCase("CH")) {

			System.setProperty("webdriver.chrome.driver", "./CHDriver/chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}
//		return driver;
		else if(browser.equalsIgnoreCase("FF")){
			driver=new FirefoxDriver();
		}

	}
	
	public String readURL() throws IOException{
		
		String url = getBaseUrl();
		
		System.out.printf("URL - ", url);
		
		return url;
	}

}
