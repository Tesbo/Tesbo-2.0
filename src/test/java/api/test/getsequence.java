package api.test;

import api.requests.common.Utility;

import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class getsequence extends base {

//    @Test
//    public void clone_sequence_with_blank_sequenceid() {
//        RequestBuilder builder = new RequestBuilder();
//        Utility utils = new Utility();
//
//        JSONObject pathParameter = new JSONObject();
//        JSONObject queryParameter = new JSONObject();
//        queryParameter.put("progress","1");
//        queryParameter.put("search","10");
//        JSONObject header = utils.login();
//        JSONObject body = new JSONObject();
//
//        String response2 = builder.updateRequestObject("sequence/sequence_auth", pathParameter, queryParameter, header, body);
//        JSONObject response3 = builder.performRequest(response2);
//    }

    @Test
    public void delete_sequence_with_valid_token() throws IOException, ParseException {
        RequestBuilder builder = new RequestBuilder();
        Utility utils = new Utility();
        JSONObject response = builder.performRequest("sequence/login_with_valid_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        String accestoken = validator.getDataFromBody("$.payload.accessToken");


        JSONObject pathParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("Authorization","Bearer " + accestoken);
        header.put("Content-Type","application/json");
        JSONObject body = new JSONObject();
        body.put("title","hellotest");
        JSONObject queryParameter = new JSONObject();

        String response2 = builder.updateRequestObject("sequence/delete_sequence_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response2);

        ResponseValidator validator2 = new ResponseValidator(response1);
        validator2.compareJsonData(response1,"delete_sequence_with_valid_token");

    }
}
