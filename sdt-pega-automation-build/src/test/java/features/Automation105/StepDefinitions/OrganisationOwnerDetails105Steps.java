package features.Automation105.StepDefinitions;

import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;

import java.util.List;
import java.util.Map;

public class OrganisationOwnerDetails105Steps extends DriverFactory {

    @And("I can enter organisation details and select address from lookup")
    public void iCanEnterOrganisationDetailsAndSelectAddressFromLookup() {
        //int index = (int) _persistentData.getContext("organisationOwnerNameElementIndex");
        int index = 0;
        _organisationOwnerDetails105.keyInOrganisationAddress(index);
        _organisationOwnerDetails105.keyInOrganisationContactDetails(index);
    }

    @And("I can enter owner organisation details and key in manual address")
    public void Icanenterownerorganisationdetailsandkeyinmanualaddress(DataTable organisationOwnerDataSet) {
        List<Map<String, String>> listOrganisationOwnerObjectDataTable = _organisationOwnerDetails105.getCucumberDataAsList(organisationOwnerDataSet);
        _organisationOwnerDetails105.verifyOrganisationDetailsandKeyInDetails(listOrganisationOwnerObjectDataTable, true);
    }
}
