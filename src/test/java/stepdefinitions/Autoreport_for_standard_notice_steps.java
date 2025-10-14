package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AutoreportAPI_for_parent_notice;
import utilities.Login_functionality_admin;

import java.time.Duration;

public class Autoreport_for_standard_notice_steps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("Given the admin logs into the Incase360 application for STANDARD auto report")
    public void the_admin_logs_into_the_incase360_application_standard() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*","--disable-dev-shm-usage","--no-sandbox","--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        Login_functionality_admin login = new Login_functionality_admin();
        login.loginTest(driver);
        Thread.sleep(3000);
    }

    @When("the admin schedules a standard auto report for user {string} with notice {string} and batch {string}")
    public void the_admin_schedules_a_standard_auto_report(String user, String notice, String batch) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/a"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/ul/li[1]/a"))).click();

        // Select user
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div/div[1]/div/div"))).click();
        WebElement userSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Search']")));
        userSearch.sendKeys(user);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

        // Select notice
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div/div[2]/div/div"))).click();
        WebElement noticeSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/input")));
        noticeSearch.sendKeys(notice);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div[2]/span"))).click();

        // Select batch
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div/div[3]/div/div/div/div[1]"))).click();
        WebElement batchSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/input")));
        batchSearch.sendKeys(batch);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div[1]/span"))).click();
    }

    @When("the admin sets the standard auto report schedule time to {string}")
    public void the_admin_sets_the_standard_auto_report_schedule_time(String scheduleTime) throws InterruptedException {
        WebElement dateTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div/div[4]/input")));
        dateTimeInput.clear();
        dateTimeInput.sendKeys(scheduleTime);
        Thread.sleep(2000);
    }

    @When("the admin submits the standard auto report")
    public void the_admin_submits_the_standard_auto_report() throws InterruptedException {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div/div[6]/button")));
        submitButton.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[6]/button[1]"))).click();
        Thread.sleep(2000);
    }

    @Then("the standard AutoReport API should be triggered successfully")
    public void the_standard_autoreport_api_should_be_triggered_successfully() {
        AutoreportAPI_for_parent_notice testapi = new AutoreportAPI_for_parent_notice();
        testapi.setup();
        testapi.testGetRequests();
        driver.navigate().refresh();
        driver.quit();
    }
}
