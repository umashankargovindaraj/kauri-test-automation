package pageObjects.Automation105;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ConfirmationPage105 extends BasePage {

    private @FindBy(xpath = "//div[@data-test-id='2019042917302608989464']//label[text()='Yes']")
    WebElement buttonSurveyYes = null;
    private @FindBy(xpath = "//div[@data-test-id='2019042917302608989464']//label[text()='No']")
    WebElement buttonSurveyNo = null;
    private @FindBy(xpath = "//div[@data-test-id='201909302044030509970']//div//strong")
    WebElement labelReferenceNumber = null;


    public String getReferenceNumber() {
        return waitandGetText(labelReferenceNumber);
    }

    public void surveyChoice(String choice) {
        if (choice.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(buttonSurveyYes);
        } else {
            waitAndclickElementUsingJS(buttonSurveyNo);
        }
    }

    public List<Map<String, String>> getCucumberDataAsList(DataTable dataTable) {
        return getCucumberDataTableAsList(dataTable);
    }

    public String getJSONOutputPayloadFromPegaAPI(String refNumber) throws InterruptedException {
        return retrieveJSONOutputDataFromPegaAPI(refNumber);
    }

    public void verifyReportDataInPegaCaseInfo(Object pegajsonPayload){
        String expectedTestData = null;
        String pegaApiXPath = null;
        String pegaCaseAPIActualData = null;
        for(Map.Entry<String, String> entry:_retrieveTestData.extractPegaAPIDataXPath().entrySet()){
            try{
                pegaApiXPath = _retrieveTestData.extractPegaDataXpath(entry.getKey());
            }catch (Exception e){
                System.out.println("Exception in retrieving Case API Data Xpath --> " + entry.getKey());
                Assert.fail("Exception in retrieving Case API Data Xpath --> " + entry.getKey());
            }
            if(!pegaApiXPath.equalsIgnoreCase("skip")) {
                expectedTestData = entry.getValue();
                try {
                    pegaCaseAPIActualData = JsonPath.parse(pegajsonPayload).read(pegaApiXPath).toString();
                } catch (Exception e) {
                    Assert.fail("Failed to retrieve Case Data from Pega API for xpath --> " + pegaApiXPath + " or unable to retrieve Case Data");
                    System.out.println("Failed to retrieve Case Data from Pega API for xpath --> " + pegaApiXPath + " or unable to retrieve Case Data");
                }
//                if (!(pegaCaseAPIActualData.toLowerCase().contains(expectedTestData.toLowerCase()))) {
                if (!(pegaCaseAPIActualData.toLowerCase().equalsIgnoreCase(expectedTestData.toLowerCase()))) {
                    System.out.println("Verification failed for with pega case info with expected value as " + expectedTestData.toLowerCase() +
                            " and actual value is " + pegaCaseAPIActualData.toLowerCase());
                    Assert.fail("Verification failed for with pega case info with expected value as " + expectedTestData.toLowerCase() +
                            " and actual value is " + pegaCaseAPIActualData.toLowerCase());
                }
            }
        }
    }


}
