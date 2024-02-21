package TestCases.APITests.CSPanelAPI;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class providerListCount extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void providerListCount_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("include_expired","1");
        queryParameters.put("per_page","50");
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListCount", pathParameter, queryParameters, header, body, schema);
        JSONObject response = (JSONObject) builder.performRequest1(update_file);
        System.out.println("Test"+ response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

      /*  String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].name");
        assertThat(name).isNotBlank();

        String color = validator.getDataFromBody("$.data[0].color");
        assertThat(color).isNotBlank();

        String is_default = validator.getDataFromBody("$.data[0].is_default");
        assertThat(is_default).isNotBlank();

        String completion_from = validator.getDataFromBody("$.data[0].filters.completion_from");
        assertThat(completion_from).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].filters.provider_status");
        assertThat(provider_status).isNotBlank();

        String user_id = validator.getDataFromBody("$.data[0].user_id");
        assertThat(user_id).isNotBlank();
*/
    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void providerListCount_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("type","employees");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListCount", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].name");
        assertThat(name).isNotBlank();

        String color = validator.getDataFromBody("$.data[0].color");
        assertThat(color).isNotBlank();

        String is_default = validator.getDataFromBody("$.data[0].is_default");
        assertThat(is_default).isNotBlank();

        String completion_from = validator.getDataFromBody("$.data[0].filters.completion_from");
        assertThat(completion_from).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].filters.provider_status");
        assertThat(provider_status).isNotBlank();

        String user_id = validator.getDataFromBody("$.data[0].user_id");
        assertThat(user_id).isNotBlank();
    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void providerListCount_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("type","employees");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListCount", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].name");
        assertThat(name).isNotBlank();

        String color = validator.getDataFromBody("$.data[0].color");
        assertThat(color).isNotBlank();

        String is_default = validator.getDataFromBody("$.data[0].is_default");
        assertThat(is_default).isNotBlank();

        String completion_from = validator.getDataFromBody("$.data[0].filters.completion_from");
        assertThat(completion_from).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].filters.provider_status");
        assertThat(provider_status).isNotBlank();

        String user_id = validator.getDataFromBody("$.data[0].user_id");
        assertThat(user_id).isNotBlank();
    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void providerListCount_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("type","employees");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListCount", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].name");
        assertThat(name).isNotBlank();

        String color = validator.getDataFromBody("$.data[0].color");
        assertThat(color).isNotBlank();

        String is_default = validator.getDataFromBody("$.data[0].is_default");
        assertThat(is_default).isNotBlank();

        String completion_from = validator.getDataFromBody("$.data[0].filters.completion_from");
        assertThat(completion_from).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].filters.provider_status");
        assertThat(provider_status).isNotBlank();

        String user_id = validator.getDataFromBody("$.data[0].user_id");
        assertThat(user_id).isNotBlank();
    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void providerListCount_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("type","employees");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListCount", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].name");
        assertThat(name).isNotBlank();

        String color = validator.getDataFromBody("$.data[0].color");
        assertThat(color).isNotBlank();

        String is_default = validator.getDataFromBody("$.data[0].is_default");
        assertThat(is_default).isNotBlank();

        String completion_from = validator.getDataFromBody("$.data[0].filters.completion_from");
        assertThat(completion_from).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].filters.provider_status");
        assertThat(provider_status).isNotBlank();

        String user_id = validator.getDataFromBody("$.data[0].user_id");
        assertThat(user_id).isNotBlank();
    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void providerListCount_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("type","employees");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListCount", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].name");
        assertThat(name).isNotBlank();

        String color = validator.getDataFromBody("$.data[0].color");
        assertThat(color).isNotBlank();

        String is_default = validator.getDataFromBody("$.data[0].is_default");
        assertThat(is_default).isNotBlank();

        String completion_from = validator.getDataFromBody("$.data[0].filters.completion_from");
        assertThat(completion_from).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].filters.provider_status");
        assertThat(provider_status).isNotBlank();

        String user_id = validator.getDataFromBody("$.data[0].user_id");
        assertThat(user_id).isNotBlank();
    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void providerListCount_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("type","employees");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListCount", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].name");
        assertThat(name).isNotBlank();

        String color = validator.getDataFromBody("$.data[0].color");
        assertThat(color).isNotBlank();

        String is_default = validator.getDataFromBody("$.data[0].is_default");
        assertThat(is_default).isNotBlank();

        String completion_from = validator.getDataFromBody("$.data[0].filters.completion_from");
        assertThat(completion_from).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].filters.provider_status");
        assertThat(provider_status).isNotBlank();

        String user_id = validator.getDataFromBody("$.data[0].user_id");
        assertThat(user_id).isNotBlank();

    }

}