package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class PopUpMenu extends BasePage{

    private Logger logger = LogManager.getRootLogger();
    private SettingsPage settingsPage;

    public PopUpMenu(AndroidDriver driver) {
        super(driver);
        settingsPage = new SettingsPage(driver);
    }

    private String settings = "com.easybrain.sudoku.android:id/item_popup_menu_settings";

    public SettingsPage navigateSettings () {
        logger.info("Waiting for visibility of Settings Page link");
        waitVisibility(By.id(settings));
        logger.info("Clicking on Settings Page link");
        click(By.id(settings));

        return new SettingsPage(driver);
    }

}

