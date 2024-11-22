package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.Login_functionality;

import java.util.ArrayList;

@Test
public class AllNotice {
    public void Addnewnotice() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.incase360.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.name("userName")).sendKeys("admin@incase360.com");
        driver.findElement(By.name("userPassword")).sendKeys("1WbFG0Z84@");
        Thread.sleep(3000);
        WebElement e = driver.findElement(By.id("captchaanswer"));
        System.out.println("This is the value" + e.getAttribute("innerHTML"));
        Thread.sleep(1000);
        driver.findElement(By.id("captcha")).sendKeys(e.getAttribute("innerHTML"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/section/main/div/div/div/div/div/div/div/form/div[4]/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/button[1]")).click();
//        Login_functionality test  = new Login_functionality();
//        test.Login();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[3]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class='btn btn-outline-primary']")).click();
        //*[@id="layout-wrapper"]/div[2]/div/div/div[2]/div[1]/div/div/input
        //*[@id="layout-wrapper"]/div[2]/div/div/div[2]/div[1]/div/div/button
        //*[@id="layout-wrapper"]/div[2]/div/div/div[2]/button
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div/input")).sendKeys("Font_001");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/div/button")).click();
        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("//div[@class='rs-table-cell-content']//div[@class='rs-table-cell-wrap']/a"));
        element.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[6]/div/div/button")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled swal2-default-outline']")).click();
//        .swal2-actions > .swal2-confirm
//        button[class='swal2-confirm swal2-styled swal2-default-outline']
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > button:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[class='main-content'] li:nth-child(2) a:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[3]/ul/li[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div/input")).sendKeys("Parent_July1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div/button")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[1]/div/div/ol/li[2]/a")).click();

//        driver.quit();body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1)
    }
}
