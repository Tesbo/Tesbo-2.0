package TestCases.APITests.CSPanelAPI;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.performaction.autoapi.RequestBuilder;
import Framework.java.io.unity.performaction.autoapi.ResponseValidator;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NewPanelLogin extends base {
    @DataProvider(name = "login_email_password_AdminRN")
    public Object[][] data_provider() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 0);
        return data;
    }
    //--------------------------------META ACTION VERIFICATION------------------------------------------------
    @Test(dataProvider = "login_email_password_AdminRN")
    public void To_verify_the_meta_action_of_Admin_RN_by_login_with_valid_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id)  {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.access_token");
        assertThat(token).isNotBlank();
        String expiration = validator.getDataFromBody("$.expires_at");
        assertThat(expiration).isNotBlank();
        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Loggin ok");
        String OrganizationDetailsGetFromResponse = validator.getDataFromBody("$.organization");
        assertThat(OrganizationDetailsGetFromResponse).contains("id", "name", "display_name", "partner_id", "location_mandatory", "discipline_mandatory", "hide_purchased_hours");
        String organization = validator.getDataFromBody("$.organization.id");
        assertThat(organization).isNotBlank();
        String name = validator.getDataFromBody("$.organization.name");
        assertThat(name).isNotBlank();
        String location = validator.getDataFromBody("$.organization.location_mandatory");
        assertThat(location).isNotBlank();
        String discipline = validator.getDataFromBody("$.organization.discipline_mandatory");
        assertThat(discipline).isNotBlank();
//        String metaActionGetFromResponse = validator.getDataFromBody("$.user.meta_actions");
//        assertThat(metaActionGetFromResponse).contains("[\"organization_generic\",\"edit_provider_details_including_roles\",\"change_language\",\"deactivate_activate_provider_from_a_program\",\"deactivate_activate_provider_from_program_bulk\",\"deactivate_activate_provider_from_the_agency\",\"deactivate_activate_provider_from_the_agency_bulk\",\"download_certificate\",\"download_certificate_bulk\",\"edit_provider_due_date\",\"edit_provider_due_date_bulk\",\"add_provider_to_a_program\",\"add_provider_to_a_program_bulk\",\"send_reset_pw_email\",\"send_a_notification\",\"send_a_notification_bulk\",\"send_certificate\",\"send_certificate_bulk\",\"view_all_provider_details_including_roles\",\"export\",\"run_reports\",\"create_provider\",\"approve_completion\",\"can_create_edit_roles\",\"can_create_edit_roles_users\",\"can_view_program_catalog\",\"edit_provider_start_date\",\"edit_provider_start_date_bulk\",\"session_management\",\"list_provider\",\"scheduled_report_management\",\"view_schedule_reports\",\"view_user_filters\",\"user_filters_management\",\"taxonomy_management\",\"can_activate_deactivate_automation_rule\",\"can_activate_deactivate_agency_user\",\"can_view_agency_access_groups\",\"can_view_agency_roles\",\"can_view_agency_users\",\"can_view_timezones\",\"can_view_partners\",\"can_view_user_emails\",\"can_edit_profile_email\",\"can_check_email\"]");
        String organization_generic = validator.getDataFromBody("$.user.meta_actions[0]");
        assertThat(organization_generic).isEqualTo("organization_generic");

        String edit_provider_details_including_roles = validator.getDataFromBody("$.user.meta_actions[1]");
        assertThat(edit_provider_details_including_roles).isEqualTo("edit_provider_details_including_roles");

        String change_language = validator.getDataFromBody("$.user.meta_actions[2]");
        assertThat(change_language).isEqualTo("change_language");

        String deactivate_activate_provider_from_a_program = validator.getDataFromBody("$.user.meta_actions[3]");
        assertThat(deactivate_activate_provider_from_a_program).isEqualTo("deactivate_activate_provider_from_a_program");

        String deactivate_activate_provider_from_program_bulk = validator.getDataFromBody("$.user.meta_actions[4]");
        assertThat(deactivate_activate_provider_from_program_bulk).isEqualTo("deactivate_activate_provider_from_program_bulk");

        String deactivate_activate_provider_from_the_agency = validator.getDataFromBody("$.user.meta_actions[5]");
        assertThat(deactivate_activate_provider_from_the_agency).isEqualTo("deactivate_activate_provider_from_the_agency");

        String deactivate_activate_provider_from_the_agency_bulk = validator.getDataFromBody("$.user.meta_actions[6]");
        assertThat(deactivate_activate_provider_from_the_agency_bulk).isEqualTo("deactivate_activate_provider_from_the_agency_bulk");

        String download_certificate = validator.getDataFromBody("$.user.meta_actions[7]");
        assertThat(download_certificate).isEqualTo("download_certificate");


        String download_certificate_bulk = validator.getDataFromBody("$.user.meta_actions[8]");
        assertThat(download_certificate_bulk).isEqualTo("download_certificate_bulk");

        String edit_provider_due_date = validator.getDataFromBody("$.user.meta_actions[9]");
        assertThat(edit_provider_due_date).isEqualTo("edit_provider_due_date");

        String edit_provider_due_date_bulk = validator.getDataFromBody("$.user.meta_actions[10]");
        assertThat(edit_provider_due_date_bulk).isEqualTo("edit_provider_due_date_bulk");

        String add_provider_to_a_program = validator.getDataFromBody("$.user.meta_actions[11]");
        assertThat(add_provider_to_a_program).isEqualTo("add_provider_to_a_program");

        String add_provider_to_a_program_bulk = validator.getDataFromBody("$.user.meta_actions[12]");
        assertThat(add_provider_to_a_program_bulk).isEqualTo("add_provider_to_a_program_bulk");


        String send_reset_pw_email = validator.getDataFromBody("$.user.meta_actions[13]");
        assertThat(send_reset_pw_email).isEqualTo("send_reset_pw_email");

        String send_a_notification = validator.getDataFromBody("$.user.meta_actions[14]");
        assertThat(send_a_notification).isEqualTo("send_a_notification");

        String send_a_notification_bulk = validator.getDataFromBody("$.user.meta_actions[15]");
        assertThat(send_a_notification_bulk).isEqualTo("send_a_notification_bulk");


        String send_certificate = validator.getDataFromBody("$.user.meta_actions[16]");
        assertThat(send_certificate).isEqualTo("send_certificate");

        String send_certificate_bulk = validator.getDataFromBody("$.user.meta_actions[17]");
        assertThat(send_certificate_bulk).isEqualTo("send_certificate_bulk");

        String view_all_provider_details_including_roles = validator.getDataFromBody("$.user.meta_actions[18]");
        assertThat(view_all_provider_details_including_roles).isEqualTo("view_all_provider_details_including_roles");

        String export = validator.getDataFromBody("$.user.meta_actions[19]");
        assertThat(export).isEqualTo("export");

        String run_reports = validator.getDataFromBody("$.user.meta_actions[20]");
        assertThat(run_reports).isEqualTo("run_reports");

        String create_provider = validator.getDataFromBody("$.user.meta_actions[21]");
        assertThat(create_provider).isEqualTo("create_provider");

        String approve_completion = validator.getDataFromBody("$.user.meta_actions[22]");
        assertThat(approve_completion).isEqualTo("approve_completion");

        String can_create_edit_roles = validator.getDataFromBody("$.user.meta_actions[23]");
        assertThat(can_create_edit_roles).isEqualTo("can_create_edit_roles");

        String can_create_edit_roles_users = validator.getDataFromBody("$.user.meta_actions[24]");
        assertThat(can_create_edit_roles_users).isEqualTo("can_create_edit_roles_users");

        String can_view_program_catalog = validator.getDataFromBody("$.user.meta_actions[25]");
        assertThat(can_view_program_catalog).isEqualTo("can_view_program_catalog");

        String edit_provider_start_date = validator.getDataFromBody("$.user.meta_actions[26]");
        assertThat(edit_provider_start_date).isEqualTo("edit_provider_start_date");

        String edit_provider_start_date_bulk = validator.getDataFromBody("$.user.meta_actions[27]");
        assertThat(edit_provider_start_date_bulk).isEqualTo("edit_provider_start_date_bulk");

        String session_management = validator.getDataFromBody("$.user.meta_actions[28]");
        assertThat(session_management).isEqualTo("session_management");

        String list_provider = validator.getDataFromBody("$.user.meta_actions[29]");
        assertThat(list_provider).isEqualTo("list_provider");

        String scheduled_report_management = validator.getDataFromBody("$.user.meta_actions[30]");
        assertThat(scheduled_report_management).isEqualTo("scheduled_report_management");

        String view_schedule_reports = validator.getDataFromBody("$.user.meta_actions[31]");
        assertThat(view_schedule_reports).isEqualTo("view_schedule_reports");

        String view_user_filters = validator.getDataFromBody("$.user.meta_actions[32]");
        assertThat(view_user_filters).isEqualTo("view_user_filters");

        String user_filters_management = validator.getDataFromBody("$.user.meta_actions[33]");
        assertThat(user_filters_management).isEqualTo("user_filters_management");

        String taxonomy_management = validator.getDataFromBody("$.user.meta_actions[34]");
        assertThat(taxonomy_management).isEqualTo("taxonomy_management");

        String can_activate_deactivate_automation_rule = validator.getDataFromBody("$.user.meta_actions[35]");
        assertThat(can_activate_deactivate_automation_rule).isEqualTo("can_activate_deactivate_automation_rule");

        String can_activate_deactivate_agency_user = validator.getDataFromBody("$.user.meta_actions[36]");
        assertThat(can_activate_deactivate_agency_user).isEqualTo("can_activate_deactivate_agency_user");

        String can_view_agency_access_groups = validator.getDataFromBody("$.user.meta_actions[37]");
        assertThat(can_view_agency_access_groups).isEqualTo("can_view_agency_access_groups");

        String can_view_agency_roles = validator.getDataFromBody("$.user.meta_actions[38]");
        assertThat(can_view_agency_roles).isEqualTo("can_view_agency_roles");


        String can_view_agency_users = validator.getDataFromBody("$.user.meta_actions[39]");
        assertThat(can_view_agency_users).isEqualTo("can_view_agency_users");

        String can_view_timezones = validator.getDataFromBody("$.user.meta_actions[40]");
        assertThat(can_view_timezones).isEqualTo("can_view_timezones");

        String can_view_partners = validator.getDataFromBody("$.user.meta_actions[41]");
        assertThat(can_view_partners).isEqualTo("can_view_partners");

        String can_view_user_emails = validator.getDataFromBody("$.user.meta_actions[42]");
        assertThat(can_view_user_emails).isEqualTo("can_view_user_emails");

        String can_edit_profile_email = validator.getDataFromBody("$.user.meta_actions[43]");
        assertThat(can_edit_profile_email).isEqualTo("can_edit_profile_email");


        String can_check_email = validator.getDataFromBody("$.user.meta_actions[44]");
        assertThat(can_check_email).isEqualTo("can_check_email");

        String manage_shift_blocking = validator.getDataFromBody("$.user.meta_actions[45]");
        assertThat(manage_shift_blocking).isEqualTo("manage_shift_blocking");
    }

    @DataProvider(name = "login_email_password_Manager")
    public Object[][] data_provider_Manager() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 1);
        return data;
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void To_verify_the_meta_action_of_manager_by_login_with_valid_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id)  {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.access_token");
        assertThat(token).isNotBlank();
        String expiration = validator.getDataFromBody("$.expires_at");
        assertThat(expiration).isNotBlank();
        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Loggin ok");
        String OrganizationDetailsGetFromResponse = validator.getDataFromBody("$.organization");
        assertThat(OrganizationDetailsGetFromResponse).contains("id", "name", "display_name", "partner_id", "location_mandatory", "discipline_mandatory", "hide_purchased_hours");
        String organization = validator.getDataFromBody("$.organization.id");
        assertThat(organization).isNotBlank();
        String name = validator.getDataFromBody("$.organization.name");
        assertThat(name).isNotBlank();
        String location = validator.getDataFromBody("$.organization.location_mandatory");
        assertThat(location).isNotBlank();
        String discipline = validator.getDataFromBody("$.organization.discipline_mandatory");
        assertThat(discipline).isNotBlank();
        String metaActionGetFromResponse = validator.getDataFromBody("$.user.meta_actions");
        assertThat(metaActionGetFromResponse).contains("[\"organization_generic\",\"edit_provider_details_including_roles\",\"change_language\",\"deactivate_activate_provider_from_a_program\",\"deactivate_activate_provider_from_program_bulk\",\"deactivate_activate_provider_from_the_agency\",\"deactivate_activate_provider_from_the_agency_bulk\",\"download_certificate\",\"download_certificate_bulk\",\"edit_provider_due_date\",\"edit_provider_due_date_bulk\",\"add_provider_to_a_program\",\"add_provider_to_a_program_bulk\",\"send_reset_pw_email\",\"send_a_notification\",\"send_a_notification_bulk\",\"send_certificate\",\"send_certificate_bulk\",\"view_all_provider_details_including_roles\",\"export\",\"run_reports\",\"create_provider\",\"can_create_edit_roles\",\"can_create_edit_roles_users\",\"can_view_program_catalog\",\"edit_provider_start_date\",\"edit_provider_start_date_bulk\",\"session_management\",\"list_provider\",\"manage_shift_blocking\",\"scheduled_report_management\",\"view_schedule_reports\",\"view_user_filters\",\"user_filters_management\",\"taxonomy_management\",\"can_activate_deactivate_automation_rule\",\"can_activate_deactivate_agency_user\",\"can_view_agency_access_groups\",\"can_view_agency_roles\",\"can_view_agency_users\",\"can_view_timezones\",\"can_view_partners\",\"can_view_user_emails\",\"can_edit_profile_email\",\"can_check_email\"]");
    }

    @DataProvider(name = "login_email_password_Coordinator")
    public Object[][] data_provider_Coordinator() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 2);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void To_verify_the_meta_action_of_Coordinator_by_login_with_valid_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id)  {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.access_token");
        assertThat(token).isNotBlank();
        String expiration = validator.getDataFromBody("$.expires_at");
        assertThat(expiration).isNotBlank();
        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Loggin ok");
        String OrganizationDetailsGetFromResponse = validator.getDataFromBody("$.organization");
        assertThat(OrganizationDetailsGetFromResponse).contains("id", "name", "display_name", "partner_id", "location_mandatory", "discipline_mandatory", "hide_purchased_hours");
        String organization = validator.getDataFromBody("$.organization.id");
        assertThat(organization).isNotBlank();
        String name = validator.getDataFromBody("$.organization.name");
        assertThat(name).isNotBlank();
        String location = validator.getDataFromBody("$.organization.location_mandatory");
        assertThat(location).isNotBlank();
        String discipline = validator.getDataFromBody("$.organization.discipline_mandatory");
        assertThat(discipline).isNotBlank();
        String metaActionGetFromResponse = validator.getDataFromBody("$.user.meta_actions");
        assertThat(metaActionGetFromResponse).contains("[\"organization_generic\",\"edit_provider_details_including_roles\",\"change_language\",\"deactivate_activate_provider_from_a_program\",\"deactivate_activate_provider_from_program_bulk\",\"deactivate_activate_provider_from_the_agency\",\"deactivate_activate_provider_from_the_agency_bulk\",\"download_certificate\",\"download_certificate_bulk\",\"edit_provider_due_date\",\"edit_provider_due_date_bulk\",\"add_provider_to_a_program\",\"add_provider_to_a_program_bulk\",\"send_reset_pw_email\",\"send_a_notification\",\"send_a_notification_bulk\",\"send_certificate\",\"send_certificate_bulk\",\"view_all_provider_details_including_roles\",\"export\",\"run_reports\",\"can_view_program_catalog\",\"edit_provider_start_date\",\"edit_provider_start_date_bulk\",\"session_management\",\"list_provider\",\"scheduled_report_management\",\"view_schedule_reports\",\"view_user_filters\",\"user_filters_management\",\"can_view_user_emails\"]");
    }

    @DataProvider(name = "login_email_password_Coordinator_limited")
    public Object[][] data_provider_Coordinator_limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 3);
        return data;
    }

    @Test(dataProvider = "login_email_password_Coordinator_limited")
    public void To_verify_the_meta_action_of_Coordinator_limited_by_login_with_valid_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id)  {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.access_token");
        assertThat(token).isNotBlank();
        String expiration = validator.getDataFromBody("$.expires_at");
        assertThat(expiration).isNotBlank();
        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Loggin ok");
        String OrganizationDetailsGetFromResponse = validator.getDataFromBody("$.organization");
        assertThat(OrganizationDetailsGetFromResponse).contains("id", "name", "display_name", "partner_id", "location_mandatory", "discipline_mandatory", "hide_purchased_hours");
        String organization = validator.getDataFromBody("$.organization.id");
        assertThat(organization).isNotBlank();
        String name = validator.getDataFromBody("$.organization.name");
        assertThat(name).isNotBlank();
        String location = validator.getDataFromBody("$.organization.location_mandatory");
        assertThat(location).isNotBlank();
        String discipline = validator.getDataFromBody("$.organization.discipline_mandatory");
        assertThat(discipline).isNotBlank();
        String metaActionGetFromResponse = validator.getDataFromBody("$.user.meta_actions");
        assertThat(metaActionGetFromResponse).contains("[\"organization_generic\",\"edit_provider_details_including_roles\",\"change_language\",\"deactivate_activate_provider_from_a_program\",\"deactivate_activate_provider_from_program_bulk\",\"download_certificate\",\"download_certificate_bulk\",\"edit_provider_due_date\",\"edit_provider_due_date_bulk\",\"send_reset_pw_email\",\"send_a_notification\",\"send_a_notification_bulk\",\"send_certificate\",\"send_certificate_bulk\",\"view_all_provider_details_including_roles\",\"export\",\"run_reports\",\"can_view_program_catalog\",\"edit_provider_start_date\",\"edit_provider_start_date_bulk\",\"list_provider\",\"scheduled_report_management\",\"view_schedule_reports\",\"view_user_filters\",\"user_filters_management\",\"can_view_user_emails\"]");
    }

    @DataProvider(name = "login_email_password_RN")
    public Object[][] data_provider_RN() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 4);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN")
    public void To_verify_the_meta_action_of_RN_by_login_with_valid_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.access_token");
        assertThat(token).isNotBlank();
        String expiration = validator.getDataFromBody("$.expires_at");
        assertThat(expiration).isNotBlank();
        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Loggin ok");
        String OrganizationDetailsGetFromResponse = validator.getDataFromBody("$.organization");
        assertThat(OrganizationDetailsGetFromResponse).contains("id", "name", "display_name", "partner_id", "location_mandatory", "discipline_mandatory", "hide_purchased_hours");
        String organization = validator.getDataFromBody("$.organization.id");
        assertThat(organization).isNotBlank();
        String name = validator.getDataFromBody("$.organization.name");
        assertThat(name).isNotBlank();
        String location = validator.getDataFromBody("$.organization.location_mandatory");
        assertThat(location).isNotBlank();
        String discipline = validator.getDataFromBody("$.organization.discipline_mandatory");
        assertThat(discipline).isNotBlank();
//        String metaActionGetFromResponse = validator.getDataFromBody("$.user.meta_actions");
//        assertThat(metaActionGetFromResponse).contains("[\"organization_generic\",\"edit_provider_details_including_roles\",\"change_language\",\"deactivate_activate_provider_from_a_program\",\"deactivate_activate_provider_from_program_bulk\",\"deactivate_activate_provider_from_the_agency\",\"deactivate_activate_provider_from_the_agency_bulk\",\"download_certificate\",\"download_certificate_bulk\",\"edit_provider_due_date\",\"edit_provider_due_date_bulk\",\"add_provider_to_a_program\",\"add_provider_to_a_program_bulk\",\"send_reset_pw_email\",\"send_a_notification\",\"send_a_notification_bulk\",\"send_certificate\",\"send_certificate_bulk\",\"view_all_provider_details_including_roles\",\"export\",\"run_reports\",\"approve_completion\",\"can_view_program_catalog\",\"edit_provider_start_date\",\"edit_provider_start_date_bulk\",\"session_management\",\"list_provider\",\"scheduled_report_management\",\"view_schedule_reports\",\"view_user_filters\",\"user_filters_management\",\"can_view_user_emails\"]");
        String organization_generic = validator.getDataFromBody("$.user.meta_actions[0]");
        assertThat(organization_generic).isEqualTo("organization_generic");

        String edit_provider_details_including_roles = validator.getDataFromBody("$.user.meta_actions[1]");
        assertThat(edit_provider_details_including_roles).isEqualTo("edit_provider_details_including_roles");

        String change_language = validator.getDataFromBody("$.user.meta_actions[2]");
        assertThat(change_language).isEqualTo("change_language");

        String deactivate_activate_provider_from_a_program = validator.getDataFromBody("$.user.meta_actions[3]");
        assertThat(deactivate_activate_provider_from_a_program).isEqualTo("deactivate_activate_provider_from_a_program");

        String deactivate_activate_provider_from_program_bulk = validator.getDataFromBody("$.user.meta_actions[4]");
        assertThat(deactivate_activate_provider_from_program_bulk).isEqualTo("deactivate_activate_provider_from_program_bulk");

        String deactivate_activate_provider_from_the_agency = validator.getDataFromBody("$.user.meta_actions[5]");
        assertThat(deactivate_activate_provider_from_the_agency).isEqualTo("deactivate_activate_provider_from_the_agency");

        String deactivate_activate_provider_from_the_agency_bulk = validator.getDataFromBody("$.user.meta_actions[6]");
        assertThat(deactivate_activate_provider_from_the_agency_bulk).isEqualTo("deactivate_activate_provider_from_the_agency_bulk");

        String download_certificate = validator.getDataFromBody("$.user.meta_actions[7]");
        assertThat(download_certificate).isEqualTo("download_certificate");


        String download_certificate_bulk = validator.getDataFromBody("$.user.meta_actions[8]");
        assertThat(download_certificate_bulk).isEqualTo("download_certificate_bulk");

        String edit_provider_due_date = validator.getDataFromBody("$.user.meta_actions[9]");
        assertThat(edit_provider_due_date).isEqualTo("edit_provider_due_date");

        String edit_provider_due_date_bulk = validator.getDataFromBody("$.user.meta_actions[10]");
        assertThat(edit_provider_due_date_bulk).isEqualTo("edit_provider_due_date_bulk");

        String add_provider_to_a_program = validator.getDataFromBody("$.user.meta_actions[11]");
        assertThat(add_provider_to_a_program).isEqualTo("add_provider_to_a_program");

        String add_provider_to_a_program_bulk = validator.getDataFromBody("$.user.meta_actions[12]");
        assertThat(add_provider_to_a_program_bulk).isEqualTo("add_provider_to_a_program_bulk");


        String send_reset_pw_email = validator.getDataFromBody("$.user.meta_actions[13]");
        assertThat(send_reset_pw_email).isEqualTo("send_reset_pw_email");

        String send_a_notification = validator.getDataFromBody("$.user.meta_actions[14]");
        assertThat(send_a_notification).isEqualTo("send_a_notification");

        String send_a_notification_bulk = validator.getDataFromBody("$.user.meta_actions[15]");
        assertThat(send_a_notification_bulk).isEqualTo("send_a_notification_bulk");


        String send_certificate = validator.getDataFromBody("$.user.meta_actions[16]");
        assertThat(send_certificate).isEqualTo("send_certificate");

        String send_certificate_bulk = validator.getDataFromBody("$.user.meta_actions[17]");
        assertThat(send_certificate_bulk).isEqualTo("send_certificate_bulk");

        String view_all_provider_details_including_roles = validator.getDataFromBody("$.user.meta_actions[18]");
        assertThat(view_all_provider_details_including_roles).isEqualTo("view_all_provider_details_including_roles");

        String export = validator.getDataFromBody("$.user.meta_actions[19]");
        assertThat(export).isEqualTo("export");

        String run_reports = validator.getDataFromBody("$.user.meta_actions[20]");
        assertThat(run_reports).isEqualTo("run_reports");



        String approve_completion = validator.getDataFromBody("$.user.meta_actions[21]");
        assertThat(approve_completion).isEqualTo("approve_completion");

        String can_view_program_catalog = validator.getDataFromBody("$.user.meta_actions[22]");
        assertThat(can_view_program_catalog).isEqualTo("can_view_program_catalog");

        String edit_provider_start_date = validator.getDataFromBody("$.user.meta_actions[23]");
        assertThat(edit_provider_start_date).isEqualTo("edit_provider_start_date");

        String edit_provider_start_date_bulk = validator.getDataFromBody("$.user.meta_actions[24]");
        assertThat(edit_provider_start_date_bulk).isEqualTo("edit_provider_start_date_bulk");

        String session_management = validator.getDataFromBody("$.user.meta_actions[25]");
        assertThat(session_management).isEqualTo("session_management");

        String list_provider = validator.getDataFromBody("$.user.meta_actions[26]");
        assertThat(list_provider).isEqualTo("list_provider");

        String scheduled_report_management = validator.getDataFromBody("$.user.meta_actions[27]");
        assertThat(scheduled_report_management).isEqualTo("scheduled_report_management");

        String view_schedule_reports = validator.getDataFromBody("$.user.meta_actions[28]");
        assertThat(view_schedule_reports).isEqualTo("view_schedule_reports");

        String view_user_filters = validator.getDataFromBody("$.user.meta_actions[29]");
        assertThat(view_user_filters).isEqualTo("view_user_filters");

        String user_filters_management = validator.getDataFromBody("$.user.meta_actions[30]");
        assertThat(user_filters_management).isEqualTo("user_filters_management");

        String can_view_user_emails = validator.getDataFromBody("$.user.meta_actions[31]");
        assertThat(can_view_user_emails).isEqualTo("can_view_user_emails");

        String manage_shift_blocking = validator.getDataFromBody("$.user.meta_actions[32]");
        assertThat(manage_shift_blocking).isEqualTo("manage_shift_blocking");
    }

    @DataProvider(name = "login_email_password_RN_limited")
    public Object[][] data_provider_RN_limited() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 5);
        return data;
    }

    @Test(dataProvider = "login_email_password_RN_limited")
    public void To_verify_the_meta_action_of_RN_limited_by_login_with_valid_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id)  {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.access_token");
        assertThat(token).isNotBlank();
        String expiration = validator.getDataFromBody("$.expires_at");
        assertThat(expiration).isNotBlank();
        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Loggin ok");
        String OrganizationDetailsGetFromResponse = validator.getDataFromBody("$.organization");
        assertThat(OrganizationDetailsGetFromResponse).contains("id", "name", "display_name", "partner_id", "location_mandatory", "discipline_mandatory", "hide_purchased_hours");
        String organization = validator.getDataFromBody("$.organization.id");
        assertThat(organization).isNotBlank();
        String name = validator.getDataFromBody("$.organization.name");
        assertThat(name).isNotBlank();
        String location = validator.getDataFromBody("$.organization.location_mandatory");
        assertThat(location).isNotBlank();
        String discipline = validator.getDataFromBody("$.organization.discipline_mandatory");
        assertThat(discipline).isNotBlank();
//        String metaActionGetFromResponse = validator.getDataFromBody("$.user.meta_actions");
//        assertThat(metaActionGetFromResponse).contains("[\"organization_generic\",\"edit_provider_details_including_roles\",\"change_language\",\"deactivate_activate_provider_from_a_program\",\"deactivate_activate_provider_from_program_bulk\",\"download_certificate\",\"download_certificate_bulk\",\"edit_provider_due_date\",\"edit_provider_due_date_bulk\",\"send_reset_pw_email\",\"send_a_notification\",\"send_a_notification_bulk\",\"send_certificate\",\"send_certificate_bulk\",\"view_all_provider_details_including_roles\",\"export\",\"run_reports\",\"approve_completion\",\"can_view_program_catalog\",\"edit_provider_start_date\",\"edit_provider_start_date_bulk\",\"list_provider\",\"scheduled_report_management\",\"view_schedule_reports\",\"view_user_filters\",\"user_filters_management\",\"can_view_user_emails\"]");

        String organization_generic = validator.getDataFromBody("$.user.meta_actions[0]");
        assertThat(organization_generic).isEqualTo("organization_generic");

        String edit_provider_details_including_roles = validator.getDataFromBody("$.user.meta_actions[1]");
        assertThat(edit_provider_details_including_roles).isEqualTo("edit_provider_details_including_roles");

        String change_language = validator.getDataFromBody("$.user.meta_actions[2]");
        assertThat(change_language).isEqualTo("change_language");

        String deactivate_activate_provider_from_a_program = validator.getDataFromBody("$.user.meta_actions[3]");
        assertThat(deactivate_activate_provider_from_a_program).isEqualTo("deactivate_activate_provider_from_a_program");

        String deactivate_activate_provider_from_program_bulk = validator.getDataFromBody("$.user.meta_actions[4]");
        assertThat(deactivate_activate_provider_from_program_bulk).isEqualTo("deactivate_activate_provider_from_program_bulk");

        String download_certificate = validator.getDataFromBody("$.user.meta_actions[5]");
        assertThat(download_certificate).isEqualTo("download_certificate");

        String download_certificate_bulk = validator.getDataFromBody("$.user.meta_actions[6]");
        assertThat(download_certificate_bulk).isEqualTo("download_certificate_bulk");

        String edit_provider_due_date = validator.getDataFromBody("$.user.meta_actions[7]");
        assertThat(edit_provider_due_date).isEqualTo("edit_provider_due_date");

        String edit_provider_due_date_bulk = validator.getDataFromBody("$.user.meta_actions[8]");
        assertThat(edit_provider_due_date_bulk).isEqualTo("edit_provider_due_date_bulk");

        String send_reset_pw_email = validator.getDataFromBody("$.user.meta_actions[9]");
        assertThat(send_reset_pw_email).isEqualTo("send_reset_pw_email");

        String send_a_notification = validator.getDataFromBody("$.user.meta_actions[10]");
        assertThat(send_a_notification).isEqualTo("send_a_notification");

        String send_a_notification_bulk = validator.getDataFromBody("$.user.meta_actions[11]");
        assertThat(send_a_notification_bulk).isEqualTo("send_a_notification_bulk");


        String send_certificate = validator.getDataFromBody("$.user.meta_actions[12]");
        assertThat(send_certificate).isEqualTo("send_certificate");

        String send_certificate_bulk = validator.getDataFromBody("$.user.meta_actions[13]");
        assertThat(send_certificate_bulk).isEqualTo("send_certificate_bulk");

        String view_all_provider_details_including_roles = validator.getDataFromBody("$.user.meta_actions[14]");
        assertThat(view_all_provider_details_including_roles).isEqualTo("view_all_provider_details_including_roles");

        String export = validator.getDataFromBody("$.user.meta_actions[15]");
        assertThat(export).isEqualTo("export");

        String run_reports = validator.getDataFromBody("$.user.meta_actions[16]");
        assertThat(run_reports).isEqualTo("run_reports");



        String approve_completion = validator.getDataFromBody("$.user.meta_actions[17]");
        assertThat(approve_completion).isEqualTo("approve_completion");

        String can_view_program_catalog = validator.getDataFromBody("$.user.meta_actions[18]");
        assertThat(can_view_program_catalog).isEqualTo("can_view_program_catalog");

        String edit_provider_start_date = validator.getDataFromBody("$.user.meta_actions[19]");
        assertThat(edit_provider_start_date).isEqualTo("edit_provider_start_date");

        String edit_provider_start_date_bulk = validator.getDataFromBody("$.user.meta_actions[20]");
        assertThat(edit_provider_start_date_bulk).isEqualTo("edit_provider_start_date_bulk");

        String list_provider = validator.getDataFromBody("$.user.meta_actions[21]");
        assertThat(list_provider).isEqualTo("list_provider");

        String scheduled_report_management = validator.getDataFromBody("$.user.meta_actions[22]");
        assertThat(scheduled_report_management).isEqualTo("scheduled_report_management");

        String view_schedule_reports = validator.getDataFromBody("$.user.meta_actions[23]");
        assertThat(view_schedule_reports).isEqualTo("view_schedule_reports");

        String view_user_filters = validator.getDataFromBody("$.user.meta_actions[24]");
        assertThat(view_user_filters).isEqualTo("view_user_filters");

        String user_filters_management = validator.getDataFromBody("$.user.meta_actions[25]");
        assertThat(user_filters_management).isEqualTo("user_filters_management");

        String can_view_user_emails = validator.getDataFromBody("$.user.meta_actions[26]");
        assertThat(can_view_user_emails).isEqualTo("can_view_user_emails");

        String manage_shift_blocking = validator.getDataFromBody("$.user.meta_actions[27]");
        assertThat(manage_shift_blocking).isEqualTo("manage_shift_blocking");
    }

    @DataProvider(name = "login_email_password_viewer")
    public Object[][] data_provider_viewer() {
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("NewPanelBackEndLogin.xlsx", 6);
        return data;
    }

    @Test(dataProvider = "login_email_password_viewer")
    public void To_verify_the_meta_action_of_viewer_by_login_with_valid_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id)  {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(200);

        String token = validator.getDataFromBody("$.access_token");
        assertThat(token).isNotBlank();
        String expiration = validator.getDataFromBody("$.expires_at");
        assertThat(expiration).isNotBlank();
        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Loggin ok");
        String OrganizationDetailsGetFromResponse = validator.getDataFromBody("$.organization");
        assertThat(OrganizationDetailsGetFromResponse).contains("id", "name", "display_name", "partner_id", "location_mandatory", "discipline_mandatory", "hide_purchased_hours");
        String organization = validator.getDataFromBody("$.organization.id");
        assertThat(organization).isNotBlank();
        String name = validator.getDataFromBody("$.organization.name");
        assertThat(name).isNotBlank();
        String location = validator.getDataFromBody("$.organization.location_mandatory");
        assertThat(location).isNotBlank();
        String discipline = validator.getDataFromBody("$.organization.discipline_mandatory");
        assertThat(discipline).isNotBlank();
//        String metaActionGetFromResponse = validator.getDataFromBody("$.user.meta_actions");
//        assertThat(metaActionGetFromResponse).contains("[\"organization_generic\",\"edit_provider_details_including_roles\",\"change_language\",\"deactivate_activate_provider_from_a_program\",\"deactivate_activate_provider_from_program_bulk\",\"download_certificate\",\"download_certificate_bulk\",\"edit_provider_due_date\",\"edit_provider_due_date_bulk\",\"send_reset_pw_email\",\"send_a_notification\",\"send_a_notification_bulk\",\"send_certificate\",\"send_certificate_bulk\",\"view_all_provider_details_including_roles\",\"export\",\"run_reports\",\"approve_completion\",\"can_view_program_catalog\",\"edit_provider_start_date\",\"edit_provider_start_date_bulk\",\"list_provider\",\"scheduled_report_management\",\"view_schedule_reports\",\"view_user_filters\",\"user_filters_management\",\"can_view_user_emails\"]");
        String meta_actions = validator.getDataFromBody("$.user.meta_actions");
        assertThat(meta_actions).isNotBlank();

        String organization_generic = validator.getDataFromBody("$.user.meta_actions[0]");
        assertThat(organization_generic).isEqualTo("organization_generic");

        String download_certificate = validator.getDataFromBody("$.user.meta_actions[1]");
        assertThat(download_certificate).isEqualTo("download_certificate");

        String download_certificate_bulk = validator.getDataFromBody("$.user.meta_actions[2]");
        assertThat(download_certificate_bulk).isEqualTo("download_certificate_bulk");

        String view_all_provider_details_including_roles = validator.getDataFromBody("$.user.meta_actions[3]");
        assertThat(view_all_provider_details_including_roles).isEqualTo("view_all_provider_details_including_roles");

        String export = validator.getDataFromBody("$.user.meta_actions[4]");
        assertThat(export).isEqualTo("export");

        String run_reports = validator.getDataFromBody("$.user.meta_actions[5]");
        assertThat(run_reports).isEqualTo("run_reports");

        String can_view_program_catalog = validator.getDataFromBody("$.user.meta_actions[6]");
        assertThat(can_view_program_catalog).isEqualTo("can_view_program_catalog");

        String session_management = validator.getDataFromBody("$.user.meta_actions[7]");
        assertThat(session_management).isEqualTo("session_management");

        String list_provider = validator.getDataFromBody("$.user.meta_actions[8]");
        assertThat(list_provider).isEqualTo("list_provider");

        String view_schedule_reports = validator.getDataFromBody("$.user.meta_actions[9]");
        assertThat(view_schedule_reports).isEqualTo("view_schedule_reports");

        String view_user_filters = validator.getDataFromBody("$.user.meta_actions[10]");
        assertThat(view_user_filters).isEqualTo("view_user_filters");

        String user_filters_management = validator.getDataFromBody("$.user.meta_actions[11]");
        assertThat(user_filters_management).isEqualTo("user_filters_management");
    }
    //-----------------------------------Common Testcases of login API-----------------------------------------//


    // ---------------------------------- Negative Cases of Login API -----------------------------------------//

    @Test(dataProvider = "login_email_password_AdminRN")
    public void To_verify_the_meta_action_of_Admin_RN_by_login_with_invalid_Email_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email+"123");
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

          String message = validator.getDataFromBody("$.message");
          assertThat(message).isEqualTo("Wrong email/password. Please try again");
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void To_verify_the_meta_action_of_Manager_by_login_with_invalid_Email_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email+"123");
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Wrong email/password. Please try again");
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void To_verify_the_meta_action_of_Coordinator_by_login_with_invalid_Email_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email+"123");
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Wrong email/password. Please try again");
    }

    @Test(dataProvider = "login_email_password_Coordinator_limited")
    public void To_verify_the_meta_action_of_Coordinator_limited_by_login_with_invalid_Email_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email+"123");
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Wrong email/password. Please try again");
    }

    @Test(dataProvider = "login_email_password_RN")
    public void To_verify_the_meta_action_of_RN_by_login_with_invalid_Email_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email+"123");
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Wrong email/password. Please try again");
    }

    @Test(dataProvider = "login_email_password_RN_limited")
    public void To_verify_the_meta_action_of_RN_Limited_by_login_with_invalid_Email_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email+"123");
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Wrong email/password. Please try again");
    }

    @Test(dataProvider = "login_email_password_viewer")
    public void To_verify_the_meta_action_of_Viewer_by_login_with_invalid_Email_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email+"123");
        body.put("password", password);

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Wrong email/password. Please try again");
    }

    @Test(dataProvider = "login_email_password_AdminRN")
    public void To_verify_the_meta_action_of_Admin_by_login_with_invalid_Password_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password + "123");

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Incorrect username or password. Please try again.");
    }

    @Test(dataProvider = "login_email_password_Manager")
    public void To_verify_the_meta_action_of_Manager_by_login_with_invalid_Password_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password + "123");

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Incorrect username or password. Please try again.");
    }

    @Test(dataProvider = "login_email_password_Coordinator")
    public void To_verify_the_meta_action_of_Coordinator_by_login_with_invalid_Password_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password + "123");

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Incorrect username or password. Please try again.");
    }

    @Test(dataProvider = "login_email_password_AdminRN")
    public void To_verify_the_meta_action_of_Admin_RN_by_login_with_invalid_Password_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password + "123");

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Incorrect username or password. Please try again.");
    }

    @Test(dataProvider = "login_email_password_Coordinator_limited")
    public void To_verify_the_meta_action_of_Coordinator_limited_by_login_with_invalid_Password_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password + "123");

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Incorrect username or password. Please try again.");
    }

    @Test(dataProvider = "login_email_password_RN")
    public void To_verify_the_meta_action_of_RN_by_login_with_invalid_Password_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password + "123");

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Incorrect username or password. Please try again.");
    }

    @Test(dataProvider = "login_email_password_RN_limited")
    public void To_verify_the_meta_action_of_RN_limited_by_login_with_invalid_Password_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password + "123");

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Incorrect username or password. Please try again.");
    }

    @Test(dataProvider = "login_email_password_viewer")
    public void To_verify_the_meta_action_of_viewer_by_login_with_invalid_Password_credentials(String email, String password, String organizationId, String organizationName,String organization_provider_ids, String course_id) {
        RequestBuilder builder = new RequestBuilder();

        JSONObject header = new JSONObject();
        header.put("content-type", "application/json");

        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password + "123");

        JSONObject pathParameter = new JSONObject();
        JSONObject queryParameters = new JSONObject();
        JSONObject schema = new JSONObject();

        String update_file = builder.updateRequestObject("CSPanelAPI/login_with_credentials", pathParameter, queryParameters, header, body, schema);
        JSONObject response = builder.performRequest(update_file);
        System.out.println(response);

        ResponseValidator validator = new ResponseValidator(response);
        validator.statusCodeShouldBe(401);

        String message = validator.getDataFromBody("$.message");
        assertThat(message).isEqualTo("Incorrect username or password. Please try again.");
    }

}

