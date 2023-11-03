package utils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class ChromeRunner {
   public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        Selenide.open("https://testweb-v3.betlive.com/ka/home");
        driver = WebDriverRunner.getWebDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
