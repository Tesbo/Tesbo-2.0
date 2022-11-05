package io.tesbo.performaction.automob;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.tesbo.framework.readers.json_file_reader;
import io.tesbo.framework.runner.TestRunner;
import io.tesbo.performaction.autoweb.Element;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class Device {
    AppiumDriver driver;
    Element element;
    json_file_reader reader = new json_file_reader();
    private Duration STEP_DURATION = Duration.ofMillis(1);
    private Duration NO_TIME = Duration.ofMillis(0);
    private PointerInput.Origin VIEW = PointerInput.Origin.viewport();
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


    public void scroll_down() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        int startY = (int) ((driver.manage().window().getSize().getHeight()) * 0.80);
        int endY = (int) ((driver.manage().window().getSize().getHeight()) * 0.20);

        int startX = (int) ((driver.manage().window().getSize().getWidth()) * 0.50);
        Sequence circle = new Sequence(finger, 0);

        circle.addAction(finger.createPointerMove(NO_TIME, VIEW, startX, startY));
        circle.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));


        for (int i = 1; i < 300 + 1; i++) {
            circle.addAction(finger.createPointerMove(STEP_DURATION, VIEW, startX, startY - (i+10)));
        }

        driver.perform(Arrays.asList(circle));

    }


}
