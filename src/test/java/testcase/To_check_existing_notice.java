package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.Login_functionality;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Test
public class To_check_existing_notice {
    public void Existing_notice() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        Login_functionality test = new Login_functionality();
        test.Login(driver);
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[5]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[7]/div/div/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[8]/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[9]/div/div/a/button")).click();
        Thread.sleep(3000);
        JavascriptExecutor jsf = (JavascriptExecutor) driver;


        jsf.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
//        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[1]/button")).click();
//        Thread.sleep(3000);
//        driver.navigate().back();

        String mainWindowHandle = driver.getWindowHandle();


        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[1]/button")).click(); // this opens a new tab


        Thread.sleep(3000);


        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle); // switch to the new tab
                break;
            }
        }

        // Step 7: Perform any actions on the new tab (e.g., open a PDF link)
        driver.get("https://testapi.incase360.com/assets/upload/tempzipextract/1732258579_preview.pdf");

        // Step 8: Close the new tab
        driver.close();

        // Step 9: Switch back to the main (original) window/tab
        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(3000);


        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[2]/span/a/button")).click();
        Thread.sleep(3000);
        JavascriptExecutor js32 = (JavascriptExecutor) driver;
        js32.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("samp[class='px-3'] input[name='sendAs']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[5]/span/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[5]/samp/input")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[5]/span/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[6]/div/div[2]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[6]/div/div[3]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[6]/div/div[2]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[6]/div/div[1]/input")).click();
        Thread.sleep(3000);
        JavascriptExecutor js33 = (JavascriptExecutor) driver;
        js33.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        JavascriptExecutor js34 = (JavascriptExecutor) driver;
        js34.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/button")).click();

    }


}
