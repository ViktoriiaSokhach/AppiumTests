package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PopUpMenu extends BasePage{

    private SettingsPage settingsPage;

    public PopUpMenu(AndroidDriver driver) {
        super(driver);
        settingsPage = new SettingsPage(driver);
    }

    private String settings = "com.easybrain.sudoku.android:id/item_popup_menu_settings";

    public SettingsPage navigateSettings () {
        waitVisibility(By.id(settings));
        click(By.id(settings));

        return new SettingsPage(driver);
    }

}

