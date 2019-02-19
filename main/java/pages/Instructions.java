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
    private String nextPageArrow = "com.easybrain.sudoku.android:id/next";
    private String instructionMessage = "com.easybrain.sudoku.android:id/bubble_text";

    public Instructions clickNextPageArrow () {
        logger.info("Waiting for visibility of Next Page Arrow");
        waitVisibility(By.id(nextPageArrow));
        logger.info("Clicking on Next Page Arrow");
        click(By.id(nextPageArrow));

        return new Instructions(driver);
    }

    public PlayPage clickSkipButton () {
        logger.info("Waiting for visibility of Skip button");
        waitVisibility(By.id(skipButton));
        logger.info("Clicking on Skip button");
        click(By.id(skipButton));

        return new PlayPage(driver);
    }

    public String GetInstructionMessage() {
        logger.info("Waiting for visibility of Instruction message");
        waitVisibility(By.id(instructionMessage));
        logger.info("Getting text of Instruction message");
        return getText(By.id(instructionMessage));
    }





}
