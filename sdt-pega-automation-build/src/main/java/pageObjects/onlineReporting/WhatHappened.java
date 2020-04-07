package pageObjects.onlineReporting;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WhatHappened extends BasePage {

    private @FindBy(xpath = "//li[@id='current']")
    WebElement linkWhatHappened = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007353618']")
    WebElement checkBoxSomeOneHurt = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007353618']/following-sibling::label")
    WebElement labelSomeOneHurtText = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007251929']")
    WebElement checkBoxDamaged = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007251929']/following-sibling::label")
    WebElement labelDamagedText = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007352747']")
    WebElement checkBoxStolen = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007352747']/following-sibling::label")
    WebElement labelStolenText = null;
    private @FindBy(xpath = "//button[@data-test-id='20190506100908067919212']")
    WebElement buttonContinue = null;
    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueMobile = null;
    private @FindBy(xpath = "//input[@data-test-id='20190506094338014818697']")
    WebElement buttonBack = null;
    private @FindBy(xpath = "//input[@data-test-id='201906271628360456129903']")
    WebElement checkBoxLostProperty = null;
    private @FindBy(xpath = "//input[@data-test-id='20190628092817037265114']")
    WebElement checkBoxSomethingElse = null;

    private @FindBy(xpath = "//input[@data-test-id='20190410174412007353618' and @aria-label='This sounds like it needs an intimidate attention']")
    WebElement toggleHurtOrThreatened = null;


    private @FindBy(xpath = "//input[@data-test-id='20190410174412007353618' and @checked]")
    WebElement toggleHurtOrThreatenedSelected = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007251929']")
    WebElement toggleDamaged = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007251929' and @checked]")
    WebElement toggleDamagedSelected = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007352747']")
    WebElement toggleStolen = null;
    private @FindBy(xpath = "//input[@data-test-id='20190410174412007352747' and @checked]")
    WebElement toggleStolenSelected = null;
    private @FindBy(xpath = "//div[@data-test-id='201906271628360456129903']//input")
    WebElement radioLostPropertyNotSelected = null;
    private @FindBy(xpath = "//div[@data-test-id='201906271628360456129903' and @radvalue='true']//input")
    WebElement radioLostPropertySelected = null;
    private @FindBy(xpath = "//div[@data-test-id='20190628092817037265114']//input")
    WebElement radioSomethingElseNotSelected = null;
    private @FindBy(xpath = "//div[@data-test-id='20190628092817037265114' and @radvalue='true']//input")
    WebElement radioSomethingElseSelected = null;


    public String getCurrentPageName() throws InterruptedException {
        return waitandGetText(linkWhatHappened);
    }

    public void clickOnSomeOneIsHurt() {
        waitAndclickElementUsingJS(checkBoxSomeOneHurt);
        _persistentData.setContext("hurtIndicator", "yes");
    }

    public void clickOnDamaged() {
        waitAndClickElement(checkBoxDamaged);
        _persistentData.setContext("damagedIndicator", "yes");
    }

    public void clickOnSomethingIsStolen() {
        waitAndclickElementUsingJS(checkBoxStolen);
        _persistentData.setContext("stolenIndicator", "yes");
    }

    public void clickOnLostProperty() {
        waitAndclickElementUsingJS(checkBoxLostProperty);
        _persistentData.setContext("lostPropertyIndicator", "yes");
    }

    public void clickOnSomethingElse() {
        waitAndclickElementUsingJS(checkBoxSomethingElse);
        _persistentData.setContext("somethingElseIndicator", "yes");
    }

    public void clickOnContinueButton() {
        waitAndclickElementUsingJS(buttonContinue);
    }

    public void clickOnBackButton() {
        waitAndclickElementUsingJS(buttonBack);
    }

    public boolean checkHurtCheckboxExists() {
        return isElementDisplayed(checkBoxSomeOneHurt);
    }

    public boolean checkStolenCheckboxExists() {
        return isElementDisplayed(checkBoxStolen);
    }

    public boolean checkDamagedCheckboxExists() {
        return isElementDisplayed(checkBoxDamaged);
    }

    public boolean checkLostPropertyCheckboxExists() {
        return isElementDisplayed(checkBoxLostProperty);
    }

    public boolean checkSomethingCheckboxExists() {
        return isElementDisplayed(checkBoxSomethingElse);
    }

    public boolean checkHurtCheckboxDoesNotExists() {
        return isElementNotDisplayed(checkBoxSomeOneHurt);
    }

    public boolean checkStolenCheckboxDoesNotExists() {
        return isElementNotDisplayed(checkBoxStolen);
    }

    public boolean checkDamagedCheckboxDoesNotExists() {
        return isElementNotDisplayed(checkBoxDamaged);
    }

    public boolean checkLostPropertyCheckboxDoesNotExists() {
        return isElementNotDisplayed(checkBoxLostProperty);
    }

    public boolean checkSomethingCheckboxDoesNotExists() {
        return isElementNotDisplayed(checkBoxSomethingElse);
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

    public boolean checkHurtToggleDeSelectedMobile() {
        return isElementDisplayed(toggleHurtOrThreatened);
    }

    public boolean checkHurtToggleSelectedMobile() {
        return isElementDisplayed(toggleHurtOrThreatenedSelected);
    }

    public boolean checkStolenToggleDeSelectedMobile() {
        return isElementDisplayed(toggleStolen);
    }

    public boolean checkStolenToggleSelectedMobile() {
        return isElementDisplayed(toggleStolenSelected);
    }

    public boolean checkDamagedToggleDeSelectedMobile() {
        return isElementDisplayed(toggleDamaged);
    }

    public boolean checkDamagedToggleSelectedMobile() {
        return isElementDisplayed(toggleDamagedSelected);
    }

    public boolean checkLostPropertyToggleExistsMobile() {
        return isElementDisplayed(radioLostPropertyNotSelected);
    }

    public boolean checkSomethingElseToggleExistsMobile() {
        return isElementDisplayed(radioSomethingElseNotSelected);
    }

    public boolean checkHurtToggleIsDeSelectedMobile() {
        return isElementDisplayed(toggleHurtOrThreatened);
    }

    public boolean checkHurtToggleIsSelectedMobile() {
        return isElementDisplayed(toggleHurtOrThreatenedSelected);
    }

    public boolean checkStolenToggleIsDeSelectedMobile() {
        return isElementDisplayed(toggleStolen);
    }

    public boolean checkStolenToggleIsSelectedMobile() {
        return isElementDisplayed(toggleStolenSelected);
    }

    public boolean checkDamagedToggleIsDeSelectedMobile() {
        return isElementDisplayed(toggleDamaged);
    }

    public boolean checkDamagedToggleIsSelectedMobile() {
        return isElementDisplayed(toggleDamagedSelected);
    }

    public boolean checkLostPropertyRadioButtonIsDeSelectedMobile() {
        return isElementDisplayed(radioLostPropertyNotSelected);
    }

    public boolean checkLostPropertyRadioButtionIsSelected() {
        return isElementDisplayed(radioLostPropertySelected);
    }

    public boolean checkSomethingElseRadioDeSelected() {
        return isElementDisplayed(radioSomethingElseNotSelected);
    }

    public boolean checkSomethingElseRadioSelected() {
        return isElementDisplayed(radioSomethingElseSelected);
    }

}
