package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class Instructions extends BasePage{

    private Logger logger = LogManager.getRootLogger();
    private PlayPage playPage;

    public Instructions(AndroidDriver driver) {
        super(driver);
        playPage = new PlayPage(driver);
    }

    private String skipButton = "com.easybrain.sudoku.android:id/skip";

    public PlayPage clickSkipButton () {
        logger.info("Waiting for visibility of Skip button");
        waitVisibility(By.id(skipButton));
        logger.info("Clicking on Skip button");
        click(By.id(skipButton));

        return new PlayPage(driver);
    }



}
