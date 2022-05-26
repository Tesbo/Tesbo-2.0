package io.unity.performaction.autoweb;

import io.unity.performaction.autoweb.Element;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class Window {

    WebDriver driver;
    Element element;

    public Window(WebDriver dri) {
        this.driver = dri;
        element = new Element(driver);

    }

    public String get_current_window_handle(String element_name) {
        return driver.getWindowHandle();
    }

    public Boolean find_new_window_and_switch(String oldWindow) {
        boolean switched = false;
        for (String windowHandle : driver.getWindowHandles()) {
            if (!oldWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                switched = true;
                break;
            }
        }
        return switched;
    }


    public void create_new_and_switch() {

        driver.switchTo().newWindow(WindowType.WINDOW);
    }


    public void create_new_tab_and_switch() {

        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void close_window() {
        driver.close();
    }

    public void switch_to_windows_and_close(String originalWindow) {
        driver.switchTo().window(originalWindow);
    }

    public void switch_to_iframe(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switch_to_iframe(String element_name) {
        driver.switchTo().frame(element_name);
    }

    public void switch_to_iframe(int element_name) {
        driver.switchTo().frame(element_name);
    }

    public void switch_to_default() {
        driver.switchTo().defaultContent();
    }

    public int get_window_width() {
        return driver.manage().window().getSize().getWidth();
    }

    public int get_window_height() {
        return driver.manage().window().getSize().getHeight();
    }

    public void set_window_size(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void maximize_window() {
        driver.manage().window().maximize();
    }

    public void minimize_window() {
        driver.manage().window().minimize();
    }

    public void full_screen_window() {
        driver.manage().window().fullscreen();
    }



}
