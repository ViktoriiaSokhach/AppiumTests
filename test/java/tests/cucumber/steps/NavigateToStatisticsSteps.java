package tests.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.*;
import tests.ThreadLocalDriver;

public class NavigateToStatisticsSteps extends BaseSteps {

    private Logger logger = LogManager.getRootLogger();
    private WelcomePage welcomePage;
    private PopUpMenu popUpMenu;
    private StatisticsPage statisticsPage;

    public NavigateToStatisticsSteps() {
        welcomePage = new WelcomePage(ThreadLocalDriver.getTLDriver());
        popUpMenu = new PopUpMenu(ThreadLocalDriver.getTLDriver());
        statisticsPage = new StatisticsPage((ThreadLocalDriver.getTLDriver()));
    }

    @Given("^User is in PopUpMenu$")
    public void navigateToPopUpMenu() {
        welcomePage
                .clickFirstAcceptButton()
                .clickSecondAcceptButton()
                .clickSkipButton()
                .clickMenuBar();
    }

    @When("^He clicks to Statistics link$")
    public void navigateToStatisticsPage() {
        popUpMenu.navigateStatistics();
    }

    @Then("^User navigates to Statistics page$")
    public void assertThatStatisticsPageDisplayed() {
        boolean isDisplayed = statisticsPage.isResetButtonDisplayed();
        logger.info("Asserting if Statistic Page is displayed");
        Assert.assertTrue(isDisplayed);
    }

}
