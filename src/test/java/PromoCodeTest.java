import dataObjects.PromoCodeData;
import dataObjects.LoginData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.ChromeRunner;
import pageObjects.PromoCodePage;

import static dataObjects.LoginData.password;
import static dataObjects.LoginData.username;
import static dataObjects.PromoCodeData.expectedText;
import static dataObjects.PromoCodeData.promoCode;

public class PromoCodeTest extends ChromeRunner {

    PromoCodePage promoCodePage = new PromoCodePage(driver);

    @Test
    public void invalidPromoCode() throws InterruptedException {
        promoCodePage.enterUsername(username);
        promoCodePage.enterPassword(password);
        promoCodePage.clickOnLogin();
        promoCodePage.closePopup();
        promoCodePage.clickOnDropdown();
        promoCodePage.selectPromo();

        promoCodePage.enterPromoCode(promoCode);
        promoCodePage.clickOnSubmit();

        String actualText = promoCodePage.messageBox.getText();
        Assert.assertEquals(actualText, expectedText);

    }
}
