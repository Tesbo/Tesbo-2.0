package mobile.tests.login;

import io.unity.framework.init.base;
import mobile.object_repository.home_screen.home_screen;
import mobile.object_repository.login.login_screen;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTests extends base {

    @Test
    public void login_test() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login_screen login_screen = new login_screen(driver);
        home_screen home_screen = new home_screen(driver);


        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        login_screen.verify_email_is_present_on_page();
        login_screen.verify_password_is_present_on_page();
        login_screen.verify_login_button_is_present_on_page();

        login_screen.enter_text_at_email("viral@nevvon.com");
        login_screen.enter_text_at_password("Viral@1010");

        login_screen.click_on_login_button();


        home_screen.verify_home_bottom_button_is_present_on_page();
        home_screen.verify_search_bottom_button_is_present_on_page();
        home_screen.verify_Notification_bottom_button_is_present_on_page();
        home_screen.verify_Bookmarks_bottom_button_is_present_on_page();


    }





}
