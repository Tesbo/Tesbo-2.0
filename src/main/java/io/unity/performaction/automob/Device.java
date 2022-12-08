package io.unity.performaction.automob;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.unity.framework.readers.json_file_reader;
import io.unity.framework.runner.TestRunner;
import io.unity.performaction.autoweb.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;

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
    public void horizontal_scroll() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        int startY = (int)((double)this.driver.manage().window().getSize().getHeight() * 0.8);
        int endY = (int)((double)this.driver.manage().window().getSize().getHeight() * 0.2);
        int startX = (int)((double)this.driver.manage().window().getSize().getWidth() * 0.5);
        Sequence circle = new Sequence(finger, 0);
        circle.addAction(finger.createPointerMove(this.NO_TIME, this.VIEW, startX, startY));
        circle.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        for(int i = 1; i < 300+1; ++i) {
            circle.addAction(finger.createPointerMove(this.STEP_DURATION, this.VIEW, startX - (i+10), startY));
        }

        this.driver.perform(Arrays.asList(circle));

    }

    public void slider(String element_name){
        WebElement slider = element.find(element_name);
        Point source = slider.getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), source.x + 400, source.y));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(singletonList(sequence));

    }



}
