package ss;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import base.BaseTest3;

//import base.BaseTest2;
import java.io.File;
import java.io.IOException;
//import base.BaseTest2;
public class TakeScreenShot2 {

   

	

	public static String screenShot(String testCaseName)
    {

        try
        {
            TakesScreenshot ts =
                    (TakesScreenshot) BaseTest3.getDriver();

            File source =
                    ts.getScreenshotAs(OutputType.FILE);

            File reportDir =
                    new File(System.getProperty("user.dir")
                            + "/reports");

            if(!reportDir.exists())
            {
                reportDir.mkdirs();
            }

            String destination =
                    System.getProperty("user.dir")
                    + "/reports/"
                    + testCaseName
                    + ".png";

            File finalDestination =
                    new File(destination);

            Files.copy(source, finalDestination);

            return destination;
        }

        catch(Exception e)
        {
            System.out.println(
                    "Screenshot failed: "
                    + e.getMessage());

            return null;
        }
    }
}