package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AutoreportAPI_for_parent_notice;
import utilities.Login_functionality_admin;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@Test
public class Autoreport_for_multiple_batches_express {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void main() throws InterruptedException {

        Login_functionality_admin test = new Login_functionality_admin();
        test.loginTest(driver);

        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/a"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/ul/li[1]/a"))).click();
        Thread.sleep(2000);

        // List of batches to process
        List<String> batches = List.of("Test_que_table_entry_01", "without_com_express_01", "without_com_express_02");

        for (String batchName : batches) {
            // Fill student field
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div/div/div[1]"))).click();
            Thread.sleep(2000);
            WebElement studentInput = driver.findElement(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div"));
            studentInput.sendKeys("vipul");
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

            // Fill teacher field
            driver.findElement(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("Com");
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"rs-9-opt-3539\"]/span"))).click();

            // ✅ Fill batch field properly
            WebElement batchDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div/div/div[1]")
            ));
            batchDropdown.click();
            Thread.sleep(2000);

            WebElement batchInput = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input"));
            batchInput.clear();
            batchInput.sendKeys(batchName);
            Thread.sleep(2000);

            WebElement batchOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='" + batchName + "']")
            ));
            batchOption.click();

            // Continue with datetime, random h5, submit button...
        }


        // Fill datetime
        WebElement dateTimeInput = driver.findElement(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input")
        );
        dateTimeInput.clear();
        dateTimeInput.sendKeys("2024-09-23T13:45");

// 2️⃣ Get all <h5> elements
        List<WebElement> h5Elements = driver.findElements(By.xpath("//h5"));

// 3️⃣ Pick a random <h5>
        Random rand = new Random();
        WebElement randomH5 = h5Elements.get(rand.nextInt(h5Elements.size()));

// 4️⃣ Click the random <h5>
        randomH5.click();

        Thread.sleep(4000);
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();




            AutoreportAPI_for_parent_notice testapi = new AutoreportAPI_for_parent_notice();
            testapi.setup();
            testapi.testGetRequests();

            // Refresh page before next batch
            driver.navigate().refresh();
            Thread.sleep(2000);
        }
    }


