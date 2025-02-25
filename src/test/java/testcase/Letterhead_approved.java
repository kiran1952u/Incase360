package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Login_functionality_admin;

import java.util.ArrayList;

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
        test.Login(driver);
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[9]/a/span"));

        element.click();
//
        JavascriptExecutor jsf = (JavascriptExecutor) driver;


        jsf.executeScript("window.scrollBy(0,500)");
        JavascriptExecutor js1f = (JavascriptExecutor) driver;


        js1f.executeScript("window.scrollBy(0,500)");
        WebElement buttonElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div/button"));

        // Click the button element
        buttonElement.click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div"));
        js.executeScript("arguments[0].scrollIntoView(true);", element1);

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Scroll to the top of the page
        js.executeScript("window.scrollTo(0, 0);");




    }
}