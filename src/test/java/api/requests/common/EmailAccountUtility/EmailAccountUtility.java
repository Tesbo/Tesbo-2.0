package api.requests.common.EmailAccountUtility;

import api.requests.common.ExcelOperation.ExcelReader;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class EmailAccountUtility extends base {
    public static void main(String[] args) {

        api.requests.common.SequenceUtility.SequenceUtility base = new api.requests.common.SequenceUtility.SequenceUtility();

        Map a = new HashMap();
        a.put("Subscription_State", "");
        a.put("Plan", "");
        a.put("Role", "");
        a.put("SHaccount1", "");

    }

    public String getEmailId(Recordset recordset) {
        {

            String emailId = null;
            try {

                while (recordset.next()) {
                    RequestBuilder builder = new RequestBuilder();
                    ExcelReader reader = new ExcelReader();

                    Map params = new HashMap();
                    params.put("Subscription_State", recordset.getField("Subscription_State"));
                    params.put("Plan", recordset.getField("Plan"));
                    params.put("Role", recordset.getField("Role"));
                    params.put("SHaccount1", recordset.getField("SHaccount1"));

                    JSONObject pathParameter = new JSONObject();
                    JSONObject queryParameter = new JSONObject();
                    JSONObject header = new JSONObject();
                    header.put("content-type", "application/json");
                    header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1", params  ,"Token"));
                    JSONObject body = new JSONObject();

                    String update_email_file = builder.updateRequestObject("email_account/get_email_account/get_email_account_with_valid_token", pathParameter, queryParameter, header, body);
                    JSONObject response = builder.performRequest(update_email_file);

                    ResponseValidator validator = new ResponseValidator(response);
                    emailId = validator.getDataFromBody("$.payload[0].id");

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return emailId;

        }
    }

    public String getConnectedEmailId(Recordset recordset) {
        {

            String emailId = null;
            try {

                while (recordset.next()) {
                    RequestBuilder builder = new RequestBuilder();
                    ExcelReader reader = new ExcelReader();

                    Map params = new HashMap();
                    params.put("Subscription_State", recordset.getField("Subscription_State"));
                    params.put("Plan", recordset.getField("Plan"));
                    params.put("Role", recordset.getField("Role"));
                    params.put("SHaccount1", recordset.getField("SHaccount1"));

                    JSONObject pathParameter = new JSONObject();
                    JSONObject queryParameter = new JSONObject();
                    JSONObject header = new JSONObject();
                    header.put("content-type", "application/json");
                    header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1", params  ,"Token"));
                    JSONObject body = new JSONObject();

                    String update_email_file = builder.updateRequestObject("email_account/get_email_account_connected/get_email_account_connected_with_valid_token", pathParameter, queryParameter, header, body);
                    JSONObject response = builder.performRequest(update_email_file);

                    ResponseValidator validator = new ResponseValidator(response);
                    emailId = validator.getDataFromBody("$.payload[0].id");

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return emailId;

        }
    }

    public String getUserEmailId() {
        RequestBuilder builder = new RequestBuilder();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameter = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        JSONObject body = new JSONObject();
        body.put("email", "testqable905+31@gmail.com");
        body.put("password", "QAble@1010");

        String response = builder.updateRequestObject("login/login_with_valid_credentials", pathParameter, queryParameter, header, body);
        JSONObject response1 = builder.performRequest(response);

        ResponseValidator validator = new ResponseValidator(response1);

        JSONObject pathParameter1 = new JSONObject();
        JSONObject queryParameter1 = new JSONObject();
        JSONObject header1 = new JSONObject();
        header1.put("content-type", "application/json");
        header1.put("Authorization", "Bearer " + validator.getDataFromBody("$.payload.accessToken"));
        JSONObject body1 = new JSONObject();

        String response2 = builder.updateRequestObject("email_account/get_email_account/get_email_account_with_valid_token", pathParameter1, queryParameter1, header1, body1);
        JSONObject response3 = builder.performRequest(response2);

        ResponseValidator validator1 = new ResponseValidator(response3);
        String emailId = validator1.getDataFromBody("$.payload[0].id");

        return emailId;
    }

}
