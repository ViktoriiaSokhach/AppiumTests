package tests.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.*;
import tests.ThreadLocalDriver;

public class MistakesLimitSwitchingSteps extends BaseSteps{
    private WelcomePage welcomePage;
    private InstructionsPage instructionsPage;
    private PlayPage playPage;
    private PopUpMenu popUpMenu;
    private SettingsPage settingsPage;

    @Before
    public void setupMistakesLimitSwitchingSteps () {
        System.out.println("Cucumber Before-MistakesLimitSwitching-test-cucumber");
        setupCucumber();
        welcomePage = new WelcomePage(ThreadLocalDriver.getTLDriver());
        instructionsPage = new InstructionsPage(ThreadLocalDriver.getTLDriver());
        playPage = new PlayPage(ThreadLocalDriver.getTLDriver());
        popUpMenu = new PopUpMenu(ThreadLocalDriver.getTLDriver());
        settingsPage = new SettingsPage(ThreadLocalDriver.getTLDriver());

    }
    @Given("^User navigates to Settings$")
    public void user_navigates_to_Settings() throws Throwable {
        welcomePage
                .clickFirstAcceptButton()
                .clickSecondAcceptButton()
                .clickSkipButton()
                .clickMenuBar()
                .navigateSettings();
    }

    @Given("^Mistakes Limit is ON$")
    public void mistakes_Limit_is_ON() throws Throwable {
        boolean isOn = settingsPage.isMistakesLimitTurnOn();
        if (isOn == false) {
            settingsPage.clickMistakesLimitSwitcher();
        }
    }

    @When("^He clicks on Limit switcher$")
    public void he_clicks_on_Limit_switcher() throws Throwable {
        settingsPage.clickMistakesLimitSwitcher();
    }

    @Then("^Mistakes Limit changes to OFF$")
    public void assert_that_mistakes_Limit_changes_to_OFF() throws Throwable {
        boolean isOn = settingsPage.isMistakesLimitTurnOn();

        Assert.assertEquals(isOn, false);
    }

    @Then("^Information message (.*) is displayed$")
    public void information_message_Changes_will_be_applied_in_the_next_game_is_displayed(String message) throws Throwable {
        String actualMessage = settingsPage.getNotificationMessage();

        Assert.assertEquals(actualMessage, message);
    }

}
