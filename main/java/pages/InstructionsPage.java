package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class InstructionsPage extends BasePage{

    private PlayPage playPage;

    public InstructionsPage(AndroidDriver driver) {
        super(driver);
        playPage = new PlayPage(driver);
    }

    private String skipButton = "com.easybrain.sudoku.android:id/skip";

    public PlayPage clickSkipButton () {
        waitVisibility(By.id(skipButton));
        click(By.id(skipButton));

        return new PlayPage(driver);
    }

}
