package pageObjects.Automation105;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhatHappened105 extends BasePage {

    private @FindBy(xpath = "//input[@data-test-id='20190410174412007353618']")
    WebElement checkBoxSomeOneHurt = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007251929']")
    WebElement checkBoxDamaged = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007352747']")
    WebElement checkBoxStolen = null;
    private @FindBy(xpath = "//input[@data-test-id='201906271628360456129903']")
    WebElement checkBoxLostProperty = null;
    private @FindBy(xpath = "//input[@data-test-id='20190628092817037265114']")
    WebElement checkBoxSomethingElse = null;
    private @FindBy(xpath = "//button[@data-test-id='20190506100908067919212']")
    WebElement buttonContinue = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007353618' and @aria-label='This sounds like it needs an intimidate attention']")
    WebElement toggleHurtOrThreatened = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007251929']")
    WebElement toggleDamaged = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007352747']")
    WebElement toggleStolen = null;
    private @FindBy(xpath = "//div[@data-test-id='201906271628360456129903']//input")
    WebElement radioLostPropertyNotSelected = null;
    private @FindBy(xpath = "//div[@data-test-id='20190628092817037265114']//input")
    WebElement radioSomethingElseNotSelected = null;
    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueMobile = null;

    public void clickOnSomeOneIsHurt() {
        waitAndclickElementUsingJS(checkBoxSomeOneHurt);
        _persistentData.setContext("hurtIndicator", "yes");
        _persistentData.setContext("eventType", "hurt");
    }

    public void clickOnDamaged() {
        waitAndClickElement(checkBoxDamaged);
        _persistentData.setContext("damagedIndicator", "yes");
        _persistentData.setContext("eventType", "damaged");
    }

    public void clickOnSomethingIsStolen() {
        waitAndclickElementUsingJS(checkBoxStolen);
        _persistentData.setContext("stolenIndicator", "yes");
        _persistentData.setContext("eventType", "stolen");
    }

    public void clickOnLostProperty() {
        waitAndclickElementUsingJS(checkBoxLostProperty);
        _persistentData.setContext("lostPropertyIndicator", "yes");
        _persistentData.setContext("eventType", "lost");
    }

    public void clickOnSomethingElse() {
        waitAndclickElementUsingJS(checkBoxSomethingElse);
        _persistentData.setContext("somethingElseIndicator", "yes");
        _persistentData.setContext("eventType", "somethingElse");
    }

    public void clickOnContinueButton() {
        waitAndclickElementUsingJS(buttonContinue);
    }

    public void navigateFromThreeQuestionsPageToEventInfoPage(boolean hurt, boolean damaged, boolean stolen, boolean lost, boolean somethingElse) {
        if (hurt) {
            clickOnSomeOneIsHurt();
        }

        if (damaged) {
            clickOnDamaged();
        }

        if (stolen) {
            clickOnSomethingIsStolen();
        }

        if (lost) {
            clickOnLostProperty();
        }

        if (somethingElse) {
            clickOnSomethingElse();
        }

        clickOnContinueButton();
    }

    public void navigateFromThreeQuestionsPageToEventInfoPageMobile(boolean hurt, boolean damaged, boolean stolen, boolean lost, boolean somethingElse) {
        if (hurt) {
            clickOnSomeOneIsHurtMobile();
        }

        if (damaged) {
            clickOnDamagedMobile();
        }

        if (stolen) {
            clickOnSomethingIsStolenMobile();
        }

        if (lost) {
            clickOnLostPropertyMobile();
        }

        if (somethingElse) {
            clickOnSomethingElseMobile();
        }

        clickOnContinueButtonMobile();
    }

    public void clickOnSomeOneIsHurtMobile() {
        waitAndclickElementUsingJS(toggleHurtOrThreatened);
        _persistentData.setContext("hurtIndicator", "yes");
    }

    public void clickOnDamagedMobile() {
        waitAndclickElementUsingJS(toggleDamaged);
        _persistentData.setContext("damagedIndicator", "yes");
    }

    public void clickOnSomethingIsStolenMobile() {
        waitAndclickElementUsingJS(toggleStolen);
        _persistentData.setContext("stolenIndicator", "yes");
    }

    public void clickOnLostPropertyMobile() {
        waitAndclickElementUsingJS(radioLostPropertyNotSelected);
        _persistentData.setContext("lostPropertyIndicator", "yes");
    }

    public void clickOnSomethingElseMobile() {
        waitAndclickElementUsingJS(radioSomethingElseNotSelected);
        _persistentData.setContext("somethingElseIndicator", "yes");
    }

    public void clickOnContinueButtonMobile() {
        waitAndclickElementUsingJS(buttonContinueMobile);
    }
}
