package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SettingsPage extends BasePage{

    public SettingsPage(AndroidDriver driver) {
        super(driver);
    }

    private String mistakesLimitSwitcher = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.Switch";
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

    public void clickMistakesLimitSwitcher () {
        waitVisibility(By.xpath(mistakesLimitSwitcher));
        click(By.xpath(mistakesLimitSwitcher));
    }

    public String getNotificationMessage() {
        waitVisibility(By.id(notificationMessage));

        return getText(By.id(notificationMessage));
    }

}
