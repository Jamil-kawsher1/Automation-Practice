package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.DashboardPage;

import java.time.Duration;

public class Setup {
   public WebDriver driver;
   @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    @AfterTest
    public void colse() throws InterruptedException {
       DashboardPage dashboard=new DashboardPage(driver);
       Thread.sleep(5000);
//       dashboard.doLogout();
//       Thread.sleep(3000);
//       driver.close();
    }
}
