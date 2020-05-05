package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import libs.DriverFactory;

import java.awt.*;

public class ReturnChildToCoordinatorStep extends DriverFactory {

    @And("click Allocation History link in Child Information page and fill Return Child to Coordinator fields")
    public void clickAllocationHistoryLinkInChildInformationPageAndFillReturnChildToCoordinatorFields() throws AWTException, InterruptedException {
        _ReturnChildToCoordinatorPage.returnChildToCoordinator();
    }
}
