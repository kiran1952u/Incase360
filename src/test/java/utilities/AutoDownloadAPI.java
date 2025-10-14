package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AutoDownloadAPI {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://testapi.incase360.com";
    }

    @Test
    public void autoDownlaodAPI() {
        String[] urls = {
                "/autoDownloadNotice",

        };

        for (String endpoint : urls) {
            if (endpoint.contains("auto")) {
                Response response = given()
                        .when()
                        .get(endpoint);
                // Print the response
                System.out.println("Response from " + endpoint + ":");
                response.prettyPrint();
            }
        }
    }

    public void callAutoDownloadAPI(String yourEndpointUrl) {
    }
}


