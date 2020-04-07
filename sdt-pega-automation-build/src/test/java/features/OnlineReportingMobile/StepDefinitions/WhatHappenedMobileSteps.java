package features.OnlineReportingMobile.StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;

public class WhatHappenedMobileSteps extends DriverFactory {


    @Then("I should be able to select Lost Property checkbox only when damaged, hurt, stolen or Something else checkbox is not selected")
    public void i_should_be_able_to_select_Lost_Property_checkbox_only_when_damaged_hurt_stolen_or_Something_else_checkbox_is_not_selected() {
        Assert.assertTrue(_whatHappened.checkLostPropertyToggleExistsMobile());
        _whatHappened.clickOnSomeOneIsHurtMobile();
        Assert.assertTrue(_whatHappened.checkLostPropertyRadioButtonIsDeSelectedMobile());
        _whatHappened.clickOnSomethingElseMobile();
        Assert.assertTrue(_whatHappened.checkLostPropertyRadioButtonIsDeSelectedMobile());
        _whatHappened.clickOnLostPropertyMobile();
        Assert.assertTrue(_whatHappened.checkHurtToggleIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkDamagedToggleIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkSomethingElseRadioDeSelected());
    }

    @Then("I should be able to select Something else checkbox only when damaged, hurt, stolen or Lost Property checkbox is not selected")
    public void i_should_be_able_to_select_Something_else_checkbox_only_when_damaged_hurt_stolen_or_Lost_Property_checkbox_is_not_selected() {
        Assert.assertTrue(_whatHappened.checkSomethingElseToggleExistsMobile());
        _whatHappened.clickOnSomeOneIsHurtMobile();
        Assert.assertTrue(_whatHappened.checkSomethingElseRadioDeSelected());
        _whatHappened.clickOnLostPropertyMobile();
        Assert.assertTrue(_whatHappened.checkSomethingElseRadioDeSelected());
        _whatHappened.clickOnSomethingElseMobile();
        Assert.assertTrue(_whatHappened.checkSomethingElseRadioSelected());
        _whatHappened.clickOnSomeOneIsHurtMobile();
        Assert.assertTrue(_whatHappened.checkSomethingElseRadioDeSelected());
        _whatHappened.clickOnSomethingElseMobile();
        Assert.assertTrue(_whatHappened.checkLostPropertyRadioButtonIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkDamagedToggleIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkLostPropertyRadioButtonIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkSomethingElseRadioSelected());
    }

    @Then("I should be able to select damaged, hurt or stolen only when Lost property or Something else checkbox is not selected")
    public void i_should_be_able_to_select_damaged_hurt_or_stolen_only_when_Lost_property_or_Something_else_checkbox_is_not_selected() {
        Assert.assertTrue(_whatHappened.checkDamagedToggleDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkHurtToggleDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkStolenToggleDeSelectedMobile());
        _whatHappened.clickOnSomeOneIsHurtMobile();
        Assert.assertTrue(_whatHappened.checkHurtToggleIsSelectedMobile());
        Assert.assertTrue(_whatHappened.checkDamagedToggleIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkStolenToggleIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkSomethingElseRadioDeSelected());
        Assert.assertTrue(_whatHappened.checkLostPropertyRadioButtonIsDeSelectedMobile());
        _whatHappened.clickOnSomethingIsStolenMobile();
        Assert.assertTrue(_whatHappened.checkStolenToggleIsSelectedMobile());
        Assert.assertTrue(_whatHappened.checkDamagedToggleIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkHurtToggleIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkSomethingElseRadioDeSelected());
        Assert.assertTrue(_whatHappened.checkLostPropertyRadioButtonIsDeSelectedMobile());
        _whatHappened.clickOnDamagedMobile();
        Assert.assertTrue(_whatHappened.checkDamagedToggleIsSelectedMobile());
        Assert.assertTrue(_whatHappened.checkStolenToggleIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkHurtToggleIsDeSelectedMobile());
        Assert.assertTrue(_whatHappened.checkLostPropertyRadioButtonIsDeSelectedMobile());

    }

}
