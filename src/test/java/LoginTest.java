import dataObjects.LoginData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.ChromeRunner;


public class LoginTest extends ChromeRunner {
    LoginPage loginPage = new LoginPage(driver);


    @Test(priority = 1)
    public void validLogin() throws InterruptedException {
        loginPage.enterUsername(LoginData.username);
        loginPage.enterPassword(LoginData.password);
        loginPage.clickOnLogin();

        String actualText = loginPage.depositText.getText();
        Assert.assertEquals(actualText, LoginData.expectedText);

    }

    @Test(priority = 2)
    public void goToSlotsPage() throws InterruptedException {
        loginPage.enterUsername(LoginData.username);
        loginPage.enterPassword(LoginData.password);
        loginPage.clickOnLogin();
        loginPage.clickOnSlotsButton();

        String actualResult = loginPage.topGames.getText();
        Assert.assertEquals(actualResult, LoginData.expectedResult);

    }

}
