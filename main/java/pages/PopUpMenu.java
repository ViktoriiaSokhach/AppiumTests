package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class PopUpMenu extends BasePage{

    private Logger logger = LogManager.getRootLogger();
    private SettingsPage settingsPage;

    private String settings = "com.easybrain.sudoku.android:id/item_popup_menu_settings";
    private String statistics = "com.easybrain.sudoku.android:id/item_popup_menu_statistics";

    public PopUpMenu(AndroidDriver driver) {
        super(driver);
        settingsPage = new SettingsPage(driver);
    }

    public SettingsPage navigateSettings () {
        logger.info("Waiting for visibility of Settings Page link");
        waitVisibility(By.id(settings));
        logger.info("Clicking on Settings Page link");
        click(By.id(settings));

        return new SettingsPage(driver);
    }

    public StatisticsPage navigateStatistics () {
        logger.info("Waiting for visibility of Statistics Page link");
        waitVisibility(By.id(statistics));
        logger.info("Clicking on Statistics Page link");
        click(By.id(statistics));

        return new StatisticsPage(driver);
    }
}

