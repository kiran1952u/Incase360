package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Login_functionality;

import java.util.concurrent.TimeUnit;

@Test
public class ExistingNotice {
    public void Existing_notice() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.incase360.com/login");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.name("userName")).sendKeys("admin@incase360.com");
        driver.findElement(By.name("userPassword")).sendKeys("1WbFG0Z84@");
        Thread.sleep(1000);
        WebElement e = driver.findElement(By.id("captchaanswer"));
        System.out.println("This is the value" + e.getAttribute("innerHTML"));
        Thread.sleep(1000);
        driver.findElement(By.id("captcha")).sendKeys(e.getAttribute("innerHTML"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/section/main/div/div/div/div/div/div/div/form/div[4]/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[6]/div/div/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("svg[aria-label='close']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[7]/div/div/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("svg[aria-label='close']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > button:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[1]/div/div/ol/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/div/input")).sendKeys("test2121");
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div[8]/div/div/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/div/input")).sendKeys("kiran_last_test");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div[8]/div/div/button[1]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div[8]/div/div/button[2]")).click();
        driver.findElement(By.id("noticeType")).sendKeys("kiran_last_test_1");
        Thread.sleep(3000);
        driver.findElement(By.name("noticeDescription")).sendKeys("kiran_last_test_11");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/input")).sendKeys("vipul");
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/label/span[1]/input")).click();
    }


}
