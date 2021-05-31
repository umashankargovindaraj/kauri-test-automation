package pageObjects.Accuro;

import libs.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ExportPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__mainNav__exportButton__text']")
    private WebElement exportTabClick;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__exportButton']")
    private WebElement exportButton;

    @FindBy(how = How.XPATH, using = "//div[@class='SectionBlock Clearfix']/h1")
    private WebElement childExportLabel;

    public void clickExportTab(){
        waitAndClickElement(exportTabClick);
    }

    public void clickExportButton(){
//----------switch to new window opened------------------------------------------/
        for(String winHandle : _driver.getWindowHandles()) {
            _driver.switchTo().window(winHandle);
        }
        waitAndClickElement(exportButton);
        System.out.println("export button clicked" +exportButton);
    }
}
