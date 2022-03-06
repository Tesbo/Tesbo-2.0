package io.unity.framework.readers;


import org.json.JSONArray;
import org.json.JSONObject;

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

    public String getPlatform(String configName) {

        return getConfigObject(configName).getString("platform");

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


    public String get_grid_url(String configName) {
        JSONObject object = getTestConfig();
        return getConfigObject(configName).getString("gridURL");
    }
    public String get_appium_url(String configName) {
        JSONObject object = getTestConfig();
        return getConfigObject(configName).getString("appiumURL");
    }
    public JSONArray getSuites (String configName) throws org.json.JSONException
    {
        JSONObject object = getTestConfig();
        return (JSONArray) getConfigObject(configName).get("testNGsuite");
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
