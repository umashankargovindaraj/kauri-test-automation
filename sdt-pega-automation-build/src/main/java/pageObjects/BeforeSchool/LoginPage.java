package pageObjects.BeforeSchool;

import libs.BasePage;

import java.io.IOException;

public class LoginPage extends BasePage {

    public void launchApplication() throws IOException {
        loadUrl(testEnvironment.getAppURL());
    }

}