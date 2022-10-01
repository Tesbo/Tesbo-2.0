package api.test;

import api.requests.common.utility.Utility;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.framework.readers.json_file_reader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

public class GetSequenceWithIdTest extends base {


        @DataProvider(name = "get_sequence")
        public Object[][] data_provider() {
                json_file_reader config = new json_file_reader();
                DataReader reader = new DataReader();
                Object[][] data = null;
                data = reader.getExcelDataForDataProvider("Get_Sequence_Test_case.xlsx",0);
                return data;
        }


        @Test(dataProvider = "get_sequence")
        public void get_sequence_with_id(String Subscription_State, String Plan, String Role1, String SHaccount1,String SHaccount2, String Ownership, String Role2,String Status_Code,String Schema){

            RequestBuilder builder = new RequestBuilder();
            Utility utils = new Utility();
            JSONObject pathParameter = new JSONObject();

            //Get the sequence id from role2

            pathParameter.put("sequenceId",utils.getsequenceid(Subscription_State, Plan, Role1, SHaccount1, SHaccount2, Ownership, Role2, Status_Code, Schema));
            JSONObject queryParameter = new JSONObject();

            //Get the token from the role1

            JSONObject header = new JSONObject();
            header.put("Authorization",utils.gettoken(Subscription_State, Plan, Role1,SHaccount1, SHaccount2, Ownership, Role2, Status_Code, Schema));

            JSONObject body = new JSONObject();

            //Call the get sequence with id
            String response = builder.updateRequestObject("sequence/get_sequenceid/get_sequence_with_id", pathParameter, queryParameter, header, body);
            JSONObject response1 = builder.performRequest(response);

            ResponseValidator validator = new ResponseValidator(response1);
            validator.equals(validator.validateSchema(response) ==  Schema);


        }
}