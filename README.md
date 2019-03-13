# BDD
## Behaviour Driven Development Tutorial

### Creating our first Story
In this section we're going to use JBehave to create our first BDD test story and use that to drive our development.

Before we do anything else, delete the App and AppTest classes, then open your pom.xml and add the following dependency.

```xml
<dependency>
    <groupId>org.jbehave</groupId>
    <artifactId>jbehave-core</artifactId>
    <version>4.1</version>
    <scope>test</scope>
</dependency>
```

We also need to upgrade the version of JUnit that Maven gave us to work with JBehave so change the version to 4.12.

This will pull in the necessary libraries from JBehave to allow us to write our first story. We also want to use annotations and our project is currently using Java 1.5 which doesn't support them, so also add the following to upgrade it to Java 1.8.

```xml
<properties>
	<maven.compiler.source>1.8</maven.compiler.source>
	<maven.compiler.target>1.8</maven.compiler.target>
</properties>
```

**Our First Story**

Let's start by creating a new file called calculator_story.story in the bdd.training package in the src/test/java directory, then copy in the below story.

> **Scenario**: when a user inputs two numbers into a calculator using the 'plus' method it should return the sum of the two numbers    
>  
> **Given** a calculator    
> **When** the user adds the numbers 24 and 11 together  
> **Then** the value of the calculator must be 35   

Now in the same directory add a class called CalculatorSteps.java and add the following code.

```java
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
```

Note that we have marked the verifyResult method as @Pending. This allows us to force the test case to fail until we implement it.

We now finally need to do a bit of setup to call our CalculatorSteps class from a JUnit. In the same package add a new class called CalculatorStory and paste in the following code.

```java
public class CalculatorStory extends JUnitStory {
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().usePendingStepStrategy(new FailingUponPendingStep())
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				.useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), new CalculatorSteps()).createCandidateSteps();
	}
}
```

The above class is using the JBehave framework libraries to load the story file we have created and use it to run against the test steps class we created. The inclusion of the FailingUponPendingStep() strategy. This ensures that JUnit will mark any unimplemented tests as failure cases, which is what we want until we implement a working test.

If you now run the CalculatorStory using JUnit you will see output to your console, effectively printing the unimplemented test and the JUnit window will show the failure for the Pending test.

### Next Steps
Try and add a Calculator class that will implement the business logic as specified by the test. When you're ready to progress switch to section3.
