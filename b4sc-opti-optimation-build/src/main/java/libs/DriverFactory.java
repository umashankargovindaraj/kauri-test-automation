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
                _persistentData = new ScenarioContext();
            }
        }
    }

}