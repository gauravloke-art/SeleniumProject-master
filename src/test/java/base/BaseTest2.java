package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.AuthenticationPage2;
import pages.BasePage2;
import pages.HomePage2;
import report.ExtentReportNG2;
import ss.TakeScreenShot2;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BaseTest2 {
	// protected WebDriver driver;
	// BasePage2 basePage = new BasePage2(driver);
	// HomePage2 homePage2 = new HomePage2(driver);

	// AuthenticationPage2 Authenticationpage2 =new AuthenticationPage2(driver);
	//protected WebDriver driver;
	public static ExtentReports extent1;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	//protected BasePage2 basePage2;
	//protected HomePage2 homePage2;
	
	//protected AuthenticationPage2 Authenticationpage2;
	public static WebDriver getDriver()
    {
        return tlDriver.get();
    }
	@BeforeSuite
	public void startReport()
	{
	    extent1 = ExtentReportNG2.getReportObject();
	}
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			// Custom Chrome profile
			//options.addArguments("user-data-dir=C:\\selenium-profile");
			//options.addArguments("profile-directory=Default");
			// Browser settings
			options.addArguments("--start-maximized");
			// Disable automation detection
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			// Disable password manager & security popups
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);
			options.setExperimentalOption("prefs", prefs);
			tlDriver.set(new ChromeDriver(options));
			//driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
		    // Custom Firefox profile
		    FirefoxProfile profile = new FirefoxProfile(
		            new File("C:\\selenium-profile-firefox"));
		    // Disable notifications
		    profile.setPreference("dom.webnotifications.enabled", false);
		    // Disable password manager
		    profile.setPreference("signon.rememberSignons", false);
		    // Disable autofill
		    profile.setPreference("browser.formfill.enable", false);
		    // Disable automation flag (limited support compared to Chrome)
		    profile.setPreference("dom.webdriver.enabled", false);
		    options.setProfile(profile);
		    // Start maximized
		    options.addArguments("--start-maximized");
		    tlDriver.set(new FirefoxDriver(options));
		    //driver = new FirefoxDriver(options);

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty(
			        "webdriver.edge.driver",
			        "C:\\Drivers\\msedgedriver.exe"
			    );
			EdgeOptions options = new EdgeOptions();
		    // Custom Edge profile
		    //options.addArguments("user-data-dir=C:\\selenium-profile-edge");
		    //options.addArguments("profile-directory=Default");
		    // Browser settings
		    options.addArguments("--start-maximized");
		    // Disable automation detection
		    options.addArguments("--disable-blink-features=AutomationControlled");
		    options.setExperimentalOption("excludeSwitches",
		            Arrays.asList("enable-automation"));
		    options.setExperimentalOption("useAutomationExtension", false);
		    // Disable password manager & notifications
		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    prefs.put("profile.password_manager_leak_detection", false);
		    prefs.put("profile.default_content_setting_values.notifications", 2);
		    options.setExperimentalOption("prefs", prefs);
		    tlDriver.set(new EdgeDriver(options));
		    //driver = new EdgeDriver(options);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("opening URL");
		getDriver().get("https://www.saucedemo.com/");
		System.out.println("URL Opened");
	

    	
		BasePage2 basePage2 = new BasePage2(getDriver());
		HomePage2 homePage2  = new HomePage2(getDriver());
		AuthenticationPage2 Authenticationpage2 = new AuthenticationPage2(getDriver());
		
		// Authenticationpage2.enterEmail("standard_user");
		// System.out.println("EmailEntered");
		// Authenticationpage2.enterPassword("secret_sauce");
		// Authenticationpage2.clickOnLogin();
		// basePage2=new BasePage2();
		// basePage2.setDriver(driver);
		// homePage2=new HomePage2();
		// Authenticationpage2.waitToLoad();
		System.out.println("wait");
	}

	@AfterMethod
	public void tearDown() {
		 getDriver().quit();
	        tlDriver.remove();
	}

	/*********************
	 * LOGIN
	 * 
	 * @throws InterruptedException
	 **************************/
	public void login() throws InterruptedException {
		// homePage.closePopUp();
		AuthenticationPage2 Authenticationpage2 =
    	        new AuthenticationPage2(getDriver());
		System.out.println("opening URL");
		// AuthenticationPage2 Authenticationpage2=new AuthenticationPage2();
		Authenticationpage2.enterEmail("standard_user");
		System.out.println("EmailEntered");
		Authenticationpage2.enterPassword("secret_sauce");
		Authenticationpage2.clickOnLogin();

		// Assert.assertTrue(homePage2.getAssertionText().contains("Hi, "));
	}

	/********************* DATAPROVIDERS **************************/
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "12345";
		data[0][1] = "12345";
		data[1][0] = "#$@#!";
		data[1][1] = "#$@#!";
		return data;
	}

	@DataProvider(name = "search")
	public Object[][] searchField() {
		Object[][] data = new Object[4][1];
		data[0][0] = "jeans";
		data[1][0] = "table";
		data[2][0] = "watch";
		data[3][0] = "كتاب";

		return data;
	}

	@DataProvider(name = "newsletter")
	public Object[][] newsLetterField() {
		Object[][] data = new Object[2][2];
		data[0][0] = "0254a7120b67@drmail.in";
		data[0][1] = "male";
		data[1][0] = "d8c0a286b126@drmail.in";
		data[1][1] = "female";

		return data;
	}
	@AfterSuite
	public void flushReport()
	{
	    extent1.flush();
	}
}