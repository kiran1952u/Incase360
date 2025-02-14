package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.Login_functionality_admin;
import utilities.Login_functionality_user;

import java.util.concurrent.TimeUnit;

public class Letterhead_e2e {
    @Test
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            Login_functionality_user test = new Login_functionality_user();
            test.Login1(driver);
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[7]/a")).click();

            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#layout-wrapper > div.main-content > div > div > div.table-responsive > div.rs-table.rs-table-hover.rs-table-word-wrap > div.rs-table-body-row-wrapper > div.rs-table-body-wheel-area > div:nth-child(5) > div > div.rs-table-cell.rs-table-cell-last > div > div > button.rs-btn-icon.rs-btn-icon-placement-left.rs-btn.rs-btn-primary.rs-btn-blue.rs-btn-xs > svg")).click();
            Thread.sleep(3000);
            WebElement inputField = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/form/div/div/div[2]/div/div/input"));

            // Clear the existing value and enter a new value
            inputField.clear();
            inputField.sendKeys("70");

//            WebElement fileInput = driver.findElement(By.cssSelector("body > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > label:nth-child(2) > div:nth-child(3) > span:nth-child(2)"));
//
//            // Provide the absolute path of the CSV file
//            String filePath = "C:\\Letterhead  photo\\pdf_generation_test.jpeg";
//            fileInput.sendKeys(filePath);

            WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

            // Set the absolute image file path
            fileInput.sendKeys("C:\\Letterhead_photo\\Adv_Letterhead_format-4.png");
            Thread.sleep(4000);

            // Find the actual file input element inside the wrapper (file input is usually hidden)
            WebElement fileInput2 = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/form/div/div/div[5]/div/label[2]/input"));

            // Provide the absolute path of the image you want to upload
            String filePath = "C:\\Letterhead_photo\\Adv_Letterhead_format-5.png"; // Replace with actual file path

            // Send the file path to the file input
            fileInput2.sendKeys(filePath);
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")).click();





        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
//            driver.quit();
        }

    }
}
