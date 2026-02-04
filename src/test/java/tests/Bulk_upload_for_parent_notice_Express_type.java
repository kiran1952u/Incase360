package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.APITest;
import utilities.Login_functionality_admin;

import java.time.Duration;

@Test
public class Bulk_upload_for_parent_notice_Express_type {
    //THis  script is for  multiple langues notice test
    public void UserAction() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.incase360.com/login");

        Login_functionality_admin test = new Login_functionality_admin();
        test.loginTest(driver);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/input")).sendKeys("kiran");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select")).click();
        WebElement dropdownElement = driver.findElement(By.className("form-control"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Tamil_kannnada_parent_2");
        Thread.sleep(3000);

        WebElement dropdownElement1 = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select"));
        Select dropdown1 = new Select(dropdownElement1);
        dropdown1.selectByVisibleText("kiran_letterhead3");

        WebElement fileInput = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/label[2]/input"));
        String csvFilePath = "D:\\UploadDATA\\Tamil kannda paernt 2 notice DATA\\Combine_tamil_kannada_csv_Data_proxy.csv";
        fileInput.sendKeys(csvFilePath);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[2]/input")).sendKeys("Tamil_kannda_auto_report_01");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[5]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();

        APITest apiTest = new APITest();
        apiTest.setup();
        for (int i = 0; i < 5; i++) {
            apiTest.testCreateNotice();
        }
        // apiTest.testCreatePDF1();  // Commented out - method removed from APITest

        driver.navigate().refresh();

        // Optionally, close the driver at the end
        driver.quit();
    }
}