package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

import static org.testng.reporters.jq.BasePanel.S;

public class LoginPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@id='_loginControl_UserName']")
    private WebElement username;

    @FindBy(how = How.XPATH, using = "//input[@id='_loginControl_Password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@id='_loginControl_LoginButton']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//div[@class='SectionBlock Clearfix']/h1")
    private WebElement childSearchButton;

    @FindBy(how = How.XPATH,using = "//select[@id='_organisationComboBox__comboBox']")
    private WebElement organisation;

    @FindBy(how = How.XPATH, using = "//input[@id='_selectOrganisationButton']")
    private WebElement organisationOkButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Log Out')]")
    private WebElement logOutButton;





    public void launchApplication() {
        try {
            loadUrl(testEnvironment.getAppURL());
        } catch (Exception e) {
            Assert.fail("Application launch failed " + e.getMessage());
            System.out.println("comment by Uma");
        }
    }

    public void login(String userType) {
        String userName = getPropertyValue("username");
        String userPassword = getPropertyValue("password");


        sendKeysToWebElement(username, userName);
        sendKeysToWebElement(password, userPassword);
        clickElement(loginButton);
        if (userType.toLowerCase().equalsIgnoreCase("UmaProvider")) {
            chooseProvider();
        } else if (userType.toLowerCase().equalsIgnoreCase("Midcentral DHB")) {
            chooseCoordinator();
        } else if (userType.toLowerCase().equalsIgnoreCase("Auckland DHB")) {
            chooseCoordinatorLocalAdmin();
        }
    }

    public void AssertHomePage() {
        isElementDisplayed(childSearchButton);
    }

    public void chooseCoordinator(){
        selectFromDropDownbyValue(organisation,"Midcentral DHB");
       // getDefaultSelectedOptionForDropDown(organisation);
        waitAndClickElement(organisationOkButton);
    }

    public void chooseProvider() {
        selectFromDropDownbyValue(organisation, "UmaProvider");
        waitAndClickElement(organisationOkButton);
    }
     public void chooseCoordinatorLocalAdmin(){
                selectFromDropDownbyValue(organisation,"Auckland DHB");
         waitAndClickElement(organisationOkButton);
            }

            public void logoutApplication() {
//        waitAndClickElement(logOutButton);
                logOutButton.click();
            }
    }



