package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AutoreportAPI_for_parent_notice;
import utilities.Login_functionality_admin;

import java.time.Duration;

@Test
public class Autoreport_for_standard_notice {
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
    @Test (groups = "Login admin user")
    public void main() throws InterruptedException {

        Login_functionality_admin test = new Login_functionality_admin();
        test.loginTest(driver);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/a")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/ul/li[1]/a")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div/div/div[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div")).sendKeys("vipul");

        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span"));
        element.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("Mu");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div/div/div[1]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("standard_batch_MSI_01");
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/label/span[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input")).sendKeys("2024-09-23T13:45");
        Thread.sleep(5000);
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"); // Adjust pattern if needed
//        String currentDateTime = now.format(formatter);
//
//        // Locate the input field using XPath
//        WebElement calendarInput = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input"));
//
//        // Use JavaScript to set the value
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value = arguments[1];", calendarInput, currentDateTime);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/div[3]/button")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
//        Thread.sleep(2000);


    }

    @Test (groups = "Api code")
    public static  void main2 (String[] args) {
        AutoreportAPI_for_parent_notice testapi = new AutoreportAPI_for_parent_notice();
        testapi.setup();
        testapi.testGetRequests();
//            driver.navigate().refresh();
    }
}