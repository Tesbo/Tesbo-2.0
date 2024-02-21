package TestCases.APITests.CSPanelAPI;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class organizationCourseDetails extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void organizationCourseDetail_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organizationID",organizationId.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("in_class","0");
        queryParameters.put("to_select","1");
        queryParameters.put("only_organization","1");
        queryParameters.put("show_emp_count","1");
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationCourseDetail", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String label = validator.getDataFromBody("$.data[0].label");
        assertThat(label).isNotBlank();

        String value = validator.getDataFromBody("$.data[0].value");
        assertThat(value).isNotBlank();

        String published = validator.getDataFromBody("$.data[0].published");
        assertThat(published).isNotBlank();

        String approved = validator.getDataFromBody("$.data[0].emp_count.approved");
        assertThat(approved).isNotBlank();

        String total = validator.getDataFromBody("$.data[0].emp_count.total");
        assertThat(total).isNotBlank();

        String duration_formatted = validator.getDataFromBody("$.data[0].duration_formatted");
        assertThat(duration_formatted).isNotBlank();

        String modules_count = validator.getDataFromBody("$.data[0].modules_count");
        assertThat(modules_count).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void organizationCourseDetail_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organizationID",organizationId.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("in_class","0");
        queryParameters.put("to_select","1");
        queryParameters.put("only_organization","1");
        queryParameters.put("show_emp_count","1");
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationCourseDetail", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String label = validator.getDataFromBody("$.data[0].label");
        assertThat(label).isNotBlank();

        String value = validator.getDataFromBody("$.data[0].value");
        assertThat(value).isNotBlank();

        String published = validator.getDataFromBody("$.data[0].published");
        assertThat(published).isNotBlank();

        String approved = validator.getDataFromBody("$.data[0].emp_count.approved");
        assertThat(approved).isNotBlank();

        String total = validator.getDataFromBody("$.data[0].emp_count.total");
        assertThat(total).isNotBlank();

        String duration_formatted = validator.getDataFromBody("$.data[0].duration_formatted");
        assertThat(duration_formatted).isNotBlank();

        String modules_count = validator.getDataFromBody("$.data[0].modules_count");
        assertThat(modules_count).isNotBlank();

    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void organizationCourseDetail_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organizationID",organizationId.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("in_class","0");
        queryParameters.put("to_select","1");
        queryParameters.put("only_organization","1");
        queryParameters.put("show_emp_count","1");
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationCourseDetail", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String label = validator.getDataFromBody("$.data[0].label");
        assertThat(label).isNotBlank();

        String value = validator.getDataFromBody("$.data[0].value");
        assertThat(value).isNotBlank();

        String published = validator.getDataFromBody("$.data[0].published");
        assertThat(published).isNotBlank();

        String approved = validator.getDataFromBody("$.data[0].emp_count.approved");
        assertThat(approved).isNotBlank();

        String total = validator.getDataFromBody("$.data[0].emp_count.total");
        assertThat(total).isNotBlank();

        String duration_formatted = validator.getDataFromBody("$.data[0].duration_formatted");
        assertThat(duration_formatted).isNotBlank();

        String modules_count = validator.getDataFromBody("$.data[0].modules_count");
        assertThat(modules_count).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void organizationCourseDetail_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organizationID",organizationId.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("in_class","0");
        queryParameters.put("to_select","1");
        queryParameters.put("only_organization","1");
        queryParameters.put("show_emp_count","1");
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationCourseDetail", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String label = validator.getDataFromBody("$.data[0].label");
        assertThat(label).isNotBlank();

        String value = validator.getDataFromBody("$.data[0].value");
        assertThat(value).isNotBlank();

        String published = validator.getDataFromBody("$.data[0].published");
        assertThat(published).isNotBlank();

        String approved = validator.getDataFromBody("$.data[0].emp_count.approved");
        assertThat(approved).isNotBlank();

        String total = validator.getDataFromBody("$.data[0].emp_count.total");
        assertThat(total).isNotBlank();

        String duration_formatted = validator.getDataFromBody("$.data[0].duration_formatted");
        assertThat(duration_formatted).isNotBlank();

        String modules_count = validator.getDataFromBody("$.data[0].modules_count");
        assertThat(modules_count).isNotBlank();

    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void organizationCourseDetail_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organizationID",organizationId.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("in_class","0");
        queryParameters.put("to_select","1");
        queryParameters.put("only_organization","1");
        queryParameters.put("show_emp_count","1");
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationCourseDetail", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String label = validator.getDataFromBody("$.data[0].label");
        assertThat(label).isNotBlank();

        String value = validator.getDataFromBody("$.data[0].value");
        assertThat(value).isNotBlank();

        String published = validator.getDataFromBody("$.data[0].published");
        assertThat(published).isNotBlank();

        String approved = validator.getDataFromBody("$.data[0].emp_count.approved");
        assertThat(approved).isNotBlank();

        String total = validator.getDataFromBody("$.data[0].emp_count.total");
        assertThat(total).isNotBlank();

        String duration_formatted = validator.getDataFromBody("$.data[0].duration_formatted");
        assertThat(duration_formatted).isNotBlank();

        String modules_count = validator.getDataFromBody("$.data[0].modules_count");
        assertThat(modules_count).isNotBlank();

    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void organizationCourseDetail_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organizationID",organizationId.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("in_class","0");
        queryParameters.put("to_select","1");
        queryParameters.put("only_organization","1");
        queryParameters.put("show_emp_count","1");
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationCourseDetail", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String label = validator.getDataFromBody("$.data[0].label");
        assertThat(label).isNotBlank();

        String value = validator.getDataFromBody("$.data[0].value");
        assertThat(value).isNotBlank();

        String published = validator.getDataFromBody("$.data[0].published");
        assertThat(published).isNotBlank();

        String approved = validator.getDataFromBody("$.data[0].emp_count.approved");
        assertThat(approved).isNotBlank();

        String total = validator.getDataFromBody("$.data[0].emp_count.total");
        assertThat(total).isNotBlank();

        String duration_formatted = validator.getDataFromBody("$.data[0].duration_formatted");
        assertThat(duration_formatted).isNotBlank();

        String modules_count = validator.getDataFromBody("$.data[0].modules_count");
        assertThat(modules_count).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void organizationCourseDetail_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organizationID",organizationId.substring(0,3));
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("in_class","0");
        queryParameters.put("to_select","1");
        queryParameters.put("only_organization","1");
        queryParameters.put("show_emp_count","1");
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationCourseDetail", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String label = validator.getDataFromBody("$.data[0].label");
        assertThat(label).isNotBlank();

        String value = validator.getDataFromBody("$.data[0].value");
        assertThat(value).isNotBlank();

        String published = validator.getDataFromBody("$.data[0].published");
        assertThat(published).isNotBlank();

        String approved = validator.getDataFromBody("$.data[0].emp_count.approved");
        assertThat(approved).isNotBlank();

        String total = validator.getDataFromBody("$.data[0].emp_count.total");
        assertThat(total).isNotBlank();

        String duration_formatted = validator.getDataFromBody("$.data[0].duration_formatted");
        assertThat(duration_formatted).isNotBlank();

        String modules_count = validator.getDataFromBody("$.data[0].modules_count");
        assertThat(modules_count).isNotBlank();

    }

    @Test(dataProvider = "login_email_password_Admin")
    public void organizationCourseDetail_with_wrong_providerId(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("organizationID",organizationId.substring(0,2));
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("in_class","0");
        queryParameters.put("to_select","1");
        queryParameters.put("only_organization","1");
        queryParameters.put("show_emp_count","1");
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationCourseDetail", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Unauthorized Action");

    }

    }