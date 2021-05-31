package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class ImmunisationCheckStep extends DriverFactory {

    @And("fill Immunisation details and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillImmunisationDetailsAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _ImmunisationCheckPage.ImmunisationChecks();
    }

    @And("fill Immunisation details and save then confirm status is In Progress in B{int} School Checks Overview Page")
    public void fillImmunisationDetailsAndSaveThenConfirmStatusIsInProgressInBSchoolChecksOverviewPage(int arg0) {
        _ImmunisationCheckPage.ImmunisationCheckReferred();

    }
}
