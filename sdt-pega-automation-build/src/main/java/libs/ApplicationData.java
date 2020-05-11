package libs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ApplicationData {

    ObjectMapper mapper = new ObjectMapper();
//    String fileDir = getPropertyValue("testDataPath");
    String fileDir = "src/main/resources/B4SCData/";
    private Map<String, Map<String,String>> applicationDataMap = new HashMap<>();
    private Map<String,String> transientDataMap  = new HashMap<>();

    public ApplicationData() {
        JSONToMap("testData.json");
    }

    public void putToMap(String key, String value) {
        this.transientDataMap.put(key,value);
    }

    public String getFromMap (String key) {
        return this.transientDataMap.get(key);
    }

    public void printMap(){
        System.out.println("*******************transientDataMap: " + this.transientDataMap.toString());
    }

    public File getJSONFile (String fileName) {
        String fullFilePath = fileDir + fileName;
        return new File(fullFilePath);
    }

    public void JSONToMap (String fileName) {
        try {
            applicationDataMap = mapper.readValue(getJSONFile(fileName), new TypeReference<Map<String, Map<String,String>>>(){});
        } catch (IOException e) {
            System.out.println("failure in JSONToMap() " + e.getMessage());
        }
    }

    public Map getApplicationData () {
        return applicationDataMap;
    }

    public Map<String, String> getPageMap (String pageName) {
        return applicationDataMap.get(pageName);
    }

    public String getElement (String pageName, String key) {
        String finalData = null;
        String dataFromTestDataFile = applicationDataMap.get(pageName).get(key);
        finalData = generateListData(dataFromTestDataFile);
        return finalData;
    }
    public String generateListData(String data) {
        String testData = null;
        List<String> conditions = splitCondition(data);
        testData = getDataFromList(conditions);
        return testData;
    }
    private List<String> splitCondition(String testCondition) {
        String[] splitStringArray = testCondition.split("\\|");
        List<String> conditions = new ArrayList<>();
        for (String condition : splitStringArray) {
            conditions.add(condition);
        }
        return conditions;
    }
    private String getDataFromList(List<String> dataList){
        int maxLength = dataList.size();
        int dataIndex = generateRandomLength(maxLength,0);
        return dataList.get(dataIndex);
    }
    private int generateRandomLength(int maxLength, int minLength){
        Random random = new Random();
        try{
            return random.nextInt(maxLength - minLength) + minLength;
        }catch (Exception e){
            return 1;
        }
    }
}
