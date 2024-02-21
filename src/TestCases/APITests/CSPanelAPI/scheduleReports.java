package TestCases.APITests.CSPanelAPI;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class scheduleReports extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void scheduleReports_for_Admin_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename", "reports" + random.ints(0, 999999).toString());
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report created successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isNotBlank();

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0, 3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0, 3));

        String schedule_type_id = validator.getDataFromBody("$.scheduled_report.schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String schedule_type_key = validator.getDataFromBody("$.scheduled_report.schedule_type.key");
        assertThat(schedule_type_key).isNotBlank();

        String schedule_type_name = validator.getDataFromBody("$.scheduled_report.schedule_type.name");
        assertThat(schedule_type_name).isNotBlank();

        String schedule_type_created_at = validator.getDataFromBody("$.scheduled_report.schedule_type.created_at");
        assertThat(schedule_type_created_at).isNotBlank();

        String schedule_type_updated_at = validator.getDataFromBody("$.scheduled_report.schedule_type.updated_at");
        assertThat(schedule_type_updated_at).isNotBlank();

        String schedule_frequency = validator.getDataFromBody("$.scheduled_report.schedule_frequency");
        assertThat(schedule_frequency).isNotBlank();

        String format = validator.getDataFromBody("$.scheduled_report.format");
        assertThat(format).isNotBlank();

        String email_to = validator.getDataFromBody("$.scheduled_report.email_to");
        assertThat(email_to).isNotBlank();

        String user_name = validator.getDataFromBody("$.scheduled_report.user_name");
        assertThat(user_name).isEqualToIgnoringCase(organizationName);

        String started_at = validator.getDataFromBody("$.scheduled_report.started_at");
        assertThat(started_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.scheduled_report.created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.scheduled_report.updated_at");
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
    public void scheduleReports_Manager_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename", "reports" + random.ints(0, 999999).toString());
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report created successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isNotBlank();

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0, 3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0, 3));

        String schedule_type_id = validator.getDataFromBody("$.scheduled_report.schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String schedule_type_key = validator.getDataFromBody("$.scheduled_report.schedule_type.key");
        assertThat(schedule_type_key).isNotBlank();

        String schedule_type_name = validator.getDataFromBody("$.scheduled_report.schedule_type.name");
        assertThat(schedule_type_name).isNotBlank();

        String schedule_type_created_at = validator.getDataFromBody("$.scheduled_report.schedule_type.created_at");
        assertThat(schedule_type_created_at).isNotBlank();

        String schedule_type_updated_at = validator.getDataFromBody("$.scheduled_report.schedule_type.updated_at");
        assertThat(schedule_type_updated_at).isNotBlank();

        String schedule_frequency = validator.getDataFromBody("$.scheduled_report.schedule_frequency");
        assertThat(schedule_frequency).isNotBlank();

        String format = validator.getDataFromBody("$.scheduled_report.format");
        assertThat(format).isNotBlank();

        String email_to = validator.getDataFromBody("$.scheduled_report.email_to");
        assertThat(email_to).isNotBlank();

        String user_name = validator.getDataFromBody("$.scheduled_report.user_name");
        assertThat(user_name).isEqualToIgnoringCase(organizationName);

        String started_at = validator.getDataFromBody("$.scheduled_report.started_at");
        assertThat(started_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.scheduled_report.created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.scheduled_report.updated_at");
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
    public void scheduleReports_Coordinator_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename", "reports" + random.ints(0, 999999).toString());
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report created successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isNotBlank();

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0, 3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0, 3));

        String schedule_type_id = validator.getDataFromBody("$.scheduled_report.schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String schedule_type_key = validator.getDataFromBody("$.scheduled_report.schedule_type.key");
        assertThat(schedule_type_key).isNotBlank();

        String schedule_type_name = validator.getDataFromBody("$.scheduled_report.schedule_type.name");
        assertThat(schedule_type_name).isNotBlank();

        String schedule_type_created_at = validator.getDataFromBody("$.scheduled_report.schedule_type.created_at");
        assertThat(schedule_type_created_at).isNotBlank();

        String schedule_type_updated_at = validator.getDataFromBody("$.scheduled_report.schedule_type.updated_at");
        assertThat(schedule_type_updated_at).isNotBlank();

        String schedule_frequency = validator.getDataFromBody("$.scheduled_report.schedule_frequency");
        assertThat(schedule_frequency).isNotBlank();

        String format = validator.getDataFromBody("$.scheduled_report.format");
        assertThat(format).isNotBlank();

        String email_to = validator.getDataFromBody("$.scheduled_report.email_to");
        assertThat(email_to).isNotBlank();

        String user_name = validator.getDataFromBody("$.scheduled_report.user_name");
        assertThat(user_name).isEqualToIgnoringCase(organizationName);

        String started_at = validator.getDataFromBody("$.scheduled_report.started_at");
        assertThat(started_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.scheduled_report.created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.scheduled_report.updated_at");
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
    public void scheduleReports_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename", "reports" + random.ints(0, 999999).toString());
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report created successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isNotBlank();

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0, 3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0, 3));

        String schedule_type_id = validator.getDataFromBody("$.scheduled_report.schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String schedule_type_key = validator.getDataFromBody("$.scheduled_report.schedule_type.key");
        assertThat(schedule_type_key).isNotBlank();

        String schedule_type_name = validator.getDataFromBody("$.scheduled_report.schedule_type.name");
        assertThat(schedule_type_name).isNotBlank();

        String schedule_type_created_at = validator.getDataFromBody("$.scheduled_report.schedule_type.created_at");
        assertThat(schedule_type_created_at).isNotBlank();

        String schedule_type_updated_at = validator.getDataFromBody("$.scheduled_report.schedule_type.updated_at");
        assertThat(schedule_type_updated_at).isNotBlank();

        String schedule_frequency = validator.getDataFromBody("$.scheduled_report.schedule_frequency");
        assertThat(schedule_frequency).isNotBlank();

        String format = validator.getDataFromBody("$.scheduled_report.format");
        assertThat(format).isNotBlank();

        String email_to = validator.getDataFromBody("$.scheduled_report.email_to");
        assertThat(email_to).isNotBlank();

        String user_name = validator.getDataFromBody("$.scheduled_report.user_name");
        assertThat(user_name).isEqualToIgnoringCase(organizationName);

        String started_at = validator.getDataFromBody("$.scheduled_report.started_at");
        assertThat(started_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.scheduled_report.created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.scheduled_report.updated_at");
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
    public void scheduleReports_RN_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename", "reports" + random.ints(0, 999999).toString());
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report created successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isNotBlank();

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0, 3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0, 3));

        String schedule_type_id = validator.getDataFromBody("$.scheduled_report.schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String schedule_type_key = validator.getDataFromBody("$.scheduled_report.schedule_type.key");
        assertThat(schedule_type_key).isNotBlank();

        String schedule_type_name = validator.getDataFromBody("$.scheduled_report.schedule_type.name");
        assertThat(schedule_type_name).isNotBlank();

        String schedule_type_created_at = validator.getDataFromBody("$.scheduled_report.schedule_type.created_at");
        assertThat(schedule_type_created_at).isNotBlank();

        String schedule_type_updated_at = validator.getDataFromBody("$.scheduled_report.schedule_type.updated_at");
        assertThat(schedule_type_updated_at).isNotBlank();

        String schedule_frequency = validator.getDataFromBody("$.scheduled_report.schedule_frequency");
        assertThat(schedule_frequency).isNotBlank();

        String format = validator.getDataFromBody("$.scheduled_report.format");
        assertThat(format).isNotBlank();

        String email_to = validator.getDataFromBody("$.scheduled_report.email_to");
        assertThat(email_to).isNotBlank();

        String user_name = validator.getDataFromBody("$.scheduled_report.user_name");
        assertThat(user_name).isEqualToIgnoringCase(organizationName);

        String started_at = validator.getDataFromBody("$.scheduled_report.started_at");
        assertThat(started_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.scheduled_report.created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.scheduled_report.updated_at");
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
    public void scheduleReports_RN_Limited_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename", "reports" + random.ints(0, 999999).toString());
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report created successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isNotBlank();

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0, 3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0, 3));

        String schedule_type_id = validator.getDataFromBody("$.scheduled_report.schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String schedule_type_key = validator.getDataFromBody("$.scheduled_report.schedule_type.key");
        assertThat(schedule_type_key).isNotBlank();

        String schedule_type_name = validator.getDataFromBody("$.scheduled_report.schedule_type.name");
        assertThat(schedule_type_name).isNotBlank();

        String schedule_type_created_at = validator.getDataFromBody("$.scheduled_report.schedule_type.created_at");
        assertThat(schedule_type_created_at).isNotBlank();

        String schedule_type_updated_at = validator.getDataFromBody("$.scheduled_report.schedule_type.updated_at");
        assertThat(schedule_type_updated_at).isNotBlank();

        String schedule_frequency = validator.getDataFromBody("$.scheduled_report.schedule_frequency");
        assertThat(schedule_frequency).isNotBlank();

        String format = validator.getDataFromBody("$.scheduled_report.format");
        assertThat(format).isNotBlank();

        String email_to = validator.getDataFromBody("$.scheduled_report.email_to");
        assertThat(email_to).isNotBlank();

        String user_name = validator.getDataFromBody("$.scheduled_report.user_name");
        assertThat(user_name).isEqualToIgnoringCase(organizationName);

        String started_at = validator.getDataFromBody("$.scheduled_report.started_at");
        assertThat(started_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.scheduled_report.created_at");
        assertThat(created_at).isNotBlank();

        String updated_at = validator.getDataFromBody("$.scheduled_report.updated_at");
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
    public void scheduleReports_Viewer_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename", "reports" + random.ints(0, 999999).toString());
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Unauthorized Action");
    }

    @Test(dataProvider = "login_email_password_Admin")
    public void scheduleReports_with_duplicate_fileName_for_Admin_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        JSONObject body = new JSONObject();
        body.put("filename", "reports");
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(409);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Report name is already in use");
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void scheduleReports_with_duplicate_fileName_for_Manager_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        JSONObject body = new JSONObject();
        body.put("filename", "reports");
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(409);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Report name is already in use");
    }


    @Test(dataProvider = "login_email_password_Coordinator")
    public void scheduleReports_with_duplicate_fileName_for_Coordinator_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        JSONObject body = new JSONObject();
        body.put("filename", "reports");
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(409);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Report name is already in use");
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void scheduleReports_with_duplicate_fileName_for_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        JSONObject body = new JSONObject();
        body.put("filename", "reports");
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(409);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Report name is already in use");
    }

    @Test(dataProvider = "login_email_password_RN")
    public void scheduleReports_with_duplicate_fileName_for_RN_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        JSONObject body = new JSONObject();
        body.put("filename", "reports");
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(409);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Report name is already in use");
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void scheduleReports_with_duplicate_fileName_for_RN_Limited_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        JSONObject body = new JSONObject();
        body.put("filename", "reports");
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(409);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Report name is already in use");
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void scheduleReports_with_duplicate_fileName_for_Viewer_User(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        JSONObject body = new JSONObject();
        body.put("filename", "reports");
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Unauthorized Action");
    }



    public String scheduleReports_to_get_report_id(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Map<String, Object> nestedJson = new HashMap<>();
        nestedJson.put("completion_type", "course");
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename", "autoReport" + random.ints(0, 9999999).toString());
        body.put("params", nestedJson);
        body.put("started_at", "2023-02-06");
        body.put("enum_schedule_type_id", "1");
        body.put("schedule_frequency", "1");
        body.put("email_to", "viral@nevvon.com");
        body.put("is_active", "1");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report created successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isNotBlank();

        return scheduled_report_id;

    }
}