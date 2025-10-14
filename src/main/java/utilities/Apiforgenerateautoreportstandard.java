package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class    Apiforgenerateautoreportstandard {
    public static void main(String[] args) {
        // Initialize WebDriver (if needed for any further testing)

        String[] apiEndpoints = {
                "https://testapi.incase360.com/autoReport",
                "https://testapi.incase360.com/autoPreliminaryReport",
                "https://testapi.incase360.com/autoInterimReport",
                "https://testapi.incase360.com/autoFinalReport"
        };

        // Execute APIs one by one
        for (String endpoint : apiEndpoints) {
            executeApi(endpoint);
        }

    }

    // Method to execute the API and print response
    public static void executeApi(String apiUrl) {
        System.out.println("Executing API: " + apiUrl);

        // Make API call
        Response response = RestAssured.get(apiUrl);

        // Print response details
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }
}
