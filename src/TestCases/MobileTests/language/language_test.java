package MobileTests.language;

import io.unity.core.init.base;
import io.unity.core.remotegrid.LambdaTestConfig;
import Screens.home_screen.home_screen;
import Screens.language_Screen.language_page;
import Screens.login.login_screen;
import Screens.profile_page.profile_page;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class language_test extends base {



    @Test
    public void To_verify_when_user_click_on_Language_option_the_language_pop_is_displayed() {

        Logger.log_qase_id("FA-323");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_click_on_Language_option_the_language_pop_is_displayed");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        profile_page profile = new profile_page(driver);
        language_page language = new language_page(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        language.verify_language_Option_is_present_on_page();
        language.click_on_language_Option();
        language.verify_save_button_is_present_on_page();
    }

    @Test
    public void To_verify_when_user_change_the_language_Language_updated_successfully_alert_is_displayed() {

        Logger.log_qase_id("FA-324");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_change_the_language_Language_updated_successfully_alert_is_displayed");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        language_page language = new language_page(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        language.verify_language_Option_is_present_on_page();
        language.click_on_language_Option();
        language.verify_save_button_is_present_on_page();
        language.click_on_save_button();
        language.verify_language_updated_successfully_alert_is_present_on_page();
    }

    @Test
    public void To_verify_when_user_tap_on_Language_option() {

        Logger.log_qase_id("TC_PR_038");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_tap_on_Language_option");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        language_page language = new language_page(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        language.verify_language_Option_is_present_on_page();
        language.click_on_language_Option();
        language.verify_save_button_is_present_on_page();
        language.click_on_save_button();

    }

    @Test
    public void To_verify_when_user_change_the_language() {

        Logger.log_qase_id("TC_PR_039");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_change_the_language");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        language_page language = new language_page(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        language.verify_language_Option_is_present_on_page();
        language.click_on_language_Option();
        language.verify_save_button_is_present_on_page();
        language.click_on_save_button();
        language.verify_language_updated_successfully_alert_is_present_on_page();
        language.click_ok_button_language_updated_successfully_alert_is_present_on_page();
        //language.verify_save_button_is_present_on_page();
    }

    @Test
    public void To_verify_when_user_tap_on_OK_button() {

        Logger.log_qase_id("TC_PR_040");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_when_user_tap_on_OK_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        language_page language = new language_page(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com", "QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        language.verify_language_Option_is_present_on_page();
        language.click_on_language_Option();
        language.verify_save_button_is_present_on_page();
        language.click_on_save_button();
        language.verify_language_updated_successfully_alert_is_present_on_page();
        language.click_ok_button_language_updated_successfully_alert_is_present_on_page();

    }



// Need to modify the test cases, As the locator are not available so not done
    @Test
    public void To_verify_user_can_change_language_using_language_option() {

        Logger.log_qase_id("NP-96");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_can_change_language_using_language_option");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        profile_page profile = new profile_page(driver);
        language_page language = new language_page(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
//        profile.verify_language_tab_is_present_on_page();
//        profile.verify_profile_help_button_is_present_on_page();
        language.verify_language_Option_is_present_on_page();
        language.click_on_language_Option();
        language.verify_language_preference_is_present_on_page();
        language.click_on_language_preference();
        language.verify_spanish_language_is_present_on_page();
        language.click_on_spanish_language();
        language.verify_language_preference_in_Spanish_is_present_on_page();
        language.click_on_language_preference_in_Spanish();
        language.verify_save_Button_Spanish_is_present_on_page();
        language.click_on_save_Button_Spanish();
        language.verify_language_Alert_Msg_Spanish_is_present_on_page();
        language.click_on_ok_button();
        language.verify_language_Option_In_Spanish_is_present_on_page();
        language.click_on_language_Option_In_Spanish();
        language.verify_language_preference_in_Spanish_is_present_on_page();
        language.click_on_language_preference_in_Spanish();
        language.verify_english_Option_is_present_on_page();
        language.click_on_english_Option();
        language.verify_save_button_is_present_on_page();
        language.click_on_save_button();
        language.verify_language_Alert_Msg_English_is_present_on_page();
        language.click_on_ok_button();

    }
}
