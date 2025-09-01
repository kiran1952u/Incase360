package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import utilities.Login_functionality_user;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class OptimizeUserRefIdSearch {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setupDriverAndLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        Login_functionality_user login = new Login_functionality_user();
        login.Login1(driver);

        driver.navigate().refresh();
    }

    @Test
    public void runRefIdDownloadFlow() throws InterruptedException {
        System.out.println("Navigating to 'Ref ID Search'...");
        By refIdLocator = By.xpath("//li[5]/a");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement refIdElement = wait.until(ExpectedConditions.elementToBeClickable(refIdLocator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", refIdElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", refIdElement);


        System.out.println("Clicking on 'Paste Ref. ID' button...");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Paste Ref. ID']"))).click();

        System.out.println("Entering Ref IDs...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//textarea"))).sendKeys(
                "NM7988\nSQ4400\nKL2819\nQS2949\nQE9400\nJO5566");

        System.out.println("Clicking Search...");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Search']"))).click();

        System.out.println("Waiting for search results to load...");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input[type='checkbox']")));

        System.out.println("Clicking first checkbox...");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@type='checkbox'])[1]"))).click();

        System.out.println("Clicking Download...");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Download']"))).click();
    }

    @AfterClass
    public void callAutoDownloadNoticeAPIAndCleanup() {
        try {
            URL url = new URL("https://testapi.incase360.com/autoDownloadNotice");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInput = "{}";
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("API Response Code: " + responseCode);

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
