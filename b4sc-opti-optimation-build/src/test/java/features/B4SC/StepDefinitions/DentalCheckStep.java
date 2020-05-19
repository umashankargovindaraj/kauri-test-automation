package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DentalCheckStep extends DriverFactory {

    @And("fill Dental details and save then confirm status is completed in B{int} School Checks Overview Page")
    public void fillDentalDetailsAndSaveThenConfirmStatusIsCompletedInBSchoolChecksOverviewPage(int arg0) {
        _DentalCheckPage.dentalChecks();
    }


    @And("fill Dental details and save then confirm status is In Progress in B{int} School Checks Overview Page")
    public void fillDentalDetailsAndSaveThenConfirmStatusIsInProgressInBSchoolChecksOverviewPage(int arg0) {
        _DentalCheckPage.dentalChecksReferred();
    }

}
