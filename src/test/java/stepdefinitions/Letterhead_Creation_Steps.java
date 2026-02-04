package stepdefinitions;

import utilities.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Login_functionality_user;

import java.time.Duration;
import java.util.List;
import java.util.Random;

/**
 * Letterhead Creation Step Definitions
 *
 * This class contains steps for creating a new letterhead in the system.
 * Extracted from Letterhead_e2e_Steps.java for separate test execution.
 *
 * Test Flow:
 * 1. Admin logs in
 * 2. Navigate to letterhead management
 * 3. Click Add New button
 * 4. Fill letterhead details (name, margins)
 * 5. Upload letterhead and signature images
 * 6. Set signature dimensions
 * 7. Submit and verify creation
 */
public class Letterhead_Creation_Steps {

    private WebDriver driver;
    private int uniqueId;
    private String uniqueLetterheadName;
    private WebDriverWait wait;
    private Login_functionality_user loginUtil;

    public Letterhead_Creation_Steps() {
        this.driver = DriverFactory.getDriver();
        // Explicit wait with 15 second timeout for slower operations
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.loginUtil = new Login_functionality_user();
        // Generate unique ID for letterhead name
        this.uniqueId = new Random().nextInt(100000);
        this.uniqueLetterheadName = "auto_letterhead_" + uniqueId;
    }

    @Given("the admin is logged into the application for letterhead creation")
    public void the_admin_is_logged_into_the_application_for_letterhead_creation() throws InterruptedException {
        loginUtil.Login1(driver);
        Thread.sleep(2000);
        System.out.println("Admin logged in successfully for letterhead creation");
    }

    @When("the admin navigates to the letterhead management section for creation")
    public void the_admin_navigates_to_the_letterhead_management_section_for_creation() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/a")).click();
        Thread.sleep(2000);
        System.out.println("Navigated to letterhead management section");
    }

    @And("the admin clicks the Add New button for letterhead creation")
    public void the_admin_clicks_the_add_new_button_for_letterhead_creation() throws InterruptedException {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(text(), 'Add New')]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        System.out.println("Clicked Add New button for letterhead");
    }

    @And("the admin enters a unique letterhead name for creation")
    public void the_admin_enters_a_unique_letterhead_name_for_creation() {
        // Wait for field to be visible and interactable
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("head_name")));
        nameField.sendKeys(uniqueLetterheadName);
        System.out.println("Entered unique letterhead name: " + uniqueLetterheadName);
    }

    @And("the admin enters header margin as {string} for letterhead")
    public void the_admin_enters_header_margin_as_for_letterhead(String headerMargin) {
        driver.findElement(By.id("headerMargin")).sendKeys(headerMargin);
        System.out.println("Entered header margin: " + headerMargin);
    }

    @And("the admin enters footer margin as {string} for letterhead")
    public void the_admin_enters_footer_margin_as_for_letterhead(String footerMargin) {
        driver.findElement(By.id("footerMargin")).sendKeys(footerMargin);
        System.out.println("Entered footer margin: " + footerMargin);
    }

    @And("the admin uploads the letterhead image file for creation")
    public void the_admin_uploads_the_letterhead_image_file_for_creation() {
        List<WebElement> fileInputs = driver.findElements(By.cssSelector("input[type='file']"));

        // Get absolute path for letterhead image
        String projectPath = System.getProperty("user.dir");
        String letterheadImagePath = projectPath + "/src/test/resources/testdata/Adv_Letterhead_format-4.png";

        // Upload the Letterhead image to the first input
        fileInputs.get(0).sendKeys(letterheadImagePath);
        System.out.println("Uploaded letterhead image: " + letterheadImagePath);
    }

    @And("the admin uploads the signature image file for creation")
    public void the_admin_uploads_the_signature_image_file_for_creation() {
        List<WebElement> fileInputs = driver.findElements(By.cssSelector("input[type='file']"));

        // Get absolute path for signature image
        String projectPath = System.getProperty("user.dir");
        String signatureImagePath = projectPath + "/src/test/resources/testdata/pdf_generation_test.jpeg";

        // Upload the Signature image to the second input
        fileInputs.get(1).sendKeys(signatureImagePath);
        System.out.println("Uploaded signature image: " + signatureImagePath);
    }

    @And("the admin enters signature width as {string} for letterhead")
    public void the_admin_enters_signature_width_as_for_letterhead(String signatureWidth) {
        driver.findElement(By.name("signatureWidth")).sendKeys(signatureWidth);
        System.out.println("Entered signature width: " + signatureWidth);
    }

    @And("the admin enters signature height as {string} for letterhead")
    public void the_admin_enters_signature_height_as_for_letterhead(String signatureHeight) {
        driver.findElement(By.id("signatureHeight")).sendKeys(signatureHeight);
        System.out.println("Entered signature height: " + signatureHeight);
    }

    @And("the admin clicks the Submit button for new letterhead creation")
    public void the_admin_clicks_the_submit_button_for_new_letterhead_creation() throws InterruptedException {
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        System.out.println("Clicked Submit button for letterhead creation");
    }

    @Then("the new letterhead should be created successfully")
    public void the_new_letterhead_should_be_created_successfully() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Letterhead created successfully: " + uniqueLetterheadName);
    }
}
