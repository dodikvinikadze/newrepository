package pageObjects;
import dataObjects.ContactData;
import dataObjects.ContactData.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static dataObjects.ContactData.senderEmail;
import static dataObjects.ContactData.senderName;

public class ContactPage {

public  SelenideElement
                        branchButton = $(byText("სალაროები")),
                        contactButton = $(byLinkText("კონტაქტი")),
                        nameInput = $(byName("senderName")),
                        emailInput = $(byName("senderMail")),
                        subjectInput = $(byName("subject")),
                        messageInput = $(byName("bodyText")),
                        sendButton = $(byText("გაგზავნა")),
                        popUp = $(byXpath("//*[text() = 'Message Sent']"));



    public void clickOnBranches() {
        branchButton.shouldBe(Condition.visible).click();
    }
    public void getContactPage() {
        contactButton.click();
    }
    public void enterSenderName(String name) {
        nameInput.setValue(senderName);
    }
    public void enterEmail(String email) {
        emailInput.setValue(senderEmail);
    }
    public void enterSubjectName(String subject) {
        subjectInput.setValue(ContactData.subject);
    }
    public void enterText(String message) {
        messageInput.setValue(ContactData.message);
    }
    public void clickOnSend() {
        sendButton.shouldBe(Condition.enabled).click();
    }
}
