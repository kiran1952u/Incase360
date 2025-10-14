package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AutoDownloadAPI;
import utilities.Login_functionality_admin;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Autodownload_with_tracking_express extends AutoDownloadAPI {

    private WebDriver driver;
    private WebDriverWait wait;
    private final Login_functionality_admin login = new Login_functionality_admin();
    private final AutoDownloadAPI autoDownloadAPI = new AutoDownloadAPI();

    @Given("the admin is logged into the system")
    public void admin_is_logged_into_the_system() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*",
                "--disable-dev-shm-usage",
                "--no-sandbox",
                "--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login.loginTest(driver);
        Thread.sleep(4000);
    }

    @When("the admin navigates to the autodownload page")
    public void admin_navigates_to_the_autodownload_page() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[12]/a/span[2]"))).click();
    }

    @When("selects user {string}")
    public void selects_user(String username) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div"))).click();
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/span"))).click();
    }

    @When("selects template {string}")
    public void selects_template(String template) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div"))).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(template);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/span"))).click();
    }

    @When("selects batch {string}")
    public void selects_batch(String batch) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/input"))).sendKeys(batch);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div[1]/span"))).click();
    }

    @When("sets the current date and time for scheduling")
    public void sets_current_date_time() {
        WebElement dateTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("scheduled_on")));
        LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        dateTimeInput.sendKeys(formattedDateTime);
    }

    @When("submits the autodownload form")
    public void submits_autodownload_form() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div/form/div/div[12]/button"))).click();
    }

    @Then("the autodownload API should be triggered successfully")
    public void autodownload_api_triggered() throws InterruptedException {
        autoDownloadAPI.setup();
        autoDownloadAPI.autoDownlaodAPI();
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.quit();
    }


}
