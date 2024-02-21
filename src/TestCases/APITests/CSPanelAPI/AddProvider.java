package TestCases.APITests.CSPanelAPI;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class AddProvider extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void AddProvider_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        String phoneNumber = "21325"+ random.ints(1111,9999);
        JSONObject body = new JSONObject();
        body.put("country_code","+1");
        body.put("phone",phoneNumber);
        body.put("first_name","Automation");
        body.put("last_name","API");
        body.put("onboard_date","2023-02-06");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/AddProvider", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(201);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Provider created successfully");

        String provider = validator.getDataFromBody("$.provider.id");
        assertThat(provider).isNotBlank();

        String phone = validator.getDataFromBody("$.provider.phone");
        assertThat(phone).contains("21325");

        String country_code = validator.getDataFromBody("$.provider.country_code");
        assertThat(country_code).isEqualTo("+1");

        String first_name = validator.getDataFromBody("$.provider.first_name");
        assertThat(first_name).isEqualTo("Automation");

        String last_name = validator.getDataFromBody("$.provider.last_name");
        assertThat(last_name).isEqualTo("API");

        String organization_provider_id = validator.getDataFromBody("$.op.organization_provider_id");
        assertThat(organization_provider_id).isNotBlank();

        String firstName = validator.getDataFromBody("$.op.first_name");
        assertThat(firstName).isNotBlank();

        String lastName = validator.getDataFromBody("$.op.last_name");
        assertThat(lastName).isNotBlank();

    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void AddProvider_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        String phoneNumber = "21325"+ random.ints(1111,9999);
        JSONObject body = new JSONObject();
        body.put("country_code","+1");
        body.put("phone",phoneNumber);
        body.put("first_name","Automation");
        body.put("last_name","API");
        body.put("onboard_date","2023-02-06");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/AddProvider", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(201);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Provider created successfully");

        String provider = validator.getDataFromBody("$.provider.id");
        assertThat(provider).isNotBlank();

        String phone = validator.getDataFromBody("$.provider.phone");
        assertThat(phone).contains("21325");

        String country_code = validator.getDataFromBody("$.provider.country_code");
        assertThat(country_code).isEqualTo("+1");

        String first_name = validator.getDataFromBody("$.provider.first_name");
        assertThat(first_name).isEqualTo("Automation");

        String last_name = validator.getDataFromBody("$.provider.last_name");
        assertThat(last_name).isEqualTo("API");

        String organization_provider_id = validator.getDataFromBody("$.op.organization_provider_id");
        assertThat(organization_provider_id).isNotBlank();

        String firstName = validator.getDataFromBody("$.op.first_name");
        assertThat(firstName).isNotBlank();

        String lastName = validator.getDataFromBody("$.op.last_name");
        assertThat(lastName).isNotBlank();
    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void AddProvider_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        String phoneNumber = "21325"+ random.ints(1111,9999);
        JSONObject body = new JSONObject();
        body.put("country_code","+1");
        body.put("phone",phoneNumber);
        body.put("first_name","Automation");
        body.put("last_name","API");
        body.put("onboard_date","2023-02-06");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/AddProvider", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void AddProvider_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        String phoneNumber = "21325"+ random.ints(1111,9999);
        JSONObject body = new JSONObject();
        body.put("country_code","+1");
        body.put("phone",phoneNumber);
        body.put("first_name","Automation");
        body.put("last_name","API");
        body.put("onboard_date","2023-02-06");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/AddProvider", pathParameter, queryParameters, header, body, schema);
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
    public void AddProvider_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        String phoneNumber = "21325"+ random.ints(1111,9999);
        JSONObject body = new JSONObject();
        body.put("country_code","+1");
        body.put("phone",phoneNumber);
        body.put("first_name","Automation");
        body.put("last_name","API");
        body.put("onboard_date","2023-02-06");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/AddProvider", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);
    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void AddProvider_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        String phoneNumber = "21325"+ random.ints(1111,9999);
        JSONObject body = new JSONObject();
        body.put("country_code","+1");
        body.put("phone",phoneNumber);
        body.put("first_name","Automation");
        body.put("last_name","API");
        body.put("onboard_date","2023-02-06");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/AddProvider", pathParameter, queryParameters, header, body, schema);
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
    public void AddProvider_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        Random random = new Random();
        String phoneNumber = "21325"+ random.ints(1111,9999);
        JSONObject body = new JSONObject();
        body.put("country_code","+1");
        body.put("phone",phoneNumber);
        body.put("first_name","Automation");
        body.put("last_name","API");
        body.put("onboard_date","2023-02-06");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id",organizationId.substring(0,3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/AddProvider", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

    }

    public String addProvider_and_get_providerID(String email, String password, String organizationId, String organizationName, String organization_provider_ids, String course_id) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization", getToken.getAccessToken(email, password));

        Random random = new Random();
        String phoneNumber = "21325" + random.ints(1111, 9999);
        JSONObject body = new JSONObject();
        body.put("country_code", "+1");
        body.put("phone", phoneNumber);
        body.put("first_name", "Automation");
        body.put("last_name", "API");
        body.put("onboard_date", "2023-02-06");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.substring(0, 3));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/AddProvider", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(201);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Provider created successfully");

        String providerID = validator.getDataFromBody("$.provider.id");
        assertThat(providerID).isNotBlank();

        return providerID;
    }

}