package api.requests.common.ContactUtility;

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

public class ContactUtility extends base {

    public static void main(String[] args) {

        ContactUtility base = new ContactUtility();

        Map a = new HashMap();
        a.put("Subscription_State", "");
        a.put("Plan", "");
        a.put("Role", "");
        a.put("SHaccount1", "");


    }
    public Integer getContactId(Recordset recordset) {
        {

            Integer contactid = 0;
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

                    String update_sequence_file = builder.updateRequestObject("contacts/get_contact/get_contact", pathParameter, queryParameter, header, body1);
                    JSONObject response = builder.performRequest(update_sequence_file);

                    ResponseValidator validator = new ResponseValidator(response);
                    contactid = Integer.valueOf(validator.getDataFromBody("$.payload.contacts[0].id"));

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return contactid;

        }
    }

    public String getStepId(Recordset recordset) {
        {

            String stepId = null;
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

                    String update_sequence_file = builder.updateRequestObject("contacts/get_contact/get_contact", pathParameter, queryParameter, header, body1);
                    JSONObject response = builder.performRequest(update_sequence_file);

                    ResponseValidator validator = new ResponseValidator(response);
                    stepId = validator.getDataFromBody("$.payload.contacts[0].sequenceContactHistory[0].step.id");

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return stepId;

        }
    }

    public String[] getContactStepId(Recordset recordset) {
        {

            String contactStepId[] = new String[2];

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
                    header.put("Authorization", reader.readFromToExcel(new File("src/test/java/data/Credential.xlsx"), "Sheet1", params, "Token"));
                    JSONObject body1 = new JSONObject();

                    String update_file = builder.updateRequestObject("contacts/get_contact/get_contact", pathParameter, queryParameter, header, body1);
                    JSONObject response1 = builder.performRequest(update_file);

                    String update_file1 = builder.updateRequestObject("contacts/get_contact/get_contact", pathParameter, queryParameter, header, body1);
                    JSONObject response2 = builder.performRequest(update_file1);

                    ResponseValidator validator1 = new ResponseValidator(response1);
                    ResponseValidator validator2 = new ResponseValidator(response2);

                    contactStepId = new String[]{validator1.getDataFromBody("$.payload.contacts[0].id"), validator2.getDataFromBody("$.payload.contacts[0].sequenceContactHistory[0].step.id")};

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return contactStepId;

        }
    }

}