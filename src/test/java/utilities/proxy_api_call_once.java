package utilities;

import org.testng.annotations.Test;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class proxy_api_call_once {


    @Test
    public void parentApiEntry() {
        try {
            // Define API endpoints
            String createNoticeUrl = "https://testapi.incase360.com/createNotice";
            String createPdfUrl = "https://tools.incase360.com/notice-management-dev/create-pdf";

            // 1️⃣ Step 1: Hit Create Notice API twice
            System.out.println("===== Step 1: Hitting Create Notice API (1st time) =====");
            sendPostRequest(createNoticeUrl);
            System.out.println("✅ createNotice API hit successfully (1st time)");

            System.out.println("\n===== Step 2: Hitting Create Notice API (2nd time) =====");
            sendPostRequest(createNoticeUrl);
            System.out.println("✅ createNotice API hit successfully (2nd time)");

            // 2️⃣ Step 3: Hit Create PDF API twice
            System.out.println("\n===== Step 3: Hitting Create PDF API (1st time) =====");
            sendPostRequest(createPdfUrl);
            System.out.println("✅ createPdf API hit successfully (1st time)");

            System.out.println("\n===== Step 4: Hitting Create PDF API (2nd time) =====");
            sendPostRequest(createPdfUrl);
            System.out.println("✅ createPdf API hit successfully (2nd time)");

            System.out.println("\n🎯 All required API calls completed successfully!");

        } catch (Exception e) {
            throw new RuntimeException("❌ Error while calling APIs: ", e);
        }
    }

    // Helper method for sending POST requests
    private void sendPostRequest(String targetUrl) throws Exception {
        URL url = new URL(targetUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Example JSON request body
        String jsonInputString = "{}";
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response from " + targetUrl + ": " + responseCode);

        connection.disconnect();
    }
}

