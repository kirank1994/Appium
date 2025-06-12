package walmart.mobileautomation.StepDefinitions;

import io.cucumber.java.en.*;

public class LoginSteps {

	@Given("user is on login page")
	public void user_is_on_login_page() {
System.out.println("user is on login page Step Defination Implementation");
	}
	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
		System.out.println("user enters valid credentials Step Defination Implementation");
	}
	@Then("user should be logged in")
	public void user_should_be_logged_in() {
		System.out.println("user should be logged in Step Defination Implementation");
	}
}