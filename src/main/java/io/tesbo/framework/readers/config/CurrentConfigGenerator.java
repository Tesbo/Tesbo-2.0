package io.tesbo.framework.readers.config;

import io.tesbo.framework.init.Base;
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
        JSONObject new_object = new JSONObject();

        new_object = object;
        PlatformReader reader = new PlatformReader();
        DataConfigReader dataConfigReader = new DataConfigReader();

        new_object.put("executionOn", reader.getPlatformDetails(object.get("executionOn").toString()));

        object.put("dataFile", dataConfigReader.getData((String) object.get("dataFile")));
        return new_object;
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

    /*
    * Generate the Suite in case for the Tags, Methods and Class Name Run
    *
    *
    * */
    public void generateSuite()
    {

    }

}
