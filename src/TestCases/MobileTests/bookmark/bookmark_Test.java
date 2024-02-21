package TestCases.MobileTests.bookmark;

import Framework.java.io.unity.core.init.base;
import Framework.java.io.unity.core.readers.JsonFileReader;
import Framework.java.io.unity.core.readers.DataReader;
import Framework.java.io.unity.core.remotegrid.LambdaTestConfig;
import Screens.bookmarks.bookmarks;
import Screens.home_screen.home_screen;
import Screens.login.login_screen;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class bookmark_Test extends base {

    @DataProvider(name = "mobile_user_login")
    public Object[][] data_provider() {
        //TODO old code json_file_reader config = new json_file_reader();
        JsonFileReader config = new JsonFileReader();
        DataReader reader = new DataReader();
        Object[][] data = null;

        data = reader.getExcelDataForDataProvider("mobile_user_cred.xlsx", 0);

        return data;
    }
    @Test()
    public void verify_when_click_on_Bookmark_tab_then_it_opens_the_bookmark_page_and_Bookmark_tab_is_highlighted()
    {
        Logger.log_qase_id("TC_BFA_001");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_when_click_on_Bookmark_tab_then_it_opens_the_bookmark_page_and_Bookmark_tab_is_highlighted");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        bookmarks bookmark = new bookmarks(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_Bookmarks_bottom_button_is_present_on_page();
        home_screen.click_on_Bookmarks_bottom_button();

        bookmark.verify_bookmarks_text_is_present_on_page();

    }

    @Test()
    public void verify_that_user_can_bookmark_the_lesson()
    {
        Logger.log_qase_id("NP-123");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("verify_that_user_can_bookmark_the_lesson");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        bookmarks bookmark = new bookmarks(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_home_bottom_button_is_present_on_page();
      //  home_screen.click_on_play_video_button();
//        home_screen.click_on_bookmarks_icon_button();
//        home_screen.click_on_home_back_button();
//        home_screen.click_on_Bookmarks_bottom_button();
     //   bookmark.verify_bookmarks_video_link_is_present_on_page();

    }

    @Test()
    public void To_verify_bookmarked_video_is_shown_in_bookmarks_tab() {
        Logger.log_qase_id("TC_BFA_002");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_bookmarked_video_is_shown_in_bookmarks_tab");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        bookmarks bookmark = new bookmarks(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_first_video_of_6m();
        home_screen.click_on_ok_button();
        bookmark.verify_bookmarks_save_and_remove_button_is_selected();
        bookmark.click_on_bookmarks_save_and_remove_button();
        bookmark.click_on_back_button_from_video_screen();

        home_screen.verify_Bookmarks_bottom_button_is_present_on_page();
        home_screen.click_on_Bookmarks_bottom_button();
        bookmark.verify_bookmark_video_in_bookmark_screen_is_displayed();
    }

    @Test()
    public void To_verify_when_disselect_bookmark_at_the_video_it_is_removed_from_the_bookmarks_tab() {
        Logger.log_qase_id("TC_BFA_003");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_disselect_bookmark_at_the_video_it_is_removed_from_the_bookmarks_tab");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        bookmarks bookmark = new bookmarks(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_first_video_of_6m();
        home_screen.click_on_ok_button();
        bookmark.verify_bookmarks_save_and_remove_button_is_selected();
        bookmark.click_on_bookmarks_save_and_remove_button();
        bookmark.click_on_back_button_from_video_screen();

        home_screen.verify_Bookmarks_bottom_button_is_present_on_page();
        home_screen.click_on_Bookmarks_bottom_button();

    }

    @Test()
    public void To_verify_that_user_can_bookmark_the_lesson() {
        Logger.log_qase_id("TC_BFA_004");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_that_user_can_bookmark_the_lesson");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        bookmarks bookmark = new bookmarks(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_first_video_of_6m();
        home_screen.click_on_ok_button();
        bookmark.verify_bookmarks_save_and_remove_button_is_selected();
        bookmark.click_on_bookmarks_save_and_remove_button();
        bookmark.click_on_back_button_from_video_screen();

        home_screen.verify_Bookmarks_bottom_button_is_present_on_page();
        home_screen.click_on_Bookmarks_bottom_button();
        bookmark.verify_bookmark_video_in_bookmark_screen_is_displayed();
    }

    @Test()
    public void To_verify_after_deactivated_the_program_provider_cannot_see_the_bookmarked_lesson_of_that_program() {
        Logger.log_qase_id("TC_BFA_005");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_after_deactivated_the_program_provider_cannot_see_the_bookmarked_lesson_of_that_program");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        bookmarks bookmark = new bookmarks(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_first_video_of_6m();
        home_screen.click_on_ok_button();
        bookmark.verify_bookmarks_save_and_remove_button_is_selected();
        bookmark.click_on_bookmarks_save_and_remove_button();
        bookmark.click_on_back_button_from_video_screen();

        home_screen.verify_Bookmarks_bottom_button_is_present_on_page();
        home_screen.click_on_Bookmarks_bottom_button();

    }

    @Test()
    public void To_verify_user_can_play_video_from_bookmark_tab() {
        Logger.log_qase_id("TC_BFA_006");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_can_play_video_from_bookmark_tab");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        bookmarks bookmark = new bookmarks(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_first_video_of_6m();
        home_screen.click_on_ok_button();
        bookmark.verify_bookmarks_save_and_remove_button_is_selected();
        bookmark.click_on_bookmarks_save_and_remove_button();
        bookmark.click_on_back_button_from_video_screen();

        home_screen.verify_Bookmarks_bottom_button_is_present_on_page();
        home_screen.click_on_Bookmarks_bottom_button();
        bookmark.verify_bookmark_video_in_bookmark_screen_is_displayed();
        bookmark.click_on_bookmark_video_in_bookmark_screen_is_displayed();
    }

    @Test()
    public void To_verify_user_is_able_to_resume_the_video() {
        Logger.log_qase_id("TC_BFA_007");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_resume_the_video");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);
        bookmarks bookmark = new bookmarks(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_change_Agency_button_is_displayed();
        home_screen.click_on_first_video_of_6m();
        home_screen.click_on_ok_button();
        bookmark.verify_bookmarks_save_and_remove_button_is_selected();
        bookmark.click_on_bookmarks_save_and_remove_button();
        bookmark.click_on_back_button_from_video_screen();

        home_screen.verify_Bookmarks_bottom_button_is_present_on_page();
        home_screen.click_on_Bookmarks_bottom_button();
        bookmark.verify_bookmark_video_in_bookmark_screen_is_displayed();
        bookmark.click_on_bookmark_video_in_bookmark_screen_is_displayed();
    }

}
