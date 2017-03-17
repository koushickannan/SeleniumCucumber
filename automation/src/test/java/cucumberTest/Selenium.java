package cucumberTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Selenium extends Config{
	
	
	 public String takeScreenShot(WebDriver driver,String screenshot) throws IOException, Exception {
		 String reportingPath = System.getProperty("user.dir")+getScreenshotPath();
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String imageName = reportingPath + "/" + screenshot + generateTimeStamp() + ".png";
	        FileUtils.copyFile(scrFile, new File(imageName));
	        return imageName;
	    }
	 
	 public static String generateTimeStamp() throws Exception {
	        long ts = (new java.util.Date()).getTime();
	        // System.out.print("Unique string - " + String.valueOf(ts));
	        return String.valueOf(ts);
	    }

	
}

