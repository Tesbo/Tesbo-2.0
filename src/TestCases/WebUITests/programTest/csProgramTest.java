package WebUITests.programTest;

import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.remotegrid.LambdaTestConfig;
import io.unity.performaction.autoweb.Window;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.csAgencySettingsPage.csAgencySettings_page;
import web.object_repository.csHomePage.csHome_page;
import web.object_repository.csdashboard.dashboard_page;
import web.object_repository.employeeActionPage.employee_action;
import web.object_repository.login.login_page;
import web.object_repository.newEmployeesPage.new_employees;
import web.object_repository.program.program_page;
import web.object_repository.csSessionPage.csSession_page;

public class csProgramTest extends base {
    login_page login = null;
    program_page program_page = null;
    csHome_page csHome = null;
    dashboard_page dashboardPage = null;
    new_employees newEmployees = null;
    csSession_page sessionPage = null;
    employee_action employeeAction = null;
    csAgencySettings_page csAgencySettingsPage = null;
    Window window = null;

    @DataProvider(name = "in_class_data")
    public Object[][] in_class_data_provider(){
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("csData.xlsx", 18);
        return data;
    }

    @DataProvider(name = "in_class_data_errors")
    public Object[][] in_class_errors_data_provider(){
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("csData.xlsx", 19);
        return data;
    }

    @DataProvider(name = "session_data")
    public Object[][] in_class_session_data(){
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("csData.xlsx", 20);
        return data;
    }

    @DataProvider(name = "session_data1")
    public Object[][] in_class_session_data1(){
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("csData.xlsx", 21);
        return data;
    }

    @DataProvider(name = "cs_program_data")
    public Object[][] cs_program_data(){
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("csData.xlsx", 22);
        return data;
    }

    @DataProvider(name = "meatball_menu_data")
    public Object[][] cs_program_meatball_menu_data(){
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("csData.xlsx", 23);
        return data;
    }

    @DataProvider(name = "hha_data")
    public Object[][] hhaExchange_data(){
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("csData.xlsx", 24);
        return data;
    }

    /**
     * CS Panel in-class session tests
     */

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_clicks_on_new_session_button(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_044");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_clicks_on_new_session_button");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.verify_fields_on_details_tab();
    }

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_clicks_on_new_session_button_details_fields(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_045");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_clicks_on_new_session_button_details_fields");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.verify_training_hours();
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.clear_seats_text_field();
        program_page.click_on_seat_up_button();
        program_page.clear_seats_text_field();
        program_page.click_on_seat_down_button();
        program_page.click_on_in_class_checkbox();
        program_page.verify_in_class_checkbox_is_unchecked();
        program_page.click_on_online_checkbox();
        program_page.verify_online_checkbox_is_checked();
    }

    @Test(dataProvider = "in_class_data_errors")
    public void to_verify_when_click_on_continue_button_without_entering_mandatory_fields(String username, String password, String agencyName, String program, String errors, String range){
        Logger.log_qase_id("TC_IS_046");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_click_on_continue_button_without_entering_mandatory_fields");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.verify_in_class_checkbox_is_checked();
        program_page.click_on_in_class_checkbox();
        program_page.verify_in_class_checkbox_is_unchecked();
        program_page.verify_online_checkbox_is_unchecked();
        program_page.click_on_continue_button();
        program_page.verify_mandatory_errors(errors);
    }

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_clicks_on_new_session_button_when_in_class_field_is_selected(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_047");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_clicks_on_new_session_button_when_in_class_field_is_selected");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
    }

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_clicks_on_new_session_button_when_online_field_is_selected(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_048");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_clicks_on_new_session_button_when_online_field_is_selected");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.verify_online_checkbox_is_unchecked();
        program_page.click_on_online_checkbox();
        program_page.enter_url_in_event_url_field(url);
    }

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_clicks_on_add_field_button(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_049");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_clicks_on_add_field_button");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.click_on_add_field_button();
        program_page.enter_value_in_new_field_name_and_new_field_value(newEmployees);
        program_page.click_on_remove_new_field_button_presence();
    }

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_click_on_new_session_button_with_schedule_tab(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_051");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_click_on_new_session_button_with_schedule_tab");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_repeat_checkbox();
        program_page.enter_text_in_session_frequency_field(frequency);
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_days_type_option();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.enter_session_end_date(format, (long)(Integer.parseInt(days.replace(".",""))/10));
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_weeks_type_option();
        program_page.select_week_day_and_verify_it_is_selected();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_after_end_type_option();
        program_page.enter_value_in_sessions_textbox(newEmployees, range.substring(0,index));
    }

    @Test(dataProvider = "in_class_data_errors")
    public void to_verify_when_click_on_create_session_button_without_entering_mandatory_fields(String username, String password, String agencyName, String program, String errors, String range){
        Logger.log_qase_id("TC_IS_052");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_click_on_create_session_button_without_entering_mandatory_fields");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.click_on_continue_button();
        program_page.verify_mandatory_errors(errors);
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_weeks_type_option();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.verify_mandatory_errors(errors);
        program_page.click_on_end_type_dropdown();
        program_page.click_on_after_end_type_option();
        program_page.verify_mandatory_errors(errors);
    }

    @Test(dataProvider = "in_class_data_errors")
    public void to_verify_that_selecting_repeat_checkbox_displays_additional_fields(String username, String password, String agencyName, String program, String errors, String range){
        Logger.log_qase_id("TC_IS_054");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_that_selecting_repeat_checkbox_displays_additional_fields");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
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

    @Test(dataProvider = "in_class_data_errors")
    public void to_verify_when_selecting_on_from_the_end_type_dropdown(String username, String password, String agencyName, String program, String errors, String range){
        Logger.log_qase_id("TC_IS_055");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_selecting_on_from_the_end_type_dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.verify_session_end_date_field_is_present();
    }

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_selecting_specific_date_from_ends_label_datepicker(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_056");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_selecting_specific_date_from_ends_label_datepicker");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.enter_session_end_date(format, (long)(Integer.parseInt(days.replace(".",""))/10));
        program_page.click_on_session_end_date_field();
        program_page.click_on_highlighted_date();
    }

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_selecting_after_from_ends_dropdown(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_057");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_selecting_after_from_ends_dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_after_end_type_option();
        program_page.verify_sessions_textbox_field_is_present();
    }

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_entering_number_in_the_sessions_textbox(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_058");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_entering_number_in_the_sessions_textbox");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0, index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_after_end_type_option();
        program_page.enter_value_in_sessions_textbox(newEmployees, range.substring(0, index));
    }

    @Test(dataProvider = "in_class_data")
    public void to_verify_when_selecting_weeks_from_session_recurring_type_dropdown(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_059");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_selecting_weeks_from_session_recurring_type_dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_repeat_checkbox();
        program_page.verify_repeat_checkbox_is_checked();
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_weeks_type_option();
        program_page.verify_week_days_field_is_present();
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_Selecting_multiple_weekdays_from_the_grid(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
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

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_Selecting_On_from_the_ends_with_dropdown(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_063");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
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

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_Selecting_after_from_the_ends_with_dropdown(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_065");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
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

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_click_on_back_button_from_schedule_tab(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_068");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_back_button_from_schedule_tab");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.click_on_continue_button();
        program_page.click_on_back_button_from_schedule_tab();
        program_page.verify_user_is_on_details_tab();
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_click_on_cancel_button_from_new_session_pop_up(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_069");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_cancel_button_from_new_session_pop_up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.click_on_cancel_button_from_new_session_pop_up();
        program_page.verify_user_is_on_in_class_sessions_tab();
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_click_on_cross_icon_from_new_session_pop_up(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_070");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_cross_icon_from_new_session_pop_up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        program_page.verify_user_is_on_in_class_sessions_tab();
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_creating_session(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_071");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_creating_session");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_continue_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_starting_session(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_072");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_starting_session");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_seats_and_verify(newEmployees, range.substring(0,index));
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_continue_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.click_on_start_session_button_from_edit_session_dialog();
        sessionPage.verify_language_dropdown_present();
        sessionPage.verify_view_fullscreen_button_present();
        sessionPage.verify_load_automatically_checkbox_present();
        sessionPage.verify_next_lesson_button_present_at_bottom();
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_session_is_created(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_073");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_session_is_created");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_seat_number("2");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_continue_button();
        program_page.click_on_cancel_button_on_edit_dialog();
        program_page.verify_session_title();
        program_page.verify_session_supervisor();
        program_page.verify_session_seats();
        program_page.verify_session_location();
        program_page.verify_session_description();
        program_page.click_on_schedule_button();
        program_page.verify_session_date();
        program_page.verify_session_time();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        String title = program_page.get_session_title();
        program_page.verify_session_title_on_card(title);
        program_page.verify_session_supervisor_on_card();
        program_page.verify_session_seats_on_card();
        program_page.verify_session_date_on_card();
        program_page.verify_session_time_on_card();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_click_on_session_title_in_session_card(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_074");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.verify_edit_button();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_click_on_edit_button_in_session_editable_dialog(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_075");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.verify_cancel_button_on_edit_dialog();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_click_on_cross_icon_from_session_edit_dialog(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_076");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.verify_edit_button();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        program_page.verify_user_is_on_in_class_sessions_tab();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_updating_session_details_from_session_edit_dialog(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_077");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        String seats = program_page.fetch_seats();
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_seat_number(String.valueOf(newEmployees.generate_number(range.substring(0,index))));
        String currentSupervisor = program_page.fetch_current_supervisor();
        program_page.enter_text_in_supervisor_field(newEmployees.generate_string(4));
        program_page.click_on_update_button_from_edit_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.verify_session_supervisor();
        program_page.click_on_schedule_button();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_update_button_from_edit_session_pop_up();
        program_page.verify_edit_button();
        program_page.wait_for_few_seconds();
        program_page.verify_session_date();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_clicking_on_cancel_after_updating_details_in_session_edit_dialog(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_078");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_cancel_after_updating_details_in_session_edit_dialog");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_session_title_button();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
        program_page.click_on_edit_button();
        program_page.verify_update_button_is_displayed_on_edit_pop_up();
        String seats = program_page.fetch_seats();
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_seat_number(String.valueOf(newEmployees.generate_number(range.substring(0,index))));
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
        //program_page.select_schedule_date(format);
        program_page.enter_schedule_start_date(format);
        program_page.click_on_cancel_button_on_edit_dialog();
        program_page.wait_for_few_seconds();
        program_page.verify_session_date_is_not_changed(currentDate);
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_clicking_on_kebab_menu_on_session_card(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_079");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_more_options_icon();
        program_page.verify_edit_session_button_on_kebab_menu();
        program_page.verify_manage_attendance_button_on_kebab_menu();
        program_page.verify_start_button_on_kebab_menu();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_clicking_on_edit_session_on_session_card(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_080");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_more_options_icon();
        program_page.verify_edit_session_button_on_kebab_menu();
        program_page.click_on_edit_session_button_on_kebab_menu();
        program_page.verify_edit_button();
        program_page.verify_schedule_tab_button();
        program_page.verify_details_tab_button();
        program_page.verify_cross_icon();
        program_page.verify_start_session_button_is_displayed_on_edit_session_pop_up();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_clicking_on_manage_attendance_in_session_card(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_081");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_more_options_icon();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.verify_add_employees_button_on_manage_attendance_pop_up();
        program_page.verify_refresh_button_on_manage_attendance_pop_up();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_clicking_on_add_employee_button_from_manage_attendance_pop_up(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_082");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_more_options_icon();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_add_employee_button_from_manage_attendance_pop_up();
        employeeAction.verify_user_is_on_employees_page();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_adding_employee_to_in_class_session(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_083");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        String sessionDetails = program_page.get_session(session);
        program_page.click_on_more_options_icon();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_add_employee_button_from_manage_attendance_pop_up();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.search_employee(employee);
        employeeAction.verify_first_employee_checkout_employee_action_is_present_on_page();
        employeeAction.click_on_first_employee_checkout_employee_action();
        employeeAction.click_on_actions();
        employeeAction.click_on_add_program_option_employee_action();
        employeeAction.click_on_in_class_program_button();
        employeeAction.click_on_programs_dropdown();
        employeeAction.select_given_program(program);
        employeeAction.verify_selected_program_displayed(program);
        employeeAction.click_on_sessions_dropdown();
        employeeAction.select_given_session(sessionDetails);
        employeeAction.click_on_submit();
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_session_title_on_card(session);
        program_page.click_on_more_options_icon();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.search_employee_in_manage_attendance(employee);
        program_page.click_on_more_icon_of_given_employee();
        program_page.click_on_remove_from_program_button_on_manage_attendance();
        program_page.click_on_remove_final_in_pop_up();
        program_page.wait_for_few_seconds();
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_recurring_session_is_created(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_084");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.wait_until_spinner_disappear();
        program_page.click_on_given_program(program);
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
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_schedule_end_time();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_repeat_checkbox();
        int index = 0;
        for(int i = 0; i<frequency.length(); i++){
            if(frequency.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_text_in_session_frequency_field(frequency.substring(0,index));
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_days_type_option();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.enter_session_end_date(format,(long)(Integer.parseInt(days.replace(".",""))/10));
        program_page.wait_for_few_seconds();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_continue_button();
        program_page.wait_for_few_seconds();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        program_page.verify_recurring_sessions_created(title);
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_session_end_date_is_before_start_date(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_085");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_seat_number("2");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_repeat_checkbox();
        program_page.enter_text_in_session_frequency_field(frequency);
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_days_type_option();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_on_end_type_option();
        program_page.enter_before_date_in_end_date(format,(long)(Integer.parseInt(days.replace(".",""))/10));
        program_page.click_on_new_session_pop_up();
        program_page.click_on_continue_button();
        program_page.verify_error_of_end_date_before_start_date();
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_download_completed_session_report(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_more_option_of_completed_session();
        program_page.click_on_session_report_button();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_clicking_on_edit_all_recurring_session(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_086");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_edit_all_recurring_session");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.find_recurring_session();
        program_page.verify_session_is_recurring_session();
        program_page.click_on_more_options_icon();
        program_page.click_on_edit_all_recurring_session_button();
        program_page.verify_start_session_button_is_not_present();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_when_updating_recurring_details_field(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_087");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_updating_recurring_details_field");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.find_recurring_session();
        program_page.verify_session_is_recurring_session();
        program_page.click_on_more_options_icon();
        program_page.click_on_edit_all_recurring_session_button();
        program_page.verify_start_session_button_is_not_present();
        program_page.click_on_edit_button();
        program_page.enter_text_in_supervisor_field(newEmployees.generate_string(4));
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_update_button_from_edit_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.verify_session_supervisor();
        program_page.verify_session_location();
        program_page.verify_session_description();
        program_page.click_on_schedule_button();
        program_page.click_on_edit_button();
        program_page.verify_session_start_date_field_is_disabled();
        program_page.verify_repeat_checkbox_is_disabled();
    }

    @Test(dataProvider = "session_data")
    public void To_verify_employee_should_not_be_added_in_completed_session(String username, String password, String agencyName, String program, String session, String format, String employee, String range){
        Logger.log_qase_id("TC_IS_090");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_employee_should_not_be_added_in_completed_session");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        String sessionDetails = program_page.get_session(program_page.get_completed_session());
        program_page.click_on_more_options_icon();
        program_page.click_on_manage_attendance_button_on_kebab_menu();
        program_page.verify_header_on_manage_attendance_pop_up();
        program_page.click_on_add_employee_button_from_manage_attendance_pop_up();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.search_employee(employee);
        employeeAction.verify_first_employee_checkout_employee_action_is_present_on_page();
        employeeAction.click_on_first_employee_checkout_employee_action();
        employeeAction.click_on_actions();
        employeeAction.click_on_add_program_option_employee_action();
        employeeAction.click_on_in_class_program_button();
        employeeAction.click_on_programs_dropdown();
        employeeAction.select_given_program(program);
        employeeAction.verify_selected_program_displayed(program);
        employeeAction.click_on_sessions_dropdown();
        employeeAction.enter_session_name_in_search_session_textbox(sessionDetails);
        employeeAction.verify_completed_session_not_present_in_the_choose_session_dropdown();
    }

    @Test(dataProvider = "session_data1")
    public void To_verify_when_clicking_on_mark_as_attended_from_manage_attendance_pop_up(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String employee){
        Logger.log_qase_id("TC_IS_091");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_mark_as_attended_from_manage_attendance_pop_up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_seat_number("2");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.click_on_continue_button();
        program_page.click_on_cancel_button_on_edit_dialog();
        program_page.verify_session_title();
        program_page.verify_session_supervisor();
        program_page.verify_session_seats();
        program_page.verify_session_location();
        program_page.verify_session_description();
        program_page.click_on_schedule_button();
        program_page.verify_session_date();
        program_page.verify_session_time();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        String title = program_page.get_session_title();
        program_page.verify_session_title_on_card(title);
        program_page.verify_session_supervisor_on_card();
        program_page.verify_session_seats_on_card();
        program_page.verify_session_date_on_card();
        program_page.verify_session_time_on_card();
        String sessionDetails = program_page.get_session(title);
        csAgencySettingsPage.click_on_employees_link();

        employeeAction.verify_user_is_on_employees_page();
        employeeAction.search_employee(employee);
        employeeAction.verify_first_employee_checkout_employee_action_is_present_on_page();
        employeeAction.click_on_first_employee_checkout_employee_action();
        employeeAction.click_on_actions();
        employeeAction.click_on_add_program_option_employee_action();
        employeeAction.click_on_in_class_program_button();
        employeeAction.click_on_programs_dropdown();
        employeeAction.select_given_program(program);
        employeeAction.verify_selected_program_displayed(program);
        employeeAction.click_on_sessions_dropdown();
        employeeAction.select_given_session(sessionDetails);
        employeeAction.click_on_submit();

        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_manage_attendance_from_card();
        program_page.search_employee_in_manage_attendance(employee);
        program_page.verify_employee_added_to_session();
        program_page.click_on_actions_icon_from_manage_attendance_pop_up();
        String currentWindow = window.get_current_window_handle("tree");
        program_page.click_on_start_button_from_manage_attendance_pop_up();
        window.find_new_window_and_switch(currentWindow);
        sessionPage.verify_language_dropdown_present();
        sessionPage.verify_next_lesson_button_present_at_bottom();
        sessionPage.verify_load_automatically_checkbox_present();
        sessionPage.verify_view_fullscreen_button_present();
        window.switch_to_windows_and_close(currentWindow);

        program_page.click_on_cancel_from_manage_attendance();
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_active_session_title_on_card(title);
        program_page.click_on_manage_attendance_from_card();
        program_page.search_employee_in_manage_attendance(employee);
        program_page.verify_status_is_pending_in_manage_attendance_pop_up();
        program_page.click_on_more_icon_of_given_employee();
        program_page.click_on_mark_as_attend_button();
        program_page.wait_for_few_seconds();
        program_page.verify_status_is_attended_in_manage_attendance_pop_up();

        program_page.click_on_more_icon_of_given_employee();
        program_page.click_on_remove_from_program_button_on_manage_attendance();
        program_page.click_on_remove_final_in_pop_up();
        program_page.wait_for_few_seconds();
    }

    @Test(dataProvider = "session_data1")
    public void To_verify_when_clicking_on_mark_as_absent_from_manage_attendance_pop_up(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String employee){
        Logger.log_qase_id("TC_IS_092");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_mark_as_absent_from_manage_attendance_pop_up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_seat_number("2");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.click_on_continue_button();
        program_page.click_on_cancel_button_on_edit_dialog();
        program_page.verify_session_title();
        program_page.verify_session_supervisor();
        program_page.verify_session_seats();
        program_page.verify_session_location();
        program_page.verify_session_description();
        program_page.click_on_schedule_button();
        program_page.verify_session_date();
        program_page.verify_session_time();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        String title = program_page.get_session_title();
        program_page.verify_session_title_on_card(title);
        program_page.verify_session_supervisor_on_card();
        program_page.verify_session_seats_on_card();
        program_page.verify_session_date_on_card();
        program_page.verify_session_time_on_card();
        String sessionDetails = program_page.get_session(title);
        csAgencySettingsPage.click_on_employees_link();

        employeeAction.verify_user_is_on_employees_page();
        employeeAction.search_employee(employee);
        employeeAction.verify_first_employee_checkout_employee_action_is_present_on_page();
        employeeAction.click_on_first_employee_checkout_employee_action();
        employeeAction.click_on_actions();
        employeeAction.click_on_add_program_option_employee_action();
        employeeAction.click_on_in_class_program_button();
        employeeAction.click_on_programs_dropdown();
        employeeAction.select_given_program(program);
        employeeAction.verify_selected_program_displayed(program);
        employeeAction.click_on_sessions_dropdown();
        employeeAction.select_given_session(sessionDetails);
        employeeAction.click_on_submit();

        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_manage_attendance_from_card();
        program_page.search_employee_in_manage_attendance(employee);
        program_page.verify_employee_added_to_session();
        program_page.click_on_actions_icon_from_manage_attendance_pop_up();
        String currentWindow = window.get_current_window_handle("tree");
        program_page.click_on_start_button_from_manage_attendance_pop_up();
        window.find_new_window_and_switch(currentWindow);
        sessionPage.verify_language_dropdown_present();
        sessionPage.verify_next_lesson_button_present_at_bottom();
        sessionPage.verify_load_automatically_checkbox_present();
        sessionPage.verify_view_fullscreen_button_present();
        window.switch_to_windows_and_close(currentWindow);

        program_page.click_on_cancel_from_manage_attendance();
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_active_session_title_on_card(title);
        program_page.click_on_manage_attendance_from_card();
        program_page.search_employee_in_manage_attendance(employee);
        program_page.verify_status_is_pending_in_manage_attendance_pop_up();
        program_page.click_on_more_icon_of_given_employee();
        program_page.click_on_mark_as_absent_button();
        program_page.wait_for_few_seconds();
        program_page.verify_status_is_absent_in_manage_attendance_pop_up();

        program_page.click_on_more_icon_of_given_employee();
        program_page.click_on_remove_from_program_button_on_manage_attendance();
        program_page.click_on_remove_final_in_pop_up();
        program_page.wait_for_few_seconds();
    }

    @Test(dataProvider = "session_data1")
    public void To_verify_when_remove_from_program_from_manage_attendance_pop_up(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String employee){
        Logger.log_qase_id("TC_IS_093");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_remove_from_program_from_manage_attendance_pop_up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_seat_number("2");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.click_on_continue_button();
        program_page.click_on_cancel_button_on_edit_dialog();
        program_page.verify_session_title();
        program_page.verify_session_supervisor();
        program_page.verify_session_seats();
        program_page.verify_session_location();
        program_page.verify_session_description();
        program_page.click_on_schedule_button();
        program_page.verify_session_date();
        program_page.verify_session_time();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        String title = program_page.get_session_title();
        program_page.verify_session_title_on_card(title);
        program_page.verify_session_supervisor_on_card();
        program_page.verify_session_seats_on_card();
        program_page.verify_session_date_on_card();
        program_page.verify_session_time_on_card();
        String sessionDetails = program_page.get_session(title);
        csAgencySettingsPage.click_on_employees_link();

        employeeAction.verify_user_is_on_employees_page();
        employeeAction.search_employee(employee);
        employeeAction.verify_first_employee_checkout_employee_action_is_present_on_page();
        employeeAction.click_on_first_employee_checkout_employee_action();
        employeeAction.click_on_actions();
        employeeAction.click_on_add_program_option_employee_action();
        employeeAction.click_on_in_class_program_button();
        employeeAction.click_on_programs_dropdown();
        employeeAction.select_given_program(program);
        employeeAction.verify_selected_program_displayed(program);
        employeeAction.click_on_sessions_dropdown();
        employeeAction.select_given_session(sessionDetails);
        employeeAction.click_on_submit();

        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_manage_attendance_from_card();
        program_page.search_employee_in_manage_attendance(employee);
        program_page.verify_employee_added_to_session();
        program_page.click_on_more_icon_of_given_employee();
        program_page.click_on_remove_from_program_button_on_manage_attendance();
        program_page.click_on_remove_final_in_pop_up();
        program_page.wait_for_few_seconds();
    }

    @Test(dataProvider = "session_data1")
    public void To_verify_mark_as_attended_and_mark_as_absent_option_is_disabled_when_session_is_in_scheduled_state(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String employee){
        Logger.log_qase_id("TC_IS_094");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_mark_as_attended_and_mark_as_absent_option_is_disabled_when_session_is_in_scheduled_state");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_seat_number("2");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.click_on_continue_button();
        program_page.click_on_cancel_button_on_edit_dialog();
        program_page.verify_session_title();
        program_page.verify_session_supervisor();
        program_page.verify_session_seats();
        program_page.verify_session_location();
        program_page.verify_session_description();
        program_page.click_on_schedule_button();
        program_page.verify_session_date();
        program_page.verify_session_time();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        String title = program_page.get_session_title();
        program_page.verify_session_title_on_card(title);
        program_page.verify_session_supervisor_on_card();
        program_page.verify_session_seats_on_card();
        program_page.verify_session_date_on_card();
        program_page.verify_session_time_on_card();
        String sessionDetails = program_page.get_session(title);
        csAgencySettingsPage.click_on_employees_link();

        employeeAction.verify_user_is_on_employees_page();
        employeeAction.search_employee(employee);
        employeeAction.verify_first_employee_checkout_employee_action_is_present_on_page();
        employeeAction.click_on_first_employee_checkout_employee_action();
        employeeAction.click_on_actions();
        employeeAction.click_on_add_program_option_employee_action();
        employeeAction.click_on_in_class_program_button();
        employeeAction.click_on_programs_dropdown();
        employeeAction.select_given_program(program);
        employeeAction.verify_selected_program_displayed(program);
        employeeAction.click_on_sessions_dropdown();
        employeeAction.select_given_session(sessionDetails);
        employeeAction.click_on_submit();

        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_manage_attendance_from_card();
        program_page.search_employee_in_manage_attendance(employee);
        program_page.verify_employee_added_to_session();
        program_page.verify_status_is_scheduled_in_manage_attendance_pop_up();
        program_page.click_on_more_icon_of_given_employee();
        program_page.verify_mark_as_attended_button_is_disabled();
        program_page.verify_mark_as_absent_button_is_disabled();
        program_page.click_on_remove_from_program_button_on_manage_attendance();
        program_page.click_on_remove_final_in_pop_up();
        program_page.wait_for_few_seconds();
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_when_selecting_month_from_dropdown(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_061");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_selecting_month_from_dropdown");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
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
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_repeat_checkbox();
        program_page.enter_text_in_session_frequency_field(frequency);
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_months_type_option();
        program_page.click_on_on_day_dropdown();
        program_page.select_day_from_day_dropdown();
        program_page.click_on_end_type_dropdown();
        program_page.click_on_after_end_type_option();
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_value_in_sessions_textbox(newEmployees, range.substring(0,index));
        program_page.click_on_continue_button();
        program_page.click_on_cross_icon_from_new_session_pop_up();
        program_page.refresh_page();
        program_page.verify_recurring_sessions_created(title);
    }

    @Test(dataProvider = "in_class_data")
    public void To_verify_create_session_with_select_month_and_not_selecting_any_day(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String range){
        Logger.log_qase_id("TC_IS_062");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_create_session_with_select_month_and_not_selecting_any_day");

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
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
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
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.click_on_repeat_checkbox();
        program_page.enter_text_in_session_frequency_field(frequency);
        program_page.click_on_session_recurring_type_dropdown();
        program_page.select_months_type_option();

        program_page.click_on_end_type_dropdown();
        program_page.click_on_after_end_type_option();
        int index = 0;
        for(int i = 0; i<range.length(); i++){
            if(range.charAt(i)=='.'){
                index = i;
                break;
            }
        }
        program_page.enter_value_in_sessions_textbox(newEmployees, range.substring(0,index));
        program_page.click_on_continue_button();
        program_page.verify_on_day_field_mandatory_error_message();
    }

    @Test(dataProvider = "session_data1")
    public void To_verify_user_switches_tab_after_saving_session_in_edit_mode(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String employee){
        Logger.log_qase_id("TC_IS_095");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_switches_tab_after_saving_session_in_edit_mode");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.click_on_given_program(program);
        program_page.click_on_in_class_sessions_tab();
        program_page.click_on_new_session_button();
        program_page.enter_text_in_title_field(newEmployees);
        String supervisor = newEmployees.generate_string(4);
        program_page.enter_text_in_supervisor_field(supervisor);
        program_page.enter_seat_number("2");
        program_page.verify_in_class_checkbox_is_checked();
        program_page.enter_text_in_location_field_and_verify(newEmployees);
        program_page.enter_text_in_description_field(newEmployees);
        program_page.click_on_continue_button();
        program_page.enter_schedule_start_date(format);
        program_page.click_on_schedule_start_time();
        program_page.select_start_time_value();
        program_page.click_on_schedule_end_time();
        program_page.select_end_time_value();
        program_page.click_on_new_session_pop_up();
        program_page.wait_for_few_seconds();
        program_page.click_on_continue_button();
        program_page.click_on_cancel_button_on_edit_dialog();
        program_page.verify_session_title();
        program_page.verify_session_supervisor();
        program_page.verify_session_seats();
        program_page.verify_session_location();
        program_page.verify_session_description();
        program_page.click_on_schedule_button();
        program_page.verify_session_date();
    }

    /**
     * CS Panel programs tests
     */

    @Test(dataProvider = "session_data1")
    public void To_verify_user_clicks_on_agency(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String employee){
        Logger.log_qase_id("TC_PP_001");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_clicks_on_agency");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.verify_programs_link();
        csAgencySettingsPage.verify_employees_link();
        program_page.verify_settings_link();
        program_page.verify_reports_link();
        program_page.verify_helps_link();
    }

    @Test(dataProvider = "session_data1")
    public void To_verify_user_clicks_on_programs_module(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String employee){
        Logger.log_qase_id("TC_PP_002");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_clicks_on_agency");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link();
        program_page.verify_non_operational_tab_link();
        program_page.verify_add_programs_button();
    }

    @Test(dataProvider = "session_data1")
    public void To_verify_user_add_program_button(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String employee){
        Logger.log_qase_id("TC_PP_003");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_add_program_button");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.verify_cancel_button_on_add_program_pop_up();
        program_page.verify_add_button_on_add_program_pop_up();
        program_page.verify_close_add_program_pop_up();
    }

    @Test(dataProvider = "session_data1")
    public void To_verify_when_clicking_on_add_button_without_selecting_program(String username, String password, String agencyName, String program, String url, String format, String hours, String minutes, String endHours, String days, String frequency, String employee){
        Logger.log_qase_id("TC_PP_004");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_clicking_on_add_button_without_selecting_program");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.verify_cancel_button_on_add_program_pop_up();
        program_page.verify_add_button_on_add_program_pop_up();
        program_page.verify_close_add_program_pop_up();
        program_page.click_on_add_button_on_add_program_pop_up();
        program_page.verify_select_program_mandatory_error();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_when_adding_program_to_agency(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_005");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_adding_program_to_agency");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.enter_text_in_program_searchbox(program1);
        program_page.select_searched_program();
        program_page.verify_delete_icon();
        program_page.verify_add_button_on_add_program_pop_up();
        program_page.click_on_add_button_on_add_program_pop_up();
        program_page.wait_until_add_program_pop_up_disappear();
        program_page.verify_non_operational_tab_link();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program1);
        program_page.click_on_action_icon_of_program();
        program_page.verify_remove_from_agency_button_is_visible();
        program_page.click_on_remove_from_agency_button();
        program_page.verify_remove_button_is_visible_on_confirmation_pop_up();
        program_page.click_on_remove_button_from_pop_up();
        program_page.verify_removed_successfully_pop_up_message();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_when_deleting_selected_program_from_pop_up(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_006");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_deleting_selected_program_from_pop_up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.enter_text_in_program_searchbox(program1);
        program_page.select_searched_program();
        program_page.verify_searched_program_selected(program1);
        program_page.click_on_delete_icon_of_program(program1);
        program_page.verify_searched_program_selected(program1);
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_add_button_with_select_multiple_program(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_007");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_add_button_with_select_multiple_program");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.enter_text_in_program_searchbox(program1);
        program_page.select_searched_program();
        program_page.verify_searched_program_selected(program1);
        program_page.enter_text_in_program_searchbox(program2);
        program_page.select_searched_program();
        program_page.verify_searched_program_selected(program2);
        program_page.verify_add_button_on_add_program_pop_up();
        program_page.click_on_add_button_on_add_program_pop_up();
        program_page.wait_until_add_program_pop_up_disappear();
        program_page.verify_non_operational_tab_link();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program1);
        program_page.click_on_action_icon_of_program();
        program_page.verify_remove_from_agency_button_is_visible();
        program_page.click_on_remove_from_agency_button();
        program_page.verify_remove_button_is_visible_on_confirmation_pop_up();
        program_page.click_on_remove_button_from_pop_up();
        program_page.verify_removed_successfully_pop_up_message();
        program_page.verify_added_program(program2);
        program_page.click_on_action_icon_of_program();
        program_page.verify_remove_from_agency_button_is_visible();
        program_page.click_on_remove_from_agency_button();
        program_page.verify_remove_button_is_visible_on_confirmation_pop_up();
        program_page.click_on_remove_button_from_pop_up();
        program_page.verify_removed_successfully_pop_up_message();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_cancel_button_without_selecting_program(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_008");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_cancel_button_without_selecting_program");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_cancel_button_on_add_programs_pop_up();
        program_page.click_on_cancel_program_button_on_programs();
        program_page.wait_until_add_program_pop_up_disappear();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_cancel_button_with_selecting_program(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_009");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_cancel_button_with_selecting_program");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.enter_text_in_program_searchbox(program1);
        program_page.select_searched_program();
        program_page.verify_searched_program_selected(program1);
        program_page.verify_cancel_button_on_add_programs_pop_up();
        program_page.click_on_cancel_program_button_on_programs();
        program_page.wait_until_add_program_pop_up_disappear();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_cancel_button_with_selecting_multiple_program(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_010");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_cancel_button_with_selecting_multiple_program");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.enter_text_in_program_searchbox(program1);
        program_page.select_searched_program();
        program_page.verify_searched_program_selected(program1);
        program_page.enter_text_in_program_searchbox(program2);
        program_page.select_searched_program();
        program_page.verify_searched_program_selected(program2);
        program_page.verify_cancel_button_on_add_programs_pop_up();
        program_page.click_on_cancel_program_button_on_programs();
        program_page.wait_until_add_program_pop_up_disappear();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_close_button_on_add_programs_pop_up(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_011");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_close_button_on_add_programs_pop_up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_close_icon_on_add_programs_pop_up();
        program_page.click_on_close_icon_from_add_programs_pop_up();
        program_page.wait_until_add_program_pop_up_disappear();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_non_operational_tab_programs(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_012");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_non_operational_tab_programs");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_deactivated_programs_on_non_operational_tab();
    }

    @Test(dataProvider = "meatball_menu_data")
    public void To_verify_meatball_menu(String username, String password, String agencyName, String partner){
        Logger.log_qase_id("TC_PP_013");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_meatball_menu");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_deactivated_programs_on_non_operational_tab();
        program_page.verify_hhaexchange_pay_code_button();
    }
    @Test(dataProvider = "cs_program_data")
    public void To_verify_copy_api_id_button(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_014");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_copy_api_id_button");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.select_any_program();
        program_page.click_on_action_link_of_any_program();
        program_page.verify_copy_api_id_button();
        program_page.click_on_copy_api_id_button();
        program_page.verify_api_id_copied_pop_up_message();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_activate_button(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_015");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_activate_button");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.enter_text_in_program_searchbox(program1);
        program_page.select_searched_program();
        program_page.verify_delete_icon();
        program_page.verify_add_button_on_add_program_pop_up();
        program_page.click_on_add_button_on_add_program_pop_up();
        program_page.wait_until_add_program_pop_up_disappear();
        program_page.verify_non_operational_tab_link();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program1);
        program_page.click_on_action_icon_of_program();
        program_page.verify_activate_button();
        program_page.click_on_activate_button();
        program_page.verify_program_activated_message_pop_up();
        program_page.verify_operational_tab_link();
        program_page.click_on_operational_tab();
        program_page.verify_operational_tab_link_on_focus();
        program_page.refresh_page();
        program_page.verify_added_program(program1);
        program_page.click_on_action_icon_of_program();
        program_page.verify_remove_from_agency_button_is_visible();
        program_page.click_on_remove_from_agency_button();
        program_page.verify_remove_button_is_visible_on_confirmation_pop_up();
        program_page.click_on_remove_button_from_pop_up();
        program_page.verify_removed_successfully_pop_up_message();
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_hhaexchange_paycode_field(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_016");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_hhaexchange_paycode_field");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_non_payable_is_enable(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_017");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_non_payable_is_enable");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_on_non_payable_button();
        program_page.verify_save_button_on_edit_hhaexchange_pop_up();
        program_page.click_on_save_button_from_edit_hhaexchange_pop_up();
        program_page.verify_hha_edit_successfull_pop_up();
        program_page.verify_program_has_given_status(nonPayableStatus);
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_non_payable_is_disable(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_018");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_non_payable_is_disable");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_off_non_payable_button();
        program_page.verify_paycode_dropdown();
        program_page.click_on_paycode_dropdown();
        program_page.select_none_from_paycode_dropdown();
        program_page.verify_save_button_on_edit_hhaexchange_pop_up();
        program_page.click_on_save_button_from_edit_hhaexchange_pop_up();
        program_page.verify_hha_edit_successfull_pop_up();
        program_page.verify_program_has_given_status(payableStatus);
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_paycode_dropdown(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_019");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_paycode_dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_off_non_payable_button();
        program_page.verify_paycode_dropdown();
        program_page.click_on_paycode_dropdown();
        program_page.verify_none_paycode_option();
        program_page.verify_alternate_paycode_option();
        program_page.verify_in_service_paycode_option();
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_nevvon_in_service_in_paycode_dropdown(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_020");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_nevvon_in_service_in_paycode_dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_off_non_payable_button();
        program_page.verify_paycode_dropdown();
        program_page.click_on_paycode_dropdown();
        program_page.select_in_service_from_paycode_dropdown();
        program_page.verify_save_button_on_edit_hhaexchange_pop_up();
        program_page.click_on_save_button_from_edit_hhaexchange_pop_up();
        program_page.verify_hha_edit_successfull_pop_up();
        program_page.verify_program_has_given_status(inServiceStatus);
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_nevvon_alternate_in_paycode_dropdown(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_021");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_nevvon_alternate_in_paycode_dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_off_non_payable_button();
        program_page.verify_paycode_dropdown();
        program_page.click_on_paycode_dropdown();
        program_page.select_alternate_from_paycode_dropdown();
        program_page.verify_save_button_on_edit_hhaexchange_pop_up();
        program_page.click_on_save_button_from_edit_hhaexchange_pop_up();
        program_page.verify_hha_edit_successfull_pop_up();
        program_page.verify_program_has_given_status(alternateStatus);
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_none_in_paycode_dropdown(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_022");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_none_in_paycode_dropdown");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_off_non_payable_button();
        program_page.verify_paycode_dropdown();
        program_page.click_on_paycode_dropdown();
        program_page.select_none_from_paycode_dropdown();
        program_page.verify_save_button_on_edit_hhaexchange_pop_up();
        program_page.click_on_save_button_from_edit_hhaexchange_pop_up();
        program_page.verify_hha_edit_successfull_pop_up();
        program_page.verify_program_has_given_status(payableStatus);
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_delayed_is_enabled(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_023");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_delayed_is_enabled");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_off_non_payable_button();
        program_page.toggle_on_delayed_button();
        program_page.verify_save_button_on_edit_hhaexchange_pop_up();
        program_page.click_on_save_button_from_edit_hhaexchange_pop_up();
        program_page.verify_hha_edit_successfull_pop_up();
        program_page.verify_delay_icon_is_present();
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_delayed_is_disabled(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_024");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_delayed_is_disabled");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_off_non_payable_button();
        program_page.toggle_off_delayed_button();
        program_page.verify_save_button_on_edit_hhaexchange_pop_up();
        program_page.click_on_save_button_from_edit_hhaexchange_pop_up();
        program_page.verify_hha_edit_successfull_pop_up();
        program_page.verify_delay_icon_not_present();
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_count_towards_compliance_is_enabled(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_025");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_count_towards_compliance_is_enabled");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_off_non_payable_button();
        program_page.toggle_on_count_towards_compliance_button();
        program_page.verify_save_button_on_edit_hhaexchange_pop_up();
        program_page.click_on_save_button_from_edit_hhaexchange_pop_up();
        program_page.verify_hha_edit_successfull_pop_up();
    }

    @Test(dataProvider = "hha_data")
    public void To_verify_count_towards_compliance_is_disabled(String username, String password, String agencyName, String program, String partner, String nonPayableStatus, String payableStatus, String alternateStatus, String inServiceStatus){
        Logger.log_qase_id("TC_PP_026");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_count_towards_compliance_is_disabled");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_and_navigate_to_settings_page();
        csAgencySettingsPage.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettingsPage.click_on_integrations_link();
        if(!csAgencySettingsPage.partner_integrated_with_agency()) {
            if(!csAgencySettingsPage.get_partner_name_of_integration_page().equalsIgnoreCase(partner)){
                csAgencySettingsPage.click_on_edit_button_on_settings_page();
                csAgencySettingsPage.remove_integration_from_agency();
                csAgencySettingsPage.verify_agency_not_integrated_with_partner_on_integration_page();
                csAgencySettingsPage.select_given_integration_partner(partner);
            }
        }
        else {
            csAgencySettingsPage.select_given_integration_partner(partner);
        }
        program_page.click_on_programs_link();
        program_page.verify_operational_tab_link_on_focus();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_hhaexchange_button();
        program_page.click_on_hhaexchange_button();
        program_page.verify_edit_hhaexchange_pop_up();
        program_page.toggle_off_non_payable_button();
        program_page.toggle_off_count_towards_compliance_button();
        program_page.verify_save_button_on_edit_hhaexchange_pop_up();
        program_page.click_on_save_button_from_edit_hhaexchange_pop_up();
        program_page.verify_hha_edit_successfull_pop_up();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_remove_from_agency_field(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_027");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_remove_from_agency_field");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.enter_text_in_program_searchbox(program1);
        program_page.select_searched_program();
        program_page.verify_delete_icon();
        program_page.verify_add_button_on_add_program_pop_up();
        program_page.click_on_add_button_on_add_program_pop_up();
        program_page.wait_until_add_program_pop_up_disappear();
        program_page.verify_non_operational_tab_link();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program1);
        program_page.click_on_action_icon_of_program();
        program_page.verify_remove_from_agency_button_is_visible();
        program_page.click_on_remove_from_agency_button();
        program_page.verify_remove_button_is_visible_on_confirmation_pop_up();
        program_page.verify_cancel_button_is_visible_on_confirmation_pop_up();
        program_page.verify_prompt_message_on_remove_program_pop_up(program1);
        program_page.click_on_remove_button_from_pop_up();
        program_page.verify_removed_successfully_pop_up_message();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_cancel_button_at_remove_from_agency_pop_up(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_028");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_cancel_button_at_remove_from_agency_pop_up");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_non_operational_tab_link();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        String program = program_page.select_any_program();
        program_page.click_on_action_icon_of_program();
        program_page.verify_remove_from_agency_button_is_visible();
        program_page.click_on_remove_from_agency_button();
        program_page.verify_cancel_button_is_visible_on_confirmation_pop_up();
        program_page.click_on_cancel_button_from_remove_program_pop_up();
        program_page.verify_program_present_on_page(program);
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_remove_program_from_agency(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_029");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_remove_program_from_agency");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.click_on_add_program_button_on_programs();
        program_page.verify_program_search_textbox();
        program_page.enter_text_in_program_searchbox(program1);
        program_page.select_searched_program();
        program_page.verify_delete_icon();
        program_page.verify_add_button_on_add_program_pop_up();
        program_page.click_on_add_button_on_add_program_pop_up();
        program_page.wait_until_add_program_pop_up_disappear();
        program_page.verify_non_operational_tab_link();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.verify_added_program(program1);
        program_page.click_on_action_icon_of_program();
        program_page.verify_remove_from_agency_button_is_visible();
        program_page.click_on_remove_from_agency_button();
        program_page.verify_remove_button_is_visible_on_confirmation_pop_up();
        program_page.click_on_remove_button_from_pop_up();
        program_page.verify_removed_successfully_pop_up_message();
        program_page.verify_program_absent_on_page(program1);
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_when_changing_layout_to_list_view(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_030");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_changing_layout_to_list_view");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.wait_until_spinner_disappear();
        program_page.click_on_layout_button();
        program_page.verify_view_toggled_to_list_view();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_when_changing_layout_to_grid_view(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_031");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_changing_layout_to_grid_view");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.wait_until_spinner_disappear();
        program_page.click_on_layout_button();
        program_page.verify_view_toggled_to_list_view();
        program_page.click_on_layout_button();
        program_page.verify_view_toggled_to_grid_view();
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_when_deactivating_the_program(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_032");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_deactivating_the_program");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.wait_until_spinner_disappear();
        String program = program_page.select_any_program();
        program_page.click_on_action_icon_of_program();
        program_page.click_on_deactivate_option();
        program_page.verify_program_deactivated_successfully();
        program_page.verify_non_operational_tab_link();
        program_page.click_on_non_operational_tab();
        program_page.verify_non_operational_tab_link_on_focus();
        program_page.refresh_page();
        program_page.wait_until_spinner_disappear();
        program_page.verify_added_program(program);
        program_page.click_on_action_icon_of_program();
        program_page.verify_activate_button();
        program_page.click_on_activate_button();
        program_page.verify_program_activated_message_pop_up();
        program_page.verify_operational_tab_link();
        program_page.click_on_operational_tab();
        program_page.verify_operational_tab_link_on_focus();
        program_page.refresh_page();
        program_page.wait_until_spinner_disappear();
        program_page.search_program(program);
        program_page.verify_added_program(program);
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_user_is_able_to_redirect_on_program_detail_page(String username, String password, String agencyName, String program1, String program2){
        Logger.log_qase_id("TC_PP_033");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_redirect_on_program_detail_page");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.wait_until_spinner_disappear();
        String program = program_page.select_any_program();
        program_page.click_on_given_program(program);
        program_page.verify_user_is_on_the_clicked_program_page(program);
    }

    @Test(dataProvider = "cs_program_data")
    public void To_verify_in_class_session_Test(String username, String password, String agencyName, String program1, String program2) {
        Logger.log_qase_id("TC_PP_034");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_in_class_session_Test");

        login = new login_page(driver);
        program_page = new program_page(driver);
        csHome = new csHome_page(driver);
        dashboardPage = new dashboard_page(driver);
        sessionPage = new csSession_page(driver);
        csAgencySettingsPage = new csAgencySettings_page(driver);
        employeeAction = new employee_action(driver);
        window = new Window(driver);
        newEmployees = new new_employees(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.click_on_agency_from_agency_list();
        dashboardPage.verify_csuser_is_on_agency_dashboard(agencyName);
        program_page.click_on_programs_link();
        program_page.verify_add_programs_button();
        program_page.verify_program_is_present_on_page();
        program_page.click_on_program_present_in_class_session();
        program_page.click_on_in_class_sessions_tab();
        program_page.verify_in_class_session_page_field();
    }
}