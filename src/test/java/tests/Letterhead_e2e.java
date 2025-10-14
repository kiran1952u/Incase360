package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.Login_functionality_user;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Letterhead_e2e {
    @Test
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        try {
            Login_functionality_user test = new Login_functionality_user();
            test.Login1(driver);
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[6]/a/span[2]")).click();

            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[contains(text(), 'Add New')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

            driver.findElement(By.id("head_name")).sendKeys("vipul_letterhead");
            driver.findElement(By.id("headerMargin")).sendKeys("60");

            driver.findElement(By.id("footerMargin")).sendKeys("20");
            // Locate all <input type="file"> on the page
            List<WebElement> fileInputs = driver.findElements(By.cssSelector("input[type='file']"));

// Upload the Letterhead image to the first input
            fileInputs.get(0).sendKeys("D:\\Arbitration process KT\\OneDrive\\Pictures\\Letterhead signature\\Adv_Letterhead_format-4.png");

// Upload the Signature image to the second input
            fileInputs.get(1).sendKeys("D:\\Arbitration process KT\\OneDrive\\Pictures\\Letterhead signature\\pdf_generation_test.jpeg");

            driver.findElement(By.name("signatureWidth")).sendKeys("100");
            driver.findElement(By.id("signatureHeight")).sendKeys("50");
            Thread.sleep(2000);
            WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);




        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
//            driver.quit();
        }

    }
}
