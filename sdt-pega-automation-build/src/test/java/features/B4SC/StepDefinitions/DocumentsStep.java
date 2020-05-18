package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class DocumentsStep extends DriverFactory {

    @And("click Documents Page link")
    public void clickDocumentsPageLink() {
        _DocumentsPage.clickDocumentsLink();
    }

    @And("click upload document link")
    public void clickUploadDocumentLink() {
    _DocumentsPage.uploadDocLink();
    }

    @Then("user attach the file by clicking choose file button")
    public void userAttachTheFileByClickingChooseFileButton() {
        _DocumentsPage.uploadDoc();
    }

    @Then("click upload button")
    public void clickUploadButton() {
        _DocumentsPage.clickUploadButton();

    }
}
