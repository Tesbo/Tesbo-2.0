package TestCases.APITests.CSPanelAPI;


import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class courseSession extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void courseSession_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organization_id",organizationId.substring(0,3));
        pathParameter.put("courseID",course_id.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/courseSession", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String last = validator.getDataFromBody("$.links.last");
        assertThat(last).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String total = validator.getDataFromBody("$.meta.total");
        assertThat(total).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void courseSession_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organization_id",organizationId.substring(0,3));
        pathParameter.put("courseID",course_id.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/courseSession", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String last = validator.getDataFromBody("$.links.last");
        assertThat(last).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String total = validator.getDataFromBody("$.meta.total");
        assertThat(total).isNotBlank();

    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void courseSession_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organization_id",organizationId.substring(0,3));
        pathParameter.put("courseID",course_id.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/courseSession", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String last = validator.getDataFromBody("$.links.last");
        assertThat(last).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String total = validator.getDataFromBody("$.meta.total");
        assertThat(total).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void courseSession_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organization_id",organizationId.substring(0,3));
        pathParameter.put("courseID",course_id.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/courseSession", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void courseSession_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organization_id",organizationId.substring(0,3));
        pathParameter.put("courseID",course_id.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/courseSession", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String last = validator.getDataFromBody("$.links.last");
        assertThat(last).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String total = validator.getDataFromBody("$.meta.total");
        assertThat(total).isNotBlank();

    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void courseSession_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organization_id",organizationId.substring(0,3));
        pathParameter.put("courseID",course_id.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/courseSession", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void courseSession_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organization_id",organizationId.substring(0,3));
        pathParameter.put("courseID",course_id.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/courseSession", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String last = validator.getDataFromBody("$.links.last");
        assertThat(last).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String total = validator.getDataFromBody("$.meta.total");
        assertThat(total).isNotBlank();


    }

}