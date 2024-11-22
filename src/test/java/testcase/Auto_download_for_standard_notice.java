package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.internal.path.json.mapping.JsonPathJackson1ObjectDeserializer;
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
import utilities.Login_functionality;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Test
public class Auto_download {
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

    public void loginPage() throws InterruptedException {
        Login_functionality test = new Login_functionality();
        test.Login(driver);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[12]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("vipul");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("standard_notice_3");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("test_pdf");
//        /html/body/div[3]/div[2]/div[1]/span
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
        WebElement dateTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("scheduled_on")));
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm a"); // Format required for datetime-local input
        String formattedDateTime = currentDateTime.format(formatter);


        // Set the current date and time into the input field
        dateTimeInput.sendKeys(formattedDateTime);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[11]/button")).click();


        AutoDownloadAPI test1 = new AutoDownloadAPI();
        test1.setup();
        test1.autoDownlaodAPI();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(30000);
        driver.quit();


    }

    public void refreshPage(ChromeDriver driver) {
        driver.navigate().refresh();
    }
}



