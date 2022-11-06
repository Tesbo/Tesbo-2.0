package io.tesbo.framework.readers.config;

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
        JSONObject object = getLockedConfig();
        return (String) object.get("baseUrl");
    }


}


}
