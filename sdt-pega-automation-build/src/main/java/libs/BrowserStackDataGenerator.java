package libs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class BrowserStackDataGenerator {

    private ObjectMapper mapper = new ObjectMapper();

    public String generateData(String status, String reason) {

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        BrowserStackPOJO browserStackPOJO = new BrowserStackPOJO();
        browserStackPOJO.setStatus(status);
        browserStackPOJO.setReason(reason);
        String json = null;
        try {
            json = mapper.writeValueAsString(browserStackPOJO);
        } catch (JsonProcessingException e) {
            System.out.println("Error in generating json data for elastic search");
        }
        System.out.println(json);
        return json;
    }
}
