package libs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ElasticSearchDataGenerator {

    private CommonMethods cm = new CommonMethods();
    private ObjectMapper mapper = new ObjectMapper();

    public String generateData(Scenarios scenarios) {

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Release release = new Release();

        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
        Date now = new Date();
        String formattedDate = dateFormat.format(now);
        System.out.println(formattedDate);
        release.setTimeStamp(formattedDate);
        release.setScenarios(scenarios);

        String json = null;
        try {
            json = mapper.writeValueAsString(release);
        } catch (JsonProcessingException e) {
            System.out.println("Error in generating json data for elastic search" + e.getMessage());
        }
        System.out.println(json);
        return json;
    }

}