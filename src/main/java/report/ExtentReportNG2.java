package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportNG2{

  

	public static ExtentReports getReportObject() {

		

	        String reportPath = System.getProperty("user.dir") + "//reports/index2.html";

	        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

	        reporter.config().setReportName("New Website");
	        reporter.config().setDocumentTitle("Gaurav Results");

	        ExtentReports extent = new ExtentReports();

	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Tester", "Gaurav");

	        return extent;
    }
}