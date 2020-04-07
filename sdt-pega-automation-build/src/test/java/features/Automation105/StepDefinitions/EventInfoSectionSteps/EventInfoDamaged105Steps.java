package features.Automation105.StepDefinitions.EventInfoSectionSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;

import java.util.List;
import java.util.Map;

public class EventInfoDamaged105Steps extends DriverFactory {

//    @And("I select {string} for {int} damaged vehicles for different owners")
//    public void iSelectForDamagedVehicles(String damagedVehicleAnswer, int numberOfDamagedVehicles) {
//        if(damagedVehicleAnswer.equalsIgnoreCase("no")){
//            _eventDamaged105.clickOnToggleVehicleDamagedNo();
//        }else if(damagedVehicleAnswer.equalsIgnoreCase("yes")){
//            _eventDamaged105.clickOnToggleVehicleDamagedYes();
//            _eventDamaged105.addVehicleAndOwnerDetails(numberOfDamagedVehicles);
//        }
//    }


    /*@When("I have indicated {string} is the owner of damaged item and keyed in owner's name")
    public void i_have_indicated_is_the_owner_of_damaged_item_and_keyed_in_owner_s_name(String damagedItemOwner) {
        _eventDamaged105.selectDamagedItemOwnerFromDropDown(damagedItemOwner);
        _eventDamaged105.keyInDataOnDamagedItemOwnerField(damagedItemOwner);
    }*/


    @And("I have indicated ownerType is the owner of damaged item and keyed in owner's name from damagedItemDataSet object in datafile")
    public void iHaveIndcatedOwnerTypeIsTheOwnerOfDamagedItemAndKeyedInOwnerSNameFromDamagedItemDataSetObjectInDatafile(DataTable damagedItemEntries) {
        List<Map<String,String>> damagedItems= damagedItemEntries.asMaps(String.class,String.class);
        boolean lastEntry = false;
        for(int i = 0;i < damagedItems.size(); i++){
            System.out.println(damagedItems.size());
            int count = i + 1;
            String dataSetObject = damagedItems.get(i).get("damagedItemDataSet");
            String damagedItemOwner = _retrieveTestData.extractDataOffDataFile(dataSetObject + ".owner.value");
            if(damagedItems.size() == 1 || count == damagedItems.size()){
                lastEntry = true;
            }
            _eventDamaged105.selectDamagedItemOwnerFromDropDown(damagedItemOwner);
            _eventDamaged105.keyInDataOnDamagedItemOwnerField(damagedItemOwner,dataSetObject);
            //enter damaged item details based on who owns it
            _eventDamaged105.keyInDataOnWhatWasDamaged(dataSetObject);
            _eventDamaged105.keyInHowWasItDamagedData(dataSetObject);
            if(!lastEntry){
                //click on add another damaged item
                _eventDamaged105.clickOnAddDamagedItem();
            }
        }
    }

    @And("I have indicated {string} to add damaged vehicle where ownerType is the owner of damaged vehicle and keyed in details from damagedVehicleDataSet object in datafile")
    public void iHaveIndicatedToAddDamagedVehicleWhereOwnerTypeIsTheOwnerOfDamagedVehicleAndKeyedInDetailsFromDamagedVehicleDataSetObjectInDatafile(String damagedVehicleAnswer, DataTable damagedVehiclesTable) {
        if(damagedVehicleAnswer.equalsIgnoreCase("no")){
            _eventDamaged105.clickOnToggleVehicleDamagedNo();
        }else if(damagedVehicleAnswer.equalsIgnoreCase("yes")){
            _eventDamaged105.clickOnToggleVehicleDamagedYes();
            List<Map<String,String>> damagedVehicles= damagedVehiclesTable.asMaps(String.class,String.class);
            boolean lastEntry = false;
            for(int i = 0;i < damagedVehicles.size(); i++){
                int count = i + 1;
                String dataSetObject = damagedVehicles.get(i).get("damagedVehicleDataSet");
                String damagedVehicleOwner = _retrieveTestData.extractDataOffDataFile(dataSetObject + ".owner.value");
                if(damagedVehicles.size() == 1 || count == damagedVehicles.size()){
                    lastEntry = true;
                }
                _eventDamaged105.selectDamagedVehicleOwnerFromDropDown(damagedVehicleOwner);
                _eventDamaged105.keyInDataOnDamagedVehicleOwnerField(damagedVehicleOwner,dataSetObject);
                //enter stolen item details based on who owns it
                _eventDamaged105.keyInDamagedVehicleLicensePlate(dataSetObject);
                _eventDamaged105.selectDamagedVehicleType(dataSetObject);
                _eventDamaged105.selectDamagedVehicleMake(dataSetObject);
                _eventDamaged105.keyInIdentifyingFeatures(dataSetObject);
                _eventDamaged105.selectWhereWasVehicleWhenItWasDamaged(dataSetObject);
                _eventDamaged105.keyInHowWasVehicleDamaged(dataSetObject);
                _eventDamaged105.selectDamagedVehicleMovedIndicator(dataSetObject);
                _eventDamaged105.selectDamagedVehicleIgnitionTamperedIndicator(dataSetObject);

                if(!lastEntry){
                    _eventDamaged105.clickOnButtonAddDamagedVehicle();
                }
            }
        }
    }
}
