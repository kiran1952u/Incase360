package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Test
public class NormalTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
//        options.addArguments("--incognito");
        // options.addArguments("--headless"); // Uncomment if running on a headless server
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    public void test() throws InterruptedException {
        Login_functionality test = new Login_functionality();
        test.Login(driver);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[11]/a")).click();
        Thread.sleep(4000);
//            driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("vipul");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div/div/div[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div")).sendKeys("vipul");
//           /html/body/div[3]/div[2]/div/span
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/input")).sendKeys("parent_july1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input")).click();
        Thread.sleep(1000);
        String customDateTime = "08-08-2024 02:57 PM";

        // Define the formatter to parse the custom date-time string
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
        LocalDateTime dateTime = LocalDateTime.parse(customDateTime, customFormatter);

        // Define the formatter to convert to "yyyy-MM-dd'T'HH:mm" format
        DateTimeFormatter localFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedDateTime = dateTime.format(localFormatter);

        // Locate the date picker element using the provided XPath
        WebElement datePicker = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input"));

        // Clear the existing value (if necessary)
        datePicker.clear();

        // Send the formatted date and time value directly
        datePicker.sendKeys(formattedDateTime);


    }
}
