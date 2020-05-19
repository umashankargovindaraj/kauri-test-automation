package features.B4SC.StepDefinitions;

import cucumber.api.java.en.Then;
import libs.DriverFactory;

public class ClosingB4SchoolChildRecordStep extends DriverFactory {



    @Then("confirm that child record will not be closed since Dental Check referral is still in progress")
    public void confirmThatChildRecordWillNotBeClosedSinceChildHealthQuestionaireReferralIsStillInProgress() {
        _ClosingB4SchoolChildRecordPage.closingB4SchoolChildRecordFAILED();
    }

    @Then("close the child record as No consent given and no health checks can be added")
    public void closeTheChildRecordAsNoConsentGivenAndNoHealthChecksCanBeAdded() {
        _ClosingB4SchoolChildRecordPage.closingB4SchoolChildRecordWithNOConsentAndNoChecksAdded();

    }

    @Then("close Childs Before School Check Record from Before School Application")
    public void closeChildsBeforeSchoolCheckRecordFromBeforeSchoolApplication() {
        _ClosingB4SchoolChildRecordPage.closingB4SchoolChildRecord();

    }
}
