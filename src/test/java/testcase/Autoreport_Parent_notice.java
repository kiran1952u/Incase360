package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AutoreportAPI;
import utilities.Login_functionality;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Test
public class Autoreport_Parent_notice {
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

    public void main() throws InterruptedException {

        Login_functionality test = new Login_functionality();
        test.Login(driver);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[11]/a")).click();
        Thread.sleep(4000);
//            driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("vipul");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div/div/div[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("vipul");
//           /html/body/div[3]/div[2]/div/span
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("parent_july1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input")).click();
        Thread.sleep(1000);
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD-MM-YYYY'T'HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);

        // Find the input element by its ID and set the value
        WebElement dateTimeInput = driver.findElement(By.id("report_on"));
        dateTimeInput.sendKeys(formattedDateTime);

        // Optional: Print a confirmation message
        System.out.println("Selected date and time: " + formattedDateTime);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[5]/div/div/div/div[1]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[6]/button")).click();
        AutoreportAPI test1 = new AutoreportAPI();
        test1.setup();
        for (int i = 0; i < 5; i++) {
            test1.setup();
        }
        test1.testGetRequests();
    }


}




