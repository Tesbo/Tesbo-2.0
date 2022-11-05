package io.tesbo.framework.readers.config;

import io.tesbo.framework.init.Base;
import org.json.JSONArray;
import org.json.JSONObject;
import org.tinylog.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CurrentConfigGenerator {

    public JSONObject getTestConfig() {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src/config/run-config.json").toAbsolutePath()));
        } catch (Exception e) {
            System.out.println("config file not found");
        }
        JSONObject testConfig = new JSONObject(data);
        return testConfig;
    }

    public JSONObject getConfigObject(String configName) {
        JSONObject object = getTestConfig();
        return (JSONObject) ((JSONObject) object.get("config")).get(configName);
    }

    public String getRunConfig() {
        JSONObject object = getTestConfig();
        return object.getString("defaultConfigToRun");
    }

    //file name config-lock.json
    public void generatorCurrentConfigFile(String config) {
        if (config.equalsIgnoreCase("")) {
            Logger.info("Config details is empty, Taking default config");
            generateFile(readConfig(getRunConfig()));
        } else {
            generateFile(readConfig(config));
        }
        Base.checkForConfigGenerated = true;
    }


    public JSONObject readConfig(String configName) {
        JSONObject object = new JSONObject();
        object = getConfigObject(configName);

        PlatformReader reader = new PlatformReader();

        JSONArray platformObjectList = new JSONArray();

        JSONArray platformList = new JSONArray();

        for (Object platform : platformList) {
            platformObjectList.put(reader.getPlatformDetails(platform.toString()));
        }

        object.put("platformList", platformList);
        return object;
    }

    public void generateFile(JSONObject fileContent) {
        try {
            FileWriter file = new FileWriter(new File("/src/config/config-lock.json"));
            file.write(fileContent.toString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
