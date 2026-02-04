package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverFactory;
import utilities.ScenarioContext;

/**
 * BulkSend_for_standard_notice_Steps - Contains UNIQUE step definitions specific to Standard Notice
 *
 * This file only contains steps that are UNIQUE to standard notice bulk send:
 * - Selecting option 28 from additional dropdown
 * - Opening date picker and selecting date (standard notice specific implementation)
 *
 * Common steps (login, navigation, user selection, etc.) are in CommonSteps.java
 */
public class BulkSend_for_standard_notice_Steps {

    private WebDriver driver;

    public BulkSend_for_standard_notice_Steps() {
        // Get the WebDriver instance from DriverFactory (managed by Hooks)
        this.driver = DriverFactory.getDriver();
    }

    // ==================================================================================
    // UNIQUE STEPS FOR STANDARD NOTICE
    // ==================================================================================

    @And("the admin selects option {int} from the additional dropdown")
    public void the_admin_selects_option_from_the_additional_dropdown(Integer optionNumber) throws InterruptedException {
        // Select option by number from additional dropdown (OLD METHOD - HARDCODED)
        // This is kept for backward compatibility
        WebElement element3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/select/option[" + optionNumber + "]"));
        element3.click();
        Thread.sleep(1000);
        System.out.println("Selected option " + optionNumber + " from additional dropdown");
    }

    @And("the admin selects the batch that was created earlier from dropdown")
    public void the_admin_selects_the_batch_that_was_created_earlier_from_dropdown() throws InterruptedException {
        // RETRIEVE batch name from ScenarioContext
        String batchName = (String) ScenarioContext.getContext("BATCH_NAME");

        if (batchName == null || batchName.isEmpty()) {
            throw new RuntimeException("❌ ERROR: Batch name not found in ScenarioContext!");
        }

        System.out.println("✅ Retrieved batch name: " + batchName);
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Open dropdown
        WebElement batchDropdownTrigger = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/span"));
        batchDropdownTrigger.click();
        System.out.println("Dropdown opened");
        Thread.sleep(2000); // Wait for dropdown to fully load

        // Find and click batch
        WebElement batchElement = driver.findElement(By.xpath("//span[text()='" + batchName + "']"));
        js.executeScript("arguments[0].click();", batchElement);
        System.out.println("Clicked batch");

        // CRITICAL: Wait for dropdown to close and UI to update
        Thread.sleep(5000); // Increased wait time

        // Check what's ACTUALLY displayed NOW
        WebElement selectedDisplay = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/span"));
        String displayedBatch = selectedDisplay.getText().trim();

        System.out.println("========================================");
        System.out.println("CHECKING WHAT IS DISPLAYED ON SCREEN:");
        System.out.println("Expected: [" + batchName + "]");
        System.out.println("Actually showing: [" + displayedBatch + "]");
        System.out.println("========================================");

        // If it's wrong, try to fix it by clicking again
        if (!displayedBatch.equals(batchName)) {
            System.out.println("⚠️ WRONG BATCH SHOWING! Attempting to fix...");

            // Open dropdown again
            batchDropdownTrigger = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/span"));
            batchDropdownTrigger.click();
            Thread.sleep(2000);

            // Click the correct batch again
            batchElement = driver.findElement(By.xpath("//span[text()='" + batchName + "']"));
            js.executeScript("arguments[0].click();", batchElement);
            System.out.println("Clicked batch again");
            Thread.sleep(5000);

            // Check again
            selectedDisplay = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/span"));
            displayedBatch = selectedDisplay.getText().trim();

            System.out.println("After retry - showing: [" + displayedBatch + "]");

            if (!displayedBatch.equals(batchName)) {
                throw new RuntimeException("❌ STILL WRONG! Expected '" + batchName + "' but showing '" + displayedBatch + "'");
            }
        }

        System.out.println("✅ Verified: Correct batch is displayed: " + batchName);

        // Store for later verification
        ScenarioContext.setContext("EXPECTED_BATCH", batchName);
    }

    @And("the admin opens the date picker and selects a date")
    public void the_admin_opens_the_date_picker_and_selects_a_date() throws InterruptedException {
        // VERIFY batch is still correct BEFORE opening date picker
        String expectedBatch = (String) ScenarioContext.getContext("EXPECTED_BATCH");
        WebElement batchDisplay = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/span"));
        String currentBatch = batchDisplay.getText().trim();

        System.out.println("========================================");
        System.out.println("BEFORE DATE PICKER - Batch check:");
        System.out.println("Expected: [" + expectedBatch + "]");
        System.out.println("Current: [" + currentBatch + "]");
        System.out.println("========================================");

        if (!currentBatch.equals(expectedBatch)) {
            throw new RuntimeException("❌ Batch changed to '" + currentBatch + "' before opening date picker!");
        }
        System.out.println("========================================");
        System.out.println("🔍 Opening date picker...");
        System.out.println("========================================");

        // Wait after batch selection before opening date picker
        Thread.sleep(2000);

        // Click to open the date picker (Standard notice specific implementation)
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]"));

        // Try multiple click strategies for date picker
        try {
            element1.click();
            System.out.println("✅ Date picker opened with regular click");
        } catch (Exception e) {
            System.out.println("❌ Regular click failed, trying JavaScript click");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element1);
            System.out.println("✅ Date picker opened with JavaScript click");
        }

        Thread.sleep(3000);

        // Select a specific date from the date picker
        WebElement dateElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/span"));
        try {
            dateElement.click();
            System.out.println("✅ Date selected with regular click");
        } catch (Exception e) {
            System.out.println("❌ Date regular click failed, trying JavaScript click");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", dateElement);
            System.out.println("✅ Date selected with JavaScript click");
        }

        System.out.println("Date selected from date picker (standard notice)");

        // Wait for date to be applied
        Thread.sleep(2000);

        // VERIFY batch is STILL correct AFTER date picker
        String expectedBatch2 = (String) ScenarioContext.getContext("EXPECTED_BATCH");
        WebElement batchDisplay2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/span"));
        String currentBatch2 = batchDisplay2.getText().trim();

        System.out.println("========================================");
        System.out.println("AFTER DATE PICKER - Batch check:");
        System.out.println("Expected: [" + expectedBatch2 + "]");
        System.out.println("Current: [" + currentBatch2 + "]");
        System.out.println("========================================");

        if (!currentBatch2.equals(expectedBatch2)) {
            System.out.println("❌❌❌ BATCH CHANGED AFTER DATE PICKER! ❌❌❌");
            System.out.println("🔧 FIX: Re-selecting the correct batch...");

            // RE-SELECT the correct batch
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            WebElement batchDropdownTrigger2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/span"));
            batchDropdownTrigger2.click();
            Thread.sleep(1000);

            WebElement batchElement2 = driver.findElement(By.xpath("//span[text()='" + expectedBatch2 + "']"));
            js2.executeScript("arguments[0].click();", batchElement2);
            System.out.println("✅ Re-clicked correct batch: " + expectedBatch2);
            Thread.sleep(3000);

            // Verify it stuck this time
            WebElement batchDisplay3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/span"));
            String finalBatch = batchDisplay3.getText().trim();
            if (!finalBatch.equals(expectedBatch2)) {
                throw new RuntimeException("❌ Still wrong after retry: " + finalBatch);
            }
            System.out.println("✅✅✅ Batch corrected successfully!");
        } else {
            System.out.println("✅ Batch still correct after date picker");
        }

        // DEBUG: Check if there are any validation errors after date selection
        try {
            java.util.List<WebElement> errorMessages = driver.findElements(By.xpath("//*[contains(@class, 'error') or contains(@class, 'invalid') or contains(@style, 'red')]"));
            if (!errorMessages.isEmpty()) {
                System.out.println("⚠️ WARNING: Found validation errors after date selection:");
                for (WebElement error : errorMessages) {
                    if (error.isDisplayed() && !error.getText().trim().isEmpty()) {
                        System.out.println("  - " + error.getText());
                    }
                }
            }
        } catch (Exception e) {
            // Ignore if no errors found
        }
    }

    @And("the admin enters the batch name that was created earlier")
    public void the_admin_enters_the_batch_name_that_was_created_earlier() throws InterruptedException {
        // RETRIEVE batch name from ScenarioContext
        String batchName = (String) ScenarioContext.getContext("BATCH_NAME");

        if (batchName == null || batchName.isEmpty()) {
            throw new RuntimeException("❌ ERROR: Batch name not found in ScenarioContext! " +
                    "Make sure to create a batch first before trying to send it.");
        }

        System.out.println("✅ Retrieved batch name from ScenarioContext: " + batchName);

        // Enter the batch name in the batch name field
        // TODO: Update this XPath with the correct element locator for batch name input field
        WebElement batchNameField = driver.findElement(By.xpath("//input[@placeholder='Enter batch name']"));
        batchNameField.clear();
        batchNameField.sendKeys(batchName);

        System.out.println("✅ Entered batch name for sending: " + batchName);
        Thread.sleep(1000);
    }

    // ==================================================================================
    // FUTURE ENHANCEMENT: Uncomment below code when ready to implement bulk send loop
    // ==================================================================================

//    @When("the admin enters notice ID range from {string} to {string}")
//    public void the_admin_enters_notice_id_range(String startId, String endId) throws InterruptedException {
//        String baseNoticeId = "IN3155-";
//
//        for (int i = 1; i <= 10; i++) {  // Replace 10 with the desired number of iterations
//            // Construct the notice ID
//            String noticeId = baseNoticeId + i;
//
//            // Wait for the first input field to be visible and send keys
//            WebElement firstInputField = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/input"));
//            firstInputField.sendKeys(noticeId);
//
//            // Construct the next notice ID
//            String nextNoticeId = baseNoticeId + (i + 1);
//
//            // Wait for the second input field to be visible and send keys
//            WebElement secondInputField = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/input"));
//            secondInputField.sendKeys(nextNoticeId);
//
//            // Click the button
//            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[4]/button")).click();
//
//            // Wait for the confirmation button to be clickable and click it
//            WebElement confirmButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
//            confirmButton.click();
//
//            // Clear the input fields
//            firstInputField.clear();
//            secondInputField.clear();
//
//            Thread.sleep(1000);
//        }
//    }
//
//    @Then("all notices should be sent successfully")
//    public void all_notices_should_be_sent_successfully() {
//        System.out.println("All notices sent successfully");
//    }
}
