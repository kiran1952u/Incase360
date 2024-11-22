package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Login_functionality;
import utilities.parent_notice_apis;

public class Bulk_upload_for_parent_notice {
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
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[6]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[6]/ul/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/input")).sendKeys("kiran");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select")).click();
        WebElement option = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select/option[109]"));
        option.click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select")).click();
        WebElement option1 = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select/option[4]"));
        // Click on the option
        option1.click();
        Thread.sleep(2000);
        String filePath = "D:\\UploadDATA\\Hindi , kannnda , panjabi   data notice\\Overdue Notice_csv_data.csv";

        // Locate the file input element
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);

        // Upload the file by sending the file path to the input element
        fileInput.sendKeys(filePath);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[2]/input")).sendKeys("Test_batch_004");
        WebElement button = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[5]/button"));

        // Click on the button
        button.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
        parent_notice_apis apistest = new parent_notice_apis();
        apistest.parentApiEntry();
        refreshPage((ChromeDriver) driver);
    }

    public void refreshPage(ChromeDriver driver) {

        driver.navigate().refresh();
        System.out.println("current refresh page");
    }


}