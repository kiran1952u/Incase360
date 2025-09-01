package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Standard_pdf_api;
import utilities.Login_functionality_admin;

import java.util.concurrent.TimeUnit;

public class Standard_pdf_creation_functionality {

    @Test
    public void UserAction() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            Login_functionality_admin test = new Login_functionality_admin();
            test.loginTest(driver);
            Thread.sleep(5000);
            driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[6]/a")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[6]/ul/li[1]/a")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/input")).sendKeys("KIRAN");
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

            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[2]/input")).sendKeys("Test_Batch_op3");
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[5]/button")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();


            Standard_pdf_api apiTest = new Standard_pdf_api();
            apiTest.setup();


            System.out.println("testCreateNotice insert notice successfully");
            apiTest.testCreateNotice();
            Thread.sleep(2000);

//            System.out.println("testCreateNotice pdf generatede successfully ");
//            apiTest.testCreateNotice();
//            Thread.sleep(2000);

            System.out.println("testCreatePDF1 pdf generatede successfully");
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
