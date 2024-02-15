package WebUITests.RolesAccessTests;

import io.unity.core.init.Session;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import web.object_repository.employeeProfilePage.employeeProfile;
import web.object_repository.login.login_page;
import web.object_repository.newEmployeesPage.new_employees;
import web.object_repository.roleAccessPage.rolesAccess;
public class RolesAccessTests  extends base {

    login_page login = null;

    login_page loginAccess = null;
    rolesAccess rolesAccess = null;

    employeeProfile employeeProfile = null;
    new_employees new_employees = null;

    @DataProvider(name = "login_credentials")
    public Object[][] data_provider_New_Panel() {
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

    @DataProvider(name = "roleAccess_credentials")
    public Object[][] data_provider() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        if (config.getEnvFromCurrentConfig().contains("test") || config.getEnvFromCurrentConfig().contains("ngdev")) {
            data = reader.getExcelDataForDataProvider("nevvon_test_role_access.xlsx", 0);
        }
        return data;
    }

    @Test(dataProvider = "roleAccess_credentials")
    public void verify_when_clicks_on_scheduled_reports(String userName, String password, String agency_name) {
        Logger.log_qase_id("NP-190");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        //config.addTestName("verify when clicks on scheduled reports");


        Session session = new Session();
        WebDriver accessDriver = session.create_new_web_session("new_panel_chrome_Old");
        login = new login_page(driver);
        loginAccess = new login_page(accessDriver);
        rolesAccess = new rolesAccess(accessDriver);
        new_employees = new new_employees(driver);
        employeeProfile = new employeeProfile(driver);


        loginAccess.performLoginToCSPanel(userName,password);
        rolesAccess.click_on_login_button_web_CS_panel();
        rolesAccess.verify_agency_drop_down_is_present_on_page();
        rolesAccess.click_on_agency_drop_down_CS_panel(agency_name);
        rolesAccess.verify_and_Click_ok_button_roles_is_present_on_page();
        rolesAccess.verify_and_Click_ok_button_roles_is_present_on_page();
        rolesAccess.verify_roles_and_permissions_tab_is_present_on_page();
        rolesAccess.click_on_roles_and_permissions_tab_CS_panel();
        rolesAccess.verify_user_text_text_box_is_present_on_page();
        rolesAccess.verify_new_button_roles_is_present_on_page();
        rolesAccess.click_on_new_button_roles_CS_panel();
        rolesAccess.verify_first_name_text_box_roles_is_present_on_page();
        rolesAccess.enter_first_name_text_box_roles_CS_panel("Automation");
        rolesAccess.enter_email_text_box_roles_CS_panel("automation@yopmail.com");
        rolesAccess.verify_access_group_drop_down_is_present_on_page();
        rolesAccess.enter_text_on_access_group_drop_down_CS_panel();
        rolesAccess.verify_all_option_roles_is_present_on_page();
        rolesAccess.click_on_all_option_roles_CS_panel();
        rolesAccess.enter_roles_drop_down_CS_panel("Admin RN");
      //  rolesAccess.click_on_create_button_roles_CS_panel();
        Object[][] newPanel =  data_provider_New_Panel();
        login.performLogin((String) newPanel[0][0], (String) newPanel[0][1]);

        new_employees.verify_employees_Option_is_present_on_page();
        new_employees.click_on_employees_Option();
        employeeProfile.verify_employee_name_is_present_on_page();
        employeeProfile.click_on_employee_name();
        employeeProfile.navigateToNewTab();

        employeeProfile.verify_employee_name_header_is_present_on_page();

    }

}
