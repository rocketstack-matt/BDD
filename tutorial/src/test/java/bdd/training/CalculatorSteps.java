package bdd.training;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CalculatorSteps {

	@Given("a calculator")
	public void setup() {
		// Initialise the Calculator service.
	}

	@When("the user adds the numbers $number1 and $number2 together")
	public void calculatorAdd(int x, int y) {
		// Use the calculator's add funtion with the given parameters.
	}

	@Pending
	@Then("the value of the calculator must be $number")
	public void verifyResult(int result) {
		// Verify the result.
	}

}
