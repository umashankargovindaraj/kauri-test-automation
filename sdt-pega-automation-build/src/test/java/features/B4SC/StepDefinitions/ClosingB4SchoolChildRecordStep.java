package features.B4SC.StepDefinitions;

import cucumber.api.java.en.Then;
import libs.DriverFactory;

public class ClosingB4SchoolChildRecordStep extends DriverFactory {

    @Then("close Childs B{int}School Check Record from B{int}School Application")
    public void closeChildsBSchoolCheckRecordFromBSchoolApplication(int arg0, int arg1) {
        _ClosingB4SchoolChildRecordPage.closingB4SchoolChildRecord();
    }
}
