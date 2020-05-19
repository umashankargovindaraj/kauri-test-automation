package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class VisionReferralStep extends DriverFactory {


    @And("fill the Vision Check Referrals to In progress status and save then verify referral status showing as In Progress")
    public void fillTheVisionCheckReferralsToInProgressStatusAndSaveThenVerifyReferralStatusShowingAsInProgress() {
        _VisionReferralPage.visionReferralInProgress();
    }
}
