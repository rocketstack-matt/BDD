package bdd.training.concordion;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import bdd.tutorial.Calculator;

@RunWith(ConcordionRunner.class)
public class CalculatorTestsFixture {
	public int add(int num1, int num2) {
		return new Calculator().add(num1, num2);
	}
}
