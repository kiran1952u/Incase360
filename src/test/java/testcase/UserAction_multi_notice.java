package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
@Test
public class UserAction_multi_notice {
    public void UserAction() throws InterruptedException {
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
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[6]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/input")).sendKeys("vipul");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[2]/select")).click();
        WebElement dropdownElement = driver.findElement(By.className("form-control"));

        // Initialize the Select class with the dropdown WebElement
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText("Parent_notice_17june1");
        Thread.sleep(3000);
        WebElement dropdownElement1 = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div[3]/select"));

        // Initialize the Select class with the dropdown WebElement
        Select dropdown1 = new Select(dropdownElement1);

        // Select an option by visible text
        dropdown1.selectByVisibleText("vipul_letterhead");
        WebElement fileInput = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/label[2]/input"));
///html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/label[2]/input
        // Provide the file path of the CSV file to be uploaded
        String csvFilePath = "D:\\UploadDATA\\NOTICE  CVS SAME DATA\\hindi_kannad_panjabi_Marathi_combine_data_testing.csv";

        // Use sendKeys() method to upload the CSV file
        fileInput.sendKeys(csvFilePath);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[3]/div[2]/input")).sendKeys("H_K_P_M_test_Pdf");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[5]/button")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();

        APITest apiTest = new APITest();
        apiTest.setup();
        for (int i = 0; i < 5; i++) {
            apiTest.testCreateNotice();
        }
        apiTest.testCreatePDF1();
        refreshPage(driver);


    }

    @Test
    public void refreshPage(ChromeDriver driver) {
        driver.navigate().refresh();
    }
}