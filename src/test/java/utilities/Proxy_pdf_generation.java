package utilities;

import org.testng.annotations.Test;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Proxy_pdf_generation {

    @Test
    public void parentApiEntry() {
        try {
            // Define API endpoints
            String createNoticeUrl = "https://testapi.incase360.com/createNotice";
            String createPdfUrl = "https://tools.incase360.com/notice-management-dev/create-pdf";

            // 1️⃣ Step 1: Hit Create Notice API 4 times
            System.out.println("===== Step 1: Hitting Create Notice API 4 times =====");
            for (int i = 0; i < 4; i++) {
                sendPostRequest(createNoticeUrl);
                System.out.println("createNotice API hit #" + (i + 1));
                Thread.sleep(1000); // optional delay
            }

            // 2️⃣ Step 2: Hit Create PDF API 4 times
            System.out.println("===== Step 2: Hitting Create PDF API 4 times =====");
            for (int i = 0; i < 4; i++) {
                sendPostRequest(createPdfUrl);
                System.out.println("createPdf API hit #" + (i + 1));
                Thread.sleep(1000);
            }

            System.out.println("\n🎯 All API calls completed successfully in sequence!");

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
