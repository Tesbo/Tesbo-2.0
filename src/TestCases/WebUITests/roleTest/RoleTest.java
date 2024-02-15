package WebUITests.roleTest;

import io.unity.core.data.TestData;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.agencypage.agency_page;
import web.object_repository.csdashboard.dashboard_page;
import web.object_repository.login.login_page;
import web.object_repository.roles.roles;

public class RoleTest extends base {
    @DataProvider(name = "CA_login")
    public Object[][] data_provider() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        if (config.getEnvFromCurrentConfig().contains("test")) {
            data = reader.getExcelDataForDataProvider("nevvon_test_env.xlsx", 0);
        } else if (config.getEnvFromCurrentConfig().contains("prod")) {
            data = reader.getExcelDataForDataProvider("nevvon_prod_env.xlsx", 0);
        }
        return data;
    }


    @Test(dataProvider = "CA_login")
    public void verify_when_click_on_Roles_Permission_tab_page_should_be_redirect_to_next_page(String user_name, String password, String agency_name) {
        Logger.log_qase_id("NP-507");

        LambdaTestConfig config = new LambdaTestConfig(driver);
      //  config.addTestName("verify when click on Roles Permission tab page should be redirect to next page");

        driver.manage().window().fullscreen();
        //String agency_name = "Triple A Homecaree - INTERNAL";
        String first_name = TestData.first_name();
        String last_name = TestData.last_name();
        String mobile_no = TestData.random_numeric_string(10);

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        agency_page agency_home = new agency_page(driver);
        roles roles = new roles(driver);


        login.performLogin(user_name, password);

        dashboard.click_on_agency_dropdown();
        dashboard.click_on_agency_dropdown_search_bar();
        dashboard.enter_text_at_search_for_option_text_box(agency_name);
        dashboard.select_agency(agency_name);

        agency_home.verify_new_employee_main_menu_button_is_present_on_page();

        roles.click_on_roles_tab();
        roles.verify_user_text_text_box_is_present_on_page();

    }
    @Test(dataProvider = "CA_login")
    public void verify_when_click_on_New_button_it_opens_Add_user_popup(String user_name, String password, String agency_name) {
        Logger.log_qase_id("NP-511");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on New button it opens Add user popup");

        driver.manage().window().fullscreen();
        //String agency_name = "Triple A Homecaree - INTERNAL";
        String first_name = TestData.first_name();
        String last_name = TestData.last_name();
        String mobile_no = TestData.random_numeric_string(10);

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        agency_page agency_home = new agency_page(driver);
        roles roles = new roles(driver);


        login.performLogin(user_name, password);

        dashboard.click_on_agency_dropdown();
        dashboard.click_on_agency_dropdown_search_bar();
        dashboard.enter_text_at_search_for_option_text_box(agency_name);
        dashboard.select_agency(agency_name);

        agency_home.verify_new_employee_main_menu_button_is_present_on_page();

        roles.click_on_roles_tab();
        roles.verify_user_text_text_box_is_present_on_page();
        roles.click_on_new_role();
        roles.verify_add_user_pop_up_text_box_is_present_on_page();

    }

    @Test(dataProvider = "CA_login")
    public void verify_that_when_keep_Empty_text_field_of_Add_user_popup_and_click_on_Create_button(String user_name, String password, String agency_name) {
        Logger.log_qase_id("NP-513");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify that when keep Empty text field of Add user popup and click on Create button");

        driver.manage().window().fullscreen();
        //String agency_name = "Triple A Homecaree - INTERNAL";
        String first_name = TestData.first_name();
        String last_name = TestData.last_name();
        String mobile_no = TestData.random_numeric_string(10);

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        agency_page agency_home = new agency_page(driver);
        roles roles = new roles(driver);


        login.performLogin(user_name, password);

        dashboard.click_on_agency_dropdown();
        dashboard.click_on_agency_dropdown_search_bar();
        dashboard.enter_text_at_search_for_option_text_box(agency_name);
        dashboard.select_agency(agency_name);

        agency_home.verify_new_employee_main_menu_button_is_present_on_page();

        roles.click_on_roles_tab();
        roles.verify_user_text_text_box_is_present_on_page();
        roles.click_on_new_role();
        roles.verify_add_user_pop_up_text_box_is_present_on_page();
        roles.click_on_add_user_create();
        roles.verify_access_group_required_pop_up_text_box_is_present_on_page();
        roles.verify_roles_required_pop_up_text_box_is_present_on_page();

    }

    @Test(dataProvider = "CA_login")
    public void verify_when_click_on_Create_Cancel_button_should_click(String user_name, String password, String agency_name) {
        Logger.log_qase_id("NP-514");
        Logger.log_qase_id("NP-516");
        Logger.log_qase_id("NP-519");
        Logger.log_qase_id("NP-525");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on Create Cancel button should click");

        driver.manage().window().fullscreen();
        //String agency_name = "Triple A Homecaree - INTERNAL";
        int number = Integer.parseInt(TestData.random_numeric_string(2));

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        agency_page agency_home = new agency_page(driver);
        roles roles = new roles(driver);


        login.performLogin(user_name, password);

        dashboard.click_on_agency_dropdown();
        dashboard.click_on_agency_dropdown_search_bar();
        dashboard.enter_text_at_search_for_option_text_box(agency_name);
        dashboard.select_agency(agency_name);

        agency_home.verify_new_employee_main_menu_button_is_present_on_page();

        roles.click_on_roles_tab();
        roles.verify_user_text_text_box_is_present_on_page();
        roles.click_on_new_role();
        roles.verify_add_user_pop_up_text_box_is_present_on_page();
        roles.click_on_add_user_cancel();
        roles.click_on_new_role();
        roles.enter_text_at_add_user_first_name("test");
        roles.enter_text_at_add_user_email("test"+TestData.random_alphabetic_string(2)+"@gmail.com");
        roles.click_on_access_dropdown();
        roles.click_on_select_access();
        roles.click_on_role_dropdown();
        roles.click_on_select_dropdown();
        roles.click_on_add_user_create();
        roles.verify_add_user_message_text_box_is_present_on_page();
    }

    @Test(dataProvider = "CA_login")
    public void verify_when_hover_the_cursor_over_Action_menu_for_the_user_it_shows_Edit_and_Reset_password_option(String user_name, String password, String agency_name) {
        Logger.log_qase_id("NP-532");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when hover the cursor over Action menu for the user it shows Edit and Reset password option");

        driver.manage().window().fullscreen();
        //String agency_name = "Triple A Homecaree - INTERNAL";
        int number = Integer.parseInt(TestData.random_numeric_string(2));

        login_page login = new login_page(driver);
        dashboard_page dashboard = new dashboard_page(driver);
        agency_page agency_home = new agency_page(driver);
        roles roles = new roles(driver);


        login.performLogin(user_name, password);

        dashboard.click_on_agency_dropdown();
        dashboard.click_on_agency_dropdown_search_bar();
        dashboard.enter_text_at_search_for_option_text_box(agency_name);
        dashboard.select_agency(agency_name);

        agency_home.verify_new_employee_main_menu_button_is_present_on_page();

        roles.click_on_roles_tab();
        roles.verify_user_text_text_box_is_present_on_page();
        roles.click_on_click_action();
        roles.verify_edit_action_text_box_is_present_on_page();
      //  roles.verify_reset_password_action_text_box_is_present_on_page();
    }
}
