package pageObjects.Accuro;

import libs.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AccuroSearchPage extends BasePage {

    @FindBy(how = How.ID, using = "b3-Input_SearchPhrase")
    private WebElement SearchText;

    public void searchOption(){

        try{
            Thread.sleep(5000);
            sendKeysToWebElement(SearchText,getAppData().getElement("CAREGIVER","RELATIONSHIP")+ Keys.ENTER);
        }
        catch(Exception ie){
        }
    }
}
