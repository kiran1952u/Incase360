package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;

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
        // Select option 28 from additional dropdown
        // This is a specific requirement for standard notice type
        WebElement element3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/select/option[" + optionNumber + "]"));
        element3.click();
        Thread.sleep(1000);
        System.out.println("Selected option " + optionNumber + " from additional dropdown");
    }

    @And("the admin opens the date picker and selects a date")
    public void the_admin_opens_the_date_picker_and_selects_a_date() throws InterruptedException {
        // Click to open the date picker (Standard notice specific implementation)
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]"));
        element1.click();
        Thread.sleep(3000);

        // Select a specific date from the date picker
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/span")).click();
        System.out.println("Date selected from date picker (standard notice)");
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
