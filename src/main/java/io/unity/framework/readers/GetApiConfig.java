package io.unity.framework.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
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

            try {

                data = new String(Files.readAllBytes(Paths.get(request_name).toAbsolutePath()));

            } catch (Exception tempFolder) {

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

        }


        finalEndpoint = addQueryParameterInURL(finalEndpoint);

        return finalEndpoint;
    }

    public String getEndPointWithPathParameter(String endPoint) {

        String newEndPoint = endPoint;

        JSONObject allPathParameter = getPathParameter();
        Iterator keys = allPathParameter.keys();

        while (keys.hasNext()) {

            String currentDynamicKey = (String) keys.next();

            newEndPoint = newEndPoint.replace("${" + currentDynamicKey + "}", allPathParameter.get(currentDynamicKey).toString());

        }

        return newEndPoint;
    }


    public String getEndPointWithQueryParameter(String endPoint) {
        String newEndPoint = endPoint;
        String[] singleEndpointElement = endPoint.split("\\?");

        String queryParameter = singleEndpointElement[1];

        String[] total_parameter_list = queryParameter.split("&");

        for (String single_parameter : total_parameter_list) {

            String[] param_list = single_parameter.split("=");
            String param_value = param_list[1].substring(2, param_list[1].length() - 1);
            newEndPoint = newEndPoint.replace("${" + param_value + "}", getQueryParameterValue(param_value));

        }

        return newEndPoint;
    }

    public String addQueryParameterInURL(String endPoint) {

        String newEndPoint = endPoint + "?";
        String final_Endpoint = "";
        try {
            JSONObject object = getAllQueryParameterList();
            Iterator keys = object.keys();

            while (keys.hasNext()) {

                String currentDynamicKey = (String) keys.next();
                String currentDynamicValue = object.get(currentDynamicKey).toString();
                newEndPoint = newEndPoint + currentDynamicKey + "=" + currentDynamicValue + "&";
            }

            final_Endpoint = newEndPoint.substring(0, newEndPoint.length() - 1);
        } catch (Exception e) {
            final_Endpoint = endPoint;
        }

        return final_Endpoint;
    }


    public String getQueryParameterValue(String parameterName) {

        JSONObject object = getApiConfig();
        JSONObject pathParameter = (JSONObject) object.get("queryParameter");
        return pathParameter.getString(parameterName);

    }

    public JSONObject getAllQueryParameterList() {

        JSONObject object = getApiConfig();
        JSONObject queryParameter = (JSONObject) object.get("queryParameter");
        return queryParameter;

    }


    public JSONObject getPathParameter() {

        JSONObject object = getApiConfig();
        JSONObject pathParameter = (JSONObject) object.get("pathParameter");
        return pathParameter;

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

    public JSONObject getSchema() {
        JSONObject object = getApiConfig();
        return (JSONObject) object.get("schema");
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
