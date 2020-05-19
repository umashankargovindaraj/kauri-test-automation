package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class DentalReferralStep extends DriverFactory {


    @And("fill the dental Check Referrals to In progress status and save then verify referral status showing as In Progress")
    public void fillTheDentalCheckReferralsToInProgressStatusAndSaveThenVerifyReferralStatusShowingAsInProgress() {
        _DentalReferralPage.dentalCheckReferralInProgress();

    }

    @And("now go back to dental Check Referral and change the status from In Progress to Completed")
    public void nowGoBackToDentalCheckReferralAndChangeTheStatusFromInProgressToCompleted() {
        _DentalReferralPage.dentalCheckReferralCompleted();
    }
}
