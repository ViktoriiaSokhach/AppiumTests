package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.WelcomePage;

import java.io.IOException;
import java.net.URL;

public class BaseTest {

    public WebDriverWait wait;

    //Base Screens for all cases
    protected WelcomePage welcomePage = null;

    @BeforeMethod
    public void setup () throws IOException {
        System.out.println("TestNG Before");

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("deviceName", "Galaxy Nexus API 27");
        capability.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        capability.setCapability("platformName", "Android");
        capability.setCapability("platformVersion", "8.1.0");
        capability.setCapability("app", "C:\\soft\\Sudoku com_v1.3.8_apkpure.com.apk");
        capability.setCapability("appActivity","com.easybrain.sudoku.gui.splash.SplashActivity");
        capability.setCapability("avd", "Galaxy_Nexus_API_27");

        ThreadLocalDriver.setTLDriver(new AndroidDriver (new URL("http://0.0.0.0:4723/wd/hub"),capability));
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);

        //Base Screen Initialization
        welcomePage = new WelcomePage(ThreadLocalDriver.getTLDriver());
    }

    @AfterMethod
    public synchronized void teardown(){
        ThreadLocalDriver.getTLDriver().quit();
    }

}
