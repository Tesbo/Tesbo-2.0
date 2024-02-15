package WebUITests.employeeProfile;

import io.unity.core.data.TestData;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.csAgencySettingsPage.csAgencySettings_page;
import web.object_repository.csHomePage.csHome_page;
import web.object_repository.csdashboard.dashboard_page;
import web.object_repository.employeeActionPage.employee_action;
import web.object_repository.employeeProfilePage.employeeProfile;
import web.object_repository.filterPage.filter;
import web.object_repository.login.login_page;
import web.object_repository.newEmployeesPage.new_employees;
import web.object_repository.program.program_page;
import WebUITests.commonDataProviders.commonDataProvider;

public class EmployeeProfileTest extends base {

    login_page login = null;
    employeeProfile employeeProfile = null;
    new_employees new_employees = null;

    program_page program_page = null;

    filter filter = null;
    csHome_page csHome = null;
    csAgencySettings_page csAgencySettingsPage = null;
    employee_action employeeAction = null;
    dashboard_page dashboardPage = null;


    @DataProvider(name = "login_credentials")
    public Object[][] data_provider() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        if (config.getEnvFromCurrentConfig().contains("test") || config.getEnvFromCurrentConfig().contains("ngdev")) {
            data = reader.getExcelDataForDataProvider("nevvon_test_env.xlsx", 0);
        } else if (config.getEnvFromCurrentConfig().contains("admin")) {
            data = reader.getExcelDataForDataProvider("nevvon_prod_env.xlsx", 0);
        }
        return data;
    }

    @DataProvider(name = "add_employee_to_agency")
    public Object[][] employee_agency_map() {
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 6);
    }

    @DataProvider(name = "edit_info")
    public Object[][] edit_emp_info() {
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 7);
    }

    @DataProvider(name = "edit_login_info")
    public Object[][] edit_login() {
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 8);
    }

    @DataProvider(name = "employee_new_data")
    public Object[][] new_employee_data() {
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 16);
    }

    @DataProvider(name = "employee_status_data")
    public Object[][] new_employee_status_data() {
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 17);
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_employees_name(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-7");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on employees name");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_message(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-8");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on message");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_message_button_is_present_on_page();
        employeeProfile.click_on_message_button();
        employeeProfile.verify_send_message_employee_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_the_content_of_the_message_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-94");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify the content of the message popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_message_button_is_present_on_page();
        employeeProfile.click_on_message_button();
        employeeProfile.verify_send_message_employee_header_is_present_on_page();
        employeeProfile.verify_first_name_is_present_on_page();
        employeeProfile.verify_last_name_is_present_on_page();
        employeeProfile.verify_cancel_button_is_present_on_page();
        employeeProfile.verify_send_button_is_present_on_page();
        employeeProfile.verify_cross_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cross_button_of_message_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-93");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cross button of message popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_message_button_is_present_on_page();
        employeeProfile.click_on_message_button();
        employeeProfile.verify_send_message_employee_header_is_present_on_page();
        employeeProfile.click_on_cross_button();
        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_message_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_employee(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-97");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button employee");


        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_message_button_is_present_on_page();
        employeeProfile.click_on_message_button();
        employeeProfile.verify_send_message_employee_header_is_present_on_page();
        employeeProfile.click_on_cancel_button();
        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_message_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_send_without_entering_any_text(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-9");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on send without entering any text");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_message_button_is_present_on_page();
        employeeProfile.click_on_message_button();
        employeeProfile.verify_send_message_employee_header_is_present_on_page();
        employeeProfile.click_on_send_button();
        employeeProfile.verify_message_require_error_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_send_after_entering_text(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-10");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on send after entering text");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_message_button_is_present_on_page();
        employeeProfile.click_on_message_button();
        employeeProfile.verify_send_message_employee_header_is_present_on_page();
        employeeProfile.enter_text_write_message_text_box("Testing");
        employeeProfile.click_on_send_button();
        employeeProfile.verify_message_sent_successfully_alert_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_edit_personal_info(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-11");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on edit personal info");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.verify_preferred_language_drop_down_is_present_on_page();
        employeeProfile.click_on_preferred_language_drop_down();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_find_country_code_and_edits_phone_number(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-14");
        Logger.log_qase_id("NEV-430");


        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when find country code and edits phone number");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.click_on_country_drop_down_button();
        employeeProfile.enter_text_country_code("+91");
        employeeProfile.select_country_name_with_country_code();
        employeeProfile.click_on_phone_number_text_box();
        TestData.random_numeric_string(8);
        employeeProfile.click_on_personal_info_update_button();
        //employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_email_address_in_personal_info(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-15");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when edits email address in personal info");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.mouse_hover_on_email_address();
        employeeProfile.verify_not_able_to_edit_the_email_address();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_language_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-455");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on language dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.click_on_preferred_language_drop_down();
        employeeProfile.select_language_from_the_dropdown();
        employeeProfile.click_on_personal_info_update_button();
        //employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_edit_birthday_from_calendar(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-189");
        Logger.log_qase_id("NEV-1002");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on edit birthday from calendar");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.click_on_calendar_icon_of_birthday_field();
//        employeeProfile.verify_calendar_popup_show();
//        TestData.get_todays_date();
//        //employeeProfile.select_birthday_date_in_calendar();
//        employeeProfile.click_on_personal_info_update_button();
//        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_first_name_and_last_name(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-12");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when edits first name and last name");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        filter = new filter(driver);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.verify_preferred_language_drop_down_is_present_on_page();

        employeeProfile.enter_text_employee_first_name("kiara");
        employeeProfile.enter_text_employee_last_name("Test");
        employeeProfile.click_on_personal_info_update_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_update_leaving_mandatory_fields_blank(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-23");
        Logger.log_qase_id("NEV-525");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on update leaving mandatory fields blank");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.remove_first_name();
        employeeProfile.remove_last_name();
        employeeProfile.remove_phone_number();
        employeeProfile.click_on_personal_info_update_button();

    }
//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_add_program_popup_Copy_icon(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NP-456");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on add program popup Copy icon");
//
//        login = new login_page(driver);
//        new_employees = new new_employees(driver);
//        employeeProfile = new employeeProfile(driver);
//        login.performLogin(userName, password);
//
//        new_employees.verify_employees_Option_is_present_on_page();
//        new_employees.click_on_employees_Option();
//        employeeProfile.verify_employee_name_is_present_on_page();
//        employeeProfile.click_on_employee_name();
//        employeeProfile.navigateToNewTab();
//
//        employeeProfile.verify_employee_name_header_is_present_on_page();
//        employeeProfile.verify_add_program_button_is_present_on_page();
//        employeeProfile.click_on_add_program_button();
//        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
//        employeeProfile.click_on_add_program_popup_copy_icon();
//        employeeProfile.Click_on_programs_dropdown();
//        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
//        employeeProfile.click_on_search_program_text_box();
//        employeeProfile.add_program_popup_paste_copy_message();
//        employeeProfile.verify_add_program_copy_message_display();
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_personal_info(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-13");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button personal info");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.verify_preferred_language_drop_down_is_present_on_page();
        employeeProfile.click_on_personal_info_cancel();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_edit_management_info(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-18");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on edit management info");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        employeeProfile.click_on_management_info_update_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_enter_string_in_employee_number_textbox(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1093");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when enter string in employee number textbox");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        employeeProfile.enter_management_info_employee_phone_number_as_string("Hellotest123");
        employeeProfile.click_on_management_info_update_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_Calendar_icon_next_to_the_employment_date(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-435");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on Calendar icon next to the employment date");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        employeeProfile.click_on_calendar_icon();
        employeeProfile.calendar_date_picker_popup_display();
        employeeProfile.click_on_management_info_update_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_employee_disciplines(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-20");
        Logger.log_qase_id("NEV-528");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when edits employee disciplines");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        employeeProfile.click_on_disciplines_dropdown_button();
        employeeProfile.verify_discipline_dropdown_list_present_on_page();
        employeeProfile.select_disciplines_in_dropdown_list();
        employeeProfile.click_on_management_info_update_button();
        //employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_location_from_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-21");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when edits location from dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        employeeProfile.click_on_location_dropdown_button();
        employeeProfile.verify_location_dropdown_list_present_on_page();
        employeeProfile.select_location_in_dropdown_list();
        employeeProfile.click_on_management_info_update_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_sub_location_from_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-22,TC_EF_055");


        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when edits sub location from dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        employeeProfile.click_on_location_dropdown_button();
        employeeProfile.verify_location_dropdown_list_present_on_page();
        employeeProfile.select_location_in_dropdown_list();
        employeeProfile.click_on_sub_location_dropdown_button();
        employeeProfile.verify_sub_location_dropdown_list_present_on_page();
        employeeProfile.select_sub_location_in_dropdown_list();
        employeeProfile.click_on_management_info_update_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_Training_Accessible_during_shift_check_box(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-431");
        Logger.log_qase_id("NEV-433");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on Training Accessible during shift check box");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        driver.navigate().refresh();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        //employeeProfile.click_on_Training_Accessible_During_Shift();
        //employeeProfile.confirm_popup_display();
        //employeeProfile.click_on_confirm_button();
        //employeeProfile.click_on_management_info_update_button();
        //employeeProfile.verify_accessible_during_shift_validation_msg();
        //employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void when_click_on_Training_Accessible_during_shift_popup_close_icon(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-529");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("when click on Training Accessible during shift popup close icon");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        //employeeProfile.click_on_Training_Accessible_During_Shift();
        //employeeProfile.confirm_popup_display();
        //employeeProfile.click_on_popup_close_icon();
        //employeeProfile.verify_employee_name_header_is_present_on_page();
    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_click_on_Cancel_button(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-432");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when click on Cancel button");
//
//        login = new login_page(driver);
//        new_employees = new new_employees(driver);
//        employeeProfile = new employeeProfile(driver);
//        login.performLogin(userName, password);
//
//        new_employees.verify_employees_Option_is_present_on_page();
//        new_employees.click_on_employees_Option();
//        employeeProfile.verify_employee_name_is_present_on_page();
//        employeeProfile.click_on_employee_name();
//        employeeProfile.navigateToNewTab();
//
//        employeeProfile.verify_employee_name_header_is_present_on_page();
//        employeeProfile.verify_management_info_edit_button_is_present_on_page();
//        employeeProfile.click_on_management_info_edit_button();
//        //employeeProfile.click_on_Training_Accessible_During_Shift();
//        //employeeProfile.confirm_popup_display();
//        //employeeProfile.click_on_confirm_popup_cancel_button();
//        //employeeProfile.verify_employee_name_header_is_present_on_page();
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Is_Applicant_checkbox_in_management_info(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-434");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on Is Applicant checkbox in management info");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        //employeeProfile.click_on_Is_Applicant_check_box_button();
        employeeProfile.click_on_management_info_update_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_saves_the_note_for_employee(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-89");


        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when saves the note for employee");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        try {
            employeeProfile.click_on_notes_edit_button();
        } catch (Exception e) {
            System.out.println(e);
        }

        employeeProfile.verify_notes_title_available();
        employeeProfile.enter_text_notes("Hello Nevvon");
        employeeProfile.click_on_save_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_the_saved_notes(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-362");
        Logger.log_qase_id("NEV-363");
        Logger.log_qase_id("NEV-530");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when edits the saved notes");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        try {
            employeeProfile.click_on_notes_edit_button();
        } catch (Exception e) {
            System.out.println(e);
        }
        //employeeProfile.click_on_notes_text_box();
        employeeProfile.enter_text_notes("Hello Nevvon");
        employeeProfile.click_on_save_button();
        employeeProfile.click_on_notes_edit_button();
        //employeeProfile.click_on_notes_text_box();
        employeeProfile.enter_text_edit_notes("Hello Nevvon new panel");
        employeeProfile.click_on_notes_update_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
        employeeProfile.click_on_notes_edit_button();
        //employeeProfile.click_on_notes_cancel_button();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_cancel_button_after_editing_note(String userName, String password, String agency_name) {

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cancel button after editing note");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        try {
            employeeProfile.click_on_notes_edit_button();
        } catch (Exception e) {
            System.out.println(e);
        }

        employeeProfile.enter_text_notes("Hello Nevvon");
        employeeProfile.click_on_save_button();
        employeeProfile.click_on_notes_edit_button();
        employeeProfile.click_on_notes_cancel_button();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Add_program_button_for_online_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-81");
        Logger.log_qase_id("NEV-92");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on Add program button for online program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.select_on_online_program_button();
        employeeProfile.verify_online_program_details_present();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_adds_program_to_the_inactive_employee(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-91");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when adds program to the inactive employee");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_terminated_option();
        employeeProfile.verify_add_program_button_is_present_on_page();

        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();

        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_Custom_start_date_option();
        employeeProfile.verify_display_custom_start_date_calendar_option();
        employeeProfile.click_on_start_custom_date_picker_calendar_icon();
        employeeProfile.calendar_start_date_picker_popup_display();

        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_Custom_due_date_option();
        employeeProfile.verify_display_custom_due_date_calendar_option();
        employeeProfile.click_on_due_custom_date_picker_calendar_icon();
        employeeProfile.calendar_due_date_picker_popup_display();

        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_inactive_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_session_drop_down(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-531");
        Logger.log_qase_id("NEV-533");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on session drop down");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();

        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_active_option();

        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.select_on_In_class_program__button();
        employeeProfile.verify_In_class_program_details_present();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_session_program_from_the_dropdown();
        employeeProfile.Click_on_session_dropdown();
        employeeProfile.verify_display_list_of_session();
        employeeProfile.select_session_from_the_dropdown();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_session_dropdown_without_selecting_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-532");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when click on session dropdown without selecting program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.select_on_In_class_program__button();
        employeeProfile.verify_In_class_program_details_present();

        employeeProfile.Click_on_session_dropdown();
        //employeeProfile.verify_display_select_program_first();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_create_new_session_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-534");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on create new session button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.select_on_In_class_program__button();
        employeeProfile.verify_In_class_program_details_present();


        employeeProfile.Click_on_session_dropdown();
        employeeProfile.verify_display_create_new_session();
        employeeProfile.click_on_create_new_session();
        employeeProfile.verify_create_new_session_details();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_create_session_and_add_remove_new_field(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-535");
        Logger.log_qase_id("NEV-536");
        Logger.log_qase_id("NEV-537");
        Logger.log_qase_id("NEV-538");
        Logger.log_qase_id("NEV-539");
        Logger.log_qase_id("NEV-542");

//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when create session and add remove new field");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.select_on_In_class_program__button();
        employeeProfile.verify_In_class_program_details_present();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_session_program_from_the_dropdown();
        employeeProfile.Click_on_session_dropdown();
        employeeProfile.verify_display_create_new_session();
        employeeProfile.click_on_create_new_session();
        employeeProfile.verify_create_new_session_details();
        employeeProfile.text_enter_session_name("testing1");
        employeeProfile.text_enter_session_Supervisor("QA");
        employeeProfile.session_schedule_click_on_calendar_icon();
        employeeProfile.verify_session_schedule_calendar_popup_display();
        employeeProfile.select_scheduled_from_calendar();
        employeeProfile.click_on_Add_field();
        employeeProfile.text_enter_new_field_name("WebApp");
        employeeProfile.text_enter_new_field_value("functional");
        employeeProfile.click_on_Add_field();
        employeeProfile.click_on_delete_icon();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_new_session_successfully_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_In_class_program_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-82");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on In class program button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();


        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.select_on_In_class_program__button();
        employeeProfile.verify_In_class_program_details_present();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_search_program_name_in_program_search_box(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-44");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when search program name in program search box");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.click_on_search_program_text_box();
        employeeProfile.enter_text_program_name("rise test");
        employeeProfile.click_on_search_program_name();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_employee_number(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-18");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when edits employee number");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_management_info_edit_button_is_present_on_page();
        employeeProfile.click_on_management_info_edit_button();
        employeeProfile.click_on_management_employee_number_text_box();
        TestData.random_numeric_string(10);
        employeeProfile.click_on_management_info_update_button();
        employeeProfile.verify_info_edited_successfully_alert_msg_is_present_on_page();
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Add_to_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-24");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Add to program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_the_content_on_Add_employees_program_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-25");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify the content on Add employees program popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_content_of_add_employees_program_popup();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enters_already_registered_phone_number(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-16");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when enters already registered phone number");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.enter_text_employee_phone("1234567891");
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enters_less_digits_than_the_required_as_per_country_code_in_phone_number_field(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-17");
        Logger.log_qase_id("NEV-526");
        Logger.log_qase_id("NEV-527");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when enters less digits than the required as per country code in phone number field");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.enter_text_employee_phone("123@4 A");
        employeeProfile.click_on_personal_info_update_button();
        employeeProfile.verify_phone_number_validation_msg_show();
    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_help_icon(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NP-26");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on help icon");
//
//        login = new login_page(driver);
//        new_employees = new new_employees(driver);
//        employeeProfile = new employeeProfile(driver);
//        login.performLogin(userName, password);
//
//        new_employees.verify_employees_Option_is_present_on_page();
//        new_employees.click_on_employees_Option();
//        employeeProfile.verify_employee_name_is_present_on_page();
//        employeeProfile.click_on_employee_name();
//        employeeProfile.navigateToNewTab();
//
//        employeeProfile.verify_employee_name_header_is_present_on_page();
//        employeeProfile.verify_add_program_button_is_present_on_page();
//        employeeProfile.click_on_add_program_button();
//        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
//        employeeProfile.verify_help_icon_is_present_on_page();
//
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_programs_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-27");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on programs dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-28");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on start date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-34");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on due date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_custom_date_from_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-36");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Custom date from due date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();

        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_Custom_start_date_option();
        //employeeProfile.verify_display_custom_start_date_calendar_option();
        employeeProfile.click_on_start_custom_date_picker_calendar_icon();
        employeeProfile.calendar_start_date_picker_popup_display();

        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_Custom_due_date_option();
        employeeProfile.verify_display_custom_due_date_calendar_option();
        employeeProfile.click_on_due_custom_date_picker_calendar_icon();
        employeeProfile.calendar_due_date_picker_popup_display();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_custom_date_from_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-30");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Custom date from start date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_Custom_start_date_option();
        employeeProfile.verify_display_custom_start_date_calendar_option();
        employeeProfile.click_on_start_custom_date_picker_calendar_icon();
        employeeProfile.calendar_start_date_picker_popup_display();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_anniversary_date_from_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-31");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on anniversary date from start date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_start_date_anniversary_date_option();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_Custom_due_date_option();
        employeeProfile.verify_display_custom_due_date_calendar_option();
        employeeProfile.click_on_due_custom_date_picker_calendar_icon();
        employeeProfile.calendar_due_date_picker_popup_display();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_anniversary_month_from_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-32");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on anniversary month from start date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_start_date_anniversary_month_option();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();

    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_Copy_icon(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NP-454");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on Copy icon");
//
//        login = new login_page(driver);
//        new_employees = new new_employees(driver);
//        employeeProfile = new employeeProfile(driver);
//        login.performLogin(userName, password);
//
//        new_employees.verify_employees_Option_is_present_on_page();
//        new_employees.click_on_employees_Option();
//        employeeProfile.verify_employee_name_is_present_on_page();
//        employeeProfile.click_on_employee_name();
//        employeeProfile.navigateToNewTab();
//
//        employeeProfile.verify_employee_name_header_is_present_on_page();
//        employeeProfile.verify_message_button_is_present_on_page();
//        employeeProfile.click_on_message_button();
//        employeeProfile.verify_send_message_employee_header_is_present_on_page();
//        employeeProfile.click_on_send_message_popup_copy_icon();
//        employeeProfile.click_on_message_text_box();
//        employeeProfile.paste_message();
//        //employeeProfile.verify_copy_message_display();
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_First_and_last_name_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-95");
        Logger.log_qase_id("NEV-96");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on First and last name button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_message_button_is_present_on_page();
        employeeProfile.click_on_message_button();
        employeeProfile.verify_send_message_employee_header_is_present_on_page();
        employeeProfile.click_on_first_name_button();
        employeeProfile.click_on_last_name_button();
        employeeProfile.click_on_send_button();
        employeeProfile.verify_message_sent_successfully_validation_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_actions_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-399");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on actions button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Active(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-437");
        Logger.log_qase_id("NEV-436");


        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Active");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_active_option();
        employeeProfile.verify_successfully_validation_msg_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_hold_option(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-438");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on hold option");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_on_hold_option();
        employeeProfile.verify_successfully_validation_msg_present_on_page();

        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_active_option();
        //employeeProfile.verify_successfully_validation_msg_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_terminated_option(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-439");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks terminated option");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_terminated_option();
        employeeProfile.verify_successfully_validation_msg_present_on_page();

        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_active_option();
        //employeeProfile.verify_successfully_validation_msg_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_hover_mouse_on_Reset_password(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-440");
        Logger.log_qase_id("NEV-443");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when hover mouse on Reset password");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);
        filter = new filter(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.click_on_search_box_of_program_page_to_search();
        employeeProfile.enter_text_at_search_button_employee_profile("Ziva Patel");

        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_reset_password_option();
        employeeProfile.verify_reset_password_option_present_on_page();
        employeeProfile.click_on_reset_password_SMS_option();
        employeeProfile.verify_change_password_popup_is_present_on_page();
        employeeProfile.click_on_change_password_popup_cancel_button();
        employeeProfile.verify_employee_name_header_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Send_for_Send_SMS(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-444");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Send for Send SMS");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);
        filter = new filter(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.click_on_search_box_of_program_page_to_search();
        employeeProfile.enter_text_at_search_button_employee_profile("Ziva Patel");

        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();

        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_reset_password_option();
        employeeProfile.verify_reset_password_option_present_on_page();
        employeeProfile.click_on_reset_password_SMS_option();
        employeeProfile.verify_change_password_popup_is_present_on_page();

        program_page.click_on_send_button_of_the_pop_up();
        employeeProfile.verify_SMS_sent_message_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Send_for_send_Email(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-549");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Send for Send Email");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);
        filter = new filter(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.click_on_search_box_of_program_page_to_search();
        employeeProfile.enter_text_at_search_button_employee_profile("Ziva Patel");

        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();

        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_reset_password_option();
        employeeProfile.verify_reset_password_option_present_on_page();
        employeeProfile.click_on_reset_password_Email_option();
        program_page.verify_send_email_to_change_password_pop_up_is_present();

        program_page.click_on_send_button_of_the_pop_up();
        employeeProfile.verify_email_sent_message_present_on_page();


    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Employee_History(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-340");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Employee History");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();

        employeeProfile.click_on_Employee_History_option();
        employeeProfile.verify_Employee_History_popup_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_open_ticket(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-445");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on open ticket");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_open_ticket_option();
        //employeeProfile.verify_agency_form_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_submit_without_entering_any_text(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-446");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on submit without entering any text");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_open_ticket_option();
        //employeeProfile.click_on_form_submit_button();
        //employeeProfile.verify_required_field_validation_msg_present();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Copy_API_ID(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-448");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on Copy API ID");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();


        employeeProfile.click_on_Copy_API_ID_option();
        employeeProfile.verify_copied_validation_msg_present();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Custom_duration_from_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-38");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Custom duration from due date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_start_date_today_option();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_Custom_duration_option();
        employeeProfile.verify_display_custom_duration_selection_option_present();
        employeeProfile.click_on_upward_dropdown();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_submit_button_without_entering_days_in_custom_duration(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-39");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks submit button without entering days in custom duration");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_Custom_duration_option();
        employeeProfile.verify_display_custom_duration_selection_option_present();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_start_date_mandatory_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_submit_after_entering_valid_necessary_details(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-40");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks submit after entering valid necessary details");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_due_date_31st_option();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_submit_without_entering_date_in_custom_date(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-37");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on submit without entering date in custom date");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_Custom_due_date_option();
        employeeProfile.clicks_on_submit_without_entering_date_in_custom_date();
        employeeProfile.verify_due_date_validation_message_displayed();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_submit_without_selecting_any_program(String userName, String password, String zagency_name) {
        Logger.log_qase_id("NEV-42");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on submit without selecting any program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Clicks_on_submit_without_selecting_any_program();
        employeeProfile.verify_Program_is_required_validation_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_more_than_one_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-43");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on more than one program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();


        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Clicks_on_submit_without_selecting_any_program();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_close_icon_on_the_top(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-83");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on close icon on the top");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.click_on_close_icon_button();
        employeeProfile.add_employee_program_popup_disappears_and_redirect_to_employee_profile_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_selects_already_added_program_from_programs_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-84");
        Logger.log_qase_id("NEV-33");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when selects already added program from programs dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_due_date_1_year_from_start_option();
        employeeProfile.click_on_add_program_submit_button();
        // employeeProfile.verify_Provider_already_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_December_31st_option_from_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-35");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on December 31st option from due date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        filter = new filter(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_due_date_31st_option();
        employeeProfile.click_on_add_program_submit_button();
        //employeeProfile.verify_Provider_already_added_to_Program_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_today_from_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-29");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on today from start date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.select_today_option_in_start_date_dropdown();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_add_employee_program_popup_cancel_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-41");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on add employee program popup cancel button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.click_on_cancle_button();
        employeeProfile.add_employee_program_popup_disappears_and_redirect_to_employee_profile_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_Edit_start_date(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1007");
        Logger.log_qase_id("NEV-1038");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when edits Edit start date");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);
        filter = new filter(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.click_on_search_box_of_program_page_to_search();
        employeeProfile.enter_text_at_search_button_employee_profile("viana");

        //employeeProfile.verify_employee_name_is_present_on_page();

        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();

//        employeeProfile.verify_add_program_button_is_present_on_page();
//        employeeProfile.click_on_add_program_button();
//        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
//        employeeProfile.Click_on_programs_dropdown();
//        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
//        employeeProfile.select_program_from_the_dropdown();
//
//        employeeProfile.Click_on_start_date_dropdown();
//        employeeProfile.verify_display_list_of_start_date_option();
//        employeeProfile.select_today_option_in_start_date_dropdown();

        employeeProfile.click_on_employee_added_program_kebab_icon_button();
        employeeProfile.verify_edit_start_date_option_on_employee_profile_page();
        employeeProfile.click_on_Edit_start_date_option();
        employeeProfile.verify_Edit_start_date_pop_up_present_on_page();
        employeeProfile.click_on_Edit_start_date_dropdown_button();
        employeeProfile.verify_start_date_edit_option_present_on_page();
        employeeProfile.click_on_Today_option_available_in_edit_start_date_dropdown();
        employeeProfile.click_on_update_button_of_edit_start_date_popup();
        employeeProfile.verify_edit_start_date_successfully_validation_msg();
        employeeProfile.verify_edited_start_date_display_on_program_start_date();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Remove_action(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1010");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Remove action");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);
        filter = new filter(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.click_on_search_box_of_program_page_to_search();
        employeeProfile.enter_text_at_search_button_employee_profile("Ziva Patel");

        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();

        employeeProfile.click_on_employee_added_program_kebab_icon_button();
        employeeProfile.verify_edit_start_date_option_on_employee_profile_page();
//        employeeProfile.click_on_remove_option();
//        employeeProfile.verify_remove_employee_pop_up_present_on_page();
//        //employeeProfile.click_on_permanently_remove_program_check_box_button();
//
//        employeeProfile.click_on_remove_button();
        //employeeProfile.verify_remove_program_successfully_validation_msg();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_the_newly_added_program_appears_in_the_program_list(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-85");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify the newly added program appears in the program list");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_add_program_button_is_present_on_page();
        employeeProfile.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_start_date_anniversary_month_option();

        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_added_to_Program_validation_msg_display();

        //employeeProfile.verify_newly_added_program_available_on_program_profile_page();
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_edit_the_due_date_of_incomplete_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-86");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on edit the due date of incomplete program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.click_on_employee_added_program_kebab_icon_button();
        employeeProfile.verify_edit_due_date_button_on_page();
        employeeProfile.click_on_edit_due_date_button();
        employeeProfile.verify_edit_due_date_header_on_page();
        employeeProfile.verify_edit_due_date_drop_down_on_page();
        employeeProfile.click_on_edit_due_date_drop_down();
        employeeProfile.verify_custom_date_edit_date_on_page();
        employeeProfile.click_on_custom_date_edit_date();
        employeeProfile.verify_due_date_due_date_choose_date_on_page();
        employeeProfile.click_on_due_date_due_date_choose_date();
        employeeProfile.calendar_due_date_picker_popup_display();
        employeeProfile.verify_due_date_confirm_edit_due_date_on_page();
        employeeProfile.click_on_due_date_confirm_edit_due_date();
        employeeProfile.verify_provider_course_modified_alert_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_edit_the_start_date_of_incomplete_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-90");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on edit the start date of incomplete program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();

        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_dropdown_option_present();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_active_option();

        employeeProfile.verify_start_date_confirm_edit_due_date_on_page();
        employeeProfile.click_on_start_date_confirm_edit_due_date();
        employeeProfile.verify_edit_due_start_header_on_page();
        employeeProfile.verify_edit_due_date_drop_down_on_page();
        employeeProfile.click_on_edit_due_date_drop_down();
        employeeProfile.verify_custom_edit_date_on_page();
        employeeProfile.click_on_custom_edit_date();
        employeeProfile.verify_choose_text_box_start_date_on_page();
        employeeProfile.click_on_choose_text_box_start_date();
        employeeProfile.calendar_due_date_picker_popup_display();
        employeeProfile.verify_start_date_confirm_edit_date_on_page();
        employeeProfile.click_on_start_date_confirm_edit_date();
        employeeProfile.verify_provider_course_modified_alert_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Open_ticket_employee_profile(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-445");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Open ticket employee profile");


        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.click_on_open_ticket_option();
        employeeProfile.navigateToNewSecondTab();
        employeeProfile.verify_submit_button_on_open_ticket_option_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_entering_text_in_form_page_of_open_ticket_employee_profile(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-447");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when entering text in form page of open ticket");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_action_dropdown_button_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.click_on_open_ticket_option();
        employeeProfile.navigateToNewSecondTab();
        employeeProfile.verify_submit_button_on_open_ticket_option_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_Edit_due_date_program_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1008");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when edits Edit due date program page");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_more_option_due_date_employee_on_page();
        employeeProfile.click_on_more_option_due_date_employee();
        employeeProfile.click_on_edit_due_date_option_program();
        employeeProfile.verify_edit_due_date_header_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_Edit_start_date_program_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1020");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when edits Edit start date program page");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_more_option_due_date_employee_on_page();
        employeeProfile.click_on_more_option_due_date_employee();
        employeeProfile.verify_edit_start_date_option_program_on_page();
        employeeProfile.click_on_edit_start_date_option_program();
        employeeProfile.verify_edit_due_start_header_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_start_date_due_date_for_program_is_100_completed(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1011");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when edits start date due date for program is 100% completed");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        filter = new filter(driver);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        //employeeProfile.verify_employee_name_header_is_present_on_page();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.click_on_search_box_of_program_page_to_search();
        employeeProfile.enter_text_at_search_button_employee_profile("Ziva Patel");

        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_newly_added_program_available_on_program_profile_page();
        employeeProfile.verify_100_completed_program();
        employeeProfile.verify_edit_start_date_and_due_date_option_is_enable();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Download_Certificate_on_completed_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1012");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Download Certificate on completed program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        filter = new filter(driver);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        //employeeProfile.verify_employee_name_header_is_present_on_page();


        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.click_on_search_box_of_program_page_to_search();
        employeeProfile.enter_text_at_search_button_employee_profile("Ziva Patel");

        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_corona_care_program_is_present();
        employeeProfile.click_on_corona_care_program_kebab_icon_button();
        employeeProfile.verify_download_certificate_option_present_on_page();
        employeeProfile.click_on_download_certificate_option();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Send_certificates(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1013");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Send certificates");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        filter = new filter(driver);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        //employeeProfile.verify_employee_name_header_is_present_on_page();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.click_on_search_box_of_program_page_to_search();
        employeeProfile.enter_text_at_search_button_employee_profile("Ziva Patel");

        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_corona_care_program_is_present();
        employeeProfile.click_on_corona_care_program_kebab_icon_button();
        employeeProfile.verify_send_certificate_option_present_on_page();
        employeeProfile.click_on_send_certificate_option();
        //employeeProfile.verify_email_send_certificate_successfully_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_adding_program_to_the_on_hold_employee(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1500");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when adding program to the on hold employee");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        filter = new filter(driver);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_on_hold_option();
        program_page.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_validation_msg_displayed();
        employeeProfile.click_on_cancle_button();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_active_option();
//        employeeProfile.verify_successfully_validation_msg_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_adding_program_to_the_Terminated_employee(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-91");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when adding program to the Terminated employee");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);
        filter = new filter(driver);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_on_terminated_option();
        employeeProfile.verify_add_program_button_is_present_on_page();
        program_page.click_on_add_program_button();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_validation_msg_displayed_for_terminated();
        employeeProfile.click_on_cancle_button();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.click_on_set_status_on_option();
        employeeProfile.click_on_active_option();
        //employeeProfile.verify_successfully_validation_msg_present_on_page();
    }

    /**
     * CS Panel tests of employee profile
     */

    @Test(dataProvider = "add_employee_to_agency")
    public void to_verify_when_adding_employee_to_agency(String username, String password, String employeeName, String agencyName) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        employeeProfile.click_on_add_to_agency_button();
        employeeProfile.search_agency_to_add_employee(agencyName);
        employeeProfile.click_on_searched_agency();
        employeeProfile.add_employee_to_agency();
        employeeProfile.verify_employee_added_successfully_to_agency(agencyName);
    }

    @Test(dataProvider = "edit_info")
    public void to_verify_csuser_can_edit_agency_p_record(String username, String password, String employeeName, String firstName, String lastName) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        employeeProfile.edit_and_verify_employee_nevvon_info(firstName, lastName);
        employeeProfile.revert_nevvon_info();
    }

    @Test(dataProvider = "edit_login_info")
    public void to_verify_csuser_can_edit_employee_login_info(String username, String password, String employeeName, String phoneNumber, String email) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        employeeProfile.edit_and_verify_login_info(email);
        employeeProfile.revert_login_info();
    }

    @Test(dataProvider = "employee_data", dataProviderClass = commonDataProvider.class)
    public void to_verify_the_actions_dropdown_on_employee_profile_with_CS_user_login(String username, String password, String employeeName) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        String agency = employeeProfile.get_agency_tab_name();
        employeeProfile.click_on_specific_agency(agency);
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_action_options_for_cs_user_on_employee_profile();
    }

    @Test(dataProvider = "employee_new_data")
    public void to_verify_cs_user_can_not_update_login_info_until_employee_will_sign_up(String username, String password, String employeeName, String tabname) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        dashboardPage = new dashboard_page(driver);
        new_employees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        employeeProfile.verify_csuser_on_employee_profile_page(employeeName);
        String agency = employeeProfile.get_agency_tab_name();
        employeeProfile.click_on_specific_agency(agency);
        employeeProfile.click_on_login_info_edit_button();
        employeeProfile.verify_phone_and_email_is_disabled();
    }

    @Test(dataProvider = "employee_new_data")
    public void to_verify_employee_sign_up_button_should_be_enabled_and_login_button_should_be_disabled_for_new_employee(String username, String password, String employeeName, String tabName) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        String agency = employeeProfile.get_agency_tab_name();
        employeeProfile.click_on_specific_agency(agency);
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_employee_sign_up_button_is_enabled_and_login_button_is_disabled();
    }

    @Test(dataProvider = "employee_new_data")
    public void to_verify_generate_verification_code_as_cs_user(String username, String password, String employeeName, String tabName) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        String agency = employeeProfile.get_agency_tab_name();
        employeeProfile.click_on_specific_agency(agency);
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.click_on_generate_verification_code_option();
        employeeProfile.verify_dialog_box_for_employee(employeeName);
        employeeProfile.click_on_generate_code_button_from_dialog_box();
        employeeProfile.verify_code_is_generated();
        employeeProfile.click_on_done_button_from_dialog_box();
    }

    @Test(dataProvider = "employee_new_data")
    public void to_verify_cs_user_should_be_on_agencies_tab_on_employee_profile_when_navigating_to_employee_profile_from_cs_panel_employees_tab(String username, String password, String employeeName, String tabName) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        employeeProfile.verify_tab_on_focus(tabName);
    }

    @Test(dataProvider = "employee_new_data")
    public void to_verify_user_navigate_to_agency_dashboard_page_from_employee_profile_page(String username, String password, String employeeName, String tabName) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        String agency = employeeProfile.get_agency_tab_name();
        employeeProfile.click_on_specific_agency(agency);
        employeeProfile.click_on_dashboard_navigation_icon_link();
        dashboardPage.verify_dashboard_page();
    }

    @Test(dataProvider = "employee_status_data")
    public void to_verify_new_employee_sign_up_button_should_be_disable_if_status_is_terminated(String username, String password, String employeeName, String status, String status1) {
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeProfile = new employeeProfile(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        dashboardPage = new dashboard_page(driver);
        employeeAction = new employee_action(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
        String agency = employeeProfile.get_agency_tab_name();
        employeeProfile.click_on_specific_agency(agency);
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_employee_sign_up_button_is_enabled_and_login_button_is_disabled();
        employeeAction.hover_on_set_status();
        employeeProfile.select_status(status);
        employeeProfile.verify_status_of_employee(status);
        employeeProfile.click_on_action_dropdown_button();
        employeeProfile.verify_employee_sign_up_button_is_disabled();
        employeeAction.hover_on_set_status();
        employeeProfile.select_status(status1);
        employeeProfile.verify_status_of_employee(status1);
    }
}
