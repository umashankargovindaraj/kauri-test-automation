package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class AccuroAddNewMemberStep extends DriverFactory {

    @When("click on add new member button and provide member details and click next button")
    public void clickonaddnewmemberbuttonandprovidememberdetailsandclicknextbutton() {
        _AccuroSearchPage.methodtoenableAddNewMemberButton();
        _AccuroAddNewMemberPage.addNewMemberDetails();
    }
}