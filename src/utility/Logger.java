package utility;

import org.testng.Reporter;

public class Logger {


    public static void log_qase_id(String qase_id) {
        Reporter.log("Test Case Id : <a href=\"https://app.qase.io/case/" + qase_id + "\"></a>");
    }
}
