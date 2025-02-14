package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class Login_functionality_user {
    public void Login1(WebDriver driver) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver.get("https://test.incase360.com/login");
        Thread.sleep(5000);

        // Login process
        WebElement usernameField = driver.findElement(By.name("userName"));
        usernameField.sendKeys("kiran@presolv360.com");

        WebElement passwordField = driver.findElement(By.name("userPassword"));
        passwordField.sendKeys("Kiran@123");
        Thread.sleep(3000);

        WebElement captchaElement = driver.findElement(By.id("captchaanswer"));
        String captchaValue = captchaElement.getAttribute("innerHTML");
        driver.findElement(By.id("captcha")).sendKeys(captchaValue);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/section/main/div/div/div/div/div/div/div/form/div[4]/div[2]/button"));
        loginButton.click();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/button[1]")).click();
    }
}