package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class  WelcomePage extends BasePage {

    private Logger logger = LogManager.getRootLogger();

    public WelcomePage(AndroidDriver driver) {
        super(driver);
    }

    private String acceptButton = "com.easybrain.sudoku.android:id/btnAccept";

    public WelcomePage clickFirstAcceptButton () {
        logger.info("Waiting for visibility and clicking on first Accept button");
        waitAndClick(By.id(acceptButton));
        return this;
    }

    public Instructions clickSecondAcceptButton () {
        logger.info("Waiting for visibility and clicking on second Accept button");
        waitAndClick(By.id(acceptButton));
        return new Instructions(driver);
    }

}
