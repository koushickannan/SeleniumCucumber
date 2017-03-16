package cucumberTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Selenium {
	WebDriver driver;
	
	
	 public String takeScreenShot(String reportingPath) throws IOException, Exception {
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String imageName = reportingPath + "/" + generateTimeStamp() + ".png";
	        FileUtils.copyFile(scrFile, new File(imageName));
	        return imageName;
	    }
	 
	 public static String generateTimeStamp() throws Exception {
	        long ts = (new java.util.Date()).getTime();
	        // System.out.print("Unique string - " + String.valueOf(ts));
	        return String.valueOf(ts);
	    }
}

