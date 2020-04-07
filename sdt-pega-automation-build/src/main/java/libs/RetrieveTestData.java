package libs;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.google.gson.JsonArray;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.MapFunction;
import org.openqa.selenium.json.Json;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static libs.DriverFactory._persistentData;


public class RetrieveTestData extends CommonMethods {

    private static String jsonStr;
    private static Object jsonObj = "";
    private static String jsonPegaStr;
    private static Object jsonPegaObj = "";


    public RetrieveTestData(String testDataJsonObject) {
        if (testDataJsonObject.equals("")) {
            Assert.fail("Scenario name is not mentioned in feature file as tag. Failing the test case");
        }
        String folderDirectory = getPropertyValue("Automation105_data");
        String filePath = System.getProperty("user.dir") + folderDirectory + testDataJsonObject + ".json";
        String filePathPega = System.getProperty("user.dir") + folderDirectory + testDataJsonObject + "_PegaXPath.json";

        try {
            jsonStr = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            System.out.println("Data file not found File not found. File : " + filePath);
            Assert.fail("Data file not found File not found. File : " + filePath);
        }

        try {
            jsonObj = Configuration.defaultConfiguration().jsonProvider().parse(jsonStr);
        } catch (Exception e) {
            System.out.println("Data json file parsing failed : " + filePath);
            Assert.fail("Data json file parsing failed : " + filePath);
        }

        try {
            jsonPegaStr = new String(Files.readAllBytes(Paths.get(filePathPega)));
        } catch (Exception e) {
            System.out.println("Pega xpath file not found File not found. File : " + filePathPega);
            Assert.fail("Pega xpath file not found File not found. File : " + filePathPega);
        }

        try {
            jsonPegaObj = Configuration.defaultConfiguration().jsonProvider().parse(jsonPegaStr);
        } catch (Exception e) {
            System.out.println("Pega xpath json file parsing failed : " + filePathPega);
            Assert.fail("Pega xpath json file parsing failed : " + filePathPega);
        }
    }

    public Map<String,String> extractPegaAPIDataXPath() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        try{
            JsonNode root = mapper.readTree(jsonStr);
            addKeys("", root, map, new ArrayList<>());
        }catch (Exception e){
            Assert.fail("Reading Test Data File failed : Please check file path or file name");
        }
        return map;
    }

    public String extractPegaDataXpath(String jsonXpath){
        String testData = "";
        try {
            testData = JsonPath.parse(jsonPegaObj).read(jsonXpath);
            if (testData == null) {
                Assert.fail("Test Data retrieval from json object failed. Possibility invalid:: Xpath => " + jsonXpath);
            }
        } catch (Exception e) {
            Assert.fail("Test Data retrieval from json object failed. Possibility invalid:: Xpath => " + jsonXpath);
        }
        return testData.trim();

    }

    public String extractDataOffDataFile(String jsonXpath) {
        String testData = "";
        try {
            testData = JsonPath.parse(jsonObj).read(jsonXpath);
            if (testData == null) {
                Assert.fail("Test Data retrieval from json object failed. Possibility invalid:: Xpath => " + jsonXpath);
            }
            _persistentData.setContext(jsonXpath, testData);
        } catch (Exception e) {
            Assert.fail("Test Data retrieval from json object failed. Possibility invalid:: Xpath => " + jsonXpath);
        }
        return testData.trim();
    }

    public String extractDataOffDataFile(String jsonXpath, boolean quitWhenDataNotFound) {
        String testData = "";
        try {
            testData = JsonPath.parse(jsonObj).read(jsonXpath);
            if (quitWhenDataNotFound) {
                Assert.fail("Test Data retrieval from json object failed. Possibility invalid:: Xpath => " + jsonXpath);
            }
            _persistentData.setContext(jsonXpath, testData);
        } catch (Exception e) {
            if (quitWhenDataNotFound) {
                Assert.fail("Test Data retrieval from json object failed. Possibility invalid:: Xpath => " + jsonXpath);
            } else {
                System.out.println("Field in data file not found. Hence the field : " + jsonXpath + " will be ignored");
            }

        }
        return testData.trim();
    }

    private void addKeys(String currentPath, JsonNode jsonNode, Map<String, String> map, List<Integer> suffix) {
        if (jsonNode.isObject()) {
            ObjectNode objectNode = (ObjectNode) jsonNode;
            Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields();
            String pathPrefix = currentPath.isEmpty() ? "" : currentPath + ".";

            while (iter.hasNext()) {
                Map.Entry<String, JsonNode> entry = iter.next();
                addKeys(pathPrefix + entry.getKey(), entry.getValue(), map, suffix);
            }
        } else if (jsonNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) jsonNode;

            for (int i = 0; i < arrayNode.size(); i++) {
                suffix.add(i + 1);
                addKeys(currentPath, arrayNode.get(i), map, suffix);

                if (i + 1 <arrayNode.size()){
                    suffix.remove(arrayNode.size() - 1);
                }
            }

        } else if (jsonNode.isValueNode()) {
            if (currentPath.contains("-")) {
                for (int i = 0; i < suffix.size(); i++) {
                    currentPath += "." + suffix.get(i);
                }

                suffix = new ArrayList<>();
            }

            ValueNode valueNode = (ValueNode) jsonNode;
            map.put(currentPath, valueNode.asText());
        }
    }
}
