package features.Automation105.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;

import java.util.List;
import java.util.Map;

public class SomebodyElseOwnerDetails105Steps extends DriverFactory {
    @Then("I should be able to key in details of the owner")
    public void I_should_be_able_to_key_in_details_of_the_owner() {
        _somebodyElseOwnerDetails105.keyInAgeOfOwnerSomeOneElse(0);
        _somebodyElseOwnerDetails105.selectInGenderOfOwnerSomeOneElse(0);
        _somebodyElseOwnerDetails105.keyInEmailAddressOfOwnerSomeOneElse(0);
        _somebodyElseOwnerDetails105.selectPhoneTypeOfOwnerOwnerSomeOneElse(0);
        _somebodyElseOwnerDetails105.keyInPhoneNumberOfOwnerSomeOneElse(0);
        _somebodyElseOwnerDetails105.selectAddressTypeSomeOneElseOwner(0);
        _somebodyElseOwnerDetails105.keyInAddressOfOwnerSomeOneElse(0);
        _somebodyElseOwnerDetails105.selectSomeElseOwnerVictimSupportFlag(_retrieveTestData.extractDataOffDataFile("ownerDetails.victimSupport"), 0);
        _somebodyElseOwnerDetails105.selectRelationsShipOfOwnerSomeOneElse(0);
    }

    @And("I can enter somebody else owner details and key in manual address")
    public void iCanEnterSomebodyElseOwnerDetailsAndKeyInManualAddress(DataTable somebodyElseOwnerDataSet) {
        List<Map<String, String>> listSomebodyElseOwnerObjectDataTable = _organisationOwnerDetails105.getCucumberDataAsList(somebodyElseOwnerDataSet);
        _somebodyElseOwnerDetails105.verifySomebodyElseOwnerDetailsandKeyInDetails(listSomebodyElseOwnerObjectDataTable, true);
    }
}
