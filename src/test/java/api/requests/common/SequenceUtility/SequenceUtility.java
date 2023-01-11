package api.requests.common.SequenceUtility;

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

public class SequenceUtility extends base {



    public static void main(String[] args) {

        SequenceUtility base = new SequenceUtility();

        Map a = new HashMap();
        a.put("Subscription_State", "");
        a.put("Plan", "");
        a.put("Role", "");
        a.put("SHaccount1", "");

    }

    public String getSequenceId(Recordset recordset) {
        {

            String sequenceid = null;
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
                    JSONObject body1 = new JSONObject();

                    String update_sequence_file = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter, queryParameter, header, body1);
                    JSONObject response = builder.performRequest(update_sequence_file);

                    ResponseValidator validator = new ResponseValidator(response);
                    sequenceid = validator.getDataFromBody("$.payload.sequences[0].id");

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return sequenceid;

        }
    }

    public Integer getSequenceContactHistoryId(Recordset recordset) {
        {

            Integer sequenceContactHistoryId = 0;
            try {

                while (recordset.next()) {
                    RequestBuilder builder = new RequestBuilder();
                    ExcelReader reader = new ExcelReader();
                    SequenceUtility obj = new SequenceUtility();

                    Map params = new HashMap();
                    params.put("Subscription_State", recordset.getField("Subscription_State"));
                    params.put("Plan", recordset.getField("Plan"));
                    params.put("Role", recordset.getField("Role"));
                    params.put("SHaccount1", recordset.getField("SHaccount1"));

                    JSONObject pathParameter = new JSONObject();
                    pathParameter.put("sequenceId",obj.getSequenceId((reader.getRecordsSet("Credential.xlsx","Sheet1",params))));

                    JSONObject queryParameter = new JSONObject();
                    JSONObject header = new JSONObject();
                    header.put("content-type", "application/json");
                    header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1", params  ,"Token"));
                    JSONObject body1 = new JSONObject();

                    String update_sequence_file = builder.updateRequestObject("sequence/get_sequence_contact/get_sequence_contact_with_valid_token", pathParameter, queryParameter, header, body1);
                    JSONObject response = builder.performRequest(update_sequence_file);

                    ResponseValidator validator = new ResponseValidator(response);
                    sequenceContactHistoryId = Integer.valueOf(validator.getDataFromBody("$.payload.contacts[0].sequenceContactHistory[0].id"));


                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return sequenceContactHistoryId;

        }
    }

    public String[] getSequenceIdScheduleId(Recordset recordset) {
        {

            String[] ScheduleIdSequenceId = new String[0];
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
                    header.put("Authorization",reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"),"Sheet1", params ,"Token"));
                    JSONObject body = new JSONObject();

                    String response2 = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter, queryParameter, header, body);
                    JSONObject response3 = builder.performRequest(response2);

                    String response4 = builder.updateRequestObject("schedule/get_schedule/get_schedule_with_valid_token", pathParameter, queryParameter, header, body);
                    JSONObject response5 = builder.performRequest(response4);

                    ResponseValidator validator1 = new ResponseValidator(response3);
                    ResponseValidator validator2 = new ResponseValidator(response5);

                    ScheduleIdSequenceId = new String[]{validator1.getDataFromBody("$.payload.sequences[0].id"), validator2.getDataFromBody("$.payload[0].id")};
                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return ScheduleIdSequenceId;

        }
    }

    public String[] getSequenceIdEmailId(Recordset recordset) {
        {

            String[] SequenceIdEmailId = new String[0];
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

                    String response2 = builder.updateRequestObject("sequence/get_sequence/get_sequence_with_valid_token", pathParameter1, queryParameter1, header1, body1);
                    JSONObject response3 = builder.performRequest(response2);

                    ResponseValidator validator1 = new ResponseValidator(response3);

                    SequenceIdEmailId = new String[]{validator1.getDataFromBody("$.payload.sequences[0].id"), validator1.getDataFromBody("$.payload.sequences[0].emailId")};
                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return SequenceIdEmailId;

        }
    }

}