package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class PlayPage extends BasePage {

    private Logger logger = LogManager.getRootLogger();
    private PopUpMenu popUpMenu;

    private String menuBar = "com.easybrain.sudoku.android:id/more_custom_image_view";

    public PlayPage(AndroidDriver driver) {
        super(driver);
        popUpMenu = new PopUpMenu(driver);
    }

    public PopUpMenu clickMenuBar () {
        logger.info("Waiting for visibility of PopUpMenu");
        waitVisibility(By.id(menuBar));
        logger.info("Clicking on PopUpMenu");
        click(By.id(menuBar));

        return new PopUpMenu(driver);
    }

}
