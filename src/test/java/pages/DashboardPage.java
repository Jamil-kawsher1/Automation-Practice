package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(className = "oxd-userdropdown-tab")
    public WebElement profileDropdown;
    @FindBy(partialLinkText = "Logout")
    public WebElement logout_btn;
    @FindBy(className = "oxd-main-menu-item--name")
    public List<WebElement> menus;
    @FindBy(className = "oxd-select-text")
    public List<WebElement> employeeDropDown;
    @FindBy(className = "oxd-select-dropdown")
    public List<WebElement> employeeStatus;


    public DashboardPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //test steps
    public void doLogout () {
        profileDropdown.click();
        logout_btn.click();
    }


}
