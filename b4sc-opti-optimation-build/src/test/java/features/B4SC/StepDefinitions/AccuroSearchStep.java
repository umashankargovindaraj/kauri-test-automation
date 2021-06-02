package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class AccuroSearchStep extends DriverFactory {

    @When("perform first name search")
    public void performfirstnamesearch() {
        _AccuroSearchPage.searchFName();
    }

    @When("perform last name search")
    public void performlastnamesearch() {
        _AccuroSearchPage.searchLName();
    }

    @When("perform dob search")
    public void performdobsearch() {
        _AccuroSearchPage.searchDOB();
    }

    @When("perform phone number search")
    public void performphonenumbersearch() {
        _AccuroSearchPage.searchPhNo();
    }

    @When("perform emailID search")
    public void performemailIDsearch() {
        _AccuroSearchPage.searchEmail();
    }

    @When("perform first and last name search")
    public void performfirstandlastnamesearch() {
        _AccuroSearchPage.searchFirstAndLastName();
    }

    @When("perform first name and phone number search")
    public void performfirstnameandphonenumbersearch() {
        _AccuroSearchPage.searchFirstNameAndPhoneNo();
    }

    @When("perform last name and phone number search")
    public void performlastnameandphonenumbersearch() {
        _AccuroSearchPage.searchLastNameAndPhoneNo();
    }

    @When("perform email address and dob search")
    public void performemailaddressanddobsearch() {
        _AccuroSearchPage.searchEmailAndDOB();
    }

    @When("perform first name last name and dob search")
    public void performfirstnamelastnameanddobsearch() {
        _AccuroSearchPage.searchFirstNameLastNameAndDOB();
    }

    @When("perform invalid first and last name search to verify no results found")
    public void performinvalidfirstandlastnamesearchtoverifynoresultsfound() {
        _AccuroSearchPage.searchWithInvalidFirstNameLastName();
    }
}
