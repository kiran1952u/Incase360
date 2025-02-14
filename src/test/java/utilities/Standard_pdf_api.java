package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Standard_pdf_api {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://testapi.incase360.com";
    }

    @Test
    public void testCreateNotice() {

        String requestBody = "{ \"title\": \"Test Notice\", \"description\": \"This is a test notice\" }";


        Response response = given()
                .when()
                .post("/createNotice");


        response.then()
                .statusCode(200);


        response.prettyPrint();
    }

    @Test
    public void testCreatePDF1() {

        String requestBody = "{ \"title\": \"Test PDF\", \"content\": \"This is the content of the test PDF\" }";


        Response response = given()
                .body(requestBody)
                .header("Content-Type", "application/json")
                .when()
                .post("/createPdf");


        response.then()
                .statusCode(200);


        response.prettyPrint();
    }
        @Test
        public void testSendScheduledNotice() { // New API test method
            String requestBody = "{ \"noticeId\": \"12345\", \"scheduleTime\": \"2025-01-18T10:00:00\" }"; // Sample request body

            Response response = given()
                    .body(requestBody)
                    .header("Content-Type", "application/json") // Set the required content type
                    .when()
                    .post("/sendScheduledNotice");

            response.then()
                    .statusCode(200); // Adjust the expected status code based on API requirements

            response.prettyPrint(); // Print the response to the console
        }
    }

