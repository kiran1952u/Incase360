package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.AutoreportAPI_for_parent_notice;
import utilities.Auto_report_merged_script;
import utilities.Login_functionality_admin;

import java.time.Duration;

/**
 * Step Definitions for Autoreport Parent Proxy Report
 * This class contains Cucumber step implementations for Autoreport_Parent_proxy_report.feature
 * Each method corresponds to a step in the feature file
 */
public class Autoreport_Parent_proxy_report_Steps {

    // Get shared driver instance from Hooks
    private WebDriver driver = Hooks.driver;

    /**
     * STEP 1: Login as admin user - MOVED TO CommonSteps.java
     * Feature: Given I am logged in as admin user
     * This step is now shared across all features in CommonSteps.java
     */

    /**
     * STEP 2: Navigate to Autoreport menu
     * Feature: When I navigate to Autoreport menu
     */
    @When("I navigate to Autoreport menu")
    public void i_navigate_to_autoreport_menu() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/a")).click();
        Thread.sleep(4000);
    }

    /**
     * STEP 3: Click on Autoreport submenu
     * Feature: And I click on Autoreport submenu
     */
    @When("I click on Autoreport submenu")
    public void i_click_on_autoreport_submenu() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[10]/ul/li[1]/a")).click();
        Thread.sleep(4000);
    }

    /**
     * STEP 4: Click on student dropdown
     * Feature: And I click on student dropdown
     */
    @When("I click on student dropdown")
    public void i_click_on_student_dropdown() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div/div/div[1]")).click();
        Thread.sleep(4000);
    }

    /**
     * STEP 5: Enter student name
     * Feature: And I enter student name "kiran"
     * @param studentName - The name of the student (e.g., "kiran")
     */
    @When("I enter student name {string}")
    public void i_enter_student_name(String studentName) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[1]/div/div")).sendKeys(studentName);
        Thread.sleep(4000);
    }

    /**
     * STEP 6: Select the student from dropdown
     * Feature: And I select the student from dropdown
     */
    @When("I select the student from dropdown")
    public void i_select_the_student_from_dropdown() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/span"));
        element.click();
        Thread.sleep(3000);
    }

    /**
     * STEP 7: Click on teacher dropdown
     * Feature: And I click on teacher dropdown
     */
    @When("I click on teacher dropdown")
    public void i_click_on_teacher_dropdown() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[2]/div/div")).click();
        Thread.sleep(1000);
    }

    /**
     * STEP 8: Enter teacher name
     * Feature: And I enter teacher name "Gujra"
     * @param teacherName - The name of the teacher (e.g., "Gujra")
     */
    @When("I enter teacher name {string}")
    public void i_enter_teacher_name(String teacherName) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/input")).sendKeys(teacherName);
        Thread.sleep(6000);
    }

    /**
     * STEP 9: Select the teacher from dropdown
     * Feature: And I select the teacher from dropdown
     */
    @When("I select the teacher from dropdown")
    public void i_select_the_teacher_from_dropdown() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[5]/span")).click();
        Thread.sleep(1000);
    }

    /**
     * STEP 10: Click on batch dropdown
     * Feature: And I click on batch dropdown
     */
    @When("I click on batch dropdown")
    public void i_click_on_batch_dropdown() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[3]/div/div/div/div[1]")).click();
        Thread.sleep(1000);
    }

    /**
     * STEP 11: Select batch from checkbox
     * Feature: And I select batch from checkbox
     */
    @When("I select batch from checkbox")
    public void i_select_batch_from_checkbox() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[8]/div/div/label/span[1]/input")).click();
        Thread.sleep(1000);
    }

    /**
     * STEP 12: Click on datetime field
     * Feature: And I click on datetime field
     */
    @When("I click on datetime field")
    public void i_click_on_datetime_field() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input")).click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * STEP 13: Enter datetime
     * Feature: And I enter datetime "2024-09-23T13:45"
     * @param datetime - The datetime value (e.g., "2024-09-23T13:45")
     */
    @When("I enter datetime {string}")
    public void i_enter_datetime(String datetime) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/form/div/div[4]/input")).sendKeys(datetime);
        Thread.sleep(5000);
    }

    /**
     * STEP 14: Click submit button
     * Feature: And I click submit button
     */
    @When("I click submit button")
    public void i_click_submit_button() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(4000);
    }

    /**
     * STEP 15: Confirm the autoreport submission
     * Feature: And I confirm the autoreport submission
     */
    @When("I confirm the autoreport submission")
    public void i_confirm_the_autoreport_submission() {
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
    }

    /**
     * STEP 16: Parent notice API should be triggered
     * Feature: Then Parent notice API should be triggered
     */
    @Then("Parent notice API should be triggered")
    public void parent_notice_api_should_be_triggered() throws InterruptedException {
        AutoreportAPI_for_parent_notice test2 = new AutoreportAPI_for_parent_notice();
        test2.setup();
        test2.testGetRequests();
    }

    /**
     * STEP 17: Merged script API should be triggered
     * Feature: And Merged script API should be triggered
     */
    @Then("Merged script API should be triggered")
    public void merged_script_api_should_be_triggered() throws InterruptedException {
        Auto_report_merged_script test1 = new Auto_report_merged_script();
        test1.setup();
        test1.testGetRequestsOnce();
    }

    /**
     * STEP 18: Navigate back to autoreport page and refresh
     * Feature: And I navigate back to autoreport page and refresh
     */
    @Then("I navigate back to autoreport page and refresh")
    public void i_navigate_back_to_autoreport_page_and_refresh() {
        driver.get("https://test.incase360.com/admin/auto-report");
        driver.navigate().refresh();
    }
}
