package walmart.mobileautomation.runners;
import walmart.mobileautomation.CI_CD.JenkinsParams;
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
	    static {
	        String tag = JenkinsParams.getTagName();
	        if (tag == null || tag.isEmpty()) {
	            throw new RuntimeException("TAG_NAME not set from Jenkins! Please pass it as -DTAG_NAME=@smoke");
	        }

	        System.out.println("Running tests with TAG: " + tag);
	        System.setProperty("cucumber.filter.tags", tag);
	    }
}