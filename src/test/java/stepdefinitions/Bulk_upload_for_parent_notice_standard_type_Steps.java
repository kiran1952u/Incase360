package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Login_functionality_admin;
import utilities.Proxy_pdf_generation;
import utilities.ScenarioContext;
import hooks.Hooks;

import java.util.UUID;

public class Bulk_upload_for_parent_notice_standard_type_Steps {
    private WebDriver driver = Hooks.driver;
    private String batchName;

    @Given("Admin logs into the application")
    public void adminLogsIntoTheApplication() throws InterruptedException {
        Login_functionality_admin test = new Login_functionality_admin();
        test.loginTest(driver);
        Thread.sleep(5000);
    }

    @When("Admin navigates to bulk upload section")
    public void adminNavigatesToBulkUploadSection() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[5]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[5]/ul/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div")).click();
        Thread.sleep(2000);
    }

    @And("Admin searches for user {string}")
    public void adminSearchesForUser(String username) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/input")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
        Thread.sleep(2000);
    }

    @And("Admin selects option {int} from first dropdown")
    public void adminSelectsOptionFromFirstDropdown(int optionNumber) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select")).click();
        WebElement option = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select/option[" + optionNumber + "]"));
        option.click();
        Thread.sleep(2000);
    }

    @And("Admin selects option {int} from second dropdown")
    public void adminSelectsOptionFromSecondDropdown(int optionNumber) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select")).click();
        WebElement option = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select/option[" + optionNumber + "]"));
        option.click();
        Thread.sleep(2000);
    }

    @And("Admin uploads CSV file {string}")
    public void adminUploadsCsvFile(String fileName) throws InterruptedException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\" + fileName;
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
        fileInput.sendKeys(filePath);
        Thread.sleep(3000);
    }

    @And("Admin enters batch name with prefix {string}")
    public void adminEntersBatchNameWithPrefix(String prefix) {
        // Generate unique batch name with random UUID
        batchName = prefix + UUID.randomUUID().toString().substring(0, 8);

        // IMPORTANT: Store batch name in ScenarioContext so other steps can access it
        ScenarioContext.setContext("BATCH_NAME", batchName);
        System.out.println("✅ Batch created: " + batchName);

        // Enter batch name in the UI
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[2]/input")).sendKeys(batchName);
    }

    @And("Admin clicks submit button")
    public void adminClicksSubmitButton() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[5]/button"));
        button.click();
        Thread.sleep(6000);
    }

    @And("Admin confirms the upload")
    public void adminConfirmsTheUpload() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
    }

    @And("System triggers parent API for PDF generation")
    public void systemTriggersParentApiForPdfGeneration() {
        Proxy_pdf_generation apistest = new Proxy_pdf_generation();
        apistest.parentApiEntry();
    }

    @Then("Page should be refreshed successfully")
    public void pageShouldBeRefreshedSuccessfully() throws InterruptedException {
        driver.navigate().refresh();
        System.out.println("Page refreshed");

        // CRITICAL: Wait for backend to process the batch before navigating to bulk send
        System.out.println("========================================");
        System.out.println("⏱️ Waiting 10 seconds for batch to be processed by backend...");
        System.out.println("========================================");
        Thread.sleep(10000);  // Wait 10 seconds for batch to be available in bulk send dropdown
    }
}
