package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

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
                System.out.println("Hitting endpoint: " + endpoint);

                Response response = given()
                        .when()
                        .get(endpoint);

                // Print the response
                System.out.println("Response from " + endpoint + ":");
                response.prettyPrint();

                // Validate the status code
                int statusCode = response.getStatusCode();
                System.out.println("Status Code: " + statusCode);
                assertEquals(statusCode, 200, "Expected status code 200 but got " + statusCode);
            }
        }
    }
}
