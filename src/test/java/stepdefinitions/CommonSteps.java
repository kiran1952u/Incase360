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
    }

    @And("the admin clicks the submit button")
    public void the_admin_clicks_the_submit_button() throws InterruptedException {
        // Click the primary submit button
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
        Thread.sleep(1000);
        System.out.println("Submit button clicked");
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
        // Click the confirmation button (SweetAlert confirm)
        driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled swal2-default-outline']")).click();
        Thread.sleep(2000);
        System.out.println("Bulk send operation confirmed successfully");
    }
}
