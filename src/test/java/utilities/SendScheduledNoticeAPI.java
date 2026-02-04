package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * SendScheduledNoticeAPI - Utility class to trigger the sendScheduledNotice API
 * This API is called after a successful bulk send operation to process scheduled notices
 */
public class SendScheduledNoticeAPI {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://testapi.incase360.com";
    }

    @Test
    public void sendScheduledNoticeAPI() {
        String endpoint = "/sendScheduledNotice";

        System.out.println("========================================");
        System.out.println("🚀 Triggering Send Scheduled Notice API...");
        System.out.println("========================================");

        try {
            Response response = given()
                    .when()
                    .get(endpoint);

            // Print the response
            System.out.println("✅ Response from " + endpoint + ":");
            System.out.println("Status Code: " + response.getStatusCode());
            response.prettyPrint();

            if (response.getStatusCode() == 200) {
                System.out.println("========================================");
                System.out.println("✅✅✅ Send Scheduled Notice API executed successfully!");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("⚠️ WARNING: API returned status code: " + response.getStatusCode());
                System.out.println("========================================");
            }
        } catch (Exception e) {
            System.out.println("========================================");
            System.out.println("❌ ERROR calling Send Scheduled Notice API: " + e.getMessage());
            System.out.println("========================================");
            e.printStackTrace();
        }
    }
}
