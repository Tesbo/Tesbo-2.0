package io.unity.framework.init;

import org.openqa.selenium.WebDriver;

public class Session {


    public WebDriver create_new_web_session() {
        WebDriver driver;
        base base = new base();
        driver = base.init();
        return driver;
    }

    public void close_session(WebDriver driver) {
        driver.quit();
    }
    public WebDriver create_new_mobile_session() {
        WebDriver driver;
        base base = new base();
        driver = base.init();
        return driver;
    }
}
