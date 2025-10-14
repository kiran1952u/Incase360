package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import utilities.AutoreportAPI_for_parent_notice;
import utilities.Login_functionality_admin;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Autoreport_test_with_multiple_batches_express {
    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public Autoreport_test_with_multiple_batches_express() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() throws InterruptedException {
        Login_functionality_admin login = new Login_functionality_admin();
        login.loginTest(driver);
        Thread.sleep(3000);
    }

    @When("I navigate to the autoreport page")
    public void i_navigate_to_the_autoreport_page() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/a"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/ul/li[1]/a"))).click();
        Thread.sleep(2000);
    }

    @When("I fill student as {string}")
    public void i_fill_student_as(String studentName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div/div/div[1]"))).click();
        Thread.sleep(2000);
        WebElement studentInput = driver.findElement(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div"));
        studentInput.sendKeys(studentName);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div[2]/div/span"))).click();

    }

    @When("I select teacher as {string}")
    public void i_select_teacher_as(String teacherName) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys(teacherName);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"rs-9-opt-3539\"]/span"))).click();
    }

    @When("I select batch {string}")
    public void i_select_batch(String batchName) throws InterruptedException {
        WebElement batchDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div/div/div[1]")));
        batchDropdown.click();
        Thread.sleep(2000);

        WebElement batchInput = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input"));
        batchInput.clear();
        batchInput.sendKeys(batchName);
        Thread.sleep(2000);

        WebElement batchOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='" + batchName + "']")));
        batchOption.click();
    }

    @When("I set datetime as {string}")
    public void i_set_datetime_as(String datetime)  {
        // Implement logic to set the datetime field in your form
        WebElement dateTimeInput = driver.findElement(
                By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input"));
        dateTimeInput.clear();
        dateTimeInput.sendKeys(datetime);
    }

    @When("I pick a random class")
    public void i_pick_a_random_class() {
        List<WebElement> h5Elements = driver.findElements(By.xpath("//h5"));
        Random rand = new Random();
        WebElement randomH5 = h5Elements.get(rand.nextInt(h5Elements.size()));
        randomH5.click();
    }

    @When("I submit the autoreport")
    public void i_submit_the_autoreport()throws InterruptedException {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[type='submit']")));
        submitButton.click();

        // ✅ Wait for confirmation modal instead of Thread.sleep
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div/div[6]/button[1]")));
        confirmButton.click();
    }

    @Then("The parent notice API should be triggered")
    public void the_parent_notice_api_should_be_triggered() throws InterruptedException {
        AutoreportAPI_for_parent_notice api = new AutoreportAPI_for_parent_notice();
        api.setup();
        api.testGetRequests();

        driver.navigate().refresh();

        // ✅ Replace Thread.sleep with WebDriverWait
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[2]/div[1]") // adjust locator to something stable on your page
        ));
    }
}

