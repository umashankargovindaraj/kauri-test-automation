package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddEventPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__mainNav__addEvent__text']")
    private WebElement addEventlink;
//---------------------------------
    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__mainNav__contactEvent__contactMethod__comboBox']")
    private WebElement contactMethod;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__mainNav__contactEvent__eventDate__textBox']")
    private WebElement contactDate;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__mainNav__contactEvent__outcome__comboBox']")
    private WebElement addEventOutcome;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__mainNav__contactEvent__eventSave']")
    private static WebElement addEventSaveButton;
//--------------------------------------
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__Events__text']")
    private WebElement eventLink;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Phone')]")
    private WebElement verifyContactMethod;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'No Answer')]")
    private WebElement verifyOutcome;

    public void addEventTabLink(){
        waitAndClickElement(addEventlink);
    }
    public void AddEventDetails(){
        selectFromDropDownbyIndex(contactMethod,1);
        sendKeysToWebElement(contactDate, addOrSubtractDaysFromToday("sub", 0));
        selectFromDropDownbyIndex(addEventOutcome,1);
        waitAndClickElement(addEventSaveButton);

    }

    public void verifyAddEventDetailsSaved(){
        waitAndClickElement(eventLink);
        verifyText(verifyContactMethod,"Phone");
        System.out.println("Status Of the Questionnaire:" + verifyContactMethod.getText());
        verifyText(verifyOutcome,"No Answer");
        System.out.println("Status Of the Questionnaire:" + verifyOutcome.getText());

    }

}
