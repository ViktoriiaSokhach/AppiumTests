package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PlayPage extends BasePage {

    private PopUpMenu popUpMenu;

    public PlayPage(AndroidDriver driver) {
        super(driver);
        popUpMenu = new PopUpMenu(driver);
    }

    private String menuBar = "com.easybrain.sudoku.android:id/more_custom_image_view";

    public PopUpMenu clickMenuBar () {
        waitVisibility(By.id(menuBar));
        click(By.id(menuBar));

        return new PopUpMenu(driver);
    }

}
