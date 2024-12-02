package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Proxy_combine_csv {

        @BeforeClass
        public void setup () {
        // Set the base URI for the APIs
        RestAssured.baseURI = "https://testapi.incase360.com";
    }

        @Test
        public void testGetRequestsOnce () {

        String[] urls = {"/mergeAutoReportPx", "/ProxyAutoPreliminaryReportGenerate", "/ProxyAutoInterimReportGenerate", "/ProxyAutoFinalReportGenerate"};


        for (String endpoint : urls) {
            System.out.println("\nHitting endpoint: " + endpoint);


            Response response = given().when().get(endpoint);


            System.out.println("Response from " + endpoint + ":");
            response.prettyPrint();


            int statusCode = response.getStatusCode();
            System.out.println("Status Code: " + statusCode);


            assertEquals(statusCode / 100, 2, "Expected 2xx status code but got " + statusCode);
        }
    }
    }
