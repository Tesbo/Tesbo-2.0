package io.unity.framework.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        } catch (Exception baseFolder) {
            //       System.out.println("config file not found in Base Folder, Trying for the Temp Folder");
            try {

                data = new String(Files.readAllBytes(Paths.get(request_name).toAbsolutePath()));

            } catch (Exception tempFolder) {
                //         System.out.println("config file not found in Temp folder as well");
            }

        }
        JSONObject testConfig = new JSONObject(data);

        return testConfig;
    }

    public String getEndPoint() {
        String finalEndpoint;
        JSONObject object = getApiConfig();

        finalEndpoint = object.getString("endPoint");

        if (object.getString("endPoint").contains("${")) {
            finalEndpoint = getEndPointWithPathParameter(finalEndpoint);
        } else {

        }

        return finalEndpoint;
    }

    public String getEndPointWithPathParameter(String endPoint) {


        String newEndPoint = "";
        String[] singleEndpointElement = endPoint.split("/");

        for (int i = 0; i < singleEndpointElement.length; i++) {
            if (singleEndpointElement[i].contains("${")) {
                singleEndpointElement[i] = getPathParameterValue(singleEndpointElement[i].substring(2, singleEndpointElement[i].length() - 1));
            }

            newEndPoint = newEndPoint + singleEndpointElement[i] + "/";

        }
        System.out.println(newEndPoint);
        return newEndPoint;
    }

    public String getPathParameterValue(String parameterName) {

        JSONObject object = getApiConfig();
        JSONObject pathParameter = (JSONObject) object.get("pathParameter");
        return pathParameter.getString(parameterName);

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
