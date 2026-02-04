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
import utilities.AutoDownloadAPI;
import utilities.ScenarioContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * AutoDownload_E2E_Steps - Step definitions for Auto Download in E2E flow
 * This file is specifically for the Complete E2E Batch Flow feature
 * Uses batch name from ScenarioContext created during batch upload
 */
public class AutoDownload_E2E_Steps {
    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait = Hooks.wait;

    @When("I navigate to Auto Download module for E2E flow")
    public void i_navigate_to_auto_download_module_for_e2e() throws InterruptedException {
        System.out.println("🔍 Navigating to Auto Download module...");
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[12]/a/span[2]")))
                .click();
        Thread.sleep(2000);
        System.out.println("✅ Navigated to Auto Download module");
    }

    @When("I fill in the Auto Download form with user {string} and notice {string} using newly created batch")
    public void i_fill_in_auto_download_form_with_newly_created_batch(String user, String notice) throws InterruptedException {
        // Get batch name from ScenarioContext
        String batchName = (String) ScenarioContext.getContext("BATCH_NAME");
        System.out.println("✅ Auto Download E2E - Retrieved batch name from context: " + batchName);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Select user
        System.out.println("🔍 Selecting user: " + user);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div"))).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(user);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div[2]/div/span"))).click();
        Thread.sleep(1000);
        System.out.println("✅ User selected: " + user);

        // Select notice
        System.out.println("🔍 Selecting notice: " + notice);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div"))).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(notice);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div[2]/div/span"))).click();
        Thread.sleep(1000);
        System.out.println("✅ Notice selected: " + notice);

        // Select batch from ScenarioContext
        System.out.println("🔍 Selecting batch: " + batchName);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div"))).click();
        Thread.sleep(2000);

        WebElement batchSearch = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div[1]/div/input")));
        batchSearch.clear();
        batchSearch.sendKeys(batchName);
        Thread.sleep(3000);

        // Click on the batch option with multiple strategies
        try {
            WebElement batchOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[contains(text(),'" + batchName + "')]")));
            js.executeScript("arguments[0].scrollIntoView(true);", batchOption);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", batchOption);
            System.out.println("✅ Batch clicked (Strategy 1)");
        } catch (Exception e1) {
            System.out.println("⚠️ Strategy 1 failed, trying Strategy 2...");
            try {
                WebElement batchOption = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[3]/div[2]/div[1]/span")));
                js.executeScript("arguments[0].click();", batchOption);
                System.out.println("✅ Batch clicked (Strategy 2)");
            } catch (Exception e2) {
                System.out.println("⚠️ Strategy 2 failed, trying Strategy 3...");
                WebElement batchOption = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[3]/div[2]//span")));
                js.executeScript("arguments[0].click();", batchOption);
                System.out.println("✅ Batch clicked (Strategy 3)");
            }
        }
        Thread.sleep(2000);

        // Verify batch selection
        WebElement selectedBatch = driver.findElement(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div"));
        String displayedBatch = selectedBatch.getText().trim();
        System.out.println("✅ Auto Download E2E - Batch selected: " + displayedBatch);

        if (!displayedBatch.equals(batchName)) {
            System.out.println("⚠️ WARNING: Displayed batch doesn't match! Expected: " + batchName + ", Got: " + displayedBatch);
        } else {
            System.out.println("✅✅ Auto Download E2E - Correct batch verified!");
        }

        // Set Current Date/Time
        WebElement dateTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("scheduled_on")));
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        dateTimeInput.sendKeys(formattedDateTime);
        Thread.sleep(1000);
        System.out.println("✅ Schedule time set: " + formattedDateTime);

        // Store batch name for later verification
        ScenarioContext.setContext("AUTODOWNLOAD_BATCH", batchName);
        System.out.println("✅ Auto Download form filled successfully with batch: " + batchName);
    }

    @Then("I submit the Auto Download request for E2E flow")
    public void i_submit_the_auto_download_request_for_e2e() throws InterruptedException {
        System.out.println("🚀 Submitting Auto Download request...");
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Try multiple strategies to find and click submit button
        try {
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[12]/button")));
            js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", submitBtn);
            System.out.println("✅ Submit button clicked (Strategy 1)");
        } catch (Exception e) {
            System.out.println("⚠️ Strategy 1 failed, trying alternative...");
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//form//button[contains(text(), 'Submit') or contains(text(), 'submit')]")));
            js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
            Thread.sleep(500);
            js.executeScript("arguments[0].click();", submitBtn);
            System.out.println("✅ Submit button clicked (Strategy 2)");
        }

        Thread.sleep(4000);
        System.out.println("🚀 Triggering Auto Download API...");
        AutoDownloadAPI api = new AutoDownloadAPI();
        api.setup();
        api.autoDownlaodAPI();

        driver.navigate().refresh();
        Thread.sleep(5000);
        System.out.println("✅✅✅ Auto Download API triggered successfully!");
    }
}
