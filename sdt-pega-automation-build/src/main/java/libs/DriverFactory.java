package libs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.Automation105.ApplicationLaunch105;
import pageObjects.Automation105.EventInfoSections.*;
import pageObjects.Automation105.NonEmergency105;
import pageObjects.Automation105.WhatHappened105;
import pageObjects.Automation105.*;
import pageObjects.Automation105.EventInfoSections.EventInfo105;
import pageObjects.Automation105.EventInfoSections.EventInfoOffenderInformation105;
import pageObjects.Automation105.EventInfoSections.EventInfoLocation105;
import pageObjects.Automation105.EventInfoSections.EventInfoLost105;
import pageObjects.Automation105.EventInfoSections.EventInfoTimeOfIncident105;
import pageObjects.onlineReporting.ApplicationLaunch;
import pageObjects.onlineReporting.*;
import pageObjects.onlineReporting.EventInfoSections.*;
import persistence.ScenarioContext;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DriverFactory extends CommonMethods {

    protected static AppiumDriver _appiumDriver;
    protected static WebDriver _driver;
    protected static ApplicationLaunch _applicationLaunch;
    protected static ApplicationLaunch105 _applicationLaunch105;
    protected static NonEmergency _nonEmergency;
    protected static NonEmergency105 _nonEmergency105;
    protected static WhatHappened _whatHappened;
    protected static WhatHappened105 _whatHappened105;
    protected static EventInfo _eventInfo;
    protected static EventInfo105 _eventInfo105;
    protected static AddressManualEntry105 _addressManualEntry105;
    protected static EventInfoTimeOfIncident _eventTime;
    protected static EventInfoTimeOfIncident105 _eventTime105;
    protected static EventInfoLocationOfEvent _eventLocation;
    protected static EventInfoOffenderInformation105 _eventOffender105;
    protected static EventInfoLocation105 _eventLocation105;
    protected static EventInfoOffenderInformation _eventOffender;
    protected static EventInfoDamaged _eventDamaged;
    protected static EventInfoDamaged105 _eventDamaged105;
    protected static EventInfoStolen _eventStolen;
    protected static EventInfoStolen105 _eventStolen105;
    protected static EventInfoHurt _eventHurt;
    protected static EventInfoHurt105 _eventHurt105;
    protected static ContactDetails _contactDetails;
    protected static ReporterDetails105 _reporterDetails105;
    protected static OrganisationOwnerDetails105 _organisationOwnerDetails105;
    protected static SomebodyElseOwnerDetails105 _somebodyElseOwnerDetails105;
    protected static Summary _summary;
    protected static SummaryPage105 _summaryPage105;
    protected static Confirmation _confirmation;
    protected static ConfirmationPage105 _confirmationPage105;
    protected static ParseJSONData _parseJSONData;
    protected static RetrieveTestData _retrieveTestData;
    protected static GenerateTestData _generateTestData;
    protected static ScenarioContext _persistentData;
    protected static EventInfoLostItems _eventLost;
    protected static EventInfoLost105 _eventLost105;
    protected static EventInfoSomethingElse _eventSomethingElse;
    protected static AddressManualEntry _addressManualEntry;
    protected static Survey _survey;
    protected static SurveyPage105 _surveyPage105;
    protected static GenericControls _genericControls;
    protected static String _platFormName = "";
    private DesiredCapabilities _capabilities;
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
        if (getPropertyValue("EXECUTE_IN_BROWSERSTACK").equalsIgnoreCase("true")) {
            final String USERNAME = getBSPropertyValue("BROWSERSTACK_USERNAME"); //TODO : Temporary till we move things to OS
            final String ACCESS_KEY = getBSPropertyValue("BROWSERSTACK_TOKEN"); //TODO : Temporary till we move things to OS
            final String remoteURL = "https://" + USERNAME + ":" + ACCESS_KEY + getPropertyValue("BROWSERSTACK_URL");
            _capabilities = new DesiredCapabilities();
            executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
            try {
                String os = executionDeviceConfiguration.getDeviceParameters("OS");
                String osVersion = executionDeviceConfiguration.getDeviceParameters("OS_VERSION");
                String browserName = executionDeviceConfiguration.getDeviceParameters("BROWSER");
                String browserVersion = executionDeviceConfiguration.getDeviceParameters("BROWSER_VERSION");
                scenarios.setDeviceType("desktop");
                scenarios.setOs(os);
                scenarios.setOsVersion(osVersion);
                scenarios.setBrowser(browserName);
                scenarios.setBrowserVersion(browserVersion);
                _capabilities.setCapability("browser", browserName);
                _capabilities.setCapability("browser_version", browserVersion);
                _capabilities.setCapability("os", os);
                _capabilities.setCapability("os_version", osVersion);
                _capabilities.setCapability("browserstack.local", "false");
                _capabilities.setCapability("browserstack.debug", "true");
                _capabilities.setCapability("project", getPropertyValue("PROJECT_NAME") + "_" + getCurrentDate());
                if (getBuildNumber() == null) {
                    _capabilities.setCapability("build", executionDeviceConfiguration.getDeviceParameters("BROWSER") + "_" + executionDeviceConfiguration.getDeviceParameters("OS") + "_" + executionDeviceConfiguration.getDeviceParameters("OS_VERSION"));
                } else {
                    _capabilities.setCapability("build", "Build:" + getBuildNumber() + "_" + executionDeviceConfiguration.getDeviceParameters("BROWSER") + "_" + executionDeviceConfiguration.getDeviceParameters("OS") + "_" + executionDeviceConfiguration.getDeviceParameters("OS_VERSION"));
                }
                _capabilities.setCapability("name", testName);
                if (getPropertyValue("HEADLESS").equalsIgnoreCase("true")) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("HEADLESS");
                    _capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                }
                this._driver = new RemoteWebDriver(new URL(remoteURL), _capabilities);
                initializePageObjects();
            } catch (Exception e) {
                System.out.println("Unable to load browser: " + e.getMessage());
                System.exit(1);
            }
        } else {
            if (getPropertyValue("BROWSER").equalsIgnoreCase("chrome")) {
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

            }
            scenarios.setDeviceType("desktop");
            scenarios.setOs("mac");
            scenarios.setOsVersion("Mojave");
            scenarios.setBrowser("Chrome");
            scenarios.setBrowserVersion("75");
            try {
                this._driver = new RemoteWebDriver(new URL(getPropertyValue("selenium_local_server")), _capabilities);
            } catch (UnreachableBrowserException exception) {
                System.out.println("WebDriver creation failed. Possibly Remote webdriver endpoint is not configured properly. Check <IP>:4444/wd/hub endpoint");
                System.out.println(exception.getMessage());
                System.exit(1);
            }

            _driver.manage().window().maximize();

            initializePageObjects();
        }
        return _driver;
    }


    protected AppiumDriver getMobileDriver(String testName, String scenarioName) {
        tagName = scenarioName;
        if (getPropertyValue("EXECUTE_IN_BROWSERSTACK").equalsIgnoreCase("true")) {
            final String USERNAME = getBSPropertyValue("BROWSERSTACK_USERNAME"); //TODO : Temporary till we move things to OS
            final String ACCESS_KEY = getBSPropertyValue("BROWSERSTACK_TOKEN"); //TODO : Temporary till we move things to OS
            final String remoteURL = "https://" + USERNAME + ":" + ACCESS_KEY + getPropertyValue("BROWSERSTACK_URL");
            _capabilities = new DesiredCapabilities();
            //scenarios.setOsVersion(osVersion);
            //scenarios.setBrowser(browserName);
            //scenarios.setBrowserVersion(browserVersion);

            executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
            _capabilities.setCapability("os", executionDeviceConfiguration.getDeviceParameters("OS"));
            _capabilities.setCapability("device", executionDeviceConfiguration.getDeviceParameters("DEVICE"));
            _capabilities.setCapability("os_version", executionDeviceConfiguration.getDeviceParameters("OS_VERSION"));
            _capabilities.setCapability("browserstack.appium_version", executionDeviceConfiguration.getDeviceParameters("APPIUM_VERSION"));

            _platFormName = executionDeviceConfiguration.getDeviceParameters("OS");
            switch (_platFormName.toLowerCase()) {
                case "ios":
                    _capabilities.setCapability("automationName", "XCUITest");
                    break;
                case "android":
                    _capabilities.setCapability("automationName", "UiAutomator2");
                    break;
                default:
                    System.out.println("Invalid Device platform. Please check DEVICE_PLATFORM field in config.properties. Valid values : Android or ios");
                    System.exit(0);
            }
            try {
                _capabilities.setCapability("project", getPropertyValue("PROJECT_NAME") + "_" + getCurrentDate());
                //_capabilities.setCapability("build", getBuildNumber() + "_" + executionDeviceConfiguration.getDeviceParameters("DEVICE"));
                if (getBuildNumber() == null) {
                    _capabilities.setCapability("build", executionDeviceConfiguration.getDeviceParameters("DEVICE") + "_" + executionDeviceConfiguration.getDeviceParameters("OS") + "_" + executionDeviceConfiguration.getDeviceParameters("OS_VERSION"));
                } else {
                    _capabilities.setCapability("build", "Build:" + getBuildNumber() + "_" + executionDeviceConfiguration.getDeviceParameters("DEVICE") + "_" + executionDeviceConfiguration.getDeviceParameters("OS") + "_" + executionDeviceConfiguration.getDeviceParameters("OS_VERSION"));
                }

                _capabilities.setCapability("name", testName);
                ChromeOptions options = new ChromeOptions();
                if (getPropertyValue("HEADLESS").equalsIgnoreCase("true")) {
                    options.addArguments("HEADLESS");
                    _capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                }
                _appiumDriver = new AppiumDriver(new URL(remoteURL), _capabilities);
                initializePageObjects();
            } catch (Exception e) {
                System.out.println("Unable to load browser: " + e.getMessage());
                System.exit(0);
            }
        } else { //Local execution
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            scenarios.setDeviceType("desktop"); // this code is for elastic search reporting
            scenarios.setOs("mac");
            scenarios.setOsVersion("Mojave");
            scenarios.setBrowser("Chrome");
            scenarios.setBrowserVersion("75");
            _platFormName = getDevicePlatForm();

            switch (_platFormName.toLowerCase()) {
                case "ios":
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getIOSPlatFormName());
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getIOSPlatFormVersion());
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getIOSDeviceName());
                    desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, getIOSBrowserName());
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getIOSAutomationName());
                    desiredCapabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1");
                    break;
                case "android":
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getAndroidPlatFormName());
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getAndroidPlatFormVersion());
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getAndroidDeviceName());
                    desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
                    desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, getAndroidBrowserName());
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getAndroidAutomationName());
//                    desiredCapabilities.setCapability("autoGrantPermissions", true);
//                    desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
                    break;
                default:
                    System.out.println("Invalid Device platform. Please check DEVICE_PLATFORM field in config.properties. Valid values : Android or ios");
                    System.exit(0);
            }
            if (getPropertyValue("HEADLESS").equalsIgnoreCase("true")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("HEADLESS");
            }
            try {
                this._appiumDriver = new AppiumDriver(new URL(getPropertyValue("appium_local_server")), desiredCapabilities);
            } catch (UnreachableBrowserException | MalformedURLException exception) {
                System.out.println("WebDriver creation failed. Possibly Remote webdriver endpoint is not configured properly. Check <IP>:4444/wd/hub endpoint");
                System.out.println(exception.getMessage());
                System.exit(0);
            }
            initializePageObjects();
        }
        return _appiumDriver;
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
                _applicationLaunch = PageFactory.initElements(_driver, ApplicationLaunch.class);
                _applicationLaunch105 = PageFactory.initElements(_driver, ApplicationLaunch105.class);
                _nonEmergency = PageFactory.initElements(_driver, NonEmergency.class);
                _nonEmergency105 = PageFactory.initElements(_driver, NonEmergency105.class);
                _whatHappened = PageFactory.initElements(_driver, WhatHappened.class);
                _whatHappened105 = PageFactory.initElements(_driver, WhatHappened105.class);
                _eventInfo = PageFactory.initElements(_driver, EventInfo.class);
                _eventInfo105 = PageFactory.initElements(_driver, EventInfo105.class);
                _eventTime = PageFactory.initElements(_driver, EventInfoTimeOfIncident.class);
                _eventTime105 = PageFactory.initElements(_driver, EventInfoTimeOfIncident105.class);
                _eventLocation = PageFactory.initElements(_driver, EventInfoLocationOfEvent.class);
                _eventOffender = PageFactory.initElements(_driver, EventInfoOffenderInformation.class);
                _eventOffender105 = PageFactory.initElements(_driver, EventInfoOffenderInformation105.class);
                _eventLocation105 = PageFactory.initElements(_driver, EventInfoLocation105.class);
                _eventOffender = PageFactory.initElements(_driver, pageObjects.onlineReporting.EventInfoSections.EventInfoOffenderInformation.class);
                _eventDamaged = PageFactory.initElements(_driver, EventInfoDamaged.class);
                _eventDamaged105 = PageFactory.initElements(_driver, EventInfoDamaged105.class);
                _eventStolen = PageFactory.initElements(_driver, EventInfoStolen.class);
                _eventStolen105 = PageFactory.initElements(_driver, EventInfoStolen105.class);
                _eventHurt = PageFactory.initElements(_driver, EventInfoHurt.class);
                _eventHurt105 = PageFactory.initElements(_driver, EventInfoHurt105.class);
                _contactDetails = PageFactory.initElements(_driver, ContactDetails.class);
                _reporterDetails105 = PageFactory.initElements(_driver, ReporterDetails105.class);
                _organisationOwnerDetails105 = PageFactory.initElements(_driver, OrganisationOwnerDetails105.class);
                _somebodyElseOwnerDetails105 = PageFactory.initElements(_driver, SomebodyElseOwnerDetails105.class);
                _summary = PageFactory.initElements(_driver, Summary.class);
                _summaryPage105 = PageFactory.initElements(_driver, SummaryPage105.class);
                _confirmation = PageFactory.initElements(_driver, Confirmation.class);
                _confirmationPage105 = PageFactory.initElements(_driver, ConfirmationPage105.class);
                _eventLost = PageFactory.initElements(_driver, EventInfoLostItems.class);
                _eventLost105 = PageFactory.initElements(_driver, EventInfoLost105.class);
                _eventSomethingElse = PageFactory.initElements(_driver, EventInfoSomethingElse.class);
                _addressManualEntry = PageFactory.initElements(_driver, AddressManualEntry.class);
                _addressManualEntry105 = PageFactory.initElements(_driver, AddressManualEntry105.class);
                _survey = PageFactory.initElements(_driver, Survey.class);
                _surveyPage105 = PageFactory.initElements(_driver, SurveyPage105.class);
                _genericControls = PageFactory.initElements(_driver, GenericControls.class);
            } catch (Exception e) {
                Assert.assertTrue(false, "Page object initialization failed");
            } finally {
                _parseJSONData = new ParseJSONData();
                _retrieveTestData = new RetrieveTestData(tagName);
                _persistentData = new ScenarioContext();
                _generateTestData = new GenerateTestData(_persistentData);
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