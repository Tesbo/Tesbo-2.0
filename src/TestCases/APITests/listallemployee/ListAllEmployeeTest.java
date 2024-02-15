package APITests.listallemployee;

import api.requests.common.ExcelOperation.ExcelReader;
import api.requests.common.GetTokenUtility;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.performaction.autoapi.RequestBuilder;
import io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListAllEmployeeTest extends base {
@Test
public void verify_get_all_employee_with_valid_token()
{
    RequestBuilder builder = new RequestBuilder();
    GetTokenUtility gettoken = new GetTokenUtility();

    JSONObject header = new JSONObject();
    header.put("content-type","application/json");
    header.put("Authorization",gettoken.getToken());

    JSONObject pathParameter = new JSONObject();
    JSONObject queryParameters = new JSONObject();
    JSONObject body = new JSONObject();
    JSONObject schema = new JSONObject();

    String  update_file = builder.updateRequestObject("listallemployee/list_all_employee_with_valid_token",pathParameter, queryParameters, header, body,schema);
    JSONObject get_employee_response=builder.performRequest(update_file);
    System.out.println(get_employee_response);

    ResponseValidator employee_validator = new ResponseValidator(get_employee_response);
    employee_validator.statusCodeShouldBe(200);

    String expiration = employee_validator.getDataFromBody("$.data[*].id");
    assertThat(expiration).isNotBlank();

    String firstname_ex = employee_validator.getDataFromBody("$.data[*].first_name");
    assertThat(firstname_ex).isNotBlank();

    String lastname_ex = employee_validator.getDataFromBody("$.data[*].last_name");
    assertThat(lastname_ex).isNotBlank();

    String countrycode_ex = employee_validator.getDataFromBody("$.data[*].country_code");
    assertThat(countrycode_ex).isNotBlank();

    String email_ex = employee_validator.getDataFromBody("$.data[*].email");
    assertThat(email_ex).isNotBlank();

    String phone_ex = employee_validator.getDataFromBody("$.data[*].phone");
    assertThat(phone_ex).isNotBlank();

    String onboarddate_ex = employee_validator.getDataFromBody("$.data[*].onboard_date");
    assertThat(onboarddate_ex).isNotBlank();

    String employeenumber_ex = employee_validator.getDataFromBody("$.data[*].employee_number");
    assertThat(employeenumber_ex).isNotBlank();

    String disipline_ex = employee_validator.getDataFromBody("$.data[*].disciplines");
    assertThat(disipline_ex).isNotBlank();

    String location_ex = employee_validator.getDataFromBody("$.data[*].location");
    assertThat(location_ex).isNotBlank();

    String language_ex = employee_validator.getDataFromBody("$.data[*].language");
    assertThat(language_ex).isNotBlank();

    String status_ex = employee_validator.getDataFromBody("$.data[*].status");
    assertThat(status_ex).isNotBlank();

    String createddatetime_ex = employee_validator.getDataFromBody("$.data[*].created_datetime");
    assertThat(createddatetime_ex).isNotBlank();

    String updateddatetime_ex = employee_validator.getDataFromBody("$.data[*].updated_datetime");
    assertThat(updateddatetime_ex).isNotBlank();

    String metaobject = employee_validator.getDataFromBody("$.meta");
    assertThat(metaobject).isNotBlank();

    String last_page = employee_validator.getDataFromBody("$.meta.last_page");
    assertThat(last_page).isNotBlank();

    String first_page = employee_validator.getDataFromBody("$.meta.current_page");
    assertThat(first_page).isNotBlank();

    String total = employee_validator.getDataFromBody("$.meta.total");
    assertThat(total).isNotBlank();

}
    @Test
    public void verify_get_all_employee_with_blank_token()
    {
        RequestBuilder builder = new RequestBuilder();

        JSONObject response = builder.performRequest("listallemployee/list_all_employee_with_valid_token");
        System.out.println(response);
        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is missing !!");

    }
    @Test
    public void verify_get_all_employee_with_invalid_token()
    {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("Authorization","1234ef");
        JSONObject body = new JSONObject();
        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("listallemployee/list_all_employee_with_valid_token",pathParameter, queryParameters, header, body, schema);
        JSONObject get_employee_response=builder.performRequest(update_file);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_response);
        employee_validator.statusCodeShouldBe(401);
        System.out.println(get_employee_response);

        String message = employee_validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Token is invalid !!");
    }

    @DataProvider(name = "Signed_up_QP")
    public Object[][] Signed_up() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Signed_up_QP.xlsx", 0);
        return data;
    }
    @Test(dataProvider = "Signed_up_QP")
    public void verify_by_applying_signed_up_query_parameter_value_as_true_User_is_only_getting_signed_up_employees_list (String Id , String Filter_Name , String Value , String status_code) {
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();
        GetTokenUtility gettoken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization",gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("signed_up", Value);
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("listallemployee/list_all_employee_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_employee_response=builder.performRequest(update_file);
        System.out.println(get_employee_response);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_response);
        employee_validator.statusCodeShouldBe(200);

        String expiration = employee_validator.getDataFromBody("$.data[*].id");
        assertThat(expiration).isNotBlank();

        String firstname_ex = employee_validator.getDataFromBody("$.data[*].first_name");
        assertThat(firstname_ex).isNotBlank();

        String lastname_ex = employee_validator.getDataFromBody("$.data[*].last_name");
        assertThat(lastname_ex).isNotBlank();

        String countrycode_ex = employee_validator.getDataFromBody("$.data[*].country_code");
        assertThat(countrycode_ex).isNotBlank();

        String email_ex = employee_validator.getDataFromBody("$.data[*].email");
        assertThat(email_ex).isNotBlank();

        String phone_ex = employee_validator.getDataFromBody("$.data[*].phone");
        assertThat(phone_ex).isNotBlank();

        String onboarddate_ex = employee_validator.getDataFromBody("$.data[*].onboard_date");
        assertThat(onboarddate_ex).isNotBlank();

        String employeenumber_ex = employee_validator.getDataFromBody("$.data[*].employee_number");
        assertThat(employeenumber_ex).isNotBlank();

        String disipline_ex = employee_validator.getDataFromBody("$.data[*].disciplines");
        assertThat(disipline_ex).isNotBlank();

        String location_ex = employee_validator.getDataFromBody("$.data[*].location");
        assertThat(location_ex).isNotBlank();

        String language_ex = employee_validator.getDataFromBody("$.data[*].language");
        assertThat(language_ex).isNotBlank();

        String status_ex = employee_validator.getDataFromBody("$.data[*].status");
        assertThat(status_ex).isNotBlank();

        String createddatetime_ex = employee_validator.getDataFromBody("$.data[*].created_datetime");
        assertThat(createddatetime_ex).isNotBlank();

        String updateddatetime_ex = employee_validator.getDataFromBody("$.data[*].updated_datetime");
        assertThat(updateddatetime_ex).isNotBlank();

    }

    @DataProvider(name = "Disciplines_QP")
    public Object[][] Disciplines() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("Signed_up_QP.xlsx", 1);
        return data;
    }
    @Test(dataProvider = "Disciplines_QP")
    public void verify_by_applying_disciplines_query_parameter_User_is_only_getting_result_as_per_searched_filter(String Id , String Filter_Name , String Value , String status_code) {
        RequestBuilder builder = new RequestBuilder();
        ExcelReader reader = new ExcelReader();
        GetTokenUtility gettoken = new GetTokenUtility();

        JSONObject header = new JSONObject();
        header.put("content-type","application/json");
        header.put("Authorization",gettoken.getToken());

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        queryParameters.put("disciplines", Value);
        System.out.println(queryParameters);
        JSONObject body = new JSONObject();
        JSONObject schema = new JSONObject();

        String  update_file = builder.updateRequestObject("listallemployee/list_all_employee_with_valid_token",pathParameter, queryParameters, header, body,schema);
        JSONObject get_employee_response=builder.performRequest(update_file);
        System.out.println(get_employee_response);

        ResponseValidator employee_validator = new ResponseValidator(get_employee_response);
        employee_validator.statusCodeShouldBe(200);

        String expiration = employee_validator.getDataFromBody("$.data[*].id");
        assertThat(expiration).isNotBlank();

        String firstname_ex = employee_validator.getDataFromBody("$.data[*].first_name");
        assertThat(firstname_ex).isNotBlank();

        String lastname_ex = employee_validator.getDataFromBody("$.data[*].last_name");
        assertThat(lastname_ex).isNotBlank();

        String countrycode_ex = employee_validator.getDataFromBody("$.data[*].country_code");
        assertThat(countrycode_ex).isNotBlank();

        String email_ex = employee_validator.getDataFromBody("$.data[*].email");
        assertThat(email_ex).isNotBlank();

        String phone_ex = employee_validator.getDataFromBody("$.data[*].phone");
        assertThat(phone_ex).isNotBlank();

        String onboarddate_ex = employee_validator.getDataFromBody("$.data[*].onboard_date");
        assertThat(onboarddate_ex).isNotBlank();

        String employeenumber_ex = employee_validator.getDataFromBody("$.data[*].employee_number");
        assertThat(employeenumber_ex).isNotBlank();

        String disipline_ex = employee_validator.getDataFromBody("$.data[*].disciplines");
        assertThat(disipline_ex).isNotBlank();

        String location_ex = employee_validator.getDataFromBody("$.data[*].location");
        assertThat(location_ex).isNotBlank();

        String language_ex = employee_validator.getDataFromBody("$.data[*].language");
        assertThat(language_ex).isNotBlank();

        String status_ex = employee_validator.getDataFromBody("$.data[*].status");
        assertThat(status_ex).isNotBlank();

        String createddatetime_ex = employee_validator.getDataFromBody("$.data[*].created_datetime");
        assertThat(createddatetime_ex).isNotBlank();

        String updateddatetime_ex = employee_validator.getDataFromBody("$.data[*].updated_datetime");
        assertThat(updateddatetime_ex).isNotBlank();
    }
}
