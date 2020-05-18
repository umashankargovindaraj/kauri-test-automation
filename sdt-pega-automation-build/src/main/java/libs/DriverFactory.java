package libs;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.BeforeSchool.*;
import persistence.ScenarioContext;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DriverFactory extends CommonMethods {

    protected static WebDriver _driver;
    protected static ApplicationData appData;
    protected static LoginPage _loginPage;
    protected static SearchPage _SearchPage;
    protected static CreateChildPage _CreateChildPage;  /* create object for the page */
    protected static ConsentPage _ConsentPage;
    protected static CareGiverPage _CareGiverPage;
    protected static ChildHealthCheckPage _ChildHealthCheckPage;
    protected static DentalCheckPage _DentalCheckPage;
    protected static GrowthCheckPage _GrowthCheckPage;
    protected static ImmunisationCheckPage _ImmunisationCheckPage;
    protected static PEDSPage _PEDSPage;
    protected static SDQParentPage _SDQParentPage;
    protected static SDQTeacherPage _SDQTeacherPage;
    protected static VisionAndHearingCheckPage _VisionAndHearingCheckPage;
    protected static HearingPage _HearingPage;
    protected static DistanceVisionPage _DistanceVisionPage;
    protected static ClosingB4SchoolChildRecordPage _ClosingB4SchoolChildRecordPage;
    private DesiredCapabilities _capabilities;
    protected static  ScenarioContext _persistentData;
    protected static ParseJSONData _parseJSONData;
    protected static GenerateTestData _generateTestData;
    protected static DentalReferralPage _DentalReferralPage;
    protected static VisionReferralPage _VisionReferralPage;
    protected static ReturnChildToCoordinatorPage _ReturnChildToCoordinatorPage;
    protected static DocumentsPage _DocumentsPage;
    protected static ExportPage _ExportPage;
    protected static AddEventPage _AddEventPage;
    public Scenarios scenarios;
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
                System.setProperty("webdriver.chrome.driver",getPropertyValue("driverPath"));
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


    // get reference to the ApplicationData class.
    public ApplicationData getAppData()
    {
        return appData;
    }

    /**
     * Initialize PageObjects here.
     * Any new Page object that gets created should be initialised here.
     */
    public void initializePageObjects() {
        if (_driver != null) {
            try {
                appData = new ApplicationData();
                _loginPage = PageFactory.initElements(_driver,LoginPage.class);
                _SearchPage= PageFactory.initElements(_driver,SearchPage.class);
                _CareGiverPage=PageFactory.initElements(_driver,CareGiverPage.class);
                _ChildHealthCheckPage=PageFactory.initElements(_driver,ChildHealthCheckPage.class);
                _ClosingB4SchoolChildRecordPage=PageFactory.initElements(_driver,ClosingB4SchoolChildRecordPage.class);
                _ConsentPage=PageFactory.initElements(_driver,ConsentPage.class);
                _CreateChildPage=PageFactory.initElements(_driver,CreateChildPage.class);
                _DentalCheckPage=PageFactory.initElements(_driver,DentalCheckPage.class);
                _DistanceVisionPage=PageFactory.initElements(_driver,DistanceVisionPage.class);
                _GrowthCheckPage=PageFactory.initElements(_driver,GrowthCheckPage.class);
                _HearingPage=PageFactory.initElements(_driver,HearingPage.class);
                _ImmunisationCheckPage=PageFactory.initElements(_driver,ImmunisationCheckPage.class);
                _PEDSPage=PageFactory.initElements(_driver,PEDSPage.class);
                _SDQParentPage=PageFactory.initElements(_driver,SDQParentPage.class);
                _SDQTeacherPage=PageFactory.initElements(_driver,SDQTeacherPage.class);
                _VisionAndHearingCheckPage=PageFactory.initElements(_driver,VisionAndHearingCheckPage.class);
                _DentalReferralPage=PageFactory.initElements(_driver, DentalReferralPage.class);
                _VisionReferralPage=PageFactory.initElements(_driver,VisionReferralPage.class);
                _ReturnChildToCoordinatorPage=PageFactory.initElements(_driver,ReturnChildToCoordinatorPage.class);
                _DocumentsPage=PageFactory.initElements(_driver,DocumentsPage.class);
                _ExportPage=PageFactory.initElements(_driver,ExportPage.class);
                _AddEventPage=PageFactory.initElements(_driver,AddEventPage.class);
            } catch (Exception e) {
                Assert.assertTrue(false, "Page object initialization failed");
            } finally {
//                _parseJSONData = new ParseJSONData();
                //_retrieveTestData = new RetrieveTestData(tagName);

                _persistentData = new ScenarioContext();
                _generateTestData = new GenerateTestData(_persistentData);
            }
        }
    }

   /* public String getOperatingSystem() {
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
    }*/

    /*public String getOSVersion() {
        if (System.getProperty("OS_VERSION") != null) {
            return System.getProperty("OS_VERSION");
        } else {
            if (_platFormName.equalsIgnoreCase("android")) {
                return getPropertyValue("OS_VERSION_ANDROID");

            } else {
                return getPropertyValue("OS_VERSION");
            }
        }
    }*/

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

    /*public String getAppiumVersion() {
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

    }*/

   /* public String getDevice() {
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
    }*/

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