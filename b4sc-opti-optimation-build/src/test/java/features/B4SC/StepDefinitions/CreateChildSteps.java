package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class CreateChildSteps extends DriverFactory {

    @When("user enter mandatory child information and save")
    public void userEnterMandatoryChildInformationAndSave() {
        _CreateChildPage.enterMandateChildInformation();
    }
    @And("User select the new child button")
    public void userSelectTheNewChildButton() {
        _CreateChildPage.clickNewChildButton();
    }

    @Then("create new child screen displayed")
    public void createNewChildScreenDisplayed() {

        _CreateChildPage.enterMandateChildInformation();
    }

    @And("user edit mandatory child information and save")
    public void userEditMandatoryChildInformationAndSave() {
        _CreateChildPage.editMandateChildInformation();
    }

    @Then("confirm the previous child information removed from the user record")
    public void confirmThePreviousChildInformationRemovedFromTheUserRecord() {
    _CreateChildPage.childNotPresent();
    //This is to assign new nhi number to NHI_NUMBER key
        String new_NHI = getAppData().getFromMap("EDITED_NHI");
        if(!(new_NHI.isEmpty())){
            getAppData().putToMap("NHI_NUMBER",new_NHI);
        }
    }

    @And("enter child date of death and click save button and then confirm the child record is deceased")
    public void enterChildDateOfDeathAndClickSaveButtonAndThenConfirmTheChildRecordIsDeceased() {
        _CreateChildPage.enterChildDateOfDeath();
    }
}
