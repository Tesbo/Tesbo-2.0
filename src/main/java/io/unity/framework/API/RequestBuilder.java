package io.unity.framework.API;

import io.unity.framework.readers.GetApiConfig;
import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Map;

public class RequestBuilder {


    public JSONObject performRequest(String requestName) {
        String response = "";
        JSONObject responseObject = null;
        GetApiConfig apiConfig = new GetApiConfig(requestName);


        JSONParser parser = new JSONParser();
        try {
            responseObject = (JSONObject) parser.parse(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return responseObject;
    }

    public JSONObject performRequestWithHeaderAndBody(String requestName, Map headers, Map body) {
        String responseBody = "";
        HttpResponse response = null;
        JSONObject responseObject = null;
        HttpRequest request = null;
        GetApiConfig apiConfig = new GetApiConfig(requestName);

        if (apiConfig.getMethodType().equalsIgnoreCase("get")) {

            request = Unirest.get(apiConfig.getEndPoint()).headers(headers);
            response = request.asString();
            responseBody = (String) response.getBody();
        }

        if (apiConfig.getMethodType().equalsIgnoreCase("post")) {

            request = Unirest.post(apiConfig.getEndPoint()).headers(headers).body(body);
            response = request.asString();
            responseBody = (String) response.getBody();
        }

        JSONParser parser = new JSONParser();
        try {
            responseObject = (JSONObject) parser.parse(responseBody);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        responseObject.put("statusCode", response.getStatus());
        return responseObject;
    }
}
