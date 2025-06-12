package walmart.mobileautomation.StepDefinitions;

import io.cucumber.java.en.Given;
import walmart.mobileautomation.utils.StartServer;
public class StartAppiumServer {
	@Given("I want to start appium Server")
	public void i_want_to_start_appium_server() {
		StartServer.StartMyAppiumServer();
	}
}
