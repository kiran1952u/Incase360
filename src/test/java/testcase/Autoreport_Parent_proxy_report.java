package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AutoreportAPI_for_parent_notice;
import utilities.Login_functionality;
import utilities.Proxy_combine_csv;

import java.util.concurrent.TimeUnit;

@Test
public class Autoreport_Parent_proxy_report {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
//        options.addArguments("--incognito");
        // options.addArguments("--headless"); // Uncomment if running on a headless server
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    public void main() throws InterruptedException {

        Login_functionality test = new Login_functionality();
        test.Login(driver);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[11]/a")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[11]/ul/li[1]/a")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div/div/div[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div")).sendKeys("kiran");

        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span"));


        element.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys("Gujrati_tamil_marathi_parent_express");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span/span/mark")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div/div/div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[16]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input")).click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input")).sendKeys("2024-09-23T13:45");
        Thread.sleep(5000);



        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();

//
//        AutoreportAPI test1 = new AutoreportAPI();
//        test1.setup();
//        for (int i = 0; i < 3; i++) {
//            test1.setup();
//        }
//        test1.testGetRequests();
        AutoreportAPI_for_parent_notice test2 = new AutoreportAPI_for_parent_notice();
        test2.setup();
        test2.testGetRequests();
        Proxy_combine_csv test1 = new Proxy_combine_csv ();
        test1.setup();
        test1.testGetRequestsOnce();

    }

}




