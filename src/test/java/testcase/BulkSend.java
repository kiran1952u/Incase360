package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Login_functionality;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Test
public class BulkSend {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        // options.addArguments("--headless"); // Uncomment if running on a headless server
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void loginPage() throws InterruptedException {
        Login_functionality test = new Login_functionality();
        test.Login(driver);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/ul/li[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div/div")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/input")).sendKeys("vipul");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
        WebElement noticeTypeDropdown = driver.findElement(By.className("form-control"));

        // Create a Select object
        Select select = new Select(noticeTypeDropdown);

        // Select an option by visible text
        select.selectByVisibleText("Parent_notice_17june1");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div"));

        // Click on the element
        element.click();
        Thread.sleep(1000);
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[8]/span"));

        // Click on the element
        element1.click();
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
        driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled swal2-default-outline']")).click();
//        String baseNoticeId = "IN3155-";
//
//        for (int i = 1; i <= 10; i++) {  // Replace 10 with the desired number of iterations
//            // Construct the notice ID
//            String noticeId = baseNoticeId + i;
//
//            // Wait for the first input field to be visible and send keys
//            WebElement firstInputField = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/input"));
//            firstInputField.sendKeys(noticeId);
//
//            // Construct the next notice ID
//            String nextNoticeId = baseNoticeId + (i + 1);
//
//            // Wait for the second input field to be visible and send keys
//            WebElement secondInputField = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/input"));
//            secondInputField.sendKeys(nextNoticeId);
//
//            // Click the button
//            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[4]/button")).click();
//
//            // Wait for the confirmation button to be clickable and click it
//            WebElement confirmButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
//            confirmButton.click();
//
//            // Clear the input fields
//            firstInputField.clear();
//            secondInputField.clear();
//
//
//            Thread.sleep(1000);
//
//            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/input")).sendKeys("IN3155-1");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/input")).sendKeys("IN3155-4");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[4]/button")).click();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();

        }

    }








