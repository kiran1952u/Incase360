package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utilities.Login_functionality_admin;

public class Loginsteps {
    private WebDriver driver = Hooks.driver;

    @Given("I login as admin")
    public void i_login_as_admin() throws InterruptedException {
        Login_functionality_admin login = new Login_functionality_admin();
        login.loginTest(driver);
    }
}