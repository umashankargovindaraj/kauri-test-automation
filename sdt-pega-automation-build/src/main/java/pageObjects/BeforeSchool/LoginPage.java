package pageObjects.BeforeSchool;

import libs.BasePage;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage extends BasePage {

    public void launchApplication() {
        try{
            loadUrl(testEnvironment.getAppURL());
            System.out.println(getAppData().getElement("LOGIN","Name"));
        }catch(Exception e){
            System.out.println(getAppData().getElement("LOGIN","NAME"));
            Assert.fail("Application launch failed " + e.getMessage());
            System.out.println("comment added by tushar");
            System.out.println("comment by Uma");
        }
    }
}