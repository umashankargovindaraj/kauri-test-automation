package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class ChildHealthCheckStep extends DriverFactory {

    @And("fill Child Health Questionnaire and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillChildHealthQuestionnaireAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _ChildHealthCheckPage.ChildHealthQuestionnaire();
    }

}
