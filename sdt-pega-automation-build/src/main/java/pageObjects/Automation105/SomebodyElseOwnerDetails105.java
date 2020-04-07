package pageObjects.Automation105;

import io.cucumber.datatable.DataTable;
import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class SomebodyElseOwnerDetails105 extends BasePage {

    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[@data-test-id='20191001163651019767140']")
    List<WebElement> someOneElseDoesTextBoxOwnerAgeOrDOB = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//select[@data-test-id='20190411110011006313687']")
    List<WebElement> dropDownSomeOneElseDoesOwnerGender = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[@data-test-id='2019050216083907625630']")
    List<WebElement> someOneElseDoesTextBoxOwnerEmailAddress = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//select[@data-test-id='20190411125517041712957']")
    List<WebElement> dropDownSomeOneElseOwnerPhoneType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//select[@data-test-id='20190919120043051589619']")
    List<WebElement> dropDownSomeOneElseOwnerAddressType = null;
    private @FindBy(xpath = "//table[contains(@pl_prop_class, 'Police-Data-NIA-MasterLocation')]//tr[contains(@oaargs,'Police-Data-NIA-MasterLocation')]")
    List<WebElement> addressAutoCompleteList = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> addressAutoCompleteListMobile = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201904111102500743434']//input[@data-test-id='2019031415200802003627']")
    List<WebElement> someOneElseDoesTextBoxOwnerAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//div[@data-test-id='20190418114941075437388']//input[@value='Yes']")
    List<WebElement> toggleSomeOneElseOwnerVictimSupportYes = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//div[@data-test-id='20190418114941075437388']//input[@value='No']")
    List<WebElement> toggleSomeOneElseOwnerVictimSupportNo = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//select[@data-test-id='2019052812011802847278']")
    List<WebElement> dropDownRelationToTheOwner = null;

    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//select[@data-test-id='20190411125517041712957']")
    List<WebElement> dropDownSomebodyElseOwnerPhoneType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//select[@data-test-id='20191127095351032818541']")
    List<WebElement> dropDownSomebodyElseOwnerPhoneTypeCountry = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='20191127101604009732639']")
    List<WebElement> textBoxSomebodyElseOwnerPhoneNumberArea = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='20191127101954039317217']")
    List<WebElement> textBoxSomebodyElseOwnerPhoneNumber = null;

    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='20190412132543093548630']")
    List<WebElement> checkBoxSomebodyElseOwnerManualAddress = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//label[contains(@for,'International')]")
    List<WebElement> internationalAddressLabel = null;


    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='201904111522500376683985']")
    List<WebElement> textBoxSomebodyElseOwnerAddressUnitType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='201904111522500377684750']")
    List<WebElement> textBoxSomebodyElseOwnerAddressUnitNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='201904111522500378687291']")
    List<WebElement> textBoxSomebodyElseOwnerAddressStreetNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='201904111522500379688406']")
    List<WebElement> textBoxSomebodyElseOwnerAddressStreetName = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='201904111522500380689446' and contains(@name, 'StreetType')]")
    List<WebElement> textBoxSomebodyElseOwnerAddressStreetType = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='201904111522500380689446' and contains(@name, 'StreetDirection')]")
    List<WebElement> textBoxSomebodyElseOwnerAddressStreetDirection = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs,'StreetDirection')]")
    List<WebElement> streetDirectionAutoCompleteList = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs,'StreetType')]")
    List<WebElement> streetTypeAutoCompleteList = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='201904111527000430464605']")
    List<WebElement> textBoxSomebodyElseOwnerAddressTownSuburb = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='20190726160046054615911']")
    List<WebElement> textBoxSomebodyElseOwnerAddressTownSuburbInternational = null;

    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'TownSuburb')]")
    List<WebElement> townSuburbAutoCompleteList = null;
    private @FindBy(xpath = "//table[@pl_prop_class='Police-Data-NIA-Reference' and contains(@grid_ref_page, 'FreeFormAddress')]//tr[contains(@oaargs, 'Police-Data-NIA-Reference') and contains(@oaargs,'UnitType')]")
    List<WebElement> unitTypeAutoCompleteList = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//input[@data-test-id='2019031415200802003627']")
    List<WebElement> textBoxSomebodyElseOwnerAddress = null;
    private @FindBy(xpath = "//div[@data-node-id='SomebodyElse']//div[@data-test-id='201905161234560753348']//div[@data-test-id='20190528113323020052300']")
    List<WebElement> somebodyElseOwnerNameHeaderInReporterPage = null;
    private @FindBy(xpath = "//div[@data-test-id='201904111102500743434']//select[@data-test-id='201904111527000431465607']")
    List<WebElement> dropDownInternationalAddressCountry = null;


    public void keyInAgeOfOwnerSomeOneElse(int index) {
        sendKeysToWebElement(someOneElseDoesTextBoxOwnerAgeOrDOB.get(index), _retrieveTestData.extractDataOffDataFile("ownerDetails.ownerAge"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectInGenderOfOwnerSomeOneElse(int index) {
        selectFromDropDownbyValue(dropDownSomeOneElseDoesOwnerGender.get(index), _retrieveTestData.extractDataOffDataFile("ownerDetails.gender"));
    }

    public void selectAddressTypeSomeOneElseOwner(int index) {
        selectFromDropDownbyValue(dropDownSomeOneElseOwnerAddressType.get(index), _retrieveTestData.extractDataOffDataFile("ownerDetails.addressType"));
    }

    public void keyInEmailAddressOfOwnerSomeOneElse(int index) {
        sendKeysToWebElement(someOneElseDoesTextBoxOwnerEmailAddress.get(index), _retrieveTestData.extractDataOffDataFile("ownerDetails.emailAddress"));
    }

    public void selectPhoneTypeOfOwnerOwnerSomeOneElse(int index) {
        selectFromDropDownbyValue(dropDownSomeOneElseOwnerPhoneType.get(index), _retrieveTestData.extractDataOffDataFile("ownerDetails.phoneType"));
    }

    public void keyInPhoneNumberOfOwnerSomeOneElse(int index) {
        selectSomebodyElseOwnerPhoneCountry(index);
        keyInSomebodyElseOwnerPhoneTypeArea(index);
        keyInSomebodyElseOwnerPhoneNumber(index);
    }

    private void selectSomebodyElseOwnerPhoneCountry(int index) {
        selectFromDropDownbyValue(dropDownSomebodyElseOwnerPhoneTypeCountry.get(index), _retrieveTestData.extractDataOffDataFile("ownerDetails.countryCode"));
    }

    private void keyInSomebodyElseOwnerPhoneTypeArea(int index) {
        sendKeysToWebElement(textBoxSomebodyElseOwnerPhoneNumberArea.get(index), _retrieveTestData.extractDataOffDataFile("ownerDetails.area"));
    }

    private void keyInSomebodyElseOwnerPhoneNumber(int index) {
        sendKeysToWebElement(textBoxSomebodyElseOwnerPhoneNumber.get(index), _retrieveTestData.extractDataOffDataFile("ownerDetails.phoneNumber"));
    }

    public void keyInAddressOfOwnerSomeOneElse(int index) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            addressAutoCompleteListMobile = addressAutoCompleteList;
        }
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(someOneElseDoesTextBoxOwnerAddress.get(index), addressAutoCompleteListMobile, _retrieveTestData.extractDataOffDataFile("ownerDetails.address"), true);
        } else {
            selectLookupValue(someOneElseDoesTextBoxOwnerAddress.get(index), addressAutoCompleteList, _retrieveTestData.extractDataOffDataFile("ownerDetails.address"), true);
        }
    }

    public void selectSomeElseOwnerVictimSupportFlag(String flag, int index) {
        if (flag.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleSomeOneElseOwnerVictimSupportYes.get(index));
        } else if (flag.equalsIgnoreCase("no")) {
            waitAndclickElementUsingJS(toggleSomeOneElseOwnerVictimSupportNo.get(index));
        }
    }

    public void selectRelationsShipOfOwnerSomeOneElse(int index) {
        selectFromDropDownbyValue(dropDownRelationToTheOwner.get(index), _retrieveTestData.extractDataOffDataFile("ownerDetails.relationshipToReporter"));
    }

    public List<Map<String, String>> getCucumberDataAsList(DataTable dataTable) {
        return getCucumberDataTableAsList(dataTable);
    }

    public void verifySomebodyElseOwnerDetailsandKeyInDetails(List<Map<String, String>> listSomebodyElseOwnerObjectDataTable, boolean isAddressManualEntry) {
        for (int i = 0; i < listSomebodyElseOwnerObjectDataTable.size(); i++) {
            int elementInApplicationIndex = 0;
            String somebodyElseOwnerObjectRoot = listSomebodyElseOwnerObjectDataTable.get(i).get("somebodyElseOwnerDataSet");
            String somebodyElseManualAddressObjectRoot = listSomebodyElseOwnerObjectDataTable.get(i).get("manualAddressDataSet");
            String somebodyElseInternationalAddressIndicator = listSomebodyElseOwnerObjectDataTable.get(i).get("isInternationalAddress");
            String somebodyElseOwnerFirstName = _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObjectRoot + ".owner.firstName");
            List<WebElement> ownerDetailsPrepopulatedList = _somebodyElseOwnerDetails105.getTextOfSomebodyElseOwnerNameHeaderInReporterPage();

            boolean found = false;
            int somebodyElseOwnerManualAddressFieldsIndex = 0;
            for (WebElement ownerFirstNameElement : ownerDetailsPrepopulatedList) {
                String actualFirstnameIndicatorInApplication = ownerFirstNameElement.getText();
                String expectedFirstNameIndicatorKeyedInReporterPage = "Please provide " + somebodyElseOwnerFirstName + "'s details";
                if (actualFirstnameIndicatorInApplication.equalsIgnoreCase(expectedFirstNameIndicatorKeyedInReporterPage)) {
                    found = true;
                    keyInSomebodyElseOwnerPhoneDetails(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
                    keyInSomebodyElseOwnerAgeGenderRelationShipAndVictimSupportAddressType(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
                    if (isAddressManualEntry) {
                        clickOnCheckBoxSomebodyElseOwnerManualAddress(elementInApplicationIndex);
                        keyInManualNZAddressDetailsSomebodyElseOwner(somebodyElseOwnerManualAddressFieldsIndex, somebodyElseManualAddressObjectRoot, somebodyElseInternationalAddressIndicator);
                    } else {
                        keyInSomebodyElseOwnerAddressFromLookUp(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
                    }
                    somebodyElseOwnerManualAddressFieldsIndex++;
                    break;
                }
                elementInApplicationIndex++;
            }
            if (!found) {
                Assert.fail("Owner section for Owner : " + somebodyElseOwnerFirstName + " does not exist");
            }
        }
    }

    public void keyInSomebodyElseOwnerAgeGenderRelationShipAndVictimSupportAddressType(int elementInApplicationIndex, String somebodyElseOwnerObjectRoot) {
        selectSomebodyElseOwnerRelationToOwner(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
        String eventTypeIndicator = (String) _persistentData.getContext("eventType");
        if (!eventTypeIndicator.equalsIgnoreCase("lost")) {
            clickOnVictimSupportFlag(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
        }
        selectSomebodyElseOwnerGender(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
        selectSomebodyElseOwnerAddressType(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
        keyInSomebodyElseOwnerAgeOrDateOfBirth(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
    }

    public void selectSomebodyElseOwnerAddressType(int elementInApplicationIndex, String somebodyElseOwnerObjectRoot) {
        selectFromDropDownbyValue(dropDownSomeOneElseOwnerAddressType.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObjectRoot + ".owner.addressType"));
    }

    public void selectSomebodyElseOwnerGender(int elementInApplicationIndex, String somebodyElseOwnerObjectRoot) {
        selectFromDropDownbyValue(dropDownSomeOneElseDoesOwnerGender.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObjectRoot + ".owner.gender"));
    }

    public void keyInSomebodyElseOwnerAgeOrDateOfBirth(int elementInApplicationIndex, String somebodyElseOwnerObjectRoot) {
        sendKeysToWebElement(someOneElseDoesTextBoxOwnerAgeOrDOB.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObjectRoot + ".owner.age"));
    }

    public void selectSomebodyElseOwnerRelationToOwner(int elementInApplicationIndex, String somebodyElseOwnerObjectRoot) {
        selectFromDropDownbyValue(dropDownRelationToTheOwner.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObjectRoot + ".owner.howAreTheyRelated"));
    }


    public void clickOnVictimSupportFlag(int elementInApplicationIndex, String somebodyElseOwnerObjectRoot) {
        String flag = _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObjectRoot + ".owner.victimSupportFlag");

        if (flag.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleSomeOneElseOwnerVictimSupportYes.get(elementInApplicationIndex));
        } else if (flag.equalsIgnoreCase("no")) {
            waitAndclickElementUsingJS(toggleSomeOneElseOwnerVictimSupportNo.get(elementInApplicationIndex));
        }
    }

    public void keyInSomebodyElseOwnerPhoneDetails(int elementInApplicationIndex, String somebodyElseOwnerObjectRoot) {
        selectSomebodyElseOwnerPhoneType(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
        selectSomebodyElseOwnerCountry(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
        keyInSomebodyElseOwnerTypeArea(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
        keyInSomebodyElseOwnerPhoneNumber(elementInApplicationIndex, somebodyElseOwnerObjectRoot);
    }

    private void selectSomebodyElseOwnerPhoneType(int elementInApplicationIndex, String somebodyElseOwnerObjectRoot) {
        selectFromDropDownbyValue(dropDownSomebodyElseOwnerPhoneType.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObjectRoot + ".owner.phoneType"));
    }

    private void selectSomebodyElseOwnerCountry(int elementInApplicationIndex, String somebodyElseOwnerObject) {
        selectFromDropDownbyValue(dropDownSomebodyElseOwnerPhoneTypeCountry.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObject + ".owner.country"));
    }

    private void keyInSomebodyElseOwnerTypeArea(int elementInApplicationIndex, String somebodyElseOwnerObject) {
        sendKeysToWebElement(textBoxSomebodyElseOwnerPhoneNumberArea.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObject + ".owner.area"));
    }

    private void keyInSomebodyElseOwnerPhoneNumber(int elementInApplicationIndex, String somebodyElseOwnerOBject) {
        sendKeysToWebElement(textBoxSomebodyElseOwnerPhoneNumber.get(elementInApplicationIndex), _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerOBject + ".owner.number"));
    }

    private void clickOnCheckBoxSomebodyElseOwnerManualAddress(int elementInApplicationIndex) {
        waitAndclickElementUsingJS(checkBoxSomebodyElseOwnerManualAddress.get(elementInApplicationIndex));
    }

    private void keyInManualNZAddressDetailsSomebodyElseOwner(int elementInApplicationIndex, String somebodyElseManualAddressObjectRoot, String internationalAddressIndicator) {
        if (internationalAddressIndicator.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(internationalAddressLabel.get(elementInApplicationIndex));
        }

        try {
            String addressUnitTypeXpath = somebodyElseManualAddressObjectRoot + ".owner.manualAddress.unitType";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitTypeXpath, false);
            if (!(testData == null)) {
                selectLookupValue(textBoxSomebodyElseOwnerAddressUnitType.get(elementInApplicationIndex), unitTypeAutoCompleteList, testData, false);
            } else {
                System.out.println("Unit Type field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Unit Type field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressUnitNumberXpath = somebodyElseManualAddressObjectRoot + ".owner.manualAddress.unitNumber";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitNumberXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxSomebodyElseOwnerAddressUnitNumber.get(elementInApplicationIndex), testData);
            } else {
                System.out.println("Unit Number field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Unit Number field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetNumberXpath = somebodyElseManualAddressObjectRoot + ".owner.manualAddress.streetNumber";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetNumberXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxSomebodyElseOwnerAddressStreetNumber.get(elementInApplicationIndex), testData);
            } else {
                System.out.println("Street Number field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Number field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetNameXpath = somebodyElseManualAddressObjectRoot + ".owner.manualAddress.streetName";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetNameXpath, false);
            if (!(testData == null)) {
                sendKeysToWebElement(textBoxSomebodyElseOwnerAddressStreetName.get(elementInApplicationIndex), testData);
            } else {
                System.out.println("Street Name field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Name field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetTypeXpath = somebodyElseManualAddressObjectRoot + ".owner.manualAddress.streetType";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetTypeXpath, false);
            if (!(testData == null)) {
                selectLookupValue(textBoxSomebodyElseOwnerAddressStreetType.get(elementInApplicationIndex), streetTypeAutoCompleteList, testData, false);
            } else {
                System.out.println("Street Type field not mentioned in the data file and hence will not be keyed in ");
            }

        } catch (Exception e) {
            System.out.println("Street Type field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressStreetDirectionXpath = somebodyElseManualAddressObjectRoot + ".owner.manualAddress.streetDirection";
            String testData = _retrieveTestData.extractDataOffDataFile(addressStreetDirectionXpath, false);
            if (!(testData == null)) {
                selectLookupValue(textBoxSomebodyElseOwnerAddressStreetDirection.get(elementInApplicationIndex), streetDirectionAutoCompleteList, testData, false);
            } else {
                System.out.println("Street Direction field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Street Direction field not mentioned in the data file and hence will not be keyed in ");
        }

        try {
            String addressTownSuburbXpath = somebodyElseManualAddressObjectRoot + ".owner.manualAddress.townSuburb";
            String testData = _retrieveTestData.extractDataOffDataFile(addressTownSuburbXpath, false);
            if (!(testData == null)) {
                if (internationalAddressIndicator.equalsIgnoreCase("yes")) {
                    sendKeysToWebElement(textBoxSomebodyElseOwnerAddressTownSuburbInternational.get(elementInApplicationIndex), testData);
                    selectInternationalCountry(elementInApplicationIndex, somebodyElseManualAddressObjectRoot);
                } else {
                    selectLookupValue(textBoxSomebodyElseOwnerAddressTownSuburb.get(elementInApplicationIndex), townSuburbAutoCompleteList, testData, false);
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

    private void selectInternationalCountry(int index, String somebodyElseManualAddressObjectRoot) {
        try {
            String addressUnitTypeXpath = somebodyElseManualAddressObjectRoot + ".owner.manualAddress.Country";
            String testData = _retrieveTestData.extractDataOffDataFile(addressUnitTypeXpath, false);
            if (!(testData == null)) {
                selectFromDropDownbyValue(dropDownInternationalAddressCountry.get(index), testData);
            } else {
                System.out.println("Country field not mentioned in the data file and hence will not be keyed in ");
            }
        } catch (Exception e) {
            System.out.println("Country field not mentioned in the data file and hence will not be keyed in ");
        }
    }

    private void keyInSomebodyElseOwnerAddressFromLookUp(int elementInApplicationIndex, String somebodyElseOwnerObjectRoot) {
        selectLookupValue(textBoxSomebodyElseOwnerAddress.get(elementInApplicationIndex), addressAutoCompleteList, _retrieveTestData.extractDataOffDataFile(somebodyElseOwnerObjectRoot + ".owner.address"), true);
    }

    public List<WebElement> getTextOfSomebodyElseOwnerNameHeaderInReporterPage() {
        return somebodyElseOwnerNameHeaderInReporterPage;
    }


}
