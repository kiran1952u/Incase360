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
import utilities.AutoDownloadAPI;
import utilities.Login_functionality_admin;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auto_Download_With_Tracking {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I login as admin")
    public void i_login_as_admin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        new Login_functionality_admin().loginTest(driver);
    }

    @When("I navigate to Auto Download Without Tracking module")
    public void i_navigate_to_auto_download_without_tracking_module() throws InterruptedException {
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[12]/a/span[2]")))
                .click();
    }

    @When("I fill in the Auto Download form")
    public void i_fill_in_the_auto_download_form() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div"))).click();
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("vipul");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div"))).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("multiple_coborrower_standard");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div[1]/div/input"))).sendKeys("Test_auto_downlaod");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div[2]/div[1]/span"))).click();

        // ✅ Current Date/Time
        WebElement dateTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("scheduled_on")));
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);

        dateTimeInput.sendKeys(formattedDateTime);
    }

    @Then("I submit the Auto Download request")
    public void i_submit_the_auto_download_request() throws InterruptedException {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[12]/button")));
        submitBtn.click();


        Thread.sleep(4000);
        AutoDownloadAPI api = new AutoDownloadAPI();
        api.setup();
        api.autoDownlaodAPI();

        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.quit();
    }
}

