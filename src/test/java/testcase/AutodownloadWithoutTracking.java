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
import utilities.Login_functionality_admin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class AutodownloadWithoutTracking {
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated wait method
    }

    @Test
    public void loginPage() throws InterruptedException {
        Login_functionality_admin test = new Login_functionality_admin();
        test.Login(driver);

//        // Use explicit waits instead of Thread.sleep()
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[12]/a")));
//        element.click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[13]/a/span"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div"))).click();
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("vipul");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div"))).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("multiple_coborrower_standard");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/input"))).sendKeys("Test_auto_downlaod");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div[1]/span"))).click();

        // Get the current date and time
        WebElement dateTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("scheduled_on")));
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);

        // Set the current date and time into the input field
        dateTimeInput.sendKeys(formattedDateTime);

        // Click the submit button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[11]/button"))).click();

        // Call AutoDownloadAPI to complete the process
        AutoDownloadAPI test1 = new AutoDownloadAPI();
        test1.setup();
        test1.autoDownlaodAPI();

        // Refresh page and close driver
        driver.navigate().refresh();
        Thread.sleep(5000); // wait a bit before quitting to let the page refresh properly
        driver.quit();
    }

    public void refreshPage(ChromeDriver driver) {
        driver.navigate().refresh();
    }
}
