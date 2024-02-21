package TestCases.WebUITests.adminHomeTests;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.core.readers.JsonFileReader;
import Framework.java.io.unity.core.remotegrid.LambdaTestConfig;
import Framework.java.io.unity.performaction.autoweb.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;
import Pages.login.login_page;

public class admin_home_test extends base
{
    login_page login = null;
    //TODO web
    web.object_repository.employeeProfilePage.employeeProfile employeeProfile = null;
   web.object_repository.newEmployeesPage.new_employees new_employees = null;
   //TODO filter
   filter filter = null;
   //TODO program page
    program_page programPage = null;
    Wait wait = null;
    //TODO admin_home
    admin_home adminHome = null;
    //TODO program_page
    program_page program_page = null;

    @DataProvider(name = "login_credentials")
    public Object[][] data_provider() {
        //TODO changed
        JsonFileReader config = new JsonFileReader();
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
    public void To_verify_active_programs_list_on_the_homepage(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-364");
        Logger.log_qase_id("NEV-365");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify active programs list on the homepage");
        //config.addTestName("To verify the content on the program card");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.click_on_program_name_button();
        programPage.verify_program_profile_header_present_on_page();
        programPage.verify_in_progress_button_is_present_on_page();
        programPage.verify_due_soon_button_is_present_on_page();
        programPage.verify_pending_approval_button_is_present_on_page();
        programPage.verify_approved_button_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public void To_verify_when_clicks_on_due_soon_calendar_icon(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-366");
        Logger.log_qase_id("NEV-367");
        Logger.log_qase_id("NEV-368");
        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when clicks on due soon calendar icon");


        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.click_on_due_date_button();

        adminHome.verify_extend_due_date_popup_title_text_is_equal_to("Extend Due Date");
        adminHome.verify_extend_due_date_popup_employee_name_text_is_equal_to();
        adminHome.verify_extend_due_date_by_dropdown_is_present_on_page();
        adminHome.verify_notify_employees_checkbox_is_present_on_page();
        adminHome.verify_extend_due_date_popup_cancel_button_is_present_on_page();
        adminHome.verify_extend_due_date_popup_update_button_is_present_on_page();
        adminHome.verify_extend_due_date_popup_close_button_is_present_on_page();
        adminHome.click_on_extend_due_date_popup_close_button();

        adminHome.verify_Home_button_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public  void To_verify_when_selects_extend_due_date_by_dropdown(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-369");
        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when selects extend due date by dropdown");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_include_employees_with_expired_programs_checkbox();
        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.click_on_due_date_button();

        adminHome.click_on_extend_due_date_by_dropdown();
        adminHome.verify_extend_due_date_by_dropdown_select_is_present_on_page();
    }

    @Test(dataProvider = "login_credentials")
    public  void To_verify_when_select_1_month_for_extend_due_date (String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-370& TC_DB_010");
        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when select 1 month for extend due date");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_include_employees_with_expired_programs_checkbox();
        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.click_on_due_date_button();

        adminHome.click_on_extend_due_date_by_dropdown();
        adminHome.click_on_extend_due_date_by_dropdown_select("1 Month");
        adminHome.verify_extend_due_date_by_dropdown_select_is_present_on_page();

    }
    @Test(dataProvider = "login_credentials")
    public  void To_verify_when_select_2_weeks_option_for_extend_due_date (String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-370 & TC_DB_010");
        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when select 2 weeks option for extend due date");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_include_employees_with_expired_programs_checkbox();
        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.click_on_due_date_button();

        adminHome.click_on_extend_due_date_by_dropdown();
        adminHome.click_on_extend_due_date_by_dropdown_select("2 weeks");
        adminHome.verify_extend_due_date_by_dropdown_select_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public  void To_verify_when_clicks_on_custom_from_the_dropdown(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-371");
        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when clicks on custom from the dropdown");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_include_employees_with_expired_programs_checkbox();
        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.click_on_due_date_button();

        adminHome.click_on_extend_due_date_by_dropdown();
        adminHome.click_on_extend_due_date_by_dropdown_select("Custom");
        adminHome.verify_calendar_textbox_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public  void To_verify_when_clicks_on_include_employees_with_expired_programs_checkbox(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-426");
        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when clicks on include employees with expired programs checkbox");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.verify_active_programs_text_text_is_equal_to();
        adminHome.click_on_include_employees_with_expired_programs_checkbox();
        adminHome.verify_active_programs_text_text_is_equal_to();

    }
    @Test(dataProvider = "login_credentials")
    public  void To_verify_when_selects_date_from_the_calendar(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-372");
        LambdaTestConfig config = new LambdaTestConfig(driver);

        config.addTestName("To verify when selects date from the calendar");
        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_include_employees_with_expired_programs_checkbox();
        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.click_on_due_date_button();

       adminHome.click_on_extend_due_date_by_dropdown();
       adminHome.click_on_extend_due_date_by_dropdown_select("Custom");
       adminHome.enter_text_at_calendar_textbox("Oct 12, 2022");
    }

    @Test(dataProvider = "login_credentials")
    public  void To_verify_when_clicks_on_cancel_or_cross_button_after_entering_data(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-373");
        Logger.log_qase_id("NEV-374");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on cancel button");
        config.addTestName("To verify when clicks on cancel or cross button after entering data");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_include_employees_with_expired_programs_checkbox();
        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.click_on_due_date_button();

        adminHome.click_on_extend_due_date_by_dropdown();
        adminHome.click_on_extend_due_date_by_dropdown_select("Custom");
        adminHome.enter_text_at_calendar_textbox("Oct 12, 2022");

        adminHome.click_on_extend_due_date_by_dropdown();
        adminHome.verify_extend_due_date_popup_cancel_button_is_present_on_page();
        adminHome.click_on_extend_due_date_popup_cancel_button();

        adminHome.verify_due_date_button_is_present_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public  void To_verify_when_clicks_on_update_without_selecting_custom_date(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-375");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on update without selecting custom date");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_include_employees_with_expired_programs_checkbox();
        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.click_on_due_date_button();

        adminHome.click_on_extend_due_date_by_dropdown();
        adminHome.click_on_extend_due_date_by_dropdown_select("Custom");
        adminHome.click_on_extend_due_date_popup_update_button();
        adminHome.verify_due_date_mandatory_message_text_display_on_page();

    }

    @Test(dataProvider = "login_credentials")
    public  void To_verify_when_click_on_send_message_icon(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-429");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when click on send message icon");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_include_employees_with_expired_programs_checkbox();

        adminHome.verify_send_message_icon_is_present_on_page();
        adminHome.click_on_send_message_icon();

        adminHome.verify_send_message_popup_title_text_is_equal_to("Send Message to Employees");

    }

    @Test(dataProvider = "login_credentials")
    public  void To_verify_if_user_can_work_with_old_panel (String userName, String password, String agency_name)
    {
        Logger.log_qase_id("1093, TC_DB_024");

        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify if user can work with old panel");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_click_here_button();
       // adminHome.verify_redirect_to_old_panel_page();

    }
    @Test(dataProvider = "login_credentials")
    public  void verify_include_employees_with_expired_programs_check_box_is_responding(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-1082");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify include employees with expired programs check box is responding");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_include_employees_with_expired_programs_checkbox();

    }
    @Test(dataProvider = "login_credentials")
    public  void verify_when_clicks_on_download_certificates_arrow_icon(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-425 , TC_DB_017");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when clicks on download certificates arrow icon");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.verify_download_certificate_icon_present_on_page();
        adminHome.click_on_download_certificate_icon_button();
        adminHome.verify_certificate_download_validation_msg();

    }
    @Test(dataProvider = "login_credentials")
    public  void  verify_when_click_on_employee_icon_available_in_dashboard_of_program(String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-1086");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on employee icon available in dashboard of program");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        program_page = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.verify_on_program_employee_icon_present_on_page();
        adminHome.click_on_employee_icon_icon_button();
        program_page.verify_program_profile_page_display();

    }
    @Test(dataProvider = "login_credentials")
    public  void   verify_when_click_on_available_program_name_on_dashboard (String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-1087");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when click on available program name on dashboard");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        program_page = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.verify_on_program__present_on_dashboard_page();
        adminHome.click_on_program_name_text();
        program_page.verify_program_profile_page_display();

    }
    @Test(dataProvider = "login_credentials")
    public  void  verify_when_select_Notify_employee_check_box (String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-1088");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify when select Notify employee check box");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        program_page = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.click_on_due_date_button();
        adminHome.verify_extend_due_date_popup_present_on_page();
        adminHome.click_on_notify_employee_check_box();

    }
    @Test(dataProvider = "login_credentials")
    public  void  To_verify_when_clicks_on_Help_module (String userName, String password, String agency_name)
    {
        Logger.log_qase_id("NEV-1092");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify when clicks on Help module");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.click_on_help_button();
        //adminHome.verify_redirect_to_respective_page();

    }
    @Test(dataProvider = "login_credentials")
    public  void  To_verify_Completion_rate_of_Program_card  (String userName, String password, String agency_name)
    {
        Logger.log_qase_id("TC_DB_025");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To verify Completion rate of Program card ");

        login = new login_page(driver);
        new_employees = new new_employees(driver);
        programPage = new program_page(driver);
        adminHome = new admin_home(driver);
        wait = new Wait(driver);
        login.performLogin(userName, password);

        adminHome.verify_Home_button_is_present_on_page();
        adminHome.click_on_Home_button();

        adminHome.verify_due_date_button_is_present_on_page();
        adminHome.verify_completion_rate_is_present();

    }

}
