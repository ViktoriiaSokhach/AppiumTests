package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class PopUpMenu extends BasePage{

    private Logger logger = LogManager.getRootLogger();

    private String settings = "com.easybrain.sudoku.android:id/item_popup_menu_settings";
    private String statistics = "com.easybrain.sudoku.android:id/item_popup_menu_statistics";

    public PopUpMenu(AndroidDriver driver) {
        super(driver);
    }

    public SettingsPage navigateSettings () {
        logger.info("Waiting for visibility and clicking on Settings Page link");
        waitAndClick(By.id(settings));
        return new SettingsPage(driver);
    }

    public StatisticsPage navigateStatistics () {
        logger.info("Waiting for visibility and clicking on Statistics Page link");
        waitAndClick(By.id(statistics));
        return new StatisticsPage(driver);
    }
}

