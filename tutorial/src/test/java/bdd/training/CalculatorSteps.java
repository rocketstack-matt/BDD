package bdd.training;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import bdd.tutorial.Calculator;

public class CalculatorSteps {

	private Calculator calculator;
	private int calcResult = 0;

	@Given("a calculator")
	public void setup() {
		calculator = new Calculator();
	}

	@When("the user adds the numbers $number1 and $number2 together")
	public void calculatorAdd(int x, int y) {
		calcResult = calculator.add(x, y);
	}

	@Then("the value of the calculator must be $number")
	public void verifyResult(int result) {
		assertEquals(result, calcResult);
	}

}
