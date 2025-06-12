package walmart.mobileautomation.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"walmart.mobileautomation.StepDefinitions"}, // must match your LoginSteps package
    plugin = {"pretty", "html:target/cucumber-report.html"},
    tags = "@tag", // optional: filter scenarios by tag
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}