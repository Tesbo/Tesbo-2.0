package api.requests.common.WebTokenUtility;

import api.requests.common.ExcelOperation.ExcelReader;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import io.unity.framework.data.TestData;
import io.unity.framework.init.base;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebTokenUtility extends base {

    public static void main(String[] args) {

        WebTokenUtility base = new WebTokenUtility();

        Map a = new HashMap();
        a.put("Subscription_State", "");
        a.put("Plan", "");
        a.put("Role", "");
        a.put("SHaccount1", "");

    }

    public String getWebToken(Recordset recordset) {
        {

            String Token = null;
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
                    JSONArray emails = new JSONArray();
                    emails.put("qabletest+"+ TestData.random_numeric_string(5)+"@gmail.com");

                    JSONObject body = new JSONObject();
                    body.put("emails",emails);
                    body.put("firstName","test");
                    body.put("lastName","test");

                    String update_file_role1 = builder.updateRequestObject("Team_Member/invite_user/invite_user_with_valid_token", pathParameter, queryParameter, header, body);
                    JSONObject response = builder.performRequest(update_file_role1);
                    ResponseValidator validator = new ResponseValidator(response);





                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return Token;

        }
    }
}
