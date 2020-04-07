package pageObjects.Automation105;

import io.cucumber.datatable.DataTable;
import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class OrganisationOwnerDetails105 extends BasePage {

    private @FindBy(xpath = "//table[contains(@pl_prop_class, 'Police-Data-NIA-MasterLocation')]//tr[contains(@oaargs,'Police-Data-NIA-MasterLocation')]")
    List<WebElement> addressAutoCompleteList = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> addressAutoCompleteListMobile = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='2019031415200802003627']")
    List<WebElement> textBoxOrganisationOwnerAddress = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='20190412132543093548630']")
    List<WebElement> checkBoxOrganisationOwnerManualAddress = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//div[@data-test-id='20190827120614093039571']//label[text()='New Zealand']")
    List<WebElement> tabOrganisationOwnerManualAddressNewZealand = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//div[@data-test-id='20190827120614093039571']//label[text()='International']")
    List<WebElement> tabOrganisationOwnerManualAddressInternational = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'Police-Data-NIA-Reference') and contains(@oaargs,'UnitType')]")
    List<WebElement> unitTypeAutoCompleteList = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs,'StreetType')]")
    List<WebElement> streetTypeAutoCompleteList = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500376683985']")
    List<WebElement> textBoxOrganisationOwnerAddressUnitType = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500377684750']")
    List<WebElement> textBoxOrganisationOwnerAddressUnitNumber = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500378687291']")
    List<WebElement> textBoxOrganisationOwnerAddressStreetNumber = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500379688406']")
    List<WebElement> textBoxOrganisationOwnerAddressStreetName = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500380689446' and contains(@name, 'StreetType')]")
    List<WebElement> textBoxOrganisationOwnerAddressStreetType = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111522500380689446' and contains(@name, 'StreetDirection')]")
    List<WebElement> textBoxOrganisationOwnerAddressStreetDirection = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs,'StreetDirection')]")
    List<WebElement> streetDirectionAutoCompleteList = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='201904111527000430464605']")
    List<WebElement> textBoxOrganisationOwnerAddressTownSuburb = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//input[@data-test-id='20190726160046054615911']")
    List<WebElement> textBoxOrganisationOwnerAddressTownSuburbInternational = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'TownSuburb')]")
    List<WebElement> townSuburbAutoCompleteList = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//select[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDowwInternationalAddressCountry = null;



    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//select[@data-test-id='20190411125517041712957']")
    List<WebElement> dropDownOrganisationOwnerPhoneType = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//select[@data-test-id='20191127095351032818541']")
    List<WebElement> dropDownOrganisationOwnerPhoneTypeCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='20191127101604009732639']")
    List<WebElement> textBoxOrganisationOwnerPhoneNumberArea = null;
    private @FindBy(xpath = "//div[@data-test-id='201905091206250186440']//input[@data-test-id='20191127101954039317217']")
    List<WebElement> textBoxOrganisationOwnerPhoneNumber = null;
    private @FindBy(xpath = "//div[@data-node-id='OrganizationDoes']//div[@data-test-id='201905091206250186440']//div[@data-test-id='201904111102500743434']")
    List<WebElement> organisationOwnerNameHeaderInReporterPage = null;


    public void keyInOrganisationAddress(int index) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxOrganisationOwnerAddress.get(0), addressAutoCompleteListMobile, _generateTestData.generateValidData("organisationDetails.address1"), true);
        } else {
            selectLookupValue(textBoxOrganisationOwnerAddress.get(0), addressAutoCompleteList, _retrieveTestData.extractDataOffDataFile("organisationDetails.address1"), true);
        }

    }


    public void verifyOrganisationDetailsandKeyInDetails(List<Map<String, String>> listOrganisationOwnerObjectDataTable, boolean isAddressManualEntry) {
        for (int i = 0; i < listOrganisationOwnerObjectDataTable.size(); i++) {
            int elementInApplicationIndex = 0;
            String organisationOwnerObjectRoot = listOrganisationOwnerObjectDataTable.get(i).get("organisationOwnerDataSet");
            String organisationManualAddressObjectRoot = listOrganisationOwnerObjectDataTable.get(i).get("manualAddressDataSet");
            String internationAddressIndicator = listOrganisationOwnerObjectDataTable.get(i).get("isInternationalAddress");
            String organisationOwnerName = _retrieveTestData.extractDataOffDataFile(organisationOwnerObjectRoot + ".owner.organisationName");
            List<WebElement> ownerDetailsPrepopulatedList = _organisationOwnerDetails105.getTextOfOrganisationOwnerNameHeaderInReporterPage();

            boolean found = false;
            int organisationOwnerManualAddressFieldsIndex = 0;
            for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
                String actualOrganisationNameIndicatorInApplication = ownerFirstNameElement.getText();
                String expectedOrganisationNameIndicatorKeyedInReporterPage = "Please provide " + organisationOwnerName + "'s details";

                if (actualOrganisationNameIndicatorInApplication.equalsIgnoreCase(expectedOrganisationNameIndicatorKeyedInReporterPage)) {
                    found = true;
                    keyInOrganisationOwnerPhoneDetails(elementInApplicationIndex, organisationOwnerObjectRoot);
                    if (isAddressManualEntry) {
                        clickOnCheckBoxOrganisationOwnerManualAddress(elementInApplicationIndex);
                        keyInManualNZAddressDetailsOrganisationOwner(organisationOwnerManualAddressFieldsIndex, organisationManualAddressObjectRoot,internationAddressIndicator);
                    } else {
                        keyInOrganisationOwnerAddressFromLookUp(elementInApplicationIndex, organisationOwnerObjectRoot);
                    }
                    organisationOwnerManualAddressFieldsIndex++;
                    break;
                }
                elementInApplicationIndex++;
            }
            if (!found) {
                Assert.fail("Owner section for Owner : " + organisationOwnerName + " does not exist");
            }
        }
    }

    private void clickOnCheckBoxOrganisationOwnerManualAddress(int elementInApplicationIndex) {
        waitAndclickElementUsingJS(checkBoxOrganisationOwnerManualAddress.get(elementInApplicationIndex));
    }

    private void keyInOrganisationOwnerAddressFromLookUp(int elementInApplicationIndex, String organisationOwnerObjectRoot) {
        selectLookupValue(textBoxOrganisationOwnerAddress.get(elementInApplicationIndex), addressAutoCompleteList, _retrieveTestData.extractDataOffDataFile(organisationOwnerObjectRoot + ".owner.address"), true);
    }

    private void keyInManualNZAddressDetailsOrganisationOwner(int elementInApplicationIndex, String organisationManualAddressObjectRoot, String internationalAddressIndicator) {
        if(internationalAddressIndicator.equalsIgnoreCase("yes")){
            waitAndclickElementUsingJS(tabOrganisationOwnerManualAddressInternational.get(elementInApplicationIndex));
        }
        try {
            String addressUnitTypeXpath = organisationManualAddressObjectRoot + ".owner.manualAddress.unitType";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitTypeXpath, false);
            if (!(testData == null)) {
                selectLookupValue(textBoxOrganisationOwnerAddressUnitType.get(elementInApplicationIndex), unitTypeAutoCompleteList, testData, false);
            } else {
                System.out.println("Unit Type field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Unit Type field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressUnitNumberXpath = organisationManualAddressObjectRoot + ".owner.manualAddress.unitNumber";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitNumberXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxOrganisationOwnerAddressUnitNumber.get(elementInApplicationIndex), testData);
            } else {
                System.out.println("Unit Number field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Unit Number field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetNumberXpath = organisationManualAddressObjectRoot + ".owner.manualAddress.streetNumber";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetNumberXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxOrganisationOwnerAddressStreetNumber.get(elementInApplicationIndex), testData);
            } else {
                System.out.println("Street Number field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Number field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetNameXpath = organisationManualAddressObjectRoot + ".owner.manualAddress.streetName";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetNameXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxOrganisationOwnerAddressStreetName.get(elementInApplicationIndex), testData);
            } else {
                System.out.println("Street Name field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Name field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetTypeXpath = organisationManualAddressObjectRoot + ".owner.manualAddress.streetType";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetTypeXpath, false);
            if (!(testData == null)) {
                selectLookupValue(textBoxOrganisationOwnerAddressStreetType.get(elementInApplicationIndex), streetTypeAutoCompleteList, testData, false);
            } else {
                System.out.println("Street Type field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Street Type field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetDirectionXpath = organisationManualAddressObjectRoot + ".owner.manualAddress.streetDirection";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetDirectionXpath, false);
            if (!(testData == null)) {
                selectLookupValue(textBoxOrganisationOwnerAddressStreetDirection.get(elementInApplicationIndex), streetDirectionAutoCompleteList, testData, false);
            } else {
                System.out.println("Street Direction field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Direction field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressTownSuburbXpath = organisationManualAddressObjectRoot + ".owner.manualAddress.townSuburb";
            String testData = _retrieveTestData.extractDataOffDataFile(addressTownSuburbXpath, false);
            if (!(testData == null)) {
                if(internationalAddressIndicator.equalsIgnoreCase("yes")){
                    sendKeysToWebElement(textBoxOrganisationOwnerAddressTownSuburbInternational.get(elementInApplicationIndex),testData);
                    selectInternationalCountry(elementInApplicationIndex,organisationManualAddressObjectRoot);
                }else{
                    selectLookupValue(textBoxOrganisationOwnerAddressTownSuburb.get(elementInApplicationIndex), townSuburbAutoCompleteList, testData, false);
                }
            } else {
                System.out.println("Town Suburb field not mentioned in the data file ");
                Assert.fail("Town/Suburb xpath reference is not mentioned in cucumber feature file. That's a mandatory field");
            }
        } catch (Exception e) {
            System.out.println("Town Suburb field not mentioned in the data file ");
            Assert.fail("Town/Suburb xpath reference is not mentioned in cucumber feature file. That's a mandatory field");
        }

    }

    private void selectInternationalCountry(int index, String organisationManualAddressObjectRoot){
        try {
            String addressUnitTypeXpath = organisationManualAddressObjectRoot + ".owner.manualAddress.Country";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitTypeXpath, false);
            if (!(testData == null)) {
                selectFromDropDownbyValue(dropDowwInternationalAddressCountry.get(index), testData);
            } else {
                System.out.println("Country field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Country field not mentioned in the data file and hence will not be keyed in ");
        }
    }

    public void keyInOrganisationOwnerPhoneDetails(int elementInApplicationIndex, String damagedOrganisationOwnerObjectRoot) {
        selectOrganisationOwnerPhoneType(elementInApplicationIndex, damagedOrganisationOwnerObjectRoot);
        selectOrganisationOwnerCountry(elementInApplicationIndex, damagedOrganisationOwnerObjectRoot);
        keyInOrganisationOwnerTypeArea(elementInApplicationIndex, damagedOrganisationOwnerObjectRoot);
        keyInOrganisationOwnerPhoneNumber(elementInApplicationIndex, damagedOrganisationOwnerObjectRoot);
    }

    public void keyInOrganisationContactDetails(int index) {
        selectOrganisationOwnerPhoneType(index);
        keyInOrganisationOwnerPhoneNumber(index);
    }

    private void selectOrganisationOwnerPhoneType(int elementInApplicationIndex, String damagedOrganisationOwnerObjectRoot) {
        selectFromDropDownbyValue(dropDownOrganisationOwnerPhoneType.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(damagedOrganisationOwnerObjectRoot + ".owner.phoneType"));
    }

    private void selectOrganisationOwnerCountry(int elementInApplicationIndex, String damagedOrganisationOwnerObject) {
        selectFromDropDownbyValue(dropDownOrganisationOwnerPhoneTypeCountry.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(damagedOrganisationOwnerObject + ".owner.country"));
    }

    private void keyInOrganisationOwnerTypeArea(int elementInApplicationIndex, String damagedOrganisationOwnerObject) {
        sendKeysToWebElement(textBoxOrganisationOwnerPhoneNumberArea.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(damagedOrganisationOwnerObject + ".owner.area"));
    }

    private void keyInOrganisationOwnerPhoneNumber(int elementInApplicationIndex, String damagedOrganisationOwnerOBject) {
        sendKeysToWebElement(textBoxOrganisationOwnerPhoneNumber.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(damagedOrganisationOwnerOBject + ".owner.number"));
    }

    private void keyInOrganisationOwnerUnitType(int elementApplicationIndex, String organisationOwnerObjectRoot) {

    }

    private void selectOrganisationOwnerPhoneType(int index) {
        selectFromDropDownbyValue(dropDownOrganisationOwnerPhoneType.get(index), _retrieveTestData.extractDataOffDataFile("organisationDetails.phoneType"));
    }

    private void keyInOrganisationOwnerPhoneNumber(int index) {
        selectOrganisationOwnerPhoneCountry(index);
        keyInOrganisationOwnerPhoneTypeArea(index);
        sendKeysToWebElement(textBoxOrganisationOwnerPhoneNumber.get(index), _retrieveTestData.extractDataOffDataFile("organisationDetails.phoneNumber"));
    }

    private void selectOrganisationOwnerPhoneCountry(int index) {
        selectFromDropDownbyValue(dropDownOrganisationOwnerPhoneTypeCountry.get(index), _retrieveTestData.extractDataOffDataFile("organisationDetails.countryCode"));
    }

    private void keyInOrganisationOwnerPhoneTypeArea(int index) {
        sendKeysToWebElement(textBoxOrganisationOwnerPhoneNumberArea.get(index), _retrieveTestData.extractDataOffDataFile("organisationDetails.area"));
    }

    public List<WebElement> getTextOfOrganisationOwnerNameHeaderInReporterPage() {
        return organisationOwnerNameHeaderInReporterPage;
    }

    public List<Map<String, String>> getCucumberDataAsList(DataTable dataTable) {
        return getCucumberDataTableAsList(dataTable);
    }
}
