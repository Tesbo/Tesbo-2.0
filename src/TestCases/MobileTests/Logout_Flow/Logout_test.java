package MobileTests.Logout_Flow;

import io.unity.core.init.base;
import io.unity.core.remotegrid.LambdaTestConfig;
import Screens.home_screen.home_screen;
import Screens.login.login_screen;
import Screens.profile_page.profile_page;
import Screens.logout_Screen.logout_page;
import org.testng.annotations.Test;
import utility.Logger;

import java.time.Duration;

public class Logout_test  extends base {

    @Test
    public void To_verify_user_is_able_to_logout_by_clicking_on_logout_button() {

        Logger.log_qase_id("NP-96");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_logout_by_clicking_on_logout_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        profile_page profile = new profile_page(driver);
        logout_page logout = new logout_page(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile.verify_language_tab_button_present_on_page();
        profile.verify_profile_help_button_is_present_on_page();
        profile.verify_logout_btn_is_present_on_page();
        logout.click_on_logout_btn();

        login_screen.verify_email_is_present_on_page();
    }

    @Test
    public void To_verify_user_is_able_to_logout_by_Taping_on_logout_button() {

        Logger.log_qase_id("TC_PR_037");
        LambdaTestConfig config = new LambdaTestConfig(driver);
        config.addTestName("To_verify_user_is_able_to_logout_by_Taping_on_logout_button");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        profile_page profile = new profile_page(driver);
        logout_page logout = new logout_page(driver);
        home_screen home_screen = new home_screen(driver);

        login_screen.performLoginOnMobileApp("mob@yopmail.com","QA_12345");

        home_screen.verify_profile_icon_is_present_on_page();
        home_screen.click_on_profile_icon();
        profile.verify_language_tab_button_present_on_page();
        profile.verify_profile_help_button_is_present_on_page();
        profile.verify_logout_btn_is_present_on_page();
        logout.click_on_logout_btn();

        login_screen.verify_email_is_present_on_page();
    }
}
