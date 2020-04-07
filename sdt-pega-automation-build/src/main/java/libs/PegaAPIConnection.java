package libs;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;

public class PegaAPIConnection {

    public Response doGetRequest(String endpoint, String userName, String password) {
        RestAssured.defaultParser = Parser.JSON;
        Response response = null;
        try {
            response = RestAssured.given().
                    auth().basic(userName, password).
                    headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                    when().get(endpoint).
                    then().contentType(ContentType.JSON).extract().response();
        } catch (Exception e) {
            System.out.println(response.statusCode());
        }
        return response;
    }


}
