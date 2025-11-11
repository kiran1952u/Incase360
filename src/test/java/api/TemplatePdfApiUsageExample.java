package api;

import org.testng.annotations.Test;

/**
 * Usage examples for TemplatePdfApiTest
 * This class demonstrates various ways to use the Template PDF API test
 */
public class TemplatePdfApiUsageExample {

    private TemplatePdfApiTest apiTest = new TemplatePdfApiTest();

    /**
     * Example 1: Generate PDF with custom HTML template
     */
    @Test(enabled = false) // Enable when you have your own HTML file
    public void example1_CustomHTMLTemplate() {
        apiTest.setup();

        // Specify your HTML file path
        String htmlFilePath = "src/test/resources/testdata/my_custom_template.html";
        String outputPdfPath = "target/test-output/custom_notice.pdf";

        apiTest.testTemplatePdfGeneration(
                htmlFilePath,
                outputPdfPath,
                "letterhead_image.jpg",      // Your letterhead filename
                "signature_image.jpg",        // Your signature filename
                "250",                        // Signature width in pixels
                "150",                        // Signature height in pixels
                "50",                         // Top margin (letterhead)
                "40",                         // Bottom margin (signature)
                "129"                         // Your user ID
        );

        System.out.println("PDF generated successfully at: " + outputPdfPath);
    }

    /**
     * Example 2: Generate multiple PDFs with different configurations
     */
    @Test(enabled = false) // Enable when needed
    public void example2_MultiplePDFGeneration() {
        apiTest.setup();

        // Generate PDF for User 1
        apiTest.testTemplatePdfGeneration(
                "src/test/resources/testdata/template_user1.html",
                "target/test-output/notice_user1.pdf",
                "letterhead1.jpg",
                "signature1.jpg",
                "250", "150", "50", "40", "101"
        );

        // Generate PDF for User 2
        apiTest.testTemplatePdfGeneration(
                "src/test/resources/testdata/template_user2.html",
                "target/test-output/notice_user2.pdf",
                "letterhead2.jpg",
                "signature2.jpg",
                "300", "180", "60", "45", "102"
        );

        System.out.println("Multiple PDFs generated successfully!");
    }

    /**
     * Example 3: Generate PDF with different signature sizes
     */
    @Test(enabled = false) // Enable when needed
    public void example3_DifferentSignatureSizes() {
        apiTest.setup();

        String htmlFilePath = "src/test/resources/testdata/sample_template.html";

        // Small signature
        apiTest.testTemplatePdfGeneration(
                htmlFilePath,
                "target/test-output/notice_small_signature.pdf",
                "letterhead.jpg",
                "signature.jpg",
                "150",  // Smaller width
                "100",  // Smaller height
                "50", "40", "129"
        );

        // Large signature
        apiTest.testTemplatePdfGeneration(
                htmlFilePath,
                "target/test-output/notice_large_signature.pdf",
                "letterhead.jpg",
                "signature.jpg",
                "400",  // Larger width
                "250",  // Larger height
                "50", "40", "129"
        );

        System.out.println("PDFs with different signature sizes generated!");
    }

    /**
     * Example 4: Generate PDF with custom margins
     */
    @Test(enabled = false) // Enable when needed
    public void example4_CustomMargins() {
        apiTest.setup();

        String htmlFilePath = "src/test/resources/testdata/sample_template.html";
        String outputPdfPath = "target/test-output/notice_custom_margins.pdf";

        // Larger margins for more spacing
        apiTest.testTemplatePdfGeneration(
                htmlFilePath,
                outputPdfPath,
                "letterhead.jpg",
                "signature.jpg",
                "250",
                "150",
                "80",   // Larger top margin
                "70",   // Larger bottom margin
                "129"
        );

        System.out.println("PDF with custom margins generated!");
    }

    /**
     * Example 5: Read configuration from external source (CSV, Excel, Database)
     * This example demonstrates how you might integrate with data-driven testing
     */
    @Test(enabled = false) // Enable and modify when needed
    public void example5_DataDrivenTest() {
        apiTest.setup();

        // In real scenario, you would read these from CSV, Excel, or Database
        String[][] testData = {
                {"template1.html", "output1.pdf", "letterhead1.jpg", "signature1.jpg", "250", "150", "50", "40", "129"},
                {"template2.html", "output2.pdf", "letterhead2.jpg", "signature2.jpg", "300", "180", "60", "45", "130"},
                {"template3.html", "output3.pdf", "letterhead3.jpg", "signature3.jpg", "200", "120", "40", "35", "131"}
        };

        for (String[] data : testData) {
            apiTest.testTemplatePdfGeneration(
                    "src/test/resources/testdata/" + data[0],
                    "target/test-output/" + data[1],
                    data[2], data[3], data[4], data[5], data[6], data[7], data[8]
            );
            System.out.println("Generated: " + data[1]);
        }

        System.out.println("All data-driven PDFs generated successfully!");
    }

    /**
     * Example 6: Generate PDF with minimal configuration
     */
    @Test(enabled = false) // Enable when needed
    public void example6_MinimalConfiguration() {
        apiTest.setup();

        // Use minimal default values
        apiTest.testTemplatePdfGeneration(
                "src/test/resources/testdata/sample_template.html",
                "target/test-output/minimal_notice.pdf",
                "",      // Empty letterhead
                "",      // Empty signature
                "0",     // Zero width
                "0",     // Zero height
                "0",     // Zero top margin
                "0",     // Zero bottom margin
                "129"
        );

        System.out.println("PDF with minimal configuration generated!");
    }
}
