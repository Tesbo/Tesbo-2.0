package TestCases.APITests.CSPanelAPI;


import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class employeeProfileAPI extends base {
    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanleBackEndLogin.xlsx", 1);
        return data;
    }

    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_Manager")
    public void employee_profile(String email, String password) {


        RequestBuilder builder = new RequestBuilder();
        GetTokenUtility getToken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");
        header.put("x-authorization",getToken.getAccessToken(email, password));

        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("organization_id","354");
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/employeeProfile/employeeProfileProviderListCount", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String status = validator.getDataFromBody("$.status");
        assertThat(status).isNotBlank();
        String status_course = validator.getDataFromBody("$.status_course");
        assertThat(status_course).isNotBlank();
        String provider = validator.getDataFromBody("$.provider");
        assertThat(provider).isNotBlank();
        String providerId = validator.getDataFromBody("$.provider[*].id");
        assertThat(providerId).isNotBlank();
        String providerFirstName = validator.getDataFromBody("$.provider[*].first_name");
        assertThat(providerFirstName).isNotBlank();
        String providerLastName = validator.getDataFromBody("$.provider[*].last_name");
        assertThat(providerLastName).isNotBlank();
        String organization = validator.getDataFromBody("$.organization");
        assertThat(organization).isNotBlank();
        String organizationId = validator.getDataFromBody("$.organization[*].id");
        assertThat(organizationId).isNotBlank();
        String organizationName= validator.getDataFromBody("$.organization[*].name");
        assertThat(organizationName).isNotBlank();
        String organizationDisplayName= validator.getDataFromBody("$.organization[*].display_name");
        assertThat(organizationDisplayName).isNotBlank();
    }

}
