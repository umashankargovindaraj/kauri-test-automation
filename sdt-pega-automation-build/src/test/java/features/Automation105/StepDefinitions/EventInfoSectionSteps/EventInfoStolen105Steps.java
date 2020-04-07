package features.Automation105.StepDefinitions.EventInfoSectionSteps;

import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;

import java.util.List;
import java.util.Map;

public class EventInfoStolen105Steps extends DriverFactory {
    @And("I have indicated {string} to add stolen vehicle where ownerType is the owner of stolen vehicle and keyed in details from stolenVehicleDataSet object in datafile")
    public void iHaveIndicatedToAddStolenVehicleWhereOwnerTypeIsTheOwnerOfStolenVehicleAndKeyedInDetailsFromStolenVehicleDataSetObjectInDatafile(String answer, DataTable stolenVehicleTable) {
        if(answer.equalsIgnoreCase("no")){
            _eventStolen105.clickOnStolenVehicleToggleNo();
        }else{
            _eventStolen105.clickOnStolenVehicleToggleYes();
            List<Map<String,String>> stolenVehicles= stolenVehicleTable.asMaps(String.class,String.class);
            boolean lastEntry = false;
            for(int i = 0;i < stolenVehicles.size(); i++){
                int count = i + 1;
                String dataSetObject = stolenVehicles.get(i).get("stolenVehicleDataSet");
                String stolenVehicleOwner = _retrieveTestData.extractDataOffDataFile(dataSetObject + ".owner.value");
                if(stolenVehicles.size() == 1 || count == stolenVehicles.size()){
                    lastEntry = true;
                }
                //enter stolen vehicle details based on who owns it
                _eventStolen105.selectStolenVehicleOwner(stolenVehicleOwner);
                _eventStolen105.keyInRelevantAnswersForStolenVehicleOwner(stolenVehicleOwner,dataSetObject);
                _eventStolen105.keyInStolenVehicleLicensePlate(dataSetObject);
                _eventStolen105.selectWhereWasTheVehicleStolenFrom(dataSetObject);
                _eventStolen105.selectStolenVehicleType(dataSetObject);
                _eventStolen105.selectStolenVehicleMake(dataSetObject);
                _eventStolen105.setToggleAgreeTowingCostYes();
                _eventStolen105.keyInIdentifyingFeatures(dataSetObject);
                if(!lastEntry){
                    //click on add another stolen vehicle
                    _eventStolen105.indicateAddAdditionalStolenVehicle();
                }
            }
        }

    }

    @And("I have indicated ownerType is the owner of stolen item and keyed in owner's name from stolenItemDataSet object in datafile")
    public void iHaveIndicatedOwnerTypeIsTheOwnerOfStolenItemAndKeyedInOwnerSNameFromStolenItemDataSetObjectInDatafile(DataTable stolenItemsTable) {
        List<Map<String,String>> stolenItems= stolenItemsTable.asMaps(String.class,String.class);
        boolean lastEntry = false;
        for(int i = 0;i < stolenItems.size(); i++){
            int count = i + 1;
            String dataSetObject = stolenItems.get(i).get("stolenItemDataSet");
//            String stolenItemOwner = _retrieveTestData.extractDataOffDataFile(dataSetObject + ".owner.value");
            String stolenItemOwner = stolenItems.get(i).get("ownerType");
            if(stolenItems.size() == 1 || count == stolenItems.size()){
                lastEntry = true;
            }
            _eventStolen105.selectStolenItemOwnerFromDropDown(stolenItemOwner);
            _eventStolen105.keyInRelevantAnswersForStolenItemOwner(stolenItemOwner,dataSetObject);
            //enter stolen item details based on who owns it
            _eventStolen105.keyInDataOnWhatWasStolen(dataSetObject);
            _eventStolen105.keyInSerialNumberOfStolenItem(dataSetObject);
            _eventStolen105.keyInValueOfStolenItem(dataSetObject);
            _eventStolen105.keyInDescribeOfStolenItem(dataSetObject);

            if(!lastEntry){
                //click on add another stolen item
                _eventStolen105.indicateAddAdditionalStolenItems();
            }
        }
    }
}

