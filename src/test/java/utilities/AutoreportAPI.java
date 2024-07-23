package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AutoreportAPI {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://testapi.incase360.com";
    }

    @Test
    public void testGetRequests() {
        String[] urls = {
                "/autoReport",
                "/autoPreliminaryReport",
                "/autoInterimReport",
                "/autoFinalReport"
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
}
