package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Login_functionality_admin;

import java.time.Duration;

@Test
public class Letterhead_approved {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        // options.addArguments("--headless"); // Uncomment if running on a headless server
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void loginPage() throws InterruptedException {
        Login_functionality_admin test = new Login_functionality_admin();
        test.loginTest(driver);
        Thread.sleep(2000);

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[8]/a/span[2]"));
        element1.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type='button' and contains(@class,'rs-btn-green')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type=\"button\" and contains (@class ,\"swal2-confirm swal2-styled swal2-default-outline\")]")).click();





    }
}