package WebUITests.reportsTests;

import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.login.login_page;
import web.object_repository.reports.reports_page;
import web.object_repository.scheduledReportsPage.scheduled_reports;

public class reportsTest extends base {

    login_page login = null;
    scheduled_reports scheduled_reports = null;
    reports_page reports_page = null;

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
    public void verify_when_click_on_reports(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-4");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on reports");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_search_for_the_program_in_search_box_report_history(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-903");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when search for the program in search box report history");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_search_text_box_reports_history_is_present_on_page();
        reports_page.click_on_search_text_box_reports_history();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_New_report_button_report_history(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-904");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on New report button.");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_One_time_report_button_report_history(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-905");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on one time report button.");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cross_button_on_Newreport_popup(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-906");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cross button on New report popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.click_on_cross_button_report_history();
        reports_page.verify_new_report_reports_history_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_help_icon_of_programs_completion_aggregate_data_range_on_new_report_report_popup(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-907");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on help icon of programs completion aggregate data range on new report report popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_all_button_report_button_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.verify_aggregate_label_report_history_is_present_on_page();
        reports_page.verify_completion_label_report_history_is_present_on_page();
        reports_page.verify_date_range_label_report_history_is_present_on_page();
        reports_page.verify_generate_button_report_history_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_All_link_from_new_reports_popup(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-908");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_when_clicks_on_All_link_from_new_reports_popup");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_all_button_report_button_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.verify_aggregate_label_report_history_is_present_on_page();
        reports_page.verify_completion_label_report_history_is_present_on_page();
        reports_page.verify_date_range_label_report_history_is_present_on_page();
        reports_page.verify_generate_button_report_history_is_present_on_page();
        reports_page.click_on_all_button_report_button();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_the_dropdown_of_Programs_report_history(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-909");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on the dropdown of Programs report history");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_all_button_report_button_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.verify_aggregate_label_report_history_is_present_on_page();
        reports_page.verify_completion_label_report_history_is_present_on_page();
        reports_page.verify_date_range_label_report_history_is_present_on_page();
        reports_page.verify_generate_button_report_history_is_present_on_page();
        reports_page.verify_program_placeholder_report_history_is_present_on_page();
        reports_page.click_on_program_placeholder_report_history();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Lessons_Modules_Programs_reports_history(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-911");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Lessons/Modules/Programs");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_all_button_report_button_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.verify_lesson_select_report_history_is_present_on_page();
        reports_page.click_on_lesson_select_report_history();
        reports_page.verify_module_select_report_history_is_present_on_page();
        reports_page.click_on_module_select_report_history();
        reports_page.verify_program_course_report_history_is_present_on_page();
        reports_page.click_on_program_course_report_history();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Aggregate_dropdown_reports_history(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-912");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Aggregate dropdown report history");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_all_button_report_button_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        scheduled_reports.verify_aggregate_drop_down_is_present_on_page();
        scheduled_reports.click_on_aggregate_drop_down();
        scheduled_reports.verify_aggregate_option_in_drop_down_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_select_per_user_Aggregate_in_dropdown_reports_history(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-1053");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select per user Aggregate in dropdown report history");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_all_button_report_button_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.click_on_program_placeholder_report_history();
        reports_page.verify_program_checkbox_one_report_history_is_present_on_page();
        reports_page.click_on_program_checkbox_one_report_history();

        scheduled_reports.verify_aggregate_drop_down_is_present_on_page();
        scheduled_reports.click_on_aggregate_drop_down();
        scheduled_reports.verify_aggregate_option_in_drop_down_is_present_on_page();
        scheduled_reports.click_on_per_user_aggregate_option();
        reports_page.click_on_set_specific_dates_report_history();
        reports_page.click_on_all_date_button_report_history();
        reports_page.click_on_generate_button_report_history();
        reports_page.verify_generated_per_user_report_present_on_report_history_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Specific_date_from_calendar_in_date_range(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-914");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Specific date from calendar in date range");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_all_button_report_button_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.verify_set_specific_dates_report_history_is_present_on_page();
        reports_page.click_on_set_specific_dates_report_history();
    }
    @Test(dataProvider = "login_credentials")
    public void verify_without_selecting_specific_date_then_click_on_generate_button(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-1052");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify without selecting specific date then click on generate button");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_all_button_report_button_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.click_on_program_placeholder_report_history();
        reports_page.verify_program_checkbox_one_report_history_is_present_on_page();
        reports_page.click_on_program_checkbox_one_report_history();

        reports_page.verify_set_specific_dates_report_history_is_present_on_page();
        reports_page.click_on_set_specific_dates_report_history();
        reports_page.verify_date_range_text_box_report_history_is_present_on_page();
        reports_page.click_on_generate_button_report_history();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edit_date_and_time_report_history(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-5");
        Logger.log_qase_id("NEV-6");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when edit date and time report history");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.verify_first_download_button_report_history_is_present_on_page();
        reports_page.verify_first_date_report_history();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_selects_more_than_one_program_report_history(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-910");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when selects more than one program report history");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_all_button_report_button_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.click_on_program_placeholder_report_history();
        reports_page.verify_program_checkbox_one_report_history_is_present_on_page();
        reports_page.verify_program_checkbox_two_report_history_is_present_on_page();
        reports_page.click_on_program_checkbox_one_report_history();
       // reports_page.click_on_program_checkbox_two_report_history();
        reports_page.verify_program_text_box_after_selection_report_history_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_All_date_link_of_the_reports(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-913");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on All date link of the  report history");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.verify_set_specific_dates_report_history_is_present_on_page();
        reports_page.click_on_set_specific_dates_report_history();
        reports_page.verify_date_range_text_box_report_history_is_present_on_page();
        reports_page.verify_all_date_button_report_history_is_present_on_page();
        reports_page.click_on_all_date_button_report_history();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Generate_button_reports(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-915");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Generate button reports");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.click_on_all_button_report_button();
        reports_page.verify_set_specific_dates_report_history_is_present_on_page();
        reports_page.verify_generate_button_report_history_is_present_on_page();
        reports_page.click_on_generate_button_report_history();

        reports_page.verify_generated_report_present_on_report_history_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Generate_button_without_selecting_program_completion_aggerate_data_range(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-916");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Generate button without selecting program / completion / aggerate / data range report history");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
        reports_page.verify_new_report_reports_history_is_present_on_page();
        reports_page.click_on_new_report_reports_history();
        reports_page.verify_one_time_report_button_is_present_on_page();
        reports_page.click_on_one_time_report_button();
        reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_program_label_report_history_is_present_on_page();
        reports_page.click_on_generate_button_report_history();
        reports_page.verify_program_is_required_alert_report_history_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Download_icon_report_history(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-917");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Download icon report history");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        reports_page = new reports_page(driver);
        login.performLogin(userName, password);

        scheduled_reports.verify_reports_navigation_is_present_on_page();
        scheduled_reports.click_on_reports_navigation();
        reports_page.verify_reports_page_title_is_present_on_page();
       //reports_page.verify_new_report_reports_history_is_present_on_page();
        //reports_page.click_on_new_report_reports_history();
        //reports_page.verify_one_time_report_button_is_present_on_page();
        //reports_page.click_on_one_time_report_button();
       // reports_page.verify_new_report_header_pop_up_is_present_on_page();
        reports_page.verify_first_download_button_report_history_is_present_on_page();
        reports_page.click_on_first_download_button_report_history();
    }
}
