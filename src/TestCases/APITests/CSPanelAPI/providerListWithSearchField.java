package TestCases.APITests.CSPanelAPI;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class providerListWithSearchField extends base {

    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void providerListWithSearchField_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("search","Test");
        queryParameters.put("include_expired","1");
        queryParameters.put("per_page","50");
        queryParameters.put("organization_id",organizationId);
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListWithSearchField", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String country_code = validator.getDataFromBody("$.data[0].country_code");
        assertThat(country_code).isNotBlank();

        String phone = validator.getDataFromBody("$.data[0].phone");
        assertThat(phone).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data[0].sign_up");
        assertThat(sign_up).isNotBlank();

        String organization_provider_id = validator.getDataFromBody("$.data[0].organization_provider_id");
        assertThat(organization_provider_id).isNotBlank();

        String first_name = validator.getDataFromBody("$.data[0].first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data[0].last_name");
        assertThat(last_name).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        

        String no_active_programs = validator.getDataFromBody("$.data[0].no_active_programs");
        assertThat(no_active_programs).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data[0].is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data[0].provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].provider_status");
        assertThat(provider_status).isNotBlank();

        String is_due_soon = validator.getDataFromBody("$.data[0].is_due_soon");
        assertThat(is_due_soon).isNotBlank();

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();


    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void providerListWithSearchField_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
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
        queryParameters.put("organization_id",organizationId);
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListWithSearchField", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String country_code = validator.getDataFromBody("$.data[0].country_code");
        assertThat(country_code).isNotBlank();

        String phone = validator.getDataFromBody("$.data[0].phone");
        assertThat(phone).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data[0].sign_up");
        assertThat(sign_up).isNotBlank();

        

        String organization_provider_id = validator.getDataFromBody("$.data[0].organization_provider_id");
        assertThat(organization_provider_id).isNotBlank();

        String first_name = validator.getDataFromBody("$.data[0].first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data[0].last_name");
        assertThat(last_name).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        

        String no_active_programs = validator.getDataFromBody("$.data[0].no_active_programs");
        assertThat(no_active_programs).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data[0].is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data[0].provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].provider_status");
        assertThat(provider_status).isNotBlank();

        String is_due_soon = validator.getDataFromBody("$.data[0].is_due_soon");
        assertThat(is_due_soon).isNotBlank();

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();


    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void providerListWithSearchField_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
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
        queryParameters.put("organization_id",organizationId);
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListWithSearchField", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String country_code = validator.getDataFromBody("$.data[0].country_code");
        assertThat(country_code).isNotBlank();

        String phone = validator.getDataFromBody("$.data[0].phone");
        assertThat(phone).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data[0].sign_up");
        assertThat(sign_up).isNotBlank();

        String organization_provider_id = validator.getDataFromBody("$.data[0].organization_provider_id");
        assertThat(organization_provider_id).isNotBlank();

        String first_name = validator.getDataFromBody("$.data[0].first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data[0].last_name");
        assertThat(last_name).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String no_active_programs = validator.getDataFromBody("$.data[0].no_active_programs");
        assertThat(no_active_programs).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data[0].is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data[0].provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].provider_status");
        assertThat(provider_status).isNotBlank();

        String is_due_soon = validator.getDataFromBody("$.data[0].is_due_soon");
        assertThat(is_due_soon).isNotBlank();

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();


    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void providerListWithSearchField_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

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
        queryParameters.put("organization_id",organizationId);
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListWithSearchField", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String country_code = validator.getDataFromBody("$.data[0].country_code");
        assertThat(country_code).isNotBlank();

        String phone = validator.getDataFromBody("$.data[0].phone");
        assertThat(phone).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data[0].sign_up");
        assertThat(sign_up).isNotBlank();

        

        String organization_provider_id = validator.getDataFromBody("$.data[0].organization_provider_id");
        assertThat(organization_provider_id).isNotBlank();

        String first_name = validator.getDataFromBody("$.data[0].first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data[0].last_name");
        assertThat(last_name).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String no_active_programs = validator.getDataFromBody("$.data[0].no_active_programs");
        assertThat(no_active_programs).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data[0].is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data[0].provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].provider_status");
        assertThat(provider_status).isNotBlank();

        String is_due_soon = validator.getDataFromBody("$.data[0].is_due_soon");
        assertThat(is_due_soon).isNotBlank();

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();


    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void providerListWithSearchField_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

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
        queryParameters.put("organization_id",organizationId);
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListWithSearchField", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String country_code = validator.getDataFromBody("$.data[0].country_code");
        assertThat(country_code).isNotBlank();

        String phone = validator.getDataFromBody("$.data[0].phone");
        assertThat(phone).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data[0].sign_up");
        assertThat(sign_up).isNotBlank();

        

        String organization_provider_id = validator.getDataFromBody("$.data[0].organization_provider_id");
        assertThat(organization_provider_id).isNotBlank();

        String first_name = validator.getDataFromBody("$.data[0].first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data[0].last_name");
        assertThat(last_name).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String no_active_programs = validator.getDataFromBody("$.data[0].no_active_programs");
        assertThat(no_active_programs).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data[0].is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data[0].provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].provider_status");
        assertThat(provider_status).isNotBlank();

        String is_due_soon = validator.getDataFromBody("$.data[0].is_due_soon");
        assertThat(is_due_soon).isNotBlank();

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();


    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void providerListWithSearchField_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

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
        queryParameters.put("organization_id",organizationId);
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListWithSearchField", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String country_code = validator.getDataFromBody("$.data[0].country_code");
        assertThat(country_code).isNotBlank();

        String phone = validator.getDataFromBody("$.data[0].phone");
        assertThat(phone).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data[0].sign_up");
        assertThat(sign_up).isNotBlank();

        String organization_provider_id = validator.getDataFromBody("$.data[0].organization_provider_id");
        assertThat(organization_provider_id).isNotBlank();

        String first_name = validator.getDataFromBody("$.data[0].first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data[0].last_name");
        assertThat(last_name).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        

        String no_active_programs = validator.getDataFromBody("$.data[0].no_active_programs");
        assertThat(no_active_programs).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data[0].is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data[0].provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].provider_status");
        assertThat(provider_status).isNotBlank();

        String is_due_soon = validator.getDataFromBody("$.data[0].is_due_soon");
        assertThat(is_due_soon).isNotBlank();

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();


    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void providerListWithSearchField_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

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
        queryParameters.put("organization_id",organizationId);
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/providerListWithSearchField", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data[0].id");
        assertThat(id).isNotBlank();

        String country_code = validator.getDataFromBody("$.data[0].country_code");
        assertThat(country_code).isNotBlank();

        String phone = validator.getDataFromBody("$.data[0].phone");
        assertThat(phone).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data[0].sign_up");
        assertThat(sign_up).isNotBlank();

        String organization_provider_id = validator.getDataFromBody("$.data[0].organization_provider_id");
        assertThat(organization_provider_id).isNotBlank();

        String first_name = validator.getDataFromBody("$.data[0].first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data[0].last_name");
        assertThat(last_name).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        

        String no_active_programs = validator.getDataFromBody("$.data[0].no_active_programs");
        assertThat(no_active_programs).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data[0].is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data[0].provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data[0].provider_status");
        assertThat(provider_status).isNotBlank();

        String is_due_soon = validator.getDataFromBody("$.data[0].is_due_soon");
        assertThat(is_due_soon).isNotBlank();

        String first = validator.getDataFromBody("$.links.first");
        assertThat(first).isNotBlank();

        String current_page = validator.getDataFromBody("$.meta.current_page");
        assertThat(current_page).isNotBlank();

        String from = validator.getDataFromBody("$.meta.from");
        assertThat(from).isNotBlank();

        String path = validator.getDataFromBody("$.meta.path");
        assertThat(path).isNotBlank();

        String per_page = validator.getDataFromBody("$.meta.per_page");
        assertThat(per_page).isNotBlank();

        String to = validator.getDataFromBody("$.meta.to");
        assertThat(to).isNotBlank();



    }

}