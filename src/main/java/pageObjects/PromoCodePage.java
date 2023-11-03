package pageObjects;
import dataObjects.PromoCodeData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.ChromeRunner;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class PromoCodePage extends LoginPage {

    public PromoCodePage(WebDriver driver) {
        super(driver);
    }

    By
            dropdownMenu = By.linkText("M");
    public SelenideElement


            promoInput = $(byId("პრომო კოდი")),
            submitButton = $(byText("გააქტიურება")),
            close = $(byText("არა")),
            promoCode = $(byText("პრომო კოდი")),
            dropdown = $(byText("M")),
            closeButton = $(byXpath("//*[text() = 'დახურვა']")),
            messageBox = $(byXpath("//*[text() = 'ასეთი პრომო კოდი არ არსებობს']"));



   //დროებით ამ კოდს ვერ ვიყენებ
    public void selectState(WebDriver driver) {
    driver.findElement((By) dropdown).click();
    Select selectOptions = new Select(driver.findElement((By) dropdown));

    int dropDownSize = selectOptions.getOptions().size();

        for (int i = 0; i < dropDownSize; i++) {
            selectOptions.selectByVisibleText("პრომო კოდი");
        }
    }
    public void clickOnDropdown() throws InterruptedException {
        dropdown.click();
    }
    public void selectPromo() {
        promoCode.click();
    }
    public void enterPromoCode(String promo) {
        promoInput.setValue(PromoCodeData.promoCode);
    }
    public void clickOnSubmit() {
        submitButton.shouldBe(Condition.visible).click();
    }
    public void closePopup() throws InterruptedException {
      close.click();
      Thread.sleep(3000);
    }
    public void clickOnClose() {
        closeButton.click();
    }

}
