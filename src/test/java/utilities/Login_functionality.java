package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class Login_functionality {
@Test
public void Login(WebDriver driver) throws InterruptedException {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver.get("https://test.incase360.com/login");
    Thread.sleep(5000);

    // Login process
    WebElement usernameField = driver.findElement(By.name("userName"));
    usernameField.sendKeys("admin@incase360.com");

    WebElement passwordField = driver.findElement(By.name("userPassword"));
    passwordField.sendKeys("1WbFG0Z84@");
    Thread.sleep(3000);

    WebElement captchaElement = driver.findElement(By.id("captchaanswer"));
    String captchaValue = captchaElement.getAttribute("innerHTML");
    driver.findElement(By.id("captcha")).sendKeys(captchaValue);

    WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/section/main/div/div/div/div/div/div/div/form/div[4]/div[2]/button"));
    loginButton.click();
    driver.manage().window().maximize();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/button[1]")).click();
    // Navigate to the Notices section
//        Thread.sleep(3000);
//        WebElement dashboardLink = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[4]/a"));
//        dashboardLink.click();
//        Thread.sleep(3000);
//
//        WebElement noticesLink = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[4]/ul/li[1]/a"));
//        noticesLink.click();
//        Thread.sleep(3000);

    // Navigate to the Notices section
//        Thread.sleep(3000);
//        WebElement dashboardLink = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[4]/a"));
//        dashboardLink.click();
//        Thread.sleep(3000);
//
//        WebElement noticesLink = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[4]/ul/li[1]/a"));
//        noticesLink.click();
//        Thread.sleep(3000);

    }


}


