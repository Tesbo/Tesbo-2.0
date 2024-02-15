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

public class organizationDetails extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void organizationDetails_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        providerList providerList = new providerList();
        String providerID= providerList.providerList_for_Admin_User_To_Get_Provider_Id(email, password, organizationId, organizationName, organization_provider_ids,course_id);
        body.put("providerID",providerID);
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationDetails", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.id");
        assertThat(id).isNotBlank();

        String uuid = validator.getDataFromBody("$.data.uuid");
        assertThat(uuid).isNotBlank();

        String organizationid = validator.getDataFromBody("$.data.organization.id");
        assertThat(organizationid).isEqualTo(organizationId.substring(0,3));

        String name = validator.getDataFromBody("$.data.organization.name");
        assertThat(name).isEqualTo(organizationName);

        String first_name = validator.getDataFromBody("$.data.first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data.last_name");
        assertThat(last_name).isNotBlank();

        String phone = validator.getDataFromBody("$.data.phone");
        assertThat(phone).isNotBlank();

        String country_code = validator.getDataFromBody("$.data.country_code");
        assertThat(country_code).isNotBlank();

        String coursesid = validator.getDataFromBody("$.data.courses[0].id");
        assertThat(coursesid).isNotBlank();

        String provider_id = validator.getDataFromBody("$.data.courses[0].provider_id");
        assertThat(provider_id).isNotBlank();

        String courseName = validator.getDataFromBody("$.data.courses[0].name");
        assertThat(courseName).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data.courses[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String is_active = validator.getDataFromBody("$.data.is_active");
        assertThat(is_active).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data.is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data.provider_status");
        assertThat(provider_status).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data.provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data.sign_up");
        assertThat(sign_up).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void organizationDetails_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        providerList providerList = new providerList();
        String providerID= providerList.providerList_for_Admin_User_To_Get_Provider_Id(email, password, organizationId, organizationName, organization_provider_ids,course_id);
        body.put("providerID",providerID);
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationDetails", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.id");
        assertThat(id).isNotBlank();

        String uuid = validator.getDataFromBody("$.data.uuid");
        assertThat(uuid).isNotBlank();

        String organizationid = validator.getDataFromBody("$.data.organization.id");
        assertThat(organizationid).isEqualTo(organizationId.substring(0,3));

        String name = validator.getDataFromBody("$.data.organization.name");
        assertThat(name).isEqualTo(organizationName);

        String first_name = validator.getDataFromBody("$.data.first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data.last_name");
        assertThat(last_name).isNotBlank();

        String phone = validator.getDataFromBody("$.data.phone");
        assertThat(phone).isNotBlank();

        String country_code = validator.getDataFromBody("$.data.country_code");
        assertThat(country_code).isNotBlank();

        String coursesid = validator.getDataFromBody("$.data.courses[0].id");
        assertThat(coursesid).isNotBlank();

        String provider_id = validator.getDataFromBody("$.data.courses[0].provider_id");
        assertThat(provider_id).isNotBlank();

        String courseName = validator.getDataFromBody("$.data.courses[0].name");
        assertThat(courseName).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data.courses[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String is_active = validator.getDataFromBody("$.data.is_active");
        assertThat(is_active).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data.is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data.provider_status");
        assertThat(provider_status).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data.provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data.sign_up");
        assertThat(sign_up).isNotBlank();


    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void organizationDetails_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        providerList providerList = new providerList();
        String providerID= providerList.providerList_for_Admin_User_To_Get_Provider_Id(email, password, organizationId, organizationName, organization_provider_ids,course_id);
        body.put("providerID",providerID);
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationDetails", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.id");
        assertThat(id).isNotBlank();

        String uuid = validator.getDataFromBody("$.data.uuid");
        assertThat(uuid).isNotBlank();

        String organizationid = validator.getDataFromBody("$.data.organization.id");
        assertThat(organizationid).isEqualTo(organizationId.substring(0,3));

        String name = validator.getDataFromBody("$.data.organization.name");
        assertThat(name).isEqualTo(organizationName);

        String first_name = validator.getDataFromBody("$.data.first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data.last_name");
        assertThat(last_name).isNotBlank();

        String phone = validator.getDataFromBody("$.data.phone");
        assertThat(phone).isNotBlank();

        String country_code = validator.getDataFromBody("$.data.country_code");
        assertThat(country_code).isNotBlank();

        String coursesid = validator.getDataFromBody("$.data.courses[0].id");
        assertThat(coursesid).isNotBlank();

        String provider_id = validator.getDataFromBody("$.data.courses[0].provider_id");
        assertThat(provider_id).isNotBlank();

        String courseName = validator.getDataFromBody("$.data.courses[0].name");
        assertThat(courseName).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data.courses[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String is_active = validator.getDataFromBody("$.data.is_active");
        assertThat(is_active).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data.is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data.provider_status");
        assertThat(provider_status).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data.provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data.sign_up");
        assertThat(sign_up).isNotBlank();



    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void organizationDetails_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        providerList providerList = new providerList();
        String providerID= providerList.providerList_for_Admin_User_To_Get_Provider_Id(email, password, organizationId, organizationName, organization_provider_ids,course_id);
        body.put("providerID",providerID);
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationDetails", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.id");
        assertThat(id).isNotBlank();

        String uuid = validator.getDataFromBody("$.data.uuid");
        assertThat(uuid).isNotBlank();

        String organizationid = validator.getDataFromBody("$.data.organization.id");
        assertThat(organizationid).isEqualTo(organizationId.substring(0,3));

        String name = validator.getDataFromBody("$.data.organization.name");
        assertThat(name).isEqualTo(organizationName);

        String first_name = validator.getDataFromBody("$.data.first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data.last_name");
        assertThat(last_name).isNotBlank();

        String phone = validator.getDataFromBody("$.data.phone");
        assertThat(phone).isNotBlank();

        String country_code = validator.getDataFromBody("$.data.country_code");
        assertThat(country_code).isNotBlank();

        String coursesid = validator.getDataFromBody("$.data.courses[0].id");
        assertThat(coursesid).isNotBlank();

        String provider_id = validator.getDataFromBody("$.data.courses[0].provider_id");
        assertThat(provider_id).isNotBlank();

        String courseName = validator.getDataFromBody("$.data.courses[0].name");
        assertThat(courseName).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data.courses[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String is_active = validator.getDataFromBody("$.data.is_active");
        assertThat(is_active).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data.is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data.provider_status");
        assertThat(provider_status).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data.provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data.sign_up");
        assertThat(sign_up).isNotBlank();


    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void organizationDetails_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        providerList providerList = new providerList();
        String providerID= providerList.providerList_for_Admin_User_To_Get_Provider_Id(email, password, organizationId, organizationName, organization_provider_ids,course_id);
        body.put("providerID",providerID);
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationDetails", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.id");
        assertThat(id).isNotBlank();

        String uuid = validator.getDataFromBody("$.data.uuid");
        assertThat(uuid).isNotBlank();

        String organizationid = validator.getDataFromBody("$.data.organization.id");
        assertThat(organizationid).isEqualTo(organizationId.substring(0,3));

        String name = validator.getDataFromBody("$.data.organization.name");
        assertThat(name).isEqualTo(organizationName);

        String first_name = validator.getDataFromBody("$.data.first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data.last_name");
        assertThat(last_name).isNotBlank();

        String phone = validator.getDataFromBody("$.data.phone");
        assertThat(phone).isNotBlank();

        String country_code = validator.getDataFromBody("$.data.country_code");
        assertThat(country_code).isNotBlank();

        String coursesid = validator.getDataFromBody("$.data.courses[0].id");
        assertThat(coursesid).isNotBlank();

        String provider_id = validator.getDataFromBody("$.data.courses[0].provider_id");
        assertThat(provider_id).isNotBlank();

        String courseName = validator.getDataFromBody("$.data.courses[0].name");
        assertThat(courseName).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data.courses[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String is_active = validator.getDataFromBody("$.data.is_active");
        assertThat(is_active).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data.is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data.provider_status");
        assertThat(provider_status).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data.provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data.sign_up");
        assertThat(sign_up).isNotBlank();

    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void organizationDetails_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        providerList providerList = new providerList();
        String providerID= providerList.providerList_for_Admin_User_To_Get_Provider_Id(email, password, organizationId, organizationName, organization_provider_ids,course_id);
        body.put("providerID",providerID);
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationDetails", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.id");
        assertThat(id).isNotBlank();

        String uuid = validator.getDataFromBody("$.data.uuid");
        assertThat(uuid).isNotBlank();

        String organizationid = validator.getDataFromBody("$.data.organization.id");
        assertThat(organizationid).isEqualTo(organizationId.substring(0,3));

        String name = validator.getDataFromBody("$.data.organization.name");
        assertThat(name).isEqualTo(organizationName);

        String first_name = validator.getDataFromBody("$.data.first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data.last_name");
        assertThat(last_name).isNotBlank();

        String phone = validator.getDataFromBody("$.data.phone");
        assertThat(phone).isNotBlank();

        String country_code = validator.getDataFromBody("$.data.country_code");
        assertThat(country_code).isNotBlank();

        String coursesid = validator.getDataFromBody("$.data.courses[0].id");
        assertThat(coursesid).isNotBlank();

        String provider_id = validator.getDataFromBody("$.data.courses[0].provider_id");
        assertThat(provider_id).isNotBlank();

        String courseName = validator.getDataFromBody("$.data.courses[0].name");
        assertThat(courseName).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data.courses[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String is_active = validator.getDataFromBody("$.data.is_active");
        assertThat(is_active).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data.is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data.provider_status");
        assertThat(provider_status).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data.provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data.sign_up");
        assertThat(sign_up).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void organizationDetails_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        providerList providerList = new providerList();
        String providerID= providerList.providerList_for_Admin_User_To_Get_Provider_Id(email, password, organizationId, organizationName, organization_provider_ids,course_id);
        body.put("providerID",providerID);
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        queryParameters.put("include_expired","1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationDetails", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String id = validator.getDataFromBody("$.data.id");
        assertThat(id).isNotBlank();

        String uuid = validator.getDataFromBody("$.data.uuid");
        assertThat(uuid).isNotBlank();

        String organizationid = validator.getDataFromBody("$.data.organization.id");
        assertThat(organizationid).isEqualTo(organizationId.substring(0,3));

        String name = validator.getDataFromBody("$.data.organization.name");
        assertThat(name).isEqualTo(organizationName);

        String first_name = validator.getDataFromBody("$.data.first_name");
        assertThat(first_name).isNotBlank();

        String last_name = validator.getDataFromBody("$.data.last_name");
        assertThat(last_name).isNotBlank();

        String phone = validator.getDataFromBody("$.data.phone");
        assertThat(phone).isNotBlank();

        String country_code = validator.getDataFromBody("$.data.country_code");
        assertThat(country_code).isNotBlank();

        String coursesid = validator.getDataFromBody("$.data.courses[0].id");
        assertThat(coursesid).isNotBlank();

        String provider_id = validator.getDataFromBody("$.data.courses[0].provider_id");
        assertThat(provider_id).isNotBlank();

        String courseName = validator.getDataFromBody("$.data.courses[0].name");
        assertThat(courseName).isNotBlank();

        String certificate_url = validator.getDataFromBody("$.data.courses[0].certificate_url");
        assertThat(certificate_url).isNotBlank();

        String is_active = validator.getDataFromBody("$.data.is_active");
        assertThat(is_active).isNotBlank();

        String is_applicant = validator.getDataFromBody("$.data.is_applicant");
        assertThat(is_applicant).isNotBlank();

        String provider_status = validator.getDataFromBody("$.data.provider_status");
        assertThat(provider_status).isNotBlank();

        String provider_status_id = validator.getDataFromBody("$.data.provider_status_id");
        assertThat(provider_status_id).isNotBlank();

        String sign_up = validator.getDataFromBody("$.data.sign_up");
        assertThat(sign_up).isNotBlank();

    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void organizationDetails_with_wrong_providerId(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        providerList providerList = new providerList();
        String providerID = providerList.providerList_for_Admin_User_To_Get_Provider_Id(email, password, organizationId, organizationName, organization_provider_ids, course_id);
        body.put("providerID", providerID.substring(0,4));
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        queryParameters.put("include_expired", "1");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/organizationDetailsWrongProviderID", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(404);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Provider not found");

    }

    }