package features.OnlineReporting.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;

public class WhatHappenedSteps extends DriverFactory {

    @When("I select the checkboxes in SelectOptions page {string}, {string}, {string}, {string}, {string}")
    public void i_select_the_checkboxes_in_SelectOptions_page(String damaged, String stolen, String hurt, String lost, String somethingElse) throws InterruptedException {
        System.out.println("User selection from previous page");
        System.out.println("Damaged : " + damaged);
        System.out.println("Theft : " + stolen);
        System.out.println("Hurt : " + hurt);

        if (hurt.equalsIgnoreCase("yes")) {
            _whatHappened.clickOnSomeOneIsHurt();
        }

        if (damaged.equalsIgnoreCase("yes")) {
            _whatHappened.clickOnDamaged();
        }

        if (stolen.equalsIgnoreCase("yes")) {
            _whatHappened.clickOnSomethingIsStolen();
        }

        if (lost.equalsIgnoreCase("yes")) {
            _whatHappened.clickOnLostProperty();
        }

        if (somethingElse.equalsIgnoreCase("yes")) {
            _whatHappened.clickOnSomethingElse();
        }
    }

    @Then("I should see the relevant {string}, {string}, {string}, {string}, {string} based on the selection made on the checkboxes")
    public void i_should_see_the_relevant_based_on_the_selection_made_on_the_checkboxes(String damageSection, String stolenSection, String hurtSection, String lostProperty, String somethingElse) {
        if (damageSection.equalsIgnoreCase("yes")) {
            Assert.assertTrue(_eventDamaged.checkIfDamagedDetailsSectionIsDisplayed(), "Checking if Section to key in details of Damaged item is displayed");
        }

        if (stolenSection.equalsIgnoreCase("yes")) {
            Assert.assertTrue(_eventStolen.checkIfStolenDetailsSectionIsDisplayed(), "Checking if Section to key in details of Stolen item is displayed");
        }

        if (hurtSection.equalsIgnoreCase("yes")) {
            Assert.assertTrue(_eventHurt.checkIfHurtDetailsSectionIsDisplayed(), "Checking if Section to key in details of Hurt item is displayed");
        }

        if (lostProperty.equalsIgnoreCase("yes")) {
            Assert.assertTrue(_eventLost.checkIfLostPropertySectionExists(), "Checking if Section to key in details of Hurt item is displayed");
        }

        if (somethingElse.equalsIgnoreCase("yes")) {
            Assert.assertTrue(_eventSomethingElse.checkIfWhatHappenedSomethingElseExists(), "Checking if Section to key in details of Hurt item is displayed");
        }
    }


    @When("select continue")
    public void select_continue() {
        _whatHappened.clickOnContinueButton();
    }

    @Then("I should be navigated to the Questions Page")
    public void i_should_be_navigated_to_the_Questions_Page() {

    }

    @Then("I should be able to select Lost Property checkbox only when damaged, hurt, stolen or Something else checkbox is not selected")
    public void i_should_be_able_to_select_Lost_Property_checkbox_only_when_damaged_hurt_stolen_or_Something_else_checkbox_is_not_selected() {
        Assert.assertTrue(_whatHappened.checkLostPropertyCheckboxExists());
        _whatHappened.clickOnSomeOneIsHurt();
        Assert.assertTrue(_whatHappened.checkLostPropertyCheckboxDoesNotExists());
        _whatHappened.clickOnSomeOneIsHurt();
        Assert.assertTrue(_whatHappened.checkLostPropertyCheckboxExists());
        _whatHappened.clickOnSomethingElse();
        Assert.assertTrue(_whatHappened.checkLostPropertyCheckboxDoesNotExists());
        _whatHappened.clickOnSomethingElse();
        _whatHappened.clickOnLostProperty();
        Assert.assertTrue(_whatHappened.checkHurtCheckboxDoesNotExists());
        Assert.assertTrue(_whatHappened.checkDamagedCheckboxDoesNotExists());
        Assert.assertTrue(_whatHappened.checkSomethingCheckboxDoesNotExists());
        _whatHappened.clickOnLostProperty();
    }

    @Then("I should be able to select Something else checkbox only when damaged, hurt, stolen or Lost Property checkbox is not selected")
    public void i_should_be_able_to_select_Something_else_checkbox_only_when_damaged_hurt_stolen_or_Lost_Property_checkbox_is_not_selected() {
        Assert.assertTrue(_whatHappened.checkSomethingCheckboxExists());
        _whatHappened.clickOnLostProperty();
        Assert.assertTrue(_whatHappened.checkSomethingCheckboxDoesNotExists());
        _whatHappened.clickOnLostProperty();
        Assert.assertTrue(_whatHappened.checkSomethingCheckboxExists());
        _whatHappened.clickOnSomeOneIsHurt();
        Assert.assertTrue(_whatHappened.checkSomethingCheckboxDoesNotExists());
        _whatHappened.clickOnSomeOneIsHurt();
        Assert.assertTrue(_whatHappened.checkSomethingCheckboxExists());
        _whatHappened.clickOnSomethingElse();
        Assert.assertTrue(_whatHappened.checkLostPropertyCheckboxDoesNotExists());
        Assert.assertTrue(_whatHappened.checkDamagedCheckboxDoesNotExists());
        Assert.assertTrue(_whatHappened.checkLostPropertyCheckboxDoesNotExists());
        _whatHappened.clickOnSomethingElse();
    }

    @Then("I should be able to select damaged, hurt or stolen only when Lost property or Something else checkbox is not selected")
    public void i_should_be_able_to_select_damaged_hurt_or_stolen_only_when_Lost_property_or_Something_else_checkbox_is_not_selected() {
        Assert.assertTrue(_whatHappened.checkDamagedCheckboxExists());
        Assert.assertTrue(_whatHappened.checkHurtCheckboxExists());
        Assert.assertTrue(_whatHappened.checkStolenCheckboxExists());
        _whatHappened.clickOnLostProperty();
        Assert.assertTrue(_whatHappened.checkDamagedCheckboxDoesNotExists());
        Assert.assertTrue(_whatHappened.checkHurtCheckboxDoesNotExists());
        Assert.assertTrue(_whatHappened.checkStolenCheckboxDoesNotExists());
        _whatHappened.clickOnLostProperty();
        Assert.assertTrue(_whatHappened.checkDamagedCheckboxExists());
        Assert.assertTrue(_whatHappened.checkHurtCheckboxExists());
        Assert.assertTrue(_whatHappened.checkStolenCheckboxExists());
        _whatHappened.clickOnSomethingElse();
        Assert.assertTrue(_whatHappened.checkDamagedCheckboxDoesNotExists());
        Assert.assertTrue(_whatHappened.checkHurtCheckboxDoesNotExists());
        Assert.assertTrue(_whatHappened.checkStolenCheckboxDoesNotExists());
    }

    @When("I indicate that something has been hurt, stolen and damaged")
    public void i_indicate_that_something_has_been_hurt_stolen_and_damaged() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


}
