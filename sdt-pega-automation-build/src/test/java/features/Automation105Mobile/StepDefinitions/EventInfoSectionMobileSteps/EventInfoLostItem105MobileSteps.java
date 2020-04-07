package features.Automation105Mobile.StepDefinitions.EventInfoSectionMobileSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class EventInfoLostItem105MobileSteps extends DriverFactory {
    @When("I have indicated that the owner of lost item is {string}")
    public void i_have_indicated_is_the_owner_of_lost_item(String lostItemOwner) {
        _eventLost105.selectLostItemOwnerFromDropDown(lostItemOwner);
    }

    @Then("I key in the details of lost items")
    public void I_key_in_the_details_of_lost_items() {
        _eventLost105.keyInWhatWasLost();
        _eventLost105.keyInLostItemID();
        _eventLost105.keyInLostItemValue();
        _eventLost105.keyInDescriptionOfItemLost();
    }

    @When("I add multiple lost items into the reports")
    public void iAddMultipleItemsIntoTheReports(DataTable eventDataTable) {
        List<Map<String, String>> listEventDataTable = _eventLost105.getCucumberDataAsList(eventDataTable);
        Assert.assertTrue(listEventDataTable.size() >= 1, "Data not found. Please mention the count of items and event type in a datatable format");
        int itemsAlreadyAdded = 1; //1 item already added in previous step
        int expectedItemCount = Integer.parseInt(listEventDataTable.get(0).get("lostItemCount"));
        for (int i = 0; i < (expectedItemCount - itemsAlreadyAdded); i++) {
            switch (listEventDataTable.get(0).get("eventType")) {
                case "lost":
                    _eventLost105.keyInLostItemSection();
                    break;
                case "stolen":
                    //ToDo
                    break;
                case "damaged":
                    //ToDo
                    break;
            }
        }
    }

    @And("I have indicated the owner of lost item and keyed in owner's name from the datatable")
    public void iHaveIndicatedTheOwnerOfLostItemAndKeyedInOwnerSNameFromTheDatatable(DataTable lostItemEntries) {
        List<Map<String, String>> lostItems = _eventLost105.getCucumberDataAsList(lostItemEntries);

        boolean lastEntry = false;
        for (int i = 0; i < lostItems.size(); i++) {
            System.out.println(lostItems.size());
            int count = i + 1;
            String dataSetObject = lostItems.get(i).get("lostItemDataSet");
            String lostItemOwner = _retrieveTestData.extractDataOffDataFile(dataSetObject + ".owner.value");
            if (lostItems.size() == 1 || count == lostItems.size()) {
                lastEntry = true;
            }
            _eventLost105.keyInWhatWasLostMobile(dataSetObject);
            _eventLost105.selectLostItemOwnerFromDropDown(lostItemOwner);
            _eventLost105.keyInLostOwnerDetails(lostItemOwner, dataSetObject);
            _eventLost105.keyInLostItemID(dataSetObject);
            _eventLost105.keyInLostItemValue(dataSetObject);
            _eventLost105.keyInDescriptionOfItemLost(dataSetObject);
            if (!lastEntry) {
                //click on add another damaged item
                _eventLost105.clickOnButtonAddLostItems();
            }
        }
    }
}
