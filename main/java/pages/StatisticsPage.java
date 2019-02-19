package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class StatisticsPage extends BasePage {

    private Logger logger = LogManager.getRootLogger();
    private String resetStatistics = "com.easybrain.sudoku.android:id/reset_stats";

    public StatisticsPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isResetButtonDisplayed() {
        logger.info("Waiting for visibility of Reset Statistics button");
        waitVisibility(By.id(resetStatistics));
        logger.info("Checking if Reset Statistics button is displayed");
        return isElementPresent(By.id(resetStatistics));
    }

}

