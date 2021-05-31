package libs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class CommonMethods {
    final String configFilePath = "configuration/config.properties";

    private Properties prop = null;
    private Properties content = null;
    private ObjectMapper mapper;
    private static JsonNode node;
    private Properties propBS = null; //TODO : Temporary till we move things to OS

    public CommonMethods() {
        initPropertyFiles();
        mapper = new ObjectMapper();
    }

    public void initPropertyFiles() {
        try (InputStream input = new FileInputStream(configFilePath)) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            functionThrowAssertMessage("Property file loading failed. Please check configuration directory");
        }
    }


    public void initDataFiles(String feature, String fileName) {
        String fileNameUpdated = "src/main/resources/" + feature + "/" + fileName;
        try {
            node = mapper.readTree(new File(fileNameUpdated));
        } catch (JsonProcessingException e) {
            Assert.assertTrue(false, "Json data file not found at the location: " + fileNameUpdated);
        } catch (IOException e) {
            Assert.assertTrue(false, "Json data file not found at the location: " + fileNameUpdated);
        }
    }

    public String getPropertyValue(String key) {
        String value = null;
        try {
            value = prop.getProperty(key).trim();
        } catch (Exception e) {
            functionThrowAssertMessage("Property value : " + key + " not found in the file. Please check configuration/config.properties file");
        }
        return value;
    }

    public String getContentData(String key) {
        String value = content.getProperty(key).trim();
        if (value.equalsIgnoreCase(null) || value.equalsIgnoreCase("")) {
            functionThrowAssertMessage("Content request not found in src/test/resources/dataDictionary/content.properties file");
        }
        return value;
    }

    public void functionThrowAssertMessage(String message) {
        Assert.assertTrue(false, message);
    }

    public JsonNode getJsonNode() {
        return node;
    }


    public void loadJsonDataFiles(String feature, String filename) {
        initDataFiles(feature, filename);
    }

    public JsonNode getDataObject(String data) {
        String[] dataString = data.split("~~");
        Assert.assertEquals(dataString.length, 3, "Check whether data string in feature file is in the format => <featureName>~~<fileName>~~<jsonobjectname>");
        String feature = dataString[0];
        String fileName = dataString[1];
        String object = dataString[2];
        loadJsonDataFiles(feature, fileName);
        JsonNode jsonNode = getJsonNode().get(object);
        Assert.assertNotNull(jsonNode, "Json test data file \"" + fileName + "\" does contain object \"" + object + "\" in the feature \"" + feature + "\". Check the file again!");
        return jsonNode;
    }

    public String getDataFromJson(JsonNode jsonData, String fieldName) {
        String data = null;
        try {
            data = jsonData.path(fieldName).textValue().trim();
        } catch (NullPointerException e) {
            Assert.assertTrue(false, "Data looked up on test data json file not present. Data searched : " + fieldName);
        }
        return data;
    }

    public String getRandomValueFromList(String listValueFromJson) {
        String[] reporterGenderList = getListOfDropDownValueFromJson(listValueFromJson);
        String values;
        if (reporterGenderList.length > 0) {
            Random r = new Random();
            int low = 1;
            int high = reporterGenderList.length;
            int result = r.nextInt(high - low) + low;
            values = reporterGenderList[result];
        } else {
            values = reporterGenderList[0];
        }
        return values;
    }

    public String[] getListOfDropDownValueFromJson(String dropDownDataFromJson) {
        String[] dropDownValues = dropDownDataFromJson.split(Pattern.quote("|"));
        if (!(dropDownValues.length > 1)) {
            Assert.assertTrue(false, "Automation configuration error. A string of values seperated by '|' expected. But did not find any in JSON data file. Please check");
        }
        return dropDownValues;

    }

    public void generateFilesTypesAndSize(String fileName, String fileExtension, int fileSize) {
        String rootDirectory = System.getProperty("user.dir");
        String fileDirectory = rootDirectory + "/files/";
        File folder = new File(fileDirectory);
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file = new File(fileDirectory + "/" + fileName + "." + fileExtension);
        RandomAccessFile rafile;
        try {
            rafile = new RandomAccessFile(file, "rw");
            rafile.setLength(fileSize);
            System.out.println("File name generated : " + fileName + "." + fileExtension);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTestFiles() {
        try {
            FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "/files"));
        } catch (IOException e) {
            System.out.println("Directory not found to clear");
        }
    }

    public String formatDate(String currentFormat, String expectedFormat, String data) {
        String formattedStartDate = null;
        try {
            Date parsedStartDate = new SimpleDateFormat(currentFormat).parse(data);
            formattedStartDate = new SimpleDateFormat(expectedFormat).format(parsedStartDate);
        } catch (Exception e) {
            System.out.println("Date formatting failed");
        }
        return formattedStartDate;
    }

    public String addOrSubtractDaysFromToday(String operation, int days) {
        Calendar cal = Calendar.getInstance();
        switch (operation.toUpperCase()) {
            case "ADD":
                break;
            case "SUB":
                cal.add(Calendar.DATE, -days);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(cal.getTime());
    }

    public void pollForConfirmationEmailToTheReporter(String referenceNumber) throws Exception {
        FetchEmail fetchEmail = new FetchEmail();
        fetchEmail.setUserPass("sdtdt.automation@gmail.com", "automation123*");
        fetchEmail.connect();
        fetchEmail.pollGmailForConfirmationEmail(referenceNumber);
    }

    public String getCurrentDateParts(String expectedFormat) {
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        String date = new SimpleDateFormat().format(currentDate);
        return formatDate("dd/MM/yy HH:mm a", expectedFormat, date);
    }

    public String getfutureYear(int value) {
        return String.valueOf(Integer.valueOf(getCurrentDateParts("yyyy")) + value);
    }

    public String getCurrentIP() throws IOException {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));
        String ip = in.readLine();
        return ip;
    }

    public String getFormattedCurrentDate(String datePattern) {
        String date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
            date = simpleDateFormat.format(new Date());
        } catch (Exception e) {
            System.out.println("Exception in converting date into format. Date pattern : " + datePattern);
        }
        return date;
    }

    //TODO : Temporary till we move things to OS
    public void initBSPropertyFiles() {
        try (InputStream input = new FileInputStream(getPropertyValue("BROWSERSTACK_LOGIN"))) {
            propBS = new Properties();
            propBS.load(input);
        } catch (IOException ex) {
            functionThrowAssertMessage("Property file loading failed. Please check configuration directory");
        }
    }

    //TODO : Temporary till we move things to OS
    public String getBSPropertyValue(String key) {
        String value = null;
        try {
            value = propBS.getProperty(key).trim();
        } catch (Exception e) {
            functionThrowAssertMessage("Property value : " + key + " not found in the file. Please check configuration/config.properties file");
        }
        return value;
    }

}
