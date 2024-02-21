package TestCases.APITests.loginTest;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends base {
    @DataProvider(name = "client_id_secret")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("client_id_secret_nevvon.xlsx", 0);
        return data;
    }
    @Test(dataProvider ="client_id_secret")
    public void login_with_valid_credentials(String client_id , String client_secret , String Token) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");

        JSONObject body = new JSONObject();
        body.put("client_secret",client_secret);
        body.put("client_id",client_id);

        System.out.println(body);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("login/login_with_credentials_for_login",pathParameter,queryParameters,header,body,schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.token");
        String expiration = validator.getDataFromBody("$.expiration");

        assertThat(token).isNotBlank();
        assertThat(expiration).isNotBlank();
    }
    @DataProvider(name = "client_id_uppercase")
    public Object[][] client_id_uppercase() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("client_id_secret_nevvon.xlsx", 1);
        return data;
    }
    @Test(dataProvider ="client_id_uppercase")
    public void login_with_valid_client_id_in_upper_case(String client_id , String client_secret) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");

        JSONObject body = new JSONObject();
        body.put("client_id",client_id);
        body.put("client_secret",client_secret);
        System.out.println(body);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("login/login_with_credentials_for_login",pathParameter,queryParameters,header,body,schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.token");
        String expiration = validator.getDataFromBody("$.expiration");

        assertThat(token).isNotBlank();
        assertThat(expiration).isNotBlank();
    }

    @DataProvider(name = "client_secret_uppercase")
    public Object[][] client_secret_uppercase() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("client_id_secret_nevvon.xlsx", 2);
        return data;
    }
    @Test(dataProvider ="client_secret_uppercase")
    public void login_with_valid_client_secret_in_upper_case(String client_id , String client_secret) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");

        JSONObject body = new JSONObject();
        body.put("client_secret",client_secret);
        body.put("client_id",client_id);

        System.out.println(body);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("login/login_with_credentials_for_login",pathParameter,queryParameters,header,body,schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.token");
        String expiration = validator.getDataFromBody("$.expiration");

        assertThat(token).isNotBlank();
        assertThat(expiration).isNotBlank();
    }
    @Test(dataProvider = "client_id_secret")
    public void login_with_blank_clientId(String client_id , String client_secret , String Token) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");

        JSONObject body = new JSONObject();
        body.put("client_secret",client_secret);
        body.put("client_id","");

        System.out.println(body);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("login/login_with_credentials_for_login",pathParameter,queryParameters,header,body,schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(400);

        String message = validator.getDataFromBody("$.message");

        assertThat(message).isNotBlank();
        assertThat(message).isEqualTo("`client_id` and `client_secret` are mandatory");


    }

    @Test(dataProvider = "client_id_secret")
    public void login_with_blank_clientSecret(String client_id , String client_secret , String Token) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");

        JSONObject body = new JSONObject();
        body.put("client_secret","");
        body.put("client_id",client_id);

        System.out.println(body);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("login/login_with_credentials_for_login",pathParameter,queryParameters,header,body,schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(400);

        String message = validator.getDataFromBody("$.message");

        assertThat(message).isNotBlank();
        assertThat(message).isEqualTo("`client_id` and `client_secret` are mandatory");


    }

    @DataProvider(name = "invalid_client_id_secret")
    public Object[][] invalid_data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("client_id_secret_nevvon.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "invalid_client_id_secret")
    public void login_with_wrong_credentials(String client_id , String client_secret) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");

        JSONObject body = new JSONObject();
        body.put("client_secret",client_secret);
        body.put("client_id", client_id);

        System.out.println(body);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("login/login_with_credentials_for_login",pathParameter,queryParameters,header,body,schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);
        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");

        assertThat(message).isNotBlank();
        assertThat(message).isEqualTo("Invalid `client_id` and `client_secret` combination");
    }

    @DataProvider(name = "valid_ci_invalid_cs")
    public Object[][] valid_ci_invalid_cs_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("client_id_secret_nevvon.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "valid_ci_invalid_cs")
    public void login_with_valid_client_id_invalid_client_secret_credentials(String client_id , String client_secret) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");

        JSONObject body = new JSONObject();
        body.put("client_secret",client_secret);
        body.put("client_id", client_id);

        System.out.println(body);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("login/login_with_credentials_for_login",pathParameter,queryParameters,header,body,schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);
        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");

        assertThat(message).isNotBlank();
        assertThat(message).isEqualTo("Invalid `client_id` and `client_secret` combination");
    }

    @DataProvider(name = "invalid_ci_valid_cs")
    public Object[][] invalid_ci_valid_cs_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("client_id_secret_nevvon.xlsx", 5);
        return data;
    }
    @Test(dataProvider = "valid_ci_invalid_cs")
    public void login_with_invalid_client_id_valid_client_secret_credentials(String client_id , String client_secret) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");

        JSONObject body = new JSONObject();
        body.put("client_secret",client_secret);
        body.put("client_id", client_id);

        System.out.println(body);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();

        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("login/login_with_credentials_for_login",pathParameter,queryParameters,header,body,schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);
        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");

        assertThat(message).isNotBlank();
        assertThat(message).isEqualTo("Invalid `client_id` and `client_secret` combination");
    }
}
