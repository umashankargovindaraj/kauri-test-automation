package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BeforeSchool.SearchPage;

public class SearchSteps extends DriverFactory {

    @When("user search all DHB for non existing NHI number and click searchAllDHB button")
    public void userSearchAllDHBForNonExistingNHINumber() {
        _SearchPage.enterNHINumber();
    }

//    @Then("error message for NHI number us displayed")
//    public void errorMessageForNHINumberUsDisplayed() {
//        _SearchPage.verifyErrorMessage();
//    }





//    @When("user search with firstname and surname")
//    public void userSearchWithFirstnameAndSurname() {
//        _SearchPage.enterFirstNameAndLastNameToSearch();
//        System.out.println("Entering First and Surname");
//
//    }

    @And("user search all DHB for search results")
    public void userSearchAllDHBForSearchResults() {
    _SearchPage.clickAllDHBButton();

    }

    @And("click assign provider link")
    public void clickAssignProviderLink() {
        _SearchPage.clickAssignProviderLink();
    }

    @And("click Management tab")
    public void clickManagementTab() {
    _SearchPage.enterManagementTab();
    }

    @And("search with the NHI Number obtained")
    public void searchWithTheNHINumberObtained() {
        _SearchPage.searchWithNHINumber();
    }

    @And("click surName link")
    public void clickSurNameLink() {
        _SearchPage.surNameLinkClick();
    }

    @Then("user click search button and confirm the child record is returned to coordinator successfully")
    public void userClickSearchButtonAndConfirmTheChildRecordIsReturnedToCoordinatorSuccessfully() {
        _SearchPage.clickSearchButtonandConfirmChildReturnedtoCoordinator();
    }
}
