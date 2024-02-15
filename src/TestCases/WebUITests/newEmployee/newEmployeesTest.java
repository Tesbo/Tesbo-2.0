
package WebUITests.newEmployee;

import io.unity.core.data.TestData;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.adminProfilePage.admin_profile;
import web.object_repository.employeeActionPage.employee_action;
import web.object_repository.employeeProfilePage.employeeProfile;
import web.object_repository.newEmployeesPage.new_employees;
import web.object_repository.login.login_page;

import java.util.Random;

public class newEmployeesTest  extends base {

    login_page login = null;
    new_employees new_employees = null;

    employee_action employee_action = null;

    admin_profile admin_profile = null;

    employeeProfile employeeProfile = null;

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
    public void verify_CS_can_see_the_management_info_form(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-981");
        Logger.log_qase_id("NEV-1108");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify CS can see the management info form");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
        new_employees.enter_text_at_employee_hiring_date_text_box("2022-08-29");

    }

    @Test(dataProvider = "login_credentials")
    public void verify_When_click_on_New_Employee_button_it_opens_pop_up(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-982");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify When click on New Employee button it opens pop up");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        new_employees.verify_phone_number_text_box_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_CS_can_see_the_Personal_info_form(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-983");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify CS can see the Personal info form");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");
        new_employees.click_on_continue_button();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_CS_clicks_on_continue_button_without_entering_phone_number(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-984,");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify CS clicks on continue button without entering phone number");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.click_on_continue_button();
        new_employees.verify_phone_number_require_error_msg_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_CS_clicks_on_continue_button_without_entering_any_data_at_personal_info_stage(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-985");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify CS clicks on continue button without entering any data at personal info stage");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.click_on_continue_button();
        new_employees.verify_first_name_require_error_msg_is_present_on_page();
        new_employees.verify_last_name_require_error_msg_is_present_on_page();
        new_employees.verify_first_name_text_box_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_agency_provider_can_go_to_personal_info_stage_when_by_entering_valid_phone_number(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-986");
        Logger.log_qase_id("NEV-986");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify agency provider can go to personal info stage when by entering valid phone number");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.verify_country_drop_Drop_is_present_on_page();
        new_employees.click_on_country_drop_Drop();
        new_employees.verify_find_Country_text_box_is_present_on_page();
        new_employees.click_on_new_employee_header();
        new_employees.click_on_continue_button();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_click_country_code_dropdown_and_search_country(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-991");
        Logger.log_qase_id("NEV-157");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click country code dropdown and search country");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        new_employees.verify_country_drop_Drop_is_present_on_page();
        new_employees.click_on_country_drop_Drop();
        new_employees.verify_find_Country_text_box_is_present_on_page();
        new_employees.enter_text_for_search_country_from_country_dropdown_text_box("91");
        new_employees.select_search_country();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_click_on_Create_button_Employee_is_created(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-1154");
        Logger.log_qase_id("NEV-161");
        Logger.log_qase_id("NEV-184");
        Logger.log_qase_id("NEV-183");
        Logger.log_qase_id("NEV-164");

        LambdaTestConfig config = new LambdaTestConfig(driver);
     //   config.addTestName("To verify when click on Create button, Employee is created");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();
        new_employees.verify_create_employee_progress_step();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("nevvon");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Test");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
        //new_employees.enter_text_at_employee_hiring_date_text_box("2022-08-29");
        new_employees.select_date_from_calendar_popup();
        new_employees.click_on_new_employee_header();
        new_employees.click_on_create_button();
        new_employees.verify_employee_redirect_to_employee_profile();
    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_Cancel_button_dialogue_button_is_closed(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-174");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on Cancel button, dialogue button is closed");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.click_on_cancel_button();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_Agency_user_can_go_to_Management_info_section_by_entering_firstname_and_lastname(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-1162");
        Logger.log_qase_id("NP-185");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify Agency user can go to Management info section by entering firstname and lastname");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");
        new_employees.verify_progress_step_is_showing_in_page();

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_selects_discipline_from_the_discipline_dropdown (String userName, String password, String agency_name) {
        Logger.log_qase_id("1110, TC_NE_018");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when selects discipline from the discipline dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");
        new_employees.verify_progress_step_is_showing_in_page();

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
        new_employees.click_on_management_info_popup();
        new_employees.verify_discipline_field_is_present();
        new_employees.select_discipline_from_the_dropdown();
        new_employees.click_on_management_info_popup();
        new_employees.click_on_discipline_removed_cross_icon();
        new_employees.verify_discipline_field_is_present();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_selects_location_from_location_dropdown (String userName, String password, String agency_name) {
        Logger.log_qase_id("1111, TC_NE_019");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when selects location from location dropdown");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");
        new_employees.verify_progress_step_is_showing_in_page();

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
        new_employees.click_on_management_info_popup();
        new_employees.verify_location_field_is_present();
        new_employees.select_location_from_the_location_dropdown();
        new_employees.verify_selected_location_is_present();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_the_redirect_profile_icon_after_entering_existing_phone_number(String userName, String password, String agency_name) {
        Logger.log_qase_id("1102,TC_NE_010");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on the redirect profile icon after entering existing phone number");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box("1234567891");
        new_employees.click_on_continue_button();
        new_employees.verify_phone_number_error_msg_is_present_on_page();
        new_employees.click_on_already_taken_phone_number_employee_name_validation();
        new_employees.verify_redirect_to_that_employee_profile_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enter_unregistered_phone_number_it_allows_to_go_to_personal_info_stage(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-1162");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when enter unregistered phone number it allows to go to personal info stage");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_Agency_user_can_go_to_Management_info_section_without_entering_Email_and_language(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-1163");
        Logger.log_qase_id("1109,TC_NE_017");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify Agency user can go to Management info section without entering Email and language");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");

        new_employees.verify_language_text_box_is_present();
        new_employees.click_on_language_dropdown();
        new_employees.select_language_from_the_dropdown();
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_Required_fields_are_missing_validation_appearing_when_click_on_continue_button_without_entering_firstname_and_lastname(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-1164");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify Required fields are missing validation appearing when click on continue button without entering firstname and lastname");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.click_on_continue_button();
        new_employees.verify_first_name_require_error_msg_is_present_on_page();
        new_employees.verify_last_name_require_error_msg_is_present_on_page();
        new_employees.verify_first_name_text_box_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_clicking_on_Cancel_button_closes_the_dialogue_box_on_personal_info_section(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1196");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify clicking on Cancel button closes the dialogue box on personal info section");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        new_employees.verify_new_employee_header_is_present_on_page();

        new_employees.click_on_cancel_button();
        new_employees.verify_new_employees_button_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_Agency_user_can_close_dialogue_box_by_clicking_on_close_icon_available_on_Management_info_page(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-1157");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify Agency user can close dialogue box by clicking on close icon available on Management info page");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_new_employee_header_is_present_on_page();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");
        new_employees.click_on_continue_button();

        //new_employees.verify_employee_hiring_date_text_box_is_present_on_page();

        new_employees.click_on_cancel_icon_on_popup();
        new_employees.verify_new_employees_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_Agency_user_can_go_to_personal_info_by_clicking_on_Back_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-1156");
        Logger.log_qase_id("11o6");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify Agency user can go to personal info by clicking on Back button");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_new_employee_header_is_present_on_page();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
        new_employees.click_on_back_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.verify_last_name_text_box_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_New_Employee_title_is_available_on_the_new_employee_pop_up(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-998");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify New Employee title is available on the new employee pop up");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        new_employees.verify_new_employee_header_is_present_on_page();
        new_employees.verify_phone_number_text_box_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_CS_can_go_to_phone_number_stage_by_clicking_on_Back_button_at_the_personal_info_stage(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-995");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify CS can go to phone number stage by clicking on Back button at the personal info stage");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_new_employee_header_is_present_on_page();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");

        new_employees.click_on_back_button();
        new_employees.verify_country_drop_Drop_is_present_on_page();
        new_employees.verify_phone_number_text_box_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_continue_button_without_entering_first_name_and_last_name(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1105");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on continue button without entering first name and last name");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.click_on_continue_button();
        new_employees.verify_first_name_require_error_msg_is_present_on_page();
        new_employees.verify_last_name_require_error_msg_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_cancel_button_with_in_new_employee_pop_up(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-989");
        Logger.log_qase_id("1104,TC_NE_012");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on cancel button with in new employee popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.click_on_cancel_button();
        new_employees.verify_new_employees_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_close_button_it_closes_the_pop_up(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1095");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when click on close icon it closes the popup");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.click_on_closed_button();
        new_employees.verify_new_employees_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_Agency_user_can_create_Employee_without_Entering_Hiring_date(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1107");
        Logger.log_qase_id("NEV-1114,TC_NE_022");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify Agency user can create Employee without Entering Hiring date");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");
        new_employees.click_on_continue_button();

        new_employees.click_on_create_button();
        new_employees.employment_date_is_required();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_continue_without_entering_birthday(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-187");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on continue without entering birthday");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();
        Random random = new Random();
        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Test");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Testlast");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_adds_the_existing_phone_number_in_different_agency (String userName, String password, String agency_name) {
        Logger.log_qase_id("1112, TC_NE_020 ");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when adds the existing phone number in different agency");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        employee_action = new employee_action(driver);
        admin_profile admin_profile = new admin_profile(driver);
        employeeProfile = new employeeProfile(driver);

        login.verify_email_text_box_is_present_on_page();
        login.clear_email_text_box();
        login.enter_text_at_email_text_box("welovejudyadmin@nevvon.com");
        login.clear_password_text_box();
        login.enter_text_at_password("123456a");
        login.click_on_login_button();

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();
        employeeProfile.verify_personal_info_edit_button_is_present_on_page();
        employeeProfile.click_on_personal_info_edit_button();
        employeeProfile.click_on_phone_number_text_box();

        new_employees.copy_employee_number();

        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.verify_log_out_button_is_present_on_page();
        admin_profile.click_on_log_out_button();

        login.verify_email_text_box_is_present_on_page();
        login.enter_text_at_email_text_box("autotest@mailinator.com");
        login.enter_text_at_password("QA_12345");
        login.click_on_login_button();

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.past_copy_phone_number_of_diff_agency();
        new_employees.click_on_continue_button();

        new_employees.verify_redirect_to_personal_info_details();
    }


}

