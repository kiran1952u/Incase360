package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AutoDownloadAPI;
import utilities.Login_admin_live;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AutoDownlaod_withtracking_Notice_live {


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

    @Test
    public void loginPage() throws InterruptedException {
       Login_admin_live test =  new Login_admin_live();
       test.Login(driver);

        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[13]/a/span"))).click();
        Thread.sleep(2000);

        String[] batchNames = {
                "Test_1",
                "Test_2",
                "Test_3",
                "test_rejected_notice_pro",
                "proxy_notice_test_prod_01"
        };

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        for (String batchName : batchNames) {
            // Select User
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div"))).click();
            WebElement userSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input[placeholder='Search']")));
            userSearch.clear();
            userSearch.sendKeys("kiran");
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

            // Select Notice
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div"))).click();
            WebElement noticeSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input[placeholder='Search']")));
            noticeSearch.clear();
            noticeSearch.sendKeys("Test_ABC Ltd_LRN_Sec 21_April 2024");
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[3]/div[2]/div[1]/span"))).click();

            // Select Batch
            // Click to open the dropdown
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("div[id='rs-25']"))); // or use the correct ID of the dropdown trigger
            dropdown.click();

// Wait for the option and click it
            WebElement batchOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("div[id='rs-25-opt-Test_1'] span.rs-picker-select-menu-item")));
            batchOption.click();


            String batchXpath = String.format("//html/body/div[3]/div[2]//span[text()='%s']", batchName);
            WebElement batchOption1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(batchXpath)));
            batchOption1.click();

            System.out.println("Selected batch: " + batchName);

            // === NEWLY ADDED STEPS AFTER BATCH SELECTION ===

            // Step 1: Click 4th section dropdown
            WebElement firstSpan = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/div/div/div/div[1]/span")));
            firstSpan.click();
            Thread.sleep(1000);

            // Step 2: Select option from dropdown
            WebElement firstDropdownValue = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[3]/div[2]/div[1]/span")));
            firstDropdownValue.click();

            // Step 3: Click 5th section dropdown
            WebElement secondDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[5]/div/div")));
            secondDropdown.click();
            Thread.sleep(1000);

            // Step 4: Select option from dropdown
            WebElement secondDropdownValue = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[3]/div[2]/div[2]/span")));
            secondDropdownValue.click();
            Thread.sleep(1000);

            // Set date and time
            LocalDateTime currentDateTime = LocalDateTime.now();
            String formattedDateTime = currentDateTime.format(formatter);
            WebElement dateTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("scheduled_on")));
            ((ChromeDriver) driver).executeScript("arguments[0].value = arguments[1];", dateTimeInput, formattedDateTime);

            // Submit form
            Thread.sleep(1000);
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[type='submit']")));
            ((ChromeDriver) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

            try {
                submitButton.click();
            } catch (Exception e) {
                ((ChromeDriver) driver).executeScript("arguments[0].click();", submitButton);
            }

            System.out.println("Submitted batch: " + batchName);
            Thread.sleep(3000); // wait before refresh

            // Refresh the page
            driver.navigate().refresh();
            Thread.sleep(5000); // wait for page to reload
        }

        // Call AutoDownloadAPI 5 times
        AutoDownloadAPI test1 = new AutoDownloadAPI();
        test1.setup();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Calling AutoDownloadAPI - Attempt " + i);
            test1.autoDownlaodAPI();
            Thread.sleep(2000);
        }

        driver.quit();
    }
}
