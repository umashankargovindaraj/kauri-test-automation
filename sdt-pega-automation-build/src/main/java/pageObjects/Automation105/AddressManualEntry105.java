package pageObjects.Automation105;

import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class AddressManualEntry105 extends BasePage {

    private @FindBy(xpath = "//input[@data-test-id='201904111522500376683985']")
    WebElement dropDownunitType = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'Police-Data-NIA-Reference') and contains(@oaargs,'UnitType')]")
    List<WebElement> unitTypeAutoCompleteList = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500377684750']")
    WebElement textBoxunitNumber = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500378687291']")
    WebElement textBoxstreetNumber = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500379688406']")
    WebElement textBoxstreetName = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500380689446' and contains(@name,'StreetType')]")
    WebElement textBoxstreetType = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs,'StreetType')]")
    List<WebElement> streetTypeAutoCompleteList = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111522500380689446' and contains(@name,'StreetDirection')]")
    WebElement textBoxStreetDirection = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs,'StreetDirection')]")
    List<WebElement> streetDirectionAutoCompleteList = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'TownSuburb')]")
    List<WebElement> townSuburbAutoCompleteList = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> townSuburbAutoCompleteListMobile = null;
    private @FindBy(xpath = "//input[@data-test-id='201904111527000430464605']")
    WebElement textBoxtownSuburb = null;

    public void keyInLocationAddressManually(List<Map<String, String>> manualAddressFields) {

        String manualAddressXpath = manualAddressFields.get(0).get("manualAddress");
        try {
            String addressUnitTypeXpath = manualAddressXpath + ".unitType";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitTypeXpath, false);
            if (!(testData == null)) {
                selectLookupValue(dropDownunitType, unitTypeAutoCompleteList, testData, false);
            } else {
                System.out.println("Unit Type field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Unit Type field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressUnitNumberXpath = manualAddressXpath + ".unitNumber";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitNumberXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxunitNumber, testData);
            } else {
                System.out.println("Unit Number field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Unit Number field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetNumberXpath = manualAddressXpath + ".streetNumber";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetNumberXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxstreetNumber, testData);
            } else {
                System.out.println("Street Number field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Number field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetNameXpath = manualAddressXpath + ".streetName";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetNameXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxstreetName, testData);
            } else {
                System.out.println("Street Name field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Name field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetTypeXpath = manualAddressXpath + ".streetType";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetTypeXpath, false);
            if (!(testData == null)) {
                selectLookupValue(textBoxstreetType, streetTypeAutoCompleteList, testData, false);
            } else {
                System.out.println("Street Type field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Street Type field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetDirectionXpath = manualAddressXpath + ".streetDirection";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetDirectionXpath, false);
            if (!(testData == null)) {
                selectLookupValue(textBoxStreetDirection, streetDirectionAutoCompleteList, testData, false);
            } else {
                System.out.println("Street Direction field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Direction field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressTownSuburbXpath = manualAddressXpath + ".townSuburb";
            String testData = _retrieveTestData.extractDataOffDataFile(addressTownSuburbXpath, false);
            if (!(testData == null)) {
                selectLookupValue(textBoxtownSuburb, townSuburbAutoCompleteList, testData, false);
            } else {
                System.out.println("Town Suburb field not mentioned in the data file ");
                Assert.fail("Town/Suburb xpath reference is not mentioned in cucumber feature file. That's a mandatory field");
            }
        } catch (Exception e) {
            System.out.println("Town Suburb field not mentioned in the data file ");
            Assert.fail("Town/Suburb xpath reference is not mentioned in cucumber feature file. That's a mandatory field");
        }

    }
}
