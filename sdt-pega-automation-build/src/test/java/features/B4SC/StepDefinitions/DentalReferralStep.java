package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class DentalReferralStep extends DriverFactory {

    @And("fill the Child Check Referrals to In progress status and save then verify referral status showing as In Progress")
    public void fillTheChildHealthQuestionnaireReferralsAsInProgressAndSaveConfirmStatusAsOutstanding() {
    _DentalReferralPage.dentalCheckReferralInProgress();
    }
}
