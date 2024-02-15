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

public class sendCertificate extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void sendCertificate_with_wrong_course_id_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_provider_ids", organization_provider_ids.replace(".0",""));
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        queryParameters.put("course_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/sendCertificate", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String sendCertificate_with_wrong_course_id = validator.getDataFromBody("$.message");
        assertThat(sendCertificate_with_wrong_course_id).contains("No certificates have been sent. Certificates can be sent for completed and approved programs only");

        String notification_level = validator.getDataFromBody("$.notification_level");
        assertThat(notification_level).contains("warning");

    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void sendCertificate_with_wrong_course_id_Manager_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_provider_ids", organization_provider_ids.replace(".0",""));
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        queryParameters.put("course_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/sendCertificate", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String sendCertificate_with_wrong_course_id = validator.getDataFromBody("$.message");
        assertThat(sendCertificate_with_wrong_course_id).contains("No certificates have been sent. Certificates can be sent for completed and approved programs only");

        String notification_level = validator.getDataFromBody("$.notification_level");
        assertThat(notification_level).contains("warning");
    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void sendCertificate_with_wrong_course_id_Coordinator_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_provider_ids", organization_provider_ids.replace(".0",""));
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        queryParameters.put("course_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/sendCertificate", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String sendCertificate_with_wrong_course_id = validator.getDataFromBody("$.message");
        assertThat(sendCertificate_with_wrong_course_id).contains("No certificates have been sent. Certificates can be sent for completed and approved programs only");

        String notification_level = validator.getDataFromBody("$.notification_level");
        assertThat(notification_level).contains("warning");
    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void sendCertificate_with_wrong_course_id_Coordinator_Limited_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_provider_ids", organization_provider_ids.replace(".0",""));
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        queryParameters.put("course_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/sendCertificate", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String sendCertificate_with_wrong_course_id = validator.getDataFromBody("$.message");
        assertThat(sendCertificate_with_wrong_course_id).contains("No certificates have been sent. Certificates can be sent for completed and approved programs only");

        String notification_level = validator.getDataFromBody("$.notification_level");
        assertThat(notification_level).contains("warning");
    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void sendCertificate_with_wrong_course_id_RN_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_provider_ids", organization_provider_ids.replace(".0",""));
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        queryParameters.put("course_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/sendCertificate", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String sendCertificate_with_wrong_course_id = validator.getDataFromBody("$.message");
        assertThat(sendCertificate_with_wrong_course_id).contains("No certificates have been sent. Certificates can be sent for completed and approved programs only");

        String notification_level = validator.getDataFromBody("$.notification_level");
        assertThat(notification_level).contains("warning");
    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void sendCertificate_with_wrong_course_id_RN_Limited_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_provider_ids", organization_provider_ids.replace(".0",""));
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        queryParameters.put("course_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/sendCertificate", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String sendCertificate_with_wrong_course_id = validator.getDataFromBody("$.message");
        assertThat(sendCertificate_with_wrong_course_id).contains("No certificates have been sent. Certificates can be sent for completed and approved programs only");

        String notification_level = validator.getDataFromBody("$.notification_level");
        assertThat(notification_level).contains("warning");
    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void sendCertificate_with_wrong_course_id_Viewer_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        body.put("text","%LAST_NAME%");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_provider_ids", organization_provider_ids);
        queryParameters.put("organization_id", organizationId);
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/sendCertificate", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

    }

}