package pageObjects.onlineReporting.EventInfoSections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventInfoSomethingElse extends EventInfo {

    private @FindBy(xpath = "//div[@data-test-id='201905241028350100241']")
    WebElement sectionWhatHappenedSomethingElse = null;

    public boolean checkIfWhatHappenedSomethingElseExists(){
        return isElementDisplayed(sectionWhatHappenedSomethingElse);
    }
}
