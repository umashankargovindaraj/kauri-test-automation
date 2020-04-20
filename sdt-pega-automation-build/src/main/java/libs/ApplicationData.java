package libs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApplicationData {

    ObjectMapper mapper = new ObjectMapper();
//    String fileDir = getPropertyValue("testDataPath");
    String fileDir = "src/main/resources/B4SCData/";
    private Map<String, Map<String,String>> applicationDataMap = new HashMap<>();
    private Map<String,String> transientDataMap  = new HashMap<>();

    public void putToMap(String key, String value) {
        this.transientDataMap.put(key,value);
    }

    public String getFromMap (String key) {
        return this.transientDataMap.get(key);
    }

    public void printMap(){
        System.out.println("*******************transientDataMap: " + this.transientDataMap.toString());
    }

    public ApplicationData() {
        JSONToMap("testData.json");
    }

    public File getJSONFile (String fileName) {
        String fullFilePath = fileDir + fileName;
        return new File(fullFilePath);
    }

    public void JSONToMap (String fileName) {
        try {
            applicationDataMap = mapper.readValue(getJSONFile(fileName), new TypeReference<Map<String, Map<String,String>>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map getApplicationData () {
        return applicationDataMap;
    }

    public Map<String, String> getPageMap (String pageName) {
        return applicationDataMap.get(pageName);
    }

    public String getElement (String pageName, String key) {
        return applicationDataMap.get(pageName).get(key);
    }


}
