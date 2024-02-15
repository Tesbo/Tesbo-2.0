package WebUITests.inClassSessionTests;

import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.employeeActionPage.employee_action;
import web.object_repository.employeeProfilePage.employeeProfile;
import web.object_repository.filterPage.filter;
import web.object_repository.login.login_page;
import web.object_repository.newEmployeesPage.new_employees;
import web.object_repository.program.program_page;
import web.object_repository.scheduledReportsPage.scheduled_reports;
import web.object_repository.inClassSessionPage.inClassSession_page;

public class inClassSessionTest  extends base {

    login_page login = null;
    scheduled_reports scheduled_reports = null;
    program_page program_page = null;
    filter filter = null;

    inClassSession_page inClassSessionPage = null;

    employeeProfile employeeProfile = null;

    new_employees new_employees = null;

    employee_action employee_action = null;

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

    @Test(dataProvider = "login_credentials")
    public void verify_in_class_sessions_title_shows_for_program_added_to_in_class(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-468");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify in class sessions title shows for program added to in class");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_New_session_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-470");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on New session button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();
        inClassSessionPage.click_on_new_session_button_inClassSession();
        inClassSessionPage.verify_new_session_popup_header_is_present_on_page();

        inClassSessionPage.verify_session_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_session_supervisor_inClassSession_is_present_on_page();
        inClassSessionPage.verify_calendar_choose_textbox_inClassSession_is_present_on_page();
        inClassSessionPage.verify_add_field_link_inClassSession_is_present_on_page();
        inClassSessionPage.verify_cancel_button_inClassSession_is_present_on_page();
        inClassSessionPage.verify_create_session_button_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Create_session_button_without_entering_data_in_fields(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-480");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Create session button without entering data in fields");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();
        inClassSessionPage.click_on_new_session_button_inClassSession();
        inClassSessionPage.verify_new_session_popup_header_is_present_on_page();

        inClassSessionPage.verify_session_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_session_supervisor_inClassSession_is_present_on_page();
        inClassSessionPage.verify_create_session_button_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_create_session_button_inClassSession();
        inClassSessionPage.verify_required_validation_message_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enter_data_in_Session_name_and_Supervisor_text_box_field(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-481");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when enter data in Session name and Supervisor text box field");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();
        inClassSessionPage.click_on_new_session_button_inClassSession();
        inClassSessionPage.verify_new_session_popup_header_is_present_on_page();

        inClassSessionPage.verify_session_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_session_supervisor_inClassSession_is_present_on_page();

        inClassSessionPage.enter_text_at_session_name_inClassSession("Automation");
        inClassSessionPage.enter_text_at_session_supervisor_inClassSession("Test Automation");

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_add_field_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-483");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on add field button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.click_on_new_session_button_inClassSession();
        inClassSessionPage.verify_new_session_popup_header_is_present_on_page();

        inClassSessionPage.verify_session_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_session_supervisor_inClassSession_is_present_on_page();
        inClassSessionPage.verify_add_field_link_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_add_field_link_inClassSession();

        inClassSessionPage.verify_calendar_new_field_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_new_field_value_inClassSession_is_present_on_page();
        inClassSessionPage.verify_delete_button_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_cancel_button_in_new_session_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-485");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button in new session popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();
        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.click_on_new_session_button_inClassSession();
        inClassSessionPage.verify_new_session_popup_header_is_present_on_page();

        inClassSessionPage.verify_session_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_session_supervisor_inClassSession_is_present_on_page();
        inClassSessionPage.verify_cancel_button_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_cancel_button_inClassSession();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_calendar_icon_of_Scheduled_on(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-482");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on calendar icon of Scheduled on");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();
        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.click_on_new_session_button_inClassSession();
        inClassSessionPage.verify_new_session_popup_header_is_present_on_page();

        inClassSessionPage.verify_session_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_session_supervisor_inClassSession_is_present_on_page();

        inClassSessionPage.enter_text_at_session_name_inClassSession("Automation");
        inClassSessionPage.enter_text_at_session_supervisor_inClassSession("Test Automation");

        inClassSessionPage.verify_calendar_choose_textbox_inClassSession_is_present_on_page();
        inClassSessionPage.calendar_date_choose_textbox_inClassSession();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_delete_icon_from_add_field(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-484");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on delete icon from add field");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.click_on_new_session_button_inClassSession();
        inClassSessionPage.verify_new_session_popup_header_is_present_on_page();

        inClassSessionPage.verify_session_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_session_supervisor_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_add_field_link_inClassSession();
        inClassSessionPage.verify_calendar_new_field_name_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_new_field_name_inClassSession("Test");
        inClassSessionPage.verify_new_field_value_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_new_field_value_inClassSession("automate");
        inClassSessionPage.verify_delete_button_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_delete_button_inClassSession();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_Create_session_button_with_entering_data_in_fields(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-486");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Create session button with entering data in fields");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.click_on_new_session_button_inClassSession();
        inClassSessionPage.verify_new_session_popup_header_is_present_on_page();

        inClassSessionPage.verify_session_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_session_supervisor_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_session_name_inClassSession("Nothing");
        inClassSessionPage.enter_text_at_session_supervisor_inClassSession("withoutTest");
        inClassSessionPage.verify_calendar_choose_textbox_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_calendar_choose_textbox_inClassSession();
        inClassSessionPage.click_on_create_session_button_inClassSession();

        inClassSessionPage.verify_created_session_present_on_schedule_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_close_icon_in_new_session_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-487");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on close icon in new session popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.click_on_new_session_button_inClassSession();
        inClassSessionPage.verify_new_session_popup_header_is_present_on_page();

        inClassSessionPage.verify_session_name_inClassSession_is_present_on_page();
        inClassSessionPage.verify_session_supervisor_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_session_name_inClassSession("Hello");
        inClassSessionPage.enter_text_at_session_supervisor_inClassSession("Automation");
        inClassSessionPage.verify_calendar_choose_textbox_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_calendar_choose_textbox_inClassSession();

        inClassSessionPage.verify_cross_button_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_cross_button_inClassSession();
        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_search_for_any_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-471");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when search for any session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_any_session_from_scheduled(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-472");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on any session from scheduled");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_the_content_of_the_in_class_sessions_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-469");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify the content of the in class sessions page");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_edit_button_class_sessions_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-473");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on edit button class sessions page");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_edit_button_session_inClassSession();
        inClassSessionPage.verify_update_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.verify_cancel_button_session_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_cancel_button_class_sessions_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-488");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button class sessions page");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_edit_button_session_inClassSession();
        inClassSessionPage.verify_update_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.verify_cancel_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_cancel_button_session_inClassSession();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_update_button_class_sessions_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-489");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on update button class sessions page");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_edit_button_session_inClassSession();
        inClassSessionPage.verify_update_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.verify_cancel_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_update_button_session_inClassSession();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_start_session_button_in_class_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-514");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on start session button in class session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("demo");
        inClassSessionPage.click_on_active_session_kebab_button();

        inClassSessionPage.verify_start_button_session_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_close_icon_button_class_sessions_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-492");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on close icon button class sessions page");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.verify_cross_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_cross_button_session_inClassSession();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_kebab_icon_form_scheduled_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-515");
        Logger.log_qase_id("NEV-031");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on kebab icon form scheduled session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.verify_more_option_session_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_more_option_session_inClassSession();
        inClassSessionPage.verify_start_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.click_start_option();
        inClassSessionPage.verify_redirect_to_player_screen();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_start_form_scheduled_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-516");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on start form scheduled session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.verify_more_option_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_more_option_session_inClassSession();
        inClassSessionPage.verify_start_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_start_button_session_inClassSession();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_any_session_from_active(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-513");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on any session from active");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_edit_button_in_class_active_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-517");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on edit button in class active session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_edit_button_session_inClassSession();
        inClassSessionPage.verify_update_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.verify_cancel_button_session_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_cancel_button_in_class_active_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-518");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button in class active session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_edit_button_session_inClassSession();
        inClassSessionPage.verify_update_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.verify_cancel_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_cancel_button_session_inClassSession();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();
    }


    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_update_button_class_active_sessions_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-519");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on update button class active session page");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_edit_button_session_inClassSession();
        inClassSessionPage.verify_update_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.verify_cancel_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_update_button_session_inClassSession();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_add_session_button_class_active_sessions(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-520");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on add session button class active session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_edit_button_session_inClassSession();
        inClassSessionPage.verify_add_field_link_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_add_field_link_inClassSession();
        inClassSessionPage.enter_text_at_new_field_name_inClassSession("Auto");
        inClassSessionPage.verify_new_field_value_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_new_field_value_inClassSession("Testing");
        inClassSessionPage.verify_delete_button_inClassSession_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_add_employee_session_button_class_active_sessions(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-522");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("`verify when clicks on add employee session button class active session`");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.verify_search_text_box_inClassSession_is_present_on_page();
        inClassSessionPage.enter_text_at_search_text_box_inClassSession("Nothing");
        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_edit_button_session_inClassSession_is_present_on_page();

        inClassSessionPage.click_on_edit_button_session_inClassSession();
        inClassSessionPage.verify_add_field_link_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_add_field_link_inClassSession();
        inClassSessionPage.verify_add_employee_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_add_employee_inClassSession();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_Add_Employee_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1090");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Add Employee button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        program_page.click_on_add_employee_button();
        program_page.verify_add_to_program_pop_up_is_visible_on_page();
        program_page.search_employee_to_add_program("Ziva Patel");
        program_page.verify_Ziva_patel_employee_display();
        program_page.click_on_session_dropdown_button();
        program_page.select_session_from_the_dropdown();
        employeeProfile.click_on_add_program_submit_button();
        program_page.verify_successfully_add_employee_validation_msg();


    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_add_employee_with_in_In_class_session_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1091");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when add employee with in In class session popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);
        new_employees = new new_employees(driver);
        employee_action = new employee_action(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();


        inClassSessionPage.verify_search_name_in_viewList_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_search_name_in_viewList_inClassSession();
        inClassSessionPage.verify_details_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.verify_employees_schedule_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_add_employee_button_in_popup();

//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();
//
//
//        new_employees.click_on_employee_check_box();
//
//        employee_action.click_on_action_dropdown_button_employee_action();
//        employee_action.verify_employee_popup_option_present_on_page();
//        employee_action.click_on_add_program_option_employee_action();
//        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
//        employeeProfile.select_on_In_class_program__button();
//        employeeProfile.verify_In_class_program_details_present();
//
//        employeeProfile.Click_on_programs_dropdown();
//        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
//        employeeProfile.select_session_program_from_the_dropdown();
//        employeeProfile.Click_on_session_dropdown();
//        employeeProfile.verify_display_list_of_session();
//        //employeeProfile.verify_display_list_of_session_present();
//        employeeProfile.select_session_from_the_dropdown();
//        employeeProfile.click_on_add_program_submit_button();
//        employeeProfile.verify_add_program_popup_session_required_validation_msg_display();
//
//
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_backward_forward_arrow_of_session_list(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-028");
        Logger.log_qase_id("NEV-029");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on backward forward arrow of session list");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        inClassSessionPage.click_on_list_to_grid_converter_of_session_list();
        inClassSessionPage.click_on_forward_arrow_of_session_list();
        inClassSessionPage.click_on_backward_arrow_of_session_list();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_count_of_employees_on_session_when_adds_any_employee_to_the_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-030");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify count of employees on session when adds any employee to the session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();

        program_page.click_on_add_employee_button();
        program_page.verify_add_to_program_pop_up_is_visible_on_page();
        program_page.search_employee_to_add_program("Ziva Patel");
        program_page.verify_Ziva_patel_employee_display();
        inClassSessionPage.verify_selected_Employee_count();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_play_button_the_active_session_player_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_IS_032");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on play button the active session player page");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
      //  inClassSessionPage.verify_active_in_class_session_present_on_page();
        inClassSessionPage.click_on_play_icon_available_on_active_card();
        inClassSessionPage.verify_redirect_to_player_screen();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_kebab_menu_of_active_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_IS_033,TC_IS_009");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify kebab menu of active session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_schedule_is_present_on_inClassSession_page();
        inClassSessionPage.verify_active_in_class_session_present_on_page();
        inClassSessionPage.click_on_active_session_kebab_button();
        inClassSessionPage.verify_resume_option_present();
        inClassSessionPage.verify_completed_option_present();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_resume_of_active_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_IS_034");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on resume of active session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_active_in_class_session_present_on_page();
        inClassSessionPage.click_on_active_session_kebab_button();
        inClassSessionPage.verify_resume_option_present();
        inClassSessionPage.click_on_resume_option();
        inClassSessionPage.verify_redirect_to_player_screen();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_Complete_of_active_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_IS_035");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Complete of active session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_active_in_class_session_present_on_page();
        inClassSessionPage.click_on_active_session_kebab_button();
        inClassSessionPage.verify_completed_option_present();
        inClassSessionPage.click_on_completed_option();
        inClassSessionPage.verify_completed_session_popup_present();
        inClassSessionPage.click_on_confirm_button();
        inClassSessionPage.verify_completed_session_display();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_cancel_button_Complete_session(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_IS_036");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cancel button Complete session");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        inClassSessionPage = new inClassSession_page(driver);
        login.performLogin(userName, password);
        employeeProfile = new employeeProfile(driver);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();

        inClassSessionPage.verify_more_option_session_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_more_option_session_inClassSession();
        inClassSessionPage.verify_start_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.click_start_option();
        inClassSessionPage.verify_redirect_to_player_screen();

        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_active_in_class_session_present_on_page();

        inClassSessionPage.verify_active_in_class_session_present_on_page();

        inClassSessionPage.verify_more_option_session_inClassSession_is_present_on_page();
        inClassSessionPage.click_on_more_option_session_inClassSession();
        inClassSessionPage.verify_start_button_session_inClassSession_is_present_on_page();
        inClassSessionPage.click_start_option();
        inClassSessionPage.verify_redirect_to_player_screen();

        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();

        inClassSessionPage.verify_inClassSession_option_tab_is_present_on_page();
        inClassSessionPage.click_on_inClassSession_tab();
        inClassSessionPage.verify_active_in_class_session_present_on_page();
        inClassSessionPage.click_on_active_session_kebab_button();
        inClassSessionPage.verify_completed_option_present();
        inClassSessionPage.click_on_completed_option();
        inClassSessionPage.click_on_cancel_button_in_completed_session_popup();
        inClassSessionPage.verify_active_in_class_session_present_on_page();
    }
}
