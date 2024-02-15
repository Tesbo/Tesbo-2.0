package Screens.change_session;

import Screens.login.login_screen;
import io.unity.core.init.Session;
import io.unity.performaction.autoweb.Wait;
import Screens.change_environment.change_environment;
import Screens.home_screen.home_screen;
import org.openqa.selenium.WebDriver;

public class change_session_class
{
    Session session = null;
    WebDriver driver = null;

    Screens.login.login_screen login_screen = null;
    home_screen home_screen = null;
    Wait wait = null;
    change_environment change_env = null;

    public change_session_class(){
        session = new Session();
        this.driver = session.create_new_mobile_session("nevvon_android");
        login_screen = new login_screen(driver);
        home_screen = new home_screen(driver);
        wait = new Wait(driver);
        change_env = new change_environment(driver);

    }
    public void mobile_session(String userEmailID, String userPassword) {
        //wait.wait_for_second(10);
        login_screen.verify_okey_button_popup_is_present_on_page();
        login_screen.click_on_okey_button_popup();

        change_env.change_prod_to_test_environment();

        login_screen.verify_email_is_present_on_page();
        login_screen.verify_password_is_present_on_page();
        login_screen.verify_login_button_is_present_on_page();

        login_screen.enter_text_at_email(userEmailID);
        login_screen.enter_text_at_password(userPassword);

        login_screen.click_on_login_button();

        home_screen.verify_assign_program_text_is_present_on_page();

        session.close_session(driver);
    }
}
