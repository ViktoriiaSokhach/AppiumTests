package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SettingsPage extends BasePage{

    public SettingsPage(AndroidDriver driver) {
        super(driver);
    }

    private Logger logger = LogManager.getRootLogger();
    private String mistakesLimitSwitcher = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.Switch";
    private String autoCheckForMistakesSwitcher = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.Switch\n";
    private String notificationMessage = "android:id/message";

    public boolean isMistakesLimitTurnOn() {
        waitVisibility(By.xpath(mistakesLimitSwitcher));
        String status = getText(By.xpath(mistakesLimitSwitcher));
        boolean isOn = false;
        if (status.equals("ON")) {
            isOn = true;
        }
         return isOn;
    }

    public boolean isAutoCheckForMistakesTurnOn() {
        waitVisibility(By.xpath(autoCheckForMistakesSwitcher));
        String status = getText(By.xpath(autoCheckForMistakesSwitcher));
        boolean isOn = false;
        if (status.equals("ON")) {
            isOn = true;
        }
        return isOn;
    }

    public void clickMistakesLimitSwitcher () {
        logger.info("Waiting for visibility of Mistakes Limit switcher");
        waitVisibility(By.xpath(mistakesLimitSwitcher));
        logger.info("Clicking on Mistakes Limit switcher");
        click(By.xpath(mistakesLimitSwitcher));
    }

    public String getNotificationMessage() {
        logger.info("Waiting for visibility of Notification message");
        waitVisibility(By.id(notificationMessage));
        logger.info("Getting text of Notification message");
        return getText(By.id(notificationMessage));
    }

}
