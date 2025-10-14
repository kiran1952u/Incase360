package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.bouncycastle.asn1.cms.OtherRecipientInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Login_functionality_admin;
import utilities.Login_functionality_user;

public class RefIdSearchTest {
        
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void performRefIdSearch() throws InterruptedException {
        // Step 0: Perform Login
        Login_functionality_admin login = new Login_functionality_admin();
        login.loginTest(driver);
        Thread.sleep(5000);
        // Step 1: Open Ref ID Search page
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[12]/a")).click();
        Thread.sleep(8000);


        WebElement dropdown1 = driver.findElement(By.className("rs-stack-item"));
        dropdown1.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("vipul");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("make");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/label/span[1]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div/input")).sendKeys("IN3517-1\t\n");
        Thread.sleep(1000);
        // Store the current window handle
        String originalWindow = driver.getWindowHandle();

// Click the button that opens a new tab
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[7]/div/div/a/button")).click();
        Thread.sleep(2000); // wait for the new tab to open

// Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

// Close the new tab
        driver.close();

// Switch back to the original window
        driver.switchTo().window(originalWindow);
        Thread.sleep(1000);
        // Step 1: Store original window handle
        String originalWindow1 = driver.getWindowHandle();

// Step 2: Click the button that opens a new tab
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[7]/div/div/button")).click();
        Thread.sleep(3000); // Adjust based on loading speed

// Step 3: Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow1)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

// Step 4: Optionally do something in the new tab here

// Step 5: Close the new tab
        driver.close();

// Step 6: Switch back to original tab
        driver.switchTo().window(originalWindow);



    }

}
