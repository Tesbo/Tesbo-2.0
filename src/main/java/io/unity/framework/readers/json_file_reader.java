package io.unity.framework.readers;


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

    public String getEnv() {
        JSONObject object = getTestConfig();
        return object.getString("env");
    }

    public String getExecutionOn() {
        JSONObject object = getTestConfig();
        return object.getString("executionOn");
    }


    public String getPlatformType() {
        JSONObject object = getTestConfig();
        JSONObject platform = (JSONObject) object.get("platform");
        return platform.getString("platformType");
    }


    public String getBrowser() {
        JSONObject object = getTestConfig();
        JSONObject platform = (JSONObject) object.get("platform");
        return platform.getString("browser");
    }

    public String get_execution_on() {
        JSONObject object = getTestConfig();
        return object.getString("execution_on");

    }

    public String get_grid_url() {
        JSONObject object = getTestConfig();

        return object.getString("grid_url");

    }

    public JSONObject get_capabilities() {

        JSONObject object = getTestConfig();
        JSONObject platform = (JSONObject) object.get("platform");
        return platform.getJSONObject("capabilities");


    }
}
