package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Login_functionality_admin;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Autodownload_with_tracking_express {

    private WebDriver driver;
    private WebDriverWait wait;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    private String cookieValue = null;
    private List<Integer> apiResponses = new ArrayList<>();

    @Given("the admin logs into the Incase360 application")
    public void the_admin_logs_into_the_incase360_application() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*","--disable-dev-shm-usage","--no-sandbox","--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Login_functionality_admin login = new Login_functionality_admin();
        login.loginTest(driver);
        Thread.sleep(4000);

        // Capture session cookie for API
        Cookie jsession = driver.manage().getCookieNamed("JSESSIONID");
        if (jsession != null) {
            cookieValue = jsession.getValue();
            System.out.println("Captured JSESSIONID: " + cookieValue);
        } else {
            System.out.println("⚠️ No JSESSIONID cookie found, API may fail if it requires authentication.");
        }
    }

    @When("schedules auto download for the following batches:")
    public void schedules_auto_download_for_the_following_batches(DataTable dataTable) throws InterruptedException {
        List<List<String>> rows = dataTable.asLists(String.class);

        for (List<String> row : rows) {
            String user = row.get(0);
            String notice = row.get(1);
            String batchName = row.get(2);

            // Navigate to module
            wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[12]/a/span[2]")))
                    .click();

            // Select User
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div"))).click();
            WebElement userSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input[placeholder='Search']")));
            userSearch.clear(); userSearch.sendKeys(user);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

            // Select Notice
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div"))).click();
            WebElement noticeSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input[placeholder='Search']")));
            noticeSearch.clear(); noticeSearch.sendKeys(notice);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

            // Select Batch
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div"))).click();
            WebElement batchSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[3]/div[1]/div/input")));
            batchSearch.clear(); batchSearch.sendKeys(batchName);
            WebElement batchOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath(String.format("//html/body/div[3]/div[2]//span[text()='%s']", batchName))));
            batchOption.click();

            // Dropdown selections
            WebElement firstSpan = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/div/div/div/div[1]/span")));
            firstSpan.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div[1]/span"))).click();

            WebElement secondDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[5]/div/div")));
            secondDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div[2]/span"))).click();

            // Set current date/time
            LocalDateTime now = LocalDateTime.now();
            WebElement dateTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("scheduled_on")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", dateTimeInput, now.format(formatter));

            // Submit form
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
            submitButton.click();
            Thread.sleep(3000);
            driver.navigate().refresh();
            Thread.sleep(5000);

            System.out.println("✅ Scheduled batch: " + batchName);
        }
    }

    @When("the AutoDownload API is triggered {int} times")
    public void triggers_the_autodownload_api_times(int times) throws InterruptedException {
        for (int i = 1; i <= times; i++) {
            System.out.println("🔄 Calling AutoDownloadAPI - Attempt " + i);

            Response response;
            if (cookieValue != null) {
                response = RestAssured.given()
                        .baseUri("https://testapi.incase360.com/")   // 🔧 replace with actual
                        .cookie("JSESSIONID", cookieValue)
                        .when()
                        .post("/autoDownloadNotice")                 // 🔧 replace with actual
                        .then()
                        .log().all()
                        .extract().response();
            } else {
                response = RestAssured.given()
                        .baseUri("https://testapi.incase360.com/")   // 🔧 replace with actual
                        .when()
                        .post("/autoDownloadNotice")                 // 🔧 replace with actual
                        .then()
                        .log().all()
                        .extract().response();
            }

            int statusCode = response.statusCode();
            apiResponses.add(statusCode);

            if (statusCode != 200) {
                System.out.println("❌ API call failed with status: " + statusCode);
            } else {
                System.out.println("✅ API call successful with status: " + statusCode);
            }

            Thread.sleep(2000); // wait before next call
        }
    }


    @Then("the response should be successful each time")
    public void the_api_responses_should_be_successful() {
        boolean allSuccessful = apiResponses.stream().allMatch(code -> code == 200);

        if (!allSuccessful) {
            throw new AssertionError("Some API calls failed: " + apiResponses);
        }

        System.out.println("🎉 All API calls completed successfully: " + apiResponses);
        driver.quit();
    }
}
