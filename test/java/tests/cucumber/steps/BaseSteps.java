package tests.cucumber.steps;

import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import tests.ThreadLocalDriver;

public class BaseSteps {

    private WelcomePage welcomePage = null;
    private WebDriverWait wait;

    //Screen Classes Initialization
    protected void setupCucumber () {
        System.out.println("Cucumber Base Test");
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
        welcomePage = new WelcomePage(ThreadLocalDriver.getTLDriver());
    }

    protected void teardown(){
        ThreadLocalDriver.getTLDriver().quit();
    }
}

