package api.requests.common.ScheduleUtility;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ScheduleUtility extends base {

    public static void main(String[] args) {

        ScheduleUtility base = new ScheduleUtility();

        Map a = new HashMap();
        a.put("Subscription_State", "");
        a.put("Plan", "");
        a.put("Role", "");
        a.put("SHaccount1", "");

    }

    public String getScheduleId(Recordset recordset) {
        {

            String scheduleid = null;
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

                    JSONObject pathParameter1 = new JSONObject();
                    JSONObject queryParameter1 = new JSONObject();
                    JSONObject header1 = new JSONObject();
                    header1.put("content-type", "application/json");
                    header1.put("Authorization", "Bearer " + validator.getDataFromBody("$.payload.accessToken"));
                    JSONObject body1 = new JSONObject();

                    String response2 = builder.updateRequestObject("schedule/get_schedule/get_schedule_with_valid_token", pathParameter1, queryParameter1, header1, body1);
                    JSONObject response3 = builder.performRequest(response2);

                    ResponseValidator validator1 = new ResponseValidator(response3);
                    scheduleid = validator1.getDataFromBody("$.payload[0].id");

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return scheduleid;

        }
    }

}