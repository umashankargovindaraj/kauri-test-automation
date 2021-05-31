package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import libs.DriverFactory;

public class ExportStep extends DriverFactory {

    @And("click Export tab")
    public void clickExportTab() {
    _ExportPage.clickExportTab();
    }

    @Then("click Export button to export partial child")
    public void clickExportButtonToExportPartialChild() {
        _ExportPage.clickExportButton();
    }
}
