package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class SDQTeacherStep extends DriverFactory {

    @And("fill SDQ Teacher details and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillSDQTeacherDetailsAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _SDQTeacherPage.SDQTeacher();

    }
}
