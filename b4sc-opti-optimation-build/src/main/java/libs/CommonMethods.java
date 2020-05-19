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

    public String getPropertyValue(String key) {
        String value = null;
        try {
            value = prop.getProperty(key).trim();
        } catch (Exception e) {
            functionThrowAssertMessage("Property value : " + key + " not found in the file. Please check configuration/config.properties file");
        }
        return value;
    }

    public void functionThrowAssertMessage(String message) {
        Assert.assertTrue(false, message);
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

}
