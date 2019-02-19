package tests.cucumber.steps;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tests.ThreadLocalDriver;

import java.io.IOException;
import java.net.URL;

public class BaseSteps {

    private Logger logger = LogManager.getRootLogger();

    @BeforeMethod
    public void setup () throws IOException {
        logger.info("Setting up Desired Capabilities");

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("deviceName", "Galaxy Nexus API 27");
        capability.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        capability.setCapability("platformName", "Android");
        capability.setCapability("platformVersion", "8.1.0");
        capability.setCapability("app", "C:\\soft\\Sudoku com_v1.3.8_apkpure.com.apk");
        capability.setCapability("appActivity","com.easybrain.sudoku.gui.splash.SplashActivity");
        capability.setCapability("avd", "Galaxy_Nexus_API_27");

        logger.info("Setting TLDDriver");
        ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability));
    }

    @AfterMethod
    public synchronized void teardown(){
        logger.info("Tearing down TLDDriver");
        ThreadLocalDriver.getTLDriver().quit();
    }
}

