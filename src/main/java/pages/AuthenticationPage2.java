package pages;

import org.openqa.selenium.By;

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
    public SignUpPage continueSigningUp(){
    click(loginBtn);
    return new SignUpPage();
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
}
