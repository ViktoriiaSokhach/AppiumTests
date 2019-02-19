package tests.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import tests.cucumber.steps.BaseSteps;

@CucumberOptions(
        monochrome = true,
        tags = "~@Ignore",
        features = "src/test/java/tests/cucumber/features",
        glue = "tests.cucumber.steps" ,
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class RunCucumberFeatures extends  BaseSteps {

    private Logger logger = LogManager.getRootLogger();
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        logger.info("Cucumber @BeforeClass: Setting up TestNGCucumberRunner");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        logger.info("Cucumber @Test: Getting feature");
        System.out.println(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        logger.info("Cucumber @DataProvider: Providing features");
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        logger.info("Cucumber @AfterClass: Tearing down TestNGCucumberRunner");
        testNGCucumberRunner.finish();
    }

}
