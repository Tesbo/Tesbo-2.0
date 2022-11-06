package io.tesbo.framework.readers.config;

import org.json.JSONObject;
import org.tinylog.Logger;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlatformReader {

    /**
     * Reads the Platform.json and provide all file in JSONObject formate
     *
     * @return JSONObject
     */
    public JSONObject getPlatformList() {
        String pathSeparator = FileSystems.getDefault().getSeparator();
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src" + pathSeparator + "config" + pathSeparator + "platforms.json").toAbsolutePath()));
        } catch (Exception e) {
            Logger.info("Platform file not found");
        }
        JSONObject testConfig = new JSONObject(data);

        return testConfig;
    }

    /**
     * @param platformName
     */

    public JSONObject getPlatformDetails(String platformName) {

        JSONObject object = getPlatformList();
        return (JSONObject) object.get(platformName);
    }

    public JSONObject getCapabilities(String platformName) {
        JSONObject object = getPlatformDetails(platformName);

        return (JSONObject) object.get("capabilities");
    }

    public String getBrowser(String platformName) {
        JSONObject object = getCapabilities(platformName);

        return object.get("browserName").toString();
    }

    public String getBrowserVersion(String platformName) {
        JSONObject object = getCapabilities(platformName);

        return object.get("browserVersion").toString();
    }

    public String getPlatformName(String platformName) {
        JSONObject object = getCapabilities(platformName);

        return object.get("platformName").toString();
    }


    public JSONObject getOptions(String platformName) {
        JSONObject object = getPlatformDetails(platformName);

        return (JSONObject) object.get("options");
    }


    public String getGridURl(String platformName) {
        JSONObject object = getPlatformDetails(platformName);

        return object.get("gridUrl").toString();
    }

    public Boolean isGridAvailable(String platformName) {
        JSONObject object = getPlatformDetails(platformName);

        return (Boolean) object.get("isGrid");
    }

    public String getGridPlatform(String platformName) {
        JSONObject object = getPlatformDetails(platformName);

        return object.get("gridPlatform").toString();
    }


}
