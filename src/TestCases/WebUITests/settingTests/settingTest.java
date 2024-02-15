package WebUITests.settingTests;

import io.unity.core.data.TestData;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.login.login_page;
//import web.object_repository.agencypage.settingPage;
import web.object_repository.newEmployeesPage.new_employees;
import web.object_repository.settingPage.setting_page;
import web.object_repository.program.program_page;

public class settingTest extends base {

    login_page login = null;
   // settingPage settingPage = null;

    setting_page settingPage = null;

    program_page program_page = null;

    new_employees new_employees = null;


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
    public void verify_when_clicks_on_Agency(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-459");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Agency");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_Search_for_name_email_of_the_provider(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-460");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when Search for name/email of the provider");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_agency_search_bar_is_present_on_page();
        settingPage.click_and_search_on_agency_search_bar(userName);
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_New_user_button(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-461");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on New user button");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_new_user_header_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_Save_button_after_enters_the_all_required_details(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-462");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Save button after enters the all required details");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_new_user_header_agency_is_present_on_page();
        settingPage.verify_name_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_name_text_box_new_user_agency("Automation");
        settingPage.verify_email_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_email_text_box_new_user_agency("automationabc@yopmail.com");
        settingPage.verify_roles_text_box_new_user_agency_is_present_on_page();
        //settingPage.verify_access_group_new_user_agency_is_present_on_page();
        settingPage.click_on_roles_text_box_new_user_agency();
        settingPage.verify_coordinates_option_new_user_agency_is_present_on_page();
        settingPage.click_on_coordinates_option_new_user_agency();
        settingPage.verify_save_button_new_user_agency_is_present_on_page();
        settingPage.click_on_save_button_new_user_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enter_email_already_assigned_earlier(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-463");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when enter email already assigned earlier");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_new_user_header_agency_is_present_on_page();
        settingPage.verify_name_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_name_text_box_new_user_agency("Automation");
        settingPage.verify_email_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_email_text_box_new_user_agency(userName);
        settingPage.verify_roles_text_box_new_user_agency_is_present_on_page();
        //settingPage.verify_access_group_new_user_agency_is_present_on_page();
        settingPage.click_on_roles_text_box_new_user_agency();
        settingPage.verify_coordinates_option_new_user_agency_is_present_on_page();
        settingPage.click_on_coordinates_option_new_user_agency();
        settingPage.verify_save_button_new_user_agency_is_present_on_page();
        settingPage.click_on_save_button_new_user_agency();
        settingPage.verify_edit_action_alert_new_user_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cross_icon_settingPage(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-464");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cross icon agency page");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_new_user_header_agency_is_present_on_page();
        settingPage.verify_name_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_name_text_box_new_user_agency("Automation");
        settingPage.verify_email_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_email_text_box_new_user_agency(userName);
        settingPage.verify_roles_text_box_new_user_agency_is_present_on_page();
        //settingPage.verify_access_group_new_user_agency_is_present_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cancel_button_settingPage(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-465");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cancel button agency page");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_new_user_header_agency_is_present_on_page();
        settingPage.verify_name_text_box_new_user_agency_is_present_on_page();
        settingPage.verify_cancel_button_agency_is_present_on_page();
        settingPage.click_on_cancel_button_agency();

        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_the_Roles_dropdown_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-466");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on the Roles dropdown");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_new_user_header_agency_is_present_on_page();
        settingPage.verify_name_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_name_text_box_new_user_agency("Automation");
        settingPage.verify_email_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_email_text_box_new_user_agency(userName);
        settingPage.verify_roles_text_box_new_user_agency_is_present_on_page();
        settingPage.click_on_roles_text_box_new_user_agency();
        settingPage.verify_coordinates_option_new_user_agency_is_present_on_page();
        settingPage.click_on_coordinates_option_new_user_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_the_Access_group_dropdown_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-467");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on the Access group dropdown");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_new_user_header_agency_is_present_on_page();
        settingPage.verify_name_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_name_text_box_new_user_agency("Automation");
        settingPage.verify_email_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_email_text_box_new_user_agency(userName);
        settingPage.verify_roles_text_box_new_user_agency_is_present_on_page();
        //settingPage.verify_access_group_new_user_agency_is_present_on_page();
        //settingPage.click_on_access_group_new_user_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Discipline_tab_settingPage(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-940");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Discipline tab");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_Search_for_any_discipline(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-941");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when Search for any discipline");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.verify_agency_search_bar_is_present_on_page();
        settingPage.click_and_search_on_agency_search_bar(userName);
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enters_details_in_New_discipline(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-942");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when enters details in New discipline");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_new_disciplines_button_agency();
        settingPage.verify_new_disciplines_header_agency_is_present_on_page();
        settingPage.verify_edit_name_text_box_disciplines_is_present_on_page();
        settingPage.enter_text_on_name_text_box_disciplines_agency("Doctor");
        settingPage.verify_save_button_disciplines_agency_is_present_on_page();
        settingPage.click_on_save_button_disciplines_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_save_button_without_entering_any_details_in_Discipline(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-944");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on save button without entering any details in Discipline");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();

        settingPage.click_on_new_disciplines_button_agency();
        settingPage.verify_new_disciplines_header_agency_is_present_on_page();
        settingPage.verify_edit_name_text_box_disciplines_is_present_on_page();
        settingPage.click_on_discipline_text_box();
        settingPage.verify_save_button_disciplines_agency_is_present_on_page();
        settingPage.click_on_save_button_disciplines_agency();
        settingPage.verify_name_required_alert_disciplines_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cancel_button_Discipline_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-943");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify_when_clicks_on_Cancel_button_Discipline_agency");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_new_disciplines_button_agency();
        //settingPage.verify_new_disciplines_header_agency_is_present_on_page();
        settingPage.verify_edit_name_text_box_disciplines_is_present_on_page();
        settingPage.click_on_cancel_button_disciplines_agency();
        settingPage.verify_new_disciplines_header_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cross_button_Discipline_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-945");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Cross button Discipline agency");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_new_disciplines_button_agency();
        settingPage.verify_new_disciplines_header_agency_is_present_on_page();
        settingPage.verify_edit_name_text_box_disciplines_is_present_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_new_disciplines_header_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Location_tab_settingPage(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-955");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on location tab agency page");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_Search_any_location_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-956");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Search any location");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.verify_agency_search_bar_is_present_on_page();
        settingPage.click_and_search_on_agency_search_bar(userName);
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enter_details_in_New_location_popup(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-957");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when enter details in New location popup");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();

        settingPage.click_on_new_location_button_agency();
        settingPage.verify_new_location_header_agency_is_present_on_page();
        settingPage.verify_name_text_box_location_agency_is_present_on_page();
        settingPage.enter_text_on_name_text_box_location_agency(userName);
        settingPage.verify_save_button_location_agency_is_present_on_page();
        settingPage.click_on_save_button_location_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_save_button_without_entering_any_details_in_Location(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-959");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on save button without entering any details in Location");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_new_location_button_agency();
        settingPage.verify_new_location_header_agency_is_present_on_page();
        settingPage.verify_name_text_box_location_agency_is_present_on_page();
        settingPage.verify_save_button_location_agency_is_present_on_page();
        settingPage.click_on_save_button_location_agency();
        settingPage.verify_name_required_alert_disciplines_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cancel_button_location_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-958");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cancel button Location agency");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_new_location_button_agency();
        settingPage.verify_new_location_header_agency_is_present_on_page();
        settingPage.verify_cancel_button_location_agency_is_present_on_page();
        settingPage.click_on_cancel_button_location_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cross_button_location_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-960");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cross button Location agency");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_new_location_button_agency();
        settingPage.verify_new_location_header_agency_is_present_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Automation_rules_tab(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-990");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Automation rules tab");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_automation_rules_tab_is_present_on_page();
        settingPage.click_on_automation_rules_tab();
        settingPage.verify_new_rule_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_Search_of_the_any_automation_rules(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-991");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when Search of the any automation rules");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_automation_rules_tab_is_present_on_page();
        settingPage.click_on_automation_rules_tab();
        settingPage.verify_new_rule_button_is_present_on_page();
        settingPage.verify_agency_search_bar_is_present_on_page();
        settingPage.click_and_search_on_agency_search_bar(userName);
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_New_rules_button(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-992");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on New rules button");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_automation_rules_tab_is_present_on_page();
        settingPage.click_on_automation_rules_tab();
        settingPage.verify_new_rule_button_is_present_on_page();
        settingPage.click_on_new_rule_button();
        settingPage.verify_create_automation_rule_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_Without_enter_any_details_in_Create_automation_rule_popup(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-994");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        //config.addTestName("To verify Without enter any details in Create automation rule popup");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_automation_rules_tab_is_present_on_page();
        settingPage.click_on_automation_rules_tab();
        settingPage.verify_new_rule_button_is_present_on_page();
        settingPage.click_on_new_rule_button();
        settingPage.verify_create_automation_rule_is_present_on_page();
        settingPage.verify_automation_rule_submit_button_is_present_on_page();
        settingPage.click_on_automation_rule_submit_button();
        settingPage.verify_name_is_required_alert_user_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cancel_button_automation_rule_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-995");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cancel button");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_automation_rules_tab_is_present_on_page();
        settingPage.click_on_automation_rules_tab();
        settingPage.verify_new_rule_button_is_present_on_page();
        settingPage.click_on_new_rule_button();
        settingPage.verify_create_automation_rule_is_present_on_page();
        settingPage.verify_automation_rule_cancel_button_is_present_on_page();
        settingPage.click_on_automation_rule_cancel_button();
        settingPage.verify_new_rule_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Deactivate_activate_of_any_user(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-926");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Deactivate/activate of any user");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_meatball_menu_of_any_user_in_settingPage(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-925");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on meatball menu of any user in agency page");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_existing_user_information(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-927");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when edits existing user information");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_edit_button_user();
        settingPage.verify_details_header_agency_user_is_present_on_page();
        settingPage.verify_edit_user_name_user_agency_is_present_on_page();
        settingPage.verify_edit_user_email_user_agency_is_present_on_page();
        settingPage.verify_edit_user_cancel_user_agency_is_present_on_page();
        settingPage.verify_edit_user_submit_user_agency_is_present_on_page();
        settingPage.click_on_edit_user_submit_user_agency();
        settingPage.verify_organization_role_alert_user_agency_is_present_on_page();
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cross_icon_user_agency(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-928");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cross icon user agency page");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_edit_button_user();
        settingPage.verify_details_header_agency_user_is_present_on_page();
        settingPage.verify_edit_user_name_user_agency_is_present_on_page();
        settingPage.verify_edit_user_email_user_agency_is_present_on_page();
        settingPage.verify_edit_user_cancel_user_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_new_user_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cancel_button_user_agency(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-930");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cancel button");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_edit_button_user();
        settingPage.verify_details_header_agency_user_is_present_on_page();
        settingPage.verify_edit_user_name_user_agency_is_present_on_page();
        settingPage.verify_edit_user_email_user_agency_is_present_on_page();
        settingPage.verify_edit_user_cancel_user_agency_is_present_on_page();
        settingPage.click_on_edit_user_cancel_user_agency();
        settingPage.verify_new_user_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_save_button_without_entering_any_details_in_New_user(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-929");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on save button without entering any details in New user");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_edit_user_submit_user_agency_is_present_on_page();
        settingPage.click_on_edit_user_submit_user_agency();
        settingPage.verify_name_is_required_alert_user_agency_is_present_on_page();
        settingPage.verify_email_is_required_alert_user_agency_is_present_on_page();
        settingPage.verify_role_is_required_alert_user_agency_is_present_on_page();

    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Reset_password_user_agency(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-931");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Reset password");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_reset_password_button_user();
        settingPage.verify_send_email_option_user_agency_is_present_on_page();
    }


    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Send_Email_option(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-936");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Send Email option");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_reset_password_button_user();
        settingPage.verify_send_email_option_user_agency_is_present_on_page();
        settingPage.click_on_send_email_option_user_agency();
        settingPage.verify_send_email_to_change_password_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Close_button_reset_password_agency(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-937");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Close button reset password agency");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_reset_password_button_user();
        settingPage.verify_send_email_option_user_agency_is_present_on_page();
        settingPage.click_on_send_email_option_user_agency();
        settingPage.verify_send_email_to_change_password_header_is_present_on_page();
        settingPage.verify_reset_password_cancel_button_is_present_on_page();
        settingPage.click_on_reset_password_cancel_button();
        settingPage.verify_new_user_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cross_button_reset_password_agency(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-939");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cross button reset password agency");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_reset_password_button_user();
        settingPage.verify_send_email_option_user_agency_is_present_on_page();
        settingPage.click_on_send_email_option_user_agency();
        settingPage.verify_send_email_to_change_password_header_is_present_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_new_user_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_meatball_menu_of_any_location(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-961");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on meatball menu of any location");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_entering_details_in_Add_Sub_location_popup(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-962");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when entering details in Add Sub location popup");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_add_button_sub_location_agency();
        settingPage.click_on_new_location_header_agency();
        settingPage.verify_name_text_box_location_agency_is_present_on_page();
        settingPage.enter_text_on_name_text_box_location_agency(userName);
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_save_button_without_entering_any_details_in_Add_Sublocation(String userName, String password, String agency_name) {

        Logger.log_qase_id("TC_ST_056");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on save button without entering any details in Add Sublocation");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_add_button_sub_location_agency();
        settingPage.click_on_new_location_header_agency();
        settingPage.verify_name_text_box_location_agency_is_present_on_page();
        settingPage.verify_save_button_location_agency_is_present_on_page();
        settingPage.click_on_save_button_location_agency();
        settingPage.verify_name_required_alert_disciplines_msg_display();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_existing_Main_location_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-966");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when edits existing Main location");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_edit_button_sub_location_agency();
        settingPage.verify_edit_header_location_is_present_on_page();
        settingPage.verify_name_text_box_location_agency_is_present_on_page();
        settingPage.verify_cancel_button_location_agency_is_present_on_page();
        settingPage.verify_save_button_location_agency_is_present_on_page();
        settingPage.click_on_save_button_location_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_existing_Main_cancel_button_location_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-966");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cancel button");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_edit_button_sub_location_agency();
        settingPage.verify_edit_header_location_is_present_on_page();
        settingPage.verify_name_text_box_location_agency_is_present_on_page();
        settingPage.verify_cancel_button_location_agency_is_present_on_page();
        settingPage.verify_save_button_location_agency_is_present_on_page();
        settingPage.click_on_cancel_button_location_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_enter_any_details_in_Create_automation_rule_popup(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-993");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when enter any details in Create automation rule popup");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_automation_rules_tab_is_present_on_page();
        settingPage.click_on_automation_rules_tab();
        settingPage.verify_new_rule_button_is_present_on_page();
        settingPage.click_on_new_rule_button();
        settingPage.verify_create_automation_rule_is_present_on_page();
        settingPage.verify_automation_rule_name_agency_is_present_on_page();
        settingPage.enter_name_automation_rule_name_agency(userName);
        settingPage.verify_choose_when_condition_automation_rule_is_present_on_page();
        settingPage.click_on_choose_when_condition_automation_rule_agency();
        settingPage.verify_created_or_reactivated_option_automation_rule_is_present_on_page();
        settingPage.verify_reactivated_in_agency_option_automation_rule_is_present_on_page();
        settingPage.verify_created_in_agency_option_automation_rule_is_present_on_page();
        settingPage.verify_completed_program_option_automation_rule_is_present_on_page();
        settingPage.click_on_created_or_reactivated_option_automation_rule_agency();
        settingPage.verify_automation_rule_submit_button_is_present_on_page();
        settingPage.click_on_automation_rule_submit_button();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_add_action_when_Create_automation_rule(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-1085");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify add action when Create automation rule");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_automation_rules_tab_is_present_on_page();
        settingPage.click_on_automation_rules_tab();
        settingPage.verify_new_rule_button_is_present_on_page();
        settingPage.click_on_new_rule_button();
        settingPage.verify_create_automation_rule_is_present_on_page();
        settingPage.verify_automation_rule_name_agency_is_present_on_page();
        settingPage.enter_name_automation_rule_name_agency(userName);
        settingPage.verify_choose_when_condition_automation_rule_is_present_on_page();
        settingPage.click_on_choose_when_condition_automation_rule_agency();
        settingPage.verify_created_or_reactivated_option_automation_rule_is_present_on_page();
        settingPage.verify_reactivated_in_agency_option_automation_rule_is_present_on_page();
        settingPage.verify_created_in_agency_option_automation_rule_is_present_on_page();
        settingPage.verify_completed_program_option_automation_rule_is_present_on_page();
        settingPage.click_on_created_or_reactivated_option_automation_rule_agency();

        settingPage.verify_program_dropdown_present_on_page();
        settingPage.click_on_program_dropdown();
        settingPage.select_program_from_dropdown();
        settingPage.verify_start_date_dropdown_present_on_page();
        settingPage.click_on_start_date_dropdown();
        settingPage.select_custom_option_for_start_date();
        settingPage.verify_custom_calender_option_display();
        settingPage.select_custom_date_in_calendar();
        settingPage.verify_due_date_dropdown_present();
        settingPage.click_on_due_date_dropdown_in_auto_rule();
        settingPage.select_on_31_december_option_for_due_date();
        settingPage.click_on_notify_each_employee_checkbox();

        settingPage.click_on_add_action_button();
        settingPage.verify_add_more_action_popup_display();
        settingPage.click_on_delete_icon_present_on_page();

       // settingPage.verify_automation_rule_submit_button_is_present_on_page();
        settingPage.click_on_automation_rule_submit_button();
        settingPage.verify_create_automation_rule_successfully();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_selecting_an_option_of_When_to_start_automation_rules(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-996");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify selecting an option of When to start automation rules");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_automation_rules_tab_is_present_on_page();
        settingPage.click_on_automation_rules_tab();
        settingPage.verify_new_rule_button_is_present_on_page();
        settingPage.click_on_new_rule_button();
        settingPage.verify_create_automation_rule_is_present_on_page();
        settingPage.verify_automation_rule_name_agency_is_present_on_page();
        settingPage.enter_name_automation_rule_name_agency(userName);
        settingPage.verify_choose_when_condition_automation_rule_is_present_on_page();
        settingPage.click_on_choose_when_condition_automation_rule_agency();
        settingPage.verify_created_or_reactivated_option_automation_rule_is_present_on_page();
        settingPage.verify_reactivated_in_agency_option_automation_rule_is_present_on_page();
        settingPage.verify_created_in_agency_option_automation_rule_is_present_on_page();
        settingPage.verify_completed_program_option_automation_rule_is_present_on_page();
        settingPage.click_on_created_or_reactivated_option_automation_rule_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_select_or_deselect_the_check_box_of_All_employee_for_who_create_an_automation_rule(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-997");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when select or deselect the check box of All employee for who create an automation rule");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_automation_rules_tab_is_present_on_page();
        settingPage.click_on_automation_rules_tab();
        settingPage.verify_new_rule_button_is_present_on_page();
        settingPage.click_on_new_rule_button();
        settingPage.verify_create_automation_rule_is_present_on_page();
        settingPage.verify_automation_rule_name_agency_is_present_on_page();
        settingPage.verify_employee_checkbox_option_automation_rule_is_present_on_page();
        settingPage.click_on_employee_checkbox_option_automation_rule_agency();
        settingPage.verify_all_employee_whose_automation_rule_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cancel_button_in_Add_Sublocation(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-963");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cancel button Add Sublocation");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_add_button_sub_location_agency();
        settingPage.click_on_new_location_header_agency();
        settingPage.verify_name_text_box_location_agency_is_present_on_page();
        settingPage.verify_cancel_button_location_agency_is_present_on_page();
        settingPage.verify_save_button_location_agency_is_present_on_page();
        settingPage.click_on_cancel_button_location_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_meatball_menu_of_any_discipline(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-946");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on meatball menu of any location");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_edit_button_sub_location_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_edits_details_for_existing_discipline(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-947,TC_ST_030");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when edits details for existing discipline");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();

        settingPage.mouse_hover_on_existing_discipline();
        settingPage.click_on_edit_icon_on_discipline();
        settingPage.verify_edit_discipline_popup_present();
        settingPage.enter_edit_discipline_name_agency("doctorr");
        settingPage.click_on_save_button_edit_discipline_popup();
        settingPage.verify_discipline_already_exit_alert_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cancel_button_in_discipline(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-948");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cancel button in discipline");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_edit_button_sub_location_agency();
        settingPage.verify_edit_header_location_is_present_on_page();
        settingPage.verify_edit_name_discipline_agency_is_present_on_page();
        settingPage.verify_cancel_button_edit_discipline_is_present_on_page();
        settingPage.click_on_cancel_button_edit_discipline_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_without_updating_details_in_existing_discipline(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-949");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify without updating details in existing discipline");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_edit_button_sub_location_agency();
        settingPage.verify_edit_header_location_is_present_on_page();
        settingPage.verify_edit_name_discipline_agency_is_present_on_page();
        settingPage.verify_cancel_button_edit_discipline_is_present_on_page();
        settingPage.verify_submit_button_edit_discipline_on_page();
        settingPage.click_on_submit_button_edit_discipline_agency();
        settingPage.verify_discipline_already_exit_alert_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_Cross_icon_in_discipline_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-950");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when click on Cross icon discipline agency");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_edit_button_sub_location_agency();
        settingPage.verify_edit_header_location_is_present_on_page();
        settingPage.verify_edit_name_discipline_agency_is_present_on_page();
        settingPage.verify_cancel_button_edit_discipline_is_present_on_page();
        settingPage.verify_submit_button_edit_discipline_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Delete_option_from_action_menu(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-951");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Delete option from action menu");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_discipline_header_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_Cancel_button_Delete_option_pop_up_box(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-952");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To  verify when clicks on Cancel button delete option pop up agency");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_discipline_header_on_page();
        settingPage.verify_cancel_button_delete_pop_up_is_present_on_page();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_confirm_button_Delete_option_pop_up_box_agency(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-953");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on confirm button delete option pop up agency");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_discipline_header_on_page();
        settingPage.verify_confirm_button_delete_pop_up_is_present_on_page();
       // settingPage.click_on_confirm_button_delete_pop_up_agency();

    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_cross_button_Delete_option_pop_up_box(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-954");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cross button Delete pop up box agency");

        login = new login_page(driver);
         settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_discipline_header_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_without_updating_details_in_existing_main_location(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-968");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify without updating details in existing main location");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_edit_button_sub_location_agency();
        settingPage.verify_edit_header_location_is_present_on_page();
        settingPage.verify_save_button_location_agency_is_present_on_page();
        settingPage.click_on_save_button_location_agency();
        settingPage.verify_location_already_exits_alert_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cross_icon_of_edit_locations_popup(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-969");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cross icon of edit locations popup sub location settings");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_edit_button_sub_location_agency();
        settingPage.verify_edit_header_location_is_present_on_page();
        settingPage.verify_save_button_location_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Delete_symbol_of_any_unassigned_location(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-970");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Delete symbol of any unassigned location sub location settings");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_location_header_is_present_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.verify_confirm_button_delete_pop_up_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_delete_button_of_any_assigned_location_not_able_to_delete(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-1062");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on delete button of any assigned location, not able to delete");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_location_header_is_present_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.verify_confirm_button_delete_pop_up_is_present_on_page();
        settingPage.click_on_confirm_button_delete_pop_up_agency();
      //  settingPage.verify_location_assigned_not_deleted_alert_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cancel_button_sub_location_setting(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-971");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Cancel button sub location setting");
        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);
        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_location_header_is_present_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.verify_cancel_button_remove_location_on_page();
        settingPage.click_on_cancel_button_remove_location();
        settingPage.verify_new_location_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Cross_icon_discipline_remove(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-954");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cross icon setting discipline remove pop up");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_discipline_header_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_confirm_button_for_Removing_discipline(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-972");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cross icon");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_discipline_header_on_page();
        settingPage.verify_confirm_button_delete_pop_up_is_present_on_page();
        settingPage.click_on_confirm_button_delete_pop_up_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cross_button_sub_location_setting(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-973");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Cross icon setting sub location remove pop up");
        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);
        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_add_button_sub_location_agency_is_present_on_page();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_location_header_is_present_on_page();
        settingPage.verify_cross_button_agency_is_present_on_page();
        settingPage.click_on_cross_button_agency();
        settingPage.verify_new_location_button_agency_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_delete_button_of_any_assigned_discipline_not_able_to_delete(String userName, String password, String agency_name) {

        Logger.log_qase_id("NEV-1061,TC_ST_057");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on delete button of any assigned discipline, not able to delete");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_new_disciplines_button_agency_is_present_on_page();
        settingPage.click_on_meatball_menu_sub_location();
        settingPage.verify_edit_button_sub_location_agency_is_present_on_page();
        settingPage.verify_delete_button_sub_location_agency_is_present_on_page();
        settingPage.click_on_delete_button_sub_location_agency();
        settingPage.verify_remove_discipline_header_on_page();
        settingPage.verify_confirm_button_delete_pop_up_is_present_on_page();
        settingPage.click_on_confirm_button_delete_pop_up_agency();
        settingPage.verify_discipline_assigned_cannot_deleted_alert_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_Send_button_reset_password_send_email(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-937");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on Send button reset password send email");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_reset_password_button_user();
        settingPage.verify_send_email_option_user_agency_is_present_on_page();
        settingPage.click_on_send_email_option_user_agency();
        settingPage.verify_send_email_to_change_password_header_is_present_on_page();
        settingPage.verify_reset_password_cancel_button_is_present_on_page();
        settingPage.verify_reset_password_send_button_is_present_on_page();
        settingPage.click_on_reset_password_send_button();
        settingPage.verify_email_sent_alert_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_cancel_button_reset_password_send_email(String userName, String password, String agency_name) {
        Logger.log_qase_id("");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button reset password send email");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_reset_password_button_user();
        settingPage.verify_send_email_option_user_agency_is_present_on_page();
        settingPage.click_on_send_email_option_user_agency();
        settingPage.verify_send_email_to_change_password_header_is_present_on_page();
        settingPage.verify_reset_password_cancel_button_is_present_on_page();
       settingPage.click_on_cancel_button();
        settingPage.verify_agency_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_clicks_on_close_icon_button_reset_password_send_email(String userName, String password, String agency_name) {
        Logger.log_qase_id("");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on close icon button reset password send email");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        program_page.click_on_meatball_menu();
        settingPage.verify_deactivate_button_user_is_present_on_page();
        settingPage.verify_edit_button_user_is_present_on_page();
        settingPage.verify_reset_password_button_user_is_present_on_page();
        settingPage.click_on_reset_password_button_user();
        settingPage.verify_send_email_option_user_agency_is_present_on_page();
        settingPage.click_on_send_email_option_user_agency();
        settingPage.verify_send_email_to_change_password_header_is_present_on_page();
        settingPage.click_on_close_icon_button();
        settingPage.verify_agency_header_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_location_is_required_when_Select_Make_this_required_field (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_ST_064");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify location is required when Select Make this required field");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();

        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_make_this_is_required_location_field_display_when_integrated_agency();
        settingPage.click_on_Make_this_is_required_location_field();


        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();

        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Nevvon");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Test");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
        new_employees.enter_text_at_employee_hiring_date_text_box("2022-08-29");

        new_employees.verify_location_field_is_present();
        new_employees.select_location_from_the_location_dropdown();
        new_employees.click_on_cancel_button();

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();

        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();

        settingPage.click_on_Make_this_is_required_location_field_uncheck();
        settingPage.verify_make_this_is_required_location_field_display_when_integrated_agency();
    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_discipline_is_required_when_Select_Make_this_required_field (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_ST_065");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify discipline is required when Select Make this required field");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();

        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_make_this_is_required_field_display_when_integrated_agency();
        settingPage.click_on_Make_this_is_required_field();

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Nevvon");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Test");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
        new_employees.enter_text_at_employee_hiring_date_text_box("2022-08-29");

        new_employees.verify_discipline_field_is_present();
        new_employees.select_discipline_from_the_dropdown();
        new_employees.click_on_cancel_icon_on_popup();

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();

        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();

        settingPage.click_on_Make_this_is_required_discipline_field_uncheck();
        settingPage.verify_make_this_is_required_field_display_when_integrated_agency();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_without_select_discipline_field_when_discipline_is_required_while_creating_new_Employee (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_ST_068");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify without select discipline field when discipline is required while creating new Employee");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();

        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();
        settingPage.verify_make_this_is_required_field_display_when_integrated_agency();
        settingPage.click_on_Make_this_is_required_field();

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Nevvon");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Test");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
        new_employees.enter_text_at_employee_hiring_date_text_box("2022-08-29");

        new_employees.click_on_create_button();

        new_employees.verify_discipline_is_required();
        new_employees.click_on_cancel_button();

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();

        settingPage.verify_disciplines_tab_agency_is_present_on_page();
        settingPage.click_on_disciplines_tab_agency();

        settingPage.click_on_Make_this_is_required_discipline_field_uncheck();
        settingPage.verify_make_this_is_required_field_display_when_integrated_agency();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_without_select_location_field_when_location_is_required_while_creating_new_Employee (String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_ST_069");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify without select location field when location is required while creating new Employee");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        program_page = new program_page(driver);
        new_employees = new new_employees(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();

        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();
        settingPage.verify_make_this_is_required_location_field_display_when_integrated_agency();
        settingPage.click_on_Make_this_is_required_location_field();

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        new_employees.verify_new_employees_button_is_present_on_page();
        new_employees.click_on_new_employees_button();

        new_employees.verify_phone_number_text_box_is_present_on_page();
        new_employees.enter_text_at_phone_number_text_box(TestData.random_numeric_string(10));
        new_employees.click_on_continue_button();

        new_employees.verify_first_name_text_box_is_present_on_page();
        new_employees.enter_text_at_first_name_text_box("Nevvon");

        new_employees.verify_last_name_text_box_is_present_on_page();
        new_employees.enter_text_at_last_name_text_box("Test");
        new_employees.click_on_continue_button();

        new_employees.verify_employee_hiring_date_text_box_is_present_on_page();
        new_employees.enter_text_at_employee_hiring_date_text_box("2022-08-29");

        new_employees.click_on_create_button();

        new_employees.verify_location_is_required();
        new_employees.click_on_cancel_button();

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();

        settingPage.verify_location_tab_agency_is_present_on_page();
        settingPage.click_on_location_tab_agency();

        settingPage.click_on_Make_this_is_required_location_field_uncheck();
        settingPage.verify_make_this_is_required_location_field_display_when_integrated_agency();
    }
    @Test(dataProvider = "login_credentials")
    public void  Verify_creating_access_group_user(String userName, String password, String agency_name) {
        Logger.log_qase_id("TC_AG_001");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("Verify creating access group user");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_name_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_name_text_box_new_user_agency("Automation");
        settingPage.verify_email_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_email_text_box_new_user_agency("automationabc@yopmail.com");
        settingPage.verify_roles_text_box_new_user_agency_is_present_on_page();
        settingPage.click_on_roles_text_box_new_user_agency();
        settingPage.click_on_coordinates_option_new_user_agency();
        settingPage.click_on_access_dropdown();
        settingPage.select_access_group_option();
        settingPage.click_on_access_group_new_user_agency();
        settingPage.select_access_group_dropdown_option();
        settingPage.click_on_save_button_new_user_agency();
        settingPage.verify_already_assigned_role_access_validation_message();
    }
    @Test(dataProvider = "login_credentials")
    public void  To_verify_multiple_roles_can_be_assigned_to_single_user(String userName, String password, String agency_name) {

        Logger.log_qase_id("TC_ST_059");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify multiple roles can be assigned to single user");

        login = new login_page(driver);
        settingPage = new setting_page(driver);
        login.performLogin(userName, password);

        settingPage.verify_navigation_agency_is_present_on_page();
        settingPage.click_on_navigation_agency();
        settingPage.verify_agency_header_is_present_on_page();
        settingPage.verify_new_user_button_agency_is_present_on_page();
        settingPage.click_on_new_user_button_agency();
        settingPage.verify_new_user_header_agency_is_present_on_page();
        settingPage.verify_name_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_name_text_box_new_user_agency("Automation");
        settingPage.verify_email_text_box_new_user_agency_is_present_on_page();
        settingPage.enter_text_on_email_text_box_new_user_agency("automationabc@yopmail.com");
        settingPage.verify_roles_text_box_new_user_agency_is_present_on_page();

        settingPage.click_on_roles_text_box_new_user_agency();
        settingPage.verify_coordinates_option_new_user_agency_is_present_on_page();
        settingPage.click_on_coordinates_option_new_user_agency();
        settingPage.click_on_roles_text_box_new_user_agency();
        settingPage.verify_admin_role_option_present_on_page();
        settingPage.click_on_admin_role_option_available_in_dropdown();
        settingPage.verify_save_button_new_user_agency_is_present_on_page();
        settingPage.click_on_save_button_new_user_agency();
        settingPage.verify_already_assigned_role_access_validation_message();
    }
}

