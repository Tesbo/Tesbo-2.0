package io.unity.framework.init;

import org.openqa.selenium.WebDriver;

public class Session {


    public WebDriver create_new_web_session() {
        WebDriver driver;
        TestmanBase base = new TestmanBase();
        driver = base.init();
        return driver;
    }

    public WebDriver create_new_web_session(String config_name) {
        WebDriver driver;
        TestmanBase base = new TestmanBase();
        driver = base.init(config_name);
        return driver;
    }


    public void close_session(WebDriver driver) {
        driver.quit();
    }

    public WebDriver create_new_mobile_session(String config_name) {
        WebDriver driver;
        TestmanBase TestmanBase = new TestmanBase();
        driver = TestmanBase.setup_android(config_name);
        return driver;
    }

}
