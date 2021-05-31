package libs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ExecutionDeviceConfiguration extends CommonMethods {

    private static JsonNode objectDevice;

    ObjectMapper mapper = new ObjectMapper();

    public ExecutionDeviceConfiguration(String deviceKey) {
        objectDevice = getJsonObject(getRoot(), deviceKey);
    }

    private JsonNode getRoot() {
        JsonNode root = null;
        try {
            root = mapper.readTree(new File(System.getProperty("user.dir") + getPropertyValue("browserConfiguration")));
        } catch (IOException e) {
            System.out.println("Error in loading Browser configuration config tree. " + e.getMessage());
        }
        return root;
    }

    private JsonNode getJsonObject(JsonNode root, String deviceName) {
        JsonNode objectDevice = null;
        try {
            objectDevice = root.path(deviceName);
            if (objectDevice.isObject()) {
                return objectDevice;
            } else {
                System.out.println("Device not found in browserConfiguration.json file. Device => " + deviceName);
                System.exit(1);
            }

        } catch (Exception e) {
            System.out.println("Device not found in browserConfiguration.json file. Device => " + deviceName);
            System.exit(1);
        }
        return objectDevice;
    }

    public String getDeviceParameters(String key) {
        String value = "";
        try {
            value = objectDevice.path(key).asText();
        } catch (Exception e) {
            System.out.println("Device characteristics not found: " + key);
            System.exit(1);
        }
        return value;
    }

}
