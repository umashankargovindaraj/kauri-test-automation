package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import libs.DriverFactory;

public class GrowthCheckStep extends DriverFactory {

    @And("fill Growth details and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillGrowthDetailsAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _GrowthCheckPage.growthChecks();
    }


}
