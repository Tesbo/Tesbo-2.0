package io.unity.framework.readers;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GetApiConfig {

    String request_name;
    public GetApiConfig(String request_name)
    {
        this.request_name = request_name;
    }


    public JSONObject getApiConfig() {


        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src/test/java/api/requests/"+request_name+".json").toAbsolutePath()));
        } catch (Exception e) {
            System.out.println("config file not found");
        }
        JSONObject testConfig = new JSONObject(data);

        return testConfig;
    }

    public String getEndPoint() {
        JSONObject object = getApiConfig();
        return object.getString("endPoint");
    }

    public String getMethodType() {
        JSONObject object = getApiConfig();
        return object.getString("methodType");
    }

    public JSONObject getHeader() {
        JSONObject object = getApiConfig();
        return (JSONObject) object.get("header");
    }

    public JSONObject getBody() {
        JSONObject object = getApiConfig();
        return (JSONObject) object.get("body");
    }





}
