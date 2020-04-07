package features.OnlineReporting.StepDefinitions.EventInfoSectionsSteps;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoLostItemsSteps extends DriverFactory {

    @When("I have indicated {string} is the owner of lost item and keyed in owner's name")
    public void i_have_indicated_is_the_owner_of_lost_item_and_keyed_in_owner_s_name(String lostItemOwner) {
        _eventLost.selectLostItemOwnerFromDropDown(lostItemOwner);
        _eventLost.keyInLostVehicleOwnerName(lostItemOwner);
    }

    @When("I have entered required details of lost item")
    public void i_have_entered_required_details_of_lost_item() {
        _eventLost.keyInWhatWasLost();
        _eventLost.keyInLostItemID();
        _eventLost.keyInDescribeHowWasItemLost();
        _eventLost.keyInLostItemValue();
    }

    @Then("I can see three options in the lost item owner dropdown")
    public void I_can_see_three_options_in_the_lost_item_owner_dropdown(){
        String[] ownerLostItem = _generateTestData.generateListData("whatWasLost.owner.value");
        _eventLost.validateLostItemOwnerDropDownValues(ownerLostItem);
    }

    @When("I add another lost item")
    public void i_add_another_lost_item() {
        _eventLost.clickOnButtonAddLostItems();
    }


}
