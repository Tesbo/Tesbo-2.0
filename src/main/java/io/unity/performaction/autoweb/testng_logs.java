package io.unity.performaction.autoweb;

import org.testng.Reporter;

public class testng_logs {


    public void test_step(String message) {
        System.out.println(message);
        Reporter.log("Step : " + message + "<br>");
    }


    public void test_result(boolean bool) {
        if (bool) {
            Reporter.log("<h1 style=\"color:green;font-size:15px;\">Test Passed</h1> ");
        } else {
            Reporter.log("<h1 style=\"color:red;font-size:15px;\">Test Failed</h1>   ");
        }

    }


}
