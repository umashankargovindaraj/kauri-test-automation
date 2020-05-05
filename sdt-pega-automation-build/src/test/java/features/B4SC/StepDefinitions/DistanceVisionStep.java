package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class DistanceVisionStep extends DriverFactory {

    @And("fill Distance Vision details and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillDistanceVisionDetailsAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _DistanceVisionPage.distanceVision();
    }

    @And("fill Distance Vision details and save then confirm status is In Progress in B{int} School Checks Overview Page")
    public void fillDistanceVisionDetailsAndSaveThenConfirmStatusIsInProgressInBSchoolChecksOverviewPage(int arg0) {
    _DistanceVisionPage.distanceVisionReferred();
    }
}
