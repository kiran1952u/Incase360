package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class incase {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.incase360.com/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.name("userName")).sendKeys("admin@incase360.com");
        driver.findElement(By.name("userPassword")).sendKeys("1WbFG0Z84@");
        Thread.sleep(3000);
        WebElement e = driver.findElement(By.id("captchaanswer"));
        System.out.println("This is the value" + e.getAttribute("innerHTML"));
        Thread.sleep(1000);
        driver.findElement(By.id("captcha")).sendKeys(e.getAttribute("innerHTML"));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/section/main/div/div/div/div/div/div/div/form/div[4]/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/div/input")).sendKeys("font");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/div/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/div[8]/div/div/a/button")).click();
        Thread.sleep(3000);

        WebElement button = driver.findElement(By.cssSelector("#layout-wrapper > div.main-content > div > div > div:nth-child(2) > form > div:nth-child(3) > div:nth-child(1) > button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(3000);
        button.click();
    }
}
