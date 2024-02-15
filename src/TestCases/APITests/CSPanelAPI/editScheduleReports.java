package APITests.CSPanelAPI;

import api.requests.common.GetTokenUtility;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class editScheduleReports extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void editScheduleReports_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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
    public void editScheduleReports_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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
    public void editScheduleReports_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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
    public void editScheduleReports_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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
    public void editScheduleReports_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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
    public void editScheduleReports_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).isNotBlank();

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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
    public void editScheduleReports_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID","420");
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReports", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Unauthorized Action");

    }

    @Test(dataProvider = "login_email_password_Admin")
    public void editScheduleReportsWithFileName_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename","AutomationReports" + random.ints(0,999999).toString());
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReportsWithFileName", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).contains("AutomationReports");

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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

    @Test(dataProvider = "login_email_password_Manager")
    public void editScheduleReportsWithFileName_for_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename","AutomationReports" + random.ints(0,999999).toString());
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReportsWithFileName", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).contains("AutomationReports");

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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

    @Test(dataProvider = "login_email_password_Coordinator")
    public void editScheduleReportsWithFileName_for_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename","AutomationReports" + random.ints(0,999999).toString());
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReportsWithFileName", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).contains("AutomationReports");

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void editScheduleReportsWithFileName_for_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename","AutomationReports" + random.ints(0,999999).toString());
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReportsWithFileName", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).contains("AutomationReports");

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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

    @Test(dataProvider = "login_email_password_RN")
    public void editScheduleReportsWithFileName_for_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename","AutomationReports" + random.ints(0,999999).toString());
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReportsWithFileName", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).contains("AutomationReports");

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void editScheduleReportsWithFileName_for_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        scheduleReports reports =  new scheduleReports();
        String  reportsID = reports.scheduleReports_to_get_report_id(email,password,organizationId,organizationName,organization_provider_ids,course_id);

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));
        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename","AutomationReports" + random.ints(0,999999).toString());
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID",reportsID);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReportsWithFileName", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Scheduled Report modified successfully");

        String scheduled_report_id = validator.getDataFromBody("$.scheduled_report.id");
        assertThat(scheduled_report_id).isEqualTo(reportsID);

        String scheduled_report_organization_id = validator.getDataFromBody("$.scheduled_report.organization_id");
        assertThat(scheduled_report_organization_id).isEqualTo(organizationId.substring(0,3));

        String scheduled_report_filename = validator.getDataFromBody("$.scheduled_report.filename");
        assertThat(scheduled_report_filename).contains("AutomationReports");

        String course_ids = validator.getDataFromBody("$.scheduled_report.params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.scheduled_report.params.completion_type");
        assertThat(completion_type).isEqualTo("course");

        String organization_id = validator.getDataFromBody("$.scheduled_report.params.organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

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

    @Test(dataProvider = "login_email_password_Viewer")
    public void editScheduleReportsWithFileName_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        JSONObject body = new JSONObject();
        body.put("filename","AutomationReports" + random.ints(0,999999).toString());
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("reportID","420");
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/editScheduleReportsWithFileName", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Unauthorized Action");

    }

}