package WebUITests.scheduledReportsTest;

import io.unity.core.data.TestData;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.newEmployeesPage.new_employees;
import web.object_repository.scheduledReportsPage.scheduled_reports;
import web.object_repository.login.login_page;

public class ScheduledReportsTest extends base {

    login_page login = null;
    scheduled_reports scheduled_reports = null;

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
    public void verify_when_clicks_on_scheduled_reports(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-190");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on scheduled reports");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();


    }

    @Test(dataProvider = "login_credentials")
    public void verify_the_content_on_the_scheduled_reports_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-191");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify the content on the scheduled reports page");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.verify_scheduled_reports_search_option_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_search_for_the_program_in_search_box(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-195");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when search for the program in search box");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.verify_scheduled_reports_search_option_is_present_on_page();
        scheduled_reports.enter_text_at_scheduled_reports_search("Reports");
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_selects_scheduled_report_from_new_report(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-196");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when selects scheduled report from new report");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cross_button_on_new_scheduled_report_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-198");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cross button on new scheduled report popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_cross_button_is_present_on_page();
        scheduled_reports.click_on_cross_button();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.verify_scheduled_reports_search_option_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_on_new_scheduled_report_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-206");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button on new scheduled report popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_cross_button_is_present_on_page();
        scheduled_reports.click_on_cancel_button();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.verify_scheduled_reports_search_option_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_continue_without_selecting_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-207");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on continue without selecting program");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_cross_button_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_program_is_require_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_kebab_icon(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-192");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on kebab icon");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_kebab_icon_is_present_on_page();
        scheduled_reports.click_on_kebab_icon();
        scheduled_reports.verify_edit_option_is_present_on_page();
        try {
            scheduled_reports.verify_deactivate_option_is_present_on_page();
        } catch (Exception e) {
            scheduled_reports.verify_activate_option_is_present_on_page();
        }
        scheduled_reports.verify_run_now_option_is_present_on_page();
        scheduled_reports.verify_delete_option_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_edit_from_kebab_icon(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-193");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on edit from kebab icon");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_kebab_icon_is_present_on_page();
        scheduled_reports.click_on_kebab_icon();
        scheduled_reports.verify_edit_option_is_present_on_page();
        scheduled_reports.click_on_edit_option();
        scheduled_reports.verify_edit_schedules_report_header_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_the_content_on_the_new_scheduled_report_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-197");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify the content on the new scheduled report popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_cross_button_is_present_on_page();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.verify_programs_text_is_present_on_page();
        scheduled_reports.verify_completion_text_is_present_on_page();
        scheduled_reports.verify_aggregate_text_is_present_on_page();
        scheduled_reports.verify_cancel_button_is_present_on_page();
        scheduled_reports.verify_continue_button_is_present_on_page();
    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_help_icon_of_programs_completion_aggregate_on_scheduled_report_popup(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NP-199");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on help icon of programs completion aggregate on scheduled report popup");
//
//        login = new login_page(driver);
//        scheduled_reports = new scheduled_reports(driver);
//        login.performLogin(userName, password);
//
//        scheduled_reports.verify_reports_navigation_is_present_on_page();
//        scheduled_reports.click_on_reports_navigation();
//        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
//        scheduled_reports.click_on_scheduled_reports_tab();
//        scheduled_reports.verify_new_reports_button_is_present_on_page();
//        scheduled_reports.click_on_new_reports_button();
//        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
//        scheduled_reports.click_on_scheduled_reports_option();
//        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
//        scheduled_reports.verify_program_help_icon_is_present_on_page();
//        scheduled_reports.verify_completion_help_icon_is_present_on_page();
//        scheduled_reports.verify_aggregate_help_icon_is_present_on_page();
//    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_All_programs_of_scheduled_report_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-200");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on All programs of scheduled report popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_the_dropdown_of_programs(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-201");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on the dropdown of programs");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_program_drop_down_is_present_on_page();
        scheduled_reports.click_on_program_drop_down();
        scheduled_reports.verify_all_option_in_Drop_Down_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_aggregate_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-204");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on aggregate dropdown");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_aggregate_drop_down_is_present_on_page();
        scheduled_reports.click_on_aggregate_drop_down();
        scheduled_reports.verify_aggregate_option_in_drop_down_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_the_content_of_the_Schedule_step(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-305");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify the content of the Schedule step");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.verify_name_text_box_is_present_on_page();
        scheduled_reports.verify_start_text_box_is_present_on_page();
        scheduled_reports.verify_every_text_box_is_present_on_page();
        scheduled_reports.verify_send_to_text_box_is_present_on_page();


        scheduled_reports.verify_schedule_button_is_present_on_page();
        scheduled_reports.verify_back_button_is_present_on_page();
        scheduled_reports.verify_cancel_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enters_name_of_the_report_on_scheduled_report_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-298");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when enters name of the report on scheduled report popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.enter_text_at_name_text_box("Automation");
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Day_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-302");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Day dropdown");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.verify_days_drop_down_is_present_on_page();
        scheduled_reports.click_on_days_drop_down();
        scheduled_reports.verify_days_option_is_present_on_page();
        scheduled_reports.verify_weeks_option_is_present_on_page();
        scheduled_reports.verify_months_option_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_schedule_without_entering_number_of_days(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-306");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on schedule without entering number of days");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.clear_every_text_box();
        scheduled_reports.click_on_schedule_button();
        scheduled_reports.verify_amount_error_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_back_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-315");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on back button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
//        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
//        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.click_on_back_button();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_selects_days(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-303");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when selects days");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.verify_every_text_box_is_present_on_page();
        scheduled_reports.enter_text_at_every_text_box("2");

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enters_more_than_100_in_Every(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-304");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when enters more than 100 in Every");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.verify_every_text_box_is_present_on_page();
        scheduled_reports.enter_text_at_every_text_box("100");

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Week(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-307");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Week");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.click_on_days_drop_down();
        scheduled_reports.click_on_weeks_option();
        scheduled_reports.verify_DaysOf_Week_option_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_schedule_without_selecting_day_of_week(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-308");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on schedule without selecting day of week");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.click_on_days_drop_down();
        scheduled_reports.click_on_weeks_option();
        scheduled_reports.click_on_schedule_button();
        scheduled_reports.verify_value_require_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_schedule_without_selecting_number_of_weeks(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-309");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on schedule without selecting number of weeks");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.click_on_days_drop_down();
        scheduled_reports.click_on_weeks_option();
        scheduled_reports.clear_every_text_box();
        scheduled_reports.click_on_schedule_button();
        scheduled_reports.verify_amount_error_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_selects_months_from_the_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-310");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when selects months from the dropdown");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.click_on_days_drop_down();
        scheduled_reports.click_on_months_option();
        scheduled_reports.verify_DaysOf_Month_option_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_activate_deactivate_from_kebab_icon(String userName, String password, String agency_name) {

        Logger.log_qase_id("NP-194");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on activate deactivate from kebab icon");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_kebab_icon_is_present_on_page();
        scheduled_reports.click_on_kebab_icon();
        scheduled_reports.verify_edit_option_is_present_on_page();
        scheduled_reports.click_on_active_deactivate_option();
        scheduled_reports.verify_successful_validation_msg_present();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_start_text_box_is_present_on_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-299");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify start text box is present on page");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.verify_start_text_box_is_present_on_page();
        scheduled_reports.click_on_start_text_box();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_day_of_week(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-311");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select day of week");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.click_on_days_drop_down();
        scheduled_reports.click_on_weeks_option();
        scheduled_reports.verify_DaysOf_Week_option_is_present_on_page();
        scheduled_reports.click_on_monday_option();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_selects_1st_15th_date_of_the_month(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-312");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when selects 1st 15th date of the month");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.click_on_days_drop_down();
        scheduled_reports.click_on_months_option();
        scheduled_reports.verify_DaysOf_Month_option_is_present_on_page();
        scheduled_reports.click_on_fifteen_option();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_schedule_without_selecting_day_of_months(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-314");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on schedule without selecting day of months");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.click_on_days_drop_down();
        scheduled_reports.click_on_months_option();
        scheduled_reports.click_on_schedule_button();
        scheduled_reports.verify_value_require_alert_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_delete_from_kebab_icon(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-920");
        Logger.log_qase_id("NP-921");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on delete from kebab icon");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();;
        scheduled_reports.click_on_kebab_icon_on_page();
        scheduled_reports.verify_delete_option_is_present_on_page();
        scheduled_reports.click_on_delete_option();
        scheduled_reports.verify_delete_scheduled_report_pop_up_is_present_on_page();
        scheduled_reports.verify_cross_button_is_present_on_page();
        scheduled_reports.verify_cancel_button_of_pop_up__is_present_on_page();
        scheduled_reports.verify_confirm_button_is_present_on_page();
        scheduled_reports.click_on_cross_button();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_confirm_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-922");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on confirm button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();;
        scheduled_reports.click_on_kebab_icon_on_page();
        scheduled_reports.verify_delete_option_is_present_on_page();
        scheduled_reports.click_on_delete_option();
        scheduled_reports.verify_delete_scheduled_report_pop_up_is_present_on_page();
        scheduled_reports.click_on_confirm_button();
        scheduled_reports.verify_schedule_report_deleted_toast_message_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_cancel_button_in_scheduled(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-923");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button in scheduled");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();;
        scheduled_reports.click_on_kebab_icon_on_page();
        scheduled_reports.verify_delete_option_is_present_on_page();
        scheduled_reports.click_on_delete_option();
        scheduled_reports.verify_delete_scheduled_report_pop_up_is_present_on_page();
        scheduled_reports.click_on_cancel_button_of_pop_up();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_selects_more_than_one_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-202");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when selects more than one program");
        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);
        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.click_on_program_drop_down();
        scheduled_reports.click_on_multiple_program_checkbox();
      //  scheduled_reports.verify_selected_program_in_drop_down_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_schedule_without_selecting_date(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-313");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks schedule without selecting date");
        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.click_on_program_drop_down();
        scheduled_reports.click_on_multiple_program_checkbox();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.enter_text_at_name_text_box("Testing");
        scheduled_reports.click_on_schedule_button();
        scheduled_reports.verify_start_date_is_required_validation_message();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_the_cross_button_of_recipient_mail(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-320");
        Logger.log_qase_id("NP-321,TC_SR_038");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on the cross button of recipient mail");
        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.click_on_program_drop_down();
        scheduled_reports.click_on_multiple_program_checkbox();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.enter_text_at_name_text_box(TestData.random_alphabetic_string(10));
        scheduled_reports.click_on_calender_icon();
        scheduled_reports.click_on_any_date();
        scheduled_reports.enter_text_at_send_to_text_box("viral@nevvon.com");
       scheduled_reports.click_on_cross_icon_of_send_to_text_box();
       scheduled_reports.click_on_schedule_button();
       scheduled_reports.verify_recipient_is_required_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_schedule_after_entering_necessary_details(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-316");
        Logger.log_qase_id("NP-318");
        Logger.log_qase_id("NP-319");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on schedule after entering necessary details");
        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.click_on_program_drop_down();
        scheduled_reports.click_on_multiple_program_checkbox();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.enter_text_at_name_text_box(TestData.random_alphabetic_string(10));
        scheduled_reports.click_on_calender_icon();
        scheduled_reports.click_on_any_date();
        scheduled_reports.enter_text_at_send_to_text_box("viral@nevvon.com");
        scheduled_reports.enter_text_at_send_to_text_box("pragya@nevvon.com");
        scheduled_reports.click_on_schedule_button();
        scheduled_reports.verify_schedule_report_created_successfully_toast_message();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_the_angle_up_icon_of_Every(String userName, String password, String agency_name) {

        Logger.log_qase_id("NP-300");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on the angle up icon of Every");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.verify_name_text_box_is_present_on_page();
        scheduled_reports.verify_start_text_box_is_present_on_page();
        scheduled_reports.verify_every_text_box_is_present_on_page();
        scheduled_reports.verify_up_arrow_in_every_drop_down_date_message();
        scheduled_reports.click_on_up_arrow_in_every_drop_down_date();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_the_angle_down_icon_of_Every(String userName, String password, String agency_name) {

        Logger.log_qase_id("NP-301");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on the angle down icon of Every");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_new_reports_button_is_present_on_page();
        scheduled_reports.click_on_new_reports_button();
        scheduled_reports.verify_scheduled_reports_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_option();
        scheduled_reports.verify_new_scheduled_report_header_option_is_present_on_page();
        scheduled_reports.verify_all_button_is_present_on_page();
        scheduled_reports.click_on_all_button();
        scheduled_reports.verify_all_selected_in_Drop_Down_is_present_on_page();
        scheduled_reports.click_on_continue_button();
        scheduled_reports.verify_content_text_is_present_on_page();
        scheduled_reports.verify_name_text_box_is_present_on_page();
        scheduled_reports.verify_start_text_box_is_present_on_page();
        scheduled_reports.verify_every_text_box_is_present_on_page();
        scheduled_reports.verify_up_arrow_in_every_drop_down_date_message();
        scheduled_reports.click_on_up_arrow_in_every_drop_down_date();
        scheduled_reports.verify_down_arrow_in_every_drop_down_date_message();
        scheduled_reports.click_on_down_arrow_in_every_drop_down_date();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_Run_now_in_schedule_report(String userName, String password, String agency_name) {

        Logger.log_qase_id("TC_SR_042");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Run now in schedule report");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        scheduled_reports.verify_scheduled_reports_tab_option_is_present_on_page();
        scheduled_reports.click_on_scheduled_reports_tab();
        scheduled_reports.verify_kebab_icon_is_present_on_page();
        scheduled_reports.click_on_kebab_icon();
        scheduled_reports.verify_edit_option_is_present_on_page();

        scheduled_reports.verify_run_now_option_is_present_on_page();
        scheduled_reports.click_on_run_now_button();
    }
}

