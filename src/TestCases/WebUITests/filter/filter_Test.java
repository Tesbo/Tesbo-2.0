package WebUITests.filter;

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


public class filter_Test extends base
{

    login_page login = null;
    employeeProfile employeeProfile = null;

   new_employees new_employees = null;
    filter filter = null;
    employee_action employee_action = null;

    scheduled_reports scheduled_reports = null;
    program_page program_page = null;

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
    public void To_verify_when_clicks_on_Filters_button (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_003");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Filters button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.verify_filter_open_filter_panel();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_discipline_for_the_agency_show(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-269");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on discipline for the agency show");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_select_all_the_checkbox_of_discipline_gets_selected(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-270,TC_PF_032");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on select all the checkbox of discipline gets selected");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_no_of_disciplines_selected_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_clear_the_checkbox_of_discipline_gets_selected(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-271");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on clear the checkbox of discipline gets selected");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_no_of_disciplines_selected_is_present_on_page();
        filter.verify_clear_button_is_present_on_page();
        filter.click_on_clear_button();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_select_the_checkbox_of_disciplines_the_total_count_of_selected_checkboxes_appears_next_to_discipline_title(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-272");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select the checkbox of disciplines the total count of selected checkboxes appears next to discipline title");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_no_of_disciplines_selected_is_present_on_page();
        filter.verify_no_of_disciplines_selected_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_And_the_selected_disciplines_are_applicable(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-273");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on And the selected disciplines are applicable");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_no_of_disciplines_selected_is_present_on_page();
        filter.verify_and_button_is_present_on_page();
        filter.click_on_and_button();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_Or_the_selected_disciplines_are_applicable(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-274");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Or the selected disciplines are applicable");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_no_of_disciplines_selected_is_present_on_page();
        filter.verify_or_button_is_present_on_page();
        filter.click_on_or_button();

    }

//    @Test(dataProvider = "login_credentials")
//    public void  verify_when_clicks_on_the_help_icon_it_redirects_to_the_relevant_page(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NP-275");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//        config.addTestName("verify when clicks on the help icon it redirects to the relevant page");
//
//        login = new login_page(driver);
//        new_employees = new new_employees(driver);
//        filter = new filter(driver);
//        login.performLogin(userName, password);
//
//        new_employees.verify_employees_Option_is_present_on_page();
//        new_employees.click_on_employees_Option();
//        filter.verify_filter_button_is_present_on_page();
//        filter.click_on_filter_button();
//        filter.click_on_disciplines_drop_down();
//        filter.verify_select_all_button_is_present_on_page();
//        filter.verify_help_icon_is_present_on_page();
//        filter.click_on_discipline_help_icon();
//    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_save_at_the_bottom_of_the_filters_panel(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-353");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on save at the bottom of the filters panel");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_save_filters_icon_is_present_on_page();
        filter.click_on_save_filters_icon();
        filter.verify_save_filters_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_cancel_button_of_save_filter_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-359");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button of save filter popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_save_filters_icon_is_present_on_page();
        filter.click_on_save_filters_icon();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_cancel_button_of_save_filters_is_present_on_page();
        filter.click_on_cancel_button_of_save_filters();
        filter.click_on_save_filters_icon();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_cross_button_of_save_filter_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-360");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cross button of save filter popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_save_filters_icon_is_present_on_page();
        filter.click_on_save_filters_icon();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_cross_button_of_save_filters_is_present_on_page();
        filter.click_on_cross_button_of_save_filters();
        filter.click_on_save_filters_icon();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_save_after_entering_filter_name(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-361");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on save after entering filter name");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_save_filters_icon_is_present_on_page();
        filter.click_on_save_filters_icon();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.enter_saved_filter_name("Govi");
        filter.click_on_save_button_of_save_filters();

    }
    @Test(dataProvider = "login_credentials")
    public void  To_verify_when_clicks_save_filter_from_upper_panel_button_after_applying_some_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_020,TC_EF_034");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks save filter from upper panel button after applying some filter");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_save_filter_link_in_employee();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.enter_saved_filter_name("Govi");
        filter.click_on_save_button_of_save_filters();
        employee_action.verify_successfully_active_validation_display();

        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        program_page.verify_remove_default_filter_option_is_present_on_page();
        program_page.click_on_remove_default_option();
        program_page.verify_remove_saved_filter_popup_present_on_page();
        program_page.click_confirm_button_of_remove_saved_filter_popup();
    }
    @Test(dataProvider = "login_credentials")
    public void  To_verify_when_clicks_on_cross_icon_on_remove_filter_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_035");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cross icon on remove filter popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();

        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        program_page.verify_remove_default_filter_option_is_present_on_page();
        program_page.click_on_remove_default_option();
        program_page.verify_remove_saved_filter_popup_present_on_page();
        program_page.click_on_cross_icon_of_remove_employees_pop_up();
        filter.verify_filter_button_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void  To_verify_when_clicks_on_cancel_button_on_remove_filter_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_036");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cancel button on remove filter popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();

        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        program_page.verify_remove_default_filter_option_is_present_on_page();
        program_page.click_on_remove_default_option();
        program_page.verify_remove_saved_filter_popup_present_on_page();
        program_page.click_cancel_button_of_remove_saved_filter_popup();
        filter.verify_filter_button_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void  To_verify_when_clicks_on_confirm_button_on_remove_filter_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_037");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on confirm button on remove filter popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.verify_filter_button_is_present_on_page();
        filter.click_on_save_filter_link_in_employee();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.enter_saved_filter_name("Govi");
        filter.click_on_save_button_of_save_filters();

        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        program_page.verify_remove_default_filter_option_is_present_on_page();
        program_page.click_on_remove_default_option();
        program_page.verify_remove_saved_filter_popup_present_on_page();
        program_page.click_confirm_button_of_remove_saved_filter_popup();
        filter.verify_filter_button_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void  To_verify_when_clicks_on_meatball_menu_on_the_saved_filter_from_upper_panel(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_027");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on meatball menu on the saved filter from upper panel");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        program_page.click_on_filter_meatball_button();
        program_page.verify_display_meatball_option();

    }
    @Test(dataProvider = "login_credentials")
    public void  To_verify_when_clicks_set_as_default_on_the_saved_filter_from_upper_panel(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_028,TC_EF_029");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks set as default on the saved filter from upper panel");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        filter.click_on_set_as_default_EP_option();


        filter.verify_filter_button_is_present_on_page();
        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        filter.click_on_unset_as_default_EP_option();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_unpin_on_top_panel(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_031");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on unpin on top panel");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        filter.click_on_unpin_EP_option();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_rename_on_top_panel(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_032");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on rename on top panel");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();

        program_page.click_on_save_filter();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.enter_saved_filter_name("Test Filter");
        filter.click_on_save_button_of_save_filters();

        program_page.click_on_filter_meatball_button();
        //program_page.verify_display_meatball_option();
        filter.click_on_rename_EP_option();

//        program_page.verify_rename_default_filter_option_is_present_on_page();
 //       program_page.click_on_rename_default_filter_option();
        program_page.verify_save_filters_popup_header_is_present_on_page();
        program_page.click_on_rename_text_box_of_save_filter_pop_up();
        program_page.enter_rename_of_default_save_filter_popup("test");
        program_page.click_on_save_button_of_save_filter_pop_up();
        program_page.verify_filter_updated_successfully_validation_msg_present();

    }
    @Test(dataProvider = "login_credentials")
    public void  To_verify_when_clicks_on_save_filter_from_side_panel_after_applying_some_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_025");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on save filter from side panel after applying some filter");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_save_filter_button_in_filter_panel();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.enter_saved_filter_name("Auto");
        filter.click_on_save_button_of_save_filters();
        employee_action.verify_successfully_active_validation_display();
    }
    @Test(dataProvider = "login_credentials")
    public void  To_verify_when_clicks_on_save_filter_from_side_panel_without_applying_any_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_026");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on save filter from side panel without applying any filter");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        employee_action.click_on_default_filter_employee_status_active_is_present();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_filter_button();
        filter.click_save_filter_button_in_filter_panel();
        filter.verify_unable_to_applied_filter_present_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_save_without_entering_name_of_the_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-358");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on save without entering name of the filter");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        filter.verify_filter_button_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.click_on_select_all_button();
        filter.verify_save_filters_icon_is_present_on_page();
        filter.click_on_save_filters_icon();
        filter.verify_save_filters_header_is_present_on_page();
        filter.verify_name_text_box_is_present_on_page();
        filter.verify_save_button_of_save_filters_is_present_on_page();
        filter.click_on_save_button_of_save_filters();
        filter.verify_name_is_required_alert_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_signed_up_drop_down(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-602");
        Logger.log_qase_id("NEV-603,TC_EF_004, TC_EF_005,TC_EF_007");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on signed up drop down");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        filter.click_on_signed_up_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.verify_clear_button_is_present_on_page();
      //  filter.verify_help_icon_is_present_on_page();
        filter.verify_yes_check_box_is_present_on_page();
        filter.verify_no_check_box_is_present_on_page();
        filter.click_on_yes_check_box();
        filter.click_on_apply_button();

        employee_action.click_on_default_filter_employee_status_active_is_present();
        filter.verify_signed_up_yes_employee_name_are_displayed_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_Select_all_link_in_signed_up_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_026");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on 'Select all' link in  signed up dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        filter.click_on_signed_up_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.verify_clear_button_is_present_on_page();

        filter.verify_yes_check_box_is_present_on_page();
        filter.verify_no_check_box_is_present_on_page();
        filter.select_all_link_in_signed_up_filter();
        filter.click_on_apply_button();

        filter.verify_signed_up_yes_employee_name_are_displayed_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_clear_link_in_signed_up_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_025");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on clear link in signed up dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        filter.click_on_signed_up_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.verify_clear_button_is_present_on_page();

        filter.verify_yes_check_box_is_present_on_page();
        filter.verify_no_check_box_is_present_on_page();
        filter.click_on_clear_link_in_signed_up_filter();
        filter.click_on_apply_button();

        filter.verify_signed_up_yes_employee_name_are_displayed_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_no_checkbox(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-604, TC_EF_006,TC_EF_008");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on no checkbox");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);


        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        filter.click_on_signed_up_drop_down();
        filter.verify_no_check_box_is_present_on_page();
        filter.click_on_no_check_box();
        filter.click_on_apply_button();

        employee_action.click_on_default_filter_employee_status_active_is_present();
        filter.verify_signed_up_no_employee_name_are_displayed_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_completed_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-600");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on completed button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_completed_filter_button();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_Applying_filter_with_completed_default_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_099");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Applying filter with completed default filter");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);
        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        //new_employees.verify_employees_Option_is_present_on_page();
        filter.click_on_completed_filter_button();
        filter.verify_completed_program_employee_display();
    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Reset_link(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-648");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Reset link");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        filter.click_on_reset_button_present_on_page();
        filter.verify_any_filter_available_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_save_after_selecting_the_discipline_checkboxes_of_filter_module(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-277");
        Logger.log_qase_id("NEV-280,TC_EF_009");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on save after selecting the discipline checkboxes of filter module");

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
        filter.click_on_disciplines_drop_down();
        filter.click_on_first_two_check_box_of_discipline_filter();
        filter.click_on_save_filters_at_bottom();
        filter.verify_save_filters_header_is_present_on_page();
       // filter.verify_selected_discipline_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_location_dropdown_of_filter_module(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-610,TC_EF_010");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on location dropdown of filter module");

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
       // filter.verify_help_icon_is_present_on_page();
        filter.verify_clear_button_is_present_on_page();
        filter.verify_first_check_box_of_location_is_present_on_page();
    }

//    @Test(dataProvider = "login_credentials")
//    public void verify_when_clicks_on_help_icon_of_filter_module_location(String userName, String password, String agency_name) {
//        Logger.log_qase_id("NEV-614");
//
//        LambdaTestConfig config = new LambdaTestConfig(driver);
//
//        config.addTestName("verify when clicks on help icon of filter module location");
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
    public void verify_when_clicks_on_clear_link_of_filter_module_location(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-613");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("verify when clicks on clear link of filter module location");

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
    public void To_verify_in_built_filter_on_employees_page (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_001");
        Logger.log_qase_id("TC_EF_002");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify in built filter on employees page");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_in_build_filters_available();
        employee_action.verify_default_filter_employee_status_active_is_present();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_language_dropdown (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_011");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on language dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
       filter.click_on_filter_button();
       filter.verify_language_dropdown_is_present();
       filter.click_on_language_dropdown();
       filter.select_language_from_the_dropdown();
       program_page.click_on_apply_button_in_program_filter();
       filter.verify_selected_language_displayed();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_applies_None_on_language_dropdown (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_057");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when applies None on language dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();
        filter.verify_language_dropdown_is_present();
        filter.click_on_language_dropdown();
        filter.select_none_language_option_from_the_dropdown();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_none_assigned_language_employee_displayed();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_employee_active_status_dropdown (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_013,TC_EF_064");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on employee active status dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();
        filter.verify_employee_status_dropdown_is_present();
        filter.click_on_employee_status_dropdown();
        filter.select_active_status_from_the_dropdown();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_active_status_displayed();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_employee_on_hold_status_dropdown (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_065");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on employee on hold status dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.click_on_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();

        employee_action.click_on_action_dropdown_set_status_to_option();

        employee_action.click_on_On_hold_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_hold_popup_display();
        employee_action.click_on_on_hold_popup_place_on_hold_button();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();
        filter.verify_employee_status_dropdown_is_present();
        filter.click_on_employee_status_dropdown();
        filter.click_on_employee_status_clear_link();
        filter.select_on_hold_status_from_the_dropdown();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_on_hold_status_displayed();


        employee_action.select_all_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();

        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.click_on_active_option_of_employee_action_dropdown();
        employee_action.verify_set_to_active_popup_display();
        employee_action.click_on_active_button_on_active_popup();
        employee_action.verify_successfully_active_validation_display();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_Employee_status_Terminated (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_066");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when select Employee status Terminated");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.click_on_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();

        employee_action.click_on_action_dropdown_set_status_to_option();

        employee_action.click_on_terminate_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_terminate_popup_display();
        employee_action.click_on_terminate_button_on_terminate_popup();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();
        filter.verify_employee_status_dropdown_is_present();
        filter.click_on_employee_status_dropdown();
        filter.click_on_employee_status_clear_link();
        filter.select_on_terminate_status_from_the_dropdown();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_on_terminate_status_displayed();

        employee_action.select_all_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();

        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.click_on_active_option_of_employee_action_dropdown();
        employee_action.verify_set_to_active_popup_display();
        employee_action.click_on_active_button_on_active_popup();
        employee_action.verify_successfully_active_validation_display();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_Employee_status_Select_all (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_067");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when select Employee status Select all");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();
        filter.verify_employee_status_dropdown_is_present();
        filter.click_on_employee_status_dropdown();
        filter.click_on_employee_status_clear_link();
        filter.click_on_select_all_employee_status_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_active_status_displayed();

    }
        @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_no_applicant_option (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_069");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when select no applicant option");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();


        filter.click_on_filter_button();
        filter.verify_applicant_dropdown_present();
        filter.click_applicant_dropdown();
        filter.click_on_No_applicant_option();
        program_page.click_on_apply_button_in_program_filter();


        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();

        //filter.verify_No_applicant_employee_display();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_yes_applicant_option (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_068");
        Logger.log_qase_id("TC_EF_070");


        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when select yes applicant option");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        filter.verify_applicant_dropdown_present();
        filter.click_applicant_dropdown();
        filter.click_on_yes_applicant_option();
        program_page.click_on_apply_button_in_program_filter();

        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();

        //filter.verify_yes_applicant_employee_display();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        filter.verify_applicant_dropdown_present();
        filter.click_applicant_dropdown();
        filter.click_on_select_all_employee_status_filter();
        program_page.click_on_apply_button_in_program_filter();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_applying_program_filter (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_071");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when applying program filter");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        filter.click_on_program_filter_dropdown();
        filter.select_program_check_box();
        program_page.click_on_apply_button_in_program_filter();

        filter.verify_selected_program_employee_display();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_search_program_in_program_filter (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_073");
        Logger.log_qase_id("TC_EF_072");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when search program in program filter");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        filter.click_on_program_filter_dropdown();
        filter.enter_search_any_program_in_program_filter("corona care");
        filter.click_on_searched_program_close_icon_button();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_selected_program_employee_display();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_program_filter_with_select_all_program (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_074");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when program filter with select all program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        filter.click_on_program_filter_dropdown();
        filter.click_on_select_all_link_in_program_filter();
        filter.verify_program_filter_check_box_checked();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_selected_program_employee_display();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_applying_completion_filter (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_016");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when applying completion filter");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();

        filter.click_on_filter_button();
        filter.click_on_completion_dropdown();
//        filter.enter_program_starting_percentage("0");
//        filter.enter_program_eding_percentage("100");
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_selected_program_employee_display();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_discipline_with_using_And_operator(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_029");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when select discipline with using And operator");

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
        filter.verify_clear_button_is_present_on_page();
        filter.verify_and_button_is_present_on_page();
        filter.verify_or_button_is_present_on_page();
        filter.click_on_and_button();
        filter.click_on_first_two_check_box_of_discipline_filter();
        program_page.click_on_apply_button_in_program_filter();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_discipline_with_using_or_operator(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_030");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when select discipline with using or operator");

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
        filter.verify_clear_button_is_present_on_page();
        filter.verify_and_button_is_present_on_page();
        filter.verify_or_button_is_present_on_page();
        filter.click_on_or_button();
        filter.click_on_first_two_check_box_of_discipline_filter();
        program_page.click_on_apply_button_in_program_filter();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_None_option_in_Discipline_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_031");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when select None option in Discipline dropdown");

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
        filter.select_none_discipline_option_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_not_assigned_discipline_employees_present();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_Employment_Date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_059,TC_EF_060,TC_EF_012");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when click on Employment Date dropdown");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        new_employees = new new_employees(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);


        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_employment_date_dropdown();
        filter.click_on_employment_date_option_dropdown();
        filter.click_on_on_option_of_employment_date();
        filter.click_on_calendar_button_available_on_employment();
        filter.select_date_from_calendar_popup();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_employment_date_filter_applied();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_Employment_Date_after(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_062");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when click on Employment Date after");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        new_employees = new new_employees(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);


        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_employment_date_dropdown();
        filter.click_on_employment_date_option_dropdown();
        filter.click_on_after_option_of_employment_date();
        filter.click_on_calendar_button_available_on_employment();
        filter.select_date_from_calendar_popup();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_employment_date_filter_applied();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_Employment_Date_Range(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_063");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when click on Employment Date Range");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        new_employees = new new_employees(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);


        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_employment_date_dropdown();
        filter.click_on_employment_date_option_dropdown();
        filter.click_on_range_option_of_employment_date();
        filter.click_on_calendar_button_available_on_employment();
        filter.select_date_from_calendar_popup();
        filter.select_rang_date_from_calendar_popup();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_employment_date_filter_applied();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_nothing_to_show_display_while_selected_filters_data_not_available (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_087");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify nothing to show display while selected filters data not available");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        new_employees = new new_employees(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);


        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

//        filter.click_on_filter_button();
//        program_page.click_on_reset_button_in_program_filter();
//        program_page.click_on_apply_button_in_program_filter();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();
        filter.click_on_employment_date_dropdown();
        filter.click_on_employment_date_option_dropdown();
        filter.click_on_on_option_of_employment_date();
        filter.click_on_calendar_button_available_on_employment();
        filter.select_date_from_calendar_popup();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_employment_date_filter_applied();
        filter.verify_nothing_to_show_msg_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_discipline_with_using_And_operator_in_EF(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_049");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when select discipline with using And operator in EF");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        new_employees = new new_employees(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        filter.click_on_filter_button();

        filter.click_on_disciplines_drop_down();
        filter.verify_select_all_button_is_present_on_page();
        filter.verify_clear_button_is_present_on_page();
        filter.verify_and_button_is_present_on_page();
        filter.verify_or_button_is_present_on_page();

        filter.click_on_first_two_check_box_of_discipline_filter();
        filter.click_on_and_button();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_selected_discipline_with_and_condition_is_present_on_page();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_User_can_Applying_multiple_Disciplines_Filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_028,TC_PF_027");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify User can Applying multiple Disciplines Filter");

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
        filter.verify_clear_button_is_present_on_page();
        filter.verify_and_button_is_present_on_page();
        filter.verify_or_button_is_present_on_page();

        filter.click_on_first_two_check_box_of_discipline_filter();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_selected_discipline_with_and_condition_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_Applying_filter_with_selecting_In_progress_Pending_approval_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_081");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when Applying filter with selecting In-progress Pending approval program");

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

        filter.click_on_progress_status_drop_down();
        filter.select_in_progress_option_in_filter_panel();
        filter.select_pending_approval_in_filter_panel();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_in_progress_and_pending_approval_employee_display();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_Applying_filter_with_selecting_In_progress_approved_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_082");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when Applying filter with selecting In-progress approved program");

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

        filter.click_on_progress_status_drop_down();
        filter.select_in_progress_option_in_filter_panel();
        filter.select_approved_option_in_filter_panel();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_in_progress_and_pending_approval_employee_display();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_Applying_filter_with_selecting_Approved_Pending_approval_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_083");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when Applying filter with selecting Approved  Pending approval program");

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

        filter.click_on_progress_status_drop_down();
        filter.select_pending_approval_in_filter_panel();
        filter.select_approved_option_in_filter_panel();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_in_progress_and_pending_approval_employee_display();

    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_all_link_with_in_Progress_status_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_079,TC_PF_080,TC_PF_084");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when 'select all' link with in Progress status dropdown");

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

        filter.click_on_progress_status_drop_down();
        filter.select_all_link_in_progress_status();
        filter.selected_progress_status_check_box_number_display();
        program_page.click_on_apply_button_in_program_filter();
        filter.verify_in_progress_and_pending_approval_employee_display();
        filter.verify_clear_button_is_present_on_page();
        filter.click_on_clear_button();
        filter.verify_in_progress_and_pending_approval_employee_display();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_applied_multiple_filter_in_program_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_098");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when applied multiple filter in program filter");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        program_page.verify_program_nav_is_present_on_page();
        program_page.click_on_program_nav();
        program_page.verify_programs_page_header_is_present_on_page();
        program_page.verify_first_program_is_present_on_page();
        program_page.click_on_first_program();
        employee_action.click_on_default_filter_employee_status_active_is_present();
        filter.click_on_filter_button();

        filter.click_on_signed_up_drop_down();
        filter.click_on_no_check_box();

        filter.verify_employee_status_dropdown_is_present();
        filter.click_on_employee_status_dropdown();
        filter.click_on_employee_status_clear_link();
        filter.select_on_hold_status_from_the_dropdown();

        filter.click_on_progress_status_drop_down();
        filter.select_in_progress_option_in_filter_panel();

        program_page.click_on_apply_button_in_program_filter();

        filter.verify_signed_up_no_employee_name_are_displayed_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_applied_multiple_filter_in_Employee_filter(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EF_084");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when applied multiple filter in employee filter");

        login = new login_page(driver);
        scheduled_reports = new scheduled_reports(driver);
        program_page = new program_page(driver);
        new_employees = new new_employees(driver);
        filter = new filter(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);


        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.click_on_default_filter_employee_status_active_is_present();
        filter.click_on_filter_button();

        filter.click_on_signed_up_drop_down();
        filter.click_on_no_check_box();

        filter.verify_employee_status_dropdown_is_present();
        filter.click_on_employee_status_dropdown();
        filter.click_on_employee_status_clear_link();
        filter.select_on_hold_status_from_the_dropdown();

        filter.verify_language_dropdown_is_present();
        filter.click_on_language_dropdown();
        filter.select_language_from_the_dropdown();
        program_page.click_on_apply_button_in_program_filter();

        filter.verify_signed_up_no_employee_name_are_displayed_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_Applying_filter_with_starting_date_of_program(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_PF_085");

        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when Applying filter with starting date of program");

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

        filter.verify_start_date_dropdown_present();
        filter.click_on_start_date_dropdown();
        filter.click_on_calendar_button_available_on_employment();
        filter.select_date_from_calendar_popup();
        program_page.click_on_apply_button_in_program_filter();

    }

}
