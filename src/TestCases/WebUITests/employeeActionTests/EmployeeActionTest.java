package WebUITests.employeeActionTests;

import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.employeeProfilePage.employeeProfile;
import web.object_repository.filterPage.filter;
import web.object_repository.login.login_page;
import web.object_repository.newEmployeesPage.new_employees;
import web.object_repository.employeeActionPage.employee_action;
import web.object_repository.program.program_page;

public class EmployeeActionTest extends base {

    login_page login = null;

    employeeProfile employeeProfile = null;
    new_employees new_employees = null;

    employee_action employee_action = null;

    program_page program_page = null;

    filter filter = null;

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
    public void To_verify_when_clicks_on_Export_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-451");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Export button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.click_on_export_button_employee_action();
        employee_action.verify_exporting_data_validation_msg_display();
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Search_text_box(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-452");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Search textbox");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_search_button_employee_action_is_present_on_page();
        employee_action.click_on_search_button_employee_action();
        employee_action.enter_text_at_search_button_employee_action("Test");
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_message_send_message_popup_appears(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-112");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on message send message popup appears");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_message_option_employee_action_is_present_on_page();
        employee_action.click_on_message_option_employee_action();
        employee_action.verify_message_header_employee_action_is_present_on_page();
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_cancel_icon_the_popup_from_upper_right_corner(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-116");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when cancel icon the popup from upper right corner");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_message_option_employee_action_is_present_on_page();
        employee_action.click_on_message_option_employee_action();
        employee_action.verify_message_header_employee_action_is_present_on_page();
        employee_action.verify_cross_button_employee_action_is_present_on_page();
        employee_action.click_on_cross_button_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_names_of_selected_employees_appears_on_send_message_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-114");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify names of selected employees appears on send message popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_message_option_employee_action_is_present_on_page();
        employee_action.click_on_message_option_employee_action();
        employee_action.verify_message_header_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_popup_disappears(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-120");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button popup disappears");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_message_option_employee_action_is_present_on_page();
        employee_action.click_on_message_option_employee_action();
        employee_action.verify_message_header_employee_action_is_present_on_page();
        employee_action.verify_cancel_button_employee_action_is_present_on_page();
        employee_action.click_on_cancel_button_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_admin_sends_blank_message_validation_message_appears(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-122");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when admin sends blank message validation message appears");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_message_option_employee_action_is_present_on_page();
        employee_action.click_on_message_option_employee_action();
        employee_action.verify_message_header_employee_action_is_present_on_page();
        employee_action.verify_send_button_employee_action_is_present_on_page();
        employee_action.click_on_send_button_employee_action();
        employee_action.verify_message_required_alert_employee_action_is_present_on_page();
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_first_name_the_first_name_of_employees_appears_in_the_message(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-117");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on first name the first name of employees appears in the message");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_message_option_employee_action_is_present_on_page();
        employee_action.click_on_message_option_employee_action();
        employee_action.verify_message_header_employee_action_is_present_on_page();
        employee_action.verify_firstName_label_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_last_name_the_last_name_of_employees_appears_in_the_message(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-118");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on last name, the last name of the employees appears in the message");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_message_option_employee_action_is_present_on_page();
        employee_action.click_on_message_option_employee_action();
        employee_action.verify_message_header_employee_action_is_present_on_page();
        employee_action.verify_lastname_label_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_admin_sends_only_entering_spaces_validation_message_appears(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-121");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when admin sends only entering spaces validation message appears");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_message_option_employee_action_is_present_on_page();
        employee_action.click_on_message_option_employee_action();
        employee_action.verify_message_header_employee_action_is_present_on_page();
        employee_action.verify_textArea_message_option_employee_action_is_present_on_page();
        employee_action.enter_text_at_textArea_message_option_employee_action("    ");
        employee_action.verify_send_button_employee_action_is_present_on_page();
        employee_action.click_on_send_button_employee_action();
        employee_action.verify_message_required_alert_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_customize_column_popup_appears_and_close(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-143");
        Logger.log_qase_id("NEV-565");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on customize column popup appears and close");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.verify_customize_columns_option_employee_action_is_present_on_page();
        employee_action.click_on_customize_columns_option_employee_action();
        employee_action.verify_customize_columns_header_popup_present_on_page();

        employee_action.click_on_customize_close_icon_button();
        employee_action.verify_employee_header_present_on_employee_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_checkbox_checkboxes_and_save_button_changes_saved_successfully_toast_message_shows(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-144");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on checkbox checkboxes and save button changes saved successfully toast message shows");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_customize_columns_option_employee_action_is_present_on_page();
        employee_action.click_on_customize_columns_option_employee_action();
        employee_action.verify_customize_columns_header_popup_present_on_page();
        employee_action.click_on_popup_employee_option_check_box();
        employee_action.verify_customize_save_button_employee_action_is_present_on_page();
        employee_action.click_on_customize_save_button_employee_action();
        employee_action.verify_changes_saved_alert_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_deselect_any_checkbox_with_in_customize_columns_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1028");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when deselect any checkbox with in customize columns popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_customize_columns_option_employee_action_is_present_on_page();
        employee_action.click_on_customize_columns_option_employee_action();
        employee_action.verify_customize_columns_header_popup_present_on_page();
        employee_action.click_on_popup_employee_option_check_box_deselect();
        employee_action.verify_customize_save_button_employee_action_is_present_on_page();
        employee_action.click_on_customize_save_button_employee_action();
        employee_action.verify_changes_saved_alert_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_columns_gets_modified_as_per_the_changes_made_employee_actions(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-145");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify columns gets modified as per the changes made employee actions");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_customize_columns_option_employee_action_is_present_on_page();
        employee_action.click_on_customize_columns_option_employee_action();
        employee_action.verify_customize_columns_header_popup_present_on_page();
        employee_action.click_on_popup_employee_option_check_box();
        employee_action.verify_customize_save_button_employee_action_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_reset_link(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-449");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on reset link");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_customize_columns_option_employee_action_is_present_on_page();
        employee_action.click_on_customize_columns_option_employee_action();
        employee_action.verify_customize_columns_header_popup_present_on_page();
        employee_action.verify_customize_reset_button_employee_action_is_present_on_page();
        employee_action.click_on_customize_reset_button_employee_action();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_customize_columns(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-450");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button customize columns");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_first_employee_checkout_employee_action_is_present_on_page();
        employee_action.click_on_first_employee_checkout_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_customize_columns_option_employee_action_is_present_on_page();
        employee_action.click_on_customize_columns_option_employee_action();
        employee_action.verify_customize_columns_header_popup_present_on_page();
        employee_action.verify_customize_cancel_button_employee_action_is_present_on_page();
        employee_action.click_on_customize_cancel_button_employee_action();
        employee_action.verify_action_button_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_number_of_selected_employees_appears_on_send_message_pop_up(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-113");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify number of selected employees appears on send message pop up");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);
        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_hover_cursor_to_set_status_to_three_options_appear(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-124");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when hover cursor to set status to, three options appear");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);
        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_active_the_activate_employees_popup_appears_click_close_icon(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-125");
        Logger.log_qase_id("NEV-560");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on active, the activate employees popup appears click close icon");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
        employee_action.click_on_active_option_of_employee_action_dropdown();
        employee_action.verify_set_to_active_popup_display();
        employee_action.click_on_active_popup_close_icon();
        employeeProfile.verify_employee_name_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_the_activate_employees_popup_has_total_number_of_selected_employees(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-126");
        Logger.log_qase_id("NEV-127");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify the activate employees popup has total number of selected employees");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
        employee_action.click_on_active_option_of_employee_action_dropdown();
        employee_action.verify_set_to_active_popup_display();
        employee_action.verify_total_selected_no_of_employee();
        employee_action.verify_show_selected_employee_name();
        employee_action.click_on_cancel_button_active_employee_action_popup();
        employee_action.verify_employee_header_present_on_employee_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_the_on_hold_popup_has_total_number_of_selected_employees(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-132");
        Logger.log_qase_id("NEV-133");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify the on hold popup has total number of selected employees");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();

        employee_action.click_on_On_hold_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_hold_popup_display();

        employee_action.verify_on_hold_total_selected_no_of_employee();
        employee_action.verify_show_selected_employee_name();
        employee_action.click_on_cancel_button_active_employee_action_popup();
        employee_action.verify_employee_header_present_on_employee_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_the_terminate_popup_has_total_number_of_employees_selected(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-138");
        Logger.log_qase_id("NEV-139");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify the terminate popup has total number of employees selected");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();

        employee_action.click_on_terminate_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_terminate_popup_display();

        employee_action.verify_on_terminate_total_selected_no_of_employee();
        employee_action.verify_show_selected_employee_name();
        employee_action.click_on_cancel_button_active_employee_action_popup();
        employee_action.verify_employee_header_present_on_employee_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_On_hold_copy_icon_close_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-131");
        Logger.log_qase_id("NEV-561");
        Logger.log_qase_id("NEV-562");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on On hold copy icon close button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
        employee_action.click_on_On_hold_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_hold_popup_display();
        employee_action.click_on_on_hold_popup_copy_icon();
        employee_action.click_on_on_hold_popup_close_icon();
        employee_action.click_on_search_button_employee_action();
        employee_action.on_hold_popup_paste_copy_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_on_hold_popup_has_place_on_hold_and_cancel_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-135");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify on hold popup has place on hold and cancel button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
        employee_action.click_on_On_hold_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_hold_popup_display();
        employee_action.click_on_on_hold_popup_cancel_button();
        employee_action.verify_employee_header_present_on_employee_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_place_on_hold_the_employees_placed_on_hold_validation_appears(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-136");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks place on hold, the employees placed on hold validation appears");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
        employee_action.click_on_On_hold_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_hold_popup_display();
        employee_action.click_on_on_hold_popup_place_on_hold_button();
        employee_action.verify_employee_on_hold_successful_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_terminate_the_terminate_popup_appears_and_validation_msg_display(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-137");
        Logger.log_qase_id("NEV-142");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on terminate, the terminate popup appears and validation msg display");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);
        filter = new filter(driver);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
        employee_action.click_on_terminate_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_terminate_popup_display();
        employee_action.click_on_terminate_button_on_terminate_popup();
        employee_action.verify_employee_terminate_successful_validation_msg_display();
        new_employees.click_on_employee_check_box();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
        employee_action.click_on_active_option_of_employee_action_dropdown();
        employee_action.verify_set_to_active_popup_display();
        employee_action.click_on_active_button_on_active_popup();
        employee_action.verify_successfully_active_validation_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_the_terminate_popup_disappears(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-141");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button, the terminate popup disappears");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        filter = new filter(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        filter.click_on_filter_button();
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
        employee_action.click_on_terminate_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_terminate_popup_display();
        employee_action.click_on_terminate_popup_cancel_button();
        employee_action.verify_employee_header_present_on_employee_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_close_icon_and_copy_icon_in_terminate_status_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-566");
        Logger.log_qase_id("NEV-563");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on close icon and copy icon in terminate status popup");

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
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_action_dropdown_set_status_to_option();
        employee_action.verify_set_status_option_is_present_on_page();
        employee_action.click_on_terminate_option_of_employee_action_dropdown();
        employee_action.verify_set_to_status_on_terminate_popup_display();
        employee_action.click_on_terminate_popup_copy_icon();
        employee_action.click_on_terminate_popup_close_icon_button();
        employee_action.verify_employee_header_present_on_employee_page();
        employee_action.click_on_search_button_employee_action();
        employee_action.on_hold_popup_paste_copy_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_copy_icon_and_cross_icon_in_send_message_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-558");
        Logger.log_qase_id("NEV-564");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on copy icon and cross icon in send message popup");

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
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.verify_message_option_employee_action_is_present_on_page();
        employee_action.click_on_message_option_employee_action();
        employee_action.verify_message_header_employee_action_is_present_on_page();
        employeeProfile.click_on_send_message_popup_copy_icon();
        employeeProfile.click_on_message_text_box();
        employeeProfile.paste_message();
        employeeProfile.click_on_cross_button();
        employee_action.verify_employee_header_present_on_employee_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Add_to_program_option_and_copy_icon(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-567");
        Logger.log_qase_id("NEV-568");
        Logger.log_qase_id("NEV-569");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Add to program option and copy icon");

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
        program_page.click_on_reset_button_in_program_filter();
        program_page.click_on_apply_button_in_program_filter();

        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.select_on_online_program_button();
        employeeProfile.verify_online_program_details_present();
        employeeProfile.click_on_add_program_popup_copy_icon();
        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.click_on_search_program_text_box();
        employeeProfile.add_program_popup_paste_copy_message();
        employeeProfile.verify_add_program_copy_message_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_anniversary_date_from_start_date_drop_down(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-571");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on anniversary date from start date drop down");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_start_date_dropdown();
        employeeProfile.verify_display_list_of_start_date_option();
        employeeProfile.click_on_start_date_anniversary_date_option();

        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_anniversary_month_from_start_date_drop_down(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-572");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on anniversary month from start date drop down");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

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
    public void verify_when_clicks_on_today_from_start_date_dropdown_employee_action(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-570");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on today from start date dropdown employee action");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

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
    public void verify_when_clicks_on_submit_button_without_entering_dates_details(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-581");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on submit button without entering dates details");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_Custom_due_date_option();

        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_due_date_validation_message_displayed();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_due_date_dropdown_employee_action(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-576");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on due date dropdown employee action");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_action_employee(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-583");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button action employee");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.click_on_cancle_button();
        employeeProfile.add_employee_program_popup_disappears_and_redirect_to_employee_profile_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_custom_from_start_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-573");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on custom from start date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
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
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_December_31st_from_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-577");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on December 31st from due date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

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
    public void verify_when_clicks_on_1_year_from_start_from_due_date_dropdown(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-578");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on 1 year from start from due date dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employee_action.click_on_due_date_1_year_from_start_option();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_employee_added_to_Program_validation_msg();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Custom_duration_from_due_date_drop_down(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-582");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on Custom duration from due date drop down");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

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
    public void verify_when_clicks_on_Custom_duration_from_due_date_drop_down_with_0_day(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-582");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Custom duration from due date drop down with 0 day");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_Custom_duration_option();
        employeeProfile.verify_display_custom_duration_selection_option_present();
        employeeProfile.click_on_add_program_submit_button();
        employee_action.verify_start_date_mandatory_date_validation_msg_display();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Custom_date_from_due_date_drop_down(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-579");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on Custom date from due date drop down");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
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
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_submit_without_entering_date_in_custom_date_employee_action(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-580");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on submit without entering date in custom date employee action");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.Click_on_programs_dropdown();
        employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_program_from_the_dropdown();
        employeeProfile.Click_on_due_date_dropdown();
        employeeProfile.verify_display_list_of_due_date_option();
        employeeProfile.click_on_Custom_due_date_option();
        employeeProfile.verify_display_custom_due_date_calendar_option();
        employeeProfile.click_on_add_program_submit_button();
        employeeProfile.verify_due_date_validation_message_displayed();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_in_add_program_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-583");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button in add program popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

        employeeProfile.click_on_cancle_button();
        employeeProfile.add_employee_program_popup_disappears_and_redirect_to_employee_profile_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_submit_after_entering_necessary_details(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-584");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks submit after entering necessary details");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();

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
    public void verify_when_clicks_on_cross_icon_in_program_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-585");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cross icon in program popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.click_on_close_icon_button();
        employeeProfile.add_employee_program_popup_disappears_and_redirect_to_employee_profile_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_in_class_program_button_and_details(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-586");
        Logger.log_qase_id("NEV-587");
        Logger.log_qase_id("NEV-589");
        Logger.log_qase_id("NEV-598");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on in class program button and details");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.select_on_In_class_program__button();
        employeeProfile.verify_In_class_program_details_present();

        employeeProfile.Click_on_programs_dropdown();
        //employeeProfile.verify_display_list_of_programs_added_to_the_agency();
        employeeProfile.select_session_program_from_the_dropdown();
        employeeProfile.Click_on_session_dropdown();
        //employeeProfile.verify_display_list_of_session();
        //employeeProfile.verify_display_list_of_session_present();
        employeeProfile.select_session_from_the_dropdown();
        employeeProfile.click_on_add_program_submit_button();
        //employeeProfile.verify_add_program_popup_session_required_validation_msg_display();
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_session_drop_down_when_no_programs_is_selected(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-588");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on session drop down when no programs is selected");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
        employeeProfile.verify_add_employee_to_program_header_is_present_on_page();
        employeeProfile.select_on_In_class_program__button();
        employeeProfile.verify_In_class_program_details_present();

        employeeProfile.Click_on_session_dropdown();
        //employeeProfile.verify_display_select_program_first();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_create_new_session_button_in_action(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-590");
        Logger.log_qase_id("NEV-591");
        Logger.log_qase_id("NEV-592");
        Logger.log_qase_id("NEV-593");
        Logger.log_qase_id("NEV-594");
        Logger.log_qase_id("NEV-595");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on create new session button in action");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.click_on_employee_check_box();

        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_employee_popup_option_present_on_page();
        employee_action.click_on_add_program_option_employee_action();
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
        employeeProfile.verify_employee_added_to_Program_validation_msg();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_cancel_button_with_in_send_SMS_to_change_password_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-663");
        Logger.log_qase_id("NEV-658");
        Logger.log_qase_id("NEV-660");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cancel button, with in send SMS to change password popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();

        employee_action.verify_search_button_employee_action_is_present_on_page();
        employee_action.click_on_search_button_employee_action();
        employee_action.enter_text_at_search_button_employee_action("Ziva");
        employee_action.mouse_hover_and_click_on_employee_name_text();

        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();
        program_page.click_on_send_sms_button();
        program_page.verify_send_sms_to_change_password_pop_up_is_present_on_page();
        program_page.click_on_cancel_button_of_pop_up();
        program_page.verify_employee_profile_header_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_close_icon_with_in_send_SMS_to_change_password_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-665");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on close icon with in send SMS to change password popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();

        employee_action.verify_search_button_employee_action_is_present_on_page();
        employee_action.click_on_search_button_employee_action();
        employee_action.enter_text_at_search_button_employee_action("Ziva");
        employee_action.mouse_hover_and_click_on_employee_name_text();


        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();
        program_page.click_on_send_sms_button();
        program_page.verify_send_sms_to_change_password_pop_up_is_present_on_page();
        program_page.click_on_cross_icon_sms_popup();
        program_page.verify_employee_profile_header_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_send_button_for_reset_password_with_the_SMS(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-664");
        Logger.log_qase_id("NEV-661");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on send button, for reset password with the SMS");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();

        employee_action.verify_search_button_employee_action_is_present_on_page();
        employee_action.click_on_search_button_employee_action();
        employee_action.enter_text_at_search_button_employee_action("Ziva");

        employee_action.mouse_hover_and_click_on_employee_name_text();

        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();
        program_page.click_on_send_sms_button();
        program_page.verify_send_sms_to_change_password_pop_up_is_present_on_page();
        program_page.click_on_send_button_of_the_pop_up();
        employeeProfile.verify_SMS_sent_message_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_select_send_email_option_for_reset_password(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-669");
        Logger.log_qase_id("NEV-666");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when select send email option for reset password");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();

        employee_action.verify_search_button_employee_action_is_present_on_page();
        employee_action.click_on_search_button_employee_action();
        employee_action.enter_text_at_search_button_employee_action("Ziva");

        employee_action.mouse_hover_and_click_on_employee_name_text();

        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();
        program_page.click_on_send_email_button();
        program_page.verify_send_email_to_change_password_pop_up_is_present();
        program_page.click_on_send_button_of_the_pop_up();
        employeeProfile.verify_email_sent_message_present_on_page();


    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_cancel_button_with_in_send_email_to_change_password_popup(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-668");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cancel button with in send email to change password popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();

        employee_action.verify_search_button_employee_action_is_present_on_page();
        employee_action.click_on_search_button_employee_action();
        employee_action.enter_text_at_search_button_employee_action("Ziva");

        employee_action.mouse_hover_and_click_on_employee_name_text();

        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();

        program_page.click_on_send_email_button();
        program_page.verify_send_email_to_change_password_pop_up_is_present();

        program_page.click_on_send_email_popup_cancel_button();
        program_page.verify_employee_profile_header_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_close_icon_button_with_in_send_email_to_change_password(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-670");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on close icon button with in send email to change password");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);
        program_page = new program_page(driver);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_search_button_employee_action_is_present_on_page();
        employee_action.click_on_search_button_employee_action();
        employee_action.enter_text_at_search_button_employee_action("Ziva");

        employee_action.mouse_hover_and_click_on_employee_name_text();

        program_page.verify_view_profile_is_present_on_page();
        program_page.verify_reset_password_is_present_on_page();
        program_page.click_on_reset_password_button();

        program_page.click_on_send_email_button();
        program_page.verify_send_email_to_change_password_pop_up_is_present();

        program_page.click_on_cross_icon_sms_popup();
        program_page.verify_employee_profile_header_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_actions_dropdown_when_no_employee_is_selected(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EP_017");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on actions dropdown when no employee is selected");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.click_on_action_dropdown_button_employee_action();
        employee_action.verify_customize_columns_option_employee_action_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_search_any_random_name_not_existing_in_the_agency(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EP_007");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when search any random name not existing in the agency");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);
        employee_action = new employee_action(driver);
        filter = new filter(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employee_action.verify_export_button_employee_action_is_present_on_page();
        employee_action.verify_search_button_employee_action_is_present_on_page();
        employee_action.click_on_search_button_employee_action();
        employee_action.enter_text_at_search_button_employee_action("@#*&!...");
        filter.verify_nothing_to_show_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_selected_count_when_selects_checkbox_of_any_employees(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_EP_009");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify selected count when selects checkbox of any employees");

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

        program_page.click_on_select_all_button_for_select_all_check_box();
        program_page.verify_all_selected_title_display();
        program_page.verify_reset_link_present_for_check_box();
    }
}
