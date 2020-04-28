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

    public WebElement getObjectReferenceByXpath(String xpath) {
        WebElement element = null;
        try {
            element = _driver.findElement(By.xpath(xpath));
            System.out.println("Successfully found WebElement: " + "<" + element.toString() + ">");
            return element;
        } catch (Exception e) {
            System.out.println("Unable to wait and find WebElement, Exception: " + e.getMessage());
            Assert.fail("Unable to wait and find WebElement, using locator: " + "<" + element.toString() + ">");
            return element;
        }
    }

    public void waitforElementTobeVisible(WebElement element) {
        int attempts = 0;
        while (attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(element));
                waitForPageComponentLoadFluentWait();
                System.out.println("Successfully found WebElement: " + "<" + element.toString() + ">");
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Unable to wait and find WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and find WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    public String getPageTitle() {
        return _driver.getTitle();
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

    public void selectFromDropDownbyIndex(WebElement element, int index) {
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
            //waitForPageComponentLoadFluentWait();
            //actionClick(element);
            //this.WaitUntilWebElementIsVisible(element);
            try {
                select = new Select(element);
                select.selectByVisibleText(value);
               // waitForPageComponentLoadFluentWait();
            } catch (StaleElementReferenceException staleElement) {
                element = getUpdatedReferenceOfStaleElement(element);
                select = new Select(element);
               // waitForPageComponentLoadFluentWait();
                select.selectByVisibleText(value);
               // waitForPageComponentLoadFluentWait();
            }
        } catch (Exception e) {
            System.out.println("Unable to find the object");
            Assert.fail("Unable to find the object: " + e.getMessage());
        }
        //waitForPageComponentLoadFluentWait();
    }


    public boolean checkIsDisplayed(WebElement element) {
        boolean eleFound = element.isDisplayed();
        System.out.println("DROPDOWN ELEMENT IN FRAME : " + eleFound);
        return eleFound;
    }

    public void actionClick(WebElement element) {
        Actions ob = new Actions(_driver);
        try {
            ob.moveToElement(element).click().build().perform();
            System.out.println("Successfully Action Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            waitForPageComponentLoadFluentWait();
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
            if (elementPresent) {
                ob.moveToElement(elementToClick).click().build().perform();
                System.out.println("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
        } catch (Exception e) {
            System.out.println("Unable to Action Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void actionClick(WebElement element, int x, int y) {
        Actions ob = new Actions(_driver);
        try {
            ob.moveToElement(element, x, y).click().build().perform();
            System.out.println("Successfully Action Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            waitForPageComponentLoadFluentWait();
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
            if (elementPresent) {
                ob.moveToElement(elementToClick).click().build().perform();
                System.out.println("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
        } catch (Exception e) {
            System.out.println("Unable to Action Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Click on the WebElement, Exception: " + e.getMessage());
        }
    }


    public void selectFromDropDownbyValueByClick(WebElement element, String value) {
        try {
            this.wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    Select select = new Select(element);
                    return select.getOptions().size() > 1;
                }
            });
            //element.click();
            waitForPageComponentLoadFluentWait();
            Select select = new Select(element);
            List<WebElement> options = select.getOptions();
            System.out.println("DROPDOWN BY CLICK: SELECT OPTIONS COUNT: " + options.size());
            for (WebElement listElement : options) {
                System.out.println(listElement.getText().trim());
                if (listElement.getText().trim().equalsIgnoreCase(value)) {
                    waitForPageComponentLoadFluentWait();
                    try {
                        listElement.click();
                        waitForPageComponentLoadFluentWait();
                        System.out.println("Option clicked : " + listElement.getText());
                        return;
                    } catch (StaleElementReferenceException ele) {
                        select.selectByValue(value);
                    }
                }
            }
        } catch (Throwable e) {
            System.out.println("Error found: " + e.getMessage());
        }
    }

    public List<WebElement> getAllListValuesInDropDown(WebElement element) {
        List<WebElement> allListValues = null;
        try {
            this.WaitUntilWebElementIsVisible(element);
            Select select = new Select(element);
            allListValues = select.getOptions();
            waitForPageComponentLoadFluentWait();
        } catch (Exception e) {
            System.out.println("Unable to find the object");
            Assert.fail("Unable to find the object: " + e.getMessage());
        }
        return allListValues;
    }

    public void waitAndClickElementsUsingByLocator(By by) {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(by)).click();
                waitForPageComponentLoadFluentWait();
                System.out.println("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the element using the By locator, element: " + "<" + by.toString() + ">");
            }
            attempts++;
        }
    }

    public void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) {
        Wait<WebDriver> tempWait = new WebDriverWait(_driver, 30);
        try {
            tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
            list.sendKeys(textToSearchFor);
            list.sendKeys(Keys.ENTER);
            waitForPageComponentLoadFluentWait();
            System.out.println("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to sendResultsToElasticSearch the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
        }
    }


    public void clickOnElementUsingCustomTimeout(WebElement locator, WebDriver _driver, int timeout) {
        try {
            final WebDriverWait customWait = new WebDriverWait(_driver, timeout);
            customWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
            locator.click();
            waitForPageComponentLoadFluentWait();

            System.out.println("Successfully clicked on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
        } catch (Exception e) {
            System.out.println("Unable to click on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
            Assert.fail("Unable to click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void actionMoveAndClick(WebElement element) {
        Actions ob = new Actions(_driver);
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            ob.moveToElement(element).click().build().perform();
            System.out.println("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");

            waitForPageComponentLoadFluentWait();
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
            if (elementPresent) {
                ob.moveToElement(elementToClick).click().build().perform();
                System.out.println("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");

            }
        } catch (Exception e) {
            System.out.println("Unable to Action Move and Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void actionMoveAndClickByLocator(By element) throws InterruptedException {
        Actions ob = new Actions(_driver);
        try {
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            if (elementPresent == true) {
                WebElement elementToClick = _driver.findElement(element);
                ob.moveToElement(elementToClick).click().build().perform();
                System.out.println("Action moved and clicked on the following element, using By locator: " + "<" + element.toString() + ">");

                waitForPageComponentLoadFluentWait();
            }
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = _driver.findElement(element);
            ob.moveToElement(elementToClick).click().build().perform();
            System.out.println("(Stale Exception) - Action moved and clicked on the following element, using By locator: " + "<" + element.toString() + ">");

            waitForPageComponentLoadFluentWait();
        } catch (Exception e) {
            System.out.println("Unable to Action Move and Click on the WebElement using by locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Click on the WebElement using by locator, Exception: " + e.getMessage());
        }
    }

    public void sendKeysToWebElement(WebElement element, String textToSend) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            //element.clear();
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
            waitForPageComponentLoadFluentWait();
            System.out.println("Successfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to scroll to the WebElement, Exception: " + e.getMessage());
        }
    }

    public void jsPageScroll(int numb1, int numb2) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) _driver;
            js.executeScript("scroll(" + numb1 + "," + numb2 + ")");
            System.out.println("Successfully scrolled to the correct position! using locators: " + numb1 + ", " + numb2);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element using locators: " + "<" + numb1 + "> " + " <" + numb2 + ">");
            Assert.fail("Unable to manually scroll to WebElement, Exception: " + e.getMessage());
        }
    }

    public void waitAndclickElementUsingJS(WebElement element) {
        try {
            waitForPageComponentLoadFluentWait();
            String elementName = element.toString();
            //jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            jsExecutor.executeScript("arguments[0].click();", element);
            System.out.println("Successfully JS clicked on the following WebElement: " + "<" + elementName + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement staleElement = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
            waitForPageComponentLoadFluentWait();
            if (elementPresent == true) {
                jsExecutor.executeScript("arguments[0].click();", staleElement);
                System.out.println("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<" + staleElement.toString() + ">");

            }
        } catch (NoSuchElementException e) {
            System.out.println("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
        }
        waitForPageComponentLoadFluentWait();
    }


    public void waitAndclickElementUsingJSAndExit(WebElement element) {
        try {
            waitForPageComponentLoadFluentWait();
            String elementName = element.toString();
            jsExecutor.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", element);
            System.out.println("Successfully JS clicked on the following WebElement: " + "<" + elementName + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement staleElement = element;
            boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
            waitForPageComponentLoadFluentWait();
            if (elementPresent) {
                jsExecutor.executeScript("arguments[0].click();", staleElement);
                System.out.println("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<" + staleElement.toString() + ">");

            }
        } catch (NoSuchElementException e) {
            System.out.println("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
        }
        // waitForPageComponentLoadFluentWait();
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        js.executeScript("arguments[0].click();", element);

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

    public boolean WaitUntilWebElementIsVisibleUsingByLocator(By element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            System.out.println("Element is visible using By locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using By locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }


    public boolean isElementClickable(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
            return false;
        }
    }


    public boolean waitUntilPreLoadElementDissapears(By element) {
        return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public BasePage loadUrl(String url) throws IOException {
        _driver.get(url);
        return new BasePage();
    }

    public String getCurrentURL() {
        try {
            String url = _driver.getCurrentUrl();
            System.out.println("Found(Got) the following URL: " + url);
            return url;
        } catch (Exception e) {
            System.out.println("Unable to locate (Get) the current URL, Exception: " + e.getMessage());
            return e.getMessage();
        }
    }

    public String waitForSpecificPage(String urlToWaitFor) {
        try {
            String url = _driver.getCurrentUrl();
            this.wait.until(ExpectedConditions.urlMatches(urlToWaitFor));
            System.out.println("The current URL was: " + url + ", " + "navigated and waited for the following URL: " + urlToWaitFor);
            return urlToWaitFor;
        } catch (Exception e) {
            System.out.println("Exception! waiting for the URL: " + urlToWaitFor + ",  Exception: " + e.getMessage());
            return e.getMessage();
        }
    }

    public void closePopups(By locator) throws InterruptedException {
        try {
            List<WebElement> elements = this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    element.click();
                    this.wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
                    System.out.println("The popup has been closed Successfully!");

                }
            }
        } catch (Exception e) {
            System.out.println("Exception! - could not close the popup!, Exception: " + e.toString());
            throw (e);
        }
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

    public boolean isElementEnabled(WebElement element) {
        try {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            waitForPageComponentLoadFluentWait();
            this.WaitUntilWebElementIsVisible(element);
            waitForPageComponentLoadFluentWait();
            return element.isEnabled();
        } catch (StaleElementReferenceException staleException) {
            WebElement staleElement = getUpdatedReferenceOfStaleElement(element);
            handleStaleExceptionError(staleElement);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", staleElement);
            waitForPageComponentLoadFluentWait();
            this.WaitUntilWebElementIsVisible(staleElement);
            waitForPageComponentLoadFluentWait();
            return element.isEnabled();
        } catch (Exception e) {
            System.out.println("Unable to find the object in isElementEnabled()");
            Assert.fail("Unable to find the object: " + e.getMessage());
            return false;
        }
    }

    public String getDefaultSelectedOptionForDropDown(WebElement element) {
        try {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            /*waitForPageComponentLoadFluentWait();
            this.WaitUntilWebElementIsVisible(element);
            waitForPageComponentLoadFluentWait();*/
            Select select = new Select(element);
            WebElement option = select.getFirstSelectedOption();
            String defaultItem = option.getText().trim();
            return defaultItem;
        } catch (StaleElementReferenceException staleException) {
            WebElement staleElement = getUpdatedReferenceOfStaleElement(element);
            handleStaleExceptionError(staleElement);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", staleElement);
            /*waitForPageComponentLoadFluentWait();
            this.WaitUntilWebElementIsVisible(staleElement);
            waitForPageComponentLoadFluentWait();*/
            Select select = new Select(element);
            WebElement option = select.getFirstSelectedOption();
            String defaultItem = option.getText().trim();
            return defaultItem;
        } catch (Exception e) {
            System.out.println("Unable to find the object in getDefaultSelectedOptionForDropDown()");
            Assert.fail("Unable to find the object for getDefaultSelectedOptionForDropDown(): " + e.getMessage());
            return null;
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

    public boolean isDisplayed(WebElement element) {
        try {
            waitForPageComponentLoadFluentWait();
            try {
                boolean elementFound = element.isDisplayed();
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementNotDisplayed(WebElement element) {
        boolean elementNotFound = false;
        boolean elementVisible = false;
        try {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            waitForPageComponentLoadFluentWait();
            this.WaitUntilWebElementIsVisible(element);
            waitForPageComponentLoadFluentWait();
            elementVisible = element.isDisplayed();
        } catch (NoSuchElementException e) {
            elementNotFound = true;
        } catch (Exception e) {
            Assert.fail("Unable to find the object: " + e.getMessage());
        }
        if (elementVisible) {
            elementNotFound = false;
        }
        return elementNotFound;
    }

    public boolean isElementListDisplayed(List<WebElement> elements) {
        waitForPageComponentLoadFluentWait();
        boolean elementFound = false;
        try {
            for (WebElement element : elements) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
                waitForPageComponentLoadFluentWait();
                this.WaitUntilWebElementIsVisible(element);
                waitForPageComponentLoadFluentWait();
                elementFound = element.isDisplayed();
                if (!elementFound) {
                    return false;
                }
            }
            return elementFound;

        } catch (Exception e) {
            System.out.println("Unable to find the object");
            Assert.fail("Unable to find the object: " + e.getMessage());
            return false;
        }
    }

    public String waitandGetText(WebElement element) {
        boolean clicked = false;
        int attempts = 0;
        String value = null;
        while (!clicked && attempts < 10) {
            try {
                waitForPageComponentLoadFluentWait();
                value = this.wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
                System.out.println("Successfully retrieved text from WebElement: " + "<" + element.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and retrieve text on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and retrieve text from the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            waitForPageComponentLoadFluentWait();
            attempts++;
        }
        return value;
    }


    public String getAttributeValue(WebElement element, String attribute) {
        String value = "";
        try {
            waitForPageComponentLoadFluentWait();
            value = this.wait.until(ExpectedConditions.visibilityOf(element)).getAttribute(attribute);
            return value;
        } catch (Exception e) {
            System.out.println("Unable to find the WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to find the WebElement:, using locator: " + "<" + element.toString() + ">");
        }
        return value;
    }

    public void switchToBrowserFrame() {
        List<WebElement> frames = _driver.findElements(By.xpath("//iframe"));
        Assert.assertNotNull(frames, "Checking if frames exists");
        validFrame = frames.get(frames.size() - 1);
        _driver.switchTo().frame(validFrame);
    }

    public void waitForPageComponentLoad() {
        try {
            //driver.switchTo().defaultContent();
            new WebDriverWait(_driver, 30).until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='document-statetracker' and @data-state-busy-status='none']")));
            //switchToBrowserFrame();
        } catch (Exception e) {
            System.out.println("Issue in finding document state tracker");
        }
    }

    public void waitForPageComponentLoadFluentWait_Tushar() {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(_driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);

        WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                WebElement ele = null;
                //boolean loop = true;
                //int loopCounter = 0;
                //while (loop) {
                try {
                    ele = wait.until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//div[@class='document-statetracker' and @data-state-busy-status='none']")));
                    //loop = false;
                } catch (Exception e) {
                    //loopCounter++;
                    //if (loopCounter > 1) {
                    //loop = false;
                    //}
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException ex) {
//                            ex.printStackTrace();
//                        }
                    System.out.println("DOM still busy");
                }
                //}
                return ele;
                /*return wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='document-statetracker' and @data-state-busy-status='none']")));*/
            }
        });
    }

    public void waitForPageComponentLoadFluentWait() {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(_driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);

        WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                WebElement ele = null;
                boolean loop = true;
                int loopCounter = 0;
                while (loop) {
                    try {
                        ele = wait.until(ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//div[@class='document-statetracker' and @data-state-busy-status='none']")));
                        System.out.println("DOM OK");
                        loop = false;
                    } catch (Exception e) {
                        loopCounter++;
                        if (loopCounter > 1) {
                            loop = false;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("DOM still busy");
                    }
                }
                return ele;
                /*return wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='document-statetracker' and @data-state-busy-status='none']")));*/
            }
        });
    }


    public void waitForPageComponentLoadFluentWait1() {

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(_driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);

        WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                WebElement ele = null;
                WebElement eleBusy = null;
                boolean loop = true;
                int loopCounter = 0;
                while (loop) {
                    try {
                        ele = wait.until(ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//div[@class='document-statetracker' and @data-state-busy-status='none']")));
                        loop = false;
                        System.out.println("DOM OK");
                    } catch (WebDriverException e) {
                        eleBusy = wait.until(ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//div[@class='document-statetracker' and @data-state-busy-status='none'] | //div[@class='document-statetracker' and @data-state-busy-status='busy']")));
                        System.out.println("DOM Still busy");
                    } catch (Exception e) {
                        System.out.println("ABC");
                        System.exit(1);
                    }
                }
                return ele;
            }
        });
    }

    /**
     * select a value from the lookup field , mainly for address
     */
    public void selectLookupValue(WebElement field, List<WebElement> autoCompleteList, String texttolookup, boolean isFieldAddress) {
        try {
            waitForPageComponentLoadFluentWait();
            jsExecutor.executeScript("arguments[0].click();", field);
            if (isFieldAddress) {
                keyInWholeDataOnlyAfterFirstXChars(field, texttolookup);
            } else {
                field.sendKeys(texttolookup);
                field.sendKeys(Keys.ARROW_DOWN);
            }
            waitForLookUpAutoCompleteAjaxToLoad(field, texttolookup);
            waitForPageComponentLoadFluentWait();
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
                        waitForPageComponentLoadFluentWait();
                        break;
                    }
                } catch (StaleElementReferenceException staleException) {
                    WebElement staleElement = getUpdatedReferenceOfStaleElement(listValues);
                    handleStaleExceptionError(staleElement);
                    if (staleElement.getText().trim().equalsIgnoreCase(texttolookup.trim())) {
                        staleElement.click();
                        waitForPageComponentLoadFluentWait();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            Assert.assertTrue(false, "Value not found in loopup value : " + e.getMessage());
        }
    }

    public void keyInWholeDataOnlyAfterFirstXChars(WebElement element, String value) {
        int holdAfterCharacters = 4;
        element.sendKeys(value.substring(0, holdAfterCharacters));
        waitForPageComponentLoadFluentWait();
        element.sendKeys(value.substring(holdAfterCharacters));

    }

    public void enterDataOneAtATime(WebElement element, String value) {
        int i = 0;
        boolean blnLoop = true;
        for (i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            waitForPageComponentLoadFluentWait();
            System.out.println("Entered key in enterDataOneAtATime method : " + s);
            try {
                if (getAttributeValue(element, "data-change-lazy").equalsIgnoreCase("true")) {
                    System.out.println("data-change-lazy is true now");
                    abc(element, value, i + 1);
                    break;
                } else {
                    System.out.println("enterDataOneAtATime method in data-change-lazy is false");
                }
            } catch (Exception e) {
                System.out.println("Could not find data-change-lazy attribute");
            }
        }
    }

    public void abc(WebElement element, String value, int index) {
        System.out.println("Called method ABC");
        for (int i = index; i < value.length(); i++) {
            char c = value.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            System.out.println("Entered key : " + s);
        }
    }

    /**
     * verify a value in lookup field , mainly for address and firearms lookup list
     */
    public void verifyValueInLookupList(WebElement field, String texttolookup) {
        try {
            boolean valueFound = false;
            //WebElement lookupField = field.(By.xpath("//input[@data-test-id='2019031415200802003627']"));
            waitForPageComponentLoadFluentWait();
            field.clear();
            field.sendKeys(texttolookup);
            waitForPageComponentLoadFluentWait();
            field.sendKeys(Keys.ARROW_DOWN);
            waitForPageComponentLoadFluentWait();
            List<WebElement> autoCompleteList = _driver.findElements(By.xpath("//*[@class='cellIn']/span"));
            if (autoCompleteList.size() == 0) {
                Assert.fail("autoComplete list NOT found");
            } else {
                System.out.println("autoComplete list Found with elements: " + autoCompleteList.size());
            }
            for (WebElement listValues : autoCompleteList) {
                if (listValues.getText().trim().equalsIgnoreCase(texttolookup.trim())) {
                    valueFound = true;
                    break;
                }
            }
            if (!(valueFound)) {
                Assert.fail("Value not found in lookup list " + field + " for value " + texttolookup + "Please check the data");
            }
        } catch (Exception e) {
            Assert.fail("Error found " + e.getMessage());
        }
    }

    public void verifyValueNotExistInLookupList(WebElement field, String texttolookup) {
        try {
            boolean valueFound = false;
            waitForPageComponentLoadFluentWait();
            field.clear();
            field.sendKeys(texttolookup);
            waitForPageComponentLoadFluentWait();
            field.sendKeys(Keys.ARROW_DOWN);
            waitForPageComponentLoadFluentWait();
            List<WebElement> autoCompleteList = _driver.findElements(By.xpath("//*[@class='cellIn']/span"));
            if (autoCompleteList.size() == 0) {
                System.out.println("autoComplete list Found with elements: " + autoCompleteList.size());
            } else {
                for (WebElement listValues : autoCompleteList) {
                    if (listValues.getText().trim().equalsIgnoreCase(texttolookup.trim())) {
                        valueFound = true;
                        break;
                    }
                }
                if ((valueFound)) {
                    Assert.fail("Value found in lookup list " + field + " for value " + texttolookup + "Please check the data");
                }
            }
        } catch (Exception e) {
            Assert.fail("Error found " + e.getMessage());
        }
    }


    public void updateDatePickerUsingJavaScript(String value, String xpathSpanLocator, String xpathInputLocator) {
        waitForPageComponentLoadFluentWait();
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
        waitForPageComponentLoadFluentWait();
        String javaScriptCode = "function getElementByXpath(path) { " +
                "return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "}; " +
                "var b = getElementByXpath(\"" + xpathLocator + "\"); " +
                "b.setAttribute(\"value\", \"" + value + "\");" +
                "b.innerHTML='" + value + "'; " +
                "";
        jsExecutor.executeScript(javaScriptCode);
    }

    public void updateFieldValueUsingJavaScriptMobile(String xpathLocator, String value, String xpathHiddenElement, String formattedValue) {
        waitForPageComponentLoadFluentWait();
        String javaScriptCode = "function getElementByXpath(path) { " +
                "return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "}; " +
                "var a = getElementByXpath(\"" + xpathLocator + "\"); " +
                "a.setAttribute(\"value\", \"" + value + "\");" +
                "var b = getElementByXpath(\"" + xpathHiddenElement + "\"); " +
                "b.setAttribute(\"value\", \"" + formattedValue + "\");" +
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

    public void waitForLookUpAutoCompleteAjaxToLoad(WebElement element, String dataEntered) {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(_driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);

        Boolean object = fluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                if (getAttributeValue(element, "value").length() == dataEntered.length()) {
                    System.out.println("Exiting waitForLookUpAutoCompleteAjaxToLoad");
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    public void waitForOwnerNameToLoadInDropDown(WebElement element, String firstName) {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(_driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);

        Boolean object = fluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                waitForPageComponentLoadFluentWait();
                try {
                    Select select = new Select(element);
                    for (WebElement item : select.getOptions()) {
                        if (item.getText().trim().equalsIgnoreCase(firstName)) {
                            System.out.println("Owner name is loaded in the dropdown");
                            return true;
                        }
                    }
                } catch (StaleElementReferenceException e) {
                    Select select = new Select(element);
                    for (WebElement item : select.getOptions()) {
                        if (item.getText().trim().equalsIgnoreCase(firstName)) {
                            System.out.println("Owner name is loaded in the dropdown");
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

    public void waitForOwnerLastNameToTurnCaps(WebElement element) {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(_driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);

        Boolean object = fluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                waitForPageComponentLoadFluentWait();
                try {
                    return isStringUpperCase(element.getText());
                } catch (StaleElementReferenceException e) {
                    return isStringUpperCase(element.getText());
                }
            }
        });
    }

    public void waitForOwnerDOBToBeValidated(WebElement element, String value) {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(_driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);

        Boolean object = fluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                waitForPageComponentLoadFluentWait();
                try {
                    if (getAttributeValue(element, "value").equalsIgnoreCase(value)) {
                        return true;
                    }
                } catch (StaleElementReferenceException e) {
                    if (getAttributeValue(element, "value").equalsIgnoreCase(value)) {
                        return true;
                    }
                }
                return true;
            }
        });
    }

    private boolean isStringUpperCase(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isUpperCase(charArray[i]))
                return false;
        }
        return true;
    }

    public void validateDropDownListValues1(List<WebElement> allValues, String[] expectedValues) {
        Assert.assertEquals(allValues.size(), expectedValues.length + 1, "Comparing the size of items in list against expected");
        for (String expectedValue : expectedValues) {
            boolean foundValue = false;
            for (WebElement actualListValue : allValues) {
                if (expectedValue.equalsIgnoreCase(actualListValue.getText())) {
                    foundValue = true;
                    break;
                }
            }
            if (!foundValue) {
                Assert.assertTrue(false, expectedValue + " is not found in the list");
            }
        }
    }

    public void validateDropDownListValues(List<WebElement> allValues, String[] expectedValues) {
        List<String> actualList = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();
        for (WebElement actualDropDownList : allValues) {
            actualList.add(actualDropDownList.getText());
        }

        for (String expected : expectedValues) {
            expectedList.add(expected);
        }
        expectedList.removeAll(actualList);
        Assert.assertTrue(expectedList.size() == 0, "Missing data in dropdown => " + expectedList);
    }

    public void handleStaleExceptionError(WebElement element) {
        System.out.println("Handling staleException error");
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(_driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);

        Boolean object = fluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                WebElement updatedElement = element;
                try {
                    boolean elementDisplayed;
                    elementDisplayed = updatedElement.isDisplayed();
                    if (elementDisplayed) {
                        System.out.println("Element found. StaleException loop exit");
                        return true;
                    } else {
                        return false;
                    }
                } catch (StaleElementReferenceException staleExceptionHandled) {
                    updatedElement = element;
                    return false;
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

    public void clickelementAndCloseAlert(WebElement element) {
        try {
            waitForPageComponentLoadFluentWait();
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

        } catch (StaleElementReferenceException elementUpdated) {
            WebElement staleElement = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
            waitForPageComponentLoadFluentWait();
            if (elementPresent == true) {
                jsExecutor.executeScript("arguments[0].click();", staleElement);
                System.out.println("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<" + staleElement.toString() + ">");

            }
        } catch (NoSuchElementException e) {
            System.out.println("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void switchToNativeApp() {
        if (_driver instanceof AppiumDriver) {
            ((AppiumDriver) _driver).context("NATIVE_APP");
        }
    }

    public void switchToWebView() {
        if (_driver instanceof AppiumDriver) {
            Set<String> context = ((AppiumDriver) _driver).getContextHandles();
            for (String value : context) {
                if (!value.equalsIgnoreCase("NATIVE_APP")) {
                    ((AppiumDriver) _driver).context(value);
                }
            }
        }
    }

    public WebElement getFirstElementOfPage(String text) {
        String xpathFirstElementOfPage = "//*[text()='<text>']";
        String xpath = xpathFirstElementOfPage.replace("<text>", text);
        System.out.println("XPATH :::::::::" + xpath);
        WebElement element = getObjectReferenceByXpath(xpath);
        System.out.println("ELEMENT ************ " + element);
        System.out.println("ELEMENT ************ " + element.toString());
        return element;
    }


    public int generateRandomValueBetweenRange(int max, int min) {
        Random rn = new Random();
        return rn.nextInt(max - min + 1) + min;
    }

    protected List<Map<String, String>> getCucumberDataTableAsList(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        Assert.assertTrue(list.size() >= 1, "Data not found. Please mention the data in gherkin datatable format");
        return list;
    }

    public Object createJsonParser(String jsonString) {
        Object jsonObject = null;
        try {
            jsonObject = Configuration.defaultConfiguration().jsonProvider().parse(jsonString);
        } catch (Exception e) {
            Assert.fail("Invalid json string : " + jsonString + "Exception : " + e);
        }
        return jsonObject;
    }

    public String retrieveDataFromJsonOutputPayload(String jsonPayload, String xpath) {
        Object jsonObject = createJsonParser(jsonPayload);
        String data = "";
        try {
            data = JsonPath.parse(jsonObject).read(xpath).toString();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        return data;
    }
    /* verify text of an object with expected result
     * @param testObject - webelement
     * @param texttoverify - exepected text
     */
    public void verifyText(WebElement testObject, String texttoverify) {
        String actualtext = null;
        String expected = null;
        try {
           // this.wait.until(ExpectedConditions.elementToBeClickable(testObject)).click();
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
    }
