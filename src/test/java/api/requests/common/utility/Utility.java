package api.requests.common.utility;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;


public class Utility {

    public String gettoken(String Subscription_State, String Plan, String Role1, String SHaccount1,String SHaccount2, String Ownership, String Role2,String Status_Code,String Schema) {
        {


            Fillo fillo = new Fillo();
            Recordset recordset = null;
            Connection connection = null;
            String token = null;
            String Role = Role1;

            try {
                connection = fillo.getConnection("D:\\new\\v3-automation\\src\\test\\java\\data\\Get_Sequence_Test_case.xlsx");
                String strQuery = "Select * from Credential where Subscription_State='"+Subscription_State+"' and SHaccount1='" + SHaccount1 + "' and Plan='" + Plan + "' and Role='" + Role + "'";

                recordset = connection.executeQuery(strQuery);
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

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            connection.close();
            return token;
        }
    }

    public String getsequenceid(String Subscription_State, String Plan, String Role1, String SHaccount1,String SHaccount2,String Ownership, String Role2,String Status_Code,String Schema) {
        {


            Fillo fillo = new Fillo();
            Recordset recordset = null;
            Connection connection = null;
            String sequenceid = null;
            String Role = Role2;
            try {
                connection = fillo.getConnection("D:\\new\\v3-automation\\src\\test\\java\\data\\Get_Sequence_Test_case.xlsx");
                String strQuery = "Select * from Credential where Subscription_State='"+Subscription_State+"' and SHaccount1='" + SHaccount1 + "'and SHaccount2='" + SHaccount2 + "' and Plan='" + Plan + "' and Role='" + Role + "'";

                recordset = connection.executeQuery(strQuery);
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

                    String token = "Bearer " + validator.getDataFromBody("$.payload.accessToken");

                    JSONObject pathParameter1 = new JSONObject();
                    JSONObject queryParameter1 = new JSONObject();
                    JSONObject header1 = new JSONObject();
                    header1.put("content-type", "application/json");
                    header1.put("Authorization",  token);
                    JSONObject body1 = new JSONObject();


                    String response2 = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter1, queryParameter1, header1, body1);
                    JSONObject response3 = builder.performRequest(response2);

                    ResponseValidator validator1 = new ResponseValidator(response3);
                    sequenceid = validator1.getDataFromBody("$.payload.sequences[0].id");

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            connection.close();
            return sequenceid;
        }
    }
}
