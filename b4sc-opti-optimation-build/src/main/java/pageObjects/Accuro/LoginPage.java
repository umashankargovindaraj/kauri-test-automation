package pageObjects.Accuro;

import libs.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

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
        String userName = null;
        String userPassword = null;
        String organisation = null;

        if (userType.toLowerCase().equalsIgnoreCase("provider")) {
            userName = getProviderUserName();
            userPassword = getProviderPassword();
            organisation = getProviderOrganisation();
        } else if (userType.toLowerCase().equalsIgnoreCase("coordinator")) {
            userName = getCoordinatorUserName();
            userPassword = getCoordinatorUserPassword();
            organisation = getcoordinatorOrganisation();
        } else if (userType.toLowerCase().equalsIgnoreCase("admin")) {//TODO
            chooseCoordinatorLocalAdmin();
        }
        enterCredentialAndLogin(userName,userPassword);
        if(!(organisation.equalsIgnoreCase("none"))){
            selectOrganisation(organisation);
        }
    }

    private String getProviderUserName(){
        return testEnvironment.getProviderUsername();
    }

    private String getProviderPassword(){
        return testEnvironment.getProviderPassword();
    }

    private String getProviderOrganisation(){
        return testEnvironment.getProviderOrganisation();
    }

    private String getCoordinatorUserName(){
        return testEnvironment.getCoordinatorUsername();
    }

    private String getCoordinatorUserPassword(){
        return testEnvironment.getCoordinatorPassword();
    }

    private String getcoordinatorOrganisation(){
        return testEnvironment.getCoordinatorOrganisation();
    }
    private void enterCredentialAndLogin(String user,String passw){
        sendKeysToWebElement(username, user);
        sendKeysToWebElement(password, passw);
        clickElement(loginButton);
    }

    public void AssertHomePage() {
        isElementDisplayed(childSearchButton);
    }

    private void selectOrganisation(String orgName){
        selectFromDropDownbyValue(organisation,orgName);
        waitAndClickElement(organisationOkButton);
    }

     public void chooseCoordinatorLocalAdmin(){
        selectFromDropDownbyValue(organisation,"Auckland DHB");
         waitAndClickElement(organisationOkButton);
            }

            public void logoutApplication() throws InterruptedException {
                waitAndclickElementUsingJS(logOutButton);
//                logOutButton.click();
            }




}



