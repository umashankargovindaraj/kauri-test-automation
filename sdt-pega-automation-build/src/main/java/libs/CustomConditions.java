package libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {

    public static ExpectedCondition<Boolean> elementWasClicked(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    element.click();
                    return true;
                } catch (Exception ex) {
                    return false;
                }
            }
            @Override
            public String toString() {
                return "element to be clicked: " +
                        element.toString();
            }
        };
    }
}
