package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static io.restassured.RestAssured.given;

/**
 * API Test for Template PDF Generation
 * This test reads HTML content from a file, sends it to the API with letterhead configuration,
 * and converts the base64 response to a PDF file.
 */
public class TemplatePdfApiTest {

    private static final String API_URL = "https://tools.incase360.com/notice-management-dev/template-pdf";

    @BeforeClass
    public void setup() {
        // Configure RestAssured base settings
        RestAssured.useRelaxedHTTPSValidation();
    }

    /**
     * Test method to generate PDF from HTML template
     *
     * @param htmlFilePath - Path to the HTML template file
     * @param outputPdfPath - Path where the generated PDF should be saved
     * @param letterheadFileName - Name of the letterhead file
     * @param signatureFileName - Name of the signature file
     * @param signatureWidth - Width of the signature
     * @param signatureHeight - Height of the signature
     * @param headMargin - Top margin for letterhead
     * @param footMargin - Bottom margin for signature
     * @param userId - User ID
     */
    public void testTemplatePdfGeneration(String htmlFilePath, String outputPdfPath,
                                          String letterheadFileName, String signatureFileName,
                                          String signatureWidth, String signatureHeight,
                                          String headMargin, String footMargin, String userId) {
        try {
            // Step 1: Read HTML content from file
            System.out.println("Reading HTML content from: " + htmlFilePath);
            String htmlContent = readHtmlFromFile(htmlFilePath);
            Assert.assertNotNull(htmlContent, "HTML content should not be null");
            System.out.println("HTML content loaded successfully. Length: " + htmlContent.length());

            // Step 2: Build letterhead configuration JSON
            String letterheadConfig = buildLetterheadConfig(letterheadFileName, signatureFileName,
                    signatureWidth, signatureHeight, headMargin, footMargin, userId);
            System.out.println("Letterhead configuration: " + letterheadConfig);

            // Step 3: Make API request
            System.out.println("Sending request to API: " + API_URL);
            Response response = given()
                    .multiPart("template", htmlContent)
                    .multiPart("letterHeadConfiguration", letterheadConfig, "application/json")
                    .when()
                    .post(API_URL);

            // Step 4: Validate response
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());

            Assert.assertEquals(response.getStatusCode(), 200, "API should return status 200");

            // Step 5: Parse response and extract base64 data
            String status = response.jsonPath().getString("status");
            String message = response.jsonPath().getString("message");
            String base64Data = response.jsonPath().getString("data");

            System.out.println("Status: " + status);
            System.out.println("Message: " + message);

            Assert.assertEquals(status, "SUCCESS", "Status should be SUCCESS");
            Assert.assertEquals(message, "created successfully", "Message should indicate success");
            Assert.assertNotNull(base64Data, "Base64 data should not be null");

            // Step 6: Convert base64 to PDF and save
            System.out.println("Converting base64 to PDF and saving to: " + outputPdfPath);
            convertBase64ToPdf(base64Data, outputPdfPath);
            System.out.println("PDF generated successfully at: " + outputPdfPath);

            // Step 7: Verify PDF file was created
            File pdfFile = new File(outputPdfPath);
            Assert.assertTrue(pdfFile.exists(), "PDF file should exist at: " + outputPdfPath);
            Assert.assertTrue(pdfFile.length() > 0, "PDF file should not be empty");
            System.out.println("PDF file size: " + pdfFile.length() + " bytes");

        } catch (Exception e) {
            Assert.fail("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Default test with sample data
     * This is a convenience method for quick testing with default values
     */
    @Test
    public void testTemplatePdfGenerationWithDefaultValues() {
        String htmlFilePath = "src/test/resources/testdata/sample_template.html";
        String outputPdfPath = "D:\\Notice Preview\\1_template.pdf";

        testTemplatePdfGeneration(
                htmlFilePath,
                outputPdfPath,
                "1756189260_photo_2024-07-10_16-08-49.jpg",
                "1752211927_pdf_generation_test.jpeg",
                "100",
                "200",
                "50",
                "40",
                "129"
        );
    }

    /**
     * Parameterized test method that can be called from other tests or TestNG XML
     */
    @Test
    public void testTemplatePdfGenerationWithCustomValues() {
        // Read values from system properties or use defaults
        String htmlFilePath = "src/test/resources/testdata/sample_template.html";
        String outputPdfPath = "D:\\Notice Preview\\template.pdf";
        String letterheadFileName = System.getProperty("letterheadFileName", "1754913104_pdf_generation_test.png");
        String signatureFileName = System.getProperty("signatureFileName", "1752211927_pdf_generation_test.jpeg");
        String signatureWidth = System.getProperty("signatureWidth", "80");
        String signatureHeight = System.getProperty("signatureHeight", "70");
        String headMargin = System.getProperty("headMargin", "50");
        String footMargin = System.getProperty("footMargin", "40");
        String userId = System.getProperty("userId", "129");

        // Create output directory if it doesn't exist
        new File(outputPdfPath).getParentFile().mkdirs();

        testTemplatePdfGeneration(
                htmlFilePath,
                outputPdfPath,
                letterheadFileName,
                signatureFileName,
                signatureWidth,
                signatureHeight,
                headMargin,
                footMargin,
                userId
        );
    }
    @Test
    public void testTemplatePdfGenerationWithCustomValuesdaynamic() {
        // Read values from system properties or use defaults
        String htmlFilePath = "src/test/resources/testdata/sample_template.html";
        String outputPdfPath = "D:\\Notice Preview\\3_template.pdf";
        String letterheadFileName = System.getProperty("letterheadFileName", "1753967961_1724407783_photo_2024-07-04_17-56-37.jpg");
        String signatureFileName = System.getProperty("signatureFileName", "1753967962_1713941553_pdf_generation_test.jpeg");
        String signatureWidth = System.getProperty("signatureWidth", "650");
        String signatureHeight = System.getProperty("signatureHeight", "70");
        String headMargin = System.getProperty("headMargin", "50");
        String footMargin = System.getProperty("footMargin", "40");
        String userId = System.getProperty("userId", "129");

        // Create output directory if it doesn't exist
        new File(outputPdfPath).getParentFile().mkdirs();

        testTemplatePdfGeneration(
                htmlFilePath,
                outputPdfPath,
                letterheadFileName,
                signatureFileName,
                signatureWidth,
                signatureHeight,
                headMargin,
                footMargin,
                userId
        );
    }
    /**
     * Reads HTML content from a file
     *
     * @param filePath - Path to the HTML file
     * @return HTML content as String
     * @throws IOException if file cannot be read
     */
    private String readHtmlFromFile(String filePath) throws IOException {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.err.println("Error reading HTML file: " + filePath);
            throw e;
        }
    }

    /**
     * Builds the letterhead configuration JSON string
     *
     * @param letterheadFileName - Letterhead image filename
     * @param signatureFileName - Signature image filename
     * @param signatureWidth - Signature width
     * @param signatureHeight - Signature height
     * @param headMargin - Top margin
     * @param footMargin - Bottom margin
     * @param userId - User ID
     * @return JSON string with letterhead configuration
     */
    private String buildLetterheadConfig(String letterheadFileName, String signatureFileName,
                                         String signatureWidth, String signatureHeight,
                                         String headMargin, String footMargin, String userId) {
        return String.format(
                "{\"letterheadFileName\":\"%s\",\"signatureFileName\":\"%s\"," +
                "\"signatureWidth\":\"%s\",\"signatureHeight\":\"%s\"," +
                "\"headMargin\":\"%s\",\"footMargin\":\"%s\",\"userId\":\"%s\"}",
                letterheadFileName, signatureFileName, signatureWidth, signatureHeight,
                headMargin, footMargin, userId
        );
    }

    /**
     * Converts base64 string to PDF and saves it to the specified path
     *
     * @param base64Data - Base64 encoded PDF data
     * @param outputPath - Path where PDF should be saved
     * @throws IOException if file cannot be written
     */
    private void convertBase64ToPdf(String base64Data, String outputPath) throws IOException {
        try {
            // Decode base64 string
            byte[] decodedBytes = Base64.getDecoder().decode(base64Data);

            // Create parent directories if they don't exist
            File outputFile = new File(outputPath);
            outputFile.getParentFile().mkdirs();

            // Write bytes to file
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(decodedBytes);
            }

            System.out.println("Successfully converted base64 to PDF");
        } catch (IOException e) {
            System.err.println("Error converting base64 to PDF: " + e.getMessage());
            throw e;
        }
    }
}
