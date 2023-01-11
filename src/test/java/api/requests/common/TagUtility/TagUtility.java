package api.requests.common.TagUtility;

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

public class TagUtility extends base {

    public static void main(String[] args) {

        TagUtility base = new TagUtility();

        Map a = new HashMap();
        a.put("Subscription_State", "");
        a.put("Plan", "");
        a.put("Role", "");
        a.put("SHaccount1", "");


    }
    public Integer getTagId(Recordset recordset) {
        {

            Integer tagId = 0;
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

                    String update_sequence_file = builder.updateRequestObject("tag/get_tag/get_tag", pathParameter, queryParameter, header, body1);
                    JSONObject response = builder.performRequest(update_sequence_file);

                    ResponseValidator validator = new ResponseValidator(response);

                    tagId = Integer.valueOf(validator.getDataFromBody("$.payload[0].id"));

                }


            } catch (FilloException e) {
                throw new RuntimeException(e);
            }
            recordset.close();
            return tagId;

        }
    }
}