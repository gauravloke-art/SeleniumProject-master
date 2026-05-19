package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import pages.AuthenticationPage2;
import pages.BasePage2;
import pages.HomePage2;

import java.time.Duration;
import java.util.Arrays;

public class BaseTest2 {
    //protected WebDriver driver;
    //BasePage2 basePage = new BasePage2(driver);
    //HomePage2 homePage2 = new HomePage2(driver);

    //AuthenticationPage2 Authenticationpage2 =new AuthenticationPage2(driver);
    protected WebDriver driver;

    protected BasePage2 basePage;
    protected HomePage2 homePage2;
    protected AuthenticationPage2 Authenticationpage2;


    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browserName)    {
 //        ChromeOptions options=new ChromeOptions();
//        option.addArguments("headless");
//        String browserName="edge";
        if(browserName.equalsIgnoreCase("chrome")) {
        	ChromeOptions options = new ChromeOptions();
        	options.addArguments("user-data-dir=C:\\selenium-profile");
        	options.addArguments("profile-directory=Default");
        	options.addArguments("--start-maximized");

        	options.addArguments("--disable-blink-features=AutomationControlled");

        	options.setExperimentalOption("excludeSwitches",
        	        Arrays.asList("enable-automation"));

        	options.setExperimentalOption("useAutomationExtension", false);
        	driver = new ChromeDriver(options);;

        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        }
        else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("opening URL");
        driver.get("https://www.saucedemo.com/");
        System.out.println("URL Opened");
        basePage = new BasePage2(driver);

        homePage2 = new HomePage2(driver);

        Authenticationpage2 =
                new AuthenticationPage2(driver);
        //Authenticationpage2.enterEmail("standard_user");
        //System.out.println("EmailEntered");
        //Authenticationpage2.enterPassword("secret_sauce");
        //Authenticationpage2.clickOnLogin();
        //basePage2=new BasePage2();
        //basePage2.setDriver(driver);
       // homePage2=new HomePage2();
       // Authenticationpage2.waitToLoad();
        System.out.println("wait");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    /*********************LOGIN
     * @throws InterruptedException **************************/
    public void login() throws InterruptedException{
        //homePage.closePopUp();
    	System.out.println("opening URL");
        //AuthenticationPage2 Authenticationpage2=new AuthenticationPage2();
        Authenticationpage2.enterEmail("standard_user");
        System.out.println("EmailEntered");
        Authenticationpage2.enterPassword("secret_sauce");
        Authenticationpage2.clickOnLogin();
        
        
        //Assert.assertTrue(homePage2.getAssertionText().contains("Hi, "));
    }

    /*********************DATAPROVIDERS**************************/
    @DataProvider
    public Object [][] getData(){
        Object[][] data=new Object[2][2];
        data[0][0]="12345";
        data[0][1]="12345";
        data[1][0]="#$@#!";
        data[1][1]="#$@#!";
        return data;
    }

    @DataProvider(name = "search")
    public Object [][] searchField(){
        Object[][] data=new Object[4][1];
        data[0][0]="jeans";
        data[1][0]="table";
        data[2][0]="watch";
        data[3][0]="كتاب";

        return data;
    }

    @DataProvider(name = "newsletter")
    public Object [][] newsLetterField(){
        Object[][] data=new Object[2][2];
        data[0][0]="0254a7120b67@drmail.in";
        data[0][1]="male";
        data[1][0]="d8c0a286b126@drmail.in";
        data[1][1]="female";

        return data;
    }
}