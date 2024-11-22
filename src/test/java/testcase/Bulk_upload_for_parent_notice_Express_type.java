package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.APITest;
import utilities.Login_functionality;

import java.util.concurrent.TimeUnit;

@Test
public class Bulk_upload_for_parent_notice_Express_type {
    //THis  script is for  multiple langues notice test
    public void UserAction() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.incase360.com/login");
        Login_functionality test = new Login_functionality();
        test.Login(driver);
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

        // Initialize the Select class with the dropdown WebElement
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText("Tamil_kannnada_parent_2");
        Thread.sleep(3000);
        WebElement dropdownElement1 = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select"));

        // Initialize the Select class with the dropdown WebElement
        Select dropdown1 = new Select(dropdownElement1);

        // Select an option by visible text
        dropdown1.selectByVisibleText("kiran_letterhead3");
            WebElement fileInput = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/label[2]/input"));
            // Provide the file path of the CSV file to be uploaded
            String csvFilePath = "D:\\Tamil kannda issue 12092024\\Combine_tamil_kannada_csv_Data_proxy.csv";

            // Use sendKeys() method to upload the CSV file
            fileInput.sendKeys(csvFilePath);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[2]/input")).sendKeys("Tamil_kannda_pdf_autoreport_01");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[5]/button")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();

        APITest apiTest = new APITest();
        apiTest.setup();
        for (int i = 0; i < 5; i++) {
            apiTest.testCreateNotice();
        }
//        apiTest.testCreatePDFexpress();
        apiTest.testCreatePDF1();

        refreshPage(driver);

    }

    @Test
    public void refreshPage(ChromeDriver driver) {
        driver.navigate().refresh();
    }
}