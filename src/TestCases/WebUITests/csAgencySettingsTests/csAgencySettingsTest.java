package WebUITests.csAgencySettingsTests;

import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.object_repository.csAgencySettingsPage.csAgencySettings_page;
import web.object_repository.csHomePage.csHome_page;
import web.object_repository.csdashboard.dashboard_page;
import web.object_repository.employeeActionPage.employee_action;
import web.object_repository.login.login_page;
import web.object_repository.program.program_page;
import WebUITests.commonDataProviders.commonDataProvider;

public class csAgencySettingsTest extends base {

    login_page login = null;
    csHome_page csHome = null;
    csAgencySettings_page csAgencySettings = null;
    program_page programPage = null;
    employee_action employeeAction = null;
    dashboard_page dashBoard = null;

    @DataProvider(name = "error_messages")
    public Object[][] error_message_provider(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 9);
    }

    @DataProvider(name = "employee_terminate")
    public Object[][] employee_status(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 10);
    }

    @DataProvider(name = "multi_agency_emp")
    public Object[][] multiple_agency_employee(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 11);
    }

    @DataProvider(name = "integration_agency")
    public Object[][] integration_agency_data(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 12);
    }

    @DataProvider(name = "integrated_agency")
    public Object[][] integrated_agency_data(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 13);
    }

    @DataProvider(name = "partner_integration_error_validation")
    public Object[][] partner_mandatory_errors_data(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 14);
    }

    @DataProvider(name = "partner_integration_input_values")
    public Object[][] input_data_for_partner_fields(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 15);
    }



    @Test(dataProvider = "agency_name", dataProviderClass = commonDataProvider.class)
    public void to_verify_when_no_automation_rules_created_under_automation_rules_tab(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_and_navigate_to_automation_rules_tab();
        csAgencySettings.verify_tab_is_empty();
    }

    @Test(dataProvider = "add_employee_to_agency", dataProviderClass = commonDataProvider.class)
    public void to_verify_remove_employees_from_program_by_employee_numbers(String username, String password, String employeeName, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        programPage.click_on_programs_link();
        programPage.click_on_program();
        programPage.find_employees_of_program();
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.process_to_remove_employee_by_employee_number(programPage);
        csAgencySettings.verify_summary_page_for_remove_emp_operation();
        programPage.click_on_programs_link();
        programPage.click_on_program();
        programPage.verify_employee_removed_from_program();
        programPage.click_on_add_to_program_button();
        programPage.add_removed_employees_to_program_and_verify();
    }

    @Test(dataProvider = "add_employee_to_agency", dataProviderClass = commonDataProvider.class)
    public void to_verify_remove_employees_from_program_by_employee_phone_numbers(String username, String password, String employeeName, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        programPage.click_on_programs_link();
        programPage.click_on_program();
        programPage.find_employees_of_program();
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.process_to_remove_employee_by_employee_phone(programPage);
        csAgencySettings.verify_summary_page_for_remove_emp_operation();
        programPage.click_on_programs_link();
        programPage.click_on_program();
        programPage.verify_employee_removed_from_program();
        programPage.click_on_add_to_program_button();
        programPage.add_removed_employees_to_program_and_verify();
    }

    @Test(dataProvider = "error_messages")
    public void verify_appropriate_errors_when_saving_bulk_operations_without_providing_details_in_mandatory_fields(String username, String password, String agencyName, String errorMessages){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.click_on_continue_to_complete_operation();
        csAgencySettings.verify_error_messages(errorMessages);
    }

    @Test(dataProvider = "employee_terminate")
    public void to_verify_terminate_employees_by_phone_numbers(String username, String password, String agencyName, String empName, String status){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeAction = new employee_action(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.process_to_terminate_employee_by_phone(employeeAction);
        csAgencySettings.verify_summary_page_after_terminating_employee();
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_employee_terminated(empName, status);
        employeeAction.reset_employee_status_to_active();
        employeeAction.click_on_set_status_button();
        employeeAction.verify_employee_status_become_active(empName);
    }

    @Test(dataProvider = "employee_terminate")
    public void to_verify_terminate_employees_by_employee_numbers(String username, String password, String agencyName, String empName, String status){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeAction = new employee_action(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        programPage.clear_all_filters();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.process_to_terminate_employee_by_employee_number(employeeAction);
        csAgencySettings.verify_summary_page_after_terminating_employee();
        csAgencySettings.click_on_employees_link();
        programPage.clear_all_filters();
        employeeAction.verify_employee_terminated(empName, status);
        employeeAction.reset_employee_status_to_active();
        employeeAction.click_on_set_status_button();
        employeeAction.verify_employee_status_become_active(empName);
    }

    @Test(dataProvider = "employee_terminate")
    public void to_verify_terminate_employee_by_phone_but_providing_employee_number_in_employee_identifier_field(String username, String password, String agencyName, String empName, String status){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeAction = new employee_action(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.select_terminate_employee_option();
        csAgencySettings.select_identifier_type_as_phone_and_give_employee_number_in_the_field(employeeAction);
        csAgencySettings.verify_operation_not_successfull();
        csAgencySettings.click_on_employees_link();
        programPage.clear_all_filters();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);
    }

    @Test(dataProvider = "employee_terminate")
    public void to_verify_terminate_employee_by_employee_number_but_providing_phone_number_in_employee_identifier_field(String username, String password, String agencyName, String empName, String status){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeAction = new employee_action(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.select_terminate_employee_option();
        csAgencySettings.select_identifier_type_as_employee_number_and_give_phone_number_in_the_field(employeeAction);
        csAgencySettings.verify_operation_not_successfull();
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);
    }

    @Test(dataProvider = "employee_terminate")
    public void to_verify_remove_employee_from_program_by_employee_number_but_providing_phone_number_in_employee_identifier_field(String username, String password, String agencyName, String employeeName, String status){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        programPage.click_on_programs_link();
        programPage.click_on_program();
        programPage.clear_all_filters();
        programPage.search_employee(employeeName);
        programPage.verify_employee_present_on_page(employeeName);
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.select_remove_emp_from_program_option();
        csAgencySettings.select_program();
        csAgencySettings.select_identifier_type_as_employee_number_and_give_phone_number_in_the_field(programPage);
        csAgencySettings.verify_operation_not_successfull();
        programPage.click_on_programs_link();
        programPage.click_on_program();
        programPage.clear_all_filters();
        programPage.search_employee(employeeName);
        programPage.verify_employee_present_on_page(employeeName);
    }

    @Test(dataProvider = "employee_terminate")
    public void to_verify_remove_employee_from_program_by_phone_number_but_providing_employee_number_in_employee_identifier_field(String username, String password, String agencyName, String employeeName, String status){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        programPage.click_on_programs_link();
        programPage.click_on_program();
        programPage.clear_all_filters();
        programPage.search_employee(employeeName);
        programPage.verify_employee_present_on_page(employeeName);
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.select_remove_emp_from_program_option();
        csAgencySettings.select_program();
        csAgencySettings.select_identifier_type_as_phone_and_give_employee_number_in_the_field(programPage);
        csAgencySettings.verify_operation_not_successfull();
        programPage.click_on_programs_link();
        programPage.click_on_program();
        programPage.clear_all_filters();
        programPage.search_employee(employeeName);
        programPage.verify_employee_present_on_page(employeeName);
    }

    @Test(dataProvider = "multi_agency_emp")
    public void to_verify_employee_present_in_multiple_agencies_terminated_by_employee_number_should_only_terminate_from_the_agency_from_which_operation_was_performed(String username, String password, String agencyName, String agencyName1, String empName, String status){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeAction = new employee_action(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);

        csHome.search_agency_from_top_navigation(agencyName1);
        dashBoard = csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName1);
        dashBoard.verify_csuser_is_on_agency_dashboard(agencyName1);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.process_to_terminate_employee_by_employee_number(employeeAction);
        csAgencySettings.verify_summary_page_after_terminating_employee();
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_employee_terminated(empName, status);

        csHome.search_agency_from_top_navigation(agencyName);
        dashBoard = csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashBoard.verify_csuser_is_on_agency_dashboard(agencyName);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);

        csHome.search_agency_from_top_navigation(agencyName1);
        dashBoard = csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName1);
        dashBoard.verify_csuser_is_on_agency_dashboard(agencyName1);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();

        employeeAction.set_filter_to_terminated();
        employeeAction.click_on_apply_filters();
        employeeAction.click_on_filter_pane();
        employeeAction.search_employee(empName);
        employeeAction.reset_employee_status_to_active();
        employeeAction.click_on_set_status_button();
        employeeAction.verify_employee_status_become_active(empName);
    }

    @Test(dataProvider = "multi_agency_emp")
    public void to_verify_employee_present_in_multiple_agencies_terminated_by_phone_number_should_only_terminate_from_the_agency_from_which_operation_was_performed(String username, String password, String agencyName, String agencyName1, String empName, String status){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        employeeAction = new employee_action(driver);
        programPage = new program_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);

        csHome.search_agency_from_top_navigation(agencyName1);
        dashBoard = csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName1);
        dashBoard.verify_csuser_is_on_agency_dashboard(agencyName1);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);
        csAgencySettings = programPage.click_and_navigate_to_settings_page();
        csAgencySettings.click_on_bulk_operations_link();
        csAgencySettings.process_to_terminate_employee_by_phone(employeeAction);
        csAgencySettings.verify_summary_page_after_terminating_employee();
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_employee_terminated(empName, status);

        csHome.search_agency_from_top_navigation(agencyName);
        dashBoard = csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashBoard.verify_csuser_is_on_agency_dashboard(agencyName);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();
        employeeAction.verify_employees_current_status_is_not_terminated(empName, status);

        csHome.search_agency_from_top_navigation(agencyName1);
        dashBoard = csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName1);
        dashBoard.verify_csuser_is_on_agency_dashboard(agencyName1);
        csAgencySettings.click_on_employees_link();
        employeeAction.verify_user_is_on_employees_page();

        employeeAction.set_filter_to_terminated();
        employeeAction.click_on_apply_filters();
        employeeAction.click_on_filter_pane();
        employeeAction.search_employee(empName);
        employeeAction.reset_employee_status_to_active();
        employeeAction.click_on_set_status_button();
        employeeAction.verify_employee_status_become_active(empName);
    }

    @Test(dataProvider = "integration_agency")
    public void to_verify_the_integration_page_when_no_integration_created_for_agency(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.remove_integration_if_any();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
    }

    @Test(dataProvider = "integration_agency")
    public void to_verify_the_integration_section_on_info_page_when_no_integration_created_for_agency(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.remove_integration_if_any();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
        csAgencySettings.click_on_info_link();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_info_page();
    }

    @Test(dataProvider = "integration_agency")
    public void to_verify_the_presence_of_new_discipline_button_when_no_integration_created_for_agency(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.remove_integration_if_any();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
        csAgencySettings.click_on_disciplines_link();
        csAgencySettings.verify_presence_of_new_discipline_button_on_new_disciplines_tab();
    }

    @Test(dataProvider = "integration_agency")
    public void to_verify_the_presence_of_new_location_button_when_no_integration_created_for_agency(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.remove_integration_if_any();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
        csAgencySettings.click_on_locations_link();
        csAgencySettings.verify_presence_of_new_location_button_on_new_locations_tab();
    }

    @Test(dataProvider = "integration_agency")
    public void to_verify_the_impact_on_integration_page_info_page_disciplines_page_and_locations_page_when_integrating_agency_with_partner(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.remove_integration_if_any();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
        csAgencySettings.select_integration_partner_and_verify_partner_changed_successfully();
        csAgencySettings.click_on_disciplines_link();
        csAgencySettings.verify_absence_of_new_discipline_button_on_new_disciplines_tab();
        csAgencySettings.click_on_locations_link();
        csAgencySettings.verify_absence_of_new_location_button_on_new_locations_tab();
        csAgencySettings.click_on_info_link();
        csAgencySettings.verify_integration_on_info_page_when_partner_integrated_with_agency();
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.click_on_edit_button_on_settings_page();
        csAgencySettings.remove_integration_from_agency();
        csAgencySettings.verify_integration_changed_successfully();
    }

    @Test(dataProvider = "integrated_agency")
    public void to_verify_the_behavior_of_remove_integration_button_on_integration_tab(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.add_integration_if_not_present();
        csAgencySettings.verify_integration_partner_is_integrated_with_agency();
        csAgencySettings.click_on_edit_button_on_settings_page();
        csAgencySettings.verify_presence_of_remove_integration_button();
        csAgencySettings.click_on_cancel_from_integration_page();
        csAgencySettings.verify_absence_of_remove_integration_button();
    }

    @Test(dataProvider = "integration_agency")
    public void to_verify_the_impact_on_info_page_disciplines_page_and_locations_page_when_removing_integration_from_agency(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        try{
            csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
            csAgencySettings.select_integration_partner_and_verify_partner_changed_successfully();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        csAgencySettings.verify_integration_partner_is_integrated_with_agency();
        csAgencySettings.click_on_edit_button_on_settings_page();
        csAgencySettings.remove_integration_from_agency();
        csAgencySettings.verify_integration_changed_successfully();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
        csAgencySettings.click_on_disciplines_link();
        csAgencySettings.verify_presence_of_new_discipline_button_on_new_disciplines_tab();
        csAgencySettings.click_on_locations_link();
        csAgencySettings.verify_presence_of_new_location_button_on_new_locations_tab();
        csAgencySettings.click_on_info_link();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_info_page();
        csAgencySettings.click_on_cs_logo();
        csHome.verify_user_is_on_cs_home_page();
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.verify_integration_column_of_agency_is_empty();
    }

    @Test(dataProvider = "integration_agency")
    public void to_verify_that_integration_column_should_be_empty_in_agencies_page_if_no_partner_is_integrated_with_agency(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.remove_integration_if_any();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
        csAgencySettings.click_on_cs_logo();
        csHome.verify_user_is_on_cs_home_page();
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.verify_integration_column_of_agency_is_empty();
    }

    @Test(dataProvider = "integrated_agency")
    public void to_verify_that_name_of_partner_should_display_under_integration_column_in_agencies_page_if_agency_is_integrated_with_partner(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.add_integration_if_not_present();
        csAgencySettings.verify_integration_partner_is_integrated_with_agency();
        String partnerName = csAgencySettings.get_partner_name_of_integration_page();
        csAgencySettings.click_on_cs_logo();
        csHome.verify_user_is_on_cs_home_page();
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csHome.verify_integration_partner_is_same_as_integration_tab(partnerName);
    }

    @Test(dataProvider = "partner_integration_error_validation")
    public void to_verify_error_messages_of_mandatory_fields_for_integration_partners_when_trying_to_save_with_empty_mandatory_fields(String username, String password, String agencyName, String partnerName, String errors){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.remove_integration_if_any();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
        csAgencySettings.select_given_integration_partner(partnerName);
        csAgencySettings.click_on_edit_button_on_settings_page();
        csAgencySettings.clear_all_the_input_fields();
        csAgencySettings.click_on_save_button_on_integration_tab();
        switch(partnerName){
            case "AlayaCare":
            case "SmartCare":
                csAgencySettings.verify_mandatory_fields_error_for_alayacare_and_smartcare_partner(errors);
                              break;
            case "AxisCare": csAgencySettings.verify_mandatory_fields_error_for_axiscare_partner(errors);
                             break;
            case "HHAeXchange": csAgencySettings.verify_mandatory_fields_error_for_hhaexchange_partner(errors);
                                break;
        }

        csAgencySettings.verify_presence_of_remove_integration_button();
        csAgencySettings.remove_integration_from_agency();
    }

    @Test(dataProvider = "partner_integration_input_values")
    public void to_verify_able_to_save_changes_when_all_the_mandatory_fields_are_filled(String username, String password, String agencyName, String partnerName, String inputs){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.remove_integration_if_any();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
        csAgencySettings.select_given_integration_partner(partnerName);
        csAgencySettings.click_on_edit_button_on_settings_page();
        switch(partnerName){
            case "AlayaCare":
            case "SmartCare":
                csAgencySettings.enter_values_in_fields_of_alayacare_and_smartcare(inputs.split(","));
                break;
            case "AxisCare": csAgencySettings.enter_values_in_fields_of_axiscare(inputs.split(","));
                break;
            case "HHAeXchange": csAgencySettings.enter_values_in_fields_of_hhaexchange(inputs.split(","));
                break;
        }
        csAgencySettings.click_on_save_button_on_integration_tab();
        csAgencySettings.verify_integration_changes_are_successfull();
        csAgencySettings.click_on_edit_button_on_settings_page();
        csAgencySettings.verify_presence_of_remove_integration_button();
        csAgencySettings.remove_integration_from_agency();
    }

    @Test(dataProvider = "integrated_agency")
    public void to_verify_upon_clicking_on_open_integration_settings_button_from_info_tab_should_take_user_to_integration_tab(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.add_integration_from_info_tab_if_not_present();
        csAgencySettings.click_on_open_integration_settings_from_info_tab();
        csAgencySettings.verify_user_is_on_integration_tab_and_name_is_same_as_info_tab();
    }

    @Test(dataProvider = "integrated_agency")
    public void to_verify_user_can_change_partner_from_info_tab(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.click_on_edit_button_on_settings_page();
        csAgencySettings.select_integration_partner_from_info_tab();
        csAgencySettings.click_on_update_button();
        csAgencySettings.verify_update_succeed_on_info_page();
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.verify_user_is_on_integration_tab_and_name_is_same_as_info_tab();
    }

    @Test(dataProvider = "integrated_agency")
    public void to_verify_user_can_remove_partner_from_info_tab(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(agencyName);
        csHome.verify_searched_agency_from_searchbox(agencyName);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(agencyName);
        csAgencySettings.add_integration_from_info_tab_if_not_present();
        csAgencySettings.click_on_edit_button_on_settings_page();
        csAgencySettings.click_on_partners_list_dropdown();
        csAgencySettings.select_none_from_partner_list_from_info_tab();
        csAgencySettings.click_on_update_button();
        csAgencySettings.verify_update_succeed_on_info_page();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_info_page();
        csAgencySettings.click_on_integrations_link();
        csAgencySettings.verify_agency_not_integrated_with_partner_on_integration_page();
        csAgencySettings.select_integration_partner_and_verify_partner_changed_successfully();
    }
}
