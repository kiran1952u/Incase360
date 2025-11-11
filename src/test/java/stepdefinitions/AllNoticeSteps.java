package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Login_functionality_admin;

import java.util.ArrayList;

/**
 * Step Definitions for All Notice Management
 * This class contains Cucumber step implementations for AllNotice.feature
 * Each method corresponds to a step in the feature file
 */
public class AllNoticeSteps {

    // Get shared driver instance from Hooks
    private WebDriver driver = Hooks.driver;

    /**
     * STEP 1: Login as admin user
     * Feature: Given I am logged in as admin user
     */
    @Given("I am logged in as admin user")
    public void i_am_logged_in_as_admin_user() throws InterruptedException {
        Login_functionality_admin login = new Login_functionality_admin();
        login.loginTest(driver);
        Thread.sleep(5000);
    }

    /**
     * STEP 2: Navigate to All Notices menu
     * Feature: When I navigate to All Notices menu
     */
    @When("I navigate to All Notices menu")
    public void i_navigate_to_all_notices_menu() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[2]/a")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 3: Click on All Notices submenu
     * Feature: And I click on All Notices submenu
     */
    @When("I click on All Notices submenu")
    public void i_click_on_all_notices_submenu() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/ul/li[2]/ul/li[1]/a")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 4: Wait for All Notices page to load
     * Feature: And I wait for All Notices page to load
     */
    @When("I wait for All Notices page to load")
    public void i_wait_for_all_notices_page_to_load() throws InterruptedException {
        Thread.sleep(8000);
    }

    /**
     * STEP 5: Search for notice with name
     * Feature: And I search for notice with name "Font_001"
     * @param noticeName - The name of the notice to search (e.g., "Font_001")
     */
    @When("I search for notice with name {string}")
    public void i_search_for_notice_with_name(String noticeName) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div/input")).sendKeys(noticeName);
        Thread.sleep(4000);
    }

    /**
     * STEP 6: Click search button for notices
     * Feature: And I click search button for notices
     */
    @When("I click search button for notices")
    public void i_click_search_button_for_notices() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"layout-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/div/button")).click();
        Thread.sleep(4000);
    }

    /**
     * STEP 7: Click on the notice result from table
     * Feature: And I click on the notice result from table
     */
    @When("I click on the notice result from table")
    public void i_click_on_the_notice_result_from_table() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//div[@class='rs-table-cell-content']//div[@class='rs-table-cell-wrap']/a"));
        element.click();
        Thread.sleep(3000);
    }

    /**
     * STEP 8: Click download button on notice details
     * Feature: And I click download button on notice details
     */
    @When("I click download button on notice details")
    public void i_click_download_button_on_notice_details() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[6]/div/div/button")).click();
        Thread.sleep(2000);
    }

    /**
     * STEP 9: Switch to main window
     * Feature: And I switch to main window
     */
    @When("I switch to main window")
    public void i_switch_to_main_window() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
    }

    /**
     * STEP 10: Confirm the alert action
     * Feature: And I confirm the alert action
     */
    @When("I confirm the alert action")
    public void i_confirm_the_alert_action() {
        driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled swal2-default-outline']")).click();
    }

    /**
     * STEP 11: Click on link button in notice details
     * Feature: And I click on link button in notice details
     */
    @When("I click on link button in notice details")
    public void i_click_on_link_button_in_notice_details() throws InterruptedException {
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > button:nth-child(1)")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 12: Click on parent notices tab
     * Feature: And I click on parent notices tab
     */
    @When("I click on parent notices tab")
    public void i_click_on_parent_notices_tab() throws InterruptedException {
        driver.findElement(By.cssSelector("div[class='main-content'] li:nth-child(2) a:nth-child(1)")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 13: Click on Proxy Notices menu
     * Feature: And I click on Proxy Notices menu
     */
    @When("I click on Proxy Notices menu")
    public void i_click_on_proxy_notices_menu() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Proxy Notices']")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 14: Search for parent notice with name
     * Feature: And I search for parent notice with name "Parent_July1"
     * @param parentNoticeName - The name of the parent notice to search (e.g., "Parent_July1")
     */
    @When("I search for parent notice with name {string}")
    public void i_search_for_parent_notice_with_name(String parentNoticeName) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div/input")).sendKeys(parentNoticeName);
        Thread.sleep(1000);
    }

    /**
     * STEP 15: Click search button for parent notices
     * Feature: And I click search button for parent notices
     */
    @When("I click search button for parent notices")
    public void i_click_search_button_for_parent_notices() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div/div/button")).click();
        Thread.sleep(4000);
    }

    /**
     * STEP 16: Click on parent notice result
     * Feature: And I click on parent notice result
     */
    @When("I click on parent notice result")
    public void i_click_on_parent_notice_result() throws InterruptedException {
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1)")).click();
        Thread.sleep(3000);
    }

    /**
     * STEP 17: Navigate back to notices list
     * Feature: Then I navigate back to notices list
     */
    @Then("I navigate back to notices list")
    public void i_navigate_back_to_notices_list() {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[1]/div/div/ol/li[2]/a")).click();
    }
}
