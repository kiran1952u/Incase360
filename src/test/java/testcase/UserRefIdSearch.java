package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.Login_functionality_user;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserRefIdSearch {
    WebDriver driver;

    @Test
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // ✅ Incognito Mode
        options.addArguments("--incognito");

        // ✅ Allow cross-origin
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // ✅ Login
        Login_functionality_user login = new Login_functionality_user();
        login.Login1(driver);
        Thread.sleep(2000);
        driver.navigate().refresh();

        // ✅ Navigate and perform actions
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[5]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/button[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[3]/textarea"))
                .sendKeys("NM7988\nSQ4400\nKL2819\nQS2949\nQE9400\nJO5566");
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[5]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div/div/label/span[1]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/button[1]")).click();
    }

    @AfterClass
    public void callAutoDownloadNoticeAPI() {
        try {
            URL url = new URL("https://testapi.incase360.com/autoDownloadNotice");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);


            String jsonInputString = "{}";
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("API Response Code: " + responseCode);

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
//                driver.quit(); // Close browser
            }
        }
    }
}
