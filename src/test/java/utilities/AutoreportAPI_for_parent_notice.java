package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class AutoreportAPI_for_parent_notice {
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

        // Outer loop to iterate through each endpoint
        for (String endpoint : urls) {
            // Inner loop to hit the endpoint 4 times
            for (int i = 1; i <= 4; i++) {
                System.out.println("Hitting endpoint: " + endpoint + " - Attempt " + i);

                Response response = given()
                        .when()
                        .get(endpoint);

                // Print the response
                System.out.println("Response from " + endpoint + " - Attempt " + i + ":");
                response.prettyPrint();

                // Validate the status code
                int statusCode = response.getStatusCode();
                System.out.println("Status Code: " + statusCode);
                assertEquals(statusCode, 200, "Expected status code 200 but got " + statusCode);
            }
        }
    }
}
