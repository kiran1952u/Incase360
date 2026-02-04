package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverFactory;
import utilities.ScenarioContext;

import java.time.Duration;

public class Hooks {
    public  static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        // Clear ScenarioContext data after each scenario
        ScenarioContext.clearContext();

        // Quit the browser
        DriverFactory.quitDriver();
    }
}