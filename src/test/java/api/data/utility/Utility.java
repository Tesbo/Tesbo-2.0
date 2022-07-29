package api.data.utility;

import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Utility {


    public Map addBearerInHeader(String token)
    {
        String Bearer = "Bearer "+token;
        System.out.println(token);
        Map header = new HashMap();
        header.put("Content-Type","application/json");
        header.put("Authorization", Bearer);
        return header;
    }

    public Map addTitleInHeader()
    {
        String test = "QABLE";

        Map body = new HashMap();
        body.put("title", test);
        return body;
    }


    public Map addcontenttype(String token)
    {
        String Bearer = "Bearer "+token;
        System.out.println(token);
        Map header = new HashMap();
        header.put("Content-Type","application/zip");
        header.put("Authorization", Bearer);
        return header;
    }

    public Map addTitleInHeaderwithmorecharacter()
    {
        String test = "test12345678910test12345678910test12345678910test12345678910";

        Map body = new HashMap();
        body.put("title", test);
        return body;
    }

    public JSONObject login(){
        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_valid_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        String accestoken = validator.getDataFromBody("$.payload.accessToken");
        JSONObject token = new JSONObject();
        token.put("Authorization","Bearer " + accestoken);
        token.put("Content-Type","application/json");

        return token;

    }


    public JSONObject getsequenceID() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_valid_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        String accestoken = validator.getDataFromBody("$.payload.accessToken");

        JSONObject pathParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("Authorization","Bearer " +accestoken);
        header.put("Content-Type","application/json");
        JSONObject body = new JSONObject();
        body.put("title","newtest");
        JSONObject queryParameter = new JSONObject();

        String response1 = builder.updateRequestObject("sequence/create_sequence/create_sequence_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response2 = builder.performRequest(response1);
        ResponseValidator validator1 = new ResponseValidator(response2);

        String sid = validator1.getDataFromBody("$.payload.settings[0].sequenceId");
        JSONObject sequencid = new JSONObject();
        sequencid.put("sequenceId", sid);

        return sequencid;

    }

    public JSONObject diffcontenttypelogin(){
        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_valid_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        String accestoken = validator.getDataFromBody("$.payload.accessToken");
        JSONObject token = new JSONObject();
        token.put("Authorization","Bearer " + accestoken);
        token.put("Content-Type","application/zip");

        return token;

    }

    public JSONObject clonesequenceID() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_valid_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        String accestoken = validator.getDataFromBody("$.payload.accessToken");

        JSONObject pathParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("Authorization","Bearer " +accestoken);
        header.put("Content-Type","application/json");
        JSONObject body = new JSONObject();
        body.put("title","newtest");
        JSONObject queryParameter = new JSONObject();

        String response1 = builder.updateRequestObject("sequence/create_sequence/create_sequence_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response2 = builder.performRequest(response1);
        ResponseValidator validator1 = new ResponseValidator(response2);

        String sid = validator1.getDataFromBody("$.payload.settings[0].sequenceId");

        JSONObject pathParameter1 = new JSONObject();
        pathParameter1.put("sequenceId",sid);
        JSONObject body1 = new JSONObject();
        JSONObject queryParameter1 = new JSONObject();

        String response3 = builder.updateRequestObject("sequence/clone_sequence/clone_sequence_with_valid_token", pathParameter1, queryParameter1, header, body1);
        JSONObject response4 = builder.performRequest(response3);
        ResponseValidator validator2 = new ResponseValidator(response4);
        String csid = validator1.getDataFromBody("$.payload.id");

        JSONObject clonesequencid = new JSONObject();
        clonesequencid.put("sequenceId", sid);

        return clonesequencid;

    }

    public JSONObject deletesamesequenceID() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_valid_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        String accestoken = validator.getDataFromBody("$.payload.accessToken");

        JSONObject pathParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("Authorization","Bearer " +accestoken);
        header.put("Content-Type","application/json");
        JSONObject body = new JSONObject();
        body.put("title","newtest");
        JSONObject queryParameter = new JSONObject();

        String response1 = builder.updateRequestObject("sequence/create_sequence/create_sequence_with_valid_token", pathParameter, queryParameter, header, body);
        JSONObject response2 = builder.performRequest(response1);
        ResponseValidator validator1 = new ResponseValidator(response2);

        String sid = validator1.getDataFromBody("$.payload.settings[0].sequenceId");

        JSONObject pathParameter1 = new JSONObject();
        pathParameter1.put("sequenceId",sid);
        JSONObject body1 = new JSONObject();
        JSONObject queryParameter1 = new JSONObject();

        String response3 = builder.updateRequestObject("sequence/delete_sequence/delete_sequence_with_valid_token", pathParameter1, queryParameter1, header, body1);
        JSONObject response4 = builder.performRequest(response3);

        JSONObject deletesamesequencid = new JSONObject();
        deletesamesequencid.put("sequenceId", sid);

        return deletesamesequencid;

    }

    public JSONObject createstep() {

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_valid_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        String accestoken = validator.getDataFromBody("$.payload.accessToken");

        JSONObject pathParameter1 = getsequenceID();
        JSONObject header1 = new JSONObject();
        header1.put("Authorization","Bearer " +accestoken);
        header1.put("Content-Type","application/json");
        JSONObject body1 = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response3 = builder.updateRequestObject("sequence/createstep/create_step_with_valid_token", pathParameter1, queryParameter, header1, body1);
        JSONObject response4 = builder.performRequest(response3);
        ResponseValidator validator2 = new ResponseValidator(response4);

        String sid1 = validator2.getDataFromBody("$.payload.sequence.id");
        JSONObject sequencid1 = new JSONObject();
        sequencid1.put("sequenceId", sid1);

        return sequencid1;

    }

    public JSONObject resumedsequencid(){

        RequestBuilder builder = new RequestBuilder();
        JSONObject response = builder.performRequest("login/login_with_valid_credentials");
        ResponseValidator validator = new ResponseValidator(response);
        String accestoken = validator.getDataFromBody("$.payload.accessToken");

        JSONObject pathParameter1 = getsequenceID();
        JSONObject header1 = new JSONObject();
        header1.put("Authorization","Bearer " +accestoken);
        header1.put("Content-Type","application/json");
        JSONObject body1 = new JSONObject();
        JSONObject queryParameter = new JSONObject();

        String response3 = builder.updateRequestObject("sequence/createstep/create_step_with_valid_token", pathParameter1, queryParameter, header1, body1);
        JSONObject response4 = builder.performRequest(response3);
        ResponseValidator validator2 = new ResponseValidator(response4);

        String sid1 = validator2.getDataFromBody("$.payload.sequence.id");
        JSONObject sequencid1 = new JSONObject();
        sequencid1.put("sequenceId", sid1);


        JSONObject pathParameter2 = new JSONObject();
        pathParameter2.put("sequenceId",sequencid1);
        JSONObject header2= new JSONObject();
        header2.put("Authorization","Bearer " +accestoken);
        header2.put("Content-Type","application/json");
        JSONObject body2 = new JSONObject();
        JSONObject queryParameter1 = new JSONObject();

        String response5 = builder.updateRequestObject("sequence/pause_resume/pause_resume_with_valid_token", pathParameter2, queryParameter1, header2, body2);
        JSONObject response6 = builder.performRequest(response5);
        ResponseValidator validator3 = new ResponseValidator(response6);

        String sid2 = validator3.getDataFromBody("$.payload.steps.*.sequenceId");
        JSONObject sequencid2 = new JSONObject();
        sequencid1.put("sequenceId", sid2);

        return sequencid2;

    }


}
