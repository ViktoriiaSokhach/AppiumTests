package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class Instructions extends BasePage{

    private Logger logger = LogManager.getRootLogger();
    private PlayPage playPage;

    private String skipButton = "com.easybrain.sudoku.android:id/skip";
    private String nextPageArrow = "com.easybrain.sudoku.android:id/next";
    private String instructionMessage = "com.easybrain.sudoku.android:id/bubble_text";

    public Instructions(AndroidDriver driver) {
        super(driver);
        playPage = new PlayPage(driver);
    }

    public Instructions clickNextPageArrow () {
        logger.info("Waiting for visibility and clicking on Next Page Arrow");
        waitAndClick(By.id(nextPageArrow));
        return new Instructions(driver);
    }

    public PlayPage clickSkipButton () {
        logger.info("Waiting for visibility and clicking on Skip button");
        waitAndClick(By.id(skipButton));
        return new PlayPage(driver);
    }

    public String GetInstructionMessage() {
        logger.info("Waiting for visibility of Instruction message");
        waitVisibility(By.id(instructionMessage));
        logger.info("Getting text of Instruction message");
        return getText(By.id(instructionMessage));
    }

}
