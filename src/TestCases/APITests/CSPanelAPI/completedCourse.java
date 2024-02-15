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

public class completedCourse extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void completedCourse_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId);
        queryParameters.put("course_active","1");
        queryParameters.put("provider_status","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/completedCourse", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String total = validator.getDataFromBody("$.total");
        assertThat(total).isNotBlank();

        String completed = validator.getDataFromBody("completed");
        assertThat(completed).isNotBlank();

        String not_completed = validator.getDataFromBody("not_completed");
        assertThat(not_completed).isNotBlank();

        String percent_completed = validator.getDataFromBody("percent_completed");
        assertThat(percent_completed).isNotBlank();

        String percent_not_completed = validator.getDataFromBody("percent_not_completed");
        assertThat(percent_not_completed).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void completedCourse_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId);
        queryParameters.put("course_active","1");
        queryParameters.put("provider_status","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/completedCourse", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String total = validator.getDataFromBody("$.total");
        assertThat(total).isNotBlank();

        String completed = validator.getDataFromBody("completed");
        assertThat(completed).isNotBlank();

        String not_completed = validator.getDataFromBody("not_completed");
        assertThat(not_completed).isNotBlank();

        String percent_completed = validator.getDataFromBody("percent_completed");
        assertThat(percent_completed).isNotBlank();

        String percent_not_completed = validator.getDataFromBody("percent_not_completed");
        assertThat(percent_not_completed).isNotBlank();
    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void completedCourse_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId);
        queryParameters.put("course_active","1");
        queryParameters.put("provider_status","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/completedCourse", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String total = validator.getDataFromBody("$.total");
        assertThat(total).isNotBlank();

        String completed = validator.getDataFromBody("completed");
        assertThat(completed).isNotBlank();

        String not_completed = validator.getDataFromBody("not_completed");
        assertThat(not_completed).isNotBlank();

        String percent_completed = validator.getDataFromBody("percent_completed");
        assertThat(percent_completed).isNotBlank();

        String percent_not_completed = validator.getDataFromBody("percent_not_completed");
        assertThat(percent_not_completed).isNotBlank();
    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void completedCourse_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId);
        queryParameters.put("course_active","1");
        queryParameters.put("provider_status","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/completedCourse", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String total = validator.getDataFromBody("$.total");
        assertThat(total).isNotBlank();

        String completed = validator.getDataFromBody("completed");
        assertThat(completed).isNotBlank();

        String not_completed = validator.getDataFromBody("not_completed");
        assertThat(not_completed).isNotBlank();

        String percent_completed = validator.getDataFromBody("percent_completed");
        assertThat(percent_completed).isNotBlank();

        String percent_not_completed = validator.getDataFromBody("percent_not_completed");
        assertThat(percent_not_completed).isNotBlank();
    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void completedCourse_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId);
        queryParameters.put("course_active","1");
        queryParameters.put("provider_status","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/completedCourse", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String total = validator.getDataFromBody("$.total");
        assertThat(total).isNotBlank();

        String completed = validator.getDataFromBody("completed");
        assertThat(completed).isNotBlank();

        String not_completed = validator.getDataFromBody("not_completed");
        assertThat(not_completed).isNotBlank();

        String percent_completed = validator.getDataFromBody("percent_completed");
        assertThat(percent_completed).isNotBlank();

        String percent_not_completed = validator.getDataFromBody("percent_not_completed");
        assertThat(percent_not_completed).isNotBlank();
    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void completedCourse_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId);
        queryParameters.put("course_active","1");
        queryParameters.put("provider_status","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/completedCourse", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String total = validator.getDataFromBody("$.total");
        assertThat(total).isNotBlank();

        String completed = validator.getDataFromBody("completed");
        assertThat(completed).isNotBlank();

        String not_completed = validator.getDataFromBody("not_completed");
        assertThat(not_completed).isNotBlank();

        String percent_completed = validator.getDataFromBody("percent_completed");
        assertThat(percent_completed).isNotBlank();

        String percent_not_completed = validator.getDataFromBody("percent_not_completed");
        assertThat(percent_not_completed).isNotBlank();
    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void completedCourse_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId);
        queryParameters.put("course_active","1");
        queryParameters.put("provider_status","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/completedCourse", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String total = validator.getDataFromBody("$.total");
        assertThat(total).isNotBlank();

        String completed = validator.getDataFromBody("completed");
        assertThat(completed).isNotBlank();

        String not_completed = validator.getDataFromBody("not_completed");
        assertThat(not_completed).isNotBlank();

        String percent_completed = validator.getDataFromBody("percent_completed");
        assertThat(percent_completed).isNotBlank();

        String percent_not_completed = validator.getDataFromBody("percent_not_completed");
        assertThat(percent_not_completed).isNotBlank();

    }

}