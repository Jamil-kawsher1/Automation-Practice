package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Utils;

import java.util.List;

public class PimPage {
    WebDriver driver;
    @FindBy(className = "oxd-button--secondary")
    List<WebElement> buttons;

    //employe image holder
    @FindBy(className = "employee-image")
    WebElement employee_img;
    //Add employee title
    @FindBy(className = "orangehrm-main-title")
    public WebElement title_AddEmployee;
    //first name
    @FindBy(name = "firstName")
    WebElement em_first_name;

    //last name
    @FindBy(name = "lastName")
    WebElement em_last_name;

    //toggle button
    @FindBy(className = "oxd-switch-input")
    WebElement btn_toggle;

    //getting list of filed after toggle
@FindBy(className = "oxd-input")
    List <WebElement> inputs;

    public PimPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createEmployee () throws InterruptedException {
        buttons.get(1).click();
//        Utils.waitforElement(driver,employee_img,20);
        Thread.sleep(20000);
        em_first_name.sendKeys("Jamil");
        em_last_name.sendKeys("kawsher");
        btn_toggle.click();
        //waiting for 2 sec to load htm element after toggle
        Thread.sleep(2000);
        //username filed at 5 index
        inputs.get(5).sendKeys("jamil0777");
        //password filed at index 6
        inputs.get(6).sendKeys("Password1@");
        // confirm password filed at index 7
        inputs.get(7).sendKeys("Password1@");

    }
}
