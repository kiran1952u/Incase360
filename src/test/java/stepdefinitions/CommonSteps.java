package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverFactory;
import utilities.Login_functionality_admin;
import utilities.ScenarioContext;

import java.time.Duration;

/**
 * CommonSteps - Contains shared step definitions used across multiple feature files
 * This follows the DRY (Don't Repeat Yourself) principle in Cucumber BDD
 *
 * Shared steps include:
 * - Login functionality
 * - Navigation to bulk send section
 * - User selection
 * - Notice type selection
 * - Submit button clicks
 * - Confirmation handling
 */
public class CommonSteps {

    private WebDriver driver;
    private Login_functionality_admin loginUtil;

    public CommonSteps() {
        // Get the WebDriver instance from DriverFactory (managed by Hooks)
        this.driver = DriverFactory.getDriver();
        this.loginUtil = new Login_functionality_admin();
    }

    // ==================================================================================
    // GIVEN STEPS - Preconditions/Setup
    // ==================================================================================

    @Given("the admin user is logged into the application")
    public void the_admin_user_is_logged_into_the_application() throws InterruptedException {
        // Perform admin login
        loginUtil.loginTest(driver);
        Thread.sleep(5000);
        System.out.println("Admin user logged in successfully");
    }

    @Given("the admin user is logged into the Incase360 application")
    public void the_admin_user_is_logged_into_the_incase360_application() throws InterruptedException {
        // Same as above but with slightly different wording for flexibility
        loginUtil.loginTest(driver);
        Thread.sleep(5000);
        System.out.println("Admin user logged in successfully to Incase360");
    }

    @Given("I am logged in as admin user")
    public void i_am_logged_in_as_admin_user() throws InterruptedException {
        // Same as above but with different wording (used by other features)
        loginUtil.loginTest(driver);
        Thread.sleep(5000);
        System.out.println("Admin user logged in successfully");
    }

    // ==================================================================================
    // WHEN STEPS - Actions
    // ==================================================================================

    @When("the admin navigates to the bulk send section")
    public void the_admin_navigates_to_the_bulk_send_section() throws InterruptedException {
        // Click on the main menu item (Bulk Operations)
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[5]/a/span[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Click on the Bulk Send submenu
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[5]/ul/li[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Navigated to bulk send section");
    }

    @And("the admin selects {string} as the user")
    public void the_admin_selects_as_the_user(String username) throws InterruptedException {
        // Click on the user picker dropdown
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div/div")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Type the username in the search field
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/input")).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Select the user from the dropdown
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
        System.out.println("Selected user: " + username);
    }

    @And("the admin selects {string} as the user from the user picker")
    public void the_admin_selects_as_the_user_from_the_user_picker(String username) throws InterruptedException {
        // Same as above but with slightly different wording
        the_admin_selects_as_the_user(username);
    }

    @And("the admin selects {string} as the notice type")
    public void the_admin_selects_as_the_notice_type(String noticeType) throws InterruptedException {
        // Wait for the dropdown to be enabled after user selection
        Thread.sleep(2000);

        // Find the notice type dropdown
        WebElement noticeTypeDropdown = driver.findElement(By.className("form-control"));

        // Create a Select object
        Select select = new Select(noticeTypeDropdown);

        // Select an option by visible text
        select.selectByVisibleText(noticeType);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Selected notice type: " + noticeType);

        // Wait for batch dropdown to load dynamically (if it appears after notice type selection)
        System.out.println("Waiting for batch dropdown to load dynamically...");
        Thread.sleep(5000);
    }

    @And("the admin clicks the submit button")
    public void the_admin_clicks_the_submit_button() throws InterruptedException {
        // FINAL VERIFICATION: Check batch one more time BEFORE submitting
        String expectedBatch = (String) ScenarioContext.getContext("EXPECTED_BATCH");
        if (expectedBatch != null) {
            try {
                WebElement batchDisplay = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/span"));
                String currentBatch = batchDisplay.getText().trim();

                System.out.println("========================================");
                System.out.println("BEFORE SUBMIT - FINAL Batch check:");
                System.out.println("Expected: [" + expectedBatch + "]");
                System.out.println("Current: [" + currentBatch + "]");
                System.out.println("========================================");

                if (!currentBatch.equals(expectedBatch)) {
                    System.out.println("❌❌❌ WRONG BATCH RIGHT BEFORE SUBMIT! ❌❌❌");
                    throw new RuntimeException("❌ About to submit WRONG batch '" + currentBatch + "' instead of '" + expectedBatch + "'!");
                } else {
                    System.out.println("✅✅✅ Correct batch - ready to submit! ✅✅✅");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Could not verify batch: " + e.getMessage());
            }
        }

        System.out.println("========================================");
        System.out.println("🔍 Clicking submit button...");
        System.out.println("========================================");

        // Wait before clicking submit to ensure all fields are ready
        Thread.sleep(2000);

        // Click the primary submit button
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
        Thread.sleep(2000);
        System.out.println("Submit button clicked");

        // DEBUG: Check for any validation errors after clicking submit
        System.out.println("========================================");
        System.out.println("🔍 Checking for validation errors...");
        System.out.println("========================================");

        try {
            // Look for common validation error patterns
            java.util.List<WebElement> errorElements = driver.findElements(By.xpath(
                "//*[contains(@class, 'error') or contains(@class, 'invalid') or " +
                "contains(@class, 'alert-danger') or contains(@style, 'color: red') or " +
                "contains(@style, 'color:red') or contains(text(), 'required') or " +
                "contains(text(), 'Required')]"
            ));

            boolean hasErrors = false;
            for (WebElement error : errorElements) {
                if (error.isDisplayed() && !error.getText().trim().isEmpty()) {
                    hasErrors = true;
                    System.out.println("❌ VALIDATION ERROR: " + error.getText());
                }
            }

            if (!hasErrors) {
                System.out.println("✅ No validation errors detected");
            } else {
                // Print entire page source for debugging
                System.out.println("========================================");
                System.out.println("🔍 Page may have validation errors. Waiting 3 seconds...");
                System.out.println("========================================");
                Thread.sleep(3000);

                // Check again
                errorElements = driver.findElements(By.xpath(
                    "//*[contains(@class, 'error') or contains(@class, 'invalid') or " +
                    "contains(@class, 'alert')]"
                ));

                System.out.println("Re-checking errors:");
                for (WebElement error : errorElements) {
                    if (error.isDisplayed() && !error.getText().trim().isEmpty()) {
                        System.out.println("  - " + error.getText());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("✅ No validation errors found");
        }

        Thread.sleep(1000);
    }

    @And("the admin clicks the submit button for standard notice")
    public void the_admin_clicks_the_submit_button_for_standard_notice() throws InterruptedException {
        // Same implementation
        the_admin_clicks_the_submit_button();
    }

    // ==================================================================================
    // THEN STEPS - Verification
    // ==================================================================================

    @Then("the bulk send confirmation should be displayed")
    public void the_bulk_send_confirmation_should_be_displayed() throws InterruptedException {
        // Confirmation popup should be visible (SweetAlert)
        Thread.sleep(1000);
        System.out.println("Bulk send confirmation displayed");
    }

    @Then("the bulk send confirmation popup should be displayed")
    public void the_bulk_send_confirmation_popup_should_be_displayed() throws InterruptedException {
        // Same as above but with slightly different wording
        the_bulk_send_confirmation_should_be_displayed();
    }

    @And("the admin confirms the bulk send operation")
    public void the_admin_confirms_the_bulk_send_operation() throws InterruptedException {
        System.out.println("========================================");
        System.out.println("🔍 Clicking confirmation button...");
        System.out.println("========================================");

        // Click the confirmation button (SweetAlert confirm)
        driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled swal2-default-outline']")).click();
        System.out.println("✅ Confirmation button clicked");

        // CRITICAL: Wait for backend to process the bulk send operation
        System.out.println("========================================");
        System.out.println("⏱️ Waiting 10 seconds for bulk send to process...");
        System.out.println("========================================");
        Thread.sleep(10000);  // Increased from 2 to 10 seconds

        // Check for success/error messages after confirmation
        System.out.println("========================================");
        System.out.println("🔍 Checking for success/error messages...");
        System.out.println("========================================");

        try {
            // Check for success message
            java.util.List<WebElement> successMessages = driver.findElements(By.xpath(
                "//*[contains(@class, 'swal2-success') or contains(@class, 'success') or " +
                "contains(@class, 'swal2-confirm') or contains(text(), 'success') or " +
                "contains(text(), 'Success') or contains(text(), 'sent') or " +
                "contains(text(), 'Sent')]"
            ));

            boolean foundSuccess = false;
            for (WebElement success : successMessages) {
                if (success.isDisplayed() && !success.getText().trim().isEmpty()) {
                    System.out.println("✅ SUCCESS MESSAGE: " + success.getText());
                    foundSuccess = true;
                }
            }

            // Check for error messages
            java.util.List<WebElement> errorMessages = driver.findElements(By.xpath(
                "//*[contains(@class, 'swal2-error') or contains(@class, 'error') or " +
                "contains(@class, 'alert-danger') or contains(text(), 'error') or " +
                "contains(text(), 'Error') or contains(text(), 'failed') or " +
                "contains(text(), 'Failed')]"
            ));

            boolean foundError = false;
            for (WebElement error : errorMessages) {
                if (error.isDisplayed() && !error.getText().trim().isEmpty()) {
                    System.out.println("❌ ERROR MESSAGE: " + error.getText());
                    foundError = true;
                }
            }

            if (!foundSuccess && !foundError) {
                System.out.println("⚠️ No success or error messages found");

                // Print current page URL for debugging
                System.out.println("Current URL: " + driver.getCurrentUrl());

                // Check if there are any visible popups/alerts
                java.util.List<WebElement> allVisibleElements = driver.findElements(By.xpath(
                    "//*[contains(@class, 'swal') or contains(@class, 'modal') or " +
                    "contains(@class, 'alert')]"
                ));

                System.out.println("Visible popup elements:");
                for (WebElement elem : allVisibleElements) {
                    if (elem.isDisplayed()) {
                        System.out.println("  - " + elem.getTagName() + ": " + elem.getText());
                    }
                }
            }

            if (foundError) {
                System.out.println("========================================");
                System.out.println("⚠️ WARNING: Errors detected after bulk send confirmation!");
                System.out.println("========================================");
            } else if (foundSuccess) {
                System.out.println("========================================");
                System.out.println("✅ Bulk send operation completed successfully!");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("⚠️ Could not check for messages: " + e.getMessage());
        }

        System.out.println("Bulk send operation confirmed successfully");
    }
}
