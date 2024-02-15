package MobileTests.Search;

import io.unity.core.init.base;
import io.unity.core.readers.DataReader;
import io.unity.core.readers.json_file_reader;
import io.unity.core.remotegrid.LambdaTestConfig;
import Screens.home_screen.home_screen;
import Screens.login.login_screen;
import Screens.search.search_page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class search_tests extends base {
    @DataProvider(name = "mobile_user_login")
    public Object[][] data_provider() {
        json_file_reader config = new json_file_reader();
        DataReader reader = new DataReader();
        Object[][] data = null;

        data = reader.getExcelDataForDataProvider("mobile_user_cred.xlsx", 0);

        return data;
    }

    @Test()
    public void verify_user_can_search_any_specific_lesson_using_search_option()
    {
        Logger.log_qase_id("NP-100");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_user_can_search_any_specific_lesson_using_search_option");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        search_page search_page = new search_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.click_on_search_bottom_button();
       // home_screen.verify_search_bottom_button_is_selected();

        search_page.verify_search_box_button_is_present_on_page();
        search_page.click_on_search_box_button();
        search_page.enter_text_at_search_text_box("Corona");
      //  search_page.verify_search_result_is_displayed_on_page("Corona");
        search_page.verify_search_result_is_present_on_page();


    }

    @Test()
    public void verify_if_user_search_anything_outside_module_or_lesson_it_does_not_show_any_search_result()
    {
        Logger.log_qase_id("NP-104");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_if_user_search_anything_outside_module_or_lesson_it_does_not_show_any_search_result");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        search_page search_page = new search_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_search_bottom_button_is_clickable();
        home_screen.click_on_search_bottom_button();
       // home_screen.verify_search_bottom_button_is_selected();

        search_page.verify_search_box_button_is_present_on_page();
        search_page.click_on_search_box_button();
        search_page.enter_text_at_search_text_box("abc");


    }

    @Test()
    public void To_verify_when_user_searches_irrelevant_terms_then_showing_message_No_result_for_searched_term()
    {
        Logger.log_qase_id("NP-62");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_searches_irrelevant_terms_then_showing_message_No_result_for_searched_term");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        search_page search_page = new search_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_search_bottom_button_is_clickable();
        home_screen.click_on_search_bottom_button();
     //   home_screen.verify_search_bottom_button_is_selected();

        search_page.verify_search_box_button_is_present_on_page();
        search_page.click_on_search_box_button();
        search_page.enter_text_at_search_text_box("3Kr");
        search_page.verify_modules_text_is_present_on_page();

    }

    @Test()
    public void To_verify_when_tap_on_search_bar_tabs_of_Homepage_Notification_and_Bookmark_does_not_disappear()
    {
        Logger.log_qase_id("FA-216");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_tap_on_search_bar_tabs_of_Homepage_Notification_and_Bookmark_does_not_disappear");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        search_page search_page = new search_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.click_on_search_bottom_button();
    //    home_screen.verify_search_bottom_button_is_selected();

        search_page.verify_search_box_button_is_present_on_page();
        search_page.click_on_search_box_button();
        search_page.enter_text_at_search_text_box("3Kr");
        //home_screen.verify_Bookmarks_bottom_button_is_present_on_page();
    }

    @Test()
    public void to_verify_user_is_able_to_search_any_specific_module_using_search_option()
    {
        Logger.log_qase_id("FA-211");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("to_verify_user_is_able_to_search_any_specific_module_using_search_option");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        search_page search_page = new search_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.click_on_search_bottom_button();
      //  home_screen.verify_search_bottom_button_is_selected();

        search_page.verify_search_box_button_is_present_on_page();
        search_page.click_on_search_box_button();
        search_page.enter_text_at_search_text_box("Corona");
        //  search_page.verify_search_result_is_displayed_on_page("Corona");
        search_page.verify_search_result_is_present_on_page();
    }

    @Test()
    public void To_verify_when_click_on_search_tab_it_opens_search_page()
    {
        Logger.log_qase_id("FA-217");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_click_on_search_tab_it_opens_search_page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        search_page search_page = new search_page(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.click_on_search_bottom_button();
      //  home_screen.verify_search_bottom_button_is_selected();

        search_page.verify_search_box_button_is_present_on_page();
        search_page.click_on_search_box_button();
        search_page.enter_text_at_search_text_box("Corona");
    }


}
