package io.tesbo.framework.readers.config;

import io.tesbo.framework.init.Base;
import org.json.JSONArray;
import org.json.JSONObject;
import org.tinylog.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CurrentConfigGenerator {

    public JSONObject getTestConfig() {
        String data = "";
        try {
            String pathSeparator = FileSystems.getDefault().getSeparator();
            data = new String(Files.readAllBytes(Paths.get("src" + pathSeparator + "config" + pathSeparator + "run-config.json").toAbsolutePath()));
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
        JSONObject object = getConfigObject(configName);
        PlatformReader reader = new PlatformReader();
        DataConfigReader dataConfigReader = new DataConfigReader();

        JSONArray platformObjectList = new JSONArray();
        JSONArray platformList = new JSONArray();

        for (Object platform : platformList) {

            JSONObject object1 = reader.getPlatformDetails(platform.toString());

            object1.put("platformName", platform.toString());
            platformObjectList.put(object1);
        }

        object.put("platformList", platformList);
        object.put("dataFile", dataConfigReader.getData((String) object.get("dataFile")));
        return object;
    }

    public void generateFile(JSONObject fileContent) {
        try {
            String pathSeparator = FileSystems.getDefault().getSeparator();

            FileWriter file = new FileWriter(new File("src" + pathSeparator + "config" + pathSeparator + "config-lock.json"));
            file.write(fileContent.toString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
