package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

public class ConsentStep extends DriverFactory {

    @And("click B{int}SCHOOL tab")
    public void clickBSCHOOLTab(int arg0) {
        _ConsentPage.b4SchoolLink();
    }

    @And("provide Consent details")
    public void provideConsentDetails() {
        _ConsentPage.provideConsentDetails();
    }

    @And("choose NO to Consent Given field")
    public void chooseNOToConsentGivenField() {
        _ConsentPage.chooseNOConsentGiven();
    }
}
