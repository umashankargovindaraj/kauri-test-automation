package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class SDQParentStep extends DriverFactory {

    @And("fill SDQ Parent details and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillSDQParentDetailsAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _SDQParentPage.SDQParent();
    }

    @And("fill SDQ Parent details and save then confirm status is In Progress in B{int} School Checks Overview Page")
    public void fillSDQParentDetailsAndSaveThenConfirmStatusIsInProgressInBSchoolChecksOverviewPage(int arg0) {
    _SDQParentPage.SDQParentReferred();
    }


}
