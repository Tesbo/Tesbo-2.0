package common;


import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader {



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

}
