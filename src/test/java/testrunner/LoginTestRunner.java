package testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.Login;
import setup.Setup;

public class LoginTestRunner extends Setup {
    DashboardPage dahsboard;
@Test(priority = 1,description = "login with invalid Credential")
public void doLoginwithInvalidCred(){
    driver.get("https://opensource-demo.orangehrmlive.com/");
  Login login=new Login(driver);
String actual_warning=  login.doLoginwithInvalidCred("admin","wrongpass");
String expected_warning="Invalid credentials";

    Assert.assertEquals(actual_warning,expected_warning);
}
    @Test(priority = 2,description = "User Can do pages.Login With Valid credential")
    public void doLogin () {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Login loginpage = new Login(driver);
        loginpage.doLogin("Admin", "admin123");
        WebElement hedear_txt = driver.findElement(By.tagName("h6"));
        WebElement profile_img = driver.findElement(By.className("oxd-userdropdown-img"));
        String actual_text = hedear_txt.getText();
        String expected_text = "Dashboard";
        boolean image_displayed = profile_img.isDisplayed();
        //soft assertion
        SoftAssert softaseert=new SoftAssert();

        softaseert.assertEquals(actual_text, expected_text);
        softaseert.assertTrue(image_displayed);
        softaseert.assertAll();


    }


}
