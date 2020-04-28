package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class HearingStep extends DriverFactory {

    @And("fill Hearing details and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillHearingDetailsAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _HearingPage.hearing();
    }

}
