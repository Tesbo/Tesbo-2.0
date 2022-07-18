package io.unity.framework.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.unity.performaction.autoapi.ApiFileReader;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class GetApiConfig {

    String request_name;

    public GetApiConfig(String request_name) {
        this.request_name = request_name;
    }


    public JSONObject getApiConfig() {


        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("src/test/java/api/requests/" + request_name + ".json").toAbsolutePath()));
        } catch (Exception e) {
            System.out.println("config file not found");
        }
        JSONObject testConfig = new JSONObject(data);

        return testConfig;
    }

    public String getEndPoint() {
        String test;
        JSONObject object = getApiConfig();
        String specialcharacter = "{}";
        if(object.getString("endPoint").contains(specialcharacter)){
           test = object.getString("endPoint").replaceAll("[^a-zA-Z0-9]","");
        }else {
           test = object.getString("endPoint");
        }

        return test;
    }



    public String getMethodType() {
        JSONObject object = getApiConfig();
        return object.getString("methodType");
    }

    public JSONObject getHeader() {
        JSONObject object = getApiConfig();
        return (JSONObject) object.get("header");
    }

    public Map<String, String> getHeaderMap() {
        JSONObject object = getApiConfig();

        JSONObject headerObject = (JSONObject) object.get("header");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = null;
        try {
            map = objectMapper.readValue(headerObject.toString(), Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return map;
    }

    public JSONObject getBody() {
        JSONObject object = getApiConfig();
        return (JSONObject) object.get("body");
    }
    public Map<String, String> getBodyMap() {
        JSONObject object = getApiConfig();

        JSONObject headerObject = (JSONObject) object.get("body");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = null;
        try {
            map = objectMapper.readValue(headerObject.toString(), Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return map;
    }

}
