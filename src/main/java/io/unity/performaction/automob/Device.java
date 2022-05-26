package io.unity.performaction.automob;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.locator_reader;

public class Device {
    AppiumDriver driver;
    Element element;
    locator_reader reader = new locator_reader();

    public Device(AppiumDriver dri) {
        this.driver = dri;
        element = new Element(driver);
    }


    public void switch_to_context(String context_name) {

        if (reader.getPlatform().equalsIgnoreCase("android")) {
            ((AndroidDriver) driver).context(context_name);
        }
        if (reader.getPlatform().equalsIgnoreCase("iOS")) {
            ((IOSDriver) driver).context(context_name);
        }
    }


}
