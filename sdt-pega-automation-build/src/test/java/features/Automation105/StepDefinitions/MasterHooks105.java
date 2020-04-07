package features.Automation105.StepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import cucumber.api.Result;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import libs.DriverFactory;
import libs.ResultScenarioPOJO;
import libs.ResultSender;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MasterHooks105 extends DriverFactory {

    private ResultSender resultSender;
    private static ObjectMapper mapper = new ObjectMapper();
    private static Map<String, ResultScenarioPOJO> resultMap = new HashMap<>();
    private static String scenarioName;
    private static FileWriter file;
    private static Scenario cukeScenario;


    @Before
    public void setup(Scenario cukeScenarioObj) throws IOException {
        cukeScenario = cukeScenarioObj;
        boolean tagFound = false;
        for (String tag : cukeScenario.getSourceTagNames()) {
            if (tag.toLowerCase().contains("scenario_")) {
                scenarioName = tag.substring(1);
                tagFound = true;
            }
        }
        if (!tagFound) {
            System.out.println("Scenario tag not set. Please set a tag '@Scenario_<scenarioName> for the scenario");
            System.exit(1);
        }
        _driver = getWebDriver(cukeScenario.getName(), scenarioName);
        _persistentData.setContext("testCase", scenarioName);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    @After
    public void tearDownAndScreenShotOnFailure(cucumber.api.Scenario cukeScenario) throws IOException {
        resultSender = new ResultSender();
        scenarios.setScenarioName(cukeScenario.getName());
        //sessionStatus(cukeScenario.isFailed());
        try {
            if (_driver != null && cukeScenario.isFailed()) {
                cukeScenario.embed(((TakesScreenshot) _driver).getScreenshotAs(OutputType.BYTES), "image/png");
                scenarios.setTestStatus("Fail");
            } else if (!cukeScenario.isFailed()) {
                scenarios.setTestStatus("Pass");
            }
            if (_driver != null) {
                _driver.manage().deleteAllCookies();
                _driver.quit();
                _appiumDriver.quit();
                _driver = null;
                _appiumDriver = null;
            }
            deleteTestFiles();
        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenShotOnFailure, Exception: " + e.getMessage());
        }
        resultMap.put(scenarioName, testResultJsonGenerator());
        //resultSender.sendResultsToElasticSearch(getPropertyValue("elasticSearch"), scenarios);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                writeResultsToJsonFile();
            }
        });

    }


    public void sessionStatus(boolean hasTestFailed) {
        SessionId session = null;
        if (_driver instanceof RemoteWebDriver) {
            session = ((RemoteWebDriver) _driver).getSessionId();
        }
        String url = getPropertyValue("browserStack").replace("<session>", session.toString());
        String status = "passed";
        String reason = "Test Passed";
        if (hasTestFailed) {
            status = "failed";
            reason = "Test Failed";
        }
        resultSender.sendResultsToBrowserStack(url, status, reason, getBSPropertyValue("BROWSERSTACK_USERNAME"), getBSPropertyValue("BROWSERSTACK_TOKEN"));
    }

    public ResultScenarioPOJO testResultJsonGenerator() {
        ResultScenarioPOJO resultScenarioPOJO = new ResultScenarioPOJO();
        resultScenarioPOJO.setReferenceNumber((String) _persistentData.getContext("ReferenceNumber"));
        resultScenarioPOJO.setScenarioName(cukeScenario.getName());
        resultScenarioPOJO.setTestStatus(cukeScenario.getStatus().toString());
        if (cukeScenario.isFailed()) {
            String errorMessage = getTestErrorMessage();
            System.out.println(errorMessage);
            resultScenarioPOJO.setErrorMessage(errorMessage);
        }
        return resultScenarioPOJO;
    }

    public String getTestErrorMessage() {
        Field field = FieldUtils.getField(cukeScenario.getClass(), "stepResults", true);
        field.setAccessible(true);
        try {
            ArrayList<Result> results = (ArrayList<Result>) field.get(cukeScenario);
            for (Result result : results) {
                if (result.getError() != null) {
                    return result.getError().toString();
                }
            }
        } catch (Exception e) {
            System.out.println("Error while logging error" + e);
        }
        return "";
    }

    public void writeResultsToJsonFile() {
        String timeStamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
        FileWriter file = null;
        String reportFileName = null;
        try {
            File folder = new File(System.getProperty("user.dir") + "/TestResults");
            if (!folder.exists()) {
                folder.mkdir();
            }
            reportFileName = System.getProperty("user.dir") + "/TestResults/RunResults_" + timeStamp + ".json";
            file = new FileWriter(reportFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mapper.writeValue(file, resultMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Result file is available in the location: " + reportFileName);
    }
}
