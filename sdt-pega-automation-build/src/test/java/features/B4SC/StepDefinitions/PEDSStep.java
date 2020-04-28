package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class PEDSStep extends DriverFactory {

    @And("fill PEDS details and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillPEDSDetailsAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _PEDSPage.parentalEvaluationOfDevelopmentalStatus_PEDS();
    }
}
