package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Platform extends PropertyHelper {
	
	WebDriver driver;

public  void test1(String browser) {

if(browser.equalsIgnoreCase("FF")){
 
 driver=new FirefoxDriver();
 
}
else if(browser.equalsIgnoreCase("IE")){
 
System.setProperty("webdriver.ie.driver", "./IEDriverServer/IEDriverServer.exe");
 
 driver=new InternetExplorerDriver();
 

}
else if(browser.equalsIgnoreCase("CH")){
	 
System.setProperty("webdriver.ie.driver", "./CHDriver/IEDriverServer.exe");
 
 driver=new ChromeDriver();
 

}
}

}