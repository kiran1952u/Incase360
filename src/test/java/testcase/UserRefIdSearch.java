package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Login_functionality_user;

public class UserRefIdSearch {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Login to user panel
        Login_functionality_user login = new Login_functionality_user();
        login.Login1(driver);
    }

    @Test
    public void performRefIdSearchFlow() throws InterruptedException {
        // Navigate to RefID Search page
        driver.get("https://test.incase360.com/user/refidsearch");
        Thread.sleep(2000);

        // Click the first action button
        WebElement firstActionButton = driver.findElement(By.xpath("//button[contains(@class, 'action-button')]"));
        firstActionButton.click();
        Thread.sleep(1000);

        // Find and paste text into the textarea (simulate Ctrl+V manually if needed)
        WebElement textArea = driver.findElement(By.xpath("//textarea[@type='textarea']"));
        textArea.sendKeys("YOUR_REF_ID_HERE"); // Replace with actual Ref ID or simulate clipboard content
        Thread.sleep(1000);

        // Click the primary Search/Submit button
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'rs-btn') and contains(@class, 'rs-btn-primary')]"));
        searchButton.click();
        Thread.sleep(2000);

        // Check the checkbox
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        Thread.sleep(1000);

        // Click the second action button (usually for download/send action)
        WebElement secondActionButton = driver.findElement(By.xpath("(//button[contains(@class, 'action-button')])[last()]"));
        secondActionButton.click();
        Thread.sleep(2000);
    }
}