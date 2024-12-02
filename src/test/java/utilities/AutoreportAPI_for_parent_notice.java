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
        // Set the base URI for the APIs
        RestAssured.baseURI = "https://testapi.incase360.com";
    }

    @Test
    public void testGetRequests() {
        // Array of endpoints to test
        String[] urls = {
                "/autoReport",
                "/autoPreliminaryReport",
                "/autoInterimReport",
                "/autoFinalReport"
        };

        // Loop through each endpoint
        for (String endpoint : urls) {
            System.out.println("\n=== Testing endpoint: " + endpoint + " ===");

            // Hit each endpoint exactly two times
            for (int attempt = 1; attempt <= 3; attempt++) {
                System.out.println("\nHitting endpoint: " + endpoint + " - Attempt " + attempt);

                // Make the GET request
                Response response = given()
                        .when()
                        .get(endpoint);

                // Print the response details
                System.out.println("Response from " + endpoint + " - Attempt " + attempt + ":");
                response.prettyPrint();

                // Validate the status code
                int statusCode = response.getStatusCode();
                System.out.println("Status Code: " + statusCode);
                assertEquals(statusCode, 200, "Expected status code 200 but got " + statusCode);
            }
        }
    }
}
