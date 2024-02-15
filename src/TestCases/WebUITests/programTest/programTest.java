package WebUITests.programTest;

import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.csHomePage.csHome_page;
import web.object_repository.csdashboard.dashboard_page;
import web.object_repository.login.login_page;
import web.object_repository.newEmployeesPage.new_employees;
import web.object_repository.program.program_page;
import web.object_repository.scheduledReportsPage.scheduled_reports;
import web.object_repository.filterPage.filter;
import web.object_repository.employeeProfilePage.employeeProfile;
import web.object_repository.employeeActionPage.employee_action;
import web.object_repository.csSessionPage.csSession_page;

public class programTest extends base {

    login_page login = null;
    scheduled_reports scheduled_reports = null;
    program_page program_page = null;
    filter filter = null;
    employeeProfile employeeProfile = null;
    employee_action employee_action = null;
    csHome_page csHome = null;
    dashboard_page dashboardPage = null;
    new_employees newEmployees = null;
    csSession_page sessionPage = null;

    employee_action employeeAction = null;

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

//    @DataProvider(name = "login_credentials")
//    public Object[][] login_credentials_provider(){
//        DataReader reader = new DataReader();
//        Object[][] data = null;
//        data = reader.getExcelDataForDataProvider("csData.xlsx", 18);
//        return data;
//    }
//
//    @DataProvider(name = "login_credentials")
//    public Object[][] in_class_errors_data_provider(){
//        DataReader reader = new DataReader();
//        Object[][] data = null;
//        data = reader.getExcelDataForDataProvider("csData.xlsx", 19);
//        return data;
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_any_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-334");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on any program");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_any_saved_views(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-337");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on any saved views");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.click_on_save_filter();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_Add_to_program_option_is_available_under_actions_menu(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-344");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify Add to program option is available under actions menu");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();

        program_page.click_on_first_program();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_add_program_option_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_actions_after_selecting_employees(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-706");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on actions after selecting employees");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();

        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_without_selecting_employee_action_option_disable();
        program_page.click_on_employee_profile_header_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.verify_add_program_option_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_Download_certificates_option_is_available_under_actions_menu(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-343");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify Download certificates option is available under actions menu");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_download_certificates_option_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_Message_option_is_available_under_actions_menu(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-342");
        Logger.log_qase_id("NEV-757");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify Message option is available under Actions menu");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.verify_message_option_is_present_on_page();
        program_page.click_on_message_option();
        program_page.verify_send_message_popup_display_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_click_on_cancel_button_available_on_Message_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-761");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify click on cancel button available on Message popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.verify_message_option_is_present_on_page();
        program_page.click_on_message_option();
        program_page.verify_send_message_popup_display_on_page();
        program_page.click_on_cancel_button_of_message_popup();
        program_page.verify_action_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_close_icon_button_of_message_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-764");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on close icon button of message popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.verify_message_option_is_present_on_page();
        program_page.click_on_message_option();
        program_page.verify_send_message_popup_display_on_page();

        employeeProfile.click_on_cross_button();
        program_page.verify_action_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_message_popup_copy_icon(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-758");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on message popup copy icon");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.verify_message_option_is_present_on_page();
        program_page.click_on_message_option();
        program_page.verify_send_message_popup_display_on_page();

        employeeProfile.click_on_send_message_popup_copy_icon();
        employeeProfile.click_on_message_text_box();
        employeeProfile.paste_message();
        employeeProfile.verify_copy_message_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_if_clicks_on_send_button_without_entering_any_text_in_text_area(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-762");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify if clicks on send button without entering any text in text area");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.verify_message_option_is_present_on_page();
        program_page.click_on_message_option();
        program_page.verify_send_message_popup_display_on_page();

        employeeProfile.click_on_send_button();
        employeeProfile.verify_message_require_error_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_send_with_entering_message(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-763");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on send with entering message");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.verify_message_option_is_present_on_page();
        program_page.click_on_message_option();
        program_page.verify_send_message_popup_display_on_page();

        employeeProfile.enter_text_write_message_text_box("Testing");
        employeeProfile.click_on_send_button();

        employeeProfile.verify_message_sent_successfully_validation_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_first_name_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-759");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on first name button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.verify_message_option_is_present_on_page();
        program_page.click_on_message_option();
        program_page.verify_send_message_popup_display_on_page();

        employeeProfile.click_on_first_name_button();
        employeeProfile.click_on_send_button();
        //employeeProfile.verify_message_sent_successfully_validation_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_last_name_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-760");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on last name button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.verify_message_option_is_present_on_page();
        program_page.click_on_message_option();
        program_page.verify_send_message_popup_display_on_page();

        employeeProfile.click_on_last_name_button();
        employeeProfile.click_on_send_button();
        employeeProfile.verify_message_sent_successfully_validation_display();

    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_Approve_employees_option_is_available_under_actions_menu(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NP-341");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("To verify Approve employees option is available under Actions menu");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        program_page.verify_save_filter_program_is_present_on_page();
//        program_page.verify_action_button_is_present_on_page();
//        program_page.click_on_action_button();
//        program_page.verify_approve_employees_option_is_present_on_page();
//
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_Remove_from_program_option_is_available_under_actions_menu(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-345");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify Remove from program option is available under actions menu");


        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_remove_from_program_option_is_present_on_page();
    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_Deactivate_in_program_option_is_available_under_actions_menu(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NP-346");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify Deactivate in program option is available under actions menu");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        program_page.verify_save_filter_program_is_present_on_page();
//        program_page.verify_action_button_is_present_on_page();
//        program_page.click_on_action_button();
//        program_page.verify_deactivate_in_program_option_is_present_on_page();
//    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_Activate_in_program_option_is_available_under_actions_menu(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NP-347");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify Activate in program option is available under actions menu");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        program_page.verify_save_filter_program_is_present_on_page();
//        program_page.verify_action_button_is_present_on_page();
//        program_page.click_on_action_button();
//        program_page.verify_activate_in_program_option_option_is_present_on_page();
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_customize_columns_popup_should_appear(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-349");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on customize columns popup should appear");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_customize_columns_in_program_option_is_present_on_page();
        program_page.click_on_customize_columns_in_program_option();
        program_page.verify_customize_columns_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_cancel_button_of_customize_columns_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1057");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on cancel button of customize columns popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_customize_columns_in_program_option_is_present_on_page();
        program_page.click_on_customize_columns_in_program_option();
        program_page.verify_customize_columns_header_is_present_on_page();
        program_page.click_on_cancel_button_of_customize_columns_popup();
        program_page.verify_program_profile_page_display();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_close_icon_from_customize_columns_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-803");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on close icon from customize columns popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_customize_columns_in_program_option_is_present_on_page();
        program_page.click_on_customize_columns_in_program_option();
        program_page.verify_customize_columns_header_is_present_on_page();
        program_page.click_on_close_button_of_customize_columns_popup();
        program_page.verify_program_profile_page_display();
    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_the_checkbox_to_unselect_and_save_the_toast_message_changes_saved_successfully_appears(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-350");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on the checkbox to unselect and save the toast message changes saved successfully appears");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_customize_columns_in_program_option_is_present_on_page();
        program_page.click_on_customize_columns_in_program_option();
        program_page.verify_customize_columns_header_is_present_on_page();
        program_page.click_on_second_checkbox_customize_column_pop_up();
        program_page.click_on_save_customize_columns();
        program_page.verify_changes_saved_successfully_alert_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_the_checkbox_to_select_and_save_the_toast_message_changes_saved_successfully_appears(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-351");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on the checkbox to select and save, the toast message changes saved successfully appears");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_customize_columns_in_program_option_is_present_on_page();
        program_page.click_on_customize_columns_in_program_option();
        program_page.verify_customize_columns_header_is_present_on_page();
        program_page.click_on_second_checkbox_customize_column_pop_up();
        program_page.click_on_save_customize_columns();
        program_page.verify_changes_saved_successfully_alert_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_columns_gets_modified_as_per_the_changes_made(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-352");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify columns gets modified as per the changes made");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_customize_columns_in_program_option_is_present_on_page();
        program_page.click_on_customize_columns_in_program_option();
        program_page.verify_customize_columns_header_is_present_on_page();
        program_page.click_on_second_checkbox_customize_column_pop_up();
        program_page.click_on_save_customize_columns();
        program_page.verify_changes_saved_successfully_alert_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_that_total_8_options_are_available_under_actions_menu(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-348");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify that total 8 options are available under actions menu");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_add_program_option_is_present_on_page();
        program_page.verify_download_certificates_option_is_present_on_page();
        program_page.verify_message_option_is_present_on_page();
        program_page.verify_send_certificates_drop_down_option_is_present_on_page();
        program_page.verify_edit_start_date_action_drop_down_option_is_present_on_page();
        program_page.verify_edit_due_date_action_drop_down_option_is_present_on_page();

        program_page.verify_remove_from_program_option_is_present_on_page();
        program_page.verify_customize_columns_in_program_option_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Edit_Start_Date_option_in_program_action_menu(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-770");
        Logger.log_qase_id("NEV-772");
        Logger.log_qase_id("NEV-1054");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Edit Start Date option in program action menu");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("zara");

        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_start_date_action_drop_down_option_is_present_on_page();
        program_page.click_on_edit_start_date_in_program_action_menu();
        program_page.verify_edit_start_date_in_program_pop_up_header();

        employeeProfile.click_on_Edit_start_date_dropdown_button();
        employeeProfile.verify_start_date_edit_option_present_on_page();
        employeeProfile.click_on_Today_option_available_in_edit_start_date_dropdown();
        employeeProfile.click_on_update_button_of_edit_start_date_popup();
        program_page.verify_edited_start_date_successfully_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_Today_date_option_in_Due_date_drop_down(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-786");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select Today date option in Due date drop down");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_program_profile_page_display();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_due_date_action_drop_down_option_is_present_on_page();
        program_page.edit_due_date_dropdown_option_option();
        program_page.verify_edit_due_date_in_program_pop_up_header();

        employeeProfile.click_on_Edit_start_date_dropdown_button();
        employeeProfile.verify_start_date_edit_option_present_on_page();
        employeeProfile.click_on_Today_option_available_in_edit_start_date_dropdown();

        employeeProfile.click_on_update_button_of_edit_start_date_popup();
        program_page.verify_edited_start_date_successfully_validation_msg();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_Custom_option_in_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-795");
        Logger.log_qase_id("NEV-797");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select Custom option in due date dropdown");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_program_profile_page_display();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_due_date_action_drop_down_option_is_present_on_page();
        program_page.edit_due_date_dropdown_option_option();
        program_page.verify_edit_due_date_in_program_pop_up_header();

        employeeProfile.click_on_Edit_start_date_dropdown_button();
        employeeProfile.verify_start_date_edit_option_present_on_page();

        program_page.click_on_custom_option_edit_due_date_popup();
        program_page.click_on_start_custom_date_picker_calendar_icon();
        program_page.calendar_start_date_picker_popup_display();

        employeeProfile.click_on_update_button_of_edit_start_date_popup();
        program_page.verify_edited_start_date_successfully_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_without_selecting_due_custom_date_and_clicks_on_update_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-796");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify without selecting due custom date and clicks on update button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_program_profile_page_display();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_due_date_action_drop_down_option_is_present_on_page();
        program_page.edit_due_date_dropdown_option_option();
        program_page.verify_edit_due_date_in_program_pop_up_header();

        employeeProfile.click_on_Edit_start_date_dropdown_button();
        employeeProfile.verify_start_date_edit_option_present_on_page();

        program_page.click_on_custom_option_edit_due_date_popup();

        employeeProfile.click_on_update_button_of_edit_start_date_popup();
        program_page.verify_due_date_required_validation_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_Custom_option_in_edit_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-777");
        Logger.log_qase_id("NEV-1059");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select Custom option in edit start date dropdown");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_start_date_action_drop_down_option_is_present_on_page();
        program_page.click_on_edit_start_date_in_program_action_menu();
        program_page.verify_edit_start_date_in_program_pop_up_header();

        employeeProfile.click_on_Edit_start_date_dropdown_button();
        employeeProfile.verify_start_date_edit_option_present_on_page();

        program_page.verify_display_custom_start_date_calendar_option();
        program_page.click_on_custom_option_edit_start_date_popup();
        program_page.click_on_start_custom_date_picker_calendar_icon();
        program_page.calendar_start_date_picker_popup_display();
        employeeProfile.click_on_update_button_of_edit_start_date_popup();
        program_page.verify_edited_start_date_successfully_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_updated_button_without_selecting_custom_start_date(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1060");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on updated button without selecting custom start date");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_start_date_action_drop_down_option_is_present_on_page();
        program_page.click_on_edit_start_date_in_program_action_menu();
        program_page.verify_edit_start_date_in_program_pop_up_header();

        employeeProfile.click_on_Edit_start_date_dropdown_button();
        employeeProfile.verify_start_date_edit_option_present_on_page();

        program_page.verify_display_custom_start_date_calendar_option();
        program_page.click_on_custom_option_edit_start_date_popup();

        employeeProfile.click_on_update_button_of_edit_start_date_popup();
        program_page.verify_start_date_required_validation_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_edit_start_date_popup_Close_icon_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-775");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on edit start date popup Close icon button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_start_date_action_drop_down_option_is_present_on_page();
        program_page.click_on_edit_start_date_in_program_action_menu();
        program_page.verify_edit_start_date_in_program_pop_up_header();
        program_page.click_on_close_icon_button_in_edit_start_date_button();
        program_page.verify_program_profile_page_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_due_date_popup_close_icon_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-798");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on due date popup, close icon button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_due_date_action_drop_down_option_is_present_on_page();
        program_page.edit_due_date_dropdown_option_option();
        program_page.verify_edit_due_date_in_program_pop_up_header();
        program_page.click_on_close_icon_button_in_edit_due_date_button();
        program_page.verify_program_profile_page_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_on_Edit_due_Date_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1058");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button on Edit due Date popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_program_profile_page_display();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_due_date_action_drop_down_option_is_present_on_page();
        program_page.edit_due_date_dropdown_option_option();
        program_page.verify_edit_due_date_in_program_pop_up_header();
        program_page.click_cancel_button_of_edit_due_date_popup();
        program_page.verify_program_profile_page_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_on_Edit_start_Date_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-773");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button on Edit start Date popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_program_profile_page_display();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_start_date_action_drop_down_option_is_present_on_page();
        program_page.click_on_edit_start_date_in_program_action_menu();
        program_page.verify_edit_start_date_in_program_pop_up_header();
        program_page.click_on_cancel_button_in_edit_start_date_button();
        program_page.verify_program_profile_page_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_that_when_clicks_on_save_Filters(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-384");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_that_when_clicks_on_save_Filters");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.click_on_save_filters_icon();
        filter.verify_cancel_button_of_save_filters_is_present_on_page();
        filter.click_on_cancel_button_of_save_filters();
        program_page.click_on_save_filter();
        program_page.verify_save_filters_popup_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_that_when_enters_name_in_the_save_filter_name_field(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-386");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify that when enters name in the save filter name field");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.click_on_save_filters_icon();
        filter.verify_cancel_button_of_save_filters_is_present_on_page();
        filter.click_on_cancel_button_of_save_filters();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.click_on_save_filter();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.enter_saved_filter_name("Automation Filter");
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_close_icon(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-387");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on close icon");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.click_on_filter_button();
        program_page.click_on_save_filter();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_cross_button_of_save_filters_is_present_on_page();
        filter.click_on_cross_button_of_save_filters();
        program_page.verify_action_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_Program_Save_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-388");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button Program Save filter");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.click_on_filter_button();
        program_page.click_on_save_filter();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_cancel_button_of_save_filters_is_present_on_page();
        filter.click_on_cancel_button_of_save_filters();
        program_page.verify_action_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_click_on_save_button_without_entering_Name(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-389");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify click on save button without entering Name");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.click_on_filter_button();
        program_page.click_on_save_filter();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.verify_save_button_of_save_filters_is_present_on_page();
        filter.click_on_save_button_of_save_filters();
        filter.verify_name_is_required_alert_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_that_when_clicks_on_save_filter_from_side_filter_panel(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-391");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify that when clicks on save filter from side filter panel");


        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.verify_save_filters_icon_is_present_on_page();
        filter.click_on_save_filters_icon();
        filter.verify_save_filters_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_When_click_on_reset_filters(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-402");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify When click on reset filters");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        program_page.verify_reset_button_in_program_filter_is_present_on_page();
        program_page.click_on_reset_button_in_program_filter();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_filter_button_it_opens_filters_panel(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-403");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on filter button it opens filters panel");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_on_location_filter_if_click_on_clear_all_option_selected_option_remove(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-412");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify on location filter if click on clear all option selected option remove");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_clear_button_is_present_on_page();
        filter.click_on_clear_button();
    }


    @Test(dataProvider = "login_credentials")
    public void verify_Click_on_save_button_while_entering_name(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-390");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify Click on save button while entering name");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        program_page.click_on_save_filter();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.enter_saved_filter_name("Automation Filter");
        filter.verify_save_button_of_save_filters_is_present_on_page();
    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_copy_icon(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-708");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on copy icon");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//        program_page.click_on_name_check_box_of_program_page();
//        program_page.click_on_action_button();
//        program_page.click_on_activate_in_program_option();
//        program_page.click_on_copy_icon();
//        program_page.click_on_cross_icon_of_activate_in_program_pop_up();
//        program_page.click_on_search_box_of_program_page();
//    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_cancel_button(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-709");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on cancel button");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//        program_page.click_on_name_check_box_of_program_page();
//        program_page.click_on_action_button();
//        program_page.click_on_activate_in_program_option();
//        program_page.click_on_cancel_button_of_pop_up();
//        program_page.verify_action_button_is_present_on_page();
//    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_active_button(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-710");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on active button");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//        program_page.click_on_name_check_box_of_program_page();
//        program_page.click_on_action_button();
//        program_page.click_on_activate_in_program_option();
//        program_page.click_on_active_button_of_pop_up();
//        program_page.verify_employees_activate_in_program_toast_message();
//    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_cross_icon(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-711");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on cross icon");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//        program_page.click_on_name_check_box_of_program_page();
//        program_page.click_on_action_button();
//        program_page.click_on_activate_in_program_option();
//        program_page.click_on_cross_icon_of_activate_in_program_pop_up();
//        program_page.verify_action_button_is_present_on_page();
//    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_deactivate_in_program(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-712");
//        Logger.log_qase_id("NEV-713");
//        Logger.log_qase_id("NEV-716");
//
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on deactivate in program");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//        program_page.click_on_name_check_box_of_program_page();
//        program_page.click_on_action_button();
//        program_page.click_on_deactivate_in_program_option();
//        program_page.verify_deactive_employees_pop_up_is_visible();
//        program_page.click_on_copy_icon();
//        program_page.click_on_cross_icon_of_deactive_in_program_pop_up();
//        program_page.click_on_search_box_of_program_page();
//    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_cancel_button_of_deactivate_employees_pop_up(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-714");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on cancel button of deactivate employees pop up");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.click_on_first_program();
//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//        program_page.click_on_name_check_box_of_program_page();
//        program_page.click_on_action_button();
//        program_page.click_on_deactivate_in_program_option();
//        program_page.verify_deactive_employees_pop_up_is_visible();
//        program_page.click_on_cancel_button_of_pop_up();
//        program_page.verify_action_button_is_present_on_page();
//    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_deactivate_button(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-715");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on deactivate button");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.click_on_first_program();
//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//        program_page.click_on_name_check_box_of_program_page();
//        program_page.click_on_action_button();
//        program_page.click_on_deactivate_in_program_option();
//        program_page.click_on_deactivate_button_of_pop_up();
//        program_page.verify_employees_deactivate_in_program_toast_message();
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_remove_from_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-717");
        Logger.log_qase_id("NEV-718");
        Logger.log_qase_id("NEV-721");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on remove from program");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_remove_from_program_option();
        program_page.verify_remove_employees_header_is_present_on_page();
        program_page.click_on_copy_icon_of_remove_employee_pop_up();
        program_page.click_on_cross_icon_of_remove_employees_pop_up();
        program_page.click_on_search_box_of_program_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_of_remove_employees_pop_up(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-719");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button of remove employees pop up");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_remove_from_program_option();
        program_page.verify_remove_employees_header_is_present_on_page();
        program_page.click_on_cancel_button_of_pop_up();
        program_page.verify_action_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_remove_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-720");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on remove button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_remove_from_program_option();
        program_page.verify_remove_employees_header_is_present_on_page();
        program_page.click_on_remove_button_of_pop_up();
        program_page.verify_employees_remove_in_program_toast_message();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_add_to_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-722");
        Logger.log_qase_id("NEV-723");
        Logger.log_qase_id("NEV-741");


        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on add to program");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        program_page.verify_add_to_program_pop_up_is_visible_on_page();
        program_page.click_on_copy_icon_of_remove_employee_pop_up();
        program_page.click_on_cross_icon_of_add_employees_to_program_pop_up();
        program_page.click_on_search_box_of_program_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_online_program_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-725");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on online program button");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        program_page.verify_program_drop_down_is_present_on_actiavate_in_program_pop_up();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();
        program_page.verify_due_date_drop_down_is_present_activate_in_program_pop_up();
        //program_page.verify_day_optional_button_is_present_activate_in_program_pop_up();
        program_page.verify_cancel_button_is_present_on_activate_in_program_pop_up();
        program_page.verify_submit_button_is_present_on_activate_in_program_pop_up();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_select_today_option_from_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-726");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify select today option from start date dropdown");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.select_today_option_in_start_date_dropdown();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_December_31st_option_from_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-734");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select December 31st option from due date dropdown");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_due_date_31st_option();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_select_1_year_option_from_start_from_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-735");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select 1 year option from start from due date dropdown");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_due_date_1_year_from_start_option();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_Custom_date_option_from_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-737");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select Custom date option from due date dropdown");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

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

        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_Custom_duration_option_from_due_date_drop_down(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-736");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when select Custom duration option from due date drop down");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();

        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();

        employeeProfile.click_on_Custom_duration_option();
        employeeProfile.verify_display_custom_duration_selection_option_present();
        employeeProfile.click_on_upward_dropdown();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_select_anniversary_date_option_from_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-727");
        Logger.log_qase_id("NEV-733");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify select anniversary date option from start date dropdown");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_start_date_anniversary_date_option();

        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_due_date_1_year_from_start_option();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_select_anniversary_month_from_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-728");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify select anniversary month from start date dropdown");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_start_date_anniversary_month_option();

        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_Days_in_anniversary_start_date(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-731");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select Days in anniversary start date");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_start_date_anniversary_date_option();

        program_page.click_on_day_optional_button();
        program_page.verify_set_day_option_available_on_page();
        program_page.click_on_day_upward_dropdown_button();

        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_Days_in_anniversary_month(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-732");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select Days in anniversary month");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_start_date_anniversary_month_option();

        program_page.click_on_day_optional_button();
        program_page.verify_set_day_option_available_on_page();
        program_page.click_on_day_upward_dropdown_button();

        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_submit_button_without_entering_custom_start_date(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-729");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on submit button without entering custom start date");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_Custom_start_date_option();
        employeeProfile.verify_display_custom_start_date_calendar_option();

        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_Provider_start_date_mandatory_validation_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_submit_button_with_entering_custom_start_date(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-730");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on submit button with entering custom start date");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.verify_start_date_drop_down_is_present_activate_in_program_pop_up();

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
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_content(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-478");
        Logger.log_qase_id("NEV-479,TC_PP_046,TC_PP_047");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on content");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        program_page.click_on_content_tab();
        program_page.verify_module_text_is_available_on_page();
        program_page.verify_lesson_text_is_available_on_page();
        program_page.verify_download_icon_is_available_on_page();
        program_page.click_on_download_icon_available_on_content_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_that_by_default_saved_filter_views_at_the_top(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-335");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify that by default saved filter views at the top");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.verify_in_progress_button_is_present_on_page();
        program_page.verify_due_soon_button_is_present_on_page();
        program_page.verify_pending_approval_button_is_present_on_page();
        program_page.verify_approved_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_save_filters_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-676");
        Logger.log_qase_id("NEV-677");
        Logger.log_qase_id("NEV-679");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on save filters button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.click_on_save_filter();
        program_page.verify_save_filters_popup_header_is_present_on_page();
        program_page.click_on_name_text_box_of_save_filter_pop_up();
        program_page.enter_data_in_name_text_box("Testing 1234");
        program_page.click_on_cancel_button_of_pop_up();
        program_page.verify_action_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_save_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-680");
        Logger.log_qase_id("NEV-649");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on save button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.click_on_save_filter();
        program_page.verify_save_filters_popup_header_is_present_on_page();
        program_page.click_on_name_text_box_of_save_filter_pop_up();
        program_page.enter_data_in_name_text_box("Testing");
        program_page.click_on_save_button_of_save_filter_pop_up();
        program_page.verify_action_button_is_present_on_page();
        program_page.verify_user_filter_created_toast_message();
        program_page.click_on_filter_meatball_button();
        program_page.verify_display_meatball_option();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cross_icon_of_save_filter_pop_up(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-681");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cross icon of save filter pop up");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.click_on_save_filter();
        program_page.verify_save_filters_popup_header_is_present_on_page();
        program_page.click_on_name_text_box_of_save_filter_pop_up();
        program_page.enter_data_in_name_text_box("Testing 1234");
        program_page.click_on_cross_icon_of_save_filter_pop_up();
        program_page.verify_action_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_search_box(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-682");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on search box");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("Test");
        program_page.verify_searched_name_is_available_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_any_program_progress(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-671");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on any program progress");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_selected_program_header_is_present();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Export_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-683");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Export button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_selected_program_header_is_present();
        program_page.click_on_program_page_export_button();
        program_page.verify_export_validation_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_cancel_button_with_in_reset_send_email_popup(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-702");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on cancel button with in reset send email popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("corona care program");
        //program_page.verify_searched_name_is_available_on_page();

        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("ziva");
        program_page.verify_searched_name_is_available_on_page();

        program_page.click_on_signed_up_text_of_any_employee();
        program_page.click_on_meatball_menu();
        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();
        program_page.verify_send_email_is_present_on_page();
        program_page.verify_send_sms_is_present_on_page();
        program_page.click_on_send_email_button();
        program_page.verify_send_email_to_change_password_pop_up_is_present();

        program_page.click_on_send_email_popup_cancel_button();
        program_page.verify_program_profile_page_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_can_reset_password_with_Send_Email_option_for_singed_up_employee(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-810");
        Logger.log_qase_id("NEV-692");
        Logger.log_qase_id("NEV-694");
        Logger.log_qase_id("NEV-806");
        Logger.log_qase_id("NEV-700");


        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify can reset password with Send Email option for singed up employee");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("corona care program");
        //program_page.verify_searched_name_is_available_on_page();

        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("ziva");
        program_page.verify_searched_name_is_available_on_page();

        program_page.click_on_signed_up_text_of_any_employee();
        program_page.click_on_meatball_menu();
        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();
        program_page.verify_send_email_is_present_on_page();
        program_page.verify_send_sms_is_present_on_page();
        program_page.click_on_send_email_button();
        program_page.verify_send_email_to_change_password_pop_up_is_present();

        program_page.click_on_send_button_of_the_pop_up();
        employeeProfile.verify_email_sent_message_present_on_page();

    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_select_send_Email_option_for_reset_password_with_not_singed_up_employee(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-703");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when select send Email option for reset password with not singed up employee");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("Study hour");
        //program_page.verify_searched_name_is_available_on_page();

        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.click_on_filter_button();
        filter.click_on_filter_button();
        filter.click_on_signed_up_drop_down();
        filter.verify_no_check_box_is_present_on_page();
        filter.click_on_no_check_box();
        filter.click_on_apply_button();
//        program_page.click_on_search_box_of_program_page_to_search();
//        program_page.enter_employee_name_in_search_text_box("riva patel");
//        program_page.verify_searched_name_is_available_on_page();

        program_page.click_on_signed_up_text_of_any_employee();
        program_page.click_on_meatball_menu();
        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_disable_reset_password_option_on_page();
//        program_page.click_on_reset_password_button();
//        program_page.verify_send_email_is_present_on_page();
//        program_page.verify_send_sms_is_present_on_page();
//        program_page.click_on_send_email_button();
//        program_page.verify_send_email_to_change_password_pop_up_is_present();
//        program_page.click_on_send_button_of_the_pop_up();
//        employeeProfile.verify_employee_not_singed_up_validation_message_present_on_page();

    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_send_SMS(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-695");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on send SMS");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();

        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("corona care program");

        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("ziva");
        program_page.verify_searched_name_is_available_on_page();

        program_page.click_on_signed_up_text_of_any_employee();
        program_page.click_on_meatball_menu();
        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();
        program_page.click_on_send_sms_button();
        program_page.verify_send_sms_to_change_password_pop_up_is_present_on_page();
        program_page.click_on_send_button_of_the_pop_up();
        employeeProfile.verify_SMS_sent_message_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cross_icon_button_in_sms_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-699");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on cross icon button in sms popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.click_on_search_box_of_program_page_to_search();
        employeeProfile.enter_text_at_search_button_employee_profile("kiara");

        program_page.click_on_signed_up_text_of_any_employee();
        program_page.click_on_meatball_menu();
        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();
        program_page.click_on_send_sms_button();
        program_page.verify_send_sms_to_change_password_pop_up_is_present_on_page();
        program_page.click_on_cross_icon_sms_popup();
        program_page.verify_employee_profile_header_present_on_page();
    }

    //    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_copy_icon_of_send_sms_button(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-696");
//        Logger.log_qase_id("NEV-697");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//
//        config.addTestName("verify when clicks on copy icon of send sms button");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//        filter.click_on_filter_button();
//        program_page.click_on_signed_up_text_of_any_employee();
//        program_page.click_on_meatball_menu();
//        program_page.verify_view_profile_is_present_on_page();
//        program_page.verify_reset_password_is_present_on_page();
//        program_page.click_on_reset_password_button();
//        program_page.click_on_send_sms_button();
//        program_page.verify_send_sms_to_change_password_pop_up_is_present_on_page();
//        program_page.click_on_copy_icon_of_send_sms_pop_up();
//        program_page.click_on_cancel_button_of_pop_up();
//        program_page.click_on_search_box_of_program_page();
//    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_view_profile(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-693");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on view profile");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_meatball_menu();
        program_page.verify_view_profile_is_present_on_page();
        program_page.click_on_view_profile_option();
        program_page.verify_employee_profile_header_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_removing_default_filters(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-398");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify removing default filters");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_by_default_approved_filter();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.click_on_save_filter();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.enter_saved_filter_name("Test Filter");
        filter.click_on_save_button_of_save_filters();

        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        //program_page.verify_remove_default_filter_option_is_present_on_page();
        program_page.click_on_remove_default_option();
        program_page.verify_remove_saved_filter_popup_present_on_page();
        program_page.click_confirm_button_of_remove_saved_filter_popup();
        program_page.verify_default_filter_remove_successfully_validation_msg_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_cancel_button_in_removing_default_filters(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1055");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when click on cancel button in removing default filters");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

//        program_page.click_on_by_default_approved_filter();
//        program_page.verify_save_filter_program_is_present_on_page();
//        program_page.click_on_save_filter();
//        filter.verify_save_filters_header_is_present_on_page();
//        filter.verify_name_text_box_is_present_on_page();
//        filter.enter_saved_filter_name("Test Filter");
//        filter.click_on_save_button_of_save_filters();

        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        program_page.verify_remove_default_filter_option_is_present_on_page();
        program_page.click_on_remove_default_option();
        program_page.verify_remove_saved_filter_popup_present_on_page();
        program_page.click_cancel_button_of_remove_saved_filter_popup();
        program_page.verify_program_profile_page_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_try_to_renaming_default_filters(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-399");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify try to renaming default filters");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_by_default_approved_filter();
        program_page.verify_save_filter_program_is_present_on_page();
        program_page.click_on_save_filter();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.enter_saved_filter_name("Test Filter");
        filter.click_on_save_button_of_save_filters();

        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        //program_page.verify_rename_default_filter_option_is_present_on_page();
        program_page.click_on_rename_default_filter_option();
        program_page.verify_save_filters_popup_header_is_present_on_page();
        program_page.click_on_rename_text_box_of_save_filter_pop_up();
        program_page.enter_rename_of_default_save_filter_popup("auto test");
        program_page.click_on_save_button_of_save_filter_pop_up();
        program_page.verify_filter_updated_successfully_validation_msg_present();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_yes_checkbox(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-811");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on yes checkbox");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.click_on_signed_up_drop_down();
        filter.verify_yes_check_box_is_present_on_page();
        filter.click_on_yes_check_box();
        filter.click_on_apply_button();
        filter.verify_signed_up_yes_employee_name_are_displayed_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_no_checkbox(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-812");
        Logger.log_qase_id("NEV-813");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName(" verify when clicks on No checkbox");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.click_on_signed_up_drop_down();
        filter.verify_no_check_box_is_present_on_page();
        filter.click_on_no_check_box();
        filter.click_on_apply_button();
        filter.verify_signed_up_no_employee_name_are_displayed_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_disciplines(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-817");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on disciplines");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.verify_clear_button_is_present_on_page();
        filter.verify_and_button_is_present_on_page();
        filter.verify_or_button_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_select_all_link_of_disciplines_filters(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-817");
        Logger.log_qase_id("NEV-825");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on select all link of disciplines filters");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_no_of_disciplines_selected_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_view_profile_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-792");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when click on view profile button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_signed_up_text_of_any_employee();
        program_page.click_on_meatball_menu();
        program_page.verify_view_profile_is_present_on_page();
        program_page.click_on_view_profile_option_of_pop_up();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_close_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-808");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when click on close button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("ziva");
        program_page.verify_searched_name_is_available_on_page();
        program_page.click_on_signed_up_text_of_any_employee();
        program_page.click_on_meatball_menu();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();
        program_page.click_on_send_sms_button();
        program_page.click_on_cancel_button_of_pop_up();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_send_certificates_for_without_approval(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-755");
        Logger.log_qase_id("NEV-754");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on send certificates for without approval");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_send_certificates_button();
        program_page.verify_no_certificate_sent_toast_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_download_certificates(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-756");


        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on download certificates");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_download_certificates_option();
        program_page.verify_toast_message_for_certificate_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_try_to_Unpin_in_default_filters(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-401");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify try to Unpin in default filters");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        program_page.click_on_filter_meatball_button();
        program_page.verify_display_meatball_option();
        program_page.click_on_unpin_option();
        program_page.verify_filter_updated_successfully_validation_msg_present();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Help_icon_of_disciplines_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-820");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on Help icon of disciplines filter");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.click_on_disciplines_drop_down();
        //filter.verify_help_icon_is_present_on_page();
        //filter.click_on_discipline_help_icon();
        //filter.verify_here_you_can_get_help_pop_box();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_location_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-824");
        Logger.log_qase_id("NEV-827");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on location dropdown");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.click_on_location_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        //filter.verify_help_icon_is_present_on_page();
        filter.verify_clear_button_is_present_on_page();
        filter.verify_first_check_box_of_location_is_present_on_page();
    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_Help_icon_of_location_filter(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-830");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//
//        config.addTestName(" verify when clicks on Help icon of location filter");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        program_page = new program_page(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        program_page.verify_program_nav_is_present_on_page();
//        program_page.click_on_program_nav();
//        program_page.verify_programs_page_header_is_present_on_page();
//        program_page.verify_first_program_is_present_on_page();
//        program_page.click_on_first_program();
//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//        filter.click_on_location_drop_down();
//        filter.verify_help_icon_is_present_on_page();
//        filter.click_on_discipline_help_icon();
//        filter.verify_here_you_can_get_help_pop_box();
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_clear_selected_location_cleared(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-830");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName(" verify when clicks on clear selected location cleared");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.click_on_location_drop_down();
        filter.click_on_select_all_button();
        filter.verify_no_of_selected_location_is_present_on_page();
        filter.click_on_clear_button();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_Edit_Start_Date_option_with_complete_program_employees(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1000");
        Logger.log_qase_id("NEV-1001");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select Edit Start Date option with complete program employees");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_corona_care_program_present_on_page();
        program_page.click_on_corona_care_program();

        program_page.verify_add_program_button_present_on_page();
        program_page.click_on_add_employee_button();
        program_page.search_employee_to_add_program("Patel Ziva");
        program_page.verify_Ziva_patel_employee_display();
        employeeProfile.click_on_add_program_submit_button();

//        program_page.verify_ziva_employee_present_on_page();
//        program_page.verify_completed_progress_of_program_100_displayed();
//        program_page.verify_start_date_of_completed_employee();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.search_employee_to_program_details_page("Patel Ziva");
        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();

        program_page.verify_edit_start_date_action_drop_down_option_is_present_on_page();
        program_page.click_on_edit_start_date_in_program_action_menu();
        program_page.verify_edit_start_date_in_program_pop_up_header();

        employeeProfile.click_on_Edit_start_date_dropdown_button();
        employeeProfile.verify_start_date_edit_option_present_on_page();

        program_page.verify_display_custom_start_date_calendar_option();
        program_page.click_on_custom_option_edit_start_date_popup();
        program_page.click_on_start_custom_date_picker_calendar_icon();
        program_page.select_start_date_picker_for_completed_program();
        employeeProfile.click_on_update_button_of_edit_start_date_popup();
//        program_page.verify_edited_start_date_successfully_validation_msg();
//        program_page.verify_employee_start_date_not_edited();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_send_certificates_option_with_approved_status(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-999");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select send certificates option with approved status");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_corona_care_program_present_on_page();
        program_page.click_on_corona_care_program();

        program_page.click_on_add_employee_button();
        program_page.search_employee_to_add_program("Patel Ziva");
        program_page.verify_Ziva_patel_employee_display();
        employeeProfile.click_on_add_program_submit_button();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.search_employee_to_program_details_page("Patel Ziva");
        program_page.verify_ziva_employee_present_on_page();
        program_page.click_on_name_check_box_of_program_page();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_action_button();
        program_page.verify_send_certificates_drop_down_option_is_present_on_page();
        program_page.click_on_send_certificates_option_program_action();
        program_page.verify_successfully_send_certificates_validation_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_send_Email_option_for_reset_password_with_not_singed_up_employee(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-704");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when select send Email option for reset password with not singed up employee");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        program_page.click_on_search_box_of_program_page_to_search();
        program_page.enter_employee_name_in_search_text_box("Test kiara");
        program_page.verify_searched_name_is_available_on_page();

        program_page.click_on_meatball_menu();
        program_page.verify_view_profile_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_kebab_menu_icon_available_in_program_card(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1703");
        Logger.log_qase_id("NEV-1704");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When clicks on kebab menu icon, available in program card");


        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.click_on_meatball_menu_available_in_program_card();
        program_page.click_on_copy_api_id();
        program_page.verify_api_id_copied_validation();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_switch_to_view_list_icon_with_in_program_list_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1900");
        Logger.log_qase_id("NEV-1901");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on switch to view list icon with in program list page");

        login = new login_page(driver);

        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_switch_to_view_list_icon_present();
        program_page.click_on_program_view_list_icon();
        program_page.verify_view_list_program_display();
        program_page.click_on_program_view_list_icon();
        program_page.verify_display_program_view_in_gird();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_set_by_default_in_progress_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-672");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on, set by default In progress filter");

        login = new login_page(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.click_on_in_progress_button_default();
        program_page.verify_in_progress_employee_is_present();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_content_of_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1905");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify content of start date dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        employeeProfile = new employeeProfile(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.remove_default_filter();
        program_page.click_on_name_check_box_of_program_page();
        program_page.click_on_action_button();
        program_page.click_on_add_program_option();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        program_page.click_on_start_date_drop_down();
        program_page.verify_today_option_is_present();
        program_page.verify_anniversary_date_option_is_present();
        program_page.verify_anniversary_month_option_is_present();
        program_page.verify_custom_date_option_is_present();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_select_All_check_box(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PP_044");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when click on select All check box");

        login = new login_page(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_select_all_button_for_select_all_check_box();
        program_page.verify_all_selected_title_display();
        program_page.verify_reset_link_present_for_check_box();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_When_Clicks_on_Reset_link_on_program_progress(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PP_045");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        program_page.verify_action_button_is_present_on_page();
        program_page.click_on_select_all_button_for_select_all_check_box();
        program_page.verify_all_selected_title_display();
        program_page.verify_reset_link_present_for_check_box();
        program_page.click_on_reset_link_for_check_box();
        program_page.verify_all_check_box_un_checked();
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_clicks_on_new_session_button(String username, String password, String agency_name ){
        Logger.log_qase_id("TC_IS_044");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.verify_fields_on_details_tab();
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_clicks_on_new_session_button_details_fields(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_045");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        program_page.verify_training_hours();
        program_page.enter_text_in_seats_and_verify(newEmployees, "1234");
        program_page.clear_seats_text_field();
        program_page.click_on_seat_up_button();
        program_page.clear_seats_text_field();
        program_page.click_on_seat_down_button();
        program_page.click_on_in_class_checkbox();
        program_page.verify_in_class_checkbox_is_unchecked();
        program_page.click_on_online_checkbox();
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_click_on_continue_button_without_entering_mandatory_fields(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_046");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.verify_in_class_checkbox_is_checked();
        program_page.click_on_in_class_checkbox();
        program_page.verify_in_class_checkbox_is_unchecked();
        program_page.verify_online_checkbox_is_unchecked();
        program_page.click_on_continue_button();
        String listOfError = "Session name is required,Supervisor is required,Type is required";
        program_page.verify_mandatory_errors(listOfError);
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_clicks_on_new_session_button_when_in_class_field_is_selected(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_047");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_clicks_on_new_session_button_when_online_field_is_selected(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_048");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.verify_online_checkbox_is_unchecked();
        program_page.click_on_online_checkbox();
        program_page.enter_url_in_event_url_field("https://moto.com");
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_clicks_on_add_field_button(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_049");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.click_on_add_field_button();
        program_page.enter_value_in_new_field_name_and_new_field_value(newEmployees);
        program_page.click_on_remove_new_field_button_presence();
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_click_on_new_session_button_with_schedule_tab(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_051");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date("LLL dd, yyyy");
        program_page.enter_schedule_start_time((Integer.parseInt("6")), (long)(Integer.parseInt("30")));
        program_page.enter_schedule_end_time((Integer.parseInt("7")), (long)(Integer.parseInt("30")));
        program_page.click_on_repeat_checkbox();
        program_page.enter_text_in_session_frequency_field("2");
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_days_type_option();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.enter_session_end_date("LLL dd, yyyy", (long)(Integer.parseInt("5")));
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_weeks_type_option();
        program_page.select_week_day_and_verify_it_is_selected();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_after_end_type_option();
        program_page.enter_value_in_sessions_textbox(newEmployees,"1234");
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_click_on_create_session_button_without_entering_mandatory_fields(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_052");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.click_on_continue_button();
        String listOfError = "Start date is required,Start time is required,End time is required,Frequency is required,Type is required,Ending type is required";
        program_page.verify_mandatory_errors(listOfError);
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_weeks_type_option();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
//        program_page.verify_mandatory_errors(errors);
//        program_page.click_on_end_type_dropdown();
//        program_page.click_on_after_end_type_option();
//        program_page.verify_mandatory_errors(errors);
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_that_selecting_repeat_checkbox_displays_additional_fields(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_054");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.verify_session_frequency_field_is_present();
        program_page.click_on_session_recurring_type_dropdown();
        program_page.verify_days_option_is_present();
        program_page.verify_weeks_option_is_present();
        program_page.click_on_end_type_dropdown();
        program_page.verify_on_option_on_end_type_dropdown_is_present();
        program_page.verify_after_option_on_end_type_dropdown_is_present();
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_selecting_on_from_the_end_type_dropdown(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_055");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.verify_session_end_date_field_is_present();
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_selecting_specific_date_from_ends_label_datepicker(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_056");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.enter_session_end_date("LLL dd, yyyy", (long)(Integer.parseInt("5")));
        program_page.click_on_session_end_date_field();
        program_page.click_on_highlighted_date();
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_selecting_after_from_ends_dropdown(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_057");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_after_end_type_option();
        program_page.verify_sessions_textbox_field_is_present();
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_entering_number_in_the_sessions_textbox(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_058");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_after_end_type_option();
        program_page.enter_value_in_sessions_textbox(newEmployees,"1234");
    }

    @Test(dataProvider = "login_credentials")
    public void to_verify_when_selecting_weeks_from_session_recurring_type_dropdown(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_059");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify When Clicks on Reset link on program progress");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_weeks_type_option();
        program_page.verify_week_days_field_is_present();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_Selecting_multiple_weekdays_from_the_grid(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_060");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Selecting multiple weekdays from the grid");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_weeks_type_option();
        program_page.verify_week_days_field_is_present();
        program_page.select_week_day_and_verify_it_is_selected();
        program_page.select_week_day_and_verify_it_is_selected();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_Selecting_On_from_the_ends_with_dropdown(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_061");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Selecting On from the ends with dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_weeks_type_option();
        program_page.verify_week_days_field_is_present();
        program_page.select_week_day_and_verify_it_is_selected();
        program_page.verify_end_type_dropdown_is_present();
        program_page.click_on_end_type_dropdown();
        program_page.verify_on_option_on_end_type_dropdown_is_present();
        program_page.click_on_on_end_type_option();
        program_page.click_on_session_end_date_field();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_Selecting_after_from_the_ends_with_dropdown(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_063");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Selecting after from the ends with dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_weeks_type_option();
        program_page.verify_week_days_field_is_present();
        program_page.select_week_day_and_verify_it_is_selected();
        program_page.verify_end_type_dropdown_is_present();
        program_page.click_on_end_type_dropdown();
        program_page.verify_after_option_on_end_type_dropdown_is_present();
        program_page.click_on_after_end_type_option();
        program_page.verify_sessions_textbox_field_is_present();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_back_button_from_schedule_tab(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_066");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Selecting after from the ends with dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees, "1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_back_button_from_schedule_tab();
        program_page.verify_user_is_on_details_tab();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_cancel_button_from_new_session_pop_up(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_067");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Selecting after from the ends with dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.click_on_cancel_button_from_new_session_pop_up();
        program_page.verify_user_is_on_in_class_sessions_tab();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_cross_icon_from_new_session_pop_up(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_068");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Selecting after from the ends with dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        program_page.verify_user_is_on_in_class_sessions_tab();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_creating_session(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_069");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Selecting after from the ends with dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date("LLL dd, yyyy");
        program_page.click_on_choose_start_time_picker_button();
        program_page.click_on_previous_hour_create_session();
        //program_page.enter_schedule_start_time((long)(Integer.parseInt("6")), (long)(Integer.parseInt("30")));
        program_page.enter_schedule_end_time((long)(Integer.parseInt("7")), (long)(Integer.parseInt("30")));
        program_page.click_on_new_session_pop_up();
        program_page.click_on_continue_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_starting_session(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_070");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Selecting after from the ends with dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_text_in_seats_and_verify(newEmployees,"1234");
       // program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date("LLL dd, yyyy");
        //program_page.click_on_choose_start_time_picker_button();
        //program_page.click_on_previous_hour_create_session();
        program_page.enter_schedule_start_time((long)(Integer.parseInt("6")), (long)(Integer.parseInt("0")));
        program_page.enter_schedule_end_time((long)(Integer.parseInt("7")), (long)(Integer.parseInt("30")));
        program_page.click_on_new_session_pop_up();
        program_page.click_on_schedule_tab_create_session_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.click_on_start_session_button_from_edit_session_dialog();
        sessionPage.verify_language_dropdown_present();
        sessionPage.verify_view_fullscreen_button_present();
        sessionPage.verify_load_automatically_checkbox_present();
        sessionPage.verify_next_lesson_button_present_at_bottom();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_session_title_in_session_card(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_072");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_session_title_in_session_card");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.click_on_schedule_button();
        program_page.verify_edit_button();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_edit_button_in_session_editable_dialog(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_073");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_edit_button_in_session_editable_dialog");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.click_on_schedule_button();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.verify_cancel_button_on_edit_dialog();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_cross_icon_from_session_edit_dialog(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_074");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_cross_icon_from_session_edit_dialog");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.click_on_schedule_button();
        program_page.verify_edit_button();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        program_page.verify_user_is_on_in_class_sessions_tab();
    }


    // Getting failed
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_updating_session_details_from_session_edit_dialog(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_075");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_updating_session_details_from_session_edit_dialog");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.click_on_schedule_button();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        String seats = program_page.fetch_seats();
        program_page.enter_seat_number(String.valueOf(newEmployees.generate_number("1")));
        String currentSupervisor = program_page.fetch_current_supervisor();
        program_page.enter_text_in_supervisor_field(newEmployees.generate_string(4));
        program_page.click_on_update_button_from_edit_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.verify_session_supervisor();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.enter_seat_number(seats);
        program_page.enter_text_in_supervisor_field(currentSupervisor);
        program_page.click_on_update_button_from_edit_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.verify_session_supervisor();
        program_page.click_on_schedule_button();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.click_on_schedule_date_field();
        program_page.select_schedule_date("LLL dd, yyyy");
        program_page.click_on_update_button_from_edit_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.verify_session_date();
    }

    // Getting failed
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicking_on_cancel_after_updating_details_in_session_edit_dialog(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_076");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_cancel_after_updating_deatils_in_session_edit_dialog");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.click_on_schedule_button();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        String seats = program_page.fetch_seats();
        program_page.enter_seat_number(String.valueOf(newEmployees.generate_number("1")));
        String currentSupervisor = program_page.fetch_current_supervisor();
        program_page.enter_text_in_supervisor_field(newEmployees.generate_string(4));
        program_page.click_on_cancel_button_on_edit_dialog();
        program_page.wait_for_few_seconds();
        program_page.verify_session_supervisor_is_not_changed(currentSupervisor);
        program_page.verify_seats_value_is_not_changed(seats);
        program_page.click_on_schedule_button();
        String currentDate = program_page.fetch_schedule_start_date();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.click_on_schedule_date_field();
        program_page.select_schedule_date("LLL dd, yyyy");
        program_page.click_on_cancel_button_on_edit_dialog();
        program_page.wait_for_few_seconds();
        program_page.verify_session_date_is_not_changed(currentDate);
    }


    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicking_on_kebab_menu_on_session_card(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_077");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_kebab_menu_on_session_card");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_more_options_icon();
        program_page.verify_edit_session_button_on_kebab_menu();
        program_page.verify_manage_attendance_button_on_kebab_menu();
        program_page.verify_start_button_on_kebab_menu();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicking_on_edit_session_on_session_card(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_078");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_edit_session_on_session_card");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_more_options_icon();
        program_page.verify_edit_session_button_on_kebab_menu();
        program_page.click_on_edit_session_button_on_kebab_menu();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.click_on_schedule_button();
        program_page.verify_edit_button();
        program_page.verify_details_tab_button();
        program_page.verify_cross_icon();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicking_on_manage_attendance_in_session_card(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_079");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_manage_attendance_in_session_card");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_more_options_icon();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.verify_add_employees_button_on_manage_attendance_pop_up();
        // program_page.verify_refresh_button_on_manage_attendance_pop_up();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicking_on_add_employee_button_from_manage_attendance_pop_up(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_080");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_add_employee_button_from_manage_attendance_pop_up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);
        employeeAction = new employee_action(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_more_options_icon();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_add_employee_button_from_manage_attendance_pop_up();
        employeeAction.verify_user_is_on_employees_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_adding_employee_to_in_class_session(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_081");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_adding_employee_to_in_class_session");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);
        employeeAction = new employee_action(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        String sessionDetails = program_page.get_session("demo");
        program_page.click_on_more_options_icon();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_add_employee_button_from_manage_attendance_pop_up();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.search_employee("Test");
        employeeAction.verify_first_employee_checkout_employee_action_is_present_on_page();
        employeeAction.click_on_first_employee_checkout_employee_action();
        employeeAction.click_on_actions();
        employeeAction.click_on_add_program_option_employee_action();
        employeeAction.click_on_in_class_program_button();
        employeeAction.click_on_programs_dropdown();
        employeeAction.select_given_program("Healthy life");
        employeeAction.verify_selected_program_displayed("Healthy life");
        employeeAction.click_on_sessions_dropdown();
        employeeAction.select_given_session(sessionDetails);
        employeeAction.click_on_submit();
        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card("demo");
        program_page.click_on_more_options_icon();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
//        program_page.click_on_more_icon_of_given_employee("Test");
//        program_page.click_on_remove_from_program_button_on_manage_attendance();
//        program_page.click_on_remove_final_in_pop_up();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_recurring_session_is_created(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_082");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_recurring_session_is_created");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String title = program_page.get_session_title();
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_seat_number("2");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date("LLL dd, yyyy");
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.enter_schedule_end_time((long)(Integer.parseInt("7")), (long)(Integer.parseInt("30")));
        program_page.click_on_schedule_end_time();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_repeat_checkbox();
        program_page.enter_text_in_session_frequency_field("2");
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_days_type_option();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.enter_session_end_date("LLL dd, yyyy",5);
        program_page.click_on_new_session_pop_up();
        program_page.click_on_continue_button();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        program_page.verify_recurring_sessions_created(title);
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_session_end_date_is_before_start_date(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_083");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_session_end_date_is_before_start_date");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_seat_number("2");
        // program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date("LLL dd, yyyy");
        //  program_page.click_on_schedule_start_time();
        //  program_page.select_start_time_value();
        program_page.enter_schedule_end_time((long)(Integer.parseInt("7")), (long)(Integer.parseInt("30")));
        program_page.click_on_schedule_end_time();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_repeat_checkbox();
        program_page.enter_text_in_session_frequency_field("2");
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_days_type_option();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.enter_session_end_date("LLL dd, yyyy",5);
        program_page.click_on_new_session_pop_up();
        program_page.click_on_continue_button();
        program_page.verify_error_of_end_date_before_start_date();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_download_completed_session_report(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_088");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_download_completed_session_report");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_more_option_of_completed_session();
        program_page.click_on_session_report_button();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_When_Download_All_Certification_in_Completed_session(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_089");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_When_Download_All_Certification_in_Completed_session");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_more_option_of_completed_session();
        program_page.click_on_session_report_button();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_When_Download_All_Certification_in_Completed_session_run(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_089");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_When_Download_All_Certification_in_Completed_session");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_more_option_of_completed_session();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_plus_add_employee_option_manage_attendance();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_Employee_should_not_be_added_in_Completed_session(String username, String password, String agencyName){
        Logger.log_qase_id("TC_IS_090");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_Employee_should_not_be_added_in_Completed_session");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_more_option_of_completed_session();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_plus_add_employee_option_manage_attendance();
        program_page.click_on_first_checkbox_for_employee();
        program_page.click_on_add_button_manage_attendance();
    }

    @Test(dataProvider = "login_credentials")
    public void To_Verify_Mark_as_Attended_bulk_operation_in_Manage_Attendance_Session_Page(String username, String password, String agencyName) {
        Logger.log_qase_id("TC_IS_091");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To Verify Mark as Attended bulk operation in Manage Attendance Session Page");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab_link();
        program_page.verify_session_title_on_card_for_active_session("Automation");
        program_page.click_on_active_manage_attendance_link();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_all_checkbox_for_employee();
        program_page.click_on_session_attendance_actions_button();
        program_page.click_on_mark_as_attended_button();
    }

    @Test(dataProvider = "login_credentials")
    public void To_Verify_Mark_as_Absent_bulk_operation_in_Manage_Attendance_Session_Page(String username, String password, String agencyName) {
        Logger.log_qase_id("TC_IS_092");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To Verify Mark as Absent bulk operation in Manage Attendance Session Page");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card_for_active_session("Automation");
        program_page.click_on_active_manage_attendance_link();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_all_checkbox_for_employee();
        program_page.click_on_session_attendance_actions_button();
        program_page.click_on_mark_as_absent_button_from_manage_session();
    }

    @Test(dataProvider = "login_credentials")
    public void To_Verify_Remove_from_Program_bulk_operation_in_Manage_Attendance_Session_Page(String username, String password, String agencyName) {

        Logger.log_qase_id("TC_IS_093");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To Verify Remove from Program bulk operation in Manage Attendance Session Page");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card_for_active_session("Automation");
        program_page.click_on_active_manage_attendance_link();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_all_checkbox_for_employee();
        program_page.click_on_session_attendance_actions_button();
        program_page.click_on_remove_from_session_button();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_user_click_on_Edit_session_button(String username, String password, String agencyName) {

        Logger.log_qase_id("TC_IS_105");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when user click on 'Edit session' button");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card_for_active_session("Automation");
        program_page.click_on_active_manage_attendance_link();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_session_attendance_meta_actions_button();
        program_page.click_on_edit_session_option_meta_actions_option();
        program_page.verify_details_tab_button();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_user_click_on_Resume_button(String username, String password, String agencyName) {

        Logger.log_qase_id("TC_IS_106");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when user click on 'Resume' button");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);
        employeeProfile = new employeeProfile(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card_for_active_session("Automation");
        program_page.click_on_active_manage_attendance_link();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_session_attendance_meta_actions_button();
        program_page.click_on_resume_option_meta_actions_option();
        employeeProfile.navigateToNewTab();
        program_page.verify_preferred_language_in_resume_session();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_user_click_on_Complete_session_button(String username, String password, String agencyName) {

        Logger.log_qase_id("TC_IS_107");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when user click on complete button");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card_for_active_session("Automation");
        program_page.click_on_active_manage_attendance_link();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_session_attendance_meta_actions_button();
        program_page.click_on_complete_option_meta_actions_option();
        program_page.verify_completed_session_action_option();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_user_click_on_Complete_button_at_complete_pop_up(String username, String password, String agencyName) {

        Logger.log_qase_id("TC_IS_108");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when user click on Complete button at complete pop-up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);
        sessionPage = new csSession_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);

        program_page.click_on_programs_link();
        program_page.click_on_given_program("Healthy life");
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card_for_active_session("Automation");
        program_page.click_on_active_manage_attendance_link();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_session_attendance_meta_actions_button();
        program_page.click_on_complete_option_meta_actions_option();
        program_page.verify_completed_session_action_option();
        program_page.verify_complete_button_at_complete_session_pop_up();
    }


}
