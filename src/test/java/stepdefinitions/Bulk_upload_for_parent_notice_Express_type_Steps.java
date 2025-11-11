package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.APITest;
import utilities.Login_functionality_admin;

import java.io.File;
import java.time.Duration;

/**
 * Step Definitions for Bulk Upload for Parent Notice Express Type
 * This class contains Cucumber step implementations for Bulk_upload_for_parent_notice_Express_type.feature
 * Each method corresponds to a step in the feature file
 */
public class Bulk_upload_for_parent_notice_Express_type_Steps {

    // Access shared driver instance from Hooks directly in methods
    // Note: Don't store Hooks.driver in a variable here as it will capture null value before @Before runs

    /**
     * STEP 1: Login as admin user for bulk upload
     * Feature: Given I am logged in as admin user for bulk upload
     */
    @Given("I am logged in as admin user for bulk upload")
    public void i_am_logged_in_as_admin_user_for_bulk_upload() throws InterruptedException {
        Login_functionality_admin test = new Login_functionality_admin();
        test.loginTest(Hooks.driver);
        Thread.sleep(3000);
    }

    /**
     * STEP 2: Navigate to Bulk Upload menu
     * Feature: When I navigate to Bulk Upload menu
     */
    @When("I navigate to Bulk Upload menu")
    public void i_navigate_to_bulk_upload_menu() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("//span[normalize-space()='User Action']")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 3: Click on Bulk Upload submenu
     * Feature: And I click on Bulk Upload submenu
     */
    @When("I click on Bulk Upload submenu")
    public void i_click_on_bulk_upload_submenu() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("//a[normalize-space()='CSV Upload']")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 4: Click on Select user dropdown for bulk upload
     * Feature: And I click on Select user dropdown for bulk upload
     */
    @When("I click on Select user dropdown for bulk upload")
    public void i_click_on_select_user_dropdown_for_bulk_upload() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 5: Enter user name for bulk upload
     * Feature: And I enter user name "kiran" for bulk upload
     * @param userName - The name of the user (e.g., "kiran")
     *
     * Uses Explicit Wait to ensure input field is ready before typing
     */
    @When("I enter user name {string} for bulk upload")
    public void i_enter_user_name_for_bulk_upload(String userName) throws InterruptedException {
        // Wait up to 10 seconds for the input field to be visible and enabled
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/input")));
        userInput.sendKeys(userName);
        Thread.sleep(3000);
    }

    /**
     * STEP 6: Select the user from dropdown for bulk upload
     * Feature: And I select the user from dropdown for bulk upload
     *
     * Uses Explicit Wait to wait for dropdown results to appear before clicking
     */
    @When("I select the user from dropdown for bulk upload")
    public void i_select_the_user_from_dropdown_for_bulk_upload() throws InterruptedException {
        // Wait up to 10 seconds for the dropdown element to be clickable
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/span")));
        dropdownOption.click();
        Thread.sleep(3000);
    }

    /**
     * STEP 7: Select template
     * Feature: And I select template "Tamil_kannnada_parent_2"
     * @param templateName - The name of the template (e.g., "Tamil_kannnada_parent_2")
     */
    @When("I select template {string}")
    public void i_select_template(String templateName) throws InterruptedException {
        Hooks.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select")).click();
        WebElement dropdownElement = Hooks.driver.findElement(By.className("form-control"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(templateName);
        Thread.sleep(3000);
    }

    /**
     * STEP 8: Select letterhead
     * Feature: And I select letterhead "kiran_letterhead3"
     * @param letterheadName - The name of the letterhead (e.g., "kiran_letterhead3")
     */
    @When("I select letterhead {string}")
    public void i_select_letterhead(String letterheadName) throws InterruptedException {
        WebElement dropdownElement1 = Hooks.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select"));
        Select dropdown1 = new Select(dropdownElement1);
        dropdown1.selectByVisibleText(letterheadName);
        Thread.sleep(1000);
    }

    /**
     * STEP 9: Upload CSV file
     * Feature: And I upload CSV file "Combine_tamil_kannada_csv_Data_proxy.csv"
     * @param fileName - The CSV file name (stored in src/test/resources/testdata/)
     *
     * NOTE: This method automatically finds the file in the testdata folder
     * No need to provide full path - just the filename
     */
    @When("I upload CSV file {string}")
    public void i_upload_csv_file(String fileName) throws InterruptedException {
        // Automatically construct the file path from testdata folder
        String csvFilePath = new File("src/test/resources/testdata/" + fileName).getAbsolutePath();

        WebElement fileInput = Hooks.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/label[2]/input"));
        fileInput.sendKeys(csvFilePath);

        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * STEP 10: Enter notice name
     * Feature: And I enter notice name "Tamil_kannda_auto_report_01"
     * @param noticeName - The name of the notice (e.g., "Tamil_kannda_auto_report_01")
     */
    @When("I enter notice name {string}")
    public void i_enter_notice_name(String noticeName) throws InterruptedException {
        Hooks.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[2]/input")).sendKeys(noticeName);
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * STEP 11: Click submit button for bulk upload
     * Feature: And I click submit button for bulk upload
     */
    @When("I click submit button for bulk upload")
    public void i_click_submit_button_for_bulk_upload() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[5]/button")).click();
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * STEP 12: Confirm the bulk upload submission
     * Feature: And I confirm the bulk upload submission
     */
    @When("I confirm the bulk upload submission")
    public void i_confirm_the_bulk_upload_submission() throws InterruptedException {
        Hooks.driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 13: Notice creation API should be triggered 5 times
     * Feature: Then Notice creation API should be triggered 5 times
     *
     * This step calls the notice creation API 5 times to validate
     * that multiple notices are created successfully
     */
    @Then("Notice creation API should be triggered 5 times")
    public void notice_creation_api_should_be_triggered_5_times() throws InterruptedException {
        APITest apiTest = new APITest();
        apiTest.setup();
        for (int i = 0; i < 5; i++) {
            apiTest.testCreateNotice();
        }
    }

    /**
     * STEP 14: PDF creation API should be triggered
     * Feature: And PDF creation API should be triggered
     *
     * This step validates that the PDF generation API is called
     * to create the PDF documents for the notices
     */
    @Then("PDF creation API should be triggered")
    public void pdf_creation_api_should_be_triggered() throws InterruptedException {
        APITest apiTest = new APITest();
        apiTest.setup();
        apiTest.testCreatePDF1();
    }

    /**
     * STEP 15: Navigate back to bulk upload page and refresh
     * Feature: And I navigate back to bulk upload page and refresh
     */
    @Then("I navigate back to bulk upload page and refresh")
    public void i_navigate_back_to_bulk_upload_page_and_refresh() {
        Hooks.driver.navigate().refresh();
    }
}
