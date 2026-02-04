package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;
import utilities.SendScheduledNoticeAPI;

/**
 * BulkSend_for_Express_Proxy_notice_Steps - Contains UNIQUE step definitions specific to Express Proxy Notice
 *
 * This file only contains steps that are UNIQUE to express proxy notice bulk send:
 * - Selecting date from date picker (express proxy specific implementation - different from standard)
 *
 * Common steps (login, navigation, user selection, notice type, submit, confirmation, etc.) are in CommonSteps.java
 */
public class BulkSend_for_Express_Proxy_notice_Steps {

    private WebDriver driver;

    public BulkSend_for_Express_Proxy_notice_Steps() {
        // Get the WebDriver instance from DriverFactory (managed by Hooks)
        this.driver = DriverFactory.getDriver();
    }

    // ==================================================================================
    // UNIQUE STEPS FOR EXPRESS PROXY NOTICE
    // ==================================================================================

    @And("the admin selects a date from the date picker")
    public void the_admin_selects_a_date_from_the_date_picker() throws InterruptedException {
        // Click on the date picker element (Express proxy specific implementation)
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div"));
        element.click();
        Thread.sleep(1000);

        // Select a specific date
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[9]/span"));
        element1.click();
        System.out.println("Date selected from date picker (express proxy)");
    }

    @Then("the sendScheduledNotice API should be triggered")
    public void the_send_scheduled_notice_api_should_be_triggered() throws InterruptedException {
        System.out.println("========================================");
        System.out.println("⏱️ Waiting 5 seconds before triggering API...");
        System.out.println("========================================");
        Thread.sleep(5000); // Wait for backend to process

        // Trigger the API
        SendScheduledNoticeAPI api = new SendScheduledNoticeAPI();
        api.setup();
        api.sendScheduledNoticeAPI();

        System.out.println("========================================");
        System.out.println("✅ sendScheduledNotice API call completed!");
        System.out.println("========================================");
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
//
//            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/input")).sendKeys("IN3155-1");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/input")).sendKeys("IN3155-4");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[4]/button")).click();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
//        }
//    }
//
//    @Then("all notices should be sent successfully")
//    public void all_notices_should_be_sent_successfully() {
//        System.out.println("All notices sent successfully");
//    }
}
