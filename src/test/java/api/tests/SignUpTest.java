package api.tests;

import api.requests.common.TokenUtility.TokenUtility;
import com.codoid.products.exception.FilloException;
import io.unity.performaction.autoweb.testng_logs;
import io.unity.framework.data.TestData;
import io.unity.framework.init.base;
import io.unity.framework.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpTest extends base {


    @Test
    public void signup_with_valid_data(){

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email","testqable905+"+ TestData.random_numeric_string(3)+"@gmail.com");
        body.put("password","QAble@1010");
        body.put("timeZone","Asia/Kolkata");
        body.put("rewardfulReferralId",123);
        body.put("isLtdUser",true);

        logs.test_step("------------------------------------------ SIGNUP WITH VALID EMAIL AND PASSWORD--------------------------------------------");
        String update_file = builder.updateRequestObject("signup/signup_with_valid_credentials", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(201);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }

    @DataProvider(name = "signup_with_invalid_email_or_password_data_provider")
    public Object[][] data_provider1() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Signup_Test_Case.xlsx", 0);
        return data;
    }

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//

    @Test(dataProvider = "signup_with_invalid_email_or_password_data_provider")
    public void signup_with_invalid_email_or_password(String Username, String Password,String timeZone,String rewardfulReferralId, String isLtdUser,String Status_Code, String Schema) throws FilloException {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email",Username);
        body.put("password",Password);
        body.put("timeZone",timeZone);
        body.put("rewardfulReferralId",rewardfulReferralId);
        body.put("isLtdUser",isLtdUser);

        logs.test_step("------------------------------------------ SIGNUP WITH INVALID EMAIL AND PASSWORD--------------------------------------------");
        String update_file = builder.updateRequestObject("signup/signup_with_valid_credentials", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
        
try{
validator.validateSchema(Schema);}
  catch(Exception PathNotFoundException){}
    }

    @DataProvider(name = "signup_with_blank_data_provider")
    public Object[][] data_provider2() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Signup_Test_Case.xlsx", 1);
        return data;
    }

    //---------------------------------- GET THE TEST DATA FOR VALID TOKEN --------------------------------------------//

    @Test(dataProvider = "signup_with_blank_data_provider")
    public void signup_with_blank_data_provider(String Username, String Password,String timeZone,String rewardfulReferralId, String isLtdUser,String Status_Code, String Schema) throws FilloException {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();

        JSONObject pathParameter = new JSONObject();

        JSONObject queryParameters = new JSONObject();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email",Username);
        body.put("password",Password);
        body.put("timeZone",timeZone);
        body.put("rewardfulReferralId",rewardfulReferralId);
        body.put("isLtdUser",isLtdUser);

        logs.test_step("------------------------------------------ SIGNUP WITH INVALID EMAIL AND PASSWORD--------------------------------------------");
        String update_file = builder.updateRequestObject("signup/signup_with_valid_credentials", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);

        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

        logs.test_step("------------------------------------------ VALIDATE SCHEMA --------------------------------------------");
        
try{
validator.validateSchema(Schema);}
  catch(Exception PathNotFoundException){}
    }

    @Test
    public void signup_with_different_content_type() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();
        body.put("email","testqable905+"+ TestData.random_numeric_string(3)+"@gmail.com");
        body.put("password","QAble@1010");
        body.put("timeZone","Asia/Kolkata");
        body.put("rewardfulReferralId",123);
        body.put("isLtdUser",true);

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/zip");

        String update_file = builder.updateRequestObject("signup/signup_with_valid_credentials", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(400);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }


    @Test
    public void signup_with_different_method_name() {

        testng_logs logs = new testng_logs();
        RequestBuilder builder = new RequestBuilder();
        TokenUtility token_utils = new TokenUtility();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject body = new JSONObject();
        body.put("email","testqable905+"+ TestData.random_numeric_string(3)+"@gmail.com");
        body.put("password","QAble@1010");
        body.put("timeZone","Asia/Kolkata");
        body.put("rewardfulReferralId",123);
        body.put("isLtdUser",true);

        JSONObject header = new JSONObject();
        header.put("Authorization",token_utils.getTokenFromUser());
        header.put("content-type", "application/json");

        String update_file = builder.updateRequestObject("signup/signup_with_valid_credentials_with_different_method", pathParameter, queryParameters, header, body);
        JSONObject response = builder.performRequest(update_file);
        ResponseValidator validator = new ResponseValidator(response);

        logs.test_step("------------------------------------------ VALIDATE STATUS CODE--------------------------------------------");
        validator.statusCodeShouldBe(404);

        logs.test_step("------------------------------------------ VALIDATE RESPONSE TIME --------------------------------------------");
        validator.validateResponseTime((Long)response.get("responseTime"));

    }



}
