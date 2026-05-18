package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage2 extends BasePage {
    private final By emailField=By.id("user-name");
    private final By passwordField=By.id("password");
    private final By loginBtn=By.id("login-button");
    private final By invalidEmailMessage=By.xpath("//h3[@data-test='error']");
    private final By emptyEmailMessage=By.id("empty-email-error-message");

    public void enterEmail(String email){
        sendKeys(emailField,email);
    }
    public void enterPassword(String password){
        sendKeys(passwordField,password);
    }
    public void enterWrongPassword(String password){
        sendKeys(passwordField,password);
    }
    public void clickOnLogin(){
    click(loginBtn);
    //return new SignUpPage();
    }
    public SignInPage continueSigningIn(){
        click(loginBtn);
        return new SignInPage();
    }
    public String getInvalidEmailText(){
        return getText(invalidEmailMessage);
    }
    public String getEmptyEmailText(){
        return getText(emptyEmailMessage);
    }
    public void waitToLoad(){
    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailField)));
    }
   
}
