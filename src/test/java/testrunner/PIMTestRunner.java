package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.Login;
import pages.PimPage;
import setup.Setup;
import utils.Utils;

public class PIMTestRunner extends Setup {
    DashboardPage dashboard;
    Login loginpage;
    PimPage pimpage;

    @BeforeTest
    public void doLogin () {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginpage = new Login(driver);
        loginpage.doLogin("Admin", "admin123");
    }

    @Test(priority = 1, description = "User can see employe info")
    public void searchEmployeInfo () throws InterruptedException {

        dashboard = new DashboardPage(driver);
        Thread.sleep(4000);
        dashboard.menus.get(1).click();
        Thread.sleep(5000);
        String isUserFound = driver.findElements(By.className("oxd-text--span")).get(11).getText();
        Assert.assertTrue(isUserFound.contains("Records Found"));
    }

    @Test(priority = 2, description = "select employe and check there list")
    public void selectEnployeStatus () throws InterruptedException {
        Thread.sleep(4000);
        dashboard.employeeDropDown.get(0).click();
        Thread.sleep(3000);
        dashboard.employeeStatus.get(0).click();
        Thread.sleep(3000);
//        dahsboard.employeeDropDown.get(0).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("[type=submit]")).click();
        Thread.sleep(3000);
        String titleActual = driver.findElements(By.className("oxd-text--span")).get(11).getText();
        String titleExpected = "Records Found";
        Assert.assertTrue(titleActual.contains(titleExpected) || titleActual.contains("Record Found"));
        Utils.doScroll(driver);

    }
@Test(priority = 3,description = "Create Employee")
    public void createEmnplyee () {
        pimpage = new PimPage(driver);
        pimpage.createEmnplyee();
    }
}
