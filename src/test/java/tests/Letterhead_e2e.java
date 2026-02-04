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
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Letterhead_e2e {
    @Test
    public void testLetterheadCreationAndDeletion() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        try {
            // Generate unique ID for letterhead name
            int uniqueId = new Random().nextInt(100000);
            String uniqueLetterheadName = "vipul_letterhead_" + uniqueId;

            Login_functionality_user loginTest = new Login_functionality_user();
            loginTest.Login1(driver);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/a")).click();

            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[contains(text(), 'Add New')]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

            driver.findElement(By.id("head_name")).sendKeys(uniqueLetterheadName);
            System.out.println("Created letterhead with name: " + uniqueLetterheadName);
            driver.findElement(By.id("headerMargin")).sendKeys("60");

            driver.findElement(By.id("footerMargin")).sendKeys("20");

            // Locate all <input type="file"> on the page
            List<WebElement> fileInputs = driver.findElements(By.cssSelector("input[type='file']"));

            // Get absolute paths for test data files
            String projectPath = System.getProperty("user.dir");
            String letterheadImagePath = projectPath + "/src/test/resources/testdata/Adv_Letterhead_format-4.png";
            String signatureImagePath = projectPath + "/src/test/resources/testdata/pdf_generation_test.jpeg";

            // Upload the Letterhead image to the first input
            fileInputs.get(0).sendKeys(letterheadImagePath);

            // Upload the Signature image to the second input
            fileInputs.get(1).sendKeys(signatureImagePath);

            driver.findElement(By.name("signatureWidth")).sendKeys("100");
            driver.findElement(By.id("signatureHeight")).sendKeys("50");
            Thread.sleep(2000);
            WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

            // Wait for letterhead creation to complete
            Thread.sleep(3000);
            System.out.println("Letterhead created successfully. Now deleting letterhead: " + uniqueLetterheadName);

            // Navigate back to letterhead management page by clicking the letterhead menu again
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[6]/a/span[2]")).click();
            Thread.sleep(3000);

            // Find and click the delete button using the exact XPath provided
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='rs-btn-icon rs-btn-icon-placement-left rs-btn rs-btn-primary rs-btn-red rs-btn-xs']")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);

            // Wait for confirmation dialog and click OK button
            Thread.sleep(1000);
            WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='swal2-confirm swal2-styled swal2-default-outline']")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmButton);
            Thread.sleep(2000);
            System.out.println("Letterhead deleted successfully: " + uniqueLetterheadName);


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
//            driver.quit();
        }

    }
}
