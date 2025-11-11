# Template PDF API Test

This test suite provides automated testing for the Template PDF Generation API endpoint.

## Overview

The `TemplatePdfApiTest` class tests the `/template-pdf` API endpoint which generates PDF documents from HTML templates with configurable letterhead and signature configurations.

## API Details

**Endpoint:** `https://tools.incase360.com/notice-management-dev/template-pdf`
**Method:** POST
**Content-Type:** multipart/form-data

### Request Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| `template` | String | HTML content (read from file) |
| `letterHeadConfiguration` | JSON | Configuration for letterhead and signature |

### Letterhead Configuration JSON Structure

```json
{
  "letterheadFileName": "filename.jpg",
  "signatureFileName": "signature.jpg",
  "signatureWidth": "250",
  "signatureHeight": "150",
  "headMargin": "50",
  "footMargin": "40",
  "userId": "129"
}
```

### Response Format

```json
{
  "message": "created successfully",
  "status": "SUCCESS",
  "data": "<base64-encoded-pdf-string>"
}
```

## Test Files

- **Test Class:** `src/test/java/api/TemplatePdfApiTest.java`
- **Sample HTML:** `src/test/resources/testdata/sample_template.html`
- **Output Directory:** `target/test-output/`

## Running the Tests

### Method 1: Run with Default Values

```bash
mvn test -Dtest=TemplatePdfApiTest#testTemplatePdfGenerationWithDefaultValues
```

This will use the sample HTML template and default configuration values.

### Method 2: Run with Custom Values via System Properties

```bash
mvn test -Dtest=TemplatePdfApiTest#testTemplatePdfGenerationWithCustomValues \
  -DhtmlFilePath="path/to/your/template.html" \
  -DoutputPdfPath="path/to/output/document.pdf" \
  -DletterheadFileName="your_letterhead.jpg" \
  -DsignatureFileName="your_signature.jpg" \
  -DsignatureWidth="300" \
  -DsignatureHeight="200" \
  -DheadMargin="60" \
  -DfootMargin="50" \
  -DuserId="129"
```

### Method 3: Run from TestNG XML

Add the following to your `testng.xml`:

```xml
<test name="Template PDF API Test">
    <parameter name="htmlFilePath" value="src/test/resources/testdata/sample_template.html"/>
    <parameter name="outputPdfPath" value="target/test-output/generated.pdf"/>
    <classes>
        <class name="api.TemplatePdfApiTest">
            <methods>
                <include name="testTemplatePdfGenerationWithDefaultValues"/>
            </methods>
        </class>
    </classes>
</test>
```

### Method 4: Run All API Tests

```bash
mvn test -Dtest=TemplatePdfApiTest
```

## Test Features

1. **Dynamic HTML Content**: Reads HTML from any file path (no hardcoding)
2. **Configurable Parameters**: All letterhead configuration parameters are dynamic
3. **Base64 to PDF Conversion**: Automatically converts API response to PDF
4. **Dynamic Output Path**: Save PDF to any specified location
5. **Comprehensive Validation**:
   - API response status code
   - Response JSON structure
   - Base64 data presence
   - Generated PDF file existence and size
6. **Detailed Logging**: Console output at each step for debugging

## Creating Custom HTML Templates

1. Create your HTML file in `src/test/resources/testdata/` directory
2. Use standard HTML with inline CSS for best results
3. The HTML will be sent as-is to the API
4. Reference your HTML file path when running the test

### Example HTML Structure

```html
<!DOCTYPE html>
<html>
<head>
    <style>
        /* Your CSS styles */
    </style>
</head>
<body>
    <div class="header">
        <!-- Header content -->
    </div>
    <div class="content">
        <!-- Main content -->
    </div>
    <div class="footer">
        <!-- Footer content -->
    </div>
</body>
</html>
```

## Test Output

- **Console Output**: Detailed logs of each step
- **Generated PDF**: Saved to specified output path
- **TestNG Reports**: Available in `target/surefire-reports/`

## Troubleshooting

### Issue: HTML file not found
**Solution:** Check the file path is correct and file exists

### Issue: PDF not generated
**Solution:**
- Check API response in console logs
- Verify base64 data is present in response
- Check output directory has write permissions

### Issue: API returns error
**Solution:**
- Verify API endpoint is accessible
- Check letterhead and signature filenames are valid
- Ensure userId is correct

### Issue: Empty PDF generated
**Solution:**
- Verify HTML content is valid
- Check if base64 data in response is not empty
- Validate HTML doesn't have syntax errors

## Programmatic Usage

You can also call the test method programmatically from other tests:

```java
TemplatePdfApiTest apiTest = new TemplatePdfApiTest();
apiTest.setup(); // Initialize

apiTest.testTemplatePdfGeneration(
    "path/to/template.html",
    "path/to/output.pdf",
    "letterhead.jpg",
    "signature.jpg",
    "250", "150", "50", "40", "129"
);
```

## Dependencies

The test uses the following libraries:
- **RestAssured 4.4.0**: For API testing
- **TestNG 7.10.1**: For test execution
- **Java Base64**: For base64 decoding (built-in)
- **Java NIO Files**: For file operations (built-in)

## Notes

- The test automatically creates output directories if they don't exist
- HTTPS validation is relaxed for testing purposes
- All parameters are validated with assertions
- The test will fail if any step fails, with detailed error messages
