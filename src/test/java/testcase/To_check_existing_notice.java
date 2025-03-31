package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.Login_functionality_admin;

import java.util.Set;

@Test
public class To_check_existing_notice {
    public void Existing_notice() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        Login_functionality_admin test = new Login_functionality_admin();
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

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div[1]/button")).click();
        Thread.sleep(3000);// this opens a new tab
        driver.navigate().back();

    }


}
