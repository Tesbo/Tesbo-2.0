package WebUITests.csHomeTests;

import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web.object_repository.csAgencySettingsPage.csAgencySettings_page;
import web.object_repository.csHomePage.csHome_page;
import web.object_repository.csdashboard.dashboard_page;
import web.object_repository.login.login_page;
import WebUITests.commonDataProviders.commonDataProvider;

public class csHomeTest extends base {
    login_page login = null;
    csHome_page csHome = null;
    csAgencySettings_page csAgencySettings = null;
    dashboard_page dashboard = null;

    @DataProvider(name = "agency_details")
    public Object[][] agency_creation_details(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 0);
    }

    @DataProvider(name = "edit_agency")
    public Object[][] edit_agency_name(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 3);
    }

    @DataProvider(name = "reset_emp_password")
    public Object[][] reset_password(){
        DataReader reader = new DataReader();
        return reader.getExcelDataForDataProvider("csData.xlsx", 5);
    }

    @Test(dataProvider = "cs_login", dataProviderClass = commonDataProvider.class)
    public void to_verify_clicking_agency_from_agencies_table(String username, String password){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_agency_from_agency_list();
    }

    @Test(dataProvider = "agency_name", dataProviderClass = commonDataProvider.class)
    public void to_verify_agency_search_from_searchbox(String username, String password, String Agency_Name){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(Agency_Name);
        csHome.verify_searched_agency_from_searchbox(Agency_Name);
    }

    @Test(dataProvider = "cs_login", dataProviderClass = commonDataProvider.class)
    public void verify_mandatory_fields_error_when_clicking_on_save_on_create_new_agency_page(String username, String password){
        login = new login_page(driver);
        dashboard = new dashboard_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        dashboard.verify_logo_is_present_on_page();
        csHome.navigate_to_create_new_agency_page();
        csHome.verify_user_is_on_create_agency_page();
        csHome.verify_error_without_filling_mandatory_fields_on_create_new_agency_page();
    }

    @Test(dataProvider = "agency_details")
    public void create_new_agency(String username, String password, String agency_name, String contact_name, String contact_email, String job_title, String contact_phone) {
        login = new login_page(driver);
        dashboard = new dashboard_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        dashboard.verify_logo_is_present_on_page();
        csHome.navigate_to_create_new_agency_page();
        csHome.verify_user_is_on_create_agency_page();
        csHome.fill_details_of_new_agency(agency_name, contact_name, contact_email, job_title, contact_email);
        csHome.click_on_save_to_create_new_agency();
        csHome.verify_new_agency_created(agency_name);
    }

    @Test(dataProvider = "edit_agency")
    public void to_verify_when_edit_agency(String username, String password, String Agency_Name, String newAgencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.enter_agency_name_in_search_box(Agency_Name);
        csHome.verify_searched_agency_from_searchbox(Agency_Name);
        csAgencySettings = csHome.click_on_edit_to_edit_agency();
        csAgencySettings.verify_csuser_on_agency_settings_page(Agency_Name);
        csAgencySettings.edit_agency_details(newAgencyName);
        csAgencySettings.click_on_update_to_save_updated_details();
    }

    @Test(dataProvider = "agency_name", dataProviderClass = commonDataProvider.class)
    public void to_verify_when_search_agency_from_top_nav_search(String username, String password, String agencyName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);
        dashboard = new dashboard_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.search_agency_from_top_navigation(agencyName);
        csHome.click_on_agency_from_top_nav_and_navigate_to_agency_dashboard(agencyName);
        dashboard.verify_csuser_is_on_agency_dashboard(agencyName);
    }

    @Test(dataProvider = "employee_data", dataProviderClass = commonDataProvider.class)
    public void to_verify_select_employee_from_employee_table(String username, String password, String employeeName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_employee_from_the_employeelist(employeeName);
    }

    @Test(dataProvider = "employee_data", dataProviderClass = commonDataProvider.class)
    public void to_verify_view_employee_details(String username, String password, String employeeName){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.click_on_view_details_and_verify_employee_profile_page(employeeName);
    }

    @Test(dataProvider = "reset_emp_password")
    public void to_verify_reset_password_with_send_email_option(String username, String password, String employeeName, String url, String newPassword){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_employees_tab_and_verify_user_is_on_employee_tab();
        csHome.search_employee_in_searchbox(employeeName);
        csHome.send_email_to_reset_password();
        csHome.log_out();
        csHome.navigate_to_email_app_and_reset_password(url, newPassword);
    }

    @Test(dataProvider = "cs_login", dataProviderClass = commonDataProvider.class)
    public void to_verify_when_selecting_programs_tab(String username, String password){
        login = new login_page(driver);
        csHome = new csHome_page(driver);

        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();
        login.performLogin(username, password);
        csHome.verify_user_is_on_cs_home_page();
        csHome.click_on_programs_tab_an_verify_user_is_on_programs_tab();
    }
}
