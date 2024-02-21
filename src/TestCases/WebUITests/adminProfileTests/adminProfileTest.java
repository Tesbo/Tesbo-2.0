package TestCases.WebUITests.adminProfileTests;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.core.readers.JsonFileReader;
import Framework.java.io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import Pages.login.login_page;


public class adminProfileTest extends base {

     login_page login = null;
    admin_profile admin_profile = null;
    @DataProvider(name = "login_credentials")
    public Object[][] data_provider() {
        //TODO changed name
        JsonFileReader config = new JsonFileReader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        if (config.getEnvFromCurrentConfig().contains("test") || config.getEnvFromCurrentConfig().contains("ngdev") ) {
            data = reader.getExcelDataForDataProvider("nevvon_test_env.xlsx", 0);
        } else if (config.getEnvFromCurrentConfig().contains("admin")) {
            data = reader.getExcelDataForDataProvider("nevvon_prod_env.xlsx", 0);
        }
        return data;
    }

    @Test(dataProvider = "login_credentials")
    public void verify_when_click_on_my_profile_on_side_nav_bar(String userName, String password, String agency_name) {

        Logger.log_qase_id("NP-1");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on my profile on side nav bar");


        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.verify_log_out_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_edit_button(String userName, String password, String agency_name) {

        Logger.log_qase_id("NP-2");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on edit button");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();
        admin_profile.verify_update_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_edit_email_address(String userName, String password, String agency_name) {

        Logger.log_qase_id("1090 , TC_AP_016");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when edit email address");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();
        admin_profile.enter_edit_email_text_box("autotest@mailinator.com");
        admin_profile.click_on_update_button();
        admin_profile.verify_profile_edit_successfully_alert_msg_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_remove_Agency_Email_from_the_email_text_box(String userName, String password, String agency_name) {

        Logger.log_qase_id("1091 , TC_AP_017");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when remove Agency Email from the email text box");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();

        admin_profile.remove_email_in_email_text_box();
        admin_profile.click_on_update_button();
        //admin_profile.verify_email_is_required_validation_message_display();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_cancel_button(String userName, String password, String agency_name) {

        Logger.log_qase_id("NP-377");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on cancel button");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();
        admin_profile.verify_update_button_is_present_on_page();
        admin_profile.verify_cancel_button_is_present_on_page();
        admin_profile.click_on_cancel_button();
        admin_profile.verify_edit_button_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_when_clicks_on_logout(String userName, String password, String agency_name) {

        Logger.log_qase_id("NP-383");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on logout");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.verify_log_out_button_is_present_on_page();
        admin_profile.click_on_log_out_button();
        login.verify_email_text_box_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void  verify_the_details_on_the_profile_page(String userName, String password, String agency_name) {

        Logger.log_qase_id("NP-376");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify the details on the profile page");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();
        admin_profile.verify_update_button_is_present_on_page();
        admin_profile.verify_name_text_box_is_present_on_page();
        admin_profile.verify_change_image_button_is_present_on_page();
        admin_profile.verify_default_landing_page_text_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public void   verify_when_clicks_on_default_landing_page_dropdown(String userName, String password, String agency_name) {

        Logger.log_qase_id("NP-379");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on default landing page dropdown");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();
        admin_profile.verify_update_button_is_present_on_page();

        admin_profile.verify_default_landing_drop_down_is_present_on_page();
        admin_profile.click_on_default_landing_drop_down();
        admin_profile.verify_home_option_is_present_on_page();
        admin_profile.verify_employees_option_is_present_on_page();
        admin_profile.verify_programs_option_is_present_on_page();
        admin_profile.verify_reports_option_is_present_on_page();
        admin_profile.click_on_home_option();
        admin_profile.click_on_update_button();
        admin_profile.verify_profile_edit_successfully_alert_msg_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void   verify_when_clicks_on_update(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-382");
        Logger.log_qase_id("NEV-395");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify when clicks on update");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();
        admin_profile.verify_update_button_is_present_on_page();

        admin_profile.verify_default_landing_drop_down_is_present_on_page();
        admin_profile.click_on_update_button();
        admin_profile.verify_profile_edit_successfully_alert_msg_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void   verify_that_change_image_button_is_clickable(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-392");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName(" verify that change image button is clickable");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();

        admin_profile.verify_change_image_button_is_present_on_page();
        admin_profile.click_on_change_image_button();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_edits_the_agency_name(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-378");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when edits the agency name");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();

        admin_profile.verify_name_text_box_is_present_on_page();
        admin_profile.enter_agency_name_for_edit_name("AutoTest");

        admin_profile.click_on_update_button();
        admin_profile.verify_profile_edit_successfully_alert_msg_is_present_on_page();
    }
    @Test(dataProvider = "login_credentials")
    public void To_verify_when_remove_agency_name_from_the_name_text_box(String userName, String password, String agency_name) {
        Logger.log_qase_id("NEV-1089");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when remove agency name from the name text box");

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        admin_profile admin_profile = new admin_profile(driver);
        login.verify_email_text_box_is_present_on_page();
        login.verify_password_button_is_present_on_page();
        login.verify_login_button_is_present_on_page();

        login.performLogin(userName, password);

        dashboard.verify_logo_is_present_on_page();
        admin_profile.verify_account_button_is_present_on_page();
        admin_profile.click_on_account_button();
        admin_profile.verify_my_profile_button_is_present_on_page();
        admin_profile.click_on_my_profile_button();
        admin_profile.verify_edit_button_is_present_on_page();
        admin_profile.click_on_edit_button();

        admin_profile.verify_name_text_box_is_present_on_page();
        admin_profile.remove_name_from_the_text_box();

        admin_profile.click_on_update_button();
        //admin_profile.verify_name_is_required_validation_message_display();

    }

}
