package io.unity.framework.remotegrid;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LambdaTestConfig {

    WebDriver driver;

    public LambdaTestConfig(WebDriver driver) {

        this.driver = driver;
    }


    public void addTestName(String TestName) {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("lambda-name=" + TestName + "");
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


