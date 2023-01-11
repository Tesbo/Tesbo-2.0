package api.requests.common.AgencyUtility;

import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;

public class AgencyUtility extends base {

    public String getTokenForAgency() {
        RequestBuilder builder = new RequestBuilder();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();
        body.put("email", "testqable905@gmail.com");
        body.put("password", "P@ssword1");

        String response = builder.updateRequestObject("agency/agency_login/agency_login", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response);

        ResponseValidator validator = new ResponseValidator(response1);

        String token = "Bearer " + validator.getDataFromBody("$.payload.accessToken");

        return token;
    }


    public String getAgencyClient(){

        RequestBuilder builder = new RequestBuilder();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameter = new JSONObject();
        queryParameter.put("page",1);
        queryParameter.put("sortByKey","createdAt");
        queryParameter.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization",getTokenForAgency());
        JSONObject body = new JSONObject();

        String response = builder.updateRequestObject("agency/get_agency_client/get_agency_client", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response);

        ResponseValidator validator = new ResponseValidator(response1);
        String clientId = validator.getDataFromBody("$.payload.clients[0].clientId");

        return clientId;


    }

    public String getAgencyUserId(){

        RequestBuilder builder = new RequestBuilder();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameter = new JSONObject();
        queryParameter.put("page",1);
        queryParameter.put("sortByKey","createdAt");
        queryParameter.put("order","-1");
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("Authorization",getTokenForAgency());
        JSONObject body = new JSONObject();

        String response = builder.updateRequestObject("agency/get_agency_user/get_agency_user", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response);

        ResponseValidator validator = new ResponseValidator(response1);
        String agencyUserId = validator.getDataFromBody("$.payload.items[0].id");

        return agencyUserId;


    }

}
