package libs;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParseJSONData extends CommonMethods {

    public static List<Map.Entry<String, JsonNode>> allTestDataJSONObjects;
    private static List<Map.Entry<String, JsonNode>> sectionDataObjects = new ArrayList<>();

    public ParseJSONData() {
        String folderDirectory = getPropertyValue("testDataPath");
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser jp = null;
        folderDirectory = System.getProperty("user.dir") + folderDirectory;
        try {
            File folder = new File(folderDirectory);
            for (File file : folder.listFiles()) {
                try {
                    jp = jsonFactory.createJsonParser(new File(folderDirectory + file.getName()));
                } catch (IOException e) {
                    System.exit(0);
                }
                jp.setCodec(new ObjectMapper());
                JsonNode jsonNode;
                try {
                    jsonNode = jp.readValueAsTree();
                    this.allTestDataJSONObjects = readJsonData(jsonNode);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Test data JSON Folder not found: " + folderDirectory);
            System.exit(0);
        }
    }

    public String[] getJSONDataXpathParse(String value) {
        String[] dataObjectParse = value.split("\\.");
        Assert.assertTrue(dataObjectParse.length > 1, "Bad data json format. Expected format, section.field. 'section' is mandatory");
        return dataObjectParse;
    }

    public String getDataValue(String value) {
        JsonNode dataObject = null;
        String[] dataJSONObject = getJSONDataXpathParse(value);
        String sectionDataObject = dataJSONObject[0];
        List<String> dataXpath = new ArrayList<>();
        for (int i = 1; i < dataJSONObject.length; i++) {
            dataXpath.add(dataJSONObject[i]);
        }
        for (Map.Entry<String, JsonNode> entry : allTestDataJSONObjects) {
            if (entry.getKey().equalsIgnoreCase(sectionDataObject)) {
                dataObject = entry.getValue();
                break;
            }
        }
        return extractDataOffJson(dataObject, dataXpath);
    }


    public String extractDataOffJson(JsonNode node, List<String> value) {
        String dataValue = null;
        try {
            if (value.size() > 1) {
                String parentObject = value.get(0);
                String parentSubObject = value.get(1);
                JsonNode subDataObject = node.get(parentObject);
                dataValue = subDataObject.get(parentSubObject).asText();
            } else {
                dataValue = node.get(value.get(0)).asText();
            }
        } catch (Exception e) {
            System.out.println("Data not found");
            Assert.assertTrue(false, "Test Data retrieval from json object failed");
        }
        return dataValue;
    }

    public List<Map.Entry<String, JsonNode>> readJsonData(JsonNode jsonNode) {
        Iterator<Map.Entry<String, JsonNode>> ite = jsonNode.fields();
        while (ite.hasNext()) {

            Map.Entry<String, JsonNode> entry = ite.next();
            sectionDataObjects.add(entry);
        }
        return sectionDataObjects;
    }
}


