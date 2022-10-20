package io.unity.performaction.autoweb;

import org.pmw.tinylog.Logger;
import org.testng.Reporter;

public class testng_logs {


    public void test_step(String message) {
        Logger.info("Step : " + message );
        Reporter.log("Step : " + message + "<br>");
    }


    public void test_result(boolean bool) {
        if (bool) {
            Logger.info("Test Passed" );
            Reporter.log("<h1 style=\"color:green;font-size:15px;\">Test Passed</h1> ");
        } else {
            Logger.info("Test Failed" );
            Reporter.log("<h1 style=\"color:red;font-size:15px;\">Test Failed</h1>   ");
        }

    }


}
