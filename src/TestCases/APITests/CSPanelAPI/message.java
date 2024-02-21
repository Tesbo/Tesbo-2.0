package TestCases.APITests.CSPanelAPI;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class message extends base {
    @DataProvider(name = "login_email_password_Admin")
    public Object[][] data_provider_Admin() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Admin")
    public void message_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        body.put("text","%LAST_NAME%");
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_provider_ids", organization_provider_ids.replace(".0",""));
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/message", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent");
    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void message_Manager_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {
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

        String update_file = builder.updateRequestObject("CSPanelAPI/message", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent");

    }


    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void message_Coordinator_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {
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

        String update_file = builder.updateRequestObject("CSPanelAPI/message", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent");

    }

    @DataProvider(name = "login_email_password_Coordinator_Limited")
    public Object[][] data_provider_Coordinator_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void message_Coordinator_Limited_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {
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

        String update_file = builder.updateRequestObject("CSPanelAPI/message", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent");

    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void message_RN_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {

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

        String update_file = builder.updateRequestObject("CSPanelAPI/message", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent");
    }

    @DataProvider(name = "login_email_password_RN_Limited")
    public Object[][] data_provider_RN_Limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void message_RN_Limited_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {
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

        String update_file = builder.updateRequestObject("CSPanelAPI/message", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent");
    }

    @DataProvider(name = "login_email_password_Viewer")
    public Object[][] data_provider_Viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void message_Viewer_User(String email, String password, String organizationId,String organizationName, String organization_provider_ids, String course_id) {

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

        String update_file = builder.updateRequestObject("CSPanelAPI/message", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);

    }

    @Test(dataProvider = "login_email_password_Admin")
    public void message_with_courseId_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        body.put("text", "API Automation");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("courseID",course_id.replace(".0",""));
        pathParameter.put("organizationProviderId",organization_provider_ids);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/messageWithCourseId", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent successfully");
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void message_with_courseId_for_Manager_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        body.put("text", "API Automation");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("courseID",course_id.replace(".0",""));
        pathParameter.put("organizationProviderId",organization_provider_ids);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/messageWithCourseId", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent successfully");
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void message_with_courseId_for_Coordinator_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        body.put("text", "API Automation");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("courseID",course_id.replace(".0",""));
        pathParameter.put("organizationProviderId",organization_provider_ids);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/messageWithCourseId", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent successfully");
    }

    @Test(dataProvider = "login_email_password_Coordinator_Limited")
    public void message_with_courseId_for_Coordinator_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        body.put("text", "API Automation");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("courseID",course_id.replace(".0",""));
        pathParameter.put("organizationProviderId",organization_provider_ids);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/messageWithCourseId", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent successfully");
    }

    @Test(dataProvider = "login_email_password_RN")
    public void message_with_courseId_for_RN_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        body.put("text", "API Automation");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("courseID",course_id.replace(".0",""));
        pathParameter.put("organizationProviderId",organization_provider_ids);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/messageWithCourseId", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent successfully");
    }

    @Test(dataProvider = "login_email_password_RN_Limited")
    public void message_with_courseId_for_RN_Limited_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        body.put("text", "API Automation");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("courseID",course_id.replace(".0",""));
        pathParameter.put("organizationProviderId",organization_provider_ids);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/messageWithCourseId", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).contains("Message sent successfully");
    }

    @Test(dataProvider = "login_email_password_Viewer")
    public void message_with_courseId_for_Viewer_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        body.put("text", "API Automation");
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("courseID",course_id.replace(".0",""));
        pathParameter.put("organizationProviderId",organization_provider_ids);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/messageWithCourseId", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);
    }

    @Test(dataProvider = "login_email_password_Admin")
    public void message_without_text_body_for_Admin_User(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {

        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        pathParameter.put("courseID",course_id.replace(".0",""));
        pathParameter.put("organizationProviderId",organization_provider_ids);
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id", organizationId.replace(".0",""));
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/messageWithoutText", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(403);
    }


}