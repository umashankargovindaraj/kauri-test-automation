package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class VisionAndHearingCheckStep extends DriverFactory {

    @And("fill Vision and Hearing Checks details and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillVisionAndHearingChecksDetailsAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _VisionAndHearingCheckPage.visionAndHearingChecks();
    }
}
