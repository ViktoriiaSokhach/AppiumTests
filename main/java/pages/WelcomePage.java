package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class  WelcomePage extends BasePage {

    private InstructionsPage instructionsPage;

    public WelcomePage(AndroidDriver driver) {
        super(driver);
        instructionsPage = new InstructionsPage(driver);
    }

    private String acceptButton = "com.easybrain.sudoku.android:id/btnAccept";

    public WelcomePage clickFirstAcceptButton () {
        waitVisibility(By.id(acceptButton));
        click(By.id(acceptButton));

        return this;
    }

    public InstructionsPage clickSecondAcceptButton () {
        waitVisibility(By.id(acceptButton));
        click(By.id(acceptButton));

        return new InstructionsPage(driver);
    }

}
