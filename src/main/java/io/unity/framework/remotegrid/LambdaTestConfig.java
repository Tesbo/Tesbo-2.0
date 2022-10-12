package io.unity.framework.remotegrid;

import io.unity.framework.readers.json_file_reader;
import io.unity.framework.runner.TestRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.grid.config.JsonConfig;

public class LambdaTestConfig {

    WebDriver driver;

    public LambdaTestConfig(WebDriver driver) {

        this.driver = driver;
    }


    public void addTestName(String TestName) {

        json_file_reader config = new json_file_reader();
        if (config.get_grid_platForm(TestRunner.currentConfig).equalsIgnoreCase("lambdatest") || config.get_appium_platform(TestRunner.currentConfig).equalsIgnoreCase("lambdaTest")) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("lambda-name=" + TestName + "");
        }

    }

    public void markTestPassed() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("lambda-status=passed");
    }

    public void markTestFailed() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("lambda-status=failed");
    }
}


