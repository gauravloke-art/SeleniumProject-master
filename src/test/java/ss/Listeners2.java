package ss;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest2;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import screenshot.TakeScreenShot;

import java.io.IOException;

public class Listeners2 implements ITestListener {

    //ExtentReports extent = ExtentReportNG2.getReportObject();

    //ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentTest extentTest2 =
        		BaseTest2.extent1.createTest(result.getMethod().getMethodName());

        BaseTest2.test.set(extentTest2);
    }


    @Override
    public void onTestSuccess(ITestResult result)
    {
    	BaseTest2.test.get().pass("Test Passed");
    }


    @Override
    public void onTestFailure(ITestResult result)
    {
    	 BaseTest2.test.get().fail(result.getThrowable());

    	    String path =
    	            TakeScreenShot2.screenShot(
    	                    result.getMethod().getMethodName());

    	    if(path != null)
    	    {
    	        try
    	        {
    	            BaseTest2.test.get()
    	                    .addScreenCaptureFromPath(path);
    	        }
    	        catch(Exception e)
    	        {
    	            System.out.println(
    	                    "Unable to attach screenshot");
    	        }
    	    }
    }


    @Override
    public void onFinish(ITestContext context)
    {
    	BaseTest2.extent1.flush();
    }
}