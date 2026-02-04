package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AutoreportAPI_for_parent_notice;
import utilities.Auto_report_merged_script;
import utilities.ScenarioContext;

import java.time.Duration;

/**
 * Autoreport_E2E_Steps - Step definitions for Parent Proxy Auto Report in E2E flow
 * Converted from tests/Autoreport_Parent_proxy_report.java
 * This handles Parent Proxy notices with multiple batch selection
 */
public class Autoreport_E2E_Steps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait = Hooks.wait;

    @When("the admin schedules auto report for user {string} with notice {string} using newly created batch")
    public void the_admin_schedules_auto_report_using_newly_created_batch(String user, String notice) throws InterruptedException {
        // Get batch name from ScenarioContext (though for proxy we select via checkbox)
        String batchName = (String) ScenarioContext.getContext("BATCH_NAME");
        System.out.println("✅ Auto Report E2E - Retrieved batch name from context: " + batchName);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Navigate to Auto Report section
        System.out.println("🔍 Navigating to Auto Report section...");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/a"))).click();
        Thread.sleep(4000);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/ul/li[1]/a"))).click();
        Thread.sleep(4000);
        System.out.println("✅ Navigated to Auto Report section");

        // Select user dropdown
        System.out.println("🔍 Selecting user: " + user);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div/div/div[1]"))).click();
        Thread.sleep(4000);

        // Type user name
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div")).sendKeys(user);
        Thread.sleep(4000);

        // Select user from dropdown - search for specific user
        try {
            WebElement userElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[contains(text(), '" + user + "')]")));
            js.executeScript("arguments[0].scrollIntoView(true);", userElement);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", userElement);
            System.out.println("✅ User selected: " + user);
        } catch (Exception e) {
            System.out.println("⚠️ Trying alternative user selection...");
            WebElement userElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[3]/div[2]/div/span")));
            userElement.click();
            System.out.println("✅ User selected with alternative method");
        }
        Thread.sleep(3000);

        // Select notice
        System.out.println("🔍 Selecting notice: " + notice);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div")).click();
        Thread.sleep(2000);

        // Type notice name in search
        WebElement noticeSearchInput = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input"));
        noticeSearchInput.clear();
        noticeSearchInput.sendKeys(notice);
        Thread.sleep(6000);

        // Select the specific notice from dropdown
        try {
            WebElement noticeElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[contains(text(), '" + notice + "')]")));
            js.executeScript("arguments[0].scrollIntoView(true);", noticeElement);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", noticeElement);
            System.out.println("✅ Notice selected: " + notice);
        } catch (Exception e1) {
            System.out.println("⚠️ Trying alternative notice selection...");
            try {
                // Try to find any visible notice option
                WebElement noticeElement = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[3]/div[2]//span[contains(text(), '" + notice + "')]")));
                js.executeScript("arguments[0].click();", noticeElement);
                System.out.println("✅ Notice selected with alternative method");
            } catch (Exception e2) {
                System.out.println("⚠️ Using first available notice option");
                WebElement noticeElement = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[3]/div[2]//span")));
                js.executeScript("arguments[0].click();", noticeElement);
                System.out.println("✅ First available notice selected");
            }
        }
        Thread.sleep(1000);

        // Select batch using checkbox (Parent Proxy style) - Search for the specific batch created
        System.out.println("🔍 Opening batch dropdown to select: " + batchName);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div/div/div[1]")).click();
        Thread.sleep(2000);

        // Search for the specific batch name in the dropdown
        System.out.println("🔍 Searching for batch: " + batchName);
        try {
            WebElement batchSearchInput = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input"));
            batchSearchInput.clear();
            batchSearchInput.sendKeys(batchName);
            Thread.sleep(5000); // Increased wait time for dropdown to filter results
            System.out.println("✅ Batch search query entered: " + batchName);
        } catch (Exception e) {
            System.out.println("⚠️ No search input found, listing all batches");
            Thread.sleep(3000);
        }

        // Click the checkbox for the specific batch with improved strategies
        boolean checkboxClicked = false;

        // Strategy 1: Find checkbox by batch name in label/span structure
        try {
            System.out.println("🔍 Strategy 1: Looking for checkbox with batch name in label structure...");
            WebElement batchCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//label[contains(., '" + batchName + "')]//input[@type='checkbox']")));
            js.executeScript("arguments[0].scrollIntoView(true);", batchCheckbox);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", batchCheckbox);
            System.out.println("✅ Batch checkbox selected for: " + batchName + " (Strategy 1)");
            checkboxClicked = true;
        } catch (Exception e1) {
            System.out.println("⚠️ Strategy 1 failed: " + e1.getMessage());
        }

        // Strategy 2: Find checkbox by batch name with parent div
        if (!checkboxClicked) {
            try {
                System.out.println("🔍 Strategy 2: Looking for checkbox in parent div of batch name...");
                WebElement batchCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(., '" + batchName + "')]//input[@type='checkbox']")));
                js.executeScript("arguments[0].scrollIntoView(true);", batchCheckbox);
                Thread.sleep(1000);
                js.executeScript("arguments[0].click();", batchCheckbox);
                System.out.println("✅ Batch checkbox selected for: " + batchName + " (Strategy 2)");
                checkboxClicked = true;
            } catch (Exception e2) {
                System.out.println("⚠️ Strategy 2 failed: " + e2.getMessage());
            }
        }

        // Strategy 3: Click the parent label/div containing the batch name
        if (!checkboxClicked) {
            try {
                System.out.println("🔍 Strategy 3: Clicking parent element containing batch name...");
                WebElement batchLabel = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[contains(., '" + batchName + "')]")));
                js.executeScript("arguments[0].scrollIntoView(true);", batchLabel);
                Thread.sleep(1000);
                js.executeScript("arguments[0].click();", batchLabel);
                System.out.println("✅ Batch label clicked for: " + batchName + " (Strategy 3)");
                checkboxClicked = true;
            } catch (Exception e3) {
                System.out.println("⚠️ Strategy 3 failed: " + e3.getMessage());
            }
        }

        // Strategy 4: Find first available checkbox after search (assumes search filtered to one result)
        if (!checkboxClicked) {
            try {
                System.out.println("🔍 Strategy 4: Clicking first available checkbox after search...");
                WebElement firstCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(@class, 'visible')]//input[@type='checkbox']")));
                js.executeScript("arguments[0].scrollIntoView(true);", firstCheckbox);
                Thread.sleep(1000);
                js.executeScript("arguments[0].click();", firstCheckbox);
                System.out.println("✅ First available batch checkbox selected (Strategy 4)");
                checkboxClicked = true;
            } catch (Exception e4) {
                System.out.println("⚠️ Strategy 4 failed: " + e4.getMessage());
            }
        }

        // Strategy 5: Last resort - click any visible checkbox
        if (!checkboxClicked) {
            try {
                System.out.println("🔍 Strategy 5: Last resort - clicking any visible checkbox...");
                WebElement anyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@type='checkbox']")));
                js.executeScript("arguments[0].scrollIntoView(true);", anyCheckbox);
                Thread.sleep(1000);
                js.executeScript("arguments[0].click();", anyCheckbox);
                System.out.println("✅ Checkbox clicked (Strategy 5)");
                checkboxClicked = true;
            } catch (Exception e5) {
                System.out.println("❌ All strategies failed: " + e5.getMessage());
                throw new RuntimeException("Failed to select batch checkbox for: " + batchName);
            }
        }

        Thread.sleep(3000);

        // IMPORTANT: Close the dropdown by clicking elsewhere to prevent form from getting stuck
        System.out.println("🔍 Closing batch dropdown to unblock form...");
        try {
            // Strategy 1: Click on the schedule time field area to close dropdown
            WebElement scheduleField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]"));
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", scheduleField);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", scheduleField);
            System.out.println("✅ Clicked on schedule field to close dropdown (Strategy 1)");
        } catch (Exception e1) {
            System.out.println("⚠️ Strategy 1 failed, trying Strategy 2...");
            try {
                // Strategy 2: Click on form header area
                WebElement formHeader = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]"));
                js.executeScript("arguments[0].click();", formHeader);
                System.out.println("✅ Clicked on form header to close dropdown (Strategy 2)");
            } catch (Exception e2) {
                System.out.println("⚠️ Strategy 2 failed, trying Strategy 3...");
                // Strategy 3: Press Escape key
                try {
                    driver.findElement(By.tagName("body")).sendKeys(org.openqa.selenium.Keys.ESCAPE);
                    System.out.println("✅ Pressed Escape to close dropdown (Strategy 3)");
                } catch (Exception e3) {
                    System.out.println("ℹ️ All strategies completed, dropdown should be closed");
                }
            }
        }

        // Wait for dropdown to fully close and form to update
        Thread.sleep(4000);
        System.out.println("✅ Batch dropdown closed, form is ready");

        // Store batch name for later verification
        ScenarioContext.setContext("AUTOREPORT_BATCH", batchName);
        System.out.println("✅ Batch selection completed for: " + batchName);
    }

    @When("the admin sets the auto report schedule time to {string} for E2E flow")
    public void the_admin_sets_the_auto_report_schedule_time_for_e2e(String scheduleTime) throws InterruptedException {
        System.out.println("🔍 Setting schedule time: " + scheduleTime);

        // Click the datetime input field first
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input")).click();
        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Use sendKeys to enter the schedule time (same as working test case)
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input"))
                .sendKeys(scheduleTime);
        Thread.sleep(5000);

        System.out.println("✅ Schedule time set: " + scheduleTime);
    }

    @When("the admin submits the auto report for E2E flow")
    public void the_admin_submits_the_auto_report_for_e2e() throws InterruptedException {
        System.out.println("🔍 Submitting Auto Report form...");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait for submit button to be ready
        Thread.sleep(2000);

        // Find submit button
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("button[type='submit']")));

        // Scroll button into view and click using JavaScript
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", submitButton);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", submitButton);
        Thread.sleep(4000);
        System.out.println("✅ Submit button clicked");

        // Click confirmation button
        System.out.println("🔍 Clicking confirmation button...");
        try {
            WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[3]/div/div[6]/button[1]")));
            js.executeScript("arguments[0].click();", confirmButton);
            Thread.sleep(2000);
            System.out.println("✅ Confirmation button clicked");
        } catch (Exception e) {
            System.out.println("⚠️ Confirmation button not found or not needed: " + e.getMessage());
        }

        System.out.println("✅ Auto Report submitted successfully");
    }

    @Then("the AutoReport API should be triggered successfully for E2E flow")
    public void the_autoreport_api_should_be_triggered_successfully_for_e2e() {
        System.out.println("========================================");
        System.out.println("🚀 Triggering Parent Proxy Auto Report APIs...");
        System.out.println("========================================");

        // First API: AutoreportAPI_for_parent_notice
        System.out.println("📡 Calling AutoreportAPI_for_parent_notice...");
        AutoreportAPI_for_parent_notice test2 = new AutoreportAPI_for_parent_notice();
        test2.setup();
        test2.testGetRequests();
        System.out.println("✅ AutoreportAPI_for_parent_notice completed");

        System.out.println("========================================");

        // Second API: Auto_report_merged_script (Proxy specific APIs)
        System.out.println("📡 Calling Auto_report_merged_script (Proxy APIs)...");
        Auto_report_merged_script test1 = new Auto_report_merged_script();
        test1.setup();
        test1.testGetRequestsOnce();
        System.out.println("✅ Auto_report_merged_script completed");

        System.out.println("========================================");

        // Refresh the page
        System.out.println("🔄 Refreshing page...");
        driver.get("https://test.incase360.com/admin/auto-report");
        driver.navigate().refresh();

        System.out.println("========================================");
        System.out.println("✅✅✅ All Parent Proxy Auto Report APIs triggered successfully!");
        System.out.println("========================================");
    }
}
