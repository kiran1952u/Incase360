package utilities;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_notice_all_api {
    public static void main(String[] args) {


        String payload = "{\n" + "    \"template_id\": \"INSD_Kiran\",\n" + "    \"reference_id\": \"BLN000800806766\",\n" + "    \"data\": {\n" + "        \"date_of_notice\": \"28-05-2024\",\n" + "        \"Full_name_of_primary_respondent\": \"Test Name\",\n" + "        \"Status_of_primary_respondent\": \"Borrower\",\n" + "        \"Full_address_of_primary_respondent\": \"Building 1, Floor 1, Street 1, Mumbai - 400001\",\n" + "        \"Email_ID_of_primary_respondent\": \"kiran@presolv360.com\",\n" + "        \"WhatsApp_of_primary_respondent\": \"91377884572\",\n" + "        \"Coborrower_one\": \"Test 2\",\n" + "        \"Coborrower_one_email\": \"test2@presolv360.com\",\n" + "        \"Coborrower_one_mobile\": \"9137784572\",\n" + "        \"Coborrower_two\": \"\",\n" + "        \"Coborrower_two_email\": \"\",\n" + "        \"Coborrower_two_mobile\": \"\",\n" + "        \"Coborrower_three\": \"\",\n" + "        \"Coborrower_three_email\": \"\",\n" + "        \"Coborrower_three_mobile\": \"\",\n" + "        \"Details_of_other_respondent\": \"\",\n" + "        \"Email_ID_of_other_respondent\": \"\",\n" + "        \"WhatsApp_of_other_respondent\": \"\",\n" + "        \"agreement_number\": \"BLN000800806776\",\n" + "        \"disbursal_date\": \"14-09-2023\",\n" + "        \"vehicle_equipment_asset_description\": \"Maruti suzuki 800\",\n" + "        \"registration_no\": \"124485\",\n" + "        \"engine_no\": \"PL1254\",\n" + "        \"chassis_no\": \"KL01OL9632\",\n" + "        \"total_outstanding_amount\": \"9,63,494.45\",\n" + "        \"outstanding_as_on\": \"20-03-2024\",\n" + "        \"due_days_for_response\": \"7\",\n" + "        \"Reference_ID\": \"BLN000800806799\"\n" + "    }\n" + "}";

        String[] urls = {"https://tools.incase360.com/notice-management-dev/notices", "https://tools.incase360.com/notice-management-dev/update-batch", "https://tools.incase360.com/notice-management-dev/create-pdf"};
        for (String url : urls) {
//            if (url.contains("notices")) {
//            } else {
//                sendPostRequest(url, "");
//            }
            sendPostRequest(url, payload);
        }
    }

    private static void sendPostRequest(String url, String payload) {

        Response response = given().body(payload).headers(Map.of("Content-Type", "application/json", "X-API-KEY", "zzf762eJOYn8zWlG1K")).when().post(url);

        response.prettyPrint();


    }





}
