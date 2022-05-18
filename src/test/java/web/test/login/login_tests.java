package web.test.login;

import api.data.admin_user_create_data;
import io.unity.framework.API.RequestBuilder;
import io.unity.framework.API.ResponseValidator;
import io.unity.framework.init.base;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.object_repository.dashboard_page.dashboard_page;
import web.object_repository.login_page.login_page;

import java.util.HashMap;
import java.util.Map;

public class login_tests extends base {


    @Test
    public void create_admin_user_and_verify_login() {
        RequestBuilder builder = new RequestBuilder();
        admin_user_create_data user_data = new admin_user_create_data();

        JSONObject response = builder.performRequest("admin_auth/admin_auth");

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(201);

        String token = validator.getDataFromBody("$.session.accessToken");


        Map header = new HashMap();
        header.put("Authorization", "Bearer " + token);
        header.put("Content-Type", "application/json");

        Map body = user_data.generateValidUserBodyData();

        JSONObject user_create_response = builder.performRequestWithHeaderAndBody("admin_auth/admin_user_create", header, body);
        ResponseValidator user_create_validator = new ResponseValidator(user_create_response);
        user_create_validator.statusCodeShouldBe(201);

        user_create_validator.responseShouldContains("$.firstName", body.get("firstName"));
        user_create_validator.responseShouldContains("$.lastName", body.get("lastName"));
        user_create_validator.responseShouldContains("$.email", body.get("email"));
        user_create_validator.responseShouldContains("$.role", "ADMIN");
        user_create_validator.responseShouldContains("$.status", "ENABLED");

        String email = user_create_validator.getDataFromBody("$.email");
        String password = body.get("password").toString();



        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);

        login.verify_log_in_button_is_present_on_page();
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_password_is_present_on_page();

        login.enter_text_at_email_text_box(email);
        login.enter_text_at_password_password(password);
        login.click_on_log_in_button();


        dashboard.verify_appointments_link_is_present_on_page();
        dashboard.verify_dashboard_text_is_present_on_page();
        dashboard.verify_patients_link_is_present_on_page();
        dashboard.verify_physicians_link_is_present_on_page();
        dashboard.verify_appointments_link_is_present_on_page();
        dashboard.verify_settings_link_is_present_on_page();
        dashboard.verify_physician_requests_link_is_present_on_page();


        dashboard.click_on_patients_link();
        dashboard.verify_patients_page_text_is_present_on_page();

        dashboard.click_on_physicians_link();
        dashboard.verify_physician_page_text_is_present_on_page();

        dashboard.click_on_appointments_link();
        dashboard.verify_appointments_page_text_is_present_on_page();


    }

}
