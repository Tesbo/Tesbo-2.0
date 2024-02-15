package APITests.CSPanelAPI;

import api.requests.common.GetTokenUtility;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class languagesAvailableForUser extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void languagesAvailableForUser_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("available_for_users","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/languagesAvailableForUser", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.AR[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data.AR[0].name");
        assertThat(name).isNotBlank();

        String code_2 = validator.getDataFromBody("$.data.AR[0].code_2");
        assertThat(code_2).isNotBlank();

        String code_3 = validator.getDataFromBody("$.data.AR[0].code_3");
        assertThat(code_3).isNotBlank();

        String locale_name = validator.getDataFromBody("$.data.AR[0].locale_name");
        assertThat(locale_name).isNotBlank();

        String available_for_users = validator.getDataFromBody("$.data.AR[0].available_for_users");
        assertThat(available_for_users).isNotBlank();

        String available_in_system = validator.getDataFromBody("$.data.AR[0].available_in_system");
        assertThat(available_in_system).isNotBlank();

        String created_at = validator.getDataFromBody("$.data.AR[0].created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data.AR[0].updated_at");
        assertThat(updated_at).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void languagesAvailableForUser_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("available_for_users","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/languagesAvailableForUser", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.AR[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data.AR[0].name");
        assertThat(name).isNotBlank();

        String code_2 = validator.getDataFromBody("$.data.AR[0].code_2");
        assertThat(code_2).isNotBlank();

        String code_3 = validator.getDataFromBody("$.data.AR[0].code_3");
        assertThat(code_3).isNotBlank();

        String locale_name = validator.getDataFromBody("$.data.AR[0].locale_name");
        assertThat(locale_name).isNotBlank();

        String available_for_users = validator.getDataFromBody("$.data.AR[0].available_for_users");
        assertThat(available_for_users).isNotBlank();

        String available_in_system = validator.getDataFromBody("$.data.AR[0].available_in_system");
        assertThat(available_in_system).isNotBlank();

        String created_at = validator.getDataFromBody("$.data.AR[0].created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data.AR[0].updated_at");
        assertThat(updated_at).isNotBlank();

    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void languagesAvailableForUser_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("available_for_users","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/languagesAvailableForUser", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.AR[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data.AR[0].name");
        assertThat(name).isNotBlank();

        String code_2 = validator.getDataFromBody("$.data.AR[0].code_2");
        assertThat(code_2).isNotBlank();

        String code_3 = validator.getDataFromBody("$.data.AR[0].code_3");
        assertThat(code_3).isNotBlank();

        String locale_name = validator.getDataFromBody("$.data.AR[0].locale_name");
        assertThat(locale_name).isNotBlank();

        String available_for_users = validator.getDataFromBody("$.data.AR[0].available_for_users");
        assertThat(available_for_users).isNotBlank();

        String available_in_system = validator.getDataFromBody("$.data.AR[0].available_in_system");
        assertThat(available_in_system).isNotBlank();

        String created_at = validator.getDataFromBody("$.data.AR[0].created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data.AR[0].updated_at");
        assertThat(updated_at).isNotBlank();


    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void languagesAvailableForUser_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("available_for_users","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/languagesAvailableForUser", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.AR[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data.AR[0].name");
        assertThat(name).isNotBlank();

        String code_2 = validator.getDataFromBody("$.data.AR[0].code_2");
        assertThat(code_2).isNotBlank();

        String code_3 = validator.getDataFromBody("$.data.AR[0].code_3");
        assertThat(code_3).isNotBlank();

        String locale_name = validator.getDataFromBody("$.data.AR[0].locale_name");
        assertThat(locale_name).isNotBlank();

        String available_for_users = validator.getDataFromBody("$.data.AR[0].available_for_users");
        assertThat(available_for_users).isNotBlank();

        String available_in_system = validator.getDataFromBody("$.data.AR[0].available_in_system");
        assertThat(available_in_system).isNotBlank();

        String created_at = validator.getDataFromBody("$.data.AR[0].created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data.AR[0].updated_at");
        assertThat(updated_at).isNotBlank();

    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void languagesAvailableForUser_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("available_for_users","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/languagesAvailableForUser", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.AR[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data.AR[0].name");
        assertThat(name).isNotBlank();

        String code_2 = validator.getDataFromBody("$.data.AR[0].code_2");
        assertThat(code_2).isNotBlank();

        String code_3 = validator.getDataFromBody("$.data.AR[0].code_3");
        assertThat(code_3).isNotBlank();

        String locale_name = validator.getDataFromBody("$.data.AR[0].locale_name");
        assertThat(locale_name).isNotBlank();

        String available_for_users = validator.getDataFromBody("$.data.AR[0].available_for_users");
        assertThat(available_for_users).isNotBlank();

        String available_in_system = validator.getDataFromBody("$.data.AR[0].available_in_system");
        assertThat(available_in_system).isNotBlank();

        String created_at = validator.getDataFromBody("$.data.AR[0].created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data.AR[0].updated_at");
        assertThat(updated_at).isNotBlank();
    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void languagesAvailableForUser_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("available_for_users","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/languagesAvailableForUser", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.AR[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data.AR[0].name");
        assertThat(name).isNotBlank();

        String code_2 = validator.getDataFromBody("$.data.AR[0].code_2");
        assertThat(code_2).isNotBlank();

        String code_3 = validator.getDataFromBody("$.data.AR[0].code_3");
        assertThat(code_3).isNotBlank();

        String locale_name = validator.getDataFromBody("$.data.AR[0].locale_name");
        assertThat(locale_name).isNotBlank();

        String available_for_users = validator.getDataFromBody("$.data.AR[0].available_for_users");
        assertThat(available_for_users).isNotBlank();

        String available_in_system = validator.getDataFromBody("$.data.AR[0].available_in_system");
        assertThat(available_in_system).isNotBlank();

        String created_at = validator.getDataFromBody("$.data.AR[0].created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data.AR[0].updated_at");
        assertThat(updated_at).isNotBlank();
    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void languagesAvailableForUser_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("available_for_users","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/languagesAvailableForUser", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.AR[0].id");
        assertThat(id).isNotBlank();

        String name = validator.getDataFromBody("$.data.AR[0].name");
        assertThat(name).isNotBlank();

        String code_2 = validator.getDataFromBody("$.data.AR[0].code_2");
        assertThat(code_2).isNotBlank();

        String code_3 = validator.getDataFromBody("$.data.AR[0].code_3");
        assertThat(code_3).isNotBlank();

        String locale_name = validator.getDataFromBody("$.data.AR[0].locale_name");
        assertThat(locale_name).isNotBlank();

        String available_for_users = validator.getDataFromBody("$.data.AR[0].available_for_users");
        assertThat(available_for_users).isNotBlank();

        String available_in_system = validator.getDataFromBody("$.data.AR[0].available_in_system");
        assertThat(available_in_system).isNotBlank();

        String created_at = validator.getDataFromBody("$.data.AR[0].created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data.AR[0].updated_at");
        assertThat(updated_at).isNotBlank();

    }

}