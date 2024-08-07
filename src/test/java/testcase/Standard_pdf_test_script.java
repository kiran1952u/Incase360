package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.APITestStandard;

import java.util.concurrent.TimeUnit;

public class Standard_pdf_test_script {

    @Test
    public void UserAction() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            driver.get("https://test.incase360.com/login");
            driver.manage().window().maximize();

            driver.findElement(By.name("userName")).sendKeys("admin@incase360.com");
            driver.findElement(By.name("userPassword")).sendKeys("1WbFG0Z84@");
            Thread.sleep(3000);

            WebElement e = driver.findElement(By.id("captchaanswer"));
            String captchaValue = e.getAttribute("innerHTML");
            driver.findElement(By.id("captcha")).sendKeys(captchaValue);
            Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/section/main/div/div/div/div/div/div/div/form/div[4]/div[2]/button")).click();
            Thread.sleep(3000);

            driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/ul/li[1]/a")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("/html/body/div[2]/div[1]/input")).sendKeys("kiran");
//            /html/body/div[2]/div[1]/input
            Thread.sleep(3000);

            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select")).click();
            WebElement dropdownElement = driver.findElement(By.className("form-control"));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText("Standard_api_pdf");
            Thread.sleep(3000);

            WebElement dropdownElement1 = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select"));
            Select dropdown1 = new Select(dropdownElement1);
            dropdown1.selectByVisibleText("Kiran Letterhead 2");
            Thread.sleep(3000);
            WebElement fileInput = driver.findElement(By.xpath("//input[@name='uploadCsv']"));
            String csvFilePath = "D:\\Sandard_data\\Standard DATA\\Standard_api_pdf\\standard_data.csv";
            fileInput.sendKeys(csvFilePath);

            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[2]/input")).sendKeys("Test_Batch_op1");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[5]/button")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();


            APITestStandard apiTest = new APITestStandard();
            apiTest.setup();


            System.out.println("Calling testCreateNotice for the first time...");
            apiTest.testCreateNotice();
            Thread.sleep(2000);

            System.out.println("Calling testCreateNotice for the second time...");
            apiTest.testCreateNotice();
            Thread.sleep(2000);

            System.out.println("Calling testCreatePDF1...");
            apiTest.testCreatePDF1();

            // Refresh the page
            refreshPage(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
//            driver.quit();
        }
    }

    public void refreshPage(ChromeDriver driver) {
        driver.navigate().refresh();
    }
}
