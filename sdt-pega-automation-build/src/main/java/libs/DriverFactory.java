package libs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.BeforeSchool.LoginPage;
import persistence.ScenarioContext;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DriverFactory extends CommonMethods {

    protected static AppiumDriver _appiumDriver;
    protected static WebDriver _driver;
    protected static LoginPage _loginPage;
    protected static String _platFormName = "";
    private DesiredCapabilities _capabilities;
    protected static  ScenarioContext _persistentData;
    public Scenarios scenarios;
    protected static ExecutionDeviceConfiguration executionDeviceConfiguration;
    protected static String tagName = "";
    protected static Environment testEnvironment;

    public DriverFactory() {
        super();
        scenarios = new Scenarios();
        ConfigFactory.setProperty("env", getPropertyValue("ENVIRONMENT"));
        testEnvironment = ConfigFactory.create(Environment.class);
    }


    protected WebDriver getWebDriver(String testName, String scenarioName) throws MalformedURLException {
        tagName = scenarioName;
           /* if (getPropertyValue("BROWSER").equalsIgnoreCase("chrome")) {
                new DesiredCapabilities();
                _capabilities = DesiredCapabilities.chrome();
            } else if (getPropertyValue("BROWSER").equalsIgnoreCase("firefox")) {
                new DesiredCapabilities();
                _capabilities = DesiredCapabilities.firefox();
            } else {
                new DesiredCapabilities();
                _capabilities = DesiredCapabilities.chrome();
            }

            if (getPropertyValue("HEADLESS").equalsIgnoreCase("true")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("HEADLESS");
                _capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            }*/
            /*scenarios.setDeviceType("desktop");
            scenarios.setOs("mac");
            scenarios.setOsVersion("Mojave");
            scenarios.setBrowser("Chrome");
            scenarios.setBrowserVersion("75");*/
            try {
                //this._driver = new RemoteWebDriver(new URL(getPropertyValue("selenium_local_server")), _capabilities);
                System.setProperty("webdriver.chrome.driver","C:\\Users\\umashankar\\Downloads\\chromedriver_win32\\chromedriver.exe");
                this._driver = new ChromeDriver();
            } catch (UnreachableBrowserException exception) {
                System.out.println("WebDriver creation failed. Possibly Remote webdriver endpoint is not configured properly. Check <IP>:4444/wd/hub endpoint");
                System.out.println(exception.getMessage());
                System.exit(1);
            }

            _driver.manage().window().maximize();
            initializePageObjects();

        return _driver;
    }



    /**
     * Initialize PageObjects here.
     * Any new Page object that gets created should be initialised here.
     */
    public void initializePageObjects() {
        if (_appiumDriver != null) {
            _driver = _appiumDriver;
        }
        if (_driver != null) {
            try {
                _loginPage = PageFactory.initElements(_driver,LoginPage.class);
            } catch (Exception e) {
                Assert.assertTrue(false, "Page object initialization failed");
            } finally {
                //_parseJSONData = new ParseJSONData();
                //_retrieveTestData = new RetrieveTestData(tagName);
                _persistentData = new ScenarioContext();
                //_generateTestData = new GenerateTestData(_persistentData);
            }
        }
    }

    public String getOperatingSystem() {
        if (System.getProperty("OS") != null) {
            if (System.getProperty("OS").equalsIgnoreCase("mac")) {
                return "OS X";
            } else {
                return System.getProperty("OS");
            }
        } else {
            if (_platFormName.equalsIgnoreCase("android")) {
                return getPropertyValue("OS_ANDROID");
            } else {
                return getPropertyValue("OS");
            }
        }
    }

    public String getOSVersion() {
        if (System.getProperty("OS_VERSION") != null) {
            return System.getProperty("OS_VERSION");
        } else {
            if (_platFormName.equalsIgnoreCase("android")) {
                return getPropertyValue("OS_VERSION_ANDROID");

            } else {
                return getPropertyValue("OS_VERSION");
            }
        }
    }

    public String getBrowserName() {
        if (System.getProperty("BROWSER_NAME") != null) {
            return System.getProperty("BROWSER_NAME");
        } else {
            return getPropertyValue("BROWSER_NAME");
        }
    }

    public String getBrowserVersion() {
        if (System.getProperty("BROWSER_VERSION") != null) {
            return System.getProperty("BROWSER_VERSION");
        } else {
            return getPropertyValue("BROWSER_VERSION");
        }
    }

    public String getLocalTestingFlag() {
        if (System.getProperty("LOCAL_TESTING") != null) {
            return System.getProperty("LOCAL_TESTING");
        } else {
            return getPropertyValue("LOCAL_TESTING");
        }
    }

    public String getBuildNumber() {
        System.out.println("Current jenkins build number : " + System.getProperty("JENKINS_BUILD"));
        return System.getProperty("JENKINS_BUILD");

    }


    public String getDeviceType() {
        if (System.getProperty("DEVICETYPE") != null) {
            System.out.println(System.getProperty("DEVICETYPE"));
            return System.getProperty("DEVICETYPE");
        } else {
            return getPropertyValue("deviceType");
        }
    }

    public String getAppiumVersion() {
        if (System.getProperty("APPIUM_VERSION") != null) {
            System.out.println(System.getProperty("APPIUM_VERSION"));
            return System.getProperty("APPIUM_VERSION");
        } else {
            if (_platFormName.equalsIgnoreCase("android")) {
                return getPropertyValue("APPIUM_VERSION_ANDROID");
            } else {
                return getPropertyValue("APPIUM_VERSION");
            }
        }

    }

    public String getDevice() {
        if (System.getProperty("DEVICE") != null) {
            System.out.println(System.getProperty("DEVICE"));
            return System.getProperty("DEVICE");
        } else {
            if (_platFormName.equalsIgnoreCase("android")) {
                return getPropertyValue("DEVICE_ANDROID");
            } else {
                return getPropertyValue("DEVICE");
            }
        }
    }

    public String getDevicePlatForm() {
        if (System.getProperty("DEVICE_PLATFORM") != null) {
            System.out.println(System.getProperty("DEVICE_PLATFORM"));
            return System.getProperty("DEVICE_PLATFORM");
        } else {
            return getPropertyValue("DEVICE_PLATFORM");
        }
    }

    public String getIOSPlatFormName() {
        if (System.getProperty("IOS_PLATFORM_NAME") != null) {
            System.out.println(System.getProperty("IOS_PLATFORM_NAME"));
            return System.getProperty("IOS_PLATFORM_NAME");
        } else {
            return getPropertyValue("IOS_PLATFORM_NAME");
        }
    }

    public String getIOSPlatFormVersion() {
        if (System.getProperty("IOS_PLATFORM_VERSION") != null) {
            System.out.println(System.getProperty("IOS_PLATFORM_VERSION"));
            return System.getProperty("IOS_PLATFORM_VERSION");
        } else {
            return getPropertyValue("IOS_PLATFORM_VERSION");
        }
    }

    public String getIOSDeviceName() {
        if (System.getProperty("IOS_DEVICE_NAME") != null) {
            System.out.println(System.getProperty("IOS_DEVICE_NAME"));
            return System.getProperty("IOS_DEVICE_NAME");
        } else {
            return getPropertyValue("IOS_DEVICE_NAME");
        }
    }

    public String getIOSBrowserName() {
        if (System.getProperty("IOS_BROWSER_NAME") != null) {
            System.out.println(System.getProperty("IOS_BROWSER_NAME"));
            return System.getProperty("IOS_BROWSER_NAME");
        } else {
            return getPropertyValue("IOS_BROWSER_NAME");
        }
    }

    public String getIOSAutomationName() {
        if (System.getProperty("IOS_AUTOMATION_NAME") != null) {
            System.out.println(System.getProperty("IOS_AUTOMATION_NAME"));
            return System.getProperty("IOS_AUTOMATION_NAME");
        } else {
            return getPropertyValue("IOS_AUTOMATION_NAME");
        }
    }

    public String getAndroidPlatFormName() {
        if (System.getProperty("ANDROID_PLATFORM_NAME") != null) {
            System.out.println(System.getProperty("ANDROID_PLATFORM_NAME"));
            return System.getProperty("ANDROID_PLATFORM_NAME");
        } else {
            return getPropertyValue("ANDROID_PLATFORM_NAME");
        }
    }

    public String getAndroidPlatFormVersion() {
        if (System.getProperty("ANDROID_PLATFORM_VERSION") != null) {
            System.out.println(System.getProperty("ANDROID_PLATFORM_VERSION"));
            return System.getProperty("ANDROID_PLATFORM_VERSION");
        } else {
            return getPropertyValue("ANDROID_PLATFORM_VERSION");
        }
    }

    public String getAndroidDeviceName() {
        if (System.getProperty("ANDROID_DEVICE_NAME") != null) {
            System.out.println(System.getProperty("ANDROID_DEVICE_NAME"));
            return System.getProperty("ANDROID_DEVICE_NAME");
        } else {
            return getPropertyValue("ANDROID_DEVICE_NAME");
        }
    }

    public String getAndroidBrowserName() {
        if (System.getProperty("ANDROID_BROWSER_NAME") != null) {
            System.out.println(System.getProperty("ANDROID_BROWSER_NAME"));
            return System.getProperty("ANDROID_BROWSER_NAME");
        } else {
            return getPropertyValue("ANDROID_BROWSER_NAME");
        }
    }

    public String getAndroidAutomationName() {
        if (System.getProperty("ANDROID_AUTOMATION_NAME") != null) {
            System.out.println(System.getProperty("ANDROID_AUTOMATION_NAME"));
            return System.getProperty("ANDROID_AUTOMATION_NAME");
        } else {
            return getPropertyValue("ANDROID_AUTOMATION_NAME");
        }
    }

    public String getDeviceKey() {
        System.out.println("*******GETTING DEVICE KEY*******");
        if (System.getProperty("DEVICE_KEY") != null) {
            System.out.println("*******DEVICE KEY FROM SYSTEM IS : " + System.getProperty("DEVICE_KEY"));
            return System.getProperty("DEVICE_KEY");
        } else {
            System.out.println("***************SYSTEM DEVICE KEY IS NULL*******************");
            return getPropertyValue("DEVICE_KEY");
        }
    }

    public String getCurrentDate() {
        String pattern = "dd_MM_yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
        String date = simpleDateFormat.format(new Date());
        return date;
    }
}