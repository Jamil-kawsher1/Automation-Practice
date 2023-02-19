package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PimPage {
    @FindBy(className = "oxd-button--secondary")
  List <WebElement> buttons;
    public PimPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void createEmnplyee(){
        buttons.get(1).click();

    }
}
