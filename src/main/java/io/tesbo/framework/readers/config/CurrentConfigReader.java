package io.tesbo.framework.readers.config;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;
import org.tinylog.Logger;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CurrentConfigReader {


    public JSONObject getLockedConfig() {
        String pathSeparator = FileSystems.getDefault().getSeparator();

        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src" + pathSeparator + "config" + pathSeparator + "config-lock.json").toAbsolutePath()));
        } catch (Exception e) {
            Logger.info("Locked Config file not found");
        }
        JSONObject testConfig = new JSONObject(data);
        return testConfig;
    }

    public String getBaseURL() {

        String baseURl = JsonPath.read(getLockedConfig(), "$.baseUrl");

        return (baseURl);
    }


    public String getPlatform() {

        String platformName = JsonPath.read(getLockedConfig(), "$.executionOn.capabilities.platformName");


        return platformName;
    }

    public String getBrowserVersion() {

        String browserVersion = JsonPath.read(getLockedConfig(), "$.executionOn.capabilities.browserVersion");


        return browserVersion;
    }


    public String getBrowserName() {

        String browserVersion = JsonPath.read(getLockedConfig(), "$.executionOn.capabilities.browserVersion");
        return browserVersion;
    }

    public JSONObject getOptions()
    {      JSONObject browserVersion = JsonPath.read(getLockedConfig(), "$.executionOn.options");
        return browserVersion;
    }




}


}
