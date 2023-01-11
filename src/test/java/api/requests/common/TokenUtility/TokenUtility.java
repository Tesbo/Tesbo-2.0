package api.requests.common.TokenUtility;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TokenUtility extends base {

    public static void main(String[] args) {

        TokenUtility base = new TokenUtility();

        Map a = new HashMap();
        a.put("SHaccount1", "");
        a.put("Subscription_State", "");
        a.put("Plan", "");
        a.put("Role", "");

    }

    public String getToken(Recordset recordset) {
        {

            String token = null;
            try {

                while (recordset.next()) {
                    RequestBuilder builder = new RequestBuilder();
                    JSONObject pathParameter = new JSONObject();
                    JSONObject queryParameter = new JSONObject();
                    JSONObject header = new JSONObject();
                    header.put("content-type", "application/json");
                    JSONObject body = new JSONObject();
                    body.put("email", recordset.getField("Username").toString());
                    body.put("password", recordset.getField("Password").toString());

                    String response = builder.updateRequestObject("login/login_with_valid_credentials", pathParameter, queryParameter, header, body);
                    JSONObject response1 = builder.performRequest(response);

                    ResponseValidator validator = new ResponseValidator(response1);

                    token = "Bearer " + validator.getDataFromBody("$.payload.accessToken");



//                    String query = "INSERT INTO Credential (Token) Where Username = "+recordset.getField("Username").toString()+" and Password = "+recordset.getField("Password").toString()+"";
//                    System.out.println(query);
                }
            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return token;
        }
    }

    public String getTokenFromUser() {
        RequestBuilder builder = new RequestBuilder();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();
        body.put("email", "testqable905@gmail.com");
        body.put("password", "QAble@1010");

        String response = builder.updateRequestObject("login/login_with_valid_credentials", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response);

        ResponseValidator validator = new ResponseValidator(response1);

        String token = "Bearer " + validator.getDataFromBody("$.payload.accessToken");

        return token;
        }

    public String getToken1() {
        RequestBuilder builder = new RequestBuilder();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();
        body.put("email", "testqable905+101@gmail.com");
        body.put("password", "QAble@1010");

        String response = builder.updateRequestObject("login/login_with_valid_credentials", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response);

        ResponseValidator validator = new ResponseValidator(response1);

        String token = "Bearer " + validator.getDataFromBody("$.payload.accessToken");

        return token;
    }

    public String getToken2() {
        RequestBuilder builder = new RequestBuilder();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();
        body.put("email", "testqable905+101@gmail.com");
        body.put("password", "QAble@2020");

        String response = builder.updateRequestObject("login/login_with_valid_credentials", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response);

        ResponseValidator validator = new ResponseValidator(response1);

        String token = "Bearer " + validator.getDataFromBody("$.payload.accessToken");

        return token;
    }

    public String getTokenForAuth() {
        RequestBuilder builder = new RequestBuilder();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();
        body.put("email", "testqable905+102@gmail.com");
        body.put("password", "QAble@1010");

        String response = builder.updateRequestObject("login/login_with_valid_credentials", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response);

        ResponseValidator validator = new ResponseValidator(response1);

        String token = "Bearer " + validator.getDataFromBody("$.payload.accessToken");

        return token;
    }
    }
