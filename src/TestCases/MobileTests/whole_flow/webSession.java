package MobileTests.whole_flow;//package mobile.tests.whole_flow;
//import io.unity.framework.data.TestData;
//import io.unity.framework.init.Session;
//import io.unity.framework.init.base;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import web.object_repository.new_panel.agenciesPage.agencies_page;
//import web.object_repository.new_panel.agencypage.add_employee_pop_up;
//import web.object_repository.new_panel.agencypage.agency_page;
//import web.object_repository.new_panel.agencypage.employee_profile_page;
//import web.object_repository.new_panel.agencypage.new_employee_create_page;
//import web.object_repository.new_panel.csdashboard.dashboard_page;
//import web.object_repository.new_panel.login.login_page;
//
//public class webSession extends base {
//    WebDriver driver = null;
//    Session session = null;
//    public webSession(){
//        session = new Session();
//        this.driver = session.create_new_web_session("dev");
//    }
//
//    public void webTest()
//    {
//        String userEmailID = "qabletest+"+TestData.random_numeric_string(3)+"@yopmail.com";
//        String userPassword = "QA_123456";
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
//
//        login.performLogin("viral@nevvon.com", "12345a");
//
//        dashboard.click_on_agency_dropdown();
//        dashboard.click_on_agency_dropdown_search_bar();
//        dashboard.enter_text_at_search_for_option_text_box("triple Homecaree - INTERNAL");
//        dashboard.select_agency("triple Homecaree - INTERNAL");
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
//        agencies_page.enter_text_at_search_by_name_text_box("triple Homecaree - INTERNAL");
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
//
//    }
//
//    public WebDriver change_session_to_other(String config_name,String config_name2) {
//        base base = new base();
//        WebDriver driver1 = base.init(config_name);
//        session.close_session(driver1);
//
//        WebDriver driver = base.init(config_name2);
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abgd");
//        return this.driver;
//    }
//
//}
