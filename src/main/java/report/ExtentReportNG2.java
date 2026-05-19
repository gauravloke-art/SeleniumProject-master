package report;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.BasePage;
import pages.BasePage2;

public class ExtentReportNG2 extends BasePage2 {

    public ExtentReportNG2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static ExtentReports getReportObject() {

        String reportPath = System.getProperty("user.dir") + "//reports/index.html";
        ExtentSparkReporter report = new ExtentSparkReporter(reportPath);
        report.config().setReportName("Jumia Tests Report");
        report.config().setDocumentTitle("Jumia Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Eslam Mashaly", "Tester");
        return extent;
    }
}