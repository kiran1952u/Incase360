package testcase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://testapi.incase360.com";
    }

    @Test
    public void testCreateNotice() {

        String requestBody = "{ \"title\": \"Test Notice\", \"description\": \"This is a test notice\" }";


        Response response = given()
                .body(requestBody)
                .header("Content-Type", "application/json")
                .when()
                .post("/createNotice");


        response.then()
                .statusCode(200);


        response.prettyPrint();
    }

    @Test
    public void testCreatePDF() {

        String requestBody = "{ \"title\": \"Test PDF\", \"content\": \"This is the content of the test PDF\" }";


        Response response = given()
                .body(requestBody)
                .header("Content-Type", "application/json")
                .when()
                .post("https://tools.incase360.com/notice-management-dev/create-pdf");
//  this os the thevb

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
                .post("https://testapi.incase360.com/createPdf");


        response.then()
                .statusCode(200);


        response.prettyPrint();
    }
}
