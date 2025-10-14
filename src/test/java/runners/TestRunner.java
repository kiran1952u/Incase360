package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = {
                "src/test/resources/features/Autoreport_test_with_multiple_batches_express.feature",
                "src/test/resources/features/Autodownload_with_tracking_express.feature",
                "src/test/resources/features/Autodownload_with_tracking.feature",
                "src/test/resources/features/Autoreport_for_standard_notice.feature"
        },
        glue = {"stepdefinitions", "utilities"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "junit:target/cucumber-report.xml"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
        // Optional: override scenarios if needed
}
