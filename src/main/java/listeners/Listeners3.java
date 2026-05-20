package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import report.ExtentReportNG2;
import screenshot.TakeScreenShot;

import java.io.IOException;

public class Listeners3  implements ITestListener {

    ExtentReports extent = ExtentReportNG2.getReportObject();

    ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentTest extentTest2 =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest2);
    }


    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.get().pass("Test Passed");
    }


    @Override
    public void onTestFailure(ITestResult result)
    {
        test.get().fail(result.getThrowable());

        String filepath;

        try
        {
            filepath = TakeScreenShot.screenShot(
                    result.getMethod().getMethodName());

            test.get().addScreenCaptureFromPath(
                    filepath,
                    result.getMethod().getMethodName());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void onFinish(ITestContext context)
    {
        extent.flush();
    }
}