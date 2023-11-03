import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactPage;
import utils.ChromeRunner;

import static dataObjects.ContactData.*;

public class ContactTest extends ChromeRunner {
    ContactPage contactPage = new ContactPage();

    @Test
    public void sendMessage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(3000);

        contactPage.clickOnBranches();
        contactPage.getContactPage();

        js.executeScript("window.scrollBy(0,400)");

        contactPage.enterSenderName(senderName);
        contactPage.enterEmail(senderEmail);
        contactPage.enterSubjectName(subject);
        contactPage.enterText(message);
        contactPage.clickOnSend();
        Thread.sleep(2000);

        String actualResult = contactPage.popUp.getText();
        Assert.assertEquals(actualResult, expectedResult);

    }
}
