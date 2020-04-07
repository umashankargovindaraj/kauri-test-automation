package features.OnlineReportingMobile.StepDefinitions.EventInfoSectionsMobileSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;

import java.util.List;
import java.util.Map;

public class EventInfoLostPropertyMobileSteps extends DriverFactory {

    @When("I have indicated {string} is the owner of lost item and keyed in owner's name")
    public void i_have_indicated_is_the_owner_of_lost_item_and_keyed_in_owner_s_name(String lostItemOwner) {
        _eventLost.selectLostItemOwnerFromDropDown(lostItemOwner);
        //_eventLost.selectLostItemOwnerFromDropDownMobile(lostItemOwner);
        _eventLost.keyInLostVehicleOwnerNameMobile(lostItemOwner);
        //_eventLost.keyInLostVehicleOwnerName(lostItemOwner);
    }

    @When("I click on continue in the lost item details page and navigate to the next page")
    public void I_click_on_continue_in_the_lost_item_details_page_and_navigate_to_the_next_page() {
        _eventLost.clickOnContinueFromLostPropertyDetailsPageMobile();
    }

    @When("I have entered required details of lost item")
    public void i_have_entered_required_details_of_lost_item() {
        _eventLost.keyInWhatWasLost();
        _eventLost.keyInLostItemID();
        _eventLost.keyInLostItemValue();
        _eventLost.keyInDescribeHowWasItemLost();
    }



    @Then("I can see three options in the lost item owner dropdown")
    public void I_can_see_three_options_in_the_lost_item_owner_dropdown() {
        String[] ownerLostItem = _generateTestData.generateListData("whatWasLost.owner.value");
        _eventLost.validateLostItemOwnerDropDownValues(ownerLostItem);
    }

    @When("I add another lost item")
    public void i_add_another_lost_item() {
        _eventLost.clickOnButtonAddLostItems();
    }


}
