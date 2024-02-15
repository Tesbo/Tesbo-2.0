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

public class scheduleReportsGetAPI extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void scheduleReportsGetAPI_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("per_page","9999");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReportsGetAPI", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String organization_id = validator.getDataFromBody("$.data[0].organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

        String filename = validator.getDataFromBody("$.data[0].filename");
        assertThat(filename).isNotBlank();

        String aggregated = validator.getDataFromBody("$.data[0].params.aggregated");
        assertThat(aggregated).isNotBlank();

        String course_ids = validator.getDataFromBody("$.data[0].params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.data[0].params.completion_type");
        assertThat(completion_type).isNotBlank();

        String enum_schedule_type_id = validator.getDataFromBody("$.data[0].enum_schedule_type_id");
        assertThat(enum_schedule_type_id).isNotBlank();

        String schedule_type_id = validator.getDataFromBody("$.data[0].schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String key = validator.getDataFromBody("$.data[0].schedule_type.key");
        assertThat(key).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].schedule_type.name");
        assertThat(name).isNotBlank();

        String order = validator.getDataFromBody("$.data[0].schedule_type.order");
        assertThat(order).isNotBlank();

        String is_available = validator.getDataFromBody("$.data[0].schedule_type.is_available");
        assertThat(is_available).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data[0].schedule_type.updated_at");
        assertThat(updated_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.data[0].schedule_type.created_at");
        assertThat(created_at).isNotBlank();

        String links = validator.getDataFromBody("$.links");
        assertThat(links).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();

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
    public void scheduleReportsGetAPI_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("per_page","9999");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReportsGetAPI", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String organization_id = validator.getDataFromBody("$.data[0].organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

        String filename = validator.getDataFromBody("$.data[0].filename");
        assertThat(filename).isNotBlank();

        String aggregated = validator.getDataFromBody("$.data[0].params.aggregated");
        assertThat(aggregated).isNotBlank();

        String course_ids = validator.getDataFromBody("$.data[0].params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.data[0].params.completion_type");
        assertThat(completion_type).isNotBlank();

        String enum_schedule_type_id = validator.getDataFromBody("$.data[0].enum_schedule_type_id");
        assertThat(enum_schedule_type_id).isNotBlank();

        String schedule_type_id = validator.getDataFromBody("$.data[0].schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String key = validator.getDataFromBody("$.data[0].schedule_type.key");
        assertThat(key).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].schedule_type.name");
        assertThat(name).isNotBlank();

        String order = validator.getDataFromBody("$.data[0].schedule_type.order");
        assertThat(order).isNotBlank();

        String is_available = validator.getDataFromBody("$.data[0].schedule_type.is_available");
        assertThat(is_available).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data[0].schedule_type.updated_at");
        assertThat(updated_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.data[0].schedule_type.created_at");
        assertThat(created_at).isNotBlank();

        String links = validator.getDataFromBody("$.links");
        assertThat(links).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();

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
    public void scheduleReportsGetAPI_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("per_page","9999");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReportsGetAPI", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String organization_id = validator.getDataFromBody("$.data[0].organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

        String filename = validator.getDataFromBody("$.data[0].filename");
        assertThat(filename).isNotBlank();

        String aggregated = validator.getDataFromBody("$.data[0].params.aggregated");
        assertThat(aggregated).isNotBlank();

        String course_ids = validator.getDataFromBody("$.data[0].params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.data[0].params.completion_type");
        assertThat(completion_type).isNotBlank();

        String enum_schedule_type_id = validator.getDataFromBody("$.data[0].enum_schedule_type_id");
        assertThat(enum_schedule_type_id).isNotBlank();

        String schedule_type_id = validator.getDataFromBody("$.data[0].schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String key = validator.getDataFromBody("$.data[0].schedule_type.key");
        assertThat(key).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].schedule_type.name");
        assertThat(name).isNotBlank();

        String order = validator.getDataFromBody("$.data[0].schedule_type.order");
        assertThat(order).isNotBlank();

        String is_available = validator.getDataFromBody("$.data[0].schedule_type.is_available");
        assertThat(is_available).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data[0].schedule_type.updated_at");
        assertThat(updated_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.data[0].schedule_type.created_at");
        assertThat(created_at).isNotBlank();

        String links = validator.getDataFromBody("$.links");
        assertThat(links).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();

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
    public void scheduleReportsGetAPI_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("per_page","9999");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReportsGetAPI", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String organization_id = validator.getDataFromBody("$.data[0].organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

        String filename = validator.getDataFromBody("$.data[0].filename");
        assertThat(filename).isNotBlank();

        String aggregated = validator.getDataFromBody("$.data[0].params.aggregated");
        assertThat(aggregated).isNotBlank();

        String course_ids = validator.getDataFromBody("$.data[0].params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.data[0].params.completion_type");
        assertThat(completion_type).isNotBlank();

        String enum_schedule_type_id = validator.getDataFromBody("$.data[0].enum_schedule_type_id");
        assertThat(enum_schedule_type_id).isNotBlank();

        String schedule_type_id = validator.getDataFromBody("$.data[0].schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String key = validator.getDataFromBody("$.data[0].schedule_type.key");
        assertThat(key).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].schedule_type.name");
        assertThat(name).isNotBlank();

        String order = validator.getDataFromBody("$.data[0].schedule_type.order");
        assertThat(order).isNotBlank();

        String is_available = validator.getDataFromBody("$.data[0].schedule_type.is_available");
        assertThat(is_available).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data[0].schedule_type.updated_at");
        assertThat(updated_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.data[0].schedule_type.created_at");
        assertThat(created_at).isNotBlank();

        String links = validator.getDataFromBody("$.links");
        assertThat(links).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();

        String total = validator.getDataFromBody("$.meta.total");
        assertThat(total).isNotBlank();

    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void scheduleReportsGetAPI_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("per_page","9999");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReportsGetAPI", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String organization_id = validator.getDataFromBody("$.data[0].organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

        String filename = validator.getDataFromBody("$.data[0].filename");
        assertThat(filename).isNotBlank();

        String aggregated = validator.getDataFromBody("$.data[0].params.aggregated");
        assertThat(aggregated).isNotBlank();

        String course_ids = validator.getDataFromBody("$.data[0].params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.data[0].params.completion_type");
        assertThat(completion_type).isNotBlank();

        String enum_schedule_type_id = validator.getDataFromBody("$.data[0].enum_schedule_type_id");
        assertThat(enum_schedule_type_id).isNotBlank();

        String schedule_type_id = validator.getDataFromBody("$.data[0].schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String key = validator.getDataFromBody("$.data[0].schedule_type.key");
        assertThat(key).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].schedule_type.name");
        assertThat(name).isNotBlank();

        String order = validator.getDataFromBody("$.data[0].schedule_type.order");
        assertThat(order).isNotBlank();

        String is_available = validator.getDataFromBody("$.data[0].schedule_type.is_available");
        assertThat(is_available).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data[0].schedule_type.updated_at");
        assertThat(updated_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.data[0].schedule_type.created_at");
        assertThat(created_at).isNotBlank();

        String links = validator.getDataFromBody("$.links");
        assertThat(links).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();

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
    public void scheduleReportsGetAPI_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("per_page","9999");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReportsGetAPI", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String organization_id = validator.getDataFromBody("$.data[0].organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

        String filename = validator.getDataFromBody("$.data[0].filename");
        assertThat(filename).isNotBlank();

        String aggregated = validator.getDataFromBody("$.data[0].params.aggregated");
        assertThat(aggregated).isNotBlank();

        String course_ids = validator.getDataFromBody("$.data[0].params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.data[0].params.completion_type");
        assertThat(completion_type).isNotBlank();

        String enum_schedule_type_id = validator.getDataFromBody("$.data[0].enum_schedule_type_id");
        assertThat(enum_schedule_type_id).isNotBlank();

        String schedule_type_id = validator.getDataFromBody("$.data[0].schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String key = validator.getDataFromBody("$.data[0].schedule_type.key");
        assertThat(key).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].schedule_type.name");
        assertThat(name).isNotBlank();

        String order = validator.getDataFromBody("$.data[0].schedule_type.order");
        assertThat(order).isNotBlank();

        String is_available = validator.getDataFromBody("$.data[0].schedule_type.is_available");
        assertThat(is_available).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data[0].schedule_type.updated_at");
        assertThat(updated_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.data[0].schedule_type.created_at");
        assertThat(created_at).isNotBlank();

        String links = validator.getDataFromBody("$.links");
        assertThat(links).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();

        String total = validator.getDataFromBody("$.meta.total");
        assertThat(total).isNotBlank();
    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void scheduleReportsGetAPI_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("per_page","9999");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/scheduleReportsGetAPI", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String organization_id = validator.getDataFromBody("$.data[0].organization_id");
        assertThat(organization_id).isEqualTo(organizationId.substring(0,3));

        String filename = validator.getDataFromBody("$.data[0].filename");
        assertThat(filename).isNotBlank();

        String aggregated = validator.getDataFromBody("$.data[0].params.aggregated");
        assertThat(aggregated).isNotBlank();

        String course_ids = validator.getDataFromBody("$.data[0].params.course_ids");
        assertThat(course_ids).isNotBlank();

        String completion_type = validator.getDataFromBody("$.data[0].params.completion_type");
        assertThat(completion_type).isNotBlank();

        String enum_schedule_type_id = validator.getDataFromBody("$.data[0].enum_schedule_type_id");
        assertThat(enum_schedule_type_id).isNotBlank();

        String schedule_type_id = validator.getDataFromBody("$.data[0].schedule_type.id");
        assertThat(schedule_type_id).isNotBlank();

        String key = validator.getDataFromBody("$.data[0].schedule_type.key");
        assertThat(key).isNotBlank();

        String name = validator.getDataFromBody("$.data[0].schedule_type.name");
        assertThat(name).isNotBlank();

        String order = validator.getDataFromBody("$.data[0].schedule_type.order");
        assertThat(order).isNotBlank();

        String is_available = validator.getDataFromBody("$.data[0].schedule_type.is_available");
        assertThat(is_available).isNotBlank();

        String updated_at = validator.getDataFromBody("$.data[0].schedule_type.updated_at");
        assertThat(updated_at).isNotBlank();

        String created_at = validator.getDataFromBody("$.data[0].schedule_type.created_at");
        assertThat(created_at).isNotBlank();

        String links = validator.getDataFromBody("$.links");
        assertThat(links).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String last_page = validator.getDataFromBody("$.meta.last_page");
        assertThat(last_page).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();

        String total = validator.getDataFromBody("$.meta.total");
        assertThat(total).isNotBlank();

    }

}