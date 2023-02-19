package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Setup;

public class Login  {
    @FindBy(name = "username")
    WebElement text_username;
    @FindBy(name = "password")
    WebElement text_password;
    @FindBy(css = "[type=submit]")
    WebElement login_button;
  //invalid login warning text
    @FindBy(className = "oxd-alert-content-text")
    WebElement loginFwarning;

    public  Login(WebDriver driver){
        PageFactory.initElements( driver,this);
    }

    //test method fpr login with invalid credential
    public String doLoginwithInvalidCred(String username,String password){
        text_username.sendKeys(username);
        text_password.sendKeys(password);
        login_button.click();
        return loginFwarning.getText();
    }

    //test setp method for successfull Login
    public void doLogin(String username,String password){
        text_username.sendKeys(username);
        text_password.sendKeys(password);
        login_button.click();
    }
}
