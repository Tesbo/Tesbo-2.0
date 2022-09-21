package io.unity.performaction.automob;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.unity.framework.readers.json_file_reader;
import io.unity.framework.runner.TestRunner;
import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.locator_reader;

public class Device {
    AppiumDriver driver;
    Element element;
    json_file_reader reader = new json_file_reader();

    public Device(AppiumDriver dri) {
        this.driver = dri;
        element = new Element(driver);
    }


    public void switch_to_context(String context_name) {

        if (reader.getPlatform(TestRunner.currentConfig).equalsIgnoreCase("android")) {
            ((AndroidDriver) driver).context(context_name);
        }
        if (reader.getPlatform(TestRunner.currentConfig).equalsIgnoreCase("iOS")) {
            ((IOSDriver) driver).context(context_name);
        }
    }


}
