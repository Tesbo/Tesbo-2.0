package MobileTests.help;

import io.appium.java_client.android.AndroidDriver;
import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import Screens.help_Screen.help_page;
import Screens.home_screen.home_screen;
import Screens.login.login_screen;
import Screens.profile_page.profile_page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class help_test extends base {
    @DataProvider(name = "mobile_user_login")
    public Object[][] data_provider() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;
        data = reader.getExcelDataForDataProvider("mobile_user_cred.xlsx", 0);
        return data;
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_that_clicking_on_Back_to_Home_button_leads_to_Home_page_of_the_help(String username,String password,String programName) {

        Logger.log_qase_id("NP-64");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_that_clicking_on_Back_to_Home_button_leads_to_Home_page_of_the_help");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile = new profile_page(driver);
        help_page help = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");
        home_screen.click_on_profile_icon();

        profile.verify_profile_tab_is_present_on_page();
        profile.verify_language_tab_button_present_on_page();
        profile.verify_profile_help_button_is_present_on_page();
        profile.click_on_profile_help_button();
        help.verify_help_for_caregivers_is_present_on_page();
        help.click_on_help_for_caregivers();
        help.verify_back_to_home_is_present_on_page();
        help.click_on_back_to_home();
    }

    @Test(dataProvider = "mobile_user_login")
    public void to_verify_when_click_on_hamburger_is_opens_the_pop_up_showing_contact_us_link(String username,String password,String programName) {

        Logger.log_qase_id("NP-76");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_when_click_on_hamburger_is_opens_the_pop_up_showing_contact_us_link");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile = new profile_page(driver);
        help_page help = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");
        home_screen.click_on_profile_icon();

        profile.verify_profile_tab_is_present_on_page();
        profile.verify_language_tab_is_present_on_page();
        profile.verify_profile_help_button_is_present_on_page();
        profile.click_on_profile_help_button();
        help.verify_hamburger_button_is_present_on_page();
        help.click_on_to_hamburger_button();
        help.verify_contact_us_option_is_present_on_page();
        help.verify_go_to_customer_portal_option_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_Need_Help_link_is_clickable_or_not(String username,String password,String programName) {

        Logger.log_qase_id("TC_SU_009");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_Need_Help_link_is_clickable_or_not");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        help_page help_screen = new help_page(driver);

        login_screen.verify_enter_Your_Phone_number_is_present();
        login_screen.verify_need_help_button_is_present();
        login_screen.click_On_need_help_button();
        help_screen.verify_go_to_how_can_we_help_you_text_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_Tap_on_help_it_opens_help_page(String username,String password,String programName) {

        Logger.log_qase_id("TC_PR_0019");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_Tap_on_help_it_opens_help_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile = new profile_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.click_on_profile_icon();

        profile.verify_profile_tab_is_present_on_page();
        profile.verify_language_tab_is_present_on_page();
        profile.verify_profile_help_button_is_present_on_page();
        profile.click_on_help_button();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_to_see_search_bar_option_and_links_of_Help_for_caregivers_help_for_Managers_Help_for_managers_on_behalf_of_caregivers_contact_us_and_Hamburger_at_help_page(String username,String password,String programName) {

        Logger.log_qase_id("TC_PR_0020");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_see_search_bar_option_and_links_of_Help_for_caregivers_help_for_Managers_Help_for_managers_on_behalf_of_caregivers_contact_us_and_Hamburger_at_help_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.click_on_profile_icon();

        profile.verify_profile_tab_is_present_on_page();
        profile.verify_language_tab_button_present_on_page();
        profile.verify_profile_help_button_is_present_on_page();
        profile.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.verify_search_text_box_help_page_is_present_on_page();
        help_page.verify_hamburger_button_is_present_on_page();
        help_page.scroll_to_bottom();
        help_page.verify_help_for_manager_text_is_present_on_page();
        help_page.verify_contact_us_link_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_user_is_able_to_search_terms_related_to_articles(String username,String password,String programName) {

        Logger.log_qase_id("TC_PR_0021");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_search_terms_related_to_articles");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
        profile_page.verify_language_tab_button_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.verify_search_text_box_help_page_is_present_on_page();
        help_page.click_on_to_search_text_box_help_page();
        help_page.enter_text_in_search_text_box_help_page("Login");
        ((AndroidDriver) driver).hideKeyboard();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_user_searches_irrelevant_terms_then_showing_message_No_result_for (String username,String password,String programName) {

        Logger.log_qase_id("TC_PR_0022");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_searches_irrelevant_terms_then_showing_message_No_result_for");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
        profile_page.verify_language_tab_button_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.verify_search_text_box_help_page_is_present_on_page();
        help_page.click_on_to_search_text_box_help_page();
        help_page.enter_text_in_search_text_box_help_page("3Kr");
        help_page.verify_no_result_search_text();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_after_getting_search_result_there_are_dropdown_menu_for_various_help_seekers_and_Back_to_Home_button_at_upper_left_side_available (String username,String password,String programName) {

        Logger.log_qase_id("TC_PR_0023");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_after_getting_search_result_there_are_dropdown_menu_for_various_help_seekers_and_Back_to_Home_button_at_upper_left_side_available");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
        profile_page.verify_language_tab_button_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.verify_search_text_box_help_page_is_present_on_page();
        help_page.click_on_to_search_text_box_help_page();
        help_page.enter_text_in_search_text_box_help_page("3Kr");
    //  ((AndroidDriver) driver).hideKeyboard();
        help_page.verify_no_result_search_text();
        help_page.verify_back_to_home_button_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_that_Taping_on_Back_to_Home_button_leads_to_Home_page_of_the_help(String username,String password,String programName) {

        Logger.log_qase_id("TC_PR_0024");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_that_Taping_on_Back_to_Home_button_leads_to_Home_page_of_the_help");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
        profile_page.verify_language_tab_button_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.verify_search_text_box_help_page_is_present_on_page();
        help_page.click_on_to_search_text_box_help_page();
        help_page.enter_text_in_search_text_box_help_page("3Kr");
     //   ((AndroidDriver) driver).hideKeyboard();
        help_page.verify_no_result_search_text();
        help_page.verify_back_to_home_button_is_present_on_page();
        help_page.click_on_back_to_home_button();
        help_page.verify_search_text_box_help_page_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_search_bar_option_is_also_available_at_search_result_page(String username,String password,String programName) {

        Logger.log_qase_id("TC_PR_0025");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_search_bar_option_is_also_available_at_search_result_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");
        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
        profile_page.verify_language_tab_button_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.verify_search_text_box_help_page_is_present_on_page();
        help_page.click_on_to_search_text_box_help_page();
        help_page.enter_text_in_search_text_box_help_page("3Kr");
    //  ((AndroidDriver) driver).hideKeyboard();
        help_page.verify_no_result_search_text();
        help_page.verify_search_option_on_top_help_page_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_when_Tap_on_Help_for_caregiver_Help_for_managers_and_Help_for_Managers_on_behalf_of_caregivers_it_shows_contact_us_link_and_Still_need_help_link(String username,String password,String programName) {


        Logger.log_qase_id("TC_PR_026");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_Tap_on_Help_for_caregiver_Help_for_managers_and_Help_for_Managers_on_behalf_of_caregivers_it_shows_contact_us_link_and_Still_need_help_link");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");
        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
        profile_page.verify_language_tab_button_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.click_on_help_for_caregivers();
        help_page.verify_back_to_home_is_present_on_page();
        help_page.verify_help_for_caregivers_text_is_present_on_help_page();
        help_page.verify_still_need_help_link_is_present_on_page();
        help_page.verify_contact_us_link_help_page_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_links_available_at_the_Help_for_caregiver_page_leads_to_related_articles(String username,String password,String programName) {


        Logger.log_qase_id("TC_PR_027");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_links_available_at_the_Help_for_caregiver_page_leads_to_related_articles");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");
        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
        profile_page.verify_language_tab_button_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.click_on_help_for_caregivers();
        help_page.verify_back_to_home_button_is_present_on_page();
        help_page.verify_still_need_help_link_is_present_on_page();
     // help_page.verify_contact_us_link_help_page_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_that_Taping_on_still_need_help_page_leads_to_page_where_links_in_various_language_is_available(String username,String password,String programName) {


        Logger.log_qase_id("TC_PR_028");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_that_Taping_on_still_need_help_page_leads_to_page_where_links_in_various_language_is_available");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");
        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
        profile_page.verify_language_tab_button_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.click_on_help_for_caregivers();
        help_page.verify_back_to_home_is_present_on_page();
        help_page.verify_help_for_caregivers_text_is_present_on_help_page();
        help_page.verify_still_need_help_link_is_present_on_page();
        help_page.click_on_to_still_need_help_link();
        help_page.verify_english_text_help_page_is_present_on_page();
        help_page.verify_still_need_help_english_link_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_that_Taping_on_links_available_at_still_need_help_page_leads_to_the_form_for_filling(String username,String password,String programName) {


        Logger.log_qase_id("TC_PR_029");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_that_Taping_on_links_available_at_still_need_help_page_leads_to_the_form_for_filling");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");
        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
        profile_page.verify_language_tab_button_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.click_on_help_for_caregivers();
        help_page.verify_back_to_home_button_is_present_on_page();
        help_page.verify_still_need_help_link_is_present_on_page();
        help_page.click_on_to_still_need_help_link();
        help_page.verify_english_text_help_page_is_present_on_page();
        help_page.verify_still_need_help_english_link_is_present_on_page();
        help_page.click_on_to_still_need_help_english_link();
        help_page.verify_submit_button_of_still_need_help_form_is_present_on_page();
    }

    @Test(dataProvider = "mobile_user_login")
    public void To_verify_that_user_is_not_able_to_submit_form_without_filling_mandatory_field(String username,String password,String programName) {


        Logger.log_qase_id("TC_PR_031");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_that_user_is_not_able_to_submit_form_without_filling_mandatory_field");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        profile_page profile_page = new profile_page(driver);
        help_page help_page = new help_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");
        home_screen.click_on_profile_icon();

        profile_page.verify_profile_tab_is_present_on_page();
    //  profile_page.verify_language_tab_is_present_on_page();
        profile_page.verify_profile_help_button_is_present_on_page();
        profile_page.click_on_help_button();
        help_page.verify_help_for_caregivers_is_present_on_page();
        help_page.click_on_help_for_caregivers();
        help_page.verify_back_to_home_button_is_present_on_page();
     // help_page.verify_help_for_caregivers_text_is_present_on_page();
        help_page.scroll_to_still_need_help_link();
        help_page.verify_still_need_help_link_is_present_on_page();
        help_page.click_on_to_still_need_help_link();
        help_page.verify_english_text_help_page_is_present_on_page();
        help_page.verify_still_need_help_english_link_is_present_on_page();
        help_page.click_on_to_still_need_help_english_link();
        help_page.verify_submit_button_of_still_need_help_form_is_present_on_page();
        help_page.click_on_to_submit_button_of_still_need_help_form();
        help_page.verify_please_complete_all_required_fields_text_is_present_on_page();
    }
}
