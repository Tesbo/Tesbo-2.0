package io.unity.framework.readers;


import io.unity.framework.runner.TestRunner;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class json_file_reader {


    public JSONObject getTestConfig() {


        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src/config/TestConfig.json").toAbsolutePath()));
        } catch (Exception e) {
            System.out.println("config file not found");
        }
        JSONObject testConfig = new JSONObject(data);

        return testConfig;
    }




    public String getRunConfig() {
        JSONObject object = getTestConfig();
        return object.getString("run");
    }

    public JSONObject getConfigObject(String configName) {
        JSONObject object = getTestConfig();
        return (JSONObject) ((JSONObject) object.get("config")).get(configName);

    }

    public String getReportKey(String configName)
    {
        return (String) getConfigObject(configName).get("tesboReportKey");
    }



    public String getPlatform(String configName) {

        return getConfigObject(configName).getString("platform");

    }

    public String getCurrentReportDirectory() {
        String dir = System.getProperty("user.dir");

        return dir+"/test-output";
    }



    public JSONObject getAPIConfig(String configName) {

        return (JSONObject) getConfigObject(configName).get("apiTestConfig");
    }



    public boolean isAPITestConfigEnable(String configName) {

        return (boolean) getAPIConfig(configName).get("enable");
    }

    public String getAPIEnv(String configName) {

        return (String) getAPIConfig(configName).get("env");
    }

    public String getAPIEnvDirect(String configName) {

        return (String) getConfigObject(configName).get("env");
    }


    public JSONObject getTimeAssertion(String configName) {
        return (JSONObject) getConfigObject(configName).get("timeAssertion");
    }


    public Boolean isTimeAssertionEnable(String configName) {
        return (Boolean) getTimeAssertion(configName).get("enable");
    }

    public int getTimeToCompare(String configName) {
        return (int) getTimeAssertion(configName).get("timeToCompareInMs");
    }

    public String getEnv(String configName) {
        return getConfigObject(configName).getString("env");
    }


    public boolean isGrid(String configName) {
        return (boolean) getConfigObject(configName).get("isGrid");
    }

    public String getBrowser(String configName) {
        return getConfigObject(configName).getString("browser");
    }


    public JSONObject get_capabilities(String configName) {

        return getConfigObject(configName).getJSONObject("capabilities");
    }


    public JSONObject get_browserStackOption(String configName) {

        return getConfigObject(configName).getJSONObject("browserStackOption");
    }


    public JSONObject get_sauceLabOption(String configName) {

        return getConfigObject(configName).getJSONObject("sauceLabOption");
    }

    public JSONObject get_lambdaTestOption(String configName) {

        return getConfigObject(configName).getJSONObject("lambdaTestOption");
    }


    public String get_grid_url(String configName) {
        JSONObject object = getTestConfig();
        return getConfigObject(configName).getString("gridURL");
    }

    public String get_grid_platForm(String configName) {
        JSONObject object = getTestConfig();
        return getConfigObject(configName).getString("gridPlatform");
    }


    public String get_appium_url(String configName) {
        JSONObject object = getTestConfig();
        return getConfigObject(configName).getString("appiumURL");
    }

    public String get_appium_platform(String configName) {
        JSONObject object = getTestConfig();
        return getConfigObject(configName).getString("appiumPlatform");
    }


    public String get_app_name(String configName) {

        return getConfigObject(configName).getString("app");
    }


    public String get_final_app_path(String configName) {

        String app_path = "";

        File file = new File("src/test/java/mobile/app/" + get_app_name(configName));
        app_path = file.getAbsolutePath();


        return app_path;
    }


    public JSONArray getSuites(String configName) throws org.json.JSONException {
        JSONObject object = getTestConfig();
        return (JSONArray) getConfigObject(configName).get("testNGsuite");
    }



    public String getEnvFromCurrentConfig() {
        JSONObject object = getTestConfig();
        json_file_reader config = new json_file_reader();
        if (TestRunner.currentConfig.equals("")) {
            TestRunner.currentConfig = config.getRunConfig();
        }
        return getConfigObject(TestRunner.currentConfig).getString("env");
    }



   /* public String getExecutionOn() {
        JSONObject object = getTestConfig();
        return object.getString("executionOn");
    }*/

/*






    public String get_grid_url() {
        JSONObject object = getTestConfig();

        return object.getString("grid_url");

    }

    public JSONObject get_capabilities() {

        JSONObject object = getTestConfig();
        JSONObject platform = (JSONObject) object.get("platform");
        return platform.getJSONObject("capabilities");


    }*/
}
