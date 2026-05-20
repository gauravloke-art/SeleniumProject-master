package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import pages.BasePage2;

import java.io.File;
import java.io.IOException;
//import base.BaseTest2;
public class TakeScreenShot3 {

   

	
	    public static String screenShot(String testCaseName)
	            throws IOException
	    {
	        TakesScreenshot ts =
	                (TakesScreenshot) BasePage2.getDriver();

	        File source = ts.getScreenshotAs(OutputType.FILE);

	        String destination =
	                System.getProperty("user.dir")
	                + "/reports/"
	                + testCaseName
	                + ".png";

	        File finalDestination = new File(destination);

	        Files.copy(source, finalDestination);

	        return destination;
	    }
}