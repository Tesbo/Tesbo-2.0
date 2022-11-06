package io.tesbo.framework.readers.config;

import org.json.JSONObject;
import org.tinylog.Logger;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataConfigReader {

    public JSONObject getData(String fileName) {
        String pathSeparator = FileSystems.getDefault().getSeparator();
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src" + pathSeparator + "config" + pathSeparator + "" + fileName + ".json").toAbsolutePath()));
        } catch (Exception e) {
            Logger.info("Platform file not found");
        }
        JSONObject testConfig = new JSONObject(data);

        return testConfig;
    }





}
