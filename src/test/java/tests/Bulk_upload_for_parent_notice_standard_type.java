package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Login_functionality_admin;
import utilities.Proxy_pdf_generation;

import java.util.UUID;

@Test
public class Bulk_upload_for_parent_notice_standard_type {
    private WebDriver driver;

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
    }

    @Test
    public void loginPage() throws InterruptedException {
        Login_functionality_admin test = new Login_functionality_admin();
        test.loginTest(driver);

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[5]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[5]/ul/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/input")).sendKeys("vipul");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select")).click();

        WebElement option2 = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select/option[28]"));
        option2.click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select")).click();
        WebElement option1 = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select/option[2]"));
        option1.click();
        Thread.sleep(2000);

        String filePath = "D:\\coborrower data with format\\MIS test DATA\\Batch_04.csv";
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
        fileInput.sendKeys(filePath);
        Thread.sleep(3000);

        String batchName = "standard_batch_MSI_" + UUID.randomUUID().toString().substring(0, 8);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[2]/input")).sendKeys(batchName);

        WebElement button = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[5]/button"));
        button.click();
        Thread.sleep(6000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();

        // API trigger
        Proxy_pdf_generation apistest = new Proxy_pdf_generation();
        apistest.parentApiEntry();


        driver.navigate().refresh();
        System.out.println("Page refreshed");
    }
}
