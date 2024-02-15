package MobileTests.whole_flow;//package mobile.tests.whole_flow;
//
//import io.unity.framework.data.TestData;
//import io.unity.framework.init.Session;
//import io.unity.framework.init.base;
//import io.unity.framework.readers.DataReader;
//import io.unity.framework.readers.json_file_reader;
//import io.unity.performaction.autoweb.Wait;
//import mobile.object_repository.change_session.change_session_class;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import web.object_repository.new_panel.agenciesPage.agencies_page;
//import web.object_repository.new_panel.agencypage.add_employee_pop_up;
//import web.object_repository.new_panel.agencypage.agency_page;
//import web.object_repository.new_panel.agencypage.employee_profile_page;
//import web.object_repository.new_panel.agencypage.new_employee_create_page;
//import web.object_repository.new_panel.csdashboard.dashboard_page;
//import web.object_repository.new_panel.login.login_page;
//
//public class wholeTest extends base
//{
//    @DataProvider(name = "CA_login")
//    public Object[][] data_provider() {
//        json_file_reader config = new json_file_reader();
//        DataReader reader = new DataReader();
//        Object[][] data = null;
//        if (config.getEnvFromCurrentConfig().contains("test")) {
//            data = reader.getExcelDataForDataProvider("nevvon_test_env.xlsx", 0);
//        } else if (config.getEnvFromCurrentConfig().contains("prod")) {
//            data = reader.getExcelDataForDataProvider("nevvon_prod_env.xlsx", 0);
//        }
//        return data;
//    }
//
//
//    @Test(dataProvider = "CA_login")
//    public void test_whole(String user_name, String password, String agency_name)
//    {
//        Session sec = new Session();
//        driver.manage().window().fullscreen();
//        String userEmailID = "qabletest+"+TestData.random_numeric_string(3)+"@yopmail.com";
//        String userPassword = "QA_123456";
//
//        String first_name = TestData.first_name();
//        String last_name = TestData.last_name();
//        String mobile_no = TestData.random_numeric_string(10);
//        int hiring_date = TestData.get_todays_date();
//
//
//        login_page login = new login_page(driver);
//        dashboard_page dashboard = new dashboard_page(driver);
//        agency_page agency_home = new agency_page(driver);
//        agencies_page agencies_page = new agencies_page(driver);
//        add_employee_pop_up employee_popup = new add_employee_pop_up(driver);
//        new_employee_create_page employee_personal = new new_employee_create_page(driver);
//        employee_profile_page employee_profile = new employee_profile_page(driver);
////        change_environment change_env = new change_environment(driver);
////        login_screen login_screen = new login_screen(driver);//
////        home_screen home_screen = new home_screen(driver);//
//        Wait wait = new Wait(driver);
//
//
//        login.performLogin(user_name, password);
//
//        dashboard.click_on_agency_dropdown();
//        dashboard.click_on_agency_dropdown_search_bar();
//        dashboard.enter_text_at_search_for_option_text_box(agency_name);
//        dashboard.select_agency(agency_name);
//
//        agency_home.verify_new_employee_main_menu_button_is_present_on_page();
//
//        agency_home.click_on_new_employee_main_menu_button();
//
//
//        employee_popup.click_on_open_country_code_drop_down();
//        employee_popup.enter_text_at_country_code("Canada +1");
//        employee_popup.click_on_select_canada_option_drop_down();
//        employee_popup.enter_text_at_cell_no_text_box(mobile_no);
//
//
//        employee_popup.click_on_next_button_on_popup();
//
//        employee_personal.enter_text_at_first_name_text_box(first_name);
//        employee_personal.enter_text_at_last_name_text_box(last_name);
//        employee_personal.select_hiring_date(hiring_date);
//
//        employee_personal.click_on_submit_button();
//
//        dashboard.click_on_agencies_link();
//
//        agencies_page.enter_text_at_search_by_name_text_box(agency_name);
//        agencies_page.click_on_click_first_agency();
//
//        agency_home.enter_text_at_search_on_agency_page(last_name+" "+first_name);
//        agency_home.click_on_click_first_row_name();
//
//        employee_profile.click_on_email_pencil_tab();
//        employee_profile.enter_text_at_new_email_text_box(userEmailID);
//        employee_profile.click_on_check_mail_button();
//        employee_profile.enter_text_at_new_password_text_box(userPassword);
//        employee_profile.click_on_sign_up_button();
//
//        employee_profile.click_on_program_add_button();
//
//        employee_profile.enter_text_at_add_employee_to_program_popup_program_text_box("Test 5");
//        employee_profile.click_on_add_employee_to_program_popup_start_date();
//        employee_profile.setStartDate("6");
//        employee_profile.click_on_program_duration_by_text_box();
//        employee_profile.click_on_by_custom_date_button();
//        employee_profile.click_on_add_employee_to_program_popup_add_to_program_button();
//
//       // sec.create_new_mobile_session("nevvon_android");  //
//
//
//        change_session_class session = new change_session_class();   //
//        session.mobile_session(userEmailID,userPassword);            //
//
////        sec.close_session(driver);
////        sec.create_new_mobile_session("nevvon_android");
////        change_environment change_env = new change_environment(driver);
////        login_screen login_screen = new login_screen(driver);
////        home_screen home_screen = new home_screen(driver);
////
////
////        wait.wait_for_second(15);
////        login_screen.verify_okey_button_popup_is_present_on_page();
////        login_screen.click_on_okey_button_popup();
////
////        change_env.change_prod_to_test_environment();
////
////        login_screen.verify_email_is_present_on_page();
////        login_screen.verify_password_is_present_on_page();
////        login_screen.verify_login_button_is_present_on_page();
////
////        login_screen.enter_text_at_email(userEmailID);
////        login_screen.enter_text_at_password(userPassword);
////
////        login_screen.click_on_login_button();
////
////        home_screen.verify_assign_program_text_is_present_on_page();
////
////        sec.close_session(driver);
//
//
//    }
//}
