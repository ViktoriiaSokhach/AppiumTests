package tests.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.*;
import tests.ThreadLocalDriver;

public class MistakesLimitSwitchingSteps extends BaseSteps{

    private Logger logger = LogManager.getRootLogger();
    private WelcomePage welcomePage;
    private SettingsPage settingsPage;

    @Before
    public void setupMistakesLimitSwitchingSteps () {
        welcomePage = new WelcomePage(ThreadLocalDriver.getTLDriver());
        settingsPage = new SettingsPage(ThreadLocalDriver.getTLDriver());

    }
    @Given("^User navigates to Settings$")
    public void navigateToSettings() {
        welcomePage
                .clickFirstAcceptButton()
                .clickSecondAcceptButton()
                .clickSkipButton()
                .clickMenuBar()
                .navigateSettings();
    }

    @Given("^Mistakes Limit is ON$")
    public void checkIfMistakesLimitIsOn() {
        logger.info("Checking if Mistakes Limit switcher is ON:");
        boolean isOn = settingsPage.isMistakesLimitTurnOn();
        if (!isOn) {
            settingsPage.clickMistakesLimitSwitcher();
        }
    }

    @When("^He clicks on Limit switcher$")
    public void clickOnLimitSwitcher() {
        settingsPage.clickMistakesLimitSwitcher();
    }

    @Then("^Mistakes Limit changes to OFF$")
    public void assertThatMistakesLimitChangesToOff() {
        boolean isOn = settingsPage.isMistakesLimitTurnOn();

        logger.info("Asserting if Mistakes Limit switcher changes to OFF");
        Assert.assertTrue(!isOn);
    }

    @Then("^Auto-Check For Mistakes changes to OFF$")
    public void assertThatAutoCheckForMistakesChangesToOff() {
        boolean isOn = settingsPage.isAutoCheckForMistakesTurnOn();

        logger.info("Asserting if Auto-Check For Mistakes switcher changes to OFF");
        Assert.assertTrue(!isOn);
    }

    @Then("^Notification message (.*) is displayed$")
    public void assertThatNotificationMessageIsDisplayed(String message) {
        String actualMessage = settingsPage.getNotificationMessage();

        logger.info("Asserting if notification message is displayed correctly");
        Assert.assertEquals(actualMessage, message);
    }

}
