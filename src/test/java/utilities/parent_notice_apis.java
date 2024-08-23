package utilities;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class parent_notice_apis {
    public void parentApiEntry() {
        try {
            // URL for the first API
            String createNoticeUrl = "https://testapi.incase360.com/createNotice";
            // URL for the second API
            String createPdfUrl = "https://tools.incase360.com/notice-management-dev/create-pdf";

            // Hit the first API 4 times
            for (int i = 0; i < 4; i++) {
                sendPostRequest(createNoticeUrl);
            }
            // Hit the second API 4 times
                sendPostRequest(createPdfUrl);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void sendPostRequest(String targetUrl) throws Exception {
        // Create a URL object with the target URL
        URL url = new URL(targetUrl);
        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set up the request method and headers
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json"); // or any other content type
        connection.setDoOutput(true);

        // Write the request body if needed (for POST requests)
        String jsonInputString = "{}"; // Replace with actual JSON if required
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Check the response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Close the connection
        connection.disconnect();
    }

}
