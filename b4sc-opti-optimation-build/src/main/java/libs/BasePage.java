package libs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BasePage extends DriverFactory {
    protected WebDriverWait wait;
    private JavascriptExecutor jsExecutor;
    protected WebElement validFrame;

    int timeOut = 30;
    int polling = 1;

    public BasePage() {
        if (_driver != null) {
            this.wait = new WebDriverWait(_driver, 30);
            jsExecutor = ((JavascriptExecutor) _driver);
        }
    }

    public void hoverOver(WebElement element) {
        Actions builder = new Actions(_driver);
        builder.moveToElement(element).perform();
    }

    public void waitforElementTobeVisible(WebElement element) {
        int attempts = 0;
        while (attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(element));
                System.out.println("Successfully found WebElement: " + "<" + element.toString() + ">");
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Unable to wait and find WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and find WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    public void clickElement(WebElement element) {
        try{
            this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch(Exception e){
            Assert.fail("Uable to click the element " + e.getMessage());
        }
    }

    public void waitAndClickElement(WebElement element) {
        boolean clicked = false;
        int attempts = 0;
        waitForLoad(_driver);
        waitForElementLoadedCompletely(element);
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                clicked = true;
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    /**
     * wait for page load
     */
    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        this.wait.until(pageLoadCondition);
    }

    public void selectFromDropDownbyIndex(WebElement element, int index) {
        waitForElementLoadedCompletely(element);
        try {
            this.WaitUntilWebElementIsVisible(element);
            Select select = new Select(element);
            select.selectByIndex(index);

        } catch (Exception e) {
            System.out.println("Unable to find the object");
            Assert.fail("Unable to find the object: " + e.getMessage());
        }


    }

    public void selectFromDropDownbyValue(WebElement element, String value) {
        Select select;
        try {
            waitForElementLoadedCompletely(element);
            try {
                select = new Select(element);
                select.selectByVisibleText(value);
               // 
            } catch (StaleElementReferenceException staleElement) {
                element = getUpdatedReferenceOfStaleElement(element);
                select = new Select(element);
               // 
                select.selectByVisibleText(value);
               // 
            }
        } catch (Exception e) {
            System.out.println("Unable to select value " + value +" for dropdown element " + element);
            Assert.fail("Unable to select value " + value +" for dropdown element " + element + "error: " + e.getMessage());
        }
        //
    }

    public List<WebElement> getAllListValuesInDropDown(WebElement element) {
        List<WebElement> allListValues = null;
        try {
            this.WaitUntilWebElementIsVisible(element);
            Select select = new Select(element);
            allListValues = select.getOptions();
            
        } catch (Exception e) {
            System.out.println("Unable to find the object");
            Assert.fail("Unable to find the object: " + e.getMessage());
        }
        return allListValues;
    }

    public void sendKeysToWebElement(WebElement element, String textToSend) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(textToSend);
            //sendTABKey(element);
            System.out.println("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to locate WebElement: " + "<" + element.toString() + "> and sendResultsToElasticSearch the following keys: " + textToSend);
            Assert.fail("Unable to keys to WebElement, Exception: " + e.getMessage());
        }
    }

    public void sendTABKey(WebElement element) {
        try {
            this.WaitUntilWebElementIsVisible(element);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            element.sendKeys(Keys.TAB);
        } catch (Exception e) {
            System.out.println("Unable to send TAB WebElement");
            Assert.fail("Unable to sendkeys to WebElement, Exception: " + e.getMessage());
        }
    }

    public void sendKeysToWebElement(WebElement element, String textToSend, boolean withoutFrame) {
        try {
            this.WaitUntilWebElementIsVisible(element);
            element.clear();
            element.sendKeys(textToSend);
            System.out.println("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to locate WebElement: " + "<" + element.toString() + "> and sendResultsToElasticSearch the following keys: " + textToSend);
            Assert.fail("Unable to sendResultsToElasticSearch keys to WebElement, Exception: " + e.getMessage());
        }
    }

    public void scrollToElementByWebElementLocator(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
            jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
            jsExecutor.executeScript("window.scrollBy(0, -400)");
            
            System.out.println("Successfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to scroll to the WebElement, Exception: " + e.getMessage());
        }
    }

    public void waitAndclickElementUsingJS(WebElement element) {
        try {
            waitForElementLoadedCompletely(element);
            String elementName = element.toString();
            //jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            jsExecutor.executeScript("arguments[0].click();", element);
            System.out.println("Successfully JS clicked on the following WebElement: " + "<" + elementName + ">");
        } catch (Exception e) {
            System.out.println("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
        }
        if (isAlertPresent()) {
            _driver.switchTo().alert();
            _driver.switchTo().alert().accept();
            _driver.switchTo().defaultContent();
        }

    }

    private void WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
        } catch (StaleElementReferenceException staleElement) {
            element = getUpdatedReferenceOfStaleElement(element);
            this.wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
        }
    }

    public BasePage loadUrl(String url) {
        try{
            _driver.get(url);
        }catch(Exception e){
            Assert.fail("Error in getting the URL " + url + " " + e.getMessage());
        }
        return new BasePage();
    }

    public boolean checkPopupIsVisible() {
        try {
            @SuppressWarnings("unused")
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("A popup has been found!");
            return true;
        } catch (Exception e) {
            System.err.println("Error came while waiting for the alert popup to appear. " + e.getMessage());
        }
        return false;
    }

    public boolean isAlertPresent() {
        try {
            _driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeAlertPopupBox() throws AWTException, InterruptedException {
        try {
            Alert alert = this.wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (UnhandledAlertException f) {
            Alert alert = _driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Unable to close the popup");
            Assert.fail("Unable to close the popup, Exception: " + e.getMessage());
        }
    }

    public boolean isElementDisplayed(WebElement element) {

        try {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            try {
                this.WaitUntilWebElementIsVisible(element);
                try {
                    boolean elementFound = element.isDisplayed();
                    return elementFound;
                } catch (Exception e) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Unable to find the object");
            Assert.fail("Unable to find the object: " + e.getMessage());
            return false;
        }
    }

    public String getAttributeValue(WebElement element, String attribute) {
        String value = "";
        try {
            
            value = this.wait.until(ExpectedConditions.visibilityOf(element)).getAttribute(attribute);
            return value;
        } catch (Exception e) {
            System.out.println("Unable to find the WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to find the WebElement:, using locator: " + "<" + element.toString() + ">");
        }
        return value;
    }

    /**
     * select a value from the lookup field , mainly for address
     */
    public void selectLookupValue(WebElement field, List<WebElement> autoCompleteList, String texttolookup, boolean isFieldAddress) {
        try {

            jsExecutor.executeScript("arguments[0].click();", field);
            if (isFieldAddress) {
                keyInWholeDataOnlyAfterFirstXChars(field, texttolookup);
            } else {
                field.sendKeys(texttolookup);
                field.sendKeys(Keys.ARROW_DOWN);
            }
            System.out.println("check 1");
            autoCompleteList = getUpdatedReferenceOfStaleElementList(autoCompleteList);
            System.out.println("check 2");
            if (autoCompleteList.size() == 0) {
                Assert.fail("autoComplete list NOT found");
            } else {
                System.out.println("autoComplete list Found with elements: " + autoCompleteList.size());
            }

            for (WebElement listValues : autoCompleteList) {
                try {
                    System.out.println("VALUE FROM DROPDOWN: " + listValues.getText().trim());
                    System.out.println("VALUE EXPECTED     : " + texttolookup);
                    if (listValues.getText().trim().equalsIgnoreCase(texttolookup.trim())) {
                        listValues.click();
                        
                        break;
                    }
                } catch (Exception staleException) {
                    Assert.fail("Error in selecting the lookup value");
                }
            }
        } catch (Exception e) {
            Assert.assertTrue(false, "Value not found in loopup value : " + e.getMessage());
        }
    }

    public void keyInWholeDataOnlyAfterFirstXChars(WebElement element, String value) {
        int holdAfterCharacters = 4;
        element.sendKeys(value.substring(0, holdAfterCharacters));
        
        element.sendKeys(value.substring(holdAfterCharacters));

    }

    public void updateDatePickerUsingJavaScript(String value, String xpathSpanLocator, String xpathInputLocator) {

        String javaScriptCode = "function getElementByXpath(path) { " +
                "return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "}; " +
                "var a = getElementByXpath(\"" + xpathSpanLocator + "\"); " +
                "a.innerHTML='" + value + "'; " +
                "var b = getElementByXpath(\"" + xpathInputLocator + "\"); " +
                "b.setAttribute(\"value\", \"" + value + "\");" +
                "";
        jsExecutor.executeScript(javaScriptCode);
    }

    public void updateFieldValueUsingJavaScript(String xpathLocator, String value) {
        
        String javaScriptCode = "function getElementByXpath(path) { " +
                "return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "}; " +
                "var b = getElementByXpath(\"" + xpathLocator + "\"); " +
                "b.setAttribute(\"value\", \"" + value + "\");" +
                "b.innerHTML='" + value + "'; " +
                "";
        jsExecutor.executeScript(javaScriptCode);
    }

    public void waitForElementLoadedCompletely(WebElement element) {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(_driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);

        WebElement object = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                WebElement ele = element;
                wait.until(ExpectedConditions.elementToBeClickable(ele));
                wait.until(ExpectedConditions.visibilityOf(ele));
                boolean visible = ele.isEnabled();
                if (visible) {
                    return ele;
                } else {
                    System.out.println("Object not found. " + element.toString());
                    return null;
                }
            }
        });
    }

    public WebElement getUpdatedReferenceOfStaleElement(WebElement staleElement) {
        String xpathStaleElement = staleElement.toString().substring(staleElement.toString().indexOf("xpath: ") + 7, staleElement.toString().length() - 1);
        try {
            return _driver.findElement(By.xpath(xpathStaleElement));
        } catch (Exception e) {
            System.out.println("Cannot update reference of staleElement : " + e.getMessage());
            return null;
        }
    }

    public List<WebElement> getUpdatedReferenceOfStaleElementList(List<WebElement> staleElement) {
        WebElement xpathArrayElements = staleElement.get(0);
        String xpathFromElement = xpathArrayElements.toString();
        String xpathStaleElement = xpathFromElement.substring(xpathFromElement.indexOf("xpath: ") + 7, xpathFromElement.length() - 1);
        try {
            return _driver.findElements(By.xpath(xpathStaleElement));
        } catch (Exception e) {
            System.out.println("Cannot update reference of staleElement : " + e.getMessage());
            return null;
        }
    }

    /* verify text of an object with expected result
     * @param testObject - webelement
     * @param texttoverify - exepected text
     */
    public void verifyText(WebElement testObject, String texttoverify) {
        String actualtext = null;
        String expected = null;
        waitForElementLoadedCompletely(testObject);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(testObject));
            expected = texttoverify.trim().replaceAll("\\s+", "").toLowerCase();
            actualtext = testObject.getText().trim().replaceAll("\\s+", "").toLowerCase();
            Assert.assertEquals(actualtext, expected);
        } catch (Exception e) {
            Assert.fail("Verification failed for actual value: " + actualtext + " and expected value: " + expected);
        }
    }
    /* verify partial text of an object
     * @param testObject - webelement
     * @param texttoverify
     */
    public void verifyTextPartially(WebElement testObject, String texttoverify){
        try{
            String expected = texttoverify.trim().replaceAll("\\s+","").toLowerCase();
            wait.until(ExpectedConditions.elementToBeClickable(testObject));
            String actualtext = testObject.getText().trim().replaceAll("\\s+","").toLowerCase();
            System.out.println(expected);
            System.out.println(actualtext);
            if(actualtext.contains(expected)){
                Assert.assertTrue(true,"Partial text verification successful");
            }else{
                Assert.fail("Partial verification failed");
            }
        }catch(Exception e){
            System.out.println("Error found " + e.getMessage());
        }
    }

    public void attachFile (WebElement element, String filePath) {
        System.out.println("BASE PATH : " + System.getProperty("user.dir"));
        waitForElementLoadedCompletely(element);
        try {
//            if(_driver instanceof RemoteWebDriver){
//                ((RemoteWebDriver) _driver).setFileDetector(new LocalFileDetector());
//            }
            element.sendKeys(System.getProperty("user.dir") + filePath);
        }catch (Exception e){
            Assert.fail("Uploading the document failed " + e.getMessage());
            System.out.println(e);
        }
    }
}
