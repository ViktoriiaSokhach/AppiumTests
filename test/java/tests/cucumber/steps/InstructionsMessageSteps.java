package tests.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.*;
import tests.ThreadLocalDriver;

public class InstructionsMessageSteps extends BaseSteps {

    private Logger logger = LogManager.getRootLogger();
    private WelcomePage welcomePage;
    private Instructions instructions;

    public InstructionsMessageSteps() {
        welcomePage = new WelcomePage(ThreadLocalDriver.getTLDriver());
        instructions = new Instructions(ThreadLocalDriver.getTLDriver());
    }

    @Given("^User is on Instructions first Page$")
    public void navigateToInstructionsFirstPage() {
        welcomePage
                .clickFirstAcceptButton()
                .clickSecondAcceptButton();
    }

    @When("^He navigates to Instructions second Page$")
    public void navigateToInstructionsSecondPage() {
        instructions.clickNextPageArrow();
    }

    @Then("^Instruction First message (.*) is displayed$")
    public void assertThatFirstInstructionMessageIsDisplayed(String message1) {
        String actualMessage = instructions.GetInstructionMessage();
        logger.info("Asserting if First instruction message is displayed correctly");
        Assert.assertEquals(actualMessage, message1);
    }

    @Then("^User navigates to Instructions third Page$")
    public void navigateToInstructionsThirdPage() {
        instructions.clickNextPageArrow();
    }

    @Then("^Instruction Second message (.*) is displayed$")
    public void assertThatSecondInstructionMessageIsDisplayed(String message2) {
        String actualMessage = instructions.GetInstructionMessage();
        logger.info("Asserting if Second instruction message is displayed correctly");
        Assert.assertEquals(actualMessage, message2);
    }

}
